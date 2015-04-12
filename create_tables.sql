--Scripts de creación & alter de tablas

CREATE TABLE Mascota
  ID NUMBER,
  Constraint pk_mascotas PRIMARY KEY (ID),
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
  Usuario_creacion VARCHAR(20) CONSTRAINT mascota_usuario_creacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT mascota_fecha_creacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR(20)
  Fecha_Modificacion DATE,
  Rescatista NUMBER CONSTRAINT rescatista_de_mascota_nn NOT NULL;
  
  
CREATE TABLE Tipo_Mascota
  Especie VARCHAR2(15) CONSTRAINT tipo_mascota_pk PRIMARY KEY (Especie);
  Usuario_creacion VARCHAR(20) CONSTRAINT tipo_mascota_usuario_creacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT tipo_mascota_fecha_creacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR(20)
  Fecha_Modificacion DATE,
  
INSERT ALL
  INTO Tipo_Mascota (Especie) VALUES ('Perro')
  INTO Tipo_Mascota (Especie) VALUES ('Gato')
  INTO Tipo_Mascota (Especie) VALUES ('Ave')
  INTO Tipo_Mascota (Especie) VALUES ('Reptil')
  INTO Tipo_Mascota (Especie) VALUES ('Roedor')
  SELECT * FROM dual;
  
CREATE TABLE Raza_Mascota
  Raza VARCHAR(30) CONSTRAINT raza_mascota_pk PRIMARY KEY (Raza),
  Grupo VARCHAR(15) CONSTRAINT grupo_raza_mascotas_nn NOT NULL,
  Usuario_creacion VARCHAR(20) CONSTRAINT mascota_usuario_creacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT mascota_fecha_creacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR(20)
  Fecha_Modificacion DATE,
  CONSTRAINT grupo_mascota_fk FOREIGN KEY (Grupo) REFERENCES Tipo_Mascota(Especie);
  
INSERT ALL
INTO Raza_Mascota (Raza,Grupo) VALUES(' ', '')
INTO Raza_Mascota (Raza,Grupo) VALUES(' ', '')
INTO Raza_Mascota (Raza,Grupo) VALUES(' ', '')
INTO Raza_Mascota (Raza,Grupo) VALUES(' ', '')
INTO Raza_Mascota (Raza,Grupo) VALUES(' ', '')
INTO Raza_Mascota (Raza,Grupo) VALUES(' ', '')
INTO Raza_Mascota (Raza,Grupo) VALUES(' ', '')
INTO Raza_Mascota (Raza,Grupo) VALUES(' ', '')
INTO Raza_Mascota (Raza,Grupo) VALUES(' ', '')
SELECT * FROM dual;
  
ALTER TABLE Mascota
  ADD CONSTRAINT tipo_mascota_fk FOREIGN KEY (Tipo_mascota) REFERENCES Tipo_Mascota(Especie),
  ADD CONSTRAINT raza_mascota_fk FOREIGN KEY (Raza) REFERENCES Raza_Mascota(Raza);
  
  
--------------------------------------------------------------------------------------------------------------

CREATE TABLE Usuario
  Nombre VARCHAR2(15) CONSTRAINT usuario_nombre_pk PRIMARY KEY(Nombre),
  Password VARCHAR2(20);

CREATE TABLE Persona
  id Number,
  CONSTRAINT persona_pk PRIMARY KEY (ID),
  nombre VARCHAR2(20) CONSTRAINT persona_nombre_nn NOT NULL,
  apellido VARCHAR2(20) CONSTRAINT persona_apellido_nn NOT NULL,
  provincia VARCHAR2(10) CONSTRAINT persona_provincia_nn NOT NULL,
  telefono VARCHAR2(10),
  email VARCHAR2(40) CONSTRAINT persona_email_nn NOT NULL,
  Username VARCHAR2(15) CONSTRAINT persona_username_fk FOREIGN KEY (Username) REFERENCES Usuario(Nombre);
  Usuario_creacion VARCHAR(20) CONSTRAINT mascota_usuario_creacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT mascota_fecha_creacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR(20)
  Fecha_Modificacion DATE,
  

CREATE TABLE Rescatista
  idN
  persona Number,
  CONSTRAINT rescatista_persona_pk PRIMARY KEY 
  Usuario_creacion VARCHAR(20) CONSTRAINT mascota_usuario_creacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT mascota_fecha_creacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR(20)
  Fecha_Modificacion DATE,
  

CREATE TABLE Adoptante
  Usuario_creacion VARCHAR(20) CONSTRAINT mascota_usuario_creacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT mascota_fecha_creacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR(20)
  Fecha_Modificacion DATE,


CREATE TABLE Califica_a

CREATE TABLE Añade_a_Lista_Negra

CREATE TABLE Historial_Devoluciones
  
  
  
