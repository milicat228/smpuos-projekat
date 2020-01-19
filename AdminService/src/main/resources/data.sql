-- ovlastenja korisnika
INSERT INTO authority(id, name) 
SELECT nextval('authority_seq'), 'ADMIN'
WHERE 
NOT EXISTS (
    SELECT 1 FROM authority WHERE name = 'ADMIN'
	);

-- dodavanje admina
INSERT INTO user_account(type, id, username, password, last_password_change_date, email, active, registration_date)
SELECT 'admin', nextval('user_id_generator_seq'), 'admin', '$2a$10$EpRfsM5Dld.7QUYieKbY1.EYYO9CozUiEVuhM8HYv3dpFStmFGd1m', current_timestamp, 'admin@admin.com', true, current_timestamp
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE username = 'nurse'
);

-- dodavanje ovlastenja adminu sestri
INSERT INTO user_account_authorities(user_account_id, authorities_id) 
SELECT u.id, a.id
FROM user_account u, authority a
WHERE u.username = 'admin' AND a.name = 'ADMIN' AND 
	NOT EXISTS (
    	SELECT 1 FROM user_account_authorities WHERE user_account_id = u.id
	);

