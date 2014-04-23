(ns user
  "Tools for interactive development with the REPL. This file should
  not be included in a production build of the application."
  (:require
   [ca.clojurist.autoremote :as autoremote]
   [clj-time.core :as time+]
   [clj-time.coerce :as time+coerce]
   [clj-time.format :as time+format]
   [clojure.java.io :as io]
   [clojure.java.javadoc :refer (javadoc)]
   [clojure.pprint :refer (pprint)]
   [clojure.reflect :refer (reflect)]
   [clojure.repl :refer (apropos dir doc find-doc pst source)]
   [clojure.set :as set]
   [clojure.string :as string]
   [clojure.test :as test]
   [clojure.tools.namespace.repl :refer (refresh refresh-all)]
   [clojure.tools.trace :refer :all]
   [fipp.edn :refer (pprint) :rename {pprint fipp}]
   [org.bovinegenius.exploding-fish :as uri]
   [org.httpkit.client :as http]))

(def system
  "A Var containing an object representing the application under
  development."
  nil)

(defn init
  "Creates and initializes the system under development in the Var
  #'system."
  []
  ;; TODO
  )

(defn start
  "Starts the system running, updates the Var #'system."
  []
  ;; TODO
  )

(defn stop
  "Stops the system if it is currently running, updates the Var
  #'system."
  []
  ;; TODO
  )

(defn go
  "Initializes and starts the system running."
  []
  (init)
  (start)
  :ready)

(defn reset
  "Stops the system, reloads modified source files, and restarts it."
  []
  (stop)
  (refresh :after 'user/go))
