(defproject ca.clojureist/autoremote "0.1.2"
  :description "Send AutoRemote messages/notifications to Android devices"
  :url "http://github.com/clojureist/clj-autoremote/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 ;; URI processing
                 [org.bovinegenius/exploding-fish "0.3.4"]
                 ;; Validations
                 [com.novemberain/validateur "1.5.0"]
                 ;; HTTP client/server
                 [http-kit "2.1.13"]]
  :profiles {:dev {:dependencies [[fipp "0.4.1"]
                                  [org.clojure/tools.namespace "0.2.4"]
                                  [org.clojure/tools.trace "0.7.6"]
                                  [clj-stacktrace "0.2.7"]
                                  [clj-time "0.6.0"]]
                   :source-paths ["dev"]}}
  :min-lein-version "2.3.0")
