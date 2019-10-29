(ns two-sum-solution)

;; O(n) solution
(defn two-sum [vals target]
  (loop [vals vals
         i 0
         indexes {}]
    (if (empty? vals)
      nil
      (let [val (first vals)
            difference (- target val)
            prev-idx (get indexes difference)]
        (if prev-idx
          [prev-idx i]
          (recur (next vals) (inc i) (assoc indexes val i)))))))


(defn -main [& args]
  (is (= [2 3] (two-sum [4 8 12 2 16] 14)))
  (is (= [3 4] (two-sum [4 8 12 2 16] 18)))
  (is (= nil (two-sum [4 8 12 2 16] 83)))
  (is (= [0 1] (two-sum [4 8 12 2 16] 12)))
  (is (= [0 5] (two-sum [4 8 12 2 16 17] 21))))
