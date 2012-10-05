(ns euler.problem16
  (:use [euler.util]))

;; 2 ^ 1000
(def n (reduce *' (repeat 1000 2)))

(defn solve []
  (reduce +' (num->digits n)))
