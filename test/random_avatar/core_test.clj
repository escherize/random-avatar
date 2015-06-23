(ns random-avatar.core-test
  (:require [clojure.test :refer :all]
            [random-avatar.core :refer :all]
            [clojure.java.io :as io]))

(deftest lemon-test
  (testing "lemon.png is always the same"
    (let [_ (create-avatar "lemon")
          contents (slurp "resources/lemon.png")
          _ (io/delete-file "resources/lemon.png")]
      (is (= (count contents)
             (count (slurp "resources/lemon_copy.png"))))
      (is (= contents (slurp "resources/lemon_copy.png"))))))
