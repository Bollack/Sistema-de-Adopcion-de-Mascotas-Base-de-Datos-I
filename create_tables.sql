--Scripts de creacion & alter de tablas
--Orden de creacion de tablas: Persona, Usuario, Tipo, Raza, Mascota

CREATE TABLE Mascota --Aplicado
(
  ID NUMBER,
  CONSTRAINT pk_mascotas PRIMARY KEY (ID),
  Tipo VARCHAR2(15) CONSTRAINT tipo_mascota_nn NOT NULL,
  CONSTRAINT tipo_fk FOREIGN KEY (Tipo) REFERENCES Tipo_Mascota(Especie),
  Raza VARCHAR2(60) CONSTRAINT raza_mascota_nn NOT NULL,
  CONSTRAINT raza_fk FOREIGN KEY (Raza) REFERENCES Raza_Mascota(Raza),
  Nombre VARCHAR2(20) DEFAULT('Sin nombre'),
  Tamano VARCHAR2(10) CONSTRAINT tamano_mascota_nn NOT NULL,
  Color1  VARCHAR2(20) CONSTRAINT color1_mascota_nn NOT NULL,
  Color2  VARCHAR2(20),
  Contacto  NUMBER CONSTRAINT rescatista_de_mascota_nn NOT NULL,
  CONSTRAINT contacto_fk FOREIGN KEY(contacto) REFERENCES Persona(id),
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
  Sexo VARCHAR2(20) CONSTRAINT mascota_sexo_nn NOT NULL,
  CONSTRAINT mascota_sexo_check CHECK(Estado IN ('Macho','Hembra')),
  Situacion_abandono VARCHAR2(100),
  Sevetidad VARCHAR2(30) CONSTRAINT mascota_severidad_nn NOT NULL,
  
  Usuario_creacion VARCHAR2(20) CONSTRAINT mascota_ucreacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT mascota_fcreacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR2(20),
  Fecha_Modificacion DATE
);
  
CREATE OR REPLACE PUBLIC SYNONYM Mascota FOR Administrador.Mascota; -- CREADO
 
CREATE TABLE Tipo_Mascota --
(
  Especie VARCHAR2(45),
  CONSTRAINT tipo_mascota_pk PRIMARY KEY (Especie),
  
  Usuario_creacion VARCHAR2(20) CONSTRAINT tipo_mascota_ucreacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT tipo_mascota_fcreacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR2(20),
  Fecha_Modificacion DATE
);

CREATE OR REPLACE PUBLIC SYNONYM Tipo_Mascota FOR Administrador.Tipo_Mascota; -- CREADO

  
INSERT ALL --APLICADO(N)
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
  Grupo VARCHAR2(40) CONSTRAINT grupo_raza_mascotas_nn NOT NULL,
  
  Usuario_creacion VARCHAR2(20) CONSTRAINT raza_mascota_ucreacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT raza_mascota_fcreacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR2(20),
  Fecha_Modificacion DATE,
  CONSTRAINT grupo_mascota_fk FOREIGN KEY (Grupo) REFERENCES Tipo_Mascota(Especie)
);
  
CREATE OR REPLACE PUBLIC SYNONYM Raza_Mascota FOR Administrador.Raza_Mascota; -- CREADO

