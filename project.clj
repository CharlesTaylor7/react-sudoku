(defproject sudoku-solver "0.1.0-SNAPSHOT"
  :description "Solve sudoku puzzles with Loco"
  :url "https:github.com/charlestaylor7/sudoku-solver"
  :license {:name "MIT"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies
  [[org.clojure/clojure "1.10.0"]
   [loco "0.3.1"]]
  :main ^:skip-aot sudoku-solver.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
