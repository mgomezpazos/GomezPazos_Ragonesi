module FileSystem (FileSystem, nuevoF, etiquetasF, temasF {-agregarF, filtrarF-})
    where
import Tipos
import Tema
data FileSystem = FS [Etiqueta] [Tema] deriving (Eq, Show)

nuevoF :: FileSystem --Crea un nuevo FileSystem con sus listas vacias. (Crea una lista de listas vacías)
nuevoF = FS [] [] --no sé si está bien porque no me gusta como se imprime CHECKED
etiquetasF :: FileSystem -> [ Etiqueta ] --Crea la lista de etiquetas
etiquetasF (FS etiqueta tema) = etiqueta -- CHECKED!!!
temasF :: FileSystem -> [ Tema ] --Crea la listas de temas
temasF (FS _ tema) = tema
agregarF :: Tema -> FileSystem -> FileSystem --Agrega el tema y sus etiquetas de ser necesario.
agregarF nuevoT (FS etiqueta tema) = FS etiqueta (nuevoT : tema)
-- agregarT :: Etiqueta -> Tema -> Tema
-- agregarT etiqueta (Tem nombre etiquetas datos) = Tem nombre (etiquetas ++ [etiqueta]) datos 
-- filtrarF :: Etiqueta -> FileSystem -> [ Tema ] --Le pasamos una etiqueta y nos dice la lista de temas con esa etiqueta. Usa las funciones del file Tema.
-- filtrarF etiqueta (FS etiquetas [nuevoT]) | [aplicaT etiqueta [nuevoT]] == True = [nuevoT] --deberíamos usar temasF? aplicamos listas por comprensión?
--                                           | otherwise = []


{-


FileSystem (lo del tema de que era privado)

A lo que se referia Emilio era, que podemos construir cosas sin el constructor.

No Exportamos el CONSTRUCTOR, creando variables que pertenecen al mismo tipo.(*)

Eso se hace con las funciones de FileSystem --> nuevoF

-}