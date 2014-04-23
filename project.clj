(defproject ca.clojurist/autoremote "0.1.3-SNAPSHOT"
  :description "Send AutoRemote messages/notifications to Android devices"
  :url "http://github.com/clojurist-ca/clj-autoremote/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 ;; URI processing
                 [org.bovinegenius/exploding-fish "0.3.4"]
                 ;; Validations
                 [com.novemberain/validateur "2.0.0"]
                 ;; HTTP client/server
                 [http-kit "2.1.18"]]
  :profiles {:dev {:dependencies [[fipp "0.4.1"]
                                  [org.clojure/tools.namespace "0.2.4"]
                                  [org.clojure/tools.trace "0.7.8"]
                                  [clj-stacktrace "0.2.7"]
                                  [clj-time "0.6.0"]]
                   :source-paths ["dev"]}}
  :min-lein-version "2.3.0")
