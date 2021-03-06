(defproject sigmageo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [
                 [org.clojure/clojure "1.9.0"]
                 [compojure "1.6.1"]
                 [ring/ring-jetty-adapter "1.7.1"]
                 [ring "1.7.1"]
                 [environ "1.0.0"]
                 [org.clojure/data.json "0.2.6"]]
  :repl-options {:init-ns sigmageo.core}
  :uberjar-name "sigmageo-standalone.jar"
  :profiles {:uberjar {:aot :all}}
  :main sigmageo.web
  :min-lein-version "2.0.0"
  :hooks [environ.leiningen.hooks]
  :plugins [[environ/environ.lein "0.3.1"]])
