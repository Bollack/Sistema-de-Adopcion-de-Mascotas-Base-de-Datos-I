CREATE OR REPLACE TRIGGER BeforeInsertMascota
  BEFORE INSERT ON Administrador.Mascota FOR EACH ROW
    :new.Usuario_creacion:= user; --CAMBIAR
    :new.Fecha_creacion:=sysdate;
    :new.Usuario_Modificacion:= user; --Cambiar
    :new.Fecha_modificacion:= sysdate;
END BeforeInsertMascota;
  
CREATE OR REPLACE TRIGGER BeforeUpdateMascota
  BEFARE UPDATE ON Administrador.Mascota FOR EACH ROW
    :new.Usuario_Modificacion:= user;--Cambiar
    :newFecha_Modificacion:= sysdate;
END BeforeUpdateMascota;
  
  
  --http://www.forosdelweb.com/f100/como-hacer-trigger-auditoria-oracle-578049/    CARLOS CACHE ESO
