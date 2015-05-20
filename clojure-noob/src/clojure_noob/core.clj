(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

;;Lists
(defn -firstOfList
  [& s]
  (first s))

;;Making a set
(defn make-set
  "Takes two values and makes a set from them"
  [x y]
  #{x y})

;;Looping
(defn print-down-from
  "Prints down from a value"
  [x]
  (when (pos? x) (println x) (recur (dec x))))
