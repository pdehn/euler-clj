(ns euler.problem28)

;; sub-optimal, still plenty fast
;; (don't feel like working out the equation)
(defn solve [len]
  (loop [total 1
         prev  1
         n     2
         i     1]
    (if (> i (quot len 2))
      total
      (recur (+ total (* 4 prev) (* 10 n))
             (+ prev (* 4 n))
             (+ 2 n)
             (inc i)))))
