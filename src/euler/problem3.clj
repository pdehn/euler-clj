(ns euler.problem3
   (:use [euler.util]))


(defn solve
  []
  (filter prime? (divisors 600851475143)))
