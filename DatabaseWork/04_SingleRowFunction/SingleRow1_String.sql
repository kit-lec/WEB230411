SELECT 'Hello', lower('Hello'), upper('Hello');

SELECT name, id, upper(id) FROM t_student;

-- t_student 테이블 : 
-- ID가 9글자 이상인 학생들의 
-- 이름과 ID 와 글자수 출력 / length() 사용

SELECT name, id, length(id) FROM t_student WHERE LENGTH(id) >= 9;  -- 단일행함수는 WHERE 조건절에서 사용 가능

---------------------------------------------
-- SUBSTR 함수 
-- 구문: SUBSTR( ‘문자열’ 또는 컬럼명,   시작위치,  추출할 글자수 )
-- 문자열에서 특정 길이의 문자를 추출할 때 사용하는 함수
-- 시작위치, 음수 가능.
-- ★ 시작 인덱스가 1부터 시작한다 (인덱스는 1부터 시작) 

SELECT substr('ABCDE', 2, 3);
SELECT substr('ABCDE', 2);
SELECT substr('ABCDE', -2, 2);  -- 음수인덱싱 가능

-- #4107
-- t_student 테이블 : 
-- jumin 칼럼을 사용해서 
-- 1전공(deptno1)이 101번인 학생의 이름과 생년월일 출력 / substr() 사용
SELECT name, substr(jumin, 1, 6) "생년월일"
FROM t_student WHERE deptno1 = 101
;

SELECT * FROM t_student ;

-- #4109
SELECT name, jumin  FROM t_student
WHERE substr(jumin, 7, 1) IN ('2', '4') AND grade = 4
;

-------------------------------------------------
-- INSTR()
-- 주어진 문자열이나 컬럼에서 특정 글자의 위치를 찾아주는 함수 (인덱스 리턴)

SELECT instr('ABCDEFG', 'D');
SELECT instr('ABCDEFG', 'EF');
SELECT instr('ABCDEFG', 'EFX'); -- 못찾으면 0 리턴

-- #4110
SELECT name, tel, instr(tel, ')') 위치 
FROM t_student
;

-- #4111
select NAME , TEL, substr(tel, 1, instr(tel, ')') - 1) 지역번호
from t_student
where deptno1 = 101;







