--Mascota

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
  
--Tipo Mascota

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

--Raza Mascota

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

--Usuario & Persona
--Usuario
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
    :new.Fecha_Modificacion:= sysdate;
  END;

--Persona

CREATE OR REPLACE TRIGGER BeforeInsertPersona --APLICADO 
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

CREATE OR REPLACE TRIGGER BeforeUpdatePersona --APLICADO
  BEFORE UPDATE ON Administrador.Persona FOR EACH ROW
  BEGIN
    :new.Fecha_Modificacion:= sysdate;
  END;
  
--Adopción  
  
CREATE OR REPLACE TRIGGER BeforeInsertAdopcion --APLICADO
  BEFORE INSERT ON Administrador.Adopcion FOR EACH ROW
  BEGIN
    :new.Fecha_creacion:=sysdate;
    :new.Fecha_Modificacion:= sysdate;
    SELECT id_adopcion.NEXTVAL
    INTO   :new.ID
    FROM   dual;
  END;

CREATE OR REPLACE TRIGGER BeforeUpdateAdopcion --APLICADO
  BEFORE UPDATE ON Administrador.Persona FOR EACH ROW
  BEGIN
    :new.Fecha_Modificacion:= sysdate;
  END;

CREATE OR REPLACE TRIGGER BeforeInsertFotoAdopcion
  BEFORE INSERT ON Administrador.Foto_adopcion FOR EACH ROW
  BEGIN
    :new.Fecha_creacion:=sysdate;
    :new.Fecha_Modificacion:= sysdate;
    SELECT id_foto_adopcion.NEXTVAL
    INTO   :new.id_foto_adopcion
    FROM   dual;
  END;

CREATE OR REPLACE TRIGGER BeforeUpdateFotoAdopcion
  BEFORE UPDATE ON Administrador.Foto_adopcion FOR EACH ROW
  BEGIN
    :new.Fecha_Modificacion:= sysdate;
  END;
  
--Califica_a
CREATE OR REPLACE TRIGGER BeforeInsertCalificaA
  BEFORE INSERT ON Administrador.Califica_a FOR EACH ROW
  BEGIN
	:new.Fecha_creacion:=sysdate;
    :new.Fecha_Modificacion:= sysdate;
    SELECT id_califica_a.NEXTVAL
    INTO   :new.id_calificacion
    FROM   dual;
  END;
  
CREATE OR REPLACE TRIGGER BeforeUpdateCalificaA
  BEFORE UPDATE ON Administrador.Califica_a FOR EACH ROW
  BEGIN
    :new.Fecha_Modificacion:= sysdate;
  END;
  
--Agrega a lista negra
CREATE OR REPLACE TRIGGER BeforeInsertListaNegra
  BEFORE INSERT ON Administrador.Agrega_a_Lista_Negra FOR EACH ROW
  BEGIN
	:new.Fecha_creacion:=sysdate;
    :new.Fecha_Modificacion:= sysdate;
    SELECT id_anade_a_lista_negra.NEXTVAL
    INTO   :new.id_agregado_lista_negra
    FROM   dual;
  END;
  
CREATE OR REPLACE TRIGGER BeforeUpdateListaNegra
  BEFORE UPDATE ON Administrador.Agrega_a_Lista_Negra FOR EACH ROW
  BEGIN
	:new.Fecha_Modificacion:= sysdate;
  END;
  
--Devoluciones
CREATE OR REPLACE TRIGGER BeforeInsertDevoluciones
  BEFORE INSERT ON Administrador.Devoluciones FOR EACH ROW
  BEGIN
	:new.Fecha_creacion:=sysdate;
    :new.Fecha_Modificacion:= sysdate;
    SELECT id_devolucion.NEXTVAL
    INTO   :new.id_devolucion
    FROM   dual;
  END;

CREATE OR REPLACE TRIGGER BeforeUpdateDevoluciones
  BEFORE UPDATE ON Administrador.Devoluciones FOR EACH ROW
  BEGIN
	:new.Fecha_Modificacion:= sysdate;
  END;

--Respuesta
CREATE OR REPLACE TRIGGER  BeforeInsertRespuesta
  BEFORE INSERT ON Administrador.Respuesta FOR EACH ROW
  BEGIN
	:new.Fecha_creacion:=sysdate;
    :new.Fecha_Modificacion:= sysdate;
    SELECT id_respuesta.NEXTVAL
    INTO   :new.id_respuesta
    FROM   dual
  END;
  
CREATE OR REPLACE TRIGGER BeforeUpdateRespuesta
  BEFORE UPDATE ON Administrador.Respuesta FOR EACH ROW
  BEGIN
	:new.Fecha_Modificacion:= sysdate;
  END;

--Pregunta
CREATE OR REPLACE TRIGGER BeforeInsertPregunta
  BEFORE INSERT ON Administrador.Pregunta FOR EACH ROW
  BEGIN
	:new.Fecha_creacion:=sysdate;
    :new.Fecha_Modificacion:= sysdate;
    SELECT id_pregunta.NEXTVAL
    INTO   :new.id_pregunta
    FROM   dual
  END;
  
CREATE OR REPLACE TRIGGER BeforeUpdatePregunta
  BEFORE UPDATE ON Administrador.Pregunta FOR EACH ROW
  BEGIN
	:new.Fecha_Modificacion:= sysdate;
  END;
  
  
--Formulario
CREATE OR REPLACE TRIGGER BeforeInsertFormulario
  BEFORE INSERT ON Administrador.Formulario FOR EACH ROW
  BEGIN
	:new.Fecha_creacion:=sysdate;
    :new.Fecha_Modificacion:= sysdate;
    SELECT id_formulario.NEXTVAL
    INTO   :new.id_formulario
    FROM   dual
  END;
  
CREATE OR REPLACE TRIGGER BeforeUpdateFormulario
  BEFORE UPDATE ON Administrador.Formulario FOR EACH ROW
  BEGIN
	:new.Fecha_Modificacion:= sysdate;
  END;
  
  

