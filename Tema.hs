module Tema (Tema, nuevoT, nombreT, datosT, etiquetasT, agregarT, aplicaT)
    where
import Tipos
data Tema = Tem Nombre [ Etiqueta ] Datos deriving (Eq, Show, Ord)
--El tipo Datos representa la secuencia de datos que conforma el archivo mp3

nuevoT :: Nombre → Datos → Tema 
--nuevoT cancion datos = Tem cancion datos 
nombreT :: Tema → Nombre
datosT :: Tema → Datos
etiquetasT :: Tema → [ Etiqueta ]
agregarT :: Etiqueta → Tema →Tema
aplicaT :: Etiqueta →Tema →Bool --nos dice si esa etiqueta ya pertenece al tema

--generar las 6 funciones