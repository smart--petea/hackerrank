;https://www.hackerrank.com/challenges/plus-minus

(setf size (parse-integer (read-line)))
(setf str (read-line))

(defun print-ratios (pst-count ngt-count zero-count sz)
  (let ((sz0 (* sz 1.0)))
   (format t "~&~,6f" (/ pst-count sz0))
   (format t "~&~,6f" (/ ngt-count sz0)) 
   (format t "~&~,6f" (/ zero-count sz0))
   )
  )

(defun space-equal(e)
  (equal #\Space e)
  )

(defun next-position(strr start)
  (position-if #'space-equal strr :start start)
  )

(if (zerop size)
  (print-ratios 0 0 0 1)
  (do* (
        (index 1 (1+ index))
        (pos0 0 (1+ pos1))
        (pos1 (next-position str 0) (next-position str pos0))
        (nmbr (parse-integer (subseq str pos0 pos1)) (parse-integer (subseq str pos0 pos1)))
        (positive-count (if (> nmbr 0) 1 0) (if (> nmbr 0) (1+ positive-count) positive-count))
        (negative-count (if (< nmbr 0) 1 0) (if (< nmbr 0) (1+ negative-count) negative-count))
        (zero-count (if (zerop nmbr) 1 0)  (if (< nmbr 0) (1+ zero-count) zero-count))
        )
    ((OR (equal index size) (null pos1)) (print-ratios positive-count negative-count zero-count size))
    )
  )




