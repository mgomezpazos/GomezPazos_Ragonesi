module FileSystem (FileSystem, nuevoF, etiquetasF, temasF, agregarF, filtrarF)
    where
import Tipos
import Tema
data FileSystem = FS [Etiqueta] [Tema] deriving (Eq, Show)

nuevoF :: FileSystem --Crea un nuevo FileSystem con sus listas vacias. (Crea una lista de listas vacías)
nuevoF = FS [] [] 

etiquetasF :: FileSystem -> [ Etiqueta ] --Crea la lista de etiquetas
etiquetasF (FS etiqueta tema) = etiqueta -- CHECKED!!!

temasF :: FileSystem -> [ Tema ] --Crea la listas de temas
temasF (FS _ tema) = tema

agregarF :: Tema -> FileSystem -> FileSystem --Agrega el tema y sus etiquetas de ser necesario.
agregarF cancion (FS etiqueta tema) = FS etiqueta (cancion : tema)

filtrarF :: Etiqueta -> FileSystem -> [Tema]
filtrarF etiqueta (FS etiquetas tema) = filter (\t -> etiqueta `elem` generosMusicales t) tema
  where generosMusicales t = foldr (\each acc -> if each `elem` etiquetasT t then each:acc else acc) [] etiquetas

-- TEST:
nuevoFileSystem :: FileSystem
nuevoFileSystem = nuevoF
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

test_FileSystem :: [Bool]
test_FileSystem = [
    nuevoFileSystem == FS [] [],
    etiquetasF (FS etiquetasTest temasTest ) == etiquetasTest,
    temasF (FS etiquetasTest temasTest )== temasTest,
    agregarF cancionTest4 (FS etiquetasTest temasTest) == FS etiquetasTest [cancionTest4, cancionTest1, cancionTest2, cancionTest3],
    filtrarF "pop" (FS etiquetasTest [agregarT "pop" cancionTest2]) == [agregarT "pop" cancionTest2]
    ]
