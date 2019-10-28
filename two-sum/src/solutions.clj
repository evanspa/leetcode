(ns two-sum)

;; O(n) solution
(defn two-sum [vals target]
  (loop [vals vals
         i 0
         indexes {}
         result []]
    (let [val (first vals)
          difference (- target val)
          prev-idx (get indexes difference)]
      (if prev-idx
        [prev-idx i]
        (recur (next vals) (inc i) (assoc indexes val i) result)))))
