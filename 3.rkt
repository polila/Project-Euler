#lang racket
; https://projecteuler.net/problem=3
; The prime factors of 13195 are 5, 7, 13 and 29.
; What is the largest prime factor of the number 600851475143 ?

(define (largest-prime-factor n)
  (define (prime-iter p n)
    (cond ((prime? n) n)
          ((and (prime? p) (= (modulo n p) 0)) (prime-iter p (/ n p)))
          (else (prime-iter (+ p 1) n))))
  (prime-iter 2 n))
