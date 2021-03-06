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

(multiple-value-bind (page-cnt per-page-cnt) (parse-first-line "15 20")
  (do* ((page-cnt-str "1 8 19 15 2 29 3 2 25 2 19 26 17 33 22")
        (index 0 (1+ index))
        (pos0 0)
        pos1
        curr-page-cnt
        (special-problem-cnt 0)
        (page-start 0)
        (page-end 0)
        )
    ((equal index page-cnt) (format t "~&~A" special-problem-cnt))

    (setf pos1 (position-if #'is-space page-cnt-str :start pos0))
    (setf curr-page-cnt (parse-integer (subseq page-cnt-str pos0 pos1)))
    (unless (null pos1) (setf pos0 (1+ pos1)))

    (setf page-start (1+ page-end))
    (multiple-value-bind (page-end-x) (ceiling curr-page-cnt per-page-cnt)
      (setf page-end (+ page-start (1- page-end-x)))
      )
    (format t "~&[~A ~A] curr-page-cnt=~A" page-start page-end curr-page-cnt)
    (do* ((i page-start (1+ i))
          (out-cnt (min curr-page-cnt page-end))
          )
      ((> i out-cnt))
        ;(format t "~&[~A ~A] cnt=~A out-cnt=~A" page-start page-end curr-page-cnt out-cnt)
      (multiple-value-bind (relative-page remainder) (floor i per-page-cnt)
        (when (zerop remainder) (decf relative-page))
        ;(format t "~&page=~A index=~A ~A" (+ relative-page page-start) i (equal i (+ relative-page page-start)))
        (when (equal (+ relative-page page-start) i) (incf special-problem-cnt))
        )
      )
    )
  )

