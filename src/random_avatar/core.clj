(ns random-avatar.core
  (:import java.io.File
           (org.hackrslab.avatar
            RandomAvatarBuilder
            RandomAvatar
            RandomAvatar$Extra)))

(defn build-generator ^RandomAvatar []
  (-> (RandomAvatarBuilder.)
      (.squareSize 400)
      (.blockSize 5)
      (.backgroundColor 0x272727)
      (.cache true)
      (.addColor 0 68 204)
      (.addColor 0 136 204)
      (.addColor 81 163 81)
      (.addColor 248 148 6)
      (.addColor 189 54 47)
      (.build)))

(defn random-avatar
  "Saves a random or seeded png image into filename"
  ([filename]
   (let [generator (build-generator)]
     (.generate generator
                (new File filename))))
  ([filename seed]
   (let [generator (build-generator)]
     (.generate generator
                (new File filename)
                (RandomAvatar$Extra/seed seed)))))

(defn create-avatar [seed]
  (let [generator (build-generator)]
    (.generate generator
               (new File (str "resources/" seed ".png"))
               (RandomAvatar$Extra/seed seed))))
