(ns joc.c3)

;;Truthfulness
;;;Be careful of true?
(defn isTrue? 
  "Only returns true if argument is true"
  [a]
  (true? a))

(defn isTruth? 
  "Returns true unless argument is false or nil"
  [a]
  (if a true false))

;;Can use the fact that (seq []) is null
(defn print-seq
  "Prints the contents of a sequence"
  [s]
  (when (seq s)
    (prn (first s))
    (recur (rest s))))

;;Destructuring
(defn format-name-vector 
  "Formats a persons full name: Takes vector as argument"
  [whole-name]
  (let [[f-name m-name l-name] whole-name]
  (str l-name ", " f-name " " m-name)))

(defn format-name-map
  "Formats a persons full name: Takes a map as argument"
  [whole-name]
  (let [{f-name :f-name, m-name :m-name, l-name :l-name} whole-name]
    (str l-name ", " f-name " " m-name)))

(defn format-name-map2
  "Formats a persons full name: Takes a map as argument"
  [whole-name]
  (let [{:keys [f-name m-name l-name]} whole-name]
    (str l-name ", " f-name " " m-name)))

(defn format-name-map3
  "Formats a persons full name with Title"
  [whole-name]
  (let [{:keys [title f-name m-name l-name]} whole-name]
    (str title f-name m-name l-name)))

(defn format-name-map4
  "Formats a persons full name with Title (with default)"
  [whole-name]
  (let [{:keys [title f-name m-name l-name], :or {title "Dr."}} whole-name]
    (str title f-name m-name l-name)))

    
