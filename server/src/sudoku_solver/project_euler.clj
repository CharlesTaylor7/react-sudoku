(ns sudoku-solver.project-euler
  (:gen-class)
  (:use loco.core loco.constraints sudoku-solver.lib)
  (:require
   [clojure.string :refer [join split-lines]]))

(defn indexed
  [coll]
  (map-indexed (fn [k v] [k v]) coll))

(defn board->constraints
  "Go from the ten lines making up a board to a list of cell constraints."
  [lines]
  (for [[i row] (indexed (drop 1 lines))
        [j char] (indexed row)
        :let [value (char->digit char)]
        :when (> value 0)]
    ($= (cell i j) value)))

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
