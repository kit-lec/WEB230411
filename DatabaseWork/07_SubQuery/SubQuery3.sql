CREATE TABLE test_emp_a (
   emp_id    INT,
   emp_name  VARCHAR(100)
);

CREATE TABLE test_emp_b (
   emp_id    INT,
   emp_name  VARCHAR(100)
);

SELECT * FROM test_emp_a;
SELECT * FROM test_emp_b;

-- 한 row 씩 INSERT 
INSERT INTO test_emp_a VALUES(101, '아이언맨');

INSERT INTO test_emp_b VALUES(201, '캡틴');

-- 여러개의 row 를 한번에 INSERT 
INSERT INTO test_emp_a
VALUES (102, '블랙위도우'), (103, '토르'), (104, '블랙팬서');


-- INSERT + subquery

INSERT INTO test_emp_a (SELECT 105, '스파이더맨');

-- 두배로 뻥튀기(?)
INSERT INTO test_emp_a (SELECT * FROM test_emp_a);

SELECT * FROM test_emp_a;

SELECT * FROM test_emp_b;

INSERT INTO test_emp_b(emp_id) (SELECT emp_id FROM test_emp_a);

SELECT * FROM phonebook;

INSERT INTO phonebook (SELECT * FROM phonebook); -- 에러

INSERT INTO phonebook(name, regdate) (SELECT name, now() FROM phonebook);


-- CREATE TABLE + Subquery
CREATE TABLE test_emp_c
AS
SELECT * FROM test_emp_a;

SELECT * FROM test_emp_c;

