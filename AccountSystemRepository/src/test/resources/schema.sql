create schema discovery;

create table member
(
    MEMBER_ID int auto_increment
        primary key,
    MEMBER_FIRST_NAME varchar(45) not null,
    MEMBER_LAST_NAME varchar(45) not null,
    MEMBER_EMAIL varchar(70) not null,
    MEMBER_PHONE varchar(15) not null
);

create table account
(
    ACCOUNT_NUMBER int auto_increment
        primary key,
    MEMBER_ID int not null,
    TYPE varchar(45) not null,
    BALANCE double null,
    constraint MEMBER_ID
        foreign key (MEMBER_ID) references member (MEMBER_ID)
);

create index FKr5j0huynd7nsv1s7e9vb8qvwo
    on account (MEMBER_ID);

create table transaction
(
    TRANSACTION_ID int auto_increment
        primary key,
    ACCOUNT_NUMBER int not null,
    AMOUNT double not null,
    TRANSACTION_DATE date not null,
    constraint ACCOUNT_NUMBER
        foreign key (ACCOUNT_NUMBER) references account (ACCOUNT_NUMBER)
);

create index FKa80kblc0ww9p9xjei8luheqlk
    on transaction (ACCOUNT_NUMBER);

