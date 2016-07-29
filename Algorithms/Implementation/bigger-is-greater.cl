;https://www.hackerrank.com/challenges/bigger-is-greater
(defun get-min-max(word pivot-index word-len)
  (when (equal pivot-index (- word-len 2)) (return-from get-min-max (1+ pivot-index)))
  (do* ((index (1+ pivot-index) (1+ index))
        )
    ((equal index word-len) (1- index))
    (when (char> (char word pivot-index) (char word index)) (return-from get-min-max (1- index)))
    )
  )


(defun process-word(word)
  (let* ((word-len (length word))
        (pivot-index (- word-len 2))
        )
    (do* ()
      ((< pivot-index 0))
      (when (char< (char word pivot-index) (char word (1+ pivot-index)))
        (return)
        )
      (decf pivot-index)
      )
    (when (> 0 pivot-index) (return-from process-word "no answer"))

    (let ((m (char word pivot-index))
          (max-index (get-min-max word pivot-index word-len))
          )
      (print pivot-index)
      (print max-index)
      (setf (char word pivot-index) (char word max-index))
      (setf (char word max-index) m)
      )

    (concatenate 'string (subseq word 0 (1+ pivot-index)) (reverse (subseq word (1+ pivot-index))))
    )
  )


(do* ((n (parse-integer "1"))
      (index 0 (1+ index))
      )
  ((equal index n))
  (format t "~&~A" (process-word (read-line)))
  )
