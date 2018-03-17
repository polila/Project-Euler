#lang racket
; https://projecteuler.net/problem=3
; The prime factors of 13195 are 5, 7, 13 and 29.
; What is the largest prime factor of the number 600851475143 ?

; Testing for Primality
; reference: https://mitpress.mit.edu/sicp/chapter1/node17.html
; if 'n' is not prime it must have a divisor less than or equal
; to the square root of 'n'
(define (prime? n)
  (define (is-prime k a)
    (cond ((> (* k k) a) #t)
          ((= (remainder a k) 0) (= a k))
          (else (is-prime (+ k 1) a))))
  (is-prime 2 n))
(define (largest-prime-factor n)
	; linear iterative process
	; (2, 	n)
	; (p-a, n/p-a)
	; (p-b, n/(p-a*p-b))
	;	.	.
	;	.	.
	;	.	.
	; (p-n-1, n/(p-a*p-b...p-n-1))
	; (n/(p-a*p-b...p-n-1), n/(p-a*p-b...p-n-1))
	; (n/(p-a*p-b...p-n-1), 1)
  (define (prime-iter p n)
  	; when the number 'n' becomes prime,
  	; the largest prime factor is found since
  	; finding each prime factor 'p' was from ascending order
  	; and p <= n
    (cond ((prime? n) n)
          ((and (prime? p) (= (modulo n p) 0)) (prime-iter p (/ n p)))
          (else (prime-iter (+ p 1) n))))
  (prime-iter 2 n))
