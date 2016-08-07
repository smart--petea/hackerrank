;https://www.hackerrank.com/challenges/absolute-permutation
(defun is-space(e) 
  (equal e #\Space)
  )

(defun get-upper-element(index n k)
  (if (>= n (+ index k)) (+ index k) 0)
  )

(defun get-lower-element(index n k)
  (if (< 0 (- index k)) (- index k) 0)
  )

(defun process-str(str) 
  (do* ((n (parse-integer (subseq str 0 (position-if #'is-space str))))
         (k (parse-integer (subseq str (position-if #'is-space str :from-end t))))
         (vec (make-array n))
         (vec-flag (make-array n :initial-element 1))
         (index 0 (1+ index))
         temp
         )
    ((equal index n) vec)
    (setf temp (get-lower-element (1+ index) n k))
    (when (OR (zerop temp) (zerop (svref vec-flag (1- temp))))
      (setf temp (get-upper-element (1+ index) n k))
      (if (OR (zerop temp) (zerop (svref vec-flag (1- temp)))) (return-from process-str -1)))

    (setf (svref vec index) temp)
    (setf (svref vec-flag (1- temp)) 0)
    )
  )

(do* ((test-counts (parse-integer "1"))
      (test-index 0 (1+ test-index))
      vec
      )
  ((equal test-index test-counts))
  (format t "~&")

  (setf vec (process-str (read-line)))
  (if (vectorp vec)
    (do ((vec-index 0 (1+ vec-index))
         (vec-dim (car (array-dimensions vec)))
         )
      ((equal vec-index vec-dim))
      (format t "~A " (svref vec vec-index))
      )
    (format t "-1")
    )
  )

