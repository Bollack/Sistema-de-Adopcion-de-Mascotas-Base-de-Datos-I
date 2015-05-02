CREATE TABLESPACE SALVA_MASCOTA_DATA --CREADA
    DATAFILE 'C:\app\Carlos\oradata\Progra1\SALVA_MASCOTA_DATA01.dbf'
    SIZE 10M
    REUSE
    AUTOEXTEND ON
    NEXT 512k
    MAXSIZE 200M;   
 --
 -- PE: INDEX
 --
 CREATE TABLESPACE SALVA_MASCOTA_IND --CREADA
    DATAFILE 'C:\app\Carlos\oradata\Progra1\SALVA_MASCOTA_IND01.dbf'
    SIZE 10M
    REUSE
    AUTOEXTEND ON
    NEXT 512K
    MAXSIZE 200M;

--Cambiar los passwords por varas que den sentido
--Me parece que estan todos los grants necesarios, agregue o aviseme si faltan algunos
--ADMIN--------------------------------------------
CREATE USER Administrador --CREADO
    IDENTIFIED BY Admin12
    DEFAULT TABLESPACE salva_mascota_data
    QUOTA 10M ON salva_mascota_data
    TEMPORARY TABLESPACE temp
    QUOTA 5M ON system;
    
GRANT CONNECT TO Administrador;--APLICADO
GRANT CREATE PUBLIC SYNONYM TO Administrador; --APLICADO
GRANT CREATE SESSION TO Administrador; --APLICADO
GRANT CREATE TABLE TO Administrador; --APLICADO
GRANT CREATE VIEW TO Administrador; --APLICADO
GRANT CREATE TRIGGER TO Administrador; --APLICADO
GRANT UNLIMITED TABLESPACE TO Administrador; --APLICADO
GRANT CREATE SEQUENCE TO Administrador; --APLICADO
GRANT CREATE ANY JOB TO Administrador; --APLICADO

    
--VISITANTE--------------------------------------
CREATE USER Visitante --CREADO
    IDENTIFIED BY visitante13
    DEFAULT TABLESPACE salva_mascota_data
    QUOTA 10M ON salva_mascota_data
    TEMPORARY TABLESPACE temp
    QUOTA 5M ON system;
    
GRANT CONNECT TO Visitante; --CREADO
GRANT CREATE SESSION TO Visitante; --CREADO
GRANT SELECT TO Visitante; --ERROR
    
--USUARIO---------------------------------------
CREATE USER Usuario --CREADO
    IDENTIFIED BY usuario14
    DEFAULT TABLESPACE salva_mascota_data
    QUOTA 10M ON salva_mascota_data
    TEMPORARY TABLESPACE temp
    QUOTA 5M ON system;
    
GRANT CONNECT TO usuario; --CREADO
GRANT CREATE PUBLIC SYNONYM TO usuario; --CREADO
GRANT CREATE SESSION TO usuario; --CREADO 
GRANT UNLIMITED TABLESPACE TO usuario; --CREADO
