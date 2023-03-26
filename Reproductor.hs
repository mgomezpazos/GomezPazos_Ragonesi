module Reproductor ( Reproductor, nuevoR, temasR, archivosR, listaParaR, playR, actualR, avanzaR, retrocedeR, reiniciaR)
    where
import Tipos
import Tema
import Playlist
import FileSystem

data Reproductor = RP FileSystem Playlist deriving (Eq, Show)


nuevoR :: FileSystem -> Reproductor --Crea un nuevo reproductor a partir de un FileSystem y una nueva Playlist con su lista de temas vacia.
nuevoR filesystem = RP filesystem (nuevaP []) -- esta la modifique porque sino nos pasaba que a la hora de hacer el test se complicaba mucho

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
filesystem_test1 :: FileSystem
filesystem_test1 = nuevoF
filesystem_test2 :: FileSystem
filesystem_test2 = agregarF cancionTest1_etiqueta filesystem_test1
filesystem_test3 :: FileSystem
filesystem_test3 = agregarF cancionTest2_etiqueta filesystem_test2
playlist_test1 :: Playlist
playlist_test1 = nuevaP [cancionTest1_etiqueta, cancionTest2_etiqueta, cancionTest3_etiqueta]
nuevoReproductor :: Reproductor
nuevoReproductor = nuevoR filesystem_test1
nuevoReproductor1 :: Reproductor
nuevoReproductor1 = RP filesystem_test2 playlist_test1
reproductor_Test1 :: Reproductor
reproductor_Test1 = nuevoR (agregarF (agregarT "pop" cancionTest1) filesystem_test1)
reproductor_Test2 :: Reproductor
reproductor_Test2 = nuevoR filesystem_test3
cancionTest1 :: Tema
cancionTest1 = nuevoT "Borderline" "Tame_Impala_music"
cancionTest1_etiqueta :: Tema
cancionTest1_etiqueta = agregarT "pop" cancionTest1
cancionTest2 :: Tema
cancionTest2 = nuevoT "Despacito" "Des-pa-cito"
cancionTest2_etiqueta :: Tema
cancionTest2_etiqueta = agregarT "reggaeton" cancionTest2
cancionTest3 :: Tema
cancionTest3 = nuevoT "Eternal Summer" "The_Strokes_Song"
cancionTest3_etiqueta :: Tema
cancionTest3_etiqueta = agregarT "rock" cancionTest3
cancionTest4 :: Tema
cancionTest4 = nuevoT "Lost Cause" "Billie_Eilish_Song"
cancionTest4_etiqueta :: Tema
cancionTest4_etiqueta = agregarT "pop" cancionTest4

etiquetasTest :: [String]
etiquetasTest = ["pop", "rock", "indie"]
temasTest :: [Tema]
temasTest = [cancionTest1, cancionTest2, cancionTest3]

test_Reproductor :: [Bool]
test_Reproductor = [
    nuevoReproductor == nuevoR filesystem_test1,
    archivosR nuevoReproductor == filesystem_test1,
    listaParaR "pop" reproductor_Test2 == [cancionTest1_etiqueta],
    temasR nuevoReproductor == temasF filesystem_test1,
    playR nuevoReproductor1 "reggaeton" == RP filesystem_test2 playlist_test1,
    --actualR nuevoReproductor == actualP playlist_test1
    avanzaR nuevoReproductor1 == RP filesystem_test2 (skipP playlist_test1),
    retrocedeR nuevoReproductor1 == RP filesystem_test2 (backP playlist_test1),
    reiniciaR nuevoReproductor1 == RP filesystem_test2 (resetP playlist_test1) 
    ]
    -- HASTA ACA ARRIBA DA TRUE, ARRANQUE A PENSAR LISTAPARAR PERO ME TIRA ERROR
    {-listaParaR "pop" reproductor_Test1 == nuevoT "Borderline" ["pop"] "Tame_Impala_music",
    temasR
    playR
    actualR
    avanzaR
    retrocedeR
    reiniciaR
    ]-}
{-test_Reproductor :: [Bool]
test_Reproductor = [
    nuevoReproductor == RP [] [],
    archivosR (RP etiquetasTest temasTest) == etiquetasTest temasTest,
    listaParaR "pop" (RP etiquetasTest temasTest) == temasTest
    {-temasR (RP (etiquetasTest temasTest) temasTest) == temasTest,
    playR (RP etiquetasTest temasTest) "pop" == ,
    actualR (RP etiquetasTest temasTest) == actualP temasTest,
    avanzaR (RP etiquetasTest temasTest) == RP etiquetasTest temasTest (skipP temasTest),
    retrocedeR (RP etiquetasTest temasTest) == RP etiquetasTest temasTest (backP temasTest),
    reiniciaR (RP etiquetasTest temasTest) == RP etiquetasTest (resetP temasTest)-}
    ]

-}
