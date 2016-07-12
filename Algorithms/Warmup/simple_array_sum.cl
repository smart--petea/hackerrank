;Given an array of N integers, can you find the sum of its elements?

;Input Format

;The first line contains an integer, N, denoting the size of the array.
;The second line contains N space-separated integers representing the array's elements

;Output Format

;Print the sum of the array's elements as a single integer

;Sample input
;6
;1 2 3 4 10 11

;Sample output
;31

(setf size (read-line))
(setf arr (read-line))

(defun sum-arr(arr size)
  (do*
    ((pos1 0 (1+ pos2))
     (pos2 (position-if #'(lambda(e)(equal #\Space e)) arr :start pos1) 
           (position-if #'(lambda(e)(equal #\Space e)) arr :start pos1) 
           )
     (cnt 1 (1+ cnt))
     (nmbr nil)
     (rez 0)
     )
    ((equal cnt size) rez)
    (if (null pos2)
        (setf nmbr (parse-integer (subseq arr pos1)))
        (setf nmbr (parse-integer (subseq arr pos1 pos2)))
        )
    (when (null pos2) (return (+ nmbr rez)))
    (setf rez (+ nmbr rez))
    )
  )

(write (sum-arr arr size))


