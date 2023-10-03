create sequence SQ_BICICLETA;
create or replace trigger TG_SQ_BICICLETA
    before insert or update on BICICLETA
                                for each row begin
            if inserting and :new.ID_BICICLETA is null then
                :new.ID_BICICLETA := SQ_BICICLETA.nextval;
end if;
end;