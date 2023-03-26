module Reproductor ( Reproductor, nuevoR, temasR, archivosR, listaParaR {-playR-}, actualR, avanzaR, retrocedeR, reiniciaR)
    where
import Tipos
import Tema
import Playlist
import FileSystem

data Reproductor = RP FileSystem Playlist deriving (Eq, Show)

nuevoR :: FileSystem -> Playlist -> Reproductor
nuevoR = RP
--Crea un nuevo reproductor a partir de un FileSystem y una nueva Playlist con su lista de temas vacia.
archivosR :: Reproductor -> FileSystem
archivosR (RP filesystem playlist) = filesystem -- Funciona pero no sabemos si esta bien
--Le pasamos el reproductor ya creado y le cargamos el FileSystem.
listaParaR :: Etiqueta -> Reproductor -> [Tema]
listaParaR etiqueta (RP fylesystem playlist) = filtrarF etiqueta fylesystem
-- es igual que filtrarF
--Lctoe cargamos la lista de etiquetas y el nuevo reprodur y nos devuelve la lista con los temas con esa etiqueta


{-filtrarF :: Etiqueta -> FileSystem -> [Tema]
filtrarF etiqueta (FS etiquetas tema) = filter (\t -> etiqueta `elem` generosMusicales t) tema
  where generosMusicales t = foldr (\each acc -> if each `elem` etiquetasT t then each:acc else acc) [] etiquetas
  
  
  filtrarF "pop" (FS etiquetasTest [agregarT "pop" cancionTest2]) == [agregarT "pop" cancionTest2]
  
  
  
  
  -}



temasR :: Reproductor -> [Tema]
temasR (RP filesystem _) = temasF filesystem
--Nos devuelve los temas que tenga el reproductor
--playR :: Reproductor -> Etiqueta -> Reproductor
--QUE?!?!?!
-- le paso un reproductor con una etiqueta y me devuelve los temas de esa etiqueta

actualR :: Reproductor -> Tema -- Tema que se está reproduciendo
actualR (RP filesystem playlist) = actualP playlist

avanzaR :: Reproductor -> Reproductor -- hay que entrar a file system en temas F y sumarle 1
avanzaR (RP filesystem playlist) = RP filesystem (skipP playlist)
--Le sumamos uno a temasR
-- tenemos que avanzar la cancion desde File SYSTEM con temas F o desde Playlist con skipP

retrocedeR :: Reproductor -> Reproductor
retrocedeR (RP filesystem playlist) = RP filesystem (backP playlist)

reiniciaR :: Reproductor -> Reproductor
reiniciaR (RP filesystem playlist) = RP filesystem (resetP playlist) 
--Volvemos al inicio del reproductor o llimpia todo el reproductor o nos crea unn reproductor idéntico nuevo.
-- resetea la playlist
