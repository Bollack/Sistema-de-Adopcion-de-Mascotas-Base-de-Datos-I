--Mascota
CREATE OR REPLACE TRIGGER BeforeInsertMascota         --APLICADO
  BEFORE INSERT ON Administrador.Mascota FOR EACH ROW
  BEGIN
    :new.Fecha_creacion:=sysdate;
    :new.Fecha_Modificacion:= sysdate;
    SELECT id_mascota.NEXTVAL
    INTO   :new.ID
    FROM   dual;
  END;
  
CREATE OR REPLACE TRIGGER BeforeUpdateMascota         --APLICADO
  BEFORE UPDATE ON Administrador.Mascota FOR EACH ROW
  BEGIN
    :new.Fecha_Modificacion:= sysdate;
  END;
  
--Tipo Mascota
CREATE OR REPLACE TRIGGER BeforeInsertTipoMascota     --APLICADO
  BEFORE INSERT ON Administrador.Tipo_Mascota FOR EACH ROW
  BEGIN
    :new.Usuario_creacion:=user;
    :new.Usuario_Modificacion:=user;
    :new.Fecha_creacion:=sysdate;
    :new.Fecha_Modificacion:= sysdate;
  END;
  
CREATE OR REPLACE TRIGGER BeforeUpdateTipoMascota     --APLICADO
  BEFORE UPDATE ON Administrador.Tipo_Mascota FOR EACH ROW
  BEGIN
    :new.Fecha_Modificacion:= sysdate;
    :new.Usuario_Modificacion:=user;
  END;

--Raza Mascota
CREATE OR REPLACE TRIGGER BeforeInsertRazaMascota     --APLICADO
  BEFORE INSERT ON Administrador.Raza_Mascota FOR EACH ROW
  BEGIN
    :new.Fecha_creacion:=sysdate;
    :new.Fecha_Modificacion:= sysdate;
    :new.Usuario_creacion:=user;
    :new.Usuario_Modificacion:=user;
  END; 
  
CREATE OR REPLACE TRIGGER BeforeUpdateRazaMascota     --APLICADO
  BEFORE UPDATE ON Administrador.Raza_Mascota FOR EACH ROW
  BEGIN
    :new.Fecha_Modificacion:= sysdate;
    :new.Usuario_Modificacion:=user;
  END; 

--Usuario & Persona
--Usuario
CREATE OR REPLACE TRIGGER BeforeInsertUsuario         --APLICADO
  BEFORE INSERT ON Administrador.Usuario FOR EACH ROW
  BEGIN
    :new.Usuario_creacion:=user;
    :new.Fecha_creacion:=sysdate;
    :new.Usuario_Modificacion:=user;
    :new.Fecha_Modificacion:= sysdate;
  END;
  
CREATE OR REPLACE TRIGGER BeforeUpdateUsuario         --APLICADO
  BEFORE UPDATE ON Administrador.Usuario FOR EACH ROW
  BEGIN
    :new.Fecha_Modificacion:= sysdate;
  END;

--Persona
CREATE OR REPLACE TRIGGER BeforeInsertPersona         --APLICADO
  BEFORE INSERT ON Administrador.Persona FOR EACH ROW
  BEGIN
    :new.Usuario_creacion:=user;
    :new.Fecha_creacion:=sysdate;
    :new.Usuario_Modificacion:=user;
    :new.Fecha_Modificacion:= sysdate;
    SELECT id_persona.NEXTVAL
    INTO   :new.ID
    FROM   dual;
  END;

CREATE OR REPLACE TRIGGER BeforeUpdatePersona         --APLICADO
  BEFORE UPDATE ON Administrador.Persona FOR EACH ROW
  BEGIN
    :new.Fecha_Modificacion:= sysdate;
  END;
  
--Adopción  
CREATE OR REPLACE TRIGGER BeforeInsertAdopcion        --APLICADO
  BEFORE INSERT ON Administrador.Adopcion FOR EACH ROW
  BEGIN
    :new.Fecha_creacion:=sysdate;
    :new.Fecha_Modificacion:= sysdate;
    SELECT id_adopcion.NEXTVAL
    INTO   :new.ID
    FROM   dual;
  END;

CREATE OR REPLACE TRIGGER BeforeUpdateAdopcion        --APLICADO
  BEFORE UPDATE ON Administrador.Persona FOR EACH ROW
  BEGIN
    :new.Fecha_Modificacion:= sysdate;
  END;

--FOTOS ADOPCION
CREATE OR REPLACE TRIGGER BeforeInsertFotoAdopcion    --APLICADO
  BEFORE INSERT ON Administrador.Foto_adopcion FOR EACH ROW
  BEGIN
    :new.Fecha_creacion:=sysdate;
    :new.Fecha_Modificacion:= sysdate;
    SELECT id_foto_adopcion.NEXTVAL
    INTO   :new.id_foto_adopcion
    FROM   dual;
  END;

CREATE OR REPLACE TRIGGER BeforeUpdateFotoAdopcion    --APLICADO
  BEFORE UPDATE ON Administrador.Foto_adopcion FOR EACH ROW
  BEGIN
    :new.Fecha_Modificacion:= sysdate;
  END;
  
