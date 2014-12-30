(ns social.webapp
  (:require [clojure.tools.cli :refer [parse-opts]]
            [social.handler :as handler]
            [org.httpkit.server :as httpkit :refer [run-server]]
            [clojure.tools.logging :as log])
  (:gen-class))

(def cli-options
  [["-p" "--port PORT" "Port number"
    :default 9000
    :parse-fn #(Integer/parseInt %)
    :validate [#(< 0 % 0x10000) "Must be a number between 0 and 65536"]]
   ["-h" "--help"]])

(defn -main [& args]
  (let [{:keys [options summary errors]} (parse-opts args cli-options)
        {:keys [help port]} options]
    (when errors
      (doseq [error errors]
        (println error))
      (System/exit 1))
    (when help
      (println summary)
      (System/exit 0))
    (log/info "Running server on port:" port)
    (run-server handler/app {:port port})))

