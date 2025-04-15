create table roles
(
    id int auto_increment primary key ,
    name varchar(50) unique not null
);

create table statuses
(
    id int auto_increment primary key ,
    status_name varchar(20) unique
);

create table users
(
    id int auto_increment primary key ,
    username char(25) not null unique ,
    password_hash varchar(255) not null ,
    first_name varchar(20) not null ,
    last_name varchar(20) not null ,
    email varchar(50) not null ,
    address varchar(255) not null ,
    registered_at datetime default  current_timestamp ,
    role_id int not null ,

    constraint fk_users_role_id
        foreign key (role_id) references roles (id)
);

create table admins
(
    id int auto_increment primary key ,
    user_id int ,

    constraint fk_admins_user_id
        foreign key (user_id) references users (id)
);

create table vendors
(
    id int auto_increment primary key ,
    company_name varchar(255) ,
    user_id int ,

    constraint fk_vendors_user_id
        foreign key (user_id) references users (id)
);

create table investors
(
    id int auto_increment primary key ,
    company_name varchar(255) ,
    user_id int ,

    constraint fk_investors_user_id
        foreign key (user_id) references users (id)
);

create table debtors
(
    id int auto_increment primary key ,
    company_name varchar(20) not null ,
    address varchar(200) not null ,
    email varchar(50) not null
);

create table auctions
(
    id int auto_increment primary key ,
    start_date datetime not null ,
    end_date datetime not null ,
    bid_step decimal(15,2) not null ,
    created_at datetime default current_timestamp,
    updated_ad datetime ,
    user_id int ,
    status_id int default 1 ,

    constraint fk_auctions_user_id
        foreign key (user_id) references users (id) ,
    constraint fk_auctions_status_id
        foreign key (status_id) references statuses (id)
);

create table invoices
(
    id int auto_increment primary key ,
    amount decimal(15,2) not null ,
    description varchar(500) not null ,
    created_at datetime default current_timestamp ,
    issue_date datetime not null ,
    due_date datetime not null ,
    user_id int ,
    debtor_id int ,
    auction_id int ,
    status_id int default 1 ,

    constraint fk_invoices_users_id
        foreign key (user_id) references users (id) ,
    constraint fk_invoices_debtor_id
        foreign key (debtor_id) references debtors (id) ,
    constraint fk_invoices_auction_id
        foreign key (auction_id) references auctions (id) ,
    constraint fk_invoices_status_id
        foreign key (status_id) references statuses (id)
);

create table bids
(
    id int auto_increment primary key ,
    amount decimal(15,2) not null ,
    user_id int ,
    auction_id int,

    constraint fk_bids_user_id
        foreign key (user_id) references users (id) ,
    constraint fk_bids_auction_id
        foreign key (auction_id) references auctions (id)
);






























