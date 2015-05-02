--Compilado y testeado
create or replace FUNCTION check_existing_username(pusername IN VARCHAR2)
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

--Compilado y testeado
create or replace FUNCTION check_password (pPassword IN VARCHAR2, pUsuario IN VARCHAR2)
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
      RESULTADO:=1;
      RETURN RESULTADO;
  END IF;
  EXCEPTION
      WHEN OTHERS THEN
      RETURN NULL;
END;

create or replace FUNCTION check_estado_mascota(pid IN NUMBER)
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


--Compilado y testeado
CREATE OR REPLACE FUNCTION get_id_from_username(pUsername IN VARCHAR2)
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

--Compilado
CREATE OR REPLACE FUNCTION get_foto_antes(pId IN NUMBER)
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

--Compilado
CREATE OR REPLACE FUNCTION get_foto_despues(pId IN NUMBER)
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

--Compilado y testeado
CREATE OR REPLACE FUNCTION get_nombreCompleto_from_id(pID IN NUMBER) 
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

--*Compilada
create or replace FUNCTION get_datos_usuario(pUsername IN VARCHAR2, parametro IN VARCHAR2)
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
