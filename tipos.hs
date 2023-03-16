module Tipos (insertar)
    where
type Datos = String
type Etiqueta = String
type Nombre = String

insertar :: Ord a => a -> [a] -> [a] 
--que entrega una nueva lista con los elementos originales y el agregado ordenados naturalmente.
--insertar x xs  = [flip(x : xs)]
insertar elemento lista = reverse(elemento:reverse(lista))

--(+++) xs = foldr pegarAtras xs . reverse

{-agregar :: a -> [[a]] -> [[a]]
agregar x xss = [x : ys | ys <- xss] ++ xss-}