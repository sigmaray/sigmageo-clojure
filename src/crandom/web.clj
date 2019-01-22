(ns crandom.web
  (:require [compojure.core :refer [defroutes GET]]
            [ring.adapter.jetty :as ring]
            [ring.middleware.reload :refer [wrap-reload]]
            [clojure.java.shell :as shell]
            [environ.core :refer [env]]))

(defroutes app
  (GET "/" [] "<h2>Hello World</h2>")
  ; (GET "/random" [] ((shell/sh "shuf" "-n 1" (clojure.java.io/resource "US.json") :out))))
  (GET "/random" []  (rand-nth (clojure.string/split-lines (slurp (clojure.java.io/resource "US.json")))))
  (GET "/debug" [] (clojure.java.io/resource "US.json")))

(defn -dev-main [port]
  (ring/run-jetty (wrap-reload #'app) {:port (Integer. port)}))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 5000))]
    (ring/run-jetty #'app {:port port :join? false})))
