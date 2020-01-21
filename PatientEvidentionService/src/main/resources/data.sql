-- ovlastenja korisnika
INSERT INTO authority(id, name) 
SELECT nextval('authority_seq'), 'NURSE'
WHERE 
NOT EXISTS (
    SELECT 1 FROM authority WHERE name = 'NURSE'
	);

-- strucne spreme
INSERT INTO professional_qualification(id, name, description)
SELECT 1, 'I', 'osnovno obrazovanje'
WHERE 
NOT EXISTS (SELECT 1 FROM professional_qualification WHERE id = 1);

INSERT INTO professional_qualification(id, name, description)
SELECT 2, 'II', 'stručno osposobljavanje i neformalno obrazovanje'
WHERE 
NOT EXISTS (SELECT 1 FROM professional_qualification WHERE id = 2);

INSERT INTO professional_qualification(id, name, description)
SELECT 3, 'III', 'srednje stručno obrazovanje - 3 godine'
WHERE 
NOT EXISTS (SELECT 1 FROM professional_qualification WHERE id = 3);

INSERT INTO professional_qualification(id, name, description)
SELECT 4, 'IV', 'srednje gimnazijsko obrazovanje - 4 godine'
WHERE 
NOT EXISTS (SELECT 1 FROM professional_qualification WHERE id = 4);

INSERT INTO professional_qualification(id, name, description)
SELECT 5, 'IV', 'srednje stručno i umetničko obrazovanje obrazovanje - 4 godine'
WHERE 
NOT EXISTS (SELECT 1 FROM professional_qualification WHERE id = 5);

INSERT INTO professional_qualification(id, name, description)
SELECT 6, 'V', 'majstorsko ili specijalističko posle srednje obrazovanje (3+2 ili 4+1)'
WHERE 
NOT EXISTS (SELECT 1 FROM professional_qualification WHERE id = 6);

INSERT INTO professional_qualification(id, name, description)
SELECT 7, 'VI-1', 'OSS (180 esbp)'
WHERE 
NOT EXISTS (SELECT 1 FROM professional_qualification WHERE id = 7);

INSERT INTO professional_qualification(id, name, description)
SELECT 8, 'VI-1', 'OAS (180 esbp)'
WHERE 
NOT EXISTS (SELECT 1 FROM professional_qualification WHERE id = 8);

INSERT INTO professional_qualification(id, name, description)
SELECT 9, 'VI-2', 'OSS (240 esbp)'
WHERE 
NOT EXISTS (SELECT 1 FROM professional_qualification WHERE id = 9);

INSERT INTO professional_qualification(id, name, description)
SELECT 10, 'VI-2', 'OAS(240 esbp)'
WHERE 
NOT EXISTS (SELECT 1 FROM professional_qualification WHERE id = 10);

INSERT INTO professional_qualification(id, name, description)
SELECT 11, 'VII-1', 'MAS/IAS(300-360 esbp)'
WHERE 
NOT EXISTS (SELECT 1 FROM professional_qualification WHERE id = 11);

INSERT INTO professional_qualification(id, name, description)
SELECT 12, 'VII-1', 'MSS(300 esbp)'
WHERE 
NOT EXISTS (SELECT 1 FROM professional_qualification WHERE id = 12);

INSERT INTO professional_qualification(id, name, description)
SELECT 13, 'VII-2', 'SAS(+60 esbp)'
WHERE 
NOT EXISTS (SELECT 1 FROM professional_qualification WHERE id = 13);

INSERT INTO professional_qualification(id, name, description)
SELECT 14, 'VIII', 'DrS(+60 esbp)'
WHERE 
NOT EXISTS (SELECT 1 FROM professional_qualification WHERE id = 14);

-- dodavanje medicinske sestre
INSERT INTO user_account(type, id, username, password, last_password_change_date, email, active, registration_date, 
firstname, lastname, jmbg, date_of_birth, address, phone_number, professional_qualification_id)
SELECT 'nurse', nextval('nurse_id_generator_seq'), 'nurse', '$2a$10$JT96.VJpkDtmjmDTBvm.rOIh.9qHsW49N3OBC4fM14jzIJVfiDSu6', current_timestamp, 'nurse@nurse.com', true, current_timestamp
, 'Medicinska', 'Sestra', '2802991188736', TO_DATE('28.2.1991', 'DD.MM.YYYY'), 'Ulica bb, Novi Sad 21000', '060/1322175', 5
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE username = 'nurse'
);

