-- 복합키 제약조건 만들기

CREATE TABLE test_member (
    mb_uid INT NOT NULL,
    mb_nick VARCHAR(10) NOT NULL,
    mb_name VARCHAR(10) NOT NULL,
	CONSTRAINT test_member_pk PRIMARY KEY(mb_uid, mb_nick)
);

INSERT INTO test_member VALUES(1, 'aaa', 'John');
INSERT INTO test_member VALUES(1, 'bbb', 'John');  -- 가능

SELECT * FROM test_member;


