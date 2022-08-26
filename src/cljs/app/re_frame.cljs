(ns app.re-frame
  (:require [app.registrar :refer [kind->id->handler]]))

(defn reg-event-db [event-id handler]
  (swap! kind->id->handler assoc-in [:event event-id] handler))
