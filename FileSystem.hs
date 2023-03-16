module FileSystem ( FileSystem, nuevoF, etiquetasF, temasF, agregarF, filtrarF )
    where
import Tipos
import Tema
data FileSystem = FS [Etiqueta] [Tema] deriving (Eq, Show)

nuevoF :: FileSystem
--Crea un nuevo FileSystem con sus listas vacias. (Crea una lista de listas vacías)
etiquetasF :: FileSystem → [ Etiqueta ]
--Crea la lista de etiquetas
temasF :: FileSystem → [ Tema ]
--Crea la listas de temas
agregarF :: Tema →FileSystem →FileSystem
--Agrega el tema y sus etiquetas de ser necesario.
filtrarF :: Etiqueta → FileSystem → [ Tema ]
--Le pasamos una etiqueta y nos dice la lista de temas con esa etiqueta. Usa las funciones de el file Tema.
