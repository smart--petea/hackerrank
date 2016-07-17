(defun print-smbl(smbl size)
  (do ((inner-index 1 (1+ inner-index)))
    ((> inner-index size))
    (format t "~A" smbl)
    )
  )

(do (
     (n (parse-integer (read-line)))
     (outer-index 1 (1+ outer-index))
     )
  ((> outer-index n))
  (format t "~&")
  ;print spaces
  (print-smbl #\Space (- n outer-index))
  ;print #
  (print-smbl "#" outer-index)
  )
