--Scripts de creación & alter de tablas

CREATE TABLE Mascotas
  ID NUMBER(Identity(0,1) Constraint PK_Mascotas PRIMARY KEY (ID),
  Nombre VARCHAR2(20),
  Tamaño VARCHAR2(10) CONSTRAINT tamano_mascota_nn NOT NULL,
  Color1  VARCHAR2(20) CONSTRAINT color1_mascota_nn NOT NULL,
  Color2  VARCHAR2(20),
  Tel_contacto VARCHAR2(20) CONSTRAINT tel_rescatista_mascota_nn NOT NULL,
  Lugar VARCHAR2(20) CONSTRAINT lugar_mascota_nn NOT NULL,
  Nivel_energia VARCHAR2(20),
  Enfermedades VARCHAR2(20), --ANALIZAR
  Veterinario VARCHAR2(20),
  Fotografia_antes BLOB(200) CONSTRAINT foto_antes_mascota_nn NOT NULL,
  Correo_contacto VARCHAR2(30),
  Espacio_requerido VARCHAR2(10),
  Tipo_mascota VARCHAR2(15) CONSTRAINT tipo_mascota_nn NOT NULL, --Foreign Key a Tabla de Tipo
  Raza VARCCHAR2(30), ---Foreign Key a Tabla de Raza
  Veterinario VARCHAR2(25),
  Medicamentos VARCHAR2(20), --ANALIZAR
  Estado VARCHAR2(13) DEFAULT ('En abandono'),
  Notas VARCHAR2(75),
  Tratamientos VARCHAR2(25), --ANALIZAR
  Rescatista NUMBER CONSTRAINT rescatista_de_mascota_nn NOT NULL;
  
CREATE TABLE Tipo_Mascotas
  Especie VARCHAR2(15) CONSTRAINT tipo_mascota_pk PRIMARY KEY (Especie);
  
INSERT ALL
  INTO Tipo_Mascotas (Especie) VALUES ('Perro')
  INTO Tipo_Mascotas (Especie) VALUES ('Gato')
  INTO Tipo_Mascotas (Especie) VALUES ('Ave')
  INTO Tipo_Mascotas (Especie) VALUES ('Reptil')
  INTO Tipo_Mascotas (Especie) VALUES ('Roedor');
  
CREATE TABLE Raza_Mascotas
  Raza VARCHAR(30) CONSTRAINT raza_mascota_pk PRIMARY KEY (Raza),
  Grupo VARCHAR(15) CONSTRAINT grupo_raza_mascotas_nn NOT NULL,
  CONSTRAINT grupo_mascota_fk FOREIGN KEY (Grupo) REFERENCES Tipo_Mascota(Especie);
  
INSERT ALL
INTO Raza_Mascotas (Raza,Grupo) VALUES(' ', '')
INTO Raza_Mascotas (Raza,Grupo) VALUES(' ', '')
INTO Raza_Mascotas (Raza,Grupo) VALUES(' ', '')
INTO Raza_Mascotas (Raza,Grupo) VALUES(' ', '')
INTO Raza_Mascotas (Raza,Grupo) VALUES(' ', '')
INTO Raza_Mascotas (Raza,Grupo) VALUES(' ', '')
INTO Raza_Mascotas (Raza,Grupo) VALUES(' ', '')
INTO Raza_Mascotas (Raza,Grupo) VALUES(' ', '')
INTO Raza_Mascotas (Raza,Grupo) VALUES(' ', '')
  
ALTER TABLE Mascotas
  ADD CONSTRAINT tipo_mascota_fk FOREIGN KEY (Tipo_mascota) REFERENCES Tipo_Mascotas(Especie),
  ADD CONSTRAINT raza_mascota_fk FOREIGN KEY (Raza) REFERENCES Raza_Mascotas (Raza);
  

  
  
  
