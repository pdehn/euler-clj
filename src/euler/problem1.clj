(ns euler.problem1
  (:use [euler.util]
        [clojure.set]))

(defn take-lt-1000 [s] (filter #(> 1000 %) (take 1000 s)))

(def threes (take-lt-1000 (multiples 3)))
(def fives (take-lt-1000 (multiples 5)))

(defn solve []
  (sum (union (set threes) (set fives)))) 
