-- scott 의 급여
SELECT sal FROM t_emp WHERE ename = 'SCOTT';

SELECT ename, sal FROM t_emp
WHERE sal > (SELECT sal FROM t_emp WHERE ename = 'SCOTT')
;

-- #7103
SELECT deptno1 FROM t_student WHERE name = '이윤나';

SELECT 
	s.name "학생이름", 
	d.dname "1전공"
FROM 
	t_student s, t_department d
WHERE 
	s.deptno1 = d.deptno
	AND s.deptno1 = (SELECT deptno1 FROM t_student WHERE name = '이윤나')
	;

-- #7104
-- TODO

SELECT hiredate FROM t_professor WHERE name = '송도권';

SELECT p.name "교수명", 
	date_format(p.hiredate, '%Y-%m-%d') "입사일", 
	d.dname "학과명"
FROM t_professor p, t_department d
WHERE p.deptno = d.deptno AND p.hiredate > (SELECT hiredate FROM t_professor WHERE name = '송도권')
;

-- 과제
-- #7105
-- #7106



-- 2. 다중행 서브쿼리
-- Sub Query 결과가 2건 이상 출력되는 것을 말합니다.
-- 다중행 Sub Query 와 함께 사용하는 연산자
--		 IN 같은 값을 찾음
--		>ANY 최소값을 반환함 (서브쿼리 결과중 가장작은것보다 큰)
--		<ANY 최대값을 반환함 (서브쿼리 결과중 가장큰것보다 작은)
--		<ALL 최소값을 반환함 (서브쿼리 결과중 가장작은것보다 작은)
--		>ALL 최대값을 반환함 (서브쿼리 결과중 가장큰것보다 큰)
--		EXIST Sub Query 값이 있을 경우 반환


-- #7107) 예제
-- t_emp2, t_dept2 테이블 : 
-- 근무지역 (t_dept2.area) 이 서울 지사인 모든 사원들의 
-- 사번(empno)과 이름(name), 부서번호(deptno)를 출력하세요

SELECT dcode FROM t_dept2 WHERE area = '서울지사';

SELECT empno, name, deptno FROM t_emp2
WHERE deptno IN (SELECT dcode FROM t_dept2 WHERE area = '서울지사')
;

-- #7108) 연습
-- t_emp2 테이블 : 
-- 전체직원중 과장 직급의 최소연봉자보다 
-- 연봉이 높은 사람의 
-- 이름(name)과 직급(post), 연봉(pay)을 출력하세요.  
-- 단, 연봉 출력 형식은 천 단위 구분 기호와 원 표시를 하세요

SELECT
	name "이름", 
	post "직급",
	concat(format(pay, 0), '원') "연봉"
FROM t_emp2
WHERE pay >=ANY  (SELECT pay FROM t_emp2 WHERE post = '과장')
;

SELECT pay FROM t_emp2 WHERE post = '과장';

SELECT
	name "이름", 
	post "직급",
	concat(format(pay, 0), '원') "연봉"
FROM t_emp2
WHERE pay > (SELECT min(pay) FROM t_emp2 WHERE post = '과장');



-- 과제
-- #7109
-- #7110




