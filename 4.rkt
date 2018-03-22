#lang racket
; https://projecteuler.net/problem=4
; A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
; Find the largest palindrome made from the product of two 3-digit numbers.
; Answer = 906,609 (Completed in Java)
; Could not solve runtime issue with memory when .rkt file is executed
; posted question on StackOverflow: https://stackoverflow.com/questions/49376592/calculating-n-digit-palindromes-infinite-loop

(define (exp a b)
    (define (iter product count)
      (if (= count b)
          product
          (iter (* a product) (+ count 1))))
  (if (= b 0)
      1
      (iter a 1)))
(define (palindrome? ab)
  #;(define (length ab)
    (define (iter n count)
      (if (= n 0)
          count
          (iter (floor (/ n 10)) (+ count 1))))
    (iter ab 0))
    #;(define (check-symmetry ab left right)
          (if (> left right)
              (if (= (floor (/ (modulo ab (exp 10 left)) (exp 10 (- left 1))))
                     (floor (/ (modulo ab (exp 10 right)) (exp 10 (- right 1)))))
                  (check-symmetry ab (- left 1) (+ right 1))
                  #f)
              #t))
        ;(check-symmetry ab)
  (define (reverse n sum) ; suggested solution translated to .rkt after using Java to solve problem inititally
    (if (= n 0)
        sum
        (reverse (floor (/ n 10)) (+ (* sum 10) (floor (modulo n 10))))))
  (= ab (reverse ab 0)))

#;(define (largest-palindrome a b max)
 (if (> b 100)
     (if (and (palindrome? (* a b)) (< max (* a b)))
         (largest-palindrome a (- b 1) (* a b))
         (largest-palindrome a (- b 1) max))
     (largest-palindrome (- a 1) (- a 1) (* a b)))
  (if (< a 100)
      max
      0))
(define (largest-palindrome min-int max-int) ; suggested solution translated to .rkt after using Java to solve problem inititally
 (define (i-iter a i-max)
   (define (j-iter b j-max)
     (if (> b (- min-int 1) )
         (if (and (palindrome? (* a b)) (> (* a b) j-max))
             (j-iter (- b 1) (* a b))
             (j-iter (- b 1) j-max))
         j-max))
   (if (> a (- min-int 1))
       (if (> (j-iter a i-max) i-max)
           (i-iter (- a 1) (j-iter a i-max))
           (i-iter (- a 1) i-max))
       i-max))
 (i-iter max-int 0)) 
