(ns time-observer.server.core
  (:require [org.httpkit.server :as server]
            [time-observer.server.handler :as handler])
  (:gen-class))

(def server (atom {}))
(def port 5000)

(defn- start-server
  []
  (swap! server assoc :app (server/run-server (handler/app-handler) {:port port})))

(defn- stop-server
  []
  (do
    ((:app @server) :timeout 100)
    (swap! server assoc :app nil)))

(defn- restart-server
  []
  (do
    (stop-server)
    (start-server)))

(defn -main
  "Starts the server"
  [& _args]
  (println "Server run on port " port)
  (start-server))
