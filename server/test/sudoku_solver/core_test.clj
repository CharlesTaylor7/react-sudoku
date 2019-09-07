(ns sudoku-solver.core-test
  (:require [clojure.test :refer :all]
            [sudoku-solver.core :refer :all]
            [sudoku-solver.project-euler :refer :all]))

(deftest indexed_test
  (testing "Indexes a collection"
    (is (= (indexed [3 2 1]) [[0 3] [1 2] [2 1]]))))

(deftest char->digit_test
  (testing "Converts characters to digits"
    (is (= (char->digit \3) 3))
    (is (= (char->digit \0) 0))
    (is (= (char->digit \9) 9)))
  (testing "Converting a non digit character throws"
    (is (thrown? Exception (char->digit \$)))
    (is (thrown? Exception (char->digit \#)))
    (is (thrown? Exception (char->digit \a)))))
