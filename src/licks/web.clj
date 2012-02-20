(ns licks.web)
;;  (:use [licks.core :only []]
;;        [ring.adapter.jetty]))

;; This is where the webcode goes, there's a main endpoint that returns the
;; index page and there's an endpoint that gets the music phrases and returns
;; the transcriptions.
;; The serving of the html should probably be done by ngix or something other
;; than this transcription service but I'll deal with that later since this is
;; just for fun.

(defn handler [req]
  (do
    (println req)
    {:status 200
     :headers {"Content-type" "text/html"}
     :body "Hello World!"}))
