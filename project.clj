(defproject beer-harmony "0.1.0-SNAPSHOT"
  :description "BeerMe REST API"
  :url "https://github.com/trevorbernard/gooey"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/tools.logging "0.3.1"]
                 [org.clojure/tools.cli "0.3.1"]
                 [metrics-clojure-ring "2.4.0"]
                 [org.slf4j/slf4j-api "1.7.9"]
                 [ch.qos.logback/logback-classic "1.1.2"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [ring/ring-defaults "0.1.3" :exclusions [ring/ring-core]]
                 [ring/ring-json "0.3.1"]
                 [ring/ring-devel "0.3.1"]
                 [tentacles "0.3.0"]
                 [compojure "1.3.1"]
                 [http-kit "2.1.19"]]
  :plugins [[lein-ring "0.8.13"]]
  :main social.webapp
  :ring {:handler social.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
