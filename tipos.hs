module Tipos
    where
import Data.List (sort)

type Datos = String
type Etiqueta = String
type Nombre = String

-- FUNCION:

insertar :: Ord a => a -> [a] -> [a] 
insertar elemento lista = sort(reverse(elemento:reverse lista))

-- TEST:
test_tipos :: [Bool]
test_tipos = [
    
    insertar "b" ["a","c"] == ["a","b","c"]

    ]

---------------------------------------------------------------------------------------------------------------------------------------------------
-- COMENTARIOS:
--que entrega una nueva lista con los elementos originales y el agregado ordenados naturalmente.
--insertar x xs  = [flip(x : xs)]

--(+++) xs = foldr pegarAtras xs . reverse

{-agregar :: a -> [[a]] -> [[a]]
agregar x xss = [x : ys | ys <- xss] ++ xss-}

-- Hay que repensarla
-- Porque lo que hace es appendea lo que necesitas pero ordenado dentro.
-- Si la lista es [1,3] y le appendeo un 2
-- Que me quede [1,2,3]