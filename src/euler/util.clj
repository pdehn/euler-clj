(ns euler.util)

(defn sum
  [nums]
  (reduce + nums))

(defn fact
  [n]
  (reduce *' (range 1 (inc n))))

(defn num->digits
  [num]
  (map #(- (int %) (int \0)) (into [] num)))
