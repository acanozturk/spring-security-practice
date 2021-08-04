INSERT INTO customers(name, email, mobile_number, pwd, role)
    ('user','user@user.com', '5446875366', '$2a$12$t2lOfR0qySVdkfxp3UGk5OAiZfM3mQKTrVl7zt.tFPpGfgqSQhn1u', 'user'),
('admin','admin@admin.com', '5554561234', '$2y$12$IPaRi2Qn8dMOP20pXuWggumWXD7M0tRq58GLxtEv7.8Z/.2Ptrxhm', 'admin');


INSERT INTO accounts(customer_id, account_type, branch_address)
VALUES (1, 'Savings', '123 Main Street, New York');


INSERT INTO transactions(account_number, customer_id, transaction_summary, transaction_type, transaction_amt, closing_balance, transaction_dt)
VALUES
(1, 1, 'Coffee', 'Withdrawal', 30, 34500, '2020-5-18'),
(1, 1, 'Uber', 'Withdrawal', 100, 34400, '2020-5-25'),
(1, 1, 'Grocery', 'Withdrawal', 400, 34000, '2020-6-8'),
(1, 1, 'Self Deposit', 'Deposit', 6000, 40000, '2020-10-18'),
(1, 1, 'Check', 'Deposit', 10000, 50000, '2020-11-22');


INSERT INTO loans(customer_id, loan_type, total_loan, amount_paid, outstanding_amount, start_dt)
VALUES
(1, 'Mortgage', 300000, 230000, 70000, '2020-10-13'),
(1, 'Car', 20000, 5000, 1500, '2021-5-8'),
(1, 'Personal', 10000, 10000, 0, '2020-7-22');


INSERT INTO cards(customer_id, card_number, card_type, total_limit, amount_used, available_amount)
VALUES
(1, '4565XXXX4656', 'Credit', 10000, 500, 9500),
(1, '5468XXXX9855', 'Bank', 15000, 8000, 7000);


INSERT INTO notices(notice_summary, notice_details, notic_beg_dt, notic_end_dt)
VALUES
('Home Loan Interest rates reduced', 'Home loan interest rates are reduced as per the goverment guidelines. The updated rates will be effective immediately','2020-10-14', '2020-11-30'),
('Net Banking Offers', 'Customers who will opt for Internet banking while opening a saving account will get a $50 amazon voucher', '2020-10-14', '2020-12-05'),
('Mobile App Downtime', 'The mobile application of the EazyBank will be down from 2AM-5AM on 12/05/2020 due to maintenance activities', '2020-10-14', '2020-12-01'),
('E Auction notice', 'There will be a e-auction on 12/08/2020 on the Bank website for all the stubborn arrears.Interested parties can participate in the e-auction', '2020-10-14', '2020-12-08');

INSERT INTO authorities(customer_id, name)
VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');