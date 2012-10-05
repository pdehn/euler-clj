(ns euler.problem21
  (:use clojure.set))

(defn divisors
  [n]
  (filter #(= 0 (mod n %)) (range 1 (inc (quot n 2)))))

(defn d
  [n]
  (reduce + (divisors n)))

(defn amicable-pairs
  [a]
  (let [b  (d a)
        a' (d b)]
    (if (and (= a' a)
             (not= a b))
      #{a b}
      #{})))

(defn solve
  []
  (reduce + (into []
                  (apply union (map amicable-pairs (range 1 10001))))))