CREATE OR REPLACE FUNCTION check_existing_username(pusername IN VARCHAR2)
RETURN BOOLEAN AS

CURSOR usernames  IS
	SELECT username
	FROM usuario
	WHERE username = pusername;
vUsuario VARCHAR2(30);
BEGIN
  OPEN usernames;
  FETCH usernames into vUsuario;
  CLOSE usernames;
  
	IF (usernames%NOTFOUND) THEN
		CLOSE usernames;
		RETURN 1;
	ELSE 
		CLOSE usernames;
		RETURN 0;
  END IF;
END;


CREATE OR REPLACE FUNCTION check_password (pPassword IN VARCHAR2, pUsuario IN VARCHAR2)
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
	CLOSE pass;
  
		IF(pass%FOUND=FALSE) THEN
			{return 1;}
      }
		ELSE
			RETURN 0;
		END IF;
END;

CREATE OR REPLACE FUNCTION check_estado_mascota(pid IN NUMBER)
RETURN BIT AS
vEstado NUMBER;
CURSOR estado IS
	SELECT estado
	FROM Mascota
	WHERE id = pid;
BEGIN
	OPEN estado;
	FETCH estado into vID;
	CLOSE estado;
	IF(vEstado='Adoptado') THEN
		RETURN 1;
	ELSE
		RETURN 0;
	END IF;
END;