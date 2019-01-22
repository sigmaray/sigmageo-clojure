(ns crandom.web
  (:require [compojure.core :refer [defroutes GET]]
            [ring.adapter.jetty :as ring]
            [ring.middleware.reload :refer [wrap-reload]]
            [clojure.java.shell :as shell]))

(defroutes app
  (GET "/" [] "<h2>Hello World</h2>")
  (GET "/random" [] ((shell/sh "shuf" "-n 1" "resources/US.json") :out)))

(def reloadable-app
  (wrap-reload #'app))

(defn -main []
  (ring/run-jetty #'reloadable-app {:port 7070 :join? false}))
