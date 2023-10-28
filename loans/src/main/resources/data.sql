DROP TABLE IF EXISTS loans;

CREATE TABLE loans(
loan_id int NOT NULL PRIMARY KEY,
loan_nmbr int NOT NULL,
mobile_nmbr VARCHAR(10) NOT NULL,
loan_type VARCHAR(50) NOT NULL,
total_amount int NOT NULL,
amount_paid int NOT NULL,
outstanding_amt int NOT NULL,
created_dt date NOT NULL,
created_by VARCHAR(20) NOT NULL,
upated_at date DEFAULT NULL,
updated_by VARCHAR(20) DEFAULT NOT NULL
);
