create table reply(
	reply_no number(4) primary key,
	board_no number(4) not null,
    reply_content varchar2(2000) not null,
    reply_writer varchar2(100) not null,
    reply_regdate date default sysdate,
	constraint reply_board foreign key(board_no)
	references board(board_no) on delete cascade
);

create sequence reply_seq;

