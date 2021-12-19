(ns time-observer.server.operator
  (:require [time-observer.server.sql.time-observer :as time-observer-db]))

(defn- operation
  [operation]
  operation)

;; Public

(defmulti operator operation)

(defmethod operator :test
  [_]
  {:result :test})

(defmethod operator :get-tasks
  [_]
  (time-observer-db/get-all-tasks))