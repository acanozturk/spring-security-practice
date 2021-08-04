CREATE DATABASE spring_security;
USE spring_security;


CREATE TABLE customers
(
    customer_id   INT          NOT NULL AUTO_INCREMENT,
    name          VARCHAR(100) NOT NULL,
    email         VARCHAR(100) NOT NULL,
    mobile_number VARCHAR(20)  NOT NULL,
    pwd           VARCHAR(500) NOT NULL,
    role          VARCHAR(100) NOT NULL,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (customer_id)
);


CREATE TABLE accounts
(
    account_number INT          NOT NULL AUTO_INCREMENT,
    customer_id    INT          NOT NULL,
    account_type   VARCHAR(100) NOT NULL,
    branch_address VARCHAR(200) NOT NULL,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (account_number),
    FOREIGN KEY (customer_id) REFERENCES customers (customer_id) ON DELETE CASCADE
);


CREATE TABLE transactions
(
    transaction_id      INT          NOT NULL AUTO_INCREMENT,
    account_number      INT          NOT NULL,
    customer_id         INT          NOT NULL,
    transaction_summary VARCHAR(200) NOT NULL,
    transaction_type    VARCHAR(100) NOT NULL,
    transaction_amt     INT          NOT NULL,
    closing_balance     INT          NOT NULL,
    transaction_dt      DATE         NOT NULL,
    created_at          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (transaction_id),
    FOREIGN KEY (account_number) REFERENCES accounts (account_number) ON DELETE CASCADE,
    FOREIGN KEY (customer_id) REFERENCES customers (customer_id) ON DELETE CASCADE
);


CREATE TABLE loans
(
    loan_number        INT          NOT NULL AUTO_INCREMENT,
    customer_id        INT          NOT NULL,
    loan_type          VARCHAR(100) NOT NULL,
    total_loan         INT          NOT NULL,
    amount_paid        INT          NOT NULL,
    outstanding_amount INT          NOT NULL,
    start_dt           DATE         NOT NULL,
    created_at         TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (loan_number),
    FOREIGN KEY (customer_id) REFERENCES customers (customer_id) ON DELETE CASCADE
);


CREATE TABLE cards
(
    card_id          INT          NOT NULL AUTO_INCREMENT,
    customer_id      INT          NOT NULL,
    card_number      VARCHAR(20)  NOT NULL,
    card_type        VARCHAR(100) NOT NULL,
    total_limit      INT          NOT NULL,
    amount_used      INT          NOT NULL,
    available_amount INT          NOT NULL,
    created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (card_id),
    FOREIGN KEY (customer_id) REFERENCES customers (customer_id) ON DELETE CASCADE
);


CREATE TABLE notices
(
    notice_id      INT          NOT NULL AUTO_INCREMENT,
    notice_summary VARCHAR(200) NOT NULL,
    notice_details VARCHAR(500) NOT NULL,
    notic_beg_dt   DATE         NOT NULL,
    notic_end_dt   DATE      DEFAULT NULL,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at     DATE      DEFAULT NULL,
    PRIMARY KEY (notice_id)
);


CREATE TABLE contacts
(
    contact_id    INTEGER       NOT NULL AUTO_INCREMENT,
    contact_name  VARCHAR(50)   NOT NULL,
    contact_email VARCHAR(100)  NOT NULL,
    subject       VARCHAR(500)  NOT NULL,
    message       VARCHAR(2000) NOT NULL,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (contact_id)
);
