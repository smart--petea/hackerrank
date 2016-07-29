;https://www.hackerrank.com/challenges/lisa-workbook
(defun is-space(e)
  (equal e #\Space)
  )

(defun parse-first-line(line)
  (let* ((pos (position-if #'is-space line))
         (frst (parse-integer (subseq line 0 pos)))
         (lst  (parse-integer (subseq line (1+ pos))))
         )
    (values frst lst)
    )
  )

(multiple-value-bind (page-cnt per-page-cnt) (parse-first-line "5 3")
  (print page-cnt)
  (print per-page-cnt)
  (do* ((page-cnt-str "4 2 6 1 10")
        (index 0 (1+ index))
        (pos0 0)
        pos1
        curr-page-cnt
        )
    ((equal index page-cnt))

    (setf curr-page-cnt (parse-integer (subseq page-cnt-str pos0 pos1)))
  )
