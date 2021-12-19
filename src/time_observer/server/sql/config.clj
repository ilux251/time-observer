(ns time-observer.server.sql.config)

(def db
  {:classname "org.sqlite.JDBC"
   :subprotocol "sqlite"
   :subname "time-observer.db"})