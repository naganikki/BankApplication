DROP TABLE IF EXISTS cards;

CREATE TABLE IF NOT EXISTS cards (
    card_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    mobile_nmbr VARCHAR(10) NOT NULL,
    card_nmbr VARCHAR(50) NOT NULL,
    card_type VARCHAR(50) NOT NULL,
    total_limit int NOT NULL,
    amount_used int NOT NULL,
    available_amount int NOT NULL,
    created_dt date NOT NULL,
    created_by VARCHAR(20) NOT NULL,
    updated_dt date NOT NULL,
    updated_by VARCHAR(20) NOT NULL
);