-- dodavanje ovlastenja medicinskoj sestri
INSERT INTO user_account_authorities(user_account_id, authorities_id) 
SELECT u.id, a.id
FROM user_account u, authority a
WHERE u.username = 'nurse' AND a.name = 'NURSE' AND 
	NOT EXISTS (
    	SELECT 1 FROM user_account_authorities WHERE user_account_id = u.id
	);
	
-- dodavanje osnova osiguranja
INSERT INTO insurence_base(id, name) 
SELECT 1, 'Radni odnos'
WHERE 
NOT EXISTS (SELECT 1 FROM insurence_base WHERE id = 1);

INSERT INTO insurence_base(id, name) 
SELECT 8, 'Vrhunski i profesionalni sportisti'
WHERE 
NOT EXISTS (SELECT 1 FROM insurence_base WHERE id = 8);

INSERT INTO insurence_base(id, name) 
SELECT 9, 'Korisnik penzije'
WHERE 
NOT EXISTS (SELECT 1 FROM insurence_base WHERE id = 9);

INSERT INTO insurence_base(id, name) 
SELECT 11, 'Nezaposleno lice'
WHERE 
NOT EXISTS (SELECT 1 FROM insurence_base WHERE id = 11);

INSERT INTO insurence_base(id, name) 
SELECT 14, 'Borac, vojni invalid ili porodica poginulog boraca'
WHERE 
NOT EXISTS (SELECT 1 FROM insurence_base WHERE id = 14);

INSERT INTO insurence_base(id, name) 
SELECT 15, 'Socijalno osiguranje'
WHERE 
NOT EXISTS (SELECT 1 FROM insurence_base WHERE id = 15);

INSERT INTO insurence_base(id, name) 
SELECT 14, 'Borac, vojni invalid ili porodica poginulog boraca'
WHERE 
NOT EXISTS (SELECT 1 FROM insurence_base WHERE id = 14);

--unos obveznika plaćanja osiguranja
INSERT INTO insurence_payer(id, name) 
SELECT 1, 'Fakultet Tehničkih Nauka'
WHERE 
NOT EXISTS (SELECT 1 FROM insurence_base WHERE id = 1);

INSERT INTO insurence_payer(id, name) 
SELECT 2, 'Univer Export'
WHERE 
NOT EXISTS (SELECT 1 FROM insurence_base WHERE id = 2);

INSERT INTO insurence_payer(id, name) 
SELECT 3, 'Opština Novi Sad'
WHERE 
NOT EXISTS (SELECT 1 FROM insurence_base WHERE id = 3);

INSERT INTO insurence_payer(id, name) 
SELECT 4, 'Gradska biblioteka'
WHERE 
NOT EXISTS (SELECT 1 FROM insurence_base WHERE id = 4);

--unos pacijenata
INSERT INTO patient(id, firstname, lastname, JMBG, date_of_birth, gender, lbo, zk)
SELECT 1, 'Milica', 'Todorović', '2802997188736', TO_DATE('28.2.1997', 'dd.MM.yyyy'), 1, '21600308163', '20044507604'
WHERE 
NOT EXISTS (SELECT 1 FROM patient WHERE id = 1);

--unos pacijenata
INSERT INTO patient(id, firstname, lastname, JMBG, date_of_birth, gender, lbo, zk)
SELECT 2, 'Isteklo', 'Osiguranje', '2802997188788', TO_DATE('11.11.1965', 'dd.MM.yyyy'), 1, '27700296463', '20060508684'
WHERE 
NOT EXISTS (SELECT 1 FROM patient WHERE id = 3);

--unos pacijenata
INSERT INTO patient(id, firstname, lastname, JMBG, date_of_birth, gender, lbo, zk)
SELECT 3, 'Milana', 'Todorović', '2802347188736', TO_DATE('28.2.1997', 'dd.MM.yyyy'), 1, '28700346910', '20048667362'
WHERE 
NOT EXISTS (SELECT 1 FROM patient WHERE id = 3);


