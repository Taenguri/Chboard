create table board(
	board_no number(4) primary key,
    title varchar2(100) not null,
    content varchar2(2000) not null,
    writer varchar2(100) not null,
    regdate date default sysdate,
    hit number(4) default 0,
    new_mark varchar2(30) default 'false'
);

create sequence board_seq;

//샘플데이터 삽입
insert into board(board_no,title,content,writer)(select board_seq.nextval, title,content, writer from board);	