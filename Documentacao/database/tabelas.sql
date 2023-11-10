create table BICICLETA
(
    ID_BICICLETA NUMBER default 19 not null constraint BICICLETA primary key,
    NM_BICICLETA VARCHAR2(255),
    DONO VARCHAR(255)
);

create index "bicicleta_NM_CLIENTE_index"
    on BICICLETA (NM_BICICLETA);

create sequence SQ_BICICLETA;
create or replace trigger TG_SQ_BICICLETA
    before insert or update on BICICLETA
                                for each row begin
            if inserting and :new.ID_BICICLETA is null then
                :new.ID_BICICLETA := SQ_BICICLETA.nextval;
end if;
end;

create table CLIENTE
(
    ID_CLIENTE NUMBER default 19 not null constraint CLIENTE_PK primary key,
    NM_CLIENTE VARCHAR2(255),
    ENDERECO VARCHAR(250),
    NR_CPF VARCHAR(14)
);

create index "cliente_NM_CLIENTE_index"
    on CLIENTE (NM_CLIENTE);



create sequence SQ_CLIENTE;
create or replace trigger TG_SQ_CLIENTE
    before insert or update on CLIENTE
                                for each row begin
            if inserting and :new.ID_CLIENTE is null then
                :new.ID_CLIENTE := SQ_CLIENTE.nextval;
end if;
end;