(defproject sudoku-solver "0.1.0-SNAPSHOT"
  :description "Solve sudoku puzzles with Loco"
  :url "https:github.com/charlestaylor7/sudoku-solver"
  :license {:name "MIT"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies
  [[org.clojure/clojure "1.10.0"]
   [loco "0.3.1"]
   [compojure "1.6.1"]
   [http-kit "2.3.0"]
   [ring/ring-defaults "0.3.2"]
   [org.clojure/data.json "0.2.6"]]
  :main ^:skip-aot sudoku-solver.core
  :target-path "target/%s"
  :plugins [[lein-auto "0.1.3"]]
  :profiles {:uberjar {:aot :all}})
