#lang racket

; https://projecteuler.net/problem=1

; If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
; The sum of these multiples is 23.
; Find the sum of all the multiples of 3 or 5 below 1000.

(define (max x a)
  (if (even? x)
  ; subtract 1 to exclude limit, hence 1000
      (- (/ a x) 1)
      ; rounds down floating point result to integer
      (floor (/ a x))))
; S = 1 + 2 + 3 + ... + (n-1) + n
; S = n + (n-1) + ... + 2 + 1
; 2S = (n+1) + (n+1) + ... (n+1) + (n+1)
; 2S = (n+1)*(1 + 1 + ... + 1 + 1)
; S = (n+1)*(n)/2
(define (sum-sequence n) (/ (* n (+ n 1)) 2))
; the sum of all multiples 'a' or 'b' below 'c'
; is equal to the sum of all multiples
; 'a' or 'b' minus 'a' and 'b'(least common multiple), hence the union
; of the integer multiples in the set 'a' or 'b' below 'c'
; minus the intersection of the set 'a' and 'b' below 'c'
; a(Z) = 1*3, 2*3,..., 1000/3 = 3*(1, 2,..., 333)
; b(Z) = 1*5, 2*5,..., 1000/5-1 = 5*(1, 2,..., 199)
; (a N b)(Z) = 1*3*5, 2*3*5,..., 1000/(3*5) = 15*(1, 2,..., 66)
; (a U b) - (a N b) = a(Z) + b(Z) - (a N b)(Z)
(define (sum-multiples a b c)
  (- (+ (* a (/ (* (max a c) (+ (max a c) 1)) 2))
        (* b (/ (* (max b c) (+ (max b c) 1)) 2)))
     (* (* a b) (/ (* (max (* a b) c) (+ (max (* a b) c) 1)) 2))))
