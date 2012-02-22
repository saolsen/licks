(ns licks.web
  (:use [licks.core :only [transcribe]]
        [ring.adapter.jetty]
        [ring.middleware.reload]
        [ring.middleware.file]))

;; This is where the webcode goes, there's a main endpoint that returns the
;; index page and there's an endpoint that gets the music phrases and returns
;; the transcriptions.
;; The serving of the html should probably be done by ngix or something other
;; than this transcription service but I'll deal with that later since this is
;; just for fun.

;; Called with every jetty request
(defn handler [req]
  {:status 200
   :headers {"Content-type" "text/html"}
   :body (str req)})

(def reload
  (wrap-reload #'handler '(licks.web)))

(def app
  (wrap-file #'reload "./src/licks/resources"))

(defn run-web-server
  "Starts the web server"
  []
  (run-jetty #'app {:port 8080}))