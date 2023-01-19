Create database CheckApp;

Use CheckApp;

Create table Projects(
    IdProject int not null primary key auto_increment,
    Name varchar(50) not null,
    Description varchar(255) null,
    CreateDate DATETIME ,
    UpdateDate DATETIME
);

Create table Tasks(
    IdTask int not null primary key auto_increment,
    Name varchar(50) not null,
    Description varchar(255) null,
    Completed boolean not null,
    Notes varchar(255) null,
    DeadLine varchar(30) not null,
    CreateDate DATETIME,
    UpdateDate DATETIME,
    IdProject int not null,
    constraint FK_Tasks_Projects foreign key(IdProject)
    references Projects(IdProject)
    on DELETE CASCADE
);