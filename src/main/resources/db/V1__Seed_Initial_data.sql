insert into roles (id, name)
values (1, 'ADMIN'),
       (2, 'VENDOR'),
       (3, 'INVESTOR');

insert into statuses (id, status_name)
values (1, 'UNVERIFIED'),
       (2, 'PENDING'),
       (4, 'APPROVED'),
       (5, 'ACTIVE'),
       (6, 'ENDED');

insert into users (id, username, password_hash, first_name, last_name, email, address, role_id)
values (1, 'nickdunn', 'password', 'Nick', 'Dunn',
        'ndunn@amazon.com', 'Sofia, ul.Levski 14, 1200', 1),
       (2, 'annabrown', 'password', 'Anna', 'Brown',
        'abrown@gmail.com', 'Sofia, ul.Rez 1, 1000', 2),
       (3, 'jeffbezos', 'password', 'Jeff', 'Bezos',
        'jbefoz@amazon.com', 'San Fransisco, SF112, USA', 3);

insert into admins (id, user_id)
values (1, 1);

insert into vendors (id, company_name, user_id)
values (1, 'Lab Solutions', 2);

insert into investors (id, company_name, user_id)
values (1, 'Amazon', 3);

insert into debtors (id, company_name, address, email)
values (1, 'BuzziSpace', 'Antwerp, Belgium', 'hello@buzzispace.com');

insert into auctions (id, user_id, start_date, end_date, start_price, bid_step)
values (1, 2, '2025-04-20', '2025-04-25', 7000, 250.00);

insert into invoices (id, amount, description, issue_date, due_date, user_id, debtor_id, auction_id)
values (1, 10000.00, 'Marketing images for a new product.',
        '2025-04-15', '2025-06-15', 2, 1, 1);




























