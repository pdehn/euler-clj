(ns euler.problem25
  (:use [euler.util]))

;; minimum value (1000 digits)
(def mn (reduce *' (repeat 999 10)))

(def fibs
  ((fn f [a b] (lazy-seq (cons a (f b (+' a b))))) 1 1))

(defn solve []
  (inc (ffirst (drop-while (λ [i x] -> < x mn)
                           (map-indexed (λ i x -> [i x]) fibs)))))
