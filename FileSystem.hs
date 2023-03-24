module FileSystem (FileSystem, nuevoF, etiquetasF, temasF, agregarF, filtrarF)
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
agregarF cancion (FS etiqueta tema) = FS etiqueta (cancion : tema)

-- filtrarF :: Etiqueta -> FileSystem -> [ Tema ] --Le pasamos una etiqueta y nos dice la lista de temas con esa etiqueta. Usa las funciones del file Tema.
-- filtrarF etiqueta (FS etiquetas [nuevoT]) | [aplicaT etiqueta [nuevoT]] == True = [nuevoT] --deberíamos usar temasF? aplicamos listas por comprensión?
--                                           | otherwise = []

filtrarF :: Etiqueta -> FileSystem -> [Tema]
filtrarF etiqueta (FS etiquetas temas) = filter (\t -> etiqueta `elem` etiquetasTema t) temas
  where etiquetasTema t = foldr (\e acc -> if e `elem` etiquetasT t then e:acc else acc) [] etiquetas
-- filtrarF :: Etiqueta -> FileSystem -> [Tema]
-- filtrarF etiqueta (FS etiquetas temas) = filter (tieneEtiqueta etiqueta) temas
--   where
--     tieneEtiqueta :: Etiqueta -> Tema -> Bool
--     tieneEtiqueta etiqueta t = etiqueta `elem` t

--filtrarF etiqueta (FS etiquetas temas) = [x | x <- temas, aplicaT etiqueta x]

--filtrarF etiqueta (FS etiquetas temas) = foldr (\each acc -> if aplicaT etiqueta etiquetas then each:acc else acc) [] etiquetas
-- etiquetasT :: Tema -> [Etiqueta]
-- etiquetasT (Tem _ etiqueta _) = etiqueta
--foldr que compare si la etiqueta está en la lista de etiquetas, si está se une a la lista vacía, sino no. 
{-

FileSystem (lo del tema de que era privado)

A lo que se referia Emilio era, que podemos construir cosas sin el constructor.

No Exportamos el CONSTRUCTOR, creando variables que pertenecen al mismo tipo.(*)

Eso se hace con las funciones de FileSystem --> nuevoF

-}