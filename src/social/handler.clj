(ns social.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [social.routes.users :as users]
            [ring.middleware.reload :as reload]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (context "/api/1.0" []
    users/users-route
    (GET "/" [] "Hello World!!!"))
  (route/not-found "Not Found"))

(def app
  (-> (wrap-defaults (reload/wrap-reload app-routes ['social.routes.users]) site-defaults)
      wrap-json-response))
