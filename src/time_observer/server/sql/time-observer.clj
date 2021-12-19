(ns time-observer.server.sql.time-observer
  (:require [clojure.java.jdbc :as j]
            [time-observer.server.sql.config :refer [db]]))

(defn get-all-tasks
  []
  (j/query db "select * from task"))