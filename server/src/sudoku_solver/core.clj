(ns sudoku-solver.core
  (:require
   [sudoku-solver.lib :as sudoku]
   [org.httpkit.server :as server]
   [compojure.core :refer :all]
   [compojure.route :as route]
   [ring.middleware.defaults :refer :all]
   [clojure.pprint :as pp]
   [clojure.string :as str]
   [clojure.data.json :as json])
  (:gen-class))

(defn sudoku-solutions
  "Return all solutions to a partially filled in sudoku board." 
  [{ query :params}]
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    (json/write-str (sudoku/solve query))})

(defroutes app-routes
  (GET "/" [] sudoku-solutions)
  (route/not-found "Error, page not found!"))

(defn -main
  [& args]
  (let [port (Integer/parseInt (or (System/getenv "PORT") "3001"))]
    (server/run-server (wrap-defaults #'app-routes site-defaults) {:port port})
    (println (str "Running webserver at http:/127.0.0.1:" port "/"))))