INSERT ALL --Aplicado(n)
INTO Raza_Mascota (Raza,Grupo) VALUES('Afgano', 'Perro')
SELECT * FROM dual;
INSERT ALL --Aplicado(n)
INTO Raza_Mascota (Raza,Grupo) VALUES('Zaguate - Indeterminado', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Akita', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('American Staaffordshire Terrier', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Basenji', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Basset Hound', 'Perro')
INTO Raza_Mascota (Raza,Grupo) VALUES('Beagle', 'Perro')
SELECT * from dual;
INSERT ALL --Aplicado(n)
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
INSERT ALL --Aplicado(n)
INTO Raza_Mascota (Raza,Grupo) VALUES('Persa', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Bobtail Americano', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Ruso Azul', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Somala', 'Gato')
SELECT * from dual;
INSERT ALL --Aplicado(n)
INTO Raza_Mascota (Raza,Grupo) VALUES('Siberiano', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Manés', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Cruce', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Burmó', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Ragdoll', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Maine Coon', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Siamés', 'Gato')
INTO Raza_Mascota (Raza,Grupo) VALUES('Otro-Gato', 'Gato')
SELECT * from dual;
INSERT ALL --Aplicado(n)
INTO Raza_Mascota (Raza,Grupo) VALUES('Canario', 'Ave')
INTO Raza_Mascota (Raza,Grupo) VALUES('Cacatúa', 'Ave')
INTO Raza_Mascota (Raza,Grupo) VALUES('Loro', 'Ave')
INTO Raza_Mascota (Raza,Grupo) VALUES('Agaporni', 'Ave')
INTO Raza_Mascota (Raza,Grupo) VALUES('Ninfa - Cockatiel', 'Ave')
INTO Raza_Mascota (Raza,Grupo) VALUES('Yaco', 'Ave')
INTO Raza_Mascota (Raza,Grupo) VALUES('Guacamayo', 'Ave')
INTO Raza_Mascota (Raza,Grupo) VALUES('Otro-Ave', 'Ave')
SELECT * from dual;
INSERT ALL --Aplicado(n)
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
INSERT ALL --Aplicado(n)
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
  username VARCHAR2(30),
  CONSTRAINT usuario_pk PRIMARY KEY(username),
  Password VARCHAR2(20) CONSTRAINT usuario_password_nn NOT NULL,
  CONSTRAINT usuario_password_lenght CHECK(length(password)>7),
  
  Usuario_creacion VARCHAR2(20) CONSTRAINT usuario_ucreacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT usuario_fcreacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR2(20),
  Fecha_Modificacion DATE
);

CREATE OR REPLACE PUBLIC SYNONYM Usuario FOR Administrador.Usuario; -- CREADO

CREATE TABLE Persona --CREADA
(
  id Number,
  CONSTRAINT persona_pk PRIMARY KEY (ID),
  nombre VARCHAR2(20) CONSTRAINT persona_nombre_nn NOT NULL,
  apellido VARCHAR2(20) CONSTRAINT persona_apellido_nn NOT NULL,
  telefono VARCHAR2(10) CONSTRAINT persona_telefono_nn NOT NULL,
  CONSTRAINT persona_telefono_un UNIQUE(telefono),
  email VARCHAR2(40) CONSTRAINT persona_email_nn NOT NULL,
  CONSTRAINT persona_email_un UNIQUE(email),
  lugar VARCHAR2(100) CONSTRAINT persona_lugar_nn NOT NULL,
  usuario VARCHAR2(30),
  CONSTRAINT persona_username_fk FOREIGN KEY (usuario) REFERENCES Usuario(username),
  genero VARCHAR2(20),
  CONSTRAINT persona_genero_bin CHECK(genero IN ('Masculino', 'Femenino')),
  
  Usuario_creacion VARCHAR2(20) CONSTRAINT persona_ucreacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT persona_fcreacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR2(20),
  Fecha_Modificacion DATE
);
  
CREATE OR REPLACE PUBLIC SYNONYM Persona FOR Administrador.Persona; -- CREADO


--Adopciones--
CREATE TABLE Adopcion( --CREADA(n)
  id_adopcion NUMBER,
  CONSTRAINT adopcion_id_pk PRIMARY KEY(id_adopcion),
  persona NUMBER CONSTRAINT adopcion_persona_nn NOT NULL,
  CONSTRAINT adopcion_persona_fk FOREIGN KEY(persona) REFERENCES Persona(id), --Foreign key de la persona adoptante
  mascota NUMBER CONSTRAINT adopcion_mascota_nn NOT NULL,
  CONSTRAINT adopcion_mascota_fk FOREIGN KEY(mascota) REFERENCES Mascota(id), --FK a mascota adoptada
  rescatista NUMBER CONSTRAINT adopcion_rescatista_nn NOT NULL,
  CONSTRAINT adopcion_rescatista_fk FOREIGN KEY(rescatista) REFERENCES Persona(id), --Foreign key del que dio en adopcion
  fecha DATE DEFAULT (SYSDATE),
  
  Usuario_creacion VARCHAR(20) CONSTRAINT adopcion_usuario_creacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT adopcion_fecha_creacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR(20),
  Fecha_Modificacion DATE
);
CREATE OR REPLACE PUBLIC SYNONYM Adopcion FOR Administrador.Adopcion; -- CREADO

---Tabla fotos de adopcion
CREATE TABLE Foto_adopcion(--CREADA
  id_foto_adopcion NUMBER,
  CONSTRAINT foto_adopcion_pk PRIMARY KEY(id_foto_adopcion),
  id_adopcion NUMBER CONSTRAINT id_adopcion_nn NOT NULL,
  CONSTRAINT id_adopcion_fk FOREIGN KEY(id_adopcion) REFERENCES Adopcion(id_adopcion),
  foto BLOB CONSTRAINT foto_nn NOT NULL,
  descripcion VARCHAR2(150),
  
  Usuario_creacion VARCHAR2(20) CONSTRAINT foto_adopcion_ucreacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT foto_adopcion_fcreacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR2(20),
  Fecha_Modificacion DATE
);
CREATE OR REPLACE PUBLIC SYNONYM Foto_Adopcion FOR Administrador.Foto_adopcion;--CREADO

--Calificaciones y lista negra
CREATE TABLE Califica_a(
  id_calificacion NUMBER,
  CONSTRAINT calificacion_pk PRIMARY KEY(id_calificacion),
  id_calificador NUMBER,
  CONSTRAINT id_calificador_fk FOREIGN KEY(id_calificador) REFERENCES Persona(id),
  id_calificado NUMBER,
  CONSTRAINT id_calificado_fk FOREIGN KEY(id_calificado) REFERENCES Persona(id),
  calificacion NUMBER CONSTRAINT calificacion_nn NOT NULL,
  notas VARCHAR2(200),
  
  Usuario_creacion VARCHAR2(20) CONSTRAINT califica_a_ucreacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT califica_a_fcreacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR2(20),
  Fecha_Modificacion DATE
);
CREATE OR REPLACE PUBLIC SYNONYM Califica_a FOR Administrador.Califica_a;

CREATE TABLE Agrega_a_Lista_Negra(--CREADA
  id_agregado_lista_negra NUMBER,
  CONSTRAINT id_lista_negra_pk PRIMARY KEY(id_agregado_lista_negra),
  id_agregado NUMBER,
  CONSTRAINT id_agregado_fk FOREIGN KEY(id_agregado) REFERENCES Persona(id),
  id_reportante NUMBER,
  CONSTRAINT id_reportante_fk FOREIGN KEY(id_reportante) REFERENCES Persona(id),

  Usuario_creacion VARCHAR2(20) CONSTRAINT agrega_lnegra_ucreacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT agrega_lnegra_fcreacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR2(20),
  Fecha_Modificacion DATE
);
CREATE OR REPLACE PUBLIC SYNONYM Agrega_a_lista_negra FOR Administrador.Agrega_a_lista_negra;--CREADO

--Devoluciones 
CREATE TABLE Devoluciones(--CREADA
  id_devolucion NUMBER,
  CONSTRAINT id_devolucion_pk PRIMARY KEY(id_devolucion),
  fecha DATE DEFAULT (SYSDATE),
  motivo VARCHAR2(200) CONSTRAINT motivo_nn NOT NULL,
  id_dueno_anterior NUMBER,
  CONSTRAINT id_dueno_anterior_fk FOREIGN KEY(id_dueno_anterior) REFERENCES Persona(id),
  id_mascota_devuelta NUMBER,
  CONSTRAINT id_mascota_devuelta_fk FOREIGN KEY(id_mascota_devuelta) REFERENCES Mascota(id),
  
  Usuario_creacion VARCHAR2(20) CONSTRAINT devolucion_ucreacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT devolucion_fcreacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR2(20),
  Fecha_Modificacion DATE
);
CREATE OR REPLACE PUBLIC SYNONYM Devoluciones FOR Administrador.Devoluciones;--CREADO

--Formularios:
CREATE TABLE Respuesta(--CREADA
  id_respuesta NUMBER,
  CONSTRAINT id_respuesta_pk PRIMARY KEY(id_respuesta),
  respuesta VARCHAR2(100) CONSTRAINT respuesta_nn NOT NULL,
  posible_valor_a_variable VARCHAR2(100),
  pregunta NUMBER,
  CONSTRAINT pregunta_fk FOREIGN KEY(pregunta) REFERENCES Pregunta(id_pregunta),
  usuario NUMBER,
  CONSTRAINT usuario_pregunta_fk FOREIGN KEY(usuario) REFERENCES Persona(id),

  Usuario_creacion VARCHAR2(20) CONSTRAINT respuesta_ucreacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT respuesta_fcreacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR2(20),
  Fecha_Modificacion DATE
);
CREATE OR REPLACE PUBLIC SYNONYM Respuesta FOR Administrador.Respuesta;--CREADO

CREATE TABLE Pregunta(--CREADA
  id_pregunta NUMBER,
  CONSTRAINT id_pregunta_pk PRIMARY KEY(id_pregunta),
  enunciado VARCHAR2(200) CONSTRAINT enunciado_nn NOT NULL,
  variable_a_hallar VARCHAR2(100),
  numero_respuestas NUMBER,
  numero_respuesta NUMBER,
  
  Usuario_creacion VARCHAR2(20) CONSTRAINT pregunta_ucreacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT pregunta_fcreacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR2(20),
  Fecha_Modificacion DATE
);
CREATE OR REPLACE PUBLIC SYNONYM Pregunta FOR Administrador.Preugnta;--CREADO
  
CREATE TABLE Formulario(--CREADA
  id_formulario NUMBER,
  CONSTRAINT id_formulario_pk PRIMARY KEY(id_formulario),
  id_usuario NUMBER,
  CONSTRAINT id_usuario_fk FOREIGN KEY(id_usuario) REFERENCES Persona(id),

  Usuario_creacion VARCHAR2(20) CONSTRAINT formulario_ucreacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT formulario_fcreacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR2(20),
  Fecha_Modificacion DATE
);
CREATE OR REPLACE PUBLIC SYNONYM Formulario FOR Administrador.Formulario;--CREADO

--Bitacora mascotas
CREATE TABLE Bitacora_mascotas(--CREADA
  id_bitacora NUMBER,
  CONSTRAINT id_bitacora_pk PRIMARY KEY(id_bitacora),
  id_mascota NUMBER,
  CONSTRAINT id_mascata_bitacora_fk FOREIGN KEY(id_mascota) REFERENCES Mascota(id),
  id_persona,
  CONSTRAINT id_persona_bitacora_fk FOREIGN KEY(id_persona) REFERENCES Persona(id),
  tipo VARCHAR2(20) CONSTRAINT tipo_bitacora_nn NOT NULL,
  fecha DATE DEFAULT(SYSDATE),
  
  Usuario_creacion VARCHAR2(20) CONSTRAINT bitacora_ucreacion_nn NOT NULL,
  Fecha_creacion DATE CONSTRAINT bitacora_fcreacion_nn NOT NULL,
  Usuario_Modificacion VARCHAR2(20),
  Fecha_Modificacion DATE
);
CREATE OR REPLACE PUBLIC SYNONYM Bitacora_mascotas FOR Administrador.Bitacora_mascotas;--CREADO
