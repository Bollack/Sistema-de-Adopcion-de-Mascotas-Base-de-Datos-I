CREATE OR REPLACE TRIGGER BeforeInsertMascota
  BEFORE INSERT ON Administrador.Mascota FOR EACH ROW
    :new.Fecha_creacion:=sysdate;
    :new.Fecha_Modificacion:= sysdate;
END BeforeInsertMascota;
  
CREATE OR REPLACE TRIGGER BeforeUpdateMascota
  BEFARE UPDATE ON Administrador.Mascota FOR EACH ROW
    :newFecha_Modificacion:= sysdate;
END BeforeUpdateMascota;
  
CREATE OR REPLACE TRIGGER BeforeInsertTipoMascota
  BEFORE INSERT ON Administrador.Tipo_Mascota FOR EACH ROW
    :new.Fecha_creacion:=sysdate;
    :new.Fecha_Modificacion:= sysdate;
END BeforeInsertTipoMascota;
  
CREATE OR REPLACE TRIGGER BeforeUpdateTipoMascota
  BEFORE UPDATE ON Administrador.Tipo_Mascota FOR EACH ROW
    :new.Fecha_Modificacion:= sysdate;
END BeforeUpdateTipoMascota;

CREATE OR REPLACE TRIGGER BeforeInsertRazaMascota
  BEFORE INSERT ON Administrador.Raza_Mascota FOR EACH ROW
    :new.Fecha_creacion:=sysdate;
    :new.Fecha_Modificacion:= sysdate;
END BeforeInsertRazaMascota;
  
CREATE OR REPLACE TRIGGER BeforeUpdateRazaMascota
  BEFORE UPDATE ON Administrador.Raza_Mascota FOR EACH ROW
    :new.Fecha_Modificacion:= sysdate;
END  BeforeUpdateRazaMascota;

CREATE OR REPLACE TRIGGER BeforeInsertUsuario
  BUFORE INSERT ON Administrador.Usuario FOR EACH ROW
    :new.Usuario_creacion:=user;
    :new.Fecha_creacion:=sysdate;
    :new.Usuario_Modificacion:=user;
    :new.Fecha_Modificacion:= sysdate;
END BeforeInsertUsuario;
  
CREATE OR REPLACE TRIGGER BeforeUpdateUsuario
  BEFORE UPDATE ON Administrador.Usuario FOR EACH ROW
    :new.Usuario_Modificacion:=user;
    :new.Fecha_Modificacion:= sysdate;
END BeforeUpdateUsuario;

CREATE OR REPLACE TRIGGER BeforeInsertPersona
  BEFORE INSERT ON Administrador.Persona FOR EACH ROW
    :new.Usuario_creacion:=user;
    :new.Fecha_creacion:=sysdate;
    :new.Usuario_Modificacion:=user;
    :new.Fecha_Modificacion:= sysdate;
END BeforeInsertPersona;

CREATE OR REPLACE TRIGGER BeforeUpdatePersona
  BEFORE UPDATE ON Administrador.Persona FOR EACH ROW
    :new.Usuario_Modificacion:=user;
    :new.Fecha_Modificacion:= sysdate;
END BeforeUpdatePersona;

  --http://www.forosdelweb.com/f100/como-hacer-trigger-auditoria-oracle-578049/    CARLOS CACHE ESO
