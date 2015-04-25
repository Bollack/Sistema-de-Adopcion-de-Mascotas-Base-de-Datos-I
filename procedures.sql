CREATE OR REPLACE PROCEDURE insert_user (PUsername IN VARCHAR2, pPassword VARCHAR2) AS
BEGIN
  INSERT INTO usuario (username, Password) VALUES(pUsername, pPassword);
END;

--prueba EXEC Administrador.insert_user('snth','snthsnth');

--Compilado
CREATE OR REPLACE PROCEDURE insert_persona(pNombre IN VARCHAR2, pApellido IN VARCHAR2,
pProvincia IN VARCHAR2, pTelefono IN VARCHAR2, pEmail IN VARCHAR2, pLugar IN VARCHAR2,
pUsuario IN VARCHAR2, pGenero IN VARCHAR2) AS
BEGIN
  INSERT INTO persona(nombre, apellido, provincia, telefono, email, lugar,
   usuario, genero)
   VALUES(pNombre, pApellido, pProvincia, pTelefono, pEmail,
   pLugar, pUsuario, pGenero);
END;

--Compilado
CREATE OR REPLACE PROCEDURE update_persona(pId in NUMBER, pNombre IN VARCHAR2, pApellido IN VARCHAR2,
pProvincia IN VARCHAR2, pTelefono IN VARCHAR2, pEmail IN VARCHAR2, pLugar IN VARCHAR2) AS
BEGIN
  UPDATE persona
  SET nombre = pNombre, apellido = pApellido, provincia = pProvincia, telefono = pTelefono,
  email = pEmail, lugar = pLugar
  WHERE id = pId;
END;

--Compilado
CREATE OR REPLACE PROCEDURE insert_mascota(pTipo IN VARCHAR2, pRaza IN VARCHAR2,
pTamano IN VARCHAR2, pColor1 IN VARCHAR2,pContacto IN NUMBER,
pFacilidad_entrenamiento IN VARCHAR2, pFotografia_antes IN BLOB, pEstado IN VARCHAR2,
pSexo in VARCHAR2) AS
BEGIN
  INSERT INTO mascota (Tipo, Raza, Tamano, Color1, Contacto, Facilidad_entrenamiento,
  Fotografia_antes, Estado, sexo)
  VALUES (pTipo, pRaza, pTamano, pColor1, pContacto, pFacilidad_entrenamiento, 
  pFotografia_antes, pEstado, pSexo);
END;

--Compilado
CREATE OR REPLACE PROCEDURE update_mascota(pId IN NUMBER, pTipo IN VARCHAR2, pRaza IN VARCHAR2,
pTamano IN VARCHAR2, pColor1 IN VARCHAR2,pContacto IN NUMBER,
pFacilidad_entrenamiento IN VARCHAR2, pFotografia_antes IN BLOB, pEstado IN VARCHAR2,
pSexo in VARCHAR2) AS
BEGIN
  UPDATE mascota
  SET tipo = pTipo, raza = pRaza, tamano = pTamano, color1 = pColor1,
  contacto = pContacto, facilidad_entrenamiento = pFacilidad_entrenamiento,
  fotografia_antes = pFotografia_antes, estado = pEstado, sexo = pSexo
  WHERE id = pId;
END;

--Compilado
CREATE OR REPLACE PROCEDURE update_nombre_mascota(pId IN NUMBER, pNombre IN VARCHAR2) AS
BEGIN
  UPDATE mascota
  SET nombre = pNombre
  WHERE id = pId;
END;

--Compilado
CREATE OR REPLACE PROCEDURE update_color2_mascota(pId IN NUMBER, pCOLOR2 IN VARCHAR2) AS
BEGIN
  UPDATE mascota
  SET color2 = pColor2
  WHERE id = pId;
END;

--Compilado
CREATE OR REPLACE PROCEDURE update_nivel_energia_mascota(pId IN NUMBER, pNivel_energia IN VARCHAR2) AS
BEGIN
  UPDATE mascota
  SET nivel_energia = pNivel_energia
  WHERE id = pId;
END;

--Compilado
CREATE OR REPLACE PROCEDURE update_espacio_req_mascota(pId IN NUMBER, pEspacio_requerido IN VARCHAR2) AS
BEGIN
  UPDATE mascota
  SET espacio_requerido = pEspacio_requerido
  WHERE id = pId;
END;

--Compilado
CREATE OR REPLACE PROCEDURE update_enfermedades_mascota(pId IN NUMBER, pEnfermedades IN VARCHAR2) AS
BEGIN
  UPDATE mascota
  SET enfermedades = pEnfermedades
  WHERE id = pId;
END;

--Compilado
CREATE OR REPLACE PROCEDURE update_veterinario_mascota(pId IN NUMBER, pVeterinario IN VARCHAR2) AS
BEGIN
  UPDATE mascota
  SET veterinario = pVeterinario
  WHERE id = pId;
END;

--Compilado
CREATE OR REPLACE PROCEDURE update_medicamentos_mascota(pId IN NUMBER, pMedicamentos IN VARCHAR2) AS
BEGIN
  UPDATE mascota
  SET medicamentos = pMedicamentos
  WHERE id = pId;
END;

--Compilado
CREATE OR REPLACE PROCEDURE update_foto_despues_mascota(pId IN NUMBER, pFoto_despues IN BLOB) AS
BEGIN
  UPDATE mascota
  SET fotografia_despues = pFoto_despues
  WHERE id = pId;
END;

--Compilado
CREATE OR REPLACE PROCEDURE update_notas_mascota(pId IN NUMBER, pNotas IN VARCHAR2) AS
BEGIN
  UPDATE mascota
  SET notas = pNotas
  WHERE id = pId;
END;

--Compilado
CREATE OR REPLACE PROCEDURE update_tratamientos_mascota(pId IN NUMBER, pTratamientos IN VARCHAR2) AS
BEGIN
  UPDATE mascota
  SET tratamientos = pTratamientos
  WHERE id = pId;
END;