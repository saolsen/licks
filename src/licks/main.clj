(ns licks.main
  (:use [licks.web :only [handler]]
        [ring.adapter.jetty])
  (:gen-class))

;; Main entry point for the application, Starts the webserver.

(defn -main
  "Main entry point"
  []
  (let [port 8080]
    (do
      (println "Starting Server")
      (run-jetty handler {:port port}))))
