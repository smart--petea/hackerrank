;https://www.hackerrank.com/challenges/jumping-on-the-clouds

(defun is-space(e)
  (equal e #\Space)
  )

(do* ((n (parse-integer "6"))
      ;(clouds "0 0 1 0 0 1 0")
      (clouds "0 0 0 1 0 0")
      (index 1 (1+ index))
      (pos0 (1+ (position-if #'is-space clouds :start 0)))
      pos1
      nmbr
      (cnt 0)
      (temp 0)
      )
  ((equal index n) (format t "~&~A" cnt))

  (setf pos1 (position-if #'is-space clouds :start pos0))
  (setf nmbr (parse-integer (subseq clouds pos0 pos1)))
  (unless (null pos1) (setf pos0 (1+ pos1)))

  (format t "~&~A ~A" index temp)
  (cond
    ((zerop nmbr) (cond ((zerop temp) (setf temp 1))
                        (t (setf temp 0) (incf cnt))))
    (t (cond ((zerop temp) (setf temp 1))
             (t (incf cnt))
             )
       )
    )
  (format t " ~A" temp)
  )
