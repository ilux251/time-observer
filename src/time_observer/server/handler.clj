(ns time-observer.server.handler
  (:require
   [time-observer.server.adapter :refer [adapter-handler]]
   [compojure.core :as cp :refer [GET defroutes]]
   [ring.middleware.session :refer [wrap-session]]
   [ring.middleware.params :refer [wrap-params]]
   [ring.middleware.keyword-params :refer [wrap-keyword-params]]
   [ring.middleware.json :refer [wrap-json-response]]))

(defroutes app-routes
  (GET "/" [] {:op [:test]})
  (GET "/tasks" [] {:op [:get-tasks]}))

(defn app-handler
  []
  (-> app-routes
      adapter-handler
      wrap-keyword-params
      wrap-params
      wrap-session
      wrap-json-response))