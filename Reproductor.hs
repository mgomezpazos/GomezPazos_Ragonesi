module Reproductor ( Reproductor, nuevoR, archivosR, listaParaR, temasR, playR, actualR, avanzarR, retrocederR,
reiniciarR )
    where
import Tipos
import Tema
import Playlist
import FileSystem

data Reproductor = RP FileSystem Playlist deriving (Eq, Show)

nuevoR :: FileSystem → Reproductor
--Crea un nuevo reproductor a partir de un FileSystem y una nueva Playlist con su lista de temas vacia.
archivosR :: Reproductor → FileSystem
--Le pasamos el reproductor ya creado y le cargamos el FileSystem.
listaParaR :: Etiqueta → Reproductor →[Tema]
--Le cargamos la lista de etiquetas y el nuevo reproductor y nos devuelve la lista con los temas con esa etiqueta
temasR :: Reproductor → [Tema]
--Nos devuelve los temas que tenga el reproductor
playR :: Reproductor → Etiqueta → Reproductor
-- QUE?!?!?!?!?!?!
-- Agus:
-- ?????
actualR :: Reproductor →Tema
-- Tema que se está reproduciendo
avanzarR :: Reproductor →Reproductor
--AAanza una canción
retrocederR :: Reproductor →Reproductor
--Retrocede
reiniciarR :: Reproductor →Reproductor
--Volvemos al inicio del reproductor o llimpia todo el reproductor o nos crea unn reproductor idéntico nuevo.
-- resetea la playlist