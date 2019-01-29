(ns sigmageo.view
  (:use hiccup.page hiccup.element))

(def KEY "AIzaSyDpFdOYgaCQZCPNeiP0NhnXofDYmCJFaiY")

(defn r [lat lng]
  (html5
     [:head
     ]
     [:body 
      {:data-lat lat :data-lng lng}
      [:div {:id :street-view}]
      (include-js "https://code.jquery.com/jquery-3.3.1.min.js")
      (include-js "/map.js")
      (include-css "/map.css")
      (include-js (str "https://maps.googleapis.com/maps/api/js?key=" KEY "&callback=initialize"))
     ]))
