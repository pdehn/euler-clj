(ns euler.problem26
  (:use [euler.util]))

(defn sieve
  [[p & rst]]
  ;; make sure the stack size is sufficiently large!
  (lazy-seq (cons p (sieve (remove #(= 0 (mod % p)) rst)))))

(def primes (sieve (iterate inc 2)))

(defn e10 [x]
  (reduce *' (repeat x 10)))

;; horribly sub-optimal, takes up to minutes
(defn c [n]
  (some identity
        (for [lpow (iterate inc 1)
              mpow (range (dec lpow) 0 -1)]
          (if (= 0 (mod (- (e10 lpow) (e10 mpow)) n))
            (- lpow mpow)
            nil))))

(defn solve []
  (some (λ [p c] -> when (= p (inc c)) p)
         (map (λ x -> [x (c x)])
              (reverse (take-while (partial > 1000) primes)))))
