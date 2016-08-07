;https://www.hackerrank.com/challenges/new-year-chaos
(defun is-space(e)
  (equal e #\Space))

(defun process-str(size str) 
  (do ((index 0 (1+ index))
       (arr (make-array size))
       (pos0 0)
       pos1
       (current-nmbr nil)
       )
    ((= index size) arr)

    (setf pos1 (position-if #'is-space str :start pos0))
    (setf (svref arr index) (parse-integer (subseq str pos0 pos1)))
    (unless (null pos1) (setf pos0 (1+ pos1)))
    )
  )

(defun process(size arr-str) 
  (do* ((arr (process-str size arr-str))
        (index (1- size) (1- index))
        (bribe-cnt 0)
        )
    ((> 0 index) bribe-cnt)
    ;(format t "~&~A ~A ~A" index (svref arr index) (- (svref arr index) (1+ index)))
    (when (> (- (svref arr index) (1+ index)) 2) (return-from process "Too chaos"))
    (do* ((tmp (svref arr index))
          (j (max (- tmp 2) 0) (1+ j))
          )
      ((>= j index))
      (when (> (svref arr j) tmp) (incf bribe-cnt))
      )
    )
  )

      
(do ((tt (parse-integer "1"))
     (tt-index 0 (1+ tt-index))
     )
  ((equal tt-index tt))
  (format t "~&~A" (process  (parse-integer (read-line)) (read-line)))
  )

