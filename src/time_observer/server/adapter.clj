(ns time-observer.server.adapter
  (:require [time-observer.server.operator :refer [operator]]))

(defn adapter-handler
  [handler]
  (fn [request]
    (let [{:keys [op] :as response} (handler request)]
      (assoc response :body (apply operator op)))))