(ns euler.problem17)

(defn to-words
  [n]
  (let [thousands (quot n 1000)
        hundreds  (quot n 100)
        hundreds' (mod n 100)
        tens      (quot n 10)
        tens'     (mod n 10)]
    (cond (= 1 thousands)
          "onethousand"

          (> hundreds 0)
          (str (to-words hundreds) "hundred"
               (if (> hundreds' 0)
                 (str "and" (to-words hundreds'))
                 ""))

          (> tens 1)
          (str
           (case tens
             2 "twenty"
             3 "thirty"
             4 "forty"
             5 "fifty"
             6 "sixty"
             7 "seventy"
             8 "eighty"
             9 "ninety")
           (to-words tens'))

          :else
          (case n
            0 ""
            1 "one"
            2 "two"
            3 "three"
            4 "four"
            5 "five"
            6 "six"
            7 "seven"
            8 "eight"
            9 "nine"
            10 "ten"
            11 "eleven"
            12 "twelve"
            13 "thirteen"
            14 "fourteen"
            15 "fifteen"
            16 "sixteen"
            17 "seventeen"
            18 "eighteen"
            19 "nineteen"))))

(def nums (range 1 1001))

(defn solve
  []
  (reduce + (map count (map to-words nums))))