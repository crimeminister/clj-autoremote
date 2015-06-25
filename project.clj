(defproject ca.clojurist/autoremote "0.1.3-SNAPSHOT"
  :description "Send AutoRemote messages/notifications to Android devices"
  :url "http://github.com/clojurist-ca/clj-autoremote/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0-RC1"]
                 ;; URI processing
                 [org.bovinegenius/exploding-fish "0.3.4"]
                 ;; Validations
                 [com.novemberain/validateur "2.4.2"]
                 ;; HTTP client/server
                 [http-kit "2.1.19"]]
  :profiles {:dev {:dependencies [[fipp "0.6.2"]
                                  [org.clojure/tools.namespace "0.2.10"]
                                  [org.clojure/tools.trace "0.7.8"]
                                  [clj-stacktrace "0.2.8"]
                                  [clj-time "0.9.0"]]
                   :source-paths ["dev"]}}
  :min-lein-version "2.5.0")
