;https::/www.hackerrank.com/challenges/cut-the-sticks
(defun is-space(e)
  (equal e #\Space)
  )

(defun str-to-vec(str size)
  (do* ((vec (make-array size))
        (pos0 0)
        (index 0 (1+ index))
        pos1
        )
    ((equal index size) vec)
    (setf pos1 (position-if #'is-space str :start pos0))
    (setf (svref vec index) (parse-integer (subseq str pos0 pos1)))
    (unless (null pos1) (setf pos0 (1+ pos1)))
    )
  )

(defun non-null-length-min(vec size)
  (do* ((index 0 (1+ index))
        (cnt 0)
        el
        (mmin (svref vec 0))
        )
    ((equal index size) (values cnt mmin))
    (setf el (svref vec index))
    (unless (zerop el) (incf cnt))
    (when (AND (not (zerop el)) (> mmin el)) (setf mmin el))
    )
  )

(defun process-vec(vec size)
  (multiple-value-bind (non-null-cnt mmin) (non-null-length-min vec size)
    (if (zerop non-null-cnt)
      (format t "~&~A" 0)
      (do* (
            new-val
            new-min
            )
        ((zerop non-null-cnt))

        (format t "~&~A" non-null-cnt)

        (setf non-null-cnt 0)
        (setf new-min nil)

        (do* ((index 0 (1+ index)))
          ((equal index size))
          (unless (zerop (svref vec index))
            (setf new-val (decf (svref vec index) mmin))
            (unless (zerop new-val)
              (if (OR (null new-min) (> new-min new-val)) (setf new-min new-val))
              (incf non-null-cnt)
              )
            )
          )
        (setf mmin new-min)
        )
      )
    )
  )

(let* ((N 6)
      (str "5 4 4 2 2 8")
      (vec (str-to-vec str N))
      )
  (process-vec vec N)
  )

