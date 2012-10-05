(ns euler.util)

(defn num->digits
  [num]
  (map #(- (int %) (int \0)) (into [] num)))
