;https://www.hackerrank.com/challenges/new-year-chaos
(defun is-space(e)
  (equal e #\Space))

(defun process-str(size str) 
  (do ((index 1 (1+ index))
       (bribe-cnt 0)
       (pos0 0)
       pos1
       (current-nmbr nil)
       diff
       )
    ((> index size) bribe-cnt)

    (setf pos1 (position-if #'is-space str :start pos0))
    (setf current-nmbr (parse-integer (subseq str pos0 pos1)))
    (unless (null pos1) (setf pos0 (1+ pos1)))

    (setf diff (- current-nmbr index))
    (cond ((> diff 2) (return-from process-str "Too chaotic"))
          ((> diff 0) (incf bribe-cnt diff))
          )
    )
  )

      
(do ((tt (parse-integer "1"))
     (tt-index 0 (1+ tt-index))
     )
  ((equal tt-index tt))
  (format t "~&~A" (process-str  (parse-integer (read-line)) (read-line)))
  )

