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

INSERT INTO customers(name, email, mobile_number, pwd, role)
VALUES ('user', 'user@user.com', '5554561234', '$2y$12$IPaRi2Qn8dMOP20pXuWggumWXD7M0tRq58GLxtEv7.8Z/.2Ptrxhm', 'admin');

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

INSERT INTO accounts(customer_id, account_type, branch_address)
VALUES (1, 'Savings', '123 Main Street, New York');

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

INSERT INTO transactions(account_number, customer_id, transaction_summary, transaction_type, transaction_amt,
                         closing_balance, transaction_dt)
VALUES (1, 1, 'Coffee', 'Withdrawal', 30, 34500, '2020-5-18'),
       (1, 1, 'Uber', 'Withdrawal', 100, 34400, '2020-5-25'),
       (1, 1, 'Grocery', 'Withdrawal', 400, 34000, '2020-6-8'),
       (1, 1, 'Self Deposit', 'Deposit', 6000, 40000, '2020-10-18'),
       (1, 1, 'Check', 'Deposit', 10000, 50000, '2020-11-22');

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

INSERT INTO loans(customer_id, loan_type, total_loan, amount_paid, outstanding_amount, start_dt)
VALUES (1, 'Mortgage', 300000, 230000, 70000, '2020-10-13'),
       (1, 'Car', 20000, 5000, 1500, '2021-5-8'),
       (1, 'Personal', 10000, 10000, 0, '2020-7-22');

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

INSERT INTO cards(customer_id, card_number, card_type, total_limit, amount_used, available_amount)
VALUES (1, '4565XXXX4656', 'Credit', 10000, 500, 9500),
       (1, '5468XXXX9855', 'Bank', 15000, 8000, 7000);

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

INSERT INTO notices(notice_summary, notice_details, notic_beg_dt, notic_end_dt)
VALUES ('Home Loan Interest rates reduced',
        'Home loan interest rates are reduced as per the goverment guidelines. The updated rates will be effective immediately',
        '2020-10-14', '2020-11-30'),
       ('Net Banking Offers',
        'Customers who will opt for Internet banking while opening a saving account will get a $50 amazon voucher',
        '2020-10-14', '2020-12-05'),
       ('Mobile App Downtime',
        'The mobile application of the EazyBank will be down from 2AM-5AM on 12/05/2020 due to maintenance activities',
        '2020-10-14', '2020-12-01'),
       ('E Auction notice',
        'There will be a e-auction on 12/08/2020 on the Bank website for all the stubborn arrears.Interested parties can participate in the e-auction',
        '2020-10-14', '2020-12-08');

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
