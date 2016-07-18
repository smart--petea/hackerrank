;https://www.hackerrank.com/challenges/time-conversion
(defun get-type(str)
  (subseq str 8 9)
  )

(defun get-hour(time-str)
  (parse-integer (subseq time-str 0 2))
  )

(let* (
      (time-str  (read-line)) ;"07:05:45PM");
      (type-str (get-type time-str))
      )
  (if (equal type-str "P")
    (let ((hour (get-hour time-str)))
      (setf hour (if (equal hour 12) 0 (+ 12 hour)))
      (format t "~2,'0d" hour)
      (format t "~A" (subseq time-str 2 8))
      )
    (format t "~A" (subseq time-str 0 8))
    )
  )



;(format t "~A" (get-type "07:05:45PM"))
