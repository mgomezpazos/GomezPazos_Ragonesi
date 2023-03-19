module Playlist ( Playlist, nuevaP, actualP, skipP, backP, resetP )
    where
import Tipos
import Tema
data Playlist = Play Int [ Tema ] deriving (Eq, Show) --Una Playlist tiene una lista de temas y un entero que indica una posici´on en la lista.

--partir de una lista de temas crea una nueva Playlist con su ´ındice en cero. (Crea la Playlist)
nuevaP :: [ Tema ] →Playlist
nuevaP [Tem] = Play 0 [Tem]
--Dada una Playlist devuelve el tema en la posici´on indicada por el ´ındice. (Le pasamos el nombre de la playlist y el indice y nos devuelve la canción)
actualP :: Playlist →Tema
actualP Play num [Tem] = [Tem] !! num
--Devuelve una Playlist con su ´ındice aumentado en uno. (Pasa a la siguiente playlist)
skipP :: Playlist → Playlist
skipP (Play num [Tem]) = Play (num + 1) [Tem]
--Idem anterior pero con el ´ındice decrementado en uno.
backP :: Playlist → Playlist
backP (Play num [Tem]) = Play (num - 1) [Tem]
--Dada una Playlist crea una nueva con la lista de temas de la original.
resetP :: Playlist → Playlist
resetP Play _ [Tem] = Play 0 [Tem]