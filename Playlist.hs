module Playlist ( Playlist, nuevaP, actualP, skipP, backP, resetP )
    where
import Tipos
import Tema
data Playlist = Play Int [ Tema ] deriving (Eq, Show) --Una Playlist tiene una lista de temas y un entero que indica una posici´on en la lista.

nuevaP :: [ Tema ] →Playlist
--partir de una lista de temas crea una nueva Playlist con su ´ındice en cero. (Crea la Playlist)
actualP :: Playlist →Tema
--Dada una Playlist devuelve el tema en la posici´on indicada por el ´ındice. (Le pasamos el nombre de la playlist y el indice y nos devuelve la canción)
skipP :: Playlist → Playlist
--Devuelve una Playlist con su ´ındice aumentado en uno. (Pasa a la siguiente playlist)
backP :: Playlist → Playlist
--Idem anterior pero con el ´ındice decrementado en uno.
resetP :: Playlist → Playlist
--Dada una Playlist crea una nueva con la lista de temas de la original.