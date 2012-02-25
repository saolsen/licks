(ns licks.web
  (:use [licks.core :only [transcribe]]
        [ring.adapter.jetty]
        [ring.middleware.reload]
        [ring.middleware.file]))

;; This is where the webcode goes

;; Called with every jetty request, we want to return the index if
;; they hit the root endpoint.
(defn handler [req]
  {:status 200
   :headers {"Content-type" "text/html"}
   :body (slurp "./src/licks/resources/index.html")})

(def reload
  (wrap-reload #'handler '(licks.web)))

(def app
  (wrap-file #'reload "./src/licks/resources"))

(defn run-web-server
  "Starts the web server"
  []
  (run-jetty #'app {:port 8080}))