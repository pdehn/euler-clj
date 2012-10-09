(ns euler.util
  (:use [clojure.string :only [split]]))

(defmacro λ
  "turns this:
      (λ a b -> * a b)
  into this:
      (fn [a b] (* a b))
  also handles definitions like this:
      (λ _ -> 42)
  Can your #(...) do that? (possibly)"
  [& stuff]
  (let [[params [_ & body]] (split-with #(not= '-> %) stuff)]
    (if (= 1 (count body))
      `(fn [~@params] ~@body)
      `(fn [~@params] (~@body)))))

(defn rows
  ":: String -> [[Integer]]
  handles comma/space delimited and \r on newlines"
  [x]
  (map #(map (fn [s] (Integer/parseInt s)) %)
       (map #(split % #"\s+,?\s*")
            (split x #"\r?\n"))))

(defn sum
  ":: Number a => [a] -> a"
  [nums]
  (reduce + nums))

(defn product
  [nums]
  (reduce * nums))

(def Σ sum)
(def Π product)
(def ಠ_ಠ 'ಠ_ಠ)

(defn !
  [n]
  (reduce *' (range 1 (inc n))))

(defn num->digits
  ":: Number a => a -> [Integer]"
  [num]
  (map #(- (int %) (int \0)) (into [] num)))

(defn divisors
  ":: Number a => a -> [a]"
  [n]
  (filter #(= 0 (mod n %)) (range 1 (inc (quot n 2)))))

(defn remove-nth [coll n]
  (concat (take n coll)
          (drop (inc n) coll)))

(defn nth-permutation [vals n]
  ":: [a], Integer -> [a]
   -- from problem 24
   Returns nth permutation of vals, assuming
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
