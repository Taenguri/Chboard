create table users(
	user_no number(4) primary key,
    user_id varchar2(50) not null,
    user_name varchar2(50) not null,
    user_password varchar2(100) not null,
    verify varchar2(20) default '일반사용자'
);

create sequence user_no_seq;
