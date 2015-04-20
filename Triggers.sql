CREATE OR REPLACE TRIGGER BeforeInsertMascota
  BEFORE INSERT ON Administrador.Mascota FOR EACH ROW
    :new.Fecha_creacion:=sysdate;
    :new.Fecha_modificacion:= sysdate;
END BeforeInsertMascota;
  
CREATE OR REPLACE TRIGGER BeforeUpdateMascota
  BEFARE UPDATE ON Administrador.Mascota FOR EACH ROW
    :newFecha_Modificacion:= sysdate;
END BeforeUpdateMascota;
  
CREATE OR REPLACE TRIGGER BeforeInsertTipoMascota
  BEFORE INSERT ON Administrador.Tipo_Mascota FOR EACH ROW
    :new.Fecha_creacion:=sysdate;
    :new.Fecha_modificacion:= sysdate;
END BeforeInsertTipoMascota;
  
CREATE OR REPLACE TRIGGER BeforeUpdateTipoMascota
  BEFORE UPDATE ON Administrador.Tipo_Mascota FOR EACH ROW
    :new.Fecha_modificacion:= sysdate;
END BeforeUpdateTipoMascota;

CREATE OR REPLACE TRIGGER BeforeInsertRazaMascota
  BEFORE INSERT ON Administrador.Raza_Mascota FOR EACH ROW
    :new.Fecha_creacion:=sysdate;
    :new.Fecha_modificacion:= sysdate;
END BeforeInsertRazaMascota;
  
CREATE OR REPLACE TRIGGER BeforeUpdateRazaMascota
  BEFORE UPDATE ON Administrador.Raza_Mascota FOR EACH ROW
    :new.Fecha_modificacion:= sysdate;
END  BeforeUpdateRazaMascota;
  
  --http://www.forosdelweb.com/f100/como-hacer-trigger-auditoria-oracle-578049/    CARLOS CACHE ESO
