CREATE TABLESPACE SALVA_MASCOTA_DATA --CREADA
    DATAFILE 'D:\app\Daniel\oradata\dbprueba\SALVA_MASCOTA_DATA01.dbf'
    SIZE 10M
    REUSE
    AUTOEXTEND ON
    NEXT 512k
    MAXSIZE 200M;   
 --
 -- PE: INDEX
 --
 CREATE TABLESPACE SALVA_MASCOTA_IND --CREADA
    DATAFILE 'D:\app\Daniel\oradata\dbprueba\SALVA_MASCOTA_IND01.dbf'
    SIZE 10M
    REUSE
    AUTOEXTEND ON
    NEXT 512K
    MAXSIZE 200M;

--Cambiar los passwords por varas que den sentido
--Me parece que estan todos los grants necesarios, agregue o aviseme si faltan algunos
--ADMIN--------------------------------------------
CREATE USER Administrador --CREADA
    IDENTIFIED BY Admin12
    DEFAULT TABLESPACE salva_mascota_data
    QUOTA 10M ON salva_mascota_data
    TEMPORARY TABLESPACE temp
    QUOTA 5M ON system;
    
GRANT CONNECT TO Administrador --CREADA
GRANT CREATE PUBLIC SYNONYM TO Administrador; --CREADA
GRANT CREATE SESSION TO Administrador; --CREADA
GRANT CREATE TABLE TO Administrador; --CREADA
GRANT CREATE VIEW TO Administrador; --CREADA
GRANT CREATE TRIGGER TO Administrador; --CREADA
GRANT UNLIMITED TABLESPACE TO Administrador; --CREADA
GRANT CREATE SEQUENCE TO Administrador; --APLICADO
GRANT CREATE ANY JOB TO Administrador; --Aplicado

    
--VISITANTE--------------------------------------
CREATE USER Visitante --CREADA
    IDENTIFIED BY visitante13
    DEFAULT TABLESPACE salva_mascota_data
    QUOTA 10M ON salva_mascota_data
    TEMPORARY TABLESPACE temp
    QUOTA 5M ON system;
    
GRANT CONNECT TO Visitante; --CREADA
GRANT CREATE SESSION TO Visitante --CREADA
GRANT SELECT TO Visitante; --ERROR
    
--USUARIO---------------------------------------
CREATE USER Usuario --CREADA
    IDENTIFIED BY usuario14
    DEFAULT TABLESPACE salva_mascota_data
    QUOTA 10M ON salva_mascota_data
    TEMPORARY TABLESPACE temp
    QUOTA 5M ON system;
    
GRANT CONNECT TO usuario; --CREADA
GRANT CREATE PUBLIC SYNONYM TO usuario; --CREADA
GRANT CREATE SESSION TO usuario --CREADA 
GRANT UNLIMITED TABLESPACE TO usuario; --CREADA
