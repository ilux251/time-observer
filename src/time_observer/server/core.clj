(ns time-observer.server.core
  (:require [org.httpkit.server :as server])
  (:gen-class))

(defn -main
  "Starts the server"
  [& _args]
  (let [port 5000]
    (server/run-server #{} {:port port})
    (println "Server run on port " port)))
