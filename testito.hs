module Tema (Tema) --aplicaT, agregarT, nuevoT nombreT,etiquetasT)
    where

import Tipos
data Tema = Tem Nombre [Etiqueta] Datos deriving (Eq,Show, Ord)
--El tipo Datos representa la secuencia de datos que conforma el archivo mp3
{-
 
nombres, [etiqueta], datos son strings, hay que pensarlos como un ALIAS. No son mas que strings
Tem es el constructor, me va a construir un tipo de dato Tema.
Para construir un valor con Tem, tengo que pasarle 3 elementos. Nombre [Etiqueta] Datos
Como la función no recibe Etiqueta, le puedo pasar listas con cero elementos
tema_1 = Tem(Nombre [Etiqueta] Datos)
-}
--nuevoT :: Nombre -> Datos -> Tema 
--nuevoT nombre datos = Tem nombre [] datos

--nombreT :: Tema -> Nombre
--nombreT (Tem nombre _ _) = nombre

--etiquetasT :: Tema -> [Etiqueta]
--etiquetasT (Tem _ [etiqueta] _) = [etiqueta] 
--agregarT :: Etiqueta -> Tema -> Tema
--agregarT etiqueta (Tem nombre etiquetas datos) = Tem nombre (etiquetas ++ [etiqueta]) datos

--aplicaT :: Etiqueta -> Tema -> Bool --nos dice si esa etiqueta ya pertenece al tema
--aplicaT etiqueta (Tem _ etiquetas _) = etiqueta `elem` etiquetas