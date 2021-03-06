CREATE OR REPLACE PACKAGE Procesos AS

  PROCEDURE actualizar_adopcion(pID_Adoptante IN NUMBER, pID_Rescatista IN NUMBER, pEstado IN VARCHAR2);
  PROCEDURE agregar_lista_negra(pID_Adoptante IN NUMBER, pID_Rescatista IN NUMBER);
  PROCEDURE calificar_adoptante(pId_adoptante IN NUMBER, pId_rescatista IN NUMBER, pCalificacion IN NUMBER, pNotas IN VARCHAR2);
  PROCEDURE devolver_mascota(pId IN NUMBER, pMotivo IN VARCHAR2);
  
  PROCEDURE insert_mascota(pUsuario IN VARCHAR2, pNombre IN VARCHAR2, pTipo IN VARCHAR2,
                      pRaza IN VARCHAR2, pColor1 IN VARCHAR2, pColor2 IN VARCHAR2, pEspacioRequerido IN VARCHAR2,
                      pTamano IN VARCHAR2, pFacilidadEntrenamiento IN VARCHAR2, pNivelEnergia IN VARCHAR2,
                      pSexo IN VARCHAR2, pVeterinario IN VARCHAR2, pMedicamentos IN VARCHAR2, pEnfermedades IN VARCHAR2,
                      pNotas IN VARCHAR2, pTratamientos IN VARCHAR2, pSituacion IN VARCHAR2,
                      pSeveridad IN VARCHAR2, pFotoAntes IN BLOB, pFotoDespues IN BLOB);
                      
  PROCEDURE insert_persona(pNombre IN VARCHAR2, pApellido IN VARCHAR2, pTelefono IN VARCHAR2, pEmail IN VARCHAR2, pLugar IN VARCHAR2, pUsuario IN VARCHAR2, pGenero IN VARCHAR2);
  PROCEDURE insert_user(pUsername IN VARCHAR2, pPassword IN VARCHAR2);
  PROCEDURE Insert_User_Persona(pUsername IN VARCHAR2, pPassword IN VARCHAR2,pNombre IN VARCHAR2, --COMPILADO
                        pApellido IN VARCHAR2, pTelefono IN VARCHAR2, pEmail IN VARCHAR2, pDireccion IN VARCHAR2, pGenero IN VARCHAR2);
  PROCEDURE peticion_adopcion(pId_adoptante IN NUMBER, pId_rescatista IN NUMBER, pId_Mascota IN NUMBER);
  
  PROCEDURE update_mascota(pId IN NUMBER, pUsuario in VARCHAR2, pNombre IN VARCHAR2, pTipo IN VARCHAR2,
                          pRaza IN VARCHAR2, pColor1 IN VARCHAR2, pColor2 IN VARCHAR2, pEspacioRequerido IN VARCHAR2,
                          pTamano IN VARCHAR2, pFacilidadEntrenamiento IN VARCHAR2, pNivelEnergia IN VARCHAR2,
                          pSexo IN VARCHAR2, pVeterinario IN VARCHAR2, pMedicamentos IN VARCHAR2, pEnfermedades IN VARCHAR2,
                          pNotas IN VARCHAR2, pTratamientos IN VARCHAR2, pSituacion IN VARCHAR2,
                          pSeveridad IN VARCHAR2, pFotoAntes IN BLOB, pFotoDespues IN BLOB);

  PROCEDURE update_persona(pUsername IN VARCHAR2, pNombre IN VARCHAR2, pApellido IN VARCHAR2,
                          pTelefono IN VARCHAR2, pEmail IN VARCHAR2, pLugar IN VARCHAR2, pGenero IN VARCHAR2);
    
  PROCEDURE update_user (pUsername IN VARCHAR2, pPassword IN VARCHAR2);
  PROCEDURE Update_User_Persona(pUsername IN VARCHAR2, pPassword IN VARCHAR2, pNombre IN VARCHAR2,
                                pApellido IN VARCHAR2, pTelefono IN VARCHAR2, pCorreo IN VARCHAR2, pLugar IN VARCHAR2, pGenero IN VARCHAR2);
  
