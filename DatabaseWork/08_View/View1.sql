-- View

SHOW TABLES IN mydb2304;
SHOW FULL TABLES IN mydb2304;  -- Table_type !!


-- #8101)
-- t_professor 테이블의 profno, name, email, hpage 칼럼만
-- 사용하는 view를 생성하세요 view 의 이름은 v_prof로 하세요

CREATE OR REPLACE VIEW v_prof
AS
SELECT profno, name, email, hpage
FROM t_professor;

SELECT * FROM v_prof;


-- View 생성시 별도의 컬럼 이름을 줄수 있다
CREATE OR REPLACE VIEW v_prof(pfno, nm, em, hp)
AS
SELECT profno, name, email, hpage
FROM t_professor;

-- 인라인뷰
-- View 는 한번 만들어 놓으면 계속 사용할수 있습니다.
-- 그러나 1회용으로만 사용할 경우는 FROM 절의 서브쿼리 형태로 만들수 있습니다. 
-- 이러한 뷰를 Inline View 라 합니다.

-- #8103) 예제
-- t_student, t_department 테이블 : 
-- 학과별로 학생들의 최대키와 최대몸무게, 학과 이름을 출력하세요

SELECT d.dname "학과명", s.max_height "최대키", s.max_weight "최대몸무게"
FROM (SELECT deptno1, MAX(height) "max_height", MAX(weight) "max_weight"
	FROM t_student
	GROUP BY deptno1) s, t_department d
WHERE s.deptno1 = d.deptno;

-- 과제
-- #8104) 연습
-- t_student, t_department 테이블 : 
-- 학과별로 가장 키가 큰 학생들의 이름과 키, 
-- 학과이름을 인라인뷰 를 사용하여 다음과 같이 출력하세요

SELECT 
	d.dname "학과명", 
	a.max_height "최대키", 
	s.name "학생이름", 
	s.height "키"
FROM 
	(SELECT deptno1, MAX(height) max_height
	FROM t_student
	GROUP BY deptno1 )  a , 
	t_student s, 
	t_department d
WHERE 
	s.deptno1 = a.deptno1
	AND s.height = a.max_height
	AND s.deptno1 = d.deptno;


-- #8105) 연습
-- t_student 테이블 : 
-- 학생의 키가 동일 학년의 평균 키보다 큰 학생들의 
-- 학년과 이름과 키, 해당 학년의 평균키를 출력하되, 
-- inline view 를 사용해서 아래와 같이 출력하세요. 
-- 단 학년 칼럼은 오름 차순으로 정렬.

SELECT 
	s.grade "학년", 
	s.name "이름", 
	s.height "키", 
	a.avg_height "평균키"
FROM
	(SELECT grade, AVG(height) avg_height
	FROM t_student 
	GROUP BY grade) a, 
	t_student s
WHERE 
	a.grade = s.grade
	AND s.height > a.avg_height
ORDER BY 1;






