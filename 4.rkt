#lang racket
; https://projecteuler.net/problem=4
; A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

; Find the largest palindrome made from the product of two 3-digit numbers.

(define (exp a b)
    (define (iter product count)
      (if (= count b)
          product
          (iter (* a product) (+ count 1))))
  (if (= b 0)
      1
      (iter a 1)))

(define (palindrome? ab)
  (define (length ab)
    (define (iter n count)
      (if (= n 0)
          count
          (iter (floor (/ n 10)) (+ count 1))))
    (iter ab 0))
    (define (check-symmetry ab left right)
          (if (> left right)
              (if (= (floor (/ (modulo ab (exp 10 left)) (exp 10 (- left 1))))
                     (floor (/ (modulo ab (exp 10 right)) (exp 10 (- right 1)))))
                  (check-symmetry ab (- left 1) (+ right 1))
                  #f)
              #t))
        (check-symmetry ab (length ab) 1))

; a = min product = n^2
; b = max product = k^2
; n = min integer (i.e., 2-digits would be 10)
; k = max integer (i.e., 2-digits would be 99)
(define (largest-palindrome a b n k)
  (define (find-factor ab a b)
    (if (> a b)
        0
        (if (= (remainder ab b) 0)
            b
            (find-factor ab a (- b 1)))))
  (if (> a b)
      0
      (if (palindrome? b)
          (find-factor b n k)
          (largest-palindrome a (- b 1) n k))))
