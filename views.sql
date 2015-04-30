CREATE VIEW todo_mascota(id_Mascota, Tipo, Raza, Nombre, Tamano, Color1, Color2,
Nivel_energia, Espacio_requerido, Facilidad_entrenamiento, Enfermedades, Veterinario,
Medicamentos, Estado, Notas, Tratamientos, Nombre_contacto, Telefono_contacto,
Correo_contacto, Fecha_creacion) AS
SELECT Mascota.id, Mascota.Tipo, Mascota.Raza, Mascota.Nombre, Mascota.Tamano,
Mascota.Color1, Mascota.Color2, Mascota.Nivel_energia, Mascota.Espacio_requerido,
Mascota.Facilidad_entrenamiento, Mascota.Enfermedades, Mascota.Veterinario,
Mascota.Medicamentos, Mascota.Estado, Mascota.Notas, Mascota.Tratamientos,
Persona.nombre, Persona.Telefono, Persona.email, Mascota.Fecha_creacion
FROM Mascota, Persona
WHERE Mascota.Contacto = Persona.id;

CREATE VIEW todo_persona(id_Persona, Nombre, Apellido, Provincia, Telefono, Correo,
Lugar, Genero, Username, Fecha_creacion) AS
SELECT id, nombre, apellido, provincia, telefono, email, lugar, genero, usuario, fecha_creacion
FROM Persona;

--Compilado
CREATE VIEW calificaciones AS
SELECT  get_nombreCompleto_from_id(id_calificador) AS calificador,
calificacion, get_nombreCompleto_from_id(id_calificado) AS calificado, Fecha_creacion AS Fecha
FROM Califica_a;

