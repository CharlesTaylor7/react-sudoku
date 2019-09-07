(ns sudoku-solver.project-euler
  (:gen-class)
  (:use loco.core loco.constraints)
  (:require
   [clojure.string :refer [join split-lines]]
   [sudoku-solver.core :refer [sudoku-model]]))

(defn indexed
  [coll]
  (map-indexed #([%1 %2]) coll))

(defn soln
  []
  (->>
   "https://projecteuler.net/project/resources/p096_sudoku.txt"
   slurp
   split-lines
   partition 10
   (map (->>
         (drop 1)
         (fn [board] 
           (for [[i row] (indexed board)
                 [j value] (indexed row)
                 :when (> value 0)
                 ]
             ($= [:cell i j] value)))
         (concat sudoku-model)
         solution
         (fn 
           ; Upper left corner 3 digit number
           [{h [:cell 0 0] t [:cell 0 1] o [:cell 0 2]}] 
           ; Convert digits to number using Horner's rule 
           (+ o (* 10 (+ t (* 10 h)))))
         ))
   (reduce +)))

(soln)
