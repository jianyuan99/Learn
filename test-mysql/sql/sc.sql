CREATE TABLE sc(
    sno VARCHAR(10),
    cno VARCHAR(10),
    grade VARCHAR(10),
    FOREIGN KEY (sno) REFERENCES student(id),
    FOREIGN KEY (cno) REFERENCES course(id)
);