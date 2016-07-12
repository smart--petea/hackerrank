;https://www.hackerrank.com/challenges/diagonal-difference

(defun get-number(psition str)
  (do* ((pos1 0 (1+ pos2))
        (pos2 (position-if #'(lambda(e) (equal e #\SPACE)) str :start pos1)
              (position-if #'(lambda(e) (equal e #\SPACE)) str :start pos1)
              )
       (stp 0 (1+ stp))
       )
       ((equal psition stp) (parse-integer (subseq str pos1 pos2)))
       )
  )

(setf n (parse-integer (read-line)))

(do*
  ((str (read-line) (read-line))
   (i 0 (1+ i))
   (direct-diagonal (get-number i str) (+ (get-number i str) direct-diagonal))
   (reverse-diagonal (get-number (- n i 1) str) (+ (get-number (- n i 1) str) reverse-diagonal))
   )
  ((equal (1- n) i) (write (abs (- direct-diagonal reverse-diagonal))))
  )

