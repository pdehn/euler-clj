(ns euler.problem23
  (:use [euler.util]))

(defn abundant?
  [n]
  (< n (sum (divisors n))))

(def anums (filter abundant? (range 1 28123)))
(def nset (into #{} anums))

(defn sumable [x]
  (loop [[n & ns] anums]
    (cond (or (not n)
              (>= n x))
          false
          (contains? nset (- x n))
          true
          :else
          (recur ns))))

(defn solve []
  (sum (filter (complement sumable) (range 1 28123))))
