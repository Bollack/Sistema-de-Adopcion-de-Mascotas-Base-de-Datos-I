CREATE OR REPLACE PROCEDURE insert_user (PUsername IN VARCHAR2, pPassword VARCHAR2) AS
BEGIN
  INSERT INTO usuario (username, Password) VALUES(pUsername, pPassword);
END;

--prueba EXEC Administrador.insert_user('snth','snthsnth');