--Scripts de creación & alter de tablas
--Orden de creacion de tablas: Persona, Usuario, Tipo, Raza, Mascota
CREATE TABLE Mascota --Creado
(
  ID NUMBER,
  CONSTRAINT pk_mascotas PRIMARY KEY (ID),
  Tipo VARCHAR2(15) CONSTRAINT tipo_mascota_nn NOT NULL,
  Raza VARCHAR2(60) CONSTRAINT raza_mascota_nn NOT NULL,
  Nombre VARCHAR2(20),
  Tamaño VARCHAR2(10) CONSTRAINT tamano_mascota_nn NOT NULL,
  Color1  VARCHAR2(20) CONSTRAINT color1_mascota_nn NOT NULL,
  Color2  VARCHAR2(20),
  Rescatista NUMBER CONSTRAINT rescatista_de_mascota_nn NOT NULL,
  Tel_contacto VARCHAR2(20) CONSTRAINT tel_rescatista_mascota_nn NOT NULL,
  Correo_contacto VARCHAR2(30) CONSTRAINT correo_rescatista_mascota_nn NOT NULL,
  Lugar VARCHAR2(20) CONSTRAINT lugar_mascota_nn NOT NULL,
  Nivel_energia NUMBER CONSTRAINT nivel_energia_check CHECK(-1<Nivel_energia<11),
  Espacio_requerido NUMBER CONSTRAINT espacio_requerido_check(-1<Espacio_requerido<6),
  Facilidad_entrenamiento VARCHAR2(20) CONSTRAINT facilidad_entrenamiento_nn NOT NULL,
  Enfermedades VARCHAR2(200),
  Veterinario VARCHAR2(200),
  Medicamentos VARCHAR2(200),
  Fotografia_antes BLOB CONSTRAINT foto_antes_mascota_nn NOT NULL,
  Estado VARCHAR2(13) DEFAULT ('En abandono'),
  Notas VARCHAR2(200),
  Tratamientos VARCHAR2(200),
  
  Usuario_creacion VARCHAR2(20) CONSTRAINT mascota_ucreacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT mascota_fcreacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR2(20),
  Fecha_Modificacion DATE,
  
  CONSTRAINT tel_contacto_fk FOREIGN KEY (Tel_contacto) REFERENCES Persona(telefono),
  CONSTRAINT correo_contacto_fk FOREIGN KEY (Correo_contacto) REFERENCES Persona(email),
  CONSTRAINT raza_fk FOREIGN KEY (Raza) REFERENCES Raza_Mascota(Raza),
  CONSTRAINT tipo_fk FOREIGN KEY (Tipo) REFERENCES Tipo_Mascota(Especie),
  CONSTRAINT 
);
  
  
CREATE TABLE Tipo_Mascota --Creado
(
  Especie VARCHAR2(15) CONSTRAINT tipo_mascota_pk PRIMARY KEY (Especie);
  
  Usuario_creacion VARCHAR2(20) CONSTRAINT tipo_mascota_ucreacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT tipo_mascota_fcreacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR2(20),
  Fecha_Modificacion DATE
);
  
INSERT ALL --Añadir Triggers
  INTO Tipo_Mascota (Especie) VALUES ('Perro')
  INTO Tipo_Mascota (Especie) VALUES ('Gato')
  INTO Tipo_Mascota (Especie) VALUES ('Ave')
  INTO Tipo_Mascota (Especie) VALUES ('Reptil')
  INTO Tipo_Mascota (Especie) VALUES ('Roedor')
  SELECT * FROM dual;
  
CREATE TABLE Raza_Mascota
(
  Raza VARCHAR2(60) CONSTRAINT raza_mascota_pk PRIMARY KEY (Raza),
  Grupo VARCHAR2(15) CONSTRAINT grupo_raza_mascotas_nn NOT NULL,
  
  Usuario_creacion VARCHAR2(20) CONSTRAINT raza_mascota_ucreacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT raza_mascota_fcreacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR2(20)
  Fecha_Modificacion DATE,
  CONSTRAINT grupo_mascota_fk FOREIGN KEY (Grupo) REFERENCES Tipo_Mascota(Especie)
);
  
INSERT ALL
INTO Raza_Mascota (Raza,Grupo) VALUES('Afgano', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Zaguate - Interminado', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Akita', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('American Staaffordshire Terrier', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Basenji', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Basset Hound', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Beagle', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Bedlington Terrier', 'Perr1o')
INTO Raza_Mascota (Raza,Grupo) VALUES('Bichón Frisé', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Bloodhound', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Border Collie', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Borzoi', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Boxer', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Bull Terrier', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Bulldog Inglés', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Cavalier King Charles Spaniel', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Chihuaheño', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Chow Chow', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Clumber Spaniel', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Cocker Spaniel', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Collie Barbudo', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Collie Pelo Largo', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Crestado Chino', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Dálmata', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Desconocido', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Doberman', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Fox Terrier', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Galgo Italiano', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Golden Retriever', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Gran Danés', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Husky Siberiano', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Jack Russel Terrier', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Keeshond', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Kelpie Australiano', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Labrador', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Lobero Irlandés', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Maltés', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Pastor Alemán', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Pastor Australiano', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Pekinés', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Pomerania', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Poodle', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Poodle Toy(Taza de té)', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Pug', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Rottweiler', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Samoyedo', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Setter Inglés', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Shar Pei', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Terrier Escocés', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Yorkshire Terrier', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Persa', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Bobtail Americano', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Ruso Azul', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Somalí', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Siberiano', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Manés', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Cruce', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Desconocido', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Burmés', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Ragdoll', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Maine Coon', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Siamés', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('', 'Ave')
INTO Raza_Mascota (Raza,Grupo) VALUES('', 'Ave')
INTO Raza_Mascota (Raza,Grupo) VALUES('', 'Ave')
INTO Raza_Mascota (Raza,Grupo) VALUES('', 'Ave')
SELECT * FROM dual;
  
--------------------------------------------------------------------------------------------------------------

CREATE TABLE Usuario
(
  id Number,
  CONSTRAINT usuario_pk PRIMARY KEY(id),
  Nombre VARCHAR2(30),
  CONSTRAINT usuario_nombre_un UNIQUE(nombre),
  CONSTRAINT usuario_nombre_nn NOT NULL,
  Password VARCHAR2(20),
  CONSTRAINT usuario_password_lenght CHECK(lenght(password>)7),
  CONSTRAINT usuario_password_nn NOT NULL,
  
  Usuario_creacion VARCHAR2(20) CONSTRAINT usuario_ucreacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT usuario_fcreacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR2(20),
  Fecha_Modificacion DATE
);

CREATE TABLE Persona
(
  id Number,
  CONSTRAINT persona_pk PRIMARY KEY (ID),
  nombre VARCHAR2(20) CONSTRAINT persona_nombre_nn NOT NULL,
  apellido VARCHAR2(20) CONSTRAINT persona_apellido_nn NOT NULL,
  provincia VARCHAR2(10) CONSTRAINT persona_provincia_nn NOT NULL,
  telefono Telefono(10) CONSTRAINT persona_telefono_nn NOT NULL,
  email VARCHAR2(40) CONSTRAINT persona_email_nn NOT NULL,
  fecha_nacimiento DATE CONTRAINT fecha_nacimiento_nn NOT NULL,
  usuario NUMBER CONSTRAINT persona_username_fk FOREIGN KEY (usuario) REFERENCES Usuario(id);
  
  Usuario_creacion VARCHAR2(20) CONSTRAINT persona_ucreacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT persona_fcreacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR2(20),
  Fecha_Modificacion DATE
);

----------------------------------------------------------------------------------------------------------------------------
--Just in case

--CREATE TABLE Rescatista
  --idN
  --persona Number,
  --CONSTRAINT rescatista_persona_pk PRIMARY KEY 
  --Usuario_creacion VARCHAR(20) CONSTRAINT mascota_usuario_creacion_nn NOT NULL,
  --Fecha_creacion DATE CONSTRAINT mascota_fecha_creacion_nn NOT NULL,
  --Usuario_Modificacion VARCHAR(20)
  --Fecha_Modificacion DATE,
  

--CREATE TABLE Adoptante
  --Usuario_creacion VARCHAR(20) CONSTRAINT mascota_usuario_creacion_nn NOT NULL,
  --Fecha_creacion DATE CONSTRAINT mascota_fecha_creacion_nn NOT NULL,
  --Usuario_Modificacion VARCHAR(20)
  --Fecha_Modificacion DATE,


CREATE TABLE Califica_a

CREATE TABLE Añade_a_Lista_Negra

CREATE TABLE Historial_Devoluciones
  
  
  
