CREATE OR REPLACE FUNCTION check_existing_username(pusername IN VARCHAR2)--COMPILADO
RETURN BOOLEAN AS

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
		RETURN TRUE;
	ELSE 
		CLOSE usernames;
		RETURN FALSE;
  END IF;
END;


CREATE OR REPLACE FUNCTION check_password (pPassword IN VARCHAR2, pUsuario IN VARCHAR2)--COMPILADO
RETURN BOOLEAN AS
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
			return TRUE;
		ELSE
      CLOSE pass;
			RETURN FALSE;
		END IF;
END;

CREATE OR REPLACE FUNCTION check_estado_mascota(pid IN NUMBER)--Compilado
RETURN BOOLEAN AS
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
		RETURN TRUE;
	ELSE
    CLOSE estado_Mascota;
		RETURN FALSE;
	END IF;
END;


--Compilado
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