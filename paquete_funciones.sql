CREATE OR REPLACE PACKAGE Funciones AS

  FUNCTION check_estado_mascota(pID IN NUMBER) 
    RETURN NUMBER;
    
  FUNCTION check_existing_username(pUsername in VARCHAR2)
    RETURN NUMBER;
    
  FUNCTION check_password(pPassword IN VARCHAR2, pUsuario IN VARCHAR2)
    RETURN NUMBER;
    
  FUNCTION get_datos_mascota(pID IN NUMBER, parametro IN VARCHAR2)
    RETURN VARCHAR2;
    
  FUNCTION get_datos_usuario(pUsername IN VARCHAR2, parametro IN VARCHAR2)
    RETURN VARCHAR2 ;
    
  FUNCTION get_foto_antes(pID IN NUMBER)
    RETURN BLOB;
    
  FUNCTION get_foto_despues(pID IN NUMBER)
    RETURN BLOB;  
    
  FUNCTION get_id_adopcion(pId_Mascota IN NUMBER, pId_Adoptante IN NUMBER)
    RETURN NUMBER;
  
  FUNCTION get_id_from_username(pUsername in VARCHAR2)
    RETURN NUMBER;
  
  FUNCTION get_lugar_from_id(pId IN NUMBER)
    RETURN VARCHAR2; 
    
  FUNCTION get_nombrecompleto_from_id(pId IN NUMBER)
    RETURN VARCHAR2;
    
  FUNCTION is_person_in_black_list(pID IN NUMBER)
    RETURN NUMBER;
  
  FUNCTION get_username_from_id(pId IN NUMBER)
    RETURN VARCHAR2;


END Funciones;


