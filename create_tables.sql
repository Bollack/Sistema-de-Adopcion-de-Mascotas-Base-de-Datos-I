--Scripts de creacion & alter de tablas
--Orden de creacion de tablas: Persona, Usuario, Tipo, Raza, Mascota

/*




*/

CREATE TABLE Mascota --Aplicado
(
  ID NUMBER,
  CONSTRAINT pk_mascotas PRIMARY KEY (ID),
  Tipo VARCHAR2(15) CONSTRAINT tipo_mascota_nn NOT NULL,
  Raza VARCHAR2(60) CONSTRAINT raza_mascota_nn NOT NULL,
  Nombre VARCHAR2(20) DEFAULT('Sin nombre'),
  Tamano VARCHAR2(10) CONSTRAINT tamano_mascota_nn NOT NULL,
  Color1  VARCHAR2(20) CONSTRAINT color1_mascota_nn NOT NULL,
  Color2  VARCHAR2(20),
  Contacto  NUMBER CONSTRAINT rescatista_de_mascota_nn NOT NULL,
  Nivel_energia VARCHAR2(20),
  Espacio_requerido VARCHAR2(20),
  Facilidad_entrenamiento VARCHAR2(20) CONSTRAINT facilidad_entrenamiento_nn NOT NULL,
  Enfermedades VARCHAR2(200),
  Veterinario VARCHAR2(200),
  Medicamentos VARCHAR2(200),
  Fotografia_antes BLOB CONSTRAINT foto_antes_mascota_nn NOT NULL,
  Fotografia_despues BLOB,
  Estado VARCHAR2(30) DEFAULT('En adopción'),
  CONSTRAINT mascota_estado_check CHECK(Estado IN ('En adopción','Adoptada')),
  Notas VARCHAR2(200),
  Tratamientos VARCHAR2(200),
  
  Usuario_creacion VARCHAR2(20) CONSTRAINT mascota_ucreacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT mascota_fcreacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR2(20),
  Fecha_Modificacion DATE,
  

  CONSTRAINT raza_fk FOREIGN KEY (Raza) REFERENCES Raza_Mascota(Raza),
  CONSTRAINT tipo_fk FOREIGN KEY (Tipo) REFERENCES Tipo_Mascota(Especie),
  CONSTRAINT contacto_fk FOREIGN KEY(contacto) REFERENCES Persona(id)
);
  
CREATE PUBLIC SYNONYM Mascota FOR Administrador.Mascota; -- APLICADO

ALTER TABLE Mascota -- APLICADO
ADD (sexo VARCHAR2(20) CONSTRAINT mascota_sexo_nn NOT NULL);

ALTER TABLE Mascota -- APLICADO
ADD (CONSTRAINT mascota_sexo_check CHECK(Estado IN ('Macho','Hembra')));
  
CREATE TABLE Tipo_Mascota --Creado
(
  Especie VARCHAR2(45),
  CONSTRAINT tipo_mascota_pk PRIMARY KEY (Especie),
  
  Usuario_creacion VARCHAR2(20) CONSTRAINT tipo_mascota_ucreacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT tipo_mascota_fcreacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR2(20),
  Fecha_Modificacion DATE
);


CREATE PUBLIC SYNONYM Tipo_Mascota FOR Administrador.Tipo_Mascota; -- APLICADO

  
INSERT ALL --APLICADO
  INTO Tipo_Mascota (Especie) VALUES ('Perro')
  INTO Tipo_Mascota (Especie) VALUES ('Gato')
  INTO Tipo_Mascota (Especie) VALUES ('Ave')
  INTO Tipo_Mascota (Especie) VALUES ('Reptil, Anfibio o Arácnido')
  INTO Tipo_Mascota (Especie) VALUES ('Roedor')
  SELECT * FROM dual;
  
CREATE TABLE Raza_Mascota --CREADA
(
  Raza VARCHAR2(60),
  CONSTRAINT raza_mascota_pk PRIMARY KEY (Raza),
  Grupo VARCHAR2(15) CONSTRAINT grupo_raza_mascotas_nn NOT NULL,
  
  Usuario_creacion VARCHAR2(20) CONSTRAINT raza_mascota_ucreacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT raza_mascota_fcreacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR2(20),
  Fecha_Modificacion DATE,
  CONSTRAINT grupo_mascota_fk FOREIGN KEY (Grupo) REFERENCES Tipo_Mascota(Especie)
);

