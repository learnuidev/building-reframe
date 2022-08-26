(ns app.re-frame

  (:require [app.registrar :refer [kind->id->handler]]
            [app.db :refer [app-db]]))

(defn reg-event-db [event-id handler]
  (swap! kind->id->handler assoc-in [:event event-id] handler))


(defn dispatch [event]
  (let [event-id (first event)]
    (if-let [handler (get-in @kind->id->handler [:event event-id])]
      (let [updated-db (handler @app-db event)
            _ (reset! app-db updated-db)]
        event)
      (js/console.warn (str "No event handler registered for " event-id)))))


(comment
  (dispatch [:init])
  (dispatch [:na])
  @app-db)
