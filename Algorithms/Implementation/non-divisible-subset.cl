;https://www.hackerrank.com/challenges/non-divisible-subset
(defun is-space(e)
  (equal e #\Space)
  )

(defun parse-first-line(str)
  (let* (
        (pos (position-if #'is-space str))
        (n (parse-integer (subseq str 0 pos)))
        (k (parse-integer (subseq str (1+ pos))))
        )
    (values n k)
    )
  )

(multiple-value-bind (n k) (parse-first-line "10 4")
  (let* ( (k-len-vec (make-array k :initial-element 0)))
    (do* ( (index 0 (1+ index))
          (pos0 0)
          pos1
          (str "1 2 3 4 5 6 7 8 9 10")
          )
      ((equal index n))
      (setf pos1 (position-if #'is-space str :start pos0))
      (incf (svref k-len-vec (mod (parse-integer (subseq str pos0 pos1)) k)))
      (unless (null pos1) (setf pos0 (1+ pos1)))
    )
    (print k-len-vec)
    (multiple-value-bind (div remm) (floor k 2)
      (incf div)
      (print div)
      (do* ((index 1 (1+ index))
            (sum (if (zerop (svref k-len-vec 0)) 0 1))
            friend-index
            )
        ((equal index div) (format t "~&~A" sum))
        (setf friend-index (- k index))
        (cond ((equal index friend-index) (incf sum))
              ((> (svref k-len-vec index) (svref k-len-vec friend-index)) (incf sum (svref k-len-vec index)))
              (t (incf sum (svref k-len-vec friend-index)))
              )
        )
      )
    )
  )