CREATE OR REPLACE PACKAGE BODY Funciones AS

  FUNCTION check_estado_mascota(pid IN NUMBER)--Compilado
  RETURN NUMBER AS
  Resultado NUMBER;
  vEstado VARCHAR2(30);
  CURSOR estado_Mascota IS
    SELECT estado
    FROM Mascota
    WHERE id = pid;
  BEGIN
    OPEN estado_Mascota;
    FETCH estado_Mascota into vEstado;
    
    IF vEstado = 'Adoptado' THEN
      CLOSE estado_Mascota;
      Resultado:=1;
      RETURN Resultado;
    ELSE
      CLOSE estado_Mascota;
      Resultado:=0;
      RETURN Resultado;
    END IF;
    EXCEPTION
      WHEN OTHERS THEN
      RETURN NULL;
  END;
  
  
  FUNCTION check_existing_username(pusername IN VARCHAR2)--COMPILADO
  RETURN NUMBER AS
  RESULTADO NUMBER;
  CURSOR usernames  IS
    SELECT username
    FROM usuario
    WHERE username = pusername;
  vUsuario VARCHAR2(30);
  BEGIN
    OPEN usernames;
    FETCH usernames into vUsuario;
    
    IF (usernames%FOUND) THEN
      CLOSE usernames;
      RESULTADO:=1;
      RETURN RESULTADO;
    ELSE 
      CLOSE usernames;
      RESULTADO:=0;
      RETURN RESULTADO;
    END IF;
    EXCEPTION
      WHEN OTHERS THEN
      RETURN NULL;
  END;

  FUNCTION check_password (pPassword IN VARCHAR2, pUsuario IN VARCHAR2)--COMPILADO
  RETURN NUMBER AS
  RESULTADO NUMBER;
  vPassword VARCHAR2(40);
  CURSOR pass IS
    SELECT password
    FROM usuario
    WHERE pPassword =
      (SELECT password
      FROM usuario
      WHERE username=pUsuario);
  BEGIN
    OPEN pass;
    FETCH pass into vPassword;
    
      IF(pass%FOUND) THEN
        CLOSE pass;
        RESULTADO:=1;
        RETURN RESULTADO;
      ELSE
        CLOSE pass;
        RESULTADO:=0;
        RETURN RESULTADO;
      END IF;
      EXCEPTION
        WHEN OTHERS THEN
        RETURN NULL;
  END;

  FUNCTION get_datos_mascota(pId IN NUMBER, parametro IN VARCHAR2)
  RETURN VARCHAR2 AS
  vParametro VARCHAR2(200);
  BEGIN
    IF(parametro = 'tipo') THEN
      SELECT tipo
      INTO vParametro
      FROM mascota
      WHERE id = pId;
    ELSIF(parametro = 'raza') THEN
      SELECT raza
      INTO vParametro
      FROM mascota
      WHERE id = pId;
    ELSIF(parametro = 'tamano') THEN
      SELECT tamano
      INTO vParametro
      FROM mascota
      WHERE id = pId;
    ELSIF(parametro = 'color1') THEN
      SELECT color1
      INTO vParametro
      FROM mascota
      WHERE id = pId;
    ELSIF(parametro = 'color2') THEN
      SELECT color2
      INTO vParametro
      FROM mascota
      WHERE id = pId;
    ELSIF(parametro = 'nivel_energia') THEN
      SELECT nivel_energia
      INTO vParametro
      FROM mascota
      WHERE id = pId;
    ELSIF(parametro = 'espacio_requerido') THEN
      SELECT espacio_requerido
      INTO vParametro
      FROM mascota
      WHERE id = pId;
    ELSIF(parametro = 'facilidad_entrenamiento') THEN
      SELECT facilidad_entrenamiento
      INTO vParametro
      FROM mascota
      WHERE id = pId;
    ELSIF(parametro = 'enfermedades') THEN
      SELECT enfermedades
      INTO vParametro
      FROM mascota
      WHERE id = pId;
    ELSIF(parametro = 'veterinario') THEN
      SELECT veterinario
      INTO vParametro
      FROM mascota
      WHERE id = pId;
    ELSIF(parametro = 'medicamentos') THEN
      SELECT medicamentos
      INTO vParametro
      FROM mascota
      WHERE id = pId;
    ELSIF(parametro = 'estado') THEN
      SELECT estado
      INTO vParametro
      FROM mascota
      WHERE id = pId;
    ELSIF(parametro = 'notas') THEN
      SELECT notas
      INTO vParametro
      FROM mascota
      WHERE id = pId;
    ELSIF(parametro = 'tratamientos') THEN
      SELECT tratamientos
      INTO vParametro
      FROM mascota
      WHERE id = pId;
    ELSE
      SELECT nombre
      INTO vParametro
      FROM mascota
      WHERE id = pId;
    END IF;
    RETURN vParametro;
  END;

  FUNCTION get_datos_usuario(pUsername IN VARCHAR2, parametro IN VARCHAR2)
  RETURN VARCHAR2 AS
  vParametro VARCHAR2(100);
  BEGIN
    IF(parametro='genero')THEN
      SELECT genero 
      INTO vParametro 
      FROM persona 
      WHERE usuario = pUsername;
    ELSIF(parametro='apellido') THEN
      SELECT apellido 
      INTO vParametro 
      FROM persona 
      WHERE usuario = pUsername;
    ELSIF(parametro='nombre completo') THEN
      SELECT nombre||apellido 
      INTO vParametro
      FROM persona 
      WHERE usuario = pUsername;
    ELSIF(parametro='telefono') THEN
      SELECT telefono
      INTO vParametro 
      FROM persona 
      WHERE usuario = pUsername;
    ELSIF(parametro='correo') THEN
      SELECT email 
      INTO vParametro
      FROM persona 
      WHERE usuario = pUsername;
    ELSIF(parametro='username') THEN
      SELECT usuario 
      INTO vParametro 
      FROM persona 
      WHERE usuario = pUsername;
    ELSIF(parametro='password') THEN
      SELECT password
      INTO vParametro 
      FROM usuario
      WHERE username = pUsername;
    ELSIF(parametro='lugar') THEN
      SELECT lugar
      INTO vParametro 
      FROM persona 
      WHERE usuario = pUsername;
    ELSE
      SELECT nombre
      INTO vParametro 
      FROM persona 
      WHERE usuario = pUsername;
    END IF;
    RETURN vParametro;
  END;
  
  FUNCTION get_foto_antes(pId IN NUMBER)
  RETURN BLOB AS
  vFoto BLOB:=NULL;
  BEGIN
    SELECT Fotografia_antes
    INTO vFoto
    FROM mascota
    WHERE id = pID;
    RETURN vFoto;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RETURN vFoto;
    WHEN OTHERS THEN
      RETURN NULL;
  END;
  
  FUNCTION get_foto_despues(pId IN NUMBER)
  RETURN BLOB AS
  vFoto BLOB:=NULL;
  BEGIN
    SELECT Fotografia_despues
    INTO vFoto
    FROM mascota
    WHERE id = pID;
    RETURN vFoto;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RETURN vFoto;
    WHEN OTHERS THEN
      RETURN NULL;
  END;
  
  FUNCTION get_Id_Adopcion(pId_mascota IN NUMBER, pId_adoptante IN NUMBER)
  RETURN NUMBER AS
  vId NUMBER;
  BEGIN
    SELECT id_adopcion
    INTO vId
    FROM adopcion
    WHERE persona = pId_adoptante AND mascota = pId_mascota;
    RETURN vId;
    EXCEPTION
      WHEN OTHERS THEN
      RETURN NULL;
  END;

  FUNCTION get_id_from_username(pUsername IN VARCHAR2)
  RETURN NUMBER AS
  vId NUMBER:=NULL;
  BEGIN
    SELECT id
    INTO vId
    FROM persona
    WHERE usuario = 
      (SELECT username
      FROM usuario
      WHERE username = pUsername);
    RETURN vId;
    EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RETURN vId;
    WHEN OTHERS THEN
      RETURN NULL;
  END;

  FUNCTION get_lugar_from_id(pID IN NUMBER) 
  RETURN VARCHAR2 AS
  vNombre VARCHAR2(100):=NULL;
  BEGIN 
    SELECT lugar
    INTO vNombre
    FROM PERSONA
    WHERE id=pID;
    RETURN vNombre;
    EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RETURN NULL;
    WHEN OTHERS THEN 
      RETURN NULL;
  END get_lugar_from_id;

  FUNCTION get_nombreCompleto_from_id(pID IN NUMBER) 
  RETURN VARCHAR2 AS
  vNombre VARCHAR2(100):=NULL;
  BEGIN 
    SELECT wm_concat (nombre || ' ' || apellido)
    INTO vNombre
    FROM PERSONA
    WHERE id=pID;
    RETURN vNombre;
    EXCEPTION
    WHEN NO_DATA_FOUND THEN
    RETURN NULL;
    WHEN OTHERS THEN 
      RETURN NULL;
  END get_nombreCompleto_from_id;

  FUNCTION is_Person_In_Black_List(pId IN NUMBER)
  RETURN NUMBER AS
  resultado NUMBER;
  CURSOR in_Black_List IS
  SELECT id_agregado FROM agrega_a_lista_negra WHERE id_agregado = pId;
  BEGIN
    OPEN in_Black_List;
    IF(in_Black_List%FOUND)THEN
      CLOSE in_Black_List;
      resultado:=1;
      RETURN resultado;
    ELSE
      CLOSE in_Black_List;
      resultado:=0;
      RETURN resultado;
    END IF;
    EXCEPTION
      WHEN OTHERS THEN
      RETURN NULL;
  END;
  
  FUNCTION get_username_from_id(pID IN NUMBER)
  RETURN VARCHAR2 AS
  vUser VARCHAR2(30):=NULL;
  BEGIN
    SELECT USUARIO
    INTO vUser
    FROM PERSONA
    WHERE ID = pID;
    RETURN vUser;
    EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RETURN vUser;
    WHEN OTHERS THEN
      RETURN NULL;
  END;

END Funciones;

