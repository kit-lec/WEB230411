SHOW TABLES;

SELECT TABLE_NAME FROM information_schema.TABLES
WHERE TABLE_SCHEMA = 'mydb2304'
AND TABLE_NAME LIKE 't5_%'
;

SELECT * FROM t5_authority;
SELECT * FROM t5_user ORDER BY id DESC;
SELECT * FROM t5_user_authorities;
SELECT * FROM t5_post ORDER BY id DESC;
SELECT * FROM t5_comment ORDER BY id DESC;
SELECT * FROM t5_attachment ORDER BY id DESC;

-- 페이징 테스트용 다량의 데이터
INSERT INTO t5_post(user_id, subject, content)
SELECT user_id, subject, content FROM t5_post;

SELECT count(*) FROM t5_post;

SELECT * FROM t5_post ORDER BY id DESC LIMIT 5;

SELECT * FROM t5_post ORDER BY id DESC LIMIT 5, 5;


















