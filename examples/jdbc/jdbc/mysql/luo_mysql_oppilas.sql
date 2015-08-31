CREATE TABLE oppilas (
       Id integer NOT NULL,
       Nimi char(64) NOT NULL default '',
       Demopisteet integer(4) NOT NULL,
       Koepisteet integer(4) NOT NULL default '',
       PRIMARY KEY (Id)
);


INSERT INTO oppilas (Id,Nimi,Demopisteet,Koepisteet) VALUES (01,'Aku',10,20);
INSERT INTO oppilas (Id,Nimi,Demopisteet,Koepisteet) VALUES (02,'Hessu',12,22);
INSERT INTO oppilas (Id,Nimi,Demopisteet,Koepisteet) VALUES (03,'Mikki', 4,19);
INSERT INTO oppilas (Id,Nimi,Demopisteet,Koepisteet) VALUES (04,'Iines',11,22);
INSERT INTO oppilas (Id,Nimi,Demopisteet,Koepisteet) VALUES (05,'Heluna', 13,22);
INSERT INTO oppilas (Id,Nimi,Demopisteet,Koepisteet) VALUES (06,'Minni', 8,19);

select * from oppilas;
select * from oppilas where id='05';
SELECT * FROM oppilas WHERE Demopisteet > 10 AND Demopisteet < 15;