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
CREATE OR REPLACE PROCEDURE insert_mascota(pUsuario in VARCHAR, pNombre IN VARCHAR2, pTipo IN VARCHAR2,
pRaza IN VARCHAR2, pColor1 IN VARCHAR2, pColor2 IN VARCHAR2, pEspacioRequerido IN VARCHAR2,
pTamano IN VARCHAR2, pFacilidadEntrenamiento IN VARCHAR2, pNivelEnergia IN VARCHAR2,
pSexo IN VARCHAR2, pVeterinario IN VARCHAR2, pMedicamentos IN VARCHAR2, pEnfermedades IN VARCHAR2,
pNotas IN VARCHAR2, pTratamientos IN VARCHAR2, pSituacion IN VARCHAR2,
pSeveridad IN VARCHAR2, pFotoAntes IN BLOB, pFotoDespues IN BLOB, pContacto IN NUMBER) AS
BEGIN
  INSERT INTO mascota (tipo, raza, nombre, tamano, color1, color2, contacto, nivel_energia,
  espacio_requerido, enfermedades, veterinario, medicamentos, fotografia_antes, fotografia_despues,
  notas, tratamientos)
  VALUES (pTipo, pRaza, pNombre, pTamano, pColor1, pColor2, pContacto, pNivelEnergia,
  pEspacioRequerido, pEnfermedades, pVeterinario, pMedicamentos, pFotoAntes, pFotoDespues,
  pNotas, pTratamientos);
END;

--Compilado
CREATE OR REPLACE PROCEDURE update_mascota(pId IN NUMBER, pUsuario in VARCHAR, pNombre IN VARCHAR2, pTipo IN VARCHAR2,
pRaza IN VARCHAR2, pColor1 IN VARCHAR2, pColor2 IN VARCHAR2, pEspacioRequerido IN VARCHAR2,
pTamano IN VARCHAR2, pFacilidadEntrenamiento IN VARCHAR2, pNivelEnergia IN VARCHAR2,
pSexo IN VARCHAR2, pVeterinario IN VARCHAR2, pMedicamentos IN VARCHAR2, pEnfermedades IN VARCHAR2,
pNotas IN VARCHAR2, pTratamientos IN VARCHAR2, pSituacion IN VARCHAR2,
pSeveridad IN VARCHAR2, pFotoAntes IN BLOB, pFotoDespues IN BLOB, pContacto IN NUMBER) AS
BEGIN
  UPDATE mascota
  SET tipo = pTipo, raza = pRaza, nombre = pNombre, tamano = pTamano, color1 = pColor1,
  color2 = pColor2, contacto = pContacto, nivel_energia = pNivelEnergia, espacio_requerido = pEspacioRequerido,
  facilidad_entrenamiento = pFacilidadEntrenamiento, enfermedades = pEnfermedades,
  veterinario = pVeterinario, medicamentos = pMedicamentos, fotografia_antes = pFotoAntes,
  fotografia_despues = pFotoDespues, notas = pNotas, tratamientos = pTratamientos
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
CREATE OR REPLACE PROCEDURE update_foto_antes_mascota(pId IN NUMBER, pFoto_antes IN BLOB) AS
BEGIN
  UPDATE mascota
  SET fotografia_antes = pFoto_antes
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


CREATE OR REPLACE PROCEDURE update_contacto_mascota(pId IN NUMBER, pContacto IN NUMBER) AS
BEGIN
  UPDATE mascota
  SET contacto = pContacto
  WHERE id = pId;
END;