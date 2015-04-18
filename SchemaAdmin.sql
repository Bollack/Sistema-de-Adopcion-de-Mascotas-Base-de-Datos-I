CREATE TABLESPACE SALVA_MASCOTA_DATA
    DATAFILE 'D:\app\Daniel\oradata\dbprueba\SALVA_MASCOTA_DATA01.dbf'
    SIZE 10M
    REUSE
    AUTOEXTEND ON
    NEXT 512k
    MAXSIZE 200M;   
 --
 -- PE: INDEX
 --
 CREATE TABLESPACE SALVA_MASCOTA_IND
    DATAFILE 'D:\app\Daniel\oradata\dbprueba\SALVA_MASCOTA_IND01.dbf'
    SIZE 10M
    REUSE
    AUTOEXTEND ON
    NEXT 512K
    MAXSIZE 200M;

--Cambiar los passwords por varas que den sentido
--Me parece que estan todos los grants necesarios, agregue o aviseme si faltan algunos
--ADMIN--------------------------------------------
CREATE USER admin
    IDENTIFIED BY admin
    DEFAULT TABLESPACE salva_mascota_data
    QUOTA 10M ON salva_mascota_data
    TEMPORARY TABLESPACE temp
    QUOTA 5M ON system;
    
GRANT CONNECT TO admin;
GRANT CREATE PUBLIC SYNONYM TO admin;
GRANT CREATE SESSION TO admin;
GRANT CREATE TABLE TO admin;
GRANT CREATE VIEW TO admin;
GRANT CREATE TRIGGER TO admin;
GRANT UNLIMITED TABLESPACE TO admin;
    
--VISITANTE--------------------------------------
CREATE USER visitante
    IDENTIFIED BY visitante
    DEFAULT TABLESPACE salva_mascota_data
    QUOTA 10M ON salva_mascota_data
    TEMPORARY TABLESPACE temp
    QUOTA 5M ON system;
    
GRANT CONNECT TO visitante;
GRANT CREATE SESSION TO visitante;
    
--USUARIO---------------------------------------
CREATE USER usuario
    IDENTIFIED BY usuario
    DEFAULT TABLESPACE salva_mascota_data
    QUOTA 10M ON salva_mascota_data
    TEMPORARY TABLESPACE temp
    QUOTA 5M ON system;
    
GRANT CONNECT TO usuario;
GRANT CREATE PUBLIC SYNONYM TO usuario;
GRANT CREATE SESSION TO usuario;
GRANT UNLIMITED TABLESPACE TO usuario;
