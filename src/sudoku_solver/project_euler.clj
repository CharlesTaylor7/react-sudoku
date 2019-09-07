(ns sudoku-solver.project-euler
  (:gen-class)
  (:use loco.core loco.constraints)
  (:require
   [clojure.string :refer [join split-lines]]
   [sudoku-solver.core :refer [sudoku-model tap]]))

(defn indexed
  [coll]
  (map-indexed (fn [k v] [k v]) coll))

(defn char->digit
  "Parse character to digit"
  [char]
  (-> 
   char
   int
   (- 48)))

(defn soln
  []
  (->>
   "https://projecteuler.net/project/resources/p096_sudoku.txt"
   slurp
   split-lines
   (partition 10)
   (map
    (fn [lines] 
      (->>
       lines
       (drop 1)
       (fn [board] 
         (for [[i row] (indexed board)
               [j char] (indexed row)
               :let [value (char->digit char)]
               :when (> value 0)]
           (do (println value) 
           ($= [:cell i j] value))))
       (concat sudoku-model))))))
  ;      solution
  ;      (fn
  ;          ; Upper left corner 3 digit number
  ;        [{hun [:cell 0 0] ten [:cell 0 1] one [:cell 0 2]}] 
  ;          ; Convert digits to number using Horner's rule 
  ;        (+ one (* 10 (+ ten (* 10 hun))))))))
  ;  (reduce +)))

(soln)