END Procesos;

CREATE OR REPLACE PACKAGE BODY Procesos AS

  PROCEDURE actualizar_adopcion(pId_adoptante IN NUMBER, pId_rescatista IN NUMBER,
  pEstado IN VARCHAR2) AS
  vId_adopcion NUMBER;
  vId_mascota NUMBER;
  CURSOR buscar_adopcion IS SELECT id_adopcion FROM adopcion WHERE persona = pId_adoptante AND rescatista = pId_rescatista;
  BEGIN
    OPEN buscar_adopcion;
    FETCH buscar_adopcion INTO vId_adopcion;
    CLOSE buscar_adopcion;
    UPDATE adopcion
    SET estado = pEstado
    WHERE id_adopcion = vId_adopcion;
    IF(pEstado='Aceptada')THEN
      SELECT mascota INTO vId_mascota FROM adopcion WHERE id_adopcion = vId_adopcion;
      INSERT INTO bitacora_mascotas (id_mascota, id_persona, tipo, fecha) VALUES (vId_mascota, pId_adoptante, 'Adopción', SYSDATE);
    END IF;
    EXCEPTION
    WHEN OTHERS THEN
    ROLLBACK;
  END;
  
  PROCEDURE agregar_Lista_Negra(pId_adoptante IN NUMBER, pId_rescatista IN NUMBER) AS
  CURSOR relacion IS SELECT id_adopcion FROM adopcion WHERE persona = pId_adoptante AND rescatista = pID_rescatista;
  BEGIN
    OPEN relacion;
    IF (relacion%FOUND) THEN
      CLOSE relacion;
      INSERT INTO agrega_a_lista_negra (id_agregado,id_reportante, usuario_modificacion)
      VALUES (pId_adoptante, pId_rescatista, pId_Rescatista);
    END IF;
  END;

  PROCEDURE calificar_adoptante(pId_adoptante IN NUMBER, pId_rescatista IN NUMBER,
  pCalificacion IN NUMBER, pNotas IN VARCHAR2)AS
  CURSOR relacion IS SELECT id_adopcion FROM adopcion WHERE persona = pId_adoptante AND rescatista = pID_rescatista;
  BEGIN
    OPEN relacion;
    IF (relacion%FOUND) THEN
      CLOSE relacion;
      INSERT INTO califica_a (id_calificador, id_calificado, calificacion, notas, usuario_creacion)
      VALUES (pId_rescatista, pId_adoptante, pCalificacion, pNotas, pId_rescatista);
    END IF;
  END;
  
  PROCEDURE devolver_mascota(pId IN NUMBER, pMotivo IN VARCHAR2)AS
  vRescatista NUMBER;
  vDueno NUMBER;
  vMascota NUMBER;
  CURSOR rescatista_id IS SELECT rescatista FROM adopcion WHERE id_adopcion = pId;
  CURSOR dueno_id IS SELECT persona FROM adopcion WHERE id_adopcion = pId;
  CURSOR mascota_id IS SELECT mascota FROM adopcion WHERE id_adopcion = pId;
  BEGIN
    OPEN rescatista_id;
    FETCH rescatista_id INTO vRescatista;
    CLOSE rescatista_id;
    
    OPEN mascota_id;
    FETCH mascota_id INTO vMascota;
    CLOSE mascota_id;
    
    OPEN dueno_id;
    FETCH dueno_id INTO vDueno;
    CLOSE dueno_id;
    BEGIN
      UPDATE mascota
      SET contacto = vRescatista, estado = 'En adopción', usuario_modificacion = vDueno
      WHERE id = vMascota;
      EXCEPTION
      WHEN OTHERS THEN
      ROLLBACK;
    END;
    BEGIN
      DELETE FROM adopcion
      WHERE id_adopcion = pId;
      EXCEPTION
      WHEN OTHERS THEN
      ROLLBACK;
    END;
    BEGIN
      INSERT INTO Bitacora_mascotas (id_mascota, id_persona, tipo, fecha, usuario_creacion, usuario_modificacion)
      VALUES (vMascota, vDueno, 'Devolucion', SYSDATE, vDueno, vDueno);
      EXCEPTION
      WHEN OTHERS THEN
      ROLLBACK;
    END;
    BEGIN
      INSERT INTO devoluciones (fecha, motivo, id_dueno_anterior, id_mascota_devuelta, usuario_creacion, usuario_modificacion)
      VALUES (SYSDATE, pMotivo, vDueno, vMascota, vDueno, vDueno);
    END;
  END;
  
  PROCEDURE insert_mascota(pUsuario IN VARCHAR2, pNombre IN VARCHAR2, pTipo IN VARCHAR2,
  pRaza IN VARCHAR2, pColor1 IN VARCHAR2, pColor2 IN VARCHAR2, pEspacioRequerido IN VARCHAR2,
  pTamano IN VARCHAR2, pFacilidadEntrenamiento IN VARCHAR2, pNivelEnergia IN VARCHAR2,
  pSexo IN VARCHAR2, pVeterinario IN VARCHAR2, pMedicamentos IN VARCHAR2, pEnfermedades IN VARCHAR2,
  pNotas IN VARCHAR2, pTratamientos IN VARCHAR2, pSituacion IN VARCHAR2,
  pSeveridad IN VARCHAR2, pFotoAntes IN BLOB, pFotoDespues IN BLOB) AS
  pId NUMBER;
  pcontacto NUMBER:=Funciones.get_id_from_username(pUsuario);
  BEGIN
  
    INSERT INTO mascota (tipo, raza, nombre, tamano, facilidad_entrenamiento,color1, color2, contacto, nivel_energia,
    espacio_requerido, enfermedades, veterinario,sexo, medicamentos,-- fotografia_antes, fotografia_despues,
    notas, tratamientos, severidad,usuario_creacion, usuario_modificacion)
    VALUES (pTipo, pRaza, pNombre, pTamano,pFacilidadEntrenamiento, pColor1, pColor2, pcontacto, pNivelEnergia,
    pEspacioRequerido, pEnfermedades, pVeterinario,pSexo, pMedicamentos, --pFotoAntes, pFotoDespues,
    pNotas, pTratamientos,pSeveridad, pUsuario, pUsuario);
    
    SELECT id_mascota.CURRVAL INTO pId FROM dual;
    INSERT INTO bitacora_mascotas (id_mascota, id_persona, tipo, fecha, usuario_creacion)
    VALUES(pId, pcontacto, 'rescate', SYSDATE, pUsuario);
    
  END;
  
  PROCEDURE insert_persona(pNombre IN VARCHAR2, pApellido IN VARCHAR2,
  pTelefono IN VARCHAR2, pEmail IN VARCHAR2, pLugar IN VARCHAR2, pUsuario IN VARCHAR2, pGenero IN VARCHAR2) AS
  BEGIN
    INSERT INTO persona(nombre, apellido, telefono, email, lugar, usuario, genero)
     VALUES(pNombre, pApellido, pTelefono, pEmail, pLugar, pUsuario, pGenero);
  END;
  
  PROCEDURE insert_user (pUsername IN VARCHAR2, pPassword VARCHAR2) AS
  BEGIN
    INSERT INTO usuario (username, password) VALUES(pUsername, pPassword);
  END;
  
  PROCEDURE Insert_User_Persona(pUsername IN VARCHAR2, pPassword IN VARCHAR2,pNombre IN VARCHAR2, --COMPILADO
  pApellido IN VARCHAR2, pTelefono IN VARCHAR2, pEmail IN VARCHAR2, pDireccion IN VARCHAR2, pGenero IN VARCHAR2)AS
  BEGIN
  /*
  Es una transacciÃ³n, ya que todo se tiene que ejecutar a la vez.
  */
    BEGIN
      INSERT_USER(pUsername, pPassword);
      EXCEPTION
      WHEN OTHERS THEN
      ROLLBACK;
    END;
    BEGIN
      INSERT_PERSONA(pNombre, pApellido, pTelefono, pEmail, pDireccion, pUsername, pGenero);
      EXCEPTION
      WHEN OTHERS THEN
      ROLLBACK;
    END;
    COMMIT;
  END;
  
  PROCEDURE peticion_adopcion(pId_adoptante IN NUMBER, pId_rescatista IN NUMBER,
  pId_Mascota IN NUMBER) AS
  BEGIN
    INSERT INTO adopcion (persona, mascota, rescatista) VALUES (pId_adoptante, pId_Mascota, pId_rescatista);
  END;
  
  PROCEDURE update_mascota(pId IN NUMBER, pUsuario in VARCHAR2, pNombre IN VARCHAR2, pTipo IN VARCHAR2,
  pRaza IN VARCHAR2, pColor1 IN VARCHAR2, pColor2 IN VARCHAR2, pEspacioRequerido IN VARCHAR2,
  pTamano IN VARCHAR2, pFacilidadEntrenamiento IN VARCHAR2, pNivelEnergia IN VARCHAR2,
  pSexo IN VARCHAR2, pVeterinario IN VARCHAR2, pMedicamentos IN VARCHAR2, pEnfermedades IN VARCHAR2,
  pNotas IN VARCHAR2, pTratamientos IN VARCHAR2, pSituacion IN VARCHAR2,
  pSeveridad IN VARCHAR2, pFotoAntes IN BLOB, pFotoDespues IN BLOB) AS
  
  contacto NUMBER := Funciones.get_id_from_username(pUsuario);
  BEGIN
    UPDATE MASCOTA
    SET tipo = pTipo, raza = pRaza, nombre = pNombre, tamano = pTamano, color1 = pColor1,
    color2 = pColor2, contacto = contacto, nivel_energia = pNivelEnergia, espacio_requerido = pEspacioRequerido,
    facilidad_entrenamiento = pFacilidadEntrenamiento, enfermedades = pEnfermedades,
    veterinario = pVeterinario, medicamentos = pMedicamentos, fotografia_antes = pFotoAntes,
    fotografia_despues = pFotoDespues, notas = pNotas, tratamientos = pTratamientos,
    sexo = pSexo, severidad = pSeveridad, situacion_abandono = pSituacion, usuario_modificacion = pUsuario
    WHERE id = pId;
  END;
  
  PROCEDURE update_persona(pUsername IN VARCHAR2, pNombre IN VARCHAR2, pApellido IN VARCHAR2,
  pTelefono IN VARCHAR2, pEmail IN VARCHAR2, pLugar IN VARCHAR2, pGenero IN VARCHAR2) AS
  BEGIN
    UPDATE persona
    SET nombre = pNombre, apellido = pApellido, telefono = pTelefono,
    email = pEmail, lugar = pLugar, genero = pGenero, usuario_modificacion = pUsername
    WHERE usuario = pUsername;
  END;
  
  PROCEDURE update_user (pUsername IN VARCHAR2, pPassword IN VARCHAR2) AS
  BEGIN
    UPDATE usuario
    SET password = pPassword, usuario_modificacion = pUsername
    WHERE username = pUsername;
  END;

  PROCEDURE Update_User_Persona(pUsername IN VARCHAR2, pPassword IN VARCHAR2, pNombre IN VARCHAR2,
  pApellido IN VARCHAR2, pTelefono IN VARCHAR2, pCorreo IN VARCHAR2, pLugar IN VARCHAR2, pGenero IN VARCHAR2) AS
  BEGIN
    BEGIN
      update_user(pUsername, pPassword);
      EXCEPTION
      WHEN OTHERS THEN
      ROLLBACK;
    END;
    BEGIN
      update_persona(pUsername, pNombre, pApellido, pTelefono, pCorreo, pLugar, pGenero);
      EXCEPTION
      WHEN OTHERS THEN
      ROLLBACK;
    END;
    COMMIT;
  END;


END Procesos;
