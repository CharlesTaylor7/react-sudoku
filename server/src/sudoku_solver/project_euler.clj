(ns sudoku-solver.project-euler
  (:gen-class)
  (:use loco.core loco.constraints)
  (:require
   [clojure.string :refer [join split-lines]]
   [sudoku-solver.core :refer [sudoku-model tap]]
   [clojure.spec.alpha :refer [int-in-range?]]))

(defn indexed
  [coll]
  (map-indexed (fn [k v] [k v]) coll))

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

(defn board->constraints
  "Go from the ten lines making up a board to a list of cell constraints."
  [lines]
  (for [[i row] (indexed (drop 1 lines))
        [j char] (indexed row)
        :let [value (char->digit char)]
        :when (> value 0)]
    ($= [:cell i j] value)))

(defn extract-number
  "Get 3 digit number from upper left corner of board"
  [{hun [:cell 0 0]
    ten [:cell 0 1]
    one [:cell 0 2]}]
  ; Convert digits to number using Horner's rule
  (+ one (* 10 (+ ten (* 10 hun)))))

(defn thrush [& args]
  #(reduce (fn [x f] (f x)) % args))

(defn soln
  []
  (->>
   "https://projecteuler.net/project/resources/p096_sudoku.txt"
   slurp
   split-lines
   (partition 10)
   (map (thrush
         board->constraints
         #(lazy-cat sudoku-model %)
         solution
         extract-number))
   (reduce +)))
        
(soln)
