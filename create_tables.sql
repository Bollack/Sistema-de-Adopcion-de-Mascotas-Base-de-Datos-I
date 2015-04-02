--Scripts de creación & alter de tablas

CREATE TABLE Mascotas
  ID NUMBER(Identity(0,1) Constraint PK_Mascotas PRIMARY KEY (ID),
  Nombre VARCHAR2(20),
  Tamaño VARCHAR2(10),
  Color  VARCHAR2(20),
  Tel_contacto VARCHAR2(20),
  Lugar VARCHAR2(20),
  Nivel_energia VARCHAR2(20),
  Enfermedades VARCHAR(20), --ANALIZAR
  Veterinario VARCHAR(20),
  Fotografia_antes BLOB,
  
