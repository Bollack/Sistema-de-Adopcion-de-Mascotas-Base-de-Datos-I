CREATE OR REPLACE TRIGGER BeforeInsertMascota
  BEFORE INSERT ON Administrador.Mascota FOR EACH ROW
    :new.Usuario_creacion:= user; --CAMBIAR
    :new.Fecha_creacion:=sysdate;
  END BeforeInsertMascota
  
CREATE OR REPLACE TRIGGER b
  :new.Usuario_Modificacion 
  :newFecha_Modificacion ,
  
  
  --http://www.forosdelweb.com/f100/como-hacer-trigger-auditoria-oracle-578049/    CARLOS CACHE ESO
