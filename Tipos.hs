module Tipos
    where
import Data.List (sort)

type Datos = String
type Etiqueta = String
type Nombre = String


insertar :: Ord a => a -> [a] -> [a] --Devuelve una lista con los elementos originales y el nuevo elemento, ordenados naturalmente.
insertar elemento lista = sort(reverse(elemento:reverse lista))


-- TEST:
test_tipos :: [Bool]
test_tipos = [
    
    insertar "b" ["a","c"] == ["a","b","c"]

    ]
