(ns euler.problem48
  (:use [euler.util]))

(defn solve []
  (let [base 10000000000]
    ((modular sum base)
     (map (λ x -> modular-exp x x base)
          (range 1 1001)))))
