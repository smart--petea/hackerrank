;https://www.hackerrank.com/challenges/new-year-chaos
(defun is-space(e)
  (equal e #\Space))

(defun process-str(size str) 
  (do ((index 1 (1+ index))
       (bribe-cnt 0)
       (pos0 0)
       pos1
       (current-nmbr nil)

       )
    ((> index size) bribe-cnt)

    (setf pos1 (position-if #'is-space str :start pos0))
    (setf current-nmbr (parse-integer (subseq str pos0 pos1)))
    (unless (null pos1) (setf pos0 (1+ pos1)))

    (if (AND (>= index 2) (> index current-nmbr) )
        (if (> (- index current-nmbr) 2)
          (return-from process-str "Too chaotic")
          (incf bribe-cnt (- index current-nmbr))
          )
        )
    )
  )

      
(do ((tt (parse-integer "1"))
     (tt-index 0 (1+ tt-index))
     )
  ((equal tt-index tt))
  (format t "~&~A" (process-str  (parse-integer "8") "1 2 5 3 7 8 6 4"))
  )

