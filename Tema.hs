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
    aplicaT "indie" (Tem "Borderline" ["indie", "alternative", "Tame Impala"] "Tame_Impala_Song")
    ]