(ns app.db
  (:require [reagent.core :as r]))

;; -- Application State  --------------------------------------------------------------------------
;; Should not be accessed directly by application code.
(def app-db (r/atom {}))
