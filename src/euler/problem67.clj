(ns euler.problem67
  (:use [clojure.string :only [split]]))

(def rows
  (map #(map (fn [s] (Integer/parseInt s)) %)
       (map #(split % #"\s+,?\s*")
            (split (slurp "http://projecteuler.net/project/triangle.txt")
                   #"\r?\n"))))

(defn expand-best
  [maxes n v]
  (+ v (cond (= n 0)
             (first maxes)
             (= n (count maxes))
             (last maxes)
             :else
             (max (nth maxes n) (nth maxes (dec n))))))

(defn solve []
  (apply max
         (reduce #(map-indexed (partial expand-best %1) %2)
                 rows)))
