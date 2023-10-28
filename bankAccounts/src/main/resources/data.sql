DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS accounts;

CREATE TABLE IF NOT EXISTS customer(
customer_id int AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL,
mobile_nmbr VARCHAR(15) NOT NULL,
created_dt date NOT NULL,
created_by VARCHAR(20) NOT NULL,
upated_at date DEFAULT NULL,
updated_by VARCHAR(20) DEFAULT NOT NULL
);

CREATE TABLE IF NOT EXISTS accounts(
customer_id int NOT NULL,
account_nmbr int AUTO_INCREMENT PRIMARY KEY,
account_type VARCHAR(100) NOT NULL,
branch_addrs VARCHAR(100) NOT NULL,
created_dt date NOT NULL,
created_by VARCHAR(20) NOT NULL,
upated_at date DEFAULT NULL,
updated_by VARCHAR(20) DEFAULT NOT NULL
);



