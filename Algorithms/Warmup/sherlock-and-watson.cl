(defun is-space(e)
  (equal e #\Space)
  )
(defun parse-first-line(line)
  (let (
        n
        k
        q
        (pos0 0)
        pos1
        )
    (setf pos1 (position-if #'is-space line))
    (setf n (parse-integer (subseq line pos0 pos1)))

    (setf pos0 (1+ pos1))
    (setf pos1 (position-if #'is-space line :start pos0))
    (setf k (parse-integer (subseq line pos0 pos1)))

    (setf pos0 (1+ pos1))
    (setf q (parse-integer (subseq line pos1)))

    (values n k q)
    )
  )

(defun parse-array(line size)
  (do (
       (rez (make-array size))
       (index 0 (1+ index))
       (pos0 0 (1+ pos1))
       pos1
       )
    ((= index size) rez)

    (setf pos1 (position-if #'is-space line :start pos0))
    (setf (svref rez index) (parse-integer (subseq line pos0 pos1)))
    (when (null pos1) (return-from parse-array rez))
    )
  )

(print (parse-array "3 3 4 5 6" 5))


;(let* 
;      ((first-line "3 2 3")
;       (second-line "1 2 3")
;       (query 0)
;       arr
;       )
;      (multiple-value-bind (n k q) (parse-first-line first-line)
;        (print n)
;        (print k)
;        (print q)
;        (setf arr (parse-array second-line n))
;        (print arr)
;        )
;      )
