module Reproductor ( Reproductor, nuevoR, temasR, archivosR, listaParaR, playR, actualR, avanzaR, retrocedeR, reiniciaR)
    where
import Tipos
import Tema
import Playlist
import FileSystem

data Reproductor = RP FileSystem Playlist deriving (Eq, Show)


nuevoR :: FileSystem -> Playlist -> Reproductor --Crea un nuevo reproductor a partir de un FileSystem y una nueva Playlist con su lista de temas vacia.
nuevoR = RP

archivosR :: Reproductor -> FileSystem --Le pasamos el reproductor ya creado y le cargamos el FileSystem.
archivosR (RP filesystem playlist) = filesystem 

listaParaR :: Etiqueta -> Reproductor -> [Tema]
listaParaR etiqueta (RP fylesystem playlist) = filtrarF etiqueta fylesystem

temasR :: Reproductor -> [Tema] --Nos devuelve los temas que tenga el reproductor
temasR (RP filesystem _) = temasF filesystem

--playR (RP filesystem playlist) etiqueta = RP (filtrarF etiqueta filesystem) playlist
playR :: Reproductor -> Etiqueta -> Reproductor -- le paso un reproductor con una etiqueta y me devuelve los temas de esa etiqueta
playR (RP filesystem playlist) etiqueta = RP filesystem (nuevaP (listaParaR etiqueta (RP filesystem playlist)))

actualR :: Reproductor -> Tema -- Tema que se está reproduciendo
actualR (RP filesystem playlist) = actualP playlist

avanzaR :: Reproductor -> Reproductor --Avanza una canción 
avanzaR (RP filesystem playlist) = RP filesystem (skipP playlist)

retrocedeR :: Reproductor -> Reproductor --Retrocede una canción
retrocedeR (RP filesystem playlist) = RP filesystem (backP playlist)

reiniciaR :: Reproductor -> Reproductor --Resetea el reproductor
reiniciaR (RP filesystem playlist) = RP filesystem (resetP playlist) 


--TEST:
nuevoReproductor :: FileSystem -> Playlist -> Reproductor
nuevoReproductor = nuevoR
cancionTest1 :: Tema
cancionTest1 = nuevoT "Borderline" "Tame_Impala_music"
cancionTest2 :: Tema
cancionTest2 = nuevoT "Despacito" "Des-pa-cito"
cancionTest3 :: Tema
cancionTest3 = nuevoT "Eternal Summer" "The_Strokes_Song"
cancionTest4 :: Tema
cancionTest4 = nuevoT "Lost Cause" "Billie_Eilish_Song"

etiquetasTest :: [String]
etiquetasTest = ["pop", "rock", "indie"]
temasTest :: [Tema]
temasTest = [cancionTest1, cancionTest2, cancionTest3]

test_Reproductor :: [Bool]
test_Reproductor = [
    nuevoReproductor [] [] == RP [] [],
    archivosR (RP etiquetasTest temasTest) == etiquetasTest temasTest,
    listaParaR "pop" (RP etiquetasTest temasTest) == temasTest,
    temasR (RP (etiquetasTest temasTest) temasTest) == temasTest,
    playR (RP etiquetasTest temasTest) "pop" == ,
    actualR (RP etiquetasTest temasTest) == actualP temasTest,
    avanzaR (RP etiquetasTest temasTest) == RP etiquetasTest temasTest (skipP temasTest),
    retrocedeR (RP etiquetasTest temasTest) == RP etiquetasTest temasTest (backP temasTest),
    reiniciaR (RP etiquetasTest temasTest) == RP etiquetasTest (resetP temasTest)
    ]

