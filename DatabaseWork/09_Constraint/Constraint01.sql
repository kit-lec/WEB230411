-- 제약조건 (Constraint)

-- 제약조건 확인하기
 
SELECT * FROM Information_schema.table_constraints
WHERE table_schema = 'mydb2304';

SELECT * FROM Information_schema.table_constraints
WHERE table_schema = 'mydb2304' AND table_name = "t_emp4";

DESC t_emp4;

SELECT * FROM t_dept2;

-- DROP TABLE IF EXISTS ~ CASCADE 옵션을 주면 
-- 이를 참조하는 다른 관계된 테이블의 데이터도 연쇄 삭제딤

DROP TABLE IF EXISTS t_emp4 CASCADE;
CREATE TABLE t_emp4 (
	NO INT(4) PRIMARY KEY,
	name VARCHAR(10) NOT NULL,
	jumin VARCHAR(13) NOT NULL UNIQUE,
	area INT(1) CHECK(area < 5),
	deptno VARCHAR(6) REFERENCES t_dept2(dcode)
);


DROP TABLE IF EXISTS t_emp4 CASCADE;
CREATE TABLE t_emp4 (
	NO INT(4),
	name VARCHAR(10) NOT NULL,
	jumin VARCHAR(13) NOT NULL,
	area INT(1),
	deptno VARCHAR(6),
	PRIMARY KEY(no),
	UNIQUE(jumin),
	CHECK(area < 5),
	FOREIGN KEY(deptno) REFERENCES t_dept2(dcode)
);

-- 제약조건에 이름을 달아 정의 가능
DROP TABLE IF EXISTS t_emp3 CASCADE;
CREATE TABLE t_emp3 (
	NO INT(4),
	name VARCHAR(10) NOT NULL,
	jumin VARCHAR(13) NOT NULL,
	area INT(1),
	deptno VARCHAR(6),
	CONSTRAINT emp3_no_pk PRIMARY KEY(no),
	CONSTRAINT emp3_jumin_uk UNIQUE(jumin),
	CONSTRAINT emp3_area_ck CHECK(area < 5),
	CONSTRAINT emp3_deptno_fk FOREIGN KEY(deptno) REFERENCES t_dept2(dcode)
);


SELECT * FROM Information_schema.table_constraints
WHERE table_schema = 'mydb2304' AND table_name = "t_emp3";

-- #9005)  t_emp3 에 제약조건에 맞는 / 위배되는 DML 시도해보기
-- 제약조건에 맞는 DML / 제약조건에 위배되는 DML
INSERT INTO t_emp3 VALUES(
	1, 'MySQL', '1234561234567', 4, 1000
); -- 두번 실행하면 오류
-- SQL Error [1062] [23000]: Duplicate entry '1' for key 't_emp3.PRIMARY'

INSERT INTO t_emp3 VALUES(
	2, '오라클', '1234561234567', 4, 1000
);-- jumin unique  오류
-- SQL Error [1062] [23000]: Duplicate entry '1234561234567' for key 't_emp3.emp3_jumin_uk'

INSERT INTO t_emp3 VALUES(
	2, '오라클', '2222222222222222222222222222', 4, 1000
);-- VARCHAR(13)  초과  오류
-- SQL Error [1406] [22001]: Data truncation: Data too long for column 'jumin' at row 1

INSERT INTO t_emp3 VALUES(
	2, 'tigers', '2222222222222', 3, 2000
);-- FK  오류
-- SQL Error [1452] [23000]: Cannot add or update a child row: a foreign key constraint fails (`mydb`.`t_emp3`, CONSTRAINT `emp3_deptno_fk` FOREIGN KEY (`deptno`) REFERENCES `t_dept2` (`DCODE`))

INSERT INTO t_emp3 (NO, jumin, area, deptno) VALUES(
	2, '3333333333333', 4, 1001
); -- NN 오류
-- SQL Error [1364] [HY000]: Field 'name' doesn't have a default value

INSERT INTO t_emp3 VALUES(
	2, 'tigers', '2222222222222', 10, 1000
);-- CHECK  오류
-- SQL Error [3819] [HY000]: Check constraint 'emp3_area_ck' is violated.


-- UPDATE/DELETE 에서도 제약조건 오류 발생할수 있다.
SELECT * FROM t_emp3;

UPDATE t_emp3 SET area = 10 WHERE NO = 1;

DELETE FROM t_dept2 WHERE dcode = 1000;  -- 참조되고 있는 부모측 데이터 삭제 불가

-- #9005)   ALTER 명령 사용하여 테이블 에 제약조건 추가가능
-- 위에서 생성한 t_emp4 테이블의 name 컬럼에 UNIQUE 제약조건 추가하기

ALTER TABLE t_emp4 ADD CONSTRAINT emp4_name_uk UNIQUE(name);

SELECT * FROM Information_schema.table_constraints 
WHERE table_schema="mydb2304" AND table_name="t_emp4";

-- #9007)    외래키 추가
-- t_emp4 테이블의 name 컬럼이 t_emp2 테이블의 
-- name 컬럼의 값을 참조하도록 참조키 제약조건을 설정하세요

ALTER TABLE t_emp4
ADD CONSTRAINT emp4_name_fk FOREIGN KEY(name) REFERENCES t_emp2(name);
-- SQL Error [1822] [HY000]: Failed to add the foreign key constraint. Missing index for constraint 'emp4_name_fk' in the referenced table 't_emp2'

-- 일단 부모테이블의 name 을 UNIQUE 로 바꾼뒤, 위의 쿼리를 다시 실행해보자
ALTER TABLE t_emp2 
ADD CONSTRAINT emp2_name_uk UNIQUE(name);


-- #9008)    t_emp3 테이블을 DROP 하고, 이전과 같은 조건으로 다시 만들되
-- t_dept2(dcode)를 참조하는 detpno 컬럼은
-- 부모테이블의 해당 데이터가 삭제되면 함께 삭제되도록 설정


-- 참조하는 부모테이블의 데이터에
-- ON DELETE [reference_option]
--
-- 1. RESTRICT : 개체를 변경/삭제할 때 다른 개체가 변경/삭제할 개체를 참조하고 있을 경우 변경/삭제가 취소됩니다.(제한)
-- 2. CASCADE : 개체를 변경/삭제할 때 다른 개체가 변경/삭제할 개체를 참조하고 있을 경우 함께 변경/삭제됩니다.
-- 3. NO ACTION : MYSQL에서는 RESTRICT와 동일합니다.
-- 4. SET NULL : 개체를 변경/삭제할 때 다른 개체가 변경/삭제할 개체를 참조하고 있을 경우 참조하고 있는 값은 NULL로 세팅됩니다.


-- https://dev.mysql.com/doc/refman/8.0/en/create-table-foreign-keys.html


DROP TABLE IF EXISTS t_emp3 CASCADE;
CREATE TABLE t_emp3 (
    no INT(4),
    name VARCHAR(10) NOT NULL,
    jumin VARCHAR(13) NOT NULL,
    area INT(1),
    deptno VARCHAR(6),
    CONSTRAINT emp3_no_pk PRIMARY KEY(NO),
    CONSTRAINT emp3_jumin_uk UNIQUE(jumin),
    CONSTRAINT emp3_area_ck CHECK(area < 5),
    CONSTRAINT emp3_deptno_fk FOREIGN KEY(deptno)
        REFERENCES t_dept2(dcode)
        ON DELETE CASCADE
        -- ON UPDATE
);









