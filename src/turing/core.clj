(ns turing.core)

(defn run-iteration
  [[ltape rtape states state-index]]
  (let [cur-symbol (first rtape)
        cur-state (get states state-index)
        transition (get cur-state cur-symbol)
        new-state-index (get transition 0)
        new-symbol (get transition 1)
        direction (get transition 2)]
    (if (= :L direction)
        [(rest ltape) (conj (rest rtape) new-symbol (first ltape)) states new-state-index]
        [(cons new-symbol ltape) (rest rtape) states new-state-index])))

(defn run-machine
  [machine]
  (if (= (get machine 3) nil)
      machine
      (recur (run-iteration machine))))

(defn -main
  "Read the input file and parse it as a turing machine."
  [x]
  (let [contents (slurp x)
        parsed (read-string contents)]
    (println "Machine:" (run-machine parsed))))
