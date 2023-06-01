-- FROM 절의 테이블에 별칭(alias) 를 줄수 있다

-- 학생 20명
SELECT s.studno, s.name, s.deptno1 
FROM t_student s;

-- 학과 12개
SELECT d.deptno, d.dname
FROM t_department d;

-- 카티션곱 (Cartesian Product)
-- 두개의 테이블을 JOIN 하게 되면, 
-- 각 테이블의 레코드들의 모든 조합이 출력된다.
-- WHERE 나 ON 등으로 JOIN 조건이 주어지지 않으면 
-- 모든 카티션곱이 출력된다. 

-- 240개 <= 20 x 12
SELECT 
	s.studno, s.name, s.deptno1,
	d.deptno, d.dname
FROM t_student s, t_department d;

-- 위의 카티션 곱에서 조건을 주면 원한는 레코드만 추출 가능.

-----------------------------------------------------------------------------------
-- Equi Join (등가 Join)
-- 일반적으로 많이 쓰이는 Join 이며, 양쪽 테이블 Join 한 카티션곱에서 ‘같은조건’이 존재할 경우만 값을 가져오는 것

-- 예) #6101 
-- t_student 테이블과 t_department 테이블을 사용하여 학생이름, 1전공 학과번호, 1전공 학과 이름을 출력하세요

-- MySQL 구문
SELECT 
	s.name, s.deptno1, d.dname
FROM t_student s, t_department d
WHERE s.deptno1 = d.deptno   -- JOIN 조건
;

-- ANSI SQL (표준 SQL)구문
SELECT 
	s.name, s.deptno1, d.dname
FROM 
	t_student s 
	JOIN t_department d ON s.deptno1 = d.deptno   -- JOIN 조건
;

-- 제2전공은?
-- null 값은 JOIN 조건에 참여 안함 ★
SELECT 
	s.name, s.deptno2, d.dname
FROM t_student s, t_department d
WHERE s.deptno2 = d.deptno   -- JOIN 조건
;


-- 연습 #6102)
-- t_student 테이블, t_professor 테이블 을 join하여
-- ‘학생이름’, ‘지도교수번호’, ‘지도교수이름’ 을 출력하세요

-- MySQL 구문
select 
   s.name 학생이름, p.PROFNO 지도교수, p.NAME 지도교수이름
from t_student s , t_professor p
where s.profno = p.PROFNO;

-- ANSI 구문
select 
   s.name 학생이름, p.PROFNO 지도교수, p.NAME 지도교수이름
from 
   t_student s join t_professor p on s.profno = p.PROFNO;

-- 3테이블 JOIN

-- #6103
-- t_student, t_department, t_professor 테이블 을 join 하여 
--  학생의 이름, 학과이름, 지도교수 이름  을 출력하세요

-- MySQL 구문
SELECT s.name "학생이름", d.dname "학과이름", p.name "교수이름"
FROM t_student s, t_department d, t_professor p
WHERE s.deptno1 = d.deptno AND s.profno = p.profno
  
-- ANSI 구문
SELECT s.name "학생이름", d.dname "학과이름", p.name "교수이름"
FROM 
	t_student s
	JOIN t_department d ON s.deptno1 = d.deptno
	JOIN t_professor p ON  s.profno = p.profno
;

-- #6105

-- MySQL 구문
select 
   s.name 학생이름, p.NAME 지도교수이름
from t_student s , t_professor p
where s.profno = p.PROFNO  -- JOIN 조건
	AND s.deptno1 = 101;   -- 일반 검색 조건
	-- 단! 위 join 조건 보다 검색조건을 먼저 수행하게 된다.
	-- 일반적으로 DB 내부에선 JOIN 조건보다 검색조건을 먼저 수행 -> 카티션곱 부하를 줄이기 위해


-- ANSI 구문
select 
   s.name 학생이름, p.NAME 지도교수이름
from 
   t_student s join t_professor p on s.profno = p.PROFNO
WHERE s.deptno1 = 101;

 


