;https://www.hackerrank.com/challenges/save-the-prisoner

(defun equal-space(e)
  (equal #\Space e)
  )

(defun parse-line(line)
  (let (
        (pos0 0)
        pos1
        n
        m
        s
        )
    (setf pos1 (position-if #'equal-space line :start pos0))
    (setf n (parse-integer (subseq line pos0 pos1)))

    (setf pos0 (1+ pos1))
    (setf pos1 (position-if #'equal-space line :start pos0))
    (setf m (parse-integer (subseq line pos0 pos1)))

    (setf s (parse-integer (subseq line pos1)))

    (list n m s)
    )
  )

(defun test-case()
  (destructuring-bind (n m s) (parse-line (read-line))
    (let ((rez (mod (+ m (1- s)) n)))
      (if (zerop rez) n rez)
      )
    )
  )


(let ((tt (parse-integer (read-line))))
  (dotimes (i tt)
    (format t "~A" (test-case))
    )
  )
