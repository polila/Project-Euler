(define (square x) (* x x))

(define (sum-square-difference n)
  (define (sum-iter count sum)
    (if (= count 0)
    	; ((n * (n + 1)) / 2)^2 - (1^2 + 2^2 + ... + n^2)
        (- (square (/ (* n (+ n 1)) 2)) sum)
        (sum-iter (- count 1) (+ sum (square count)))))
  (sum-iter n 0))
