#lang racket

; https://projecteuler.net/problem=1

; If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
; The sum of these multiples is 23.
; Find the sum of all the multiples of 3 or 5 below 1000.

(define (max x a)
  (if (even? x)
      (- (/ a x) 1)
      (floor (/ a x))))

(define (sum-sequence n) (/ (* n (+ n 1)) 2))

(define (sum-multiples a b c)
  (- (+ (* a (/ (* (max a c) (+ (max a c) 1)) 2))
        (* b (/ (* (max b c) (+ (max b c) 1)) 2)))
     (* (* a b) (/ (* (max (* a b) c) (+ (max (* a b) c) 1)) 2))))
