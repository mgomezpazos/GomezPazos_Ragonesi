module Tema (Tema, nuevoT, nombreT, datosT, etiquetasT,agregarT, aplicaT)
    where
import Tipos
data Tema = Tem Nombre [Etiqueta] Datos deriving (Eq,Show, Ord)


nuevoT :: Nombre -> Datos -> Tema 
nuevoT nombre = Tem nombre []

nombreT :: Tema -> Nombre
nombreT (Tem nombre _ _) = nombre

datosT :: Tema -> Datos
datosT (Tem _ _ datos) = datos

etiquetasT :: Tema -> [Etiqueta]
etiquetasT (Tem _ etiqueta _) = etiqueta

agregarT :: Etiqueta -> Tema -> Tema
agregarT etiqueta (Tem nombre etiquetas datos) = Tem nombre (etiquetas ++ [etiqueta]) datos

aplicaT :: Etiqueta -> Tema -> Bool --nos dice si esa etiqueta ya pertenece al tema
aplicaT etiqueta (Tem _ etiquetas _) = etiqueta `elem` etiquetas


-- TEST:
test_tema :: [Bool]
test_tema = [
    nuevoT "a" "b" == Tem "a" [] "b",
    nombreT (Tem "Borderline" ["indie", "alternative", "Tame Impala"] "Tame_Impala_Song") == "Borderline",
    datosT (Tem "Borderline" ["indie", "alternative", "Tame Impala"] "Tame_Impala_Song") == "Tame_Impala_Song",
    etiquetasT (Tem "Borderline" ["indie", "alternative", "Tame Impala"] "Tame_Impala_Song") == ["indie", "alternative", "Tame Impala"] ,
    agregarT "pop" (Tem "Borderline" ["indie", "alternative", "Tame Impala"] "Tame_Impala_Song") == Tem "Borderline" ["indie", "alternative", "Tame Impala", "pop"] "Tame_Impala_Song",
    aplicaT "indie" (Tem "Borderline" ["indie", "alternative", "Tame Impala"] "Tame_Impala_Song") == True
    ]

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- COMENTARIOS:
--El tipo Datos representa la secuencia de datos que conforma el archivo mp3
{-
 
nombres, [etiqueta], datos son strings, hay que pensarlos como un ALIAS. No son mas que strings
Tem es el constructor, me va a construir un tipo de dato Tema.
Para construir un valor con Tem, tengo que pasarle 3 elementos. Nombre [Etiqueta] Datos
Como la función no recibe Etiqueta, le puedo pasar listas con cero elementos
tema_1 = Tem(Nombre [Etiqueta] Datos)
-}
--nuevoT2 = Tem 