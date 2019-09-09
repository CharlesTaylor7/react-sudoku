(ns sudoku-solver.lib
  (:gen-class)
  (:use loco.constraints)
  (:require
   [loco.core :as loco]
   [clojure.string :refer [join split]]
   [clojure.spec.alpha :refer [int-in-range?]]))

(defn cell
  [i j]
  (keyword (str i "-" j)))

(def sudoku-model
  "A blank sudoku model"
  (let [vars (for [i (range 9)
                   j (range 9)]
               ($in (cell i j) 1 9))
        rows (for [i (range 9)]
               ($distinct (for [j (range 9)] (cell i j))))
        cols (for [j (range 9)]
               ($distinct (for [i (range 9)] (cell i j))))
        boxes (for [i (range 3) j (range 3)]
                ($distinct
                 (for [x (range 3) y (range 3)]
                   (cell (+ x (* 3 i)) (+ y (* 3 j))))))]
    (concat vars rows cols boxes)))

(defn sort-board
  [board]
  (sort-by (fn [[[_ i j] v]] (+ j (* 9 i))) board))

(defn tap
  "Prints the value, and returns it"
  ([x] (tap identity x))
  ([f x] (println (f x)) x))

(defn diagram
  "Get a string diagram of the sudoku board"
  [board]
  (->>
   board
   (map second)
   (partition 9)
   (map (fn [row] (->>
                   row 
                   (partition 3)
                   (map #(join " " %))
                   (join "|"))))
   (partition 3)
   (map (fn [cols] (join "\n" cols)))
   (join "\n-----------------\n")))

(defn my-assert
  "Assert a predicate on x. Throws an exception if the assertion failed, otherwise returns x."
  [x pred message]
  (if (pred x)
    x
    (throw (.Exception message))))

(defn char->digit
  "Parse character to digit"
  [char]
  (->
   char
   int
   (- 48)
   (my-assert #(int-in-range? 0 10 %) "character should be a digit")))

(defn to-constraint
  "Turn a query param into a sudoku constaint"
  [[key value]]
  ($= (keyword key) (char->digit value)))

(defn solve
  [query]
  (loco/solution
   (concat
    sudoku-model
    (map to-constraint query))))
