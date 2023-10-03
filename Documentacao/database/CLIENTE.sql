create table CLIENTE
(
    ID_CLIENTE NUMBER default 19 not null constraint CLIENTE_PK primary key,
    NM_CLIENTE VARCHAR2(255)
);

create index "cliente_NM_CLIENTE_index"
    on CLIENTE (NM_CLIENTE);

drop table CLIENTE