ALTER TABLE Raza_Mascota --Aplicado
MODIFY (Grupo VARCHAR2(40));
  
CREATE PUBLIC SYNONYM Raza_Mascota FOR Administrador.Raza_Mascota; -- APLICADO

INSERT ALL --Aplicado
INTO Raza_Mascota (Raza,Grupo) VALUES('Afgano', 'Perro')
SELECT * FROM dual;
INSERT ALL --Aplicado
INTO Raza_Mascota (Raza,Grupo) VALUES('Zaguate - Indeterminado', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Akita', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('American Staaffordshire Terrier', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Basenji', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Basset Hound', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Beagle', 'Perro')
SELECT * from dual;
INSERT ALL --Aplicado
INTO Raza_Mascota (Raza,Grupo) VALUES('Bedlington Terrier', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Bichon Friso', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Bloodhound', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Border Collie', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Borzoi', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Boxer', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Bull Terrier', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Bulldog Ingles', 'Perro')
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
INTO Raza_Mascota (Raza,Grupo) VALUES('Otro', 'Perro')
SELECT * from dual;
INSERT ALL --Aplicado
INTO Raza_Mascota (Raza,Grupo) VALUES('Persa', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Bobtail Americano', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Ruso Azul', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Somala', 'Gato')
SELECT * from dual;
INSERT ALL --Aplicado
INTO Raza_Mascota (Raza,Grupo) VALUES('Siberiano', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Manés', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Cruce', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Burmó', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Ragdoll', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Maine Coon', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Siamés', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Otro-Gato', 'Gato')
SELECT * from dual;
INSERT ALL --Aplicado
INTO Raza_Mascota (Raza,Grupo) VALUES('Canario', 'Ave')
INTO Raza_Mascota (Raza,Grupo) VALUES('Cacatúa', 'Ave')
INTO Raza_Mascota (Raza,Grupo) VALUES('Loro', 'Ave')
INTO Raza_Mascota (Raza,Grupo) VALUES('Agaporni', 'Ave')
INTO Raza_Mascota (Raza,Grupo) VALUES('Ninfa - Cockatiel', 'Ave')
INTO Raza_Mascota (Raza,Grupo) VALUES('Yaco', 'Ave')
INTO Raza_Mascota (Raza,Grupo) VALUES('Guacamayo', 'Ave')
INTO Raza_Mascota (Raza,Grupo) VALUES('Otro-Ave', 'Ave')
SELECT * from dual;
INSERT ALL --Aplicado
INTO Raza_Mascota (Raza,Grupo) VALUES('lagartijas', 'Reptil, Anfibio o Arácnido')
INTO Raza_Mascota (Raza,Grupo) VALUES('Serpientes', 'Reptil, Anfibio o Arácnido')
INTO Raza_Mascota (Raza,Grupo) VALUES('Anfibios', 'Reptil, Anfibio o Arácnido')
INTO Raza_Mascota (Raza,Grupo) VALUES('Tortugas', 'Reptil, Anfibio o Arácnido')
INTO Raza_Mascota (Raza,Grupo) VALUES('Tarántula', 'Reptil, Anfibio o Arácnido')
INTO Raza_Mascota (Raza,Grupo) VALUES('Cienpies', 'Reptil, Anfibio o Arácnido')
INTO Raza_Mascota (Raza,Grupo) VALUES('Escorpión', 'Reptil, Anfibio o Arácnido')
INTO Raza_Mascota (Raza,Grupo) VALUES('Cangrejo Ermitaño', 'Reptil, Anfibio o Arácnido')
INTO Raza_Mascota (Raza,Grupo) VALUES('Otro tipo', 'Reptil, Anfibio o Arácnido')
SELECT * from dual;
INSERT ALL  --Aplicado
INTO Raza_Mascota (Raza,Grupo) VALUES('Conejo', 'Roedor')
INTO Raza_Mascota (Raza,Grupo) VALUES('Hamster', 'Roedor')
INTO Raza_Mascota (Raza,Grupo) VALUES('Ratón', 'Roedor')
INTO Raza_Mascota (Raza,Grupo) VALUES('Chinchilla', 'Roedor')
INTO Raza_Mascota (Raza,Grupo) VALUES('Rata', 'Roedor')
INTO Raza_Mascota (Raza,Grupo) VALUES('Otro-Roedor', 'Roedor')
SELECT * FROM dual;
  
--------------------------------------------------------------------------------------------------------------

CREATE TABLE Usuario --CREADA
(
  username VARCHAR2(30)CONSTRAINT usuario_username_nn NOT NULL,
  CONSTRAINT usuario_pk PRIMARY KEY(username),
  CONSTRAINT usuario_username_un UNIQUE(username),
  Password VARCHAR2(20) CONSTRAINT usuario_password_nn NOT NULL,
  CONSTRAINT usuario_password_lenght CHECK(length(password)>7),
  
  Usuario_creacion VARCHAR2(20) CONSTRAINT usuario_ucreacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT usuario_fcreacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR2(20),
  Fecha_Modificacion DATE
);

CREATE PUBLIC SYNONYM Usuario FOR Administrador.Usuario; -- APLICADO


CREATE TABLE Persona --CREADA
(
  id Number,
  CONSTRAINT persona_pk PRIMARY KEY (ID),
  nombre VARCHAR2(20) CONSTRAINT persona_nombre_nn NOT NULL,
  apellido VARCHAR2(20) CONSTRAINT persona_apellido_nn NOT NULL,
  provincia VARCHAR2(10) CONSTRAINT persona_provincia_nn NOT NULL,
  telefono VARCHAR2(10) CONSTRAINT persona_telefono_nn NOT NULL,
  email VARCHAR2(40) CONSTRAINT persona_email_nn NOT NULL,
  --fecha_nacimiento DATE CONTRAINT fecha_nacimiento_nn NOT NULL,
  usuario NUMBER,
  CONSTRAINT persona_username_fk FOREIGN KEY (usuario) REFERENCES Usuario(id),
  genero VARCHAR2(20),
  CONSTRAINT persona_genero_bin CHECK(genero IN ('Masculino', 'Femenino')),
  
  Usuario_creacion VARCHAR2(20) CONSTRAINT persona_ucreacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT persona_fcreacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR2(20),
  Fecha_Modificacion DATE
);

ALTER TABLE Persona --Aplicado
  ADD CONSTRAINT persona_email_un UNIQUE(email);
ALTER TABLE Persona --Aplicado
  ADD CONSTRAINT persona_telefono_un UNIQUE(telefono);
ALTER TABLE Persona --Aplicado
  MODIFY (Lugar VARCHAR2(60));
ALTER TABLE Persona --Aplicado
  MODIFY (Lugar VARCHAR2(60) CONSTRAINT persona_lugar_nn NOT NULL);
  
CREATE PUBLIC SYNONYM Persona FOR Administrador.Persona; -- APLICADO

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

--Adopciones--

CREATE TABLE Adopcion --APLICADO
(
  id NUMBER,
  CONSTRAINT adopcion_id_pk PRIMARY KEY(id),
  persona NUMBER   CONSTRAINT adopcion_persona_nn NOT NULL,
  CONSTRAINT adopcion_persona_fk FOREIGN KEY(persona) REFERENCES Persona(id), --Foreign key de la persona adoptante
  mascota NUMBER CONSTRAINT adopcion_mascota_nn NOT NULL,
  CONSTRAINT adopcion_mascota_fk FOREIGN KEY(mascota) REFERENCES Mascota(id) --FK a mascota adoptada
);

CREATE PUBLIC SYNONYM Adopcion FOR Administrador.Adopcion; -- APLICADO

ALTER TABLE Adopcion --APLICADA
ADD (Usuario_creacion VARCHAR(20) CONSTRAINT adopcion_usuario_creacion_nn NOT NULL);

ALTER TABLE Adopcion --APLICADA
ADD(Fecha_creacion DATE CONSTRAINT adopcion_fecha_creacion_nn NOT NULL);


ALTER TABLE Adopcion --APLICADA
ADD (Usuario_Modificacion VARCHAR(20));

ALTER TABLE Adopcion --APLICADA
ADD(Fecha_Modificacion DATE);

--Calificaciones y lista negra---------


CREATE TABLE Califica_a
(
);

CREATE TABLE Agega_a_Lista_Negra
(
);

--Devoluciones 

CREATE TABLE Devoluciones
(
);

CREATE TABLE Tipo_Formulario
(
);

CREATE TABLE Respuesta
(
);

CREATE TABLE Pregunta
(
);

  
CREATE TABLE Formulario
(
);


  
  
