(ns licks.main
  (:use [licks.web :only [run-web-server]])
  (:gen-class))

;; Main entry point for the application, Starts the webserver.
(defn -main
  "Main entry point"
  []
  (let [port 8000]
    (do
      (println "Starting Server")
      (run-web-server))))