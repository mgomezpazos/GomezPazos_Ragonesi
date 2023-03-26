module Playlist ( Playlist, nuevaP, actualP, skipP, backP, resetP )
    where
import Tipos
import Tema
data Playlist = Play Int [ Tema ] deriving (Eq, Show) --Una Playlist tiene una lista de temas y un entero que indica una posición en la lista.


nuevaP :: [ Tema ] -> Playlist --A partir de una lista de temas, crea una nueva Playlist con su índice en cero. 
nuevaP = Play 0 -- tested!!

actualP :: Playlist -> Tema --Dada una Playlist devuelve el tema en la posición indicada por el índice.
actualP (Play songnum temas) = temas !! songnum --tested!!

skipP :: Playlist -> Playlist --Devuelve una Playlist con su índice aumentado en uno.
skipP (Play songnum temas) = Play (songnum + 1) temas -- tested!!

backP :: Playlist -> Playlist --Idem anterior pero con el índice decrementado en uno.
backP (Play songnum temas) = Play (songnum - 1) temas --tested!!

resetP :: Playlist -> Playlist --Dada una Playlist crea una nueva con la lista de temas de la original.
resetP (Play songnum temas) = Play 0 temas --tested!!


-- TEST:
cancionTest1 :: Tema
cancionTest1 = nuevoT "Borderline" "Tame_Impala_music"
cancionTest2 :: Tema
cancionTest2 = nuevoT "Despacito" "Des-pa-cito"
cancionTest3 :: Tema
cancionTest3 = nuevoT "Eternal Summer" "The_Strokes_Song"

test_tema :: [Bool]
test_tema = [
    nuevaP [cancionTest1, cancionTest2, cancionTest3] == Play 0 [cancionTest1, cancionTest2, cancionTest3],
    actualP (Play 2 [cancionTest1, cancionTest2, cancionTest3]) == cancionTest3,
    skipP (Play 1 [cancionTest1, cancionTest2, cancionTest3]) == Play 2 [cancionTest1, cancionTest2, cancionTest3],
    backP (Play 1 [cancionTest1, cancionTest2, cancionTest3]) == Play 0 [cancionTest1, cancionTest2, cancionTest3],
    resetP (Play 1 [cancionTest1, cancionTest2, cancionTest3]) == Play 0 [cancionTest1, cancionTest2, cancionTest3]
    ] 


--Play 0 [Tem "Borderline" [] "Tame_Impala_Music", Tem "Despacito" [] "Des-pa-cito", Tem "Eternal Summer" [] "The_Strokes_Song"],