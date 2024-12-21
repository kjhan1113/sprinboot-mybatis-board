
# DB setting

create table board_table(
id bigint primary key auto_increment,
boardTitle varchar(50),
boardWriter varchar(20),
boardPass varchar(20),
boardContent varchar(500),
boardHits int default 0,
createdAt datetime default now(),
fileAttached int default 0
);

create table board_file_table(
id bigint primary key auto_increment,
originalFileName varchar(100),
storedFileName varchar(100),
boardId bigint,
constraint fk_board_file foreign key(boardId) references board_table(id) on delete cascade
);