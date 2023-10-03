create table BICICLETA
(
    ID_BICICLETA NUMBER default 19 not null constraint BICICLETA primary key,
    NM_BICICLETA VARCHAR2(255)
);

create index "bicicleta_NM_CLIENTE_index"
    on BICICLETA (NM_BICICLETA);