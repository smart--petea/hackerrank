;https://www.hackerrank.com/challenges/equal-stacks
(defun is-space(e)
  (equal e #\Space)
  )

(defun read-stack(size str)
  (do* ((lst '(0))
        pos0
        (pos1 nil)
        (index 0 (1+ index))
        nmbr
        (sum 0)
        )
    ((equal index size) lst)
    (setf pos0 (position-if #'is-space str :end pos1 :from-end t))
    (if (null pos0) (setf pos0 0))
    (setf nmbr (parse-integer (subseq str pos0 pos1)))
    (setf lst (cons (incf sum nmbr) lst))
    (setf pos1  pos0)
    )
  )

(defun parse-3-str(str)
  (let (n1 n2 n3 (pos0 0) pos1)
    (setf pos1 (position-if #'is-space str))
    (setf n1 (parse-integer (subseq str pos0 pos1)))

    (setf pos0 (1+ pos1))
    (setf pos1 (position-if #'is-space str :start pos0))
    (setf n2 (parse-integer (subseq str pos0 pos1)))

    (setf n3 (parse-integer (subseq str (1+ pos1))))
    (list n1 n2 n3)
    )
  )

(destructuring-bind (n1 n2 n3) (parse-3-str "5 3 4");(read-line))
  (let* ((stck1 (read-stack n1 "3 2 1 1 1"));(read-line)))
        (stck2 (read-stack n2 "4 3 2"));(read-line)))
        (stck3 (read-stack n3 "1 1 4 1"));(read-line)))
        (height (car (reduce #'intersection (list stck1 stck2 stck3))))
        )
    (format t "~A" height)
    )
  )