--Califica_a
CREATE OR REPLACE TRIGGER BeforeInsertCalificaA       --APLICADO
  BEFORE INSERT ON Administrador.Califica_a FOR EACH ROW
  BEGIN
	:new.Fecha_creacion:=sysdate;
    :new.Fecha_Modificacion:= sysdate;
    SELECT id_califica_a.NEXTVAL
    INTO   :new.id_calificacion
    FROM   dual;
  END;
  
CREATE OR REPLACE TRIGGER BeforeUpdateCalificaA       --APLICADO
  BEFORE UPDATE ON Administrador.Califica_a FOR EACH ROW
  BEGIN
    :new.Fecha_Modificacion:= sysdate;
  END;
  
--Agrega a lista negra
CREATE OR REPLACE TRIGGER BeforeInsertListaNegra      --APLICADO
  BEFORE INSERT ON Administrador.Agrega_a_Lista_Negra FOR EACH ROW
  BEGIN
	:new.Fecha_creacion:=sysdate;
    :new.Fecha_Modificacion:= sysdate;
    SELECT id_anade_a_lista_negra.NEXTVAL
    INTO   :new.id_agregado_lista_negra
    FROM   dual;
  END;
  
CREATE OR REPLACE TRIGGER BeforeUpdateListaNegra      --APLICADO
  BEFORE UPDATE ON Administrador.Agrega_a_Lista_Negra FOR EACH ROW
  BEGIN
	:new.Fecha_Modificacion:= sysdate;
  END;
  
--Devoluciones
CREATE OR REPLACE TRIGGER BeforeInsertDevoluciones    --APLICADO
  BEFORE INSERT ON Administrador.Devoluciones FOR EACH ROW
  BEGIN
    :new.Fecha_creacion:=sysdate;
    :new.Fecha_Modificacion:= sysdate;
    SELECT id_devolucion.NEXTVAL
    INTO   :new.id_devolucion
    FROM   dual;
  END;

CREATE OR REPLACE TRIGGER BeforeUpdateDevoluciones    --APLICADO
  BEFORE UPDATE ON Administrador.Devoluciones FOR EACH ROW
  BEGIN
	:new.Fecha_Modificacion:= sysdate;
  END;

--Respuesta
CREATE OR REPLACE TRIGGER BeforeInsertRespuesta       --APLICADO
  BEFORE INSERT ON Administrador.Respuesta FOR EACH ROW
  BEGIN
    :new.Fecha_creacion:=sysdate;
    :new.Fecha_Modificacion:= sysdate;
    SELECT id_respuesta.NEXTVAL
    INTO   :new.id_respuesta
    FROM   dual;
  END;

CREATE OR REPLACE TRIGGER BeforeUpdateRespuesta       --APLICADO
  BEFORE UPDATE ON Administrador.Respuesta FOR EACH ROW
  BEGIN
    :new.Fecha_Modificacion:= sysdate;
  END;

--Pregunta
CREATE OR REPLACE TRIGGER BeforeInsertPregunta        --APLICADO
  BEFORE INSERT ON Administrador.Pregunta FOR EACH ROW
  BEGIN
    :new.Fecha_creacion:=sysdate;
    :new.Fecha_Modificacion:= sysdate;
    SELECT id_pregunta.NEXTVAL
    INTO   :new.id_pregunta
    FROM   dual;
  END;
  
CREATE OR REPLACE TRIGGER BeforeUpdatePregunta        --APLICADO
  BEFORE UPDATE ON Administrador.Pregunta FOR EACH ROW
  BEGIN
    :new.Fecha_Modificacion:= sysdate;
  END;
  
--Formulario
CREATE OR REPLACE TRIGGER BeforeInsertFormulario      --APLICADO
  BEFORE INSERT ON Administrador.Formulario FOR EACH ROW
  BEGIN
    :new.Fecha_creacion:=sysdate;
    :new.Fecha_Modificacion:= sysdate;
    SELECT id_formulario.NEXTVAL
    INTO   :new.id_formulario
    FROM   dual;
  END;
  
CREATE OR REPLACE TRIGGER BeforeUpdateFormulario      --APLICADO
  BEFORE UPDATE ON Administrador.Formulario FOR EACH ROW
  BEGIN
    :new.Fecha_Modificacion:= sysdate;
  END;
  
--Bitacora
CREATE OR REPLACE TRIGGER BeforeInsertBitacora        --APLICADO
  BEFORE INSERT ON Administrador.Bitacora_mascotas FOR EACH ROW
  BEGIN
    :new.Fecha_creacion:=sysdate;
    :new.Fecha_Modificacion:= sysdate;
    SELECT id_bitacora.NEXTVAL
    INTO   :new.id_bitacora
    FROM   dual;
  END;

CREATE OR REPLACE TRIGGER BeforeUpdateBitacora        --APLICADO
  BEFORE UPDATE ON Administrador.Bitacora_mascotas FOR EACH ROW
  BEGIN
    :new.Fecha_Modificacion:= sysdate;
  END;


