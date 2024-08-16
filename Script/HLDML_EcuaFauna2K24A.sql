-- database: ../DataBase/HLEcuaFauna2K24A.sqlite
/*
CopyRight
autor: lizeth
Fecha: 16/08/2024
description: crear las estructuras de las entidades de exoBot
*/

INSERT INTO HLCatalogoTipo
(Nombre             ,  Descripcion) VALUES
('Pais'             , 'Pais')                       --1
,('Region'          , 'Lista regiones Ecuador')     --2
,('Provincia'       , 'Lista provincias Ecuador')   --3
,('Sexo'            , 'Lista sexos')                --4
,('IngestaNativa'   , 'Lista ingestas nativas')     --5
,('GenoAlimento'    , 'Lista geno alimentos');      --6

INSERT INTO HLCatalogo
(IdCatalogoTipo      ,Nombre                    , Descripcion   ) VALUES
 (  1                ,'Ecuador'                 , 'País de América del Sur' ) --1

,(  2                ,'Costa'                   , 'Región de Ecuador' ) --2
,(  2                ,'Sierra'                  , 'Región de Ecuador' ) --3
,(  2                ,'Oriente'                 , 'Región de Ecuador' ) --4
,(  2                ,'Galapagos'               , 'Región de Ecuador' ) --5

,(  3                ,'Azuay'                   , 'Provincia del Ecuador' ) --6
,(  3                ,'Bolivar'                 , 'Provincia del Ecuador' ) --7
,(  3                ,'Cañar'                   , 'Provincia del Ecuador' ) --8
,(  3                ,'Carchi'                  , 'Provincia del Ecuador' ) --9
,(  3                ,'Chimborazo'              , 'Provincia del Ecuador' ) --10
,(  3                ,'Cotopaxi'                , 'Provincia del Ecuador' ) --11
,(  3                ,'El Oro'                  , 'Provincia del Ecuador' ) --12
,(  3                ,'Esmeraldas'              , 'Provincia del Ecuador' ) --13
,(  3                ,'Galápagos'               , 'Provincia del Ecuador' ) --14
,(  3                ,'Guayanas'                , 'Provincia del Ecuador' ) --15
,(  3                ,'Imbabura'                , 'Provincia del Ecuador' ) --16
,(  3                ,'Loja'                    , 'Provincia del Ecuador' ) --17
,(  3                ,'Los Ríos'                , 'Provincia del Ecuador' ) --18
,(  3                ,'Manabi'                  , 'Provincia del Ecuador' ) --19
,(  3                ,'Morona Santiago'         , 'Provincia del Ecuador' ) --20
,(  3                ,'Napo'                    , 'Provincia del Ecuador' ) --21
,(  3                ,'Sucumbíos'               , 'Provincia del Ecuador' ) --22
,(  3                ,'Pastaza'                 , 'Provincia del Ecuador' ) --23
,(  3                ,'Pichincha'               , 'Provincia del Ecuador' ) --24
,(  3                ,'Santa Elena'             , 'Provincia del Ecuador' ) --25
,(  3                ,'Santo Domingo'           , 'Provincia del Ecuador' ) --26
,(  3                ,'Francisco de Orellana'   , 'Provincia del Ecuador' ) --27
,(  3                ,'Tungurahua'              , 'Provincia del Ecuador' ) --28
,(  3                ,'Zamora Chinchipe'        , 'Provincia del Ecuador' ) --29

,(  4                ,'Macho'                   , 'tipo de sexo' )     --30
,(  4                ,'Hembra'                  , 'tipo de sexo' )     --31
,(  4                ,'Asexual'                 , 'tipo de sexo' )     --32

,(  5                ,'Carnivoro'               , 'tipo de ingesta')    --33
,(  5                ,'Herbivoro'               , 'tipo de ingesta')    --34
,(  5                ,'Omnivoro'                , 'tipo de ingesta')    --35
,(  5                ,'Insectivoro'             , 'tipo de ingesta')    --36
,(  5                ,'Nectarivoro'             , 'tipo de ingesta')    --37

,(  6                ,'X'                       , 'tipo de geno alimento')    --38
,(  6                ,'XY'                      , 'tipo de geno alimento')    --39
,(  6                ,'XX'                      , 'tipo de geno alimento');   --40



INSERT INTO HLHormiga
 (IdCatalogoRegion  , IdCatalogoProvincia   , IdCatalogoSexo    , IdCatalogoIngestaNativa   ,IdCatalogoGenoAlimento , TipoHormiga   ) VALUES
 (  2               , 6                     , 30                , 33                        , 39                    , 'Soldado'     )
,(  3               , 7                     , 30                , 34                        , 40                    , 'Rastreadora' )
,(  4               , 8                     , 30                , 35                        , 39                    , 'Zangano'     )
,(  5               , 9                     , 31                , 36                        , 40                    , 'Reina'       )
,(  2               , 10                    , 31                , 37                        , 38                    , 'Larva'       );              