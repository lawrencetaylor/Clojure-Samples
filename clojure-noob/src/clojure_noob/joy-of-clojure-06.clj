(ns joc.c6)

;;Shared memory structures
(def shared-list (list :a :b :c))
(def list1 (cons :d shared-list))
(def list2 (cons :e shared-list))

(def nextlist1 (next list1))
(def nextlist2 (next list2))

(println "Are the nexts equal: " (= nextlist1 nextlist2))

(println "Are the nexts idential: " (identical? nextlist1 nextlist2))

;;Poor mans tree
(defn xconj
  ([value] (xconj nil value))
  ([tree value]
   (cond 
    (nil? tree) {:val value, :L nil, :R nil}
    (< value (:val tree)) {:val (:val tree), :L (xconj (:L tree) value), :R (:R tree)}
    :else {:val (:val tree), :L (:L tree), :R (xconj (:R tree) value)})))

(def initial-tree (xconj 5))
(def tree2 (xconj initial-tree 3))
(def tree3 (xconj tree2 2))
(def tree4 (xconj tree3 7 ))
(println initial-tree)
(println tree2)
(println tree3)
(println tree4)

(defn xseq2
  [tree]
  (when tree 
    (concat (xseq (:L tree)) [:val tree] (xseq (:R tree)))))

(println "Traversing")
(println (xseq2 tree4))
