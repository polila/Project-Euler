#lang racket
; https://projecteuler.net/problem=5

; 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
; What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

; find max 2^n and max 3^m and primes < range

(define (prime? ab)
  (cond ((or (= ab 2) (= ab 3) (= ab 5) (= ab 7)) #t)
        ((or (= (modulo ab 2) 0) (= (modulo ab 3) 0) (= (modulo ab 5) 0) (= (modulo ab 7) 0)) #f)
        (else 0)))
        
(define (smallest-multiple n)
  (define (pow a product)
    (if (> (* product a) n)
        product
        (pow a (* product a))))
  (define (prime-iter count product)
    (if (or (< count n) (= count n))
        (if (prime? count)
            (prime-iter (+ count 1) (* product count))
            (prime-iter (+ count 1) product))
        product))
  (* (pow 2 1) (pow 3 1) (prime-iter 5 1))) 
