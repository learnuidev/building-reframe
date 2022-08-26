(ns app.core
  (:require [reagent.core :as r]
            [app.re-frame :as rf]
            [reagent.dom :as rdom]))

;;
(rf/reg-event-db
 :init
 (fn [db _]
   {:counter 0}))

;;
(rf/reg-event-db
 :increment
 (fn [db _]
   (update db :counter inc)))



(defn app []
  [:div "re-frame starter"])

(defn ^:dev/after-load render
  "Render the toplevel component for this app."
  []
  (rdom/render [app] (.getElementById js/document "app")))

(defn ^:export main
  "Run application startup logic."
  []
  (render))
