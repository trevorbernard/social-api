(ns social.routes.users
  (:require [compojure.core :refer :all]
            [ring.util.response :refer [response]]))

(def world (atom [{"name" "Trev"
                     "asdfasdf" "asdfsafd"
                     "description" (str (java.util.UUID/randomUUID))}
                  {"name" "Travis"
                     "asdfasdf" "asdfsafd"
                     "description" (str (java.util.UUID/randomUUID))}
                  {"name" "Kevin"
                     "asdfasdf" "asdfsafd"
                     "description" (str (java.util.UUID/randomUUID))}
                  {"name" "Hilary"
                     "asdfasdf" "asdfsafd"
                     "description" (str (java.util.UUID/randomUUID))}]))
(defn json-response [body]
  [body]
  {:status  200
   :headers {"Content-Type" "application/json"
             "Access-Control-Allow-Origin" "http://localhost:3000"}
   :body    body})

(def users-route
  (routes
   (GET "/users/:user-id" [user-id]
     (json-response @world))))


