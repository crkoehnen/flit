(defproject flit "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.8"]
                 [hiccup "1.0.5"]
                 [ring-server "0.3.1"]
                 [environ "0.5.0"]
                 [com.cemerick/drawbridge "0.0.6"]
                 [ring/ring-jetty-adapter "1.2.2"]]
  :min-lein-version "2.0.0"
  :plugins [[lein-ring "0.8.10"]
            [environ/environ.lein "0.2.1"]]
  :ring {:handler flit.handler/app
         :init flit.handler/init
         :destroy flit.handler/destroy}
  :aot :all
  :profiles
  {:production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}
    :env {production true}}
   :dev
   {:dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.2.1"]]}}
  :hooks [environ.leiningen.hooks]
  :uberjar-name "flit-standalone.jar"
  )
