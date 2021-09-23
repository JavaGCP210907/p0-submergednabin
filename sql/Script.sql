--create table users with their details

CREATE TABLE user_roles (
	user_role_id serial PRIMARY KEY,
	role_type TEXT --ROLE TYPE can be customer, employee, employer
);


INSERT INTO user_roles (role_type)
VALUES ('customer'),
	('bank_employee'),
	('manager'),
	('administrator' );
INSERT INTO user_roles (role_type)
VALUES ('bank employee');



CREATE TABLE accounts(
	id serial PRIMARY KEY,
	account_type TEXT
);

INSERT INTO accounts (account_type)
values('saving'),
('checking');
INSERT INTO accounts (account_type)
VALUES ('system-admin');

SELECT * FROM accounts a ;
--create user_details table where all the user information are stored and role id is used as foreign key
CREATE TABLE user_details(
	user_id serial PRIMARY KEY,
	first_name TEXT,
	last_name TEXT,
	email varchar UNIQUE,
	user_password varchar,
	phone_number int,
	country TEXT,
	state TEXT,
	city TEXT,
	apartment_number TEXT,
	zip int,
	date_created_at varchar,
	date_updated_at varchar,
	user_role_id_fk int REFERENCES user_roles(user_role_id),
	account_id int REFERENCES accounts(id)
	
);



--create transactions table that shows the user transactions like adding amount, timestamp etc

CREATE TABLE transactions(
	transaction_id serial PRIMARY KEY,
	user_id_fk int REFERENCES user_details(user_id),
	amount_deposit int,
	amount_withdraw int,
	amount_added_date varchar,
	amount_update_date varchar,
	transaction_status TEXT NOT NULL -- It gives information ON what kind OF TRANSACTION IS performed LIKE deposit OR withdraw
);


