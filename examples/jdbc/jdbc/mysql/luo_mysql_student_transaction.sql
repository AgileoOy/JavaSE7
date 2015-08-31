DROP TABLE Student;
CREATE TABLE Student (
       Id INT auto_increment,
       Nimi VARCHAR(30) NOT NULL,
       Demopisteet INT NOT NULL,
       Koepisteet INT NOT NULL,
       Syntymaaika DATE NOT NULL,
       PRIMARY KEY (Id)
) ENGINE=InnoDB;


INSERT INTO Student (Nimi,Demopisteet,Koepisteet,Syntymaaika) VALUES ('Aku',10,20, '1935-1-1');
INSERT INTO Student (Nimi,Demopisteet,Koepisteet,Syntymaaika) VALUES ('Hessu',12,22, '1938-2-2');
INSERT INTO Student (Nimi,Demopisteet,Koepisteet,Syntymaaika) VALUES ('Mikki', 4,19,'1937-10-10');
INSERT INTO Student (Nimi,Demopisteet,Koepisteet,Syntymaaika) VALUES ('Iines',11,22,'1939-1-1');
INSERT INTO Student (Nimi,Demopisteet,Koepisteet,Syntymaaika) VALUES ('Heluna', 13,22,'1940-12-31');
INSERT INTO Student (Nimi,Demopisteet,Koepisteet,Syntymaaika) VALUES ('Minni', 8,19,'1935-1-1');

SELECT * from Student;

# Luodaan tallennettava proseduuri (Stored procedure) MySQL 5-tietokantaan 
# (MySQL 5:sta lähtien MySQL:ssä on tuettu tallennettuja proseduureja)
delimiter //
CREATE PROCEDURE laskeRivitMaxId (OUT rivit INT, OUT maxid INT)
  BEGIN
    SELECT COUNT(*) INTO rivit FROM Student;
    SELECT MAX(Id) INTO maxid FROM Student;
  END;
//

delimiter ;
CALL laskeRivitMaxId(@a, @b);
SELECT @a, @b;

