(ns euler.problem23
  (:use [euler.util]))

(defn abundant?
  [n]
  (< n (sum (divisors n))))

(def anums (filter abundant? (range 1 28123)))

(defn solve
  []
  nil)
