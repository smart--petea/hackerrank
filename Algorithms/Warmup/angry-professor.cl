;https://www.hackerrank.com/challenges/angry-professor
(defun is-space(e)
  (equal e #\Space)
  )

(defun parse-nk(lst)
  (let* (
         (pos (position-if #'is-space lst))
         (n (parse-integer (subseq lst 0 pos)))
         (k (parse-integer (subseq lst (1+ pos))))
         )
    (values n k)
    )
  )

(defun process-case()
  (let (
        (nk "4 3")
        (times "-1 -1 2 1")
        )
    (multiple-value-bind (N K) (parse-nk nk)
      (do* (
            (k-index 0)
            (n-index 0 (1+ n-index))
            (pos0 0)
            pos1 
            nmbr
            )
        ((equal n-index N) 'YES)

        (setf pos1 (position-if #'is-space times :start pos0))
        (setf nmbr (parse-integer (subseq times pos0 pos1)))
        (when (<= nmbr 0) (incf k-index))
        (when (equal k-index K) (return-from process-case 'NO))
        (when (null pos1) (return-from process-case 'NO))

        (setf pos0 (1+ pos1))
      )
    )
  )
  )


(do ((tt 1 (1- tt)))
    ((zerop tt))
    (format t "~A" (process-case))
    )
