CREATE OR REPLACE TRIGGER BeforeInsertMascota --APLICADO
  BEFORE INSERT ON Administrador.Mascota FOR EACH ROW
  BEGIN
    :new.Fecha_creacion:=sysdate;
    :new.Fecha_Modificacion:= sysdate;
    SELECT id_mascota.NEXTVAL
    INTO   :new.ID
    FROM   dual;
  END;
  
CREATE OR REPLACE TRIGGER BeforeUpdateMascota --APLICADO
  BEFORE UPDATE ON Administrador.Mascota FOR EACH ROW
  BEGIN
    :new.Fecha_Modificacion:= sysdate;
  END;
  
CREATE OR REPLACE TRIGGER BeforeInsertTipoMascota --APLICADO
  BEFORE INSERT ON Administrador.Tipo_Mascota FOR EACH ROW
  BEGIN
    :new.Usuario_creacion:=user;
    :new.Usuario_Modificacion:=user;
    :new.Fecha_creacion:=sysdate;
    :new.Fecha_Modificacion:= sysdate;
  END;
  
CREATE OR REPLACE TRIGGER BeforeUpdateTipoMascota --APLICADO
  BEFORE UPDATE ON Administrador.Tipo_Mascota FOR EACH ROW
  BEGIN
    :new.Fecha_Modificacion:= sysdate;
    :new.Usuario_Modificacion:=user;
  END;

CREATE OR REPLACE TRIGGER BeforeInsertRazaMascota --APLICADO
  BEFORE INSERT ON Administrador.Raza_Mascota FOR EACH ROW
  BEGIN
    :new.Fecha_creacion:=sysdate;
    :new.Fecha_Modificacion:= sysdate;
    :new.Usuario_creacion:=user;
    :new.Usuario_Modificacion:=user;
  END; 
  
CREATE OR REPLACE TRIGGER BeforeUpdateRazaMascota --APLICADO
  BEFORE UPDATE ON Administrador.Raza_Mascota FOR EACH ROW
  BEGIN
    :new.Fecha_Modificacion:= sysdate;
    :new.Usuario_Modificacion:=user;
  END; 

CREATE OR REPLACE TRIGGER BeforeInsertUsuario --APLICADO
  BEFORE INSERT ON Administrador.Usuario FOR EACH ROW
  BEGIN
    :new.Usuario_creacion:=user;
    :new.Fecha_creacion:=sysdate;
    :new.Usuario_Modificacion:=user;
    :new.Fecha_Modificacion:= sysdate;
  END;
  
CREATE OR REPLACE TRIGGER BeforeUpdateUsuario --APLICADO
  BEFORE UPDATE ON Administrador.Usuario FOR EACH ROW
  BEGIN
    :new.Usuario_Modificacion:=user;
    :new.Fecha_Modificacion:= sysdate;
  END;

CREATE OR REPLACE TRIGGER BeforeInsertPersona --APLICADO
  BEFORE INSERT ON Administrador.Persona FOR EACH ROW
  BEGIN
    :new.Usuario_creacion:=user;
    :new.Fecha_creacion:=sysdate;
    :new.Usuario_Modificacion:=user;
    :new.Fecha_Modificacion:= sysdate;
  END;

CREATE OR REPLACE TRIGGER BeforeUpdatePersona --APLICADO
  BEFORE UPDATE ON Administrador.Persona FOR EACH ROW
  BEGIN
    :new.Usuario_Modificacion:=user;
    :new.Fecha_Modificacion:= sysdate;
  END;

