(ns crandom.web
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.adapter.jetty :as ring]
            [ring.middleware.reload :refer [wrap-reload]]
            [clojure.java.shell :as shell]
            [environ.core :refer [env]]
            [crandom.view :as view]
            [clojure.data.json :as json]))

(defroutes app
  ; (GET "/" [] "<h2>Hello World</h2>")
  (route/resources "/")
  ; (GET "/random" [] ((shell/sh "shuf" "-n 1" (clojure.java.io/resource "US.json") :out))))
  ; (GET "/random" [] (rand-nth (clojure.string/split-lines (slurp (clojure.java.io/resource "US.json")))))
  (GET "/" []
    (let [
      j (json/read-str (rand-nth (clojure.string/split-lines (slurp (clojure.java.io/resource (str (rand-nth ["US" "CA" "GB"]) ".json"))))))
      lat (j "lat")
      lng (j "lng")
    ]
    (view/r lat lng)
    )
  )
  (GET "/debug" [] (clojure.java.io/resource "US.json"))
  (route/not-found "Page not found"))

(defn -dev-main [port]
  (ring/run-jetty (wrap-reload #'app) {:port (Integer. port)}))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 5000))]
    (ring/run-jetty #'app {:port port :join? false})))
