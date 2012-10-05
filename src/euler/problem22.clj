(ns euler.problem22
  (:use [clojure.java.io]
        [clojure.string :only [split]]))

(defn get-names [url]
  (map #(clojure.string/replace % #"\"" "") 
       (split (slurp (as-url url)) #"," )))

(defn name-value [s]
  (reduce + (map #(- (int %) (int \@)) (into [] s))))

(defn solve []
  (let [names (get-names "http://projecteuler.net/project/names.txt")
        sorted-names (sort names)
        name-values (map name-value sorted-names)
        scores (map-indexed #(* (inc %1) %2) name-values)]
    (reduce + scores)))
