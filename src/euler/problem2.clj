(ns euler.problem2
  (:use [euler.util]))


(defn solve
  []
  (sum (filter even? (for [n fibonacci :while (<= n 4000000)] n))))
