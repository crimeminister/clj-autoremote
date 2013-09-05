(defproject org.crimeminister/autoremote "0.1.1"
  :description "Send AutoRemote messages/notifications to Android devices"
  :url "http://github.com/crimeminister/clj-autoremote/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 ;; URI processing
                 [org.bovinegenius/exploding-fish "0.3.3"]
                 ;; Validations
                 [com.novemberain/validateur "1.5.0"]
                 ;; HTTP client/server
                 [http-kit "2.1.10"]]
  :profiles {:dev {:dependencies [[org.clojure/tools.trace "0.7.6"]
                                  [clj-stacktrace "0.2.6"]]}})
