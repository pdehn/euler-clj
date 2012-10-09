(ns euler.problem24
  (:use [euler.util]))

(defn remove-nth [coll n]
  (concat (take n coll)
          (drop (inc n) coll)))

(defn nth-permutation [vals n]
  "Returns nth permutation of vals, assuming
   ordering based on current order of vals."
  (loop [n n vals vals acc []]
    (let [v (count vals)
          p (! v)]
      (cond ;; not enough permutations available
            (> n p) nil
            ;; no permutations required
            (= n 0) (concat acc vals)
            ;; exactly enough permutations required
            (= n p) (concat acc (reverse vals))
            :else
            (let [;; whole # of permutations available for #vals - 1
                  k  (quot n (! (dec v)))
                  ;; # of permutations remaining
                  n' (- n (* k (! (dec v))))]
              (recur n'
                     (remove-nth vals k)
                     (conj acc (nth vals k))))))))

(defn solve []
  (nth-permutation (range 0 10) 999999))
