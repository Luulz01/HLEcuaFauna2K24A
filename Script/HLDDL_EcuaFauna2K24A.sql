-- database: ../DataBase/HLEcuaFauna2K24A.sqlite
/*
CopyRight
autor: lizeth
Fecha: 17jul2k14
description: crear las estructuras de las entidades de exoBot
*/



DROP TABLE IF EXISTS HLHormiga;
DROP TABLE IF EXISTS HLAlimento;
DROP TABLE IF EXISTS HLCatalogo;
DROP TABLE IF EXISTS HLCatalogoTipo;


CREATE TABLE HLCatalogoTipo 
(
    IdCatalogoTipo          INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Nombre                 VARCHAR(50) NOT NULL UNIQUE
    ,Descripcion            VARCHAR(100)  

    ,Estado                 VARCHAR     NOT NULL DEFAULT('A')
    ,FechaCreacion          DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica          DATETIME    
);

CREATE TABLE HLCatalogo
(
    IdCatalogo              INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdCatalogoTipo         INTEGER     NOT NULL REFERENCES HLCatalogoTipo(IdCatalogoTipo)
    ,Nombre                 VARCHAR(50) NOT NULL UNIQUE
    ,Descripcion            VARCHAR(100)  

    ,Estado                 VARCHAR     NOT NULL DEFAULT('A')
    ,FechaCreacion          DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica          DATETIME    
);



CREATE TABLE HLHormiga
(
    IdHormiga                   INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdCatalogoRegion           INTEGER     NOT NULL REFERENCES HLCatalogo(IdCatalogo)
    ,IdCatalogoProvincia        INTEGER     NOT NULL REFERENCES HLCatalogo(IdCatalogo)
    ,IdCatalogoSexo             INTEGER     NOT NULL REFERENCES HLCatalogo(IdCatalogo)
    ,IdCatalogoIngestaNativa    INTEGER     NOT NULL REFERENCES HLCatalogo(IdCatalogo)
    ,IdCatalogoGenoAlimento     INTEGER     NOT NULL REFERENCES HLCatalogo(IdCatalogo)
    ,TipoHormiga                VARCHAR(200)

    ,Estado                     VARCHAR     NOT NULL DEFAULT('A')
    ,FechaCreacion              DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica              DATETIME    
);
