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
--t_professor, t_department 테이블 : 
--입사일이 송도권 교수보다 나중에 입사한 사람의 
--이름과 입사일, 학과명을 출력하세요

SELECT p.name "교수명", 
	date_format(p.hiredate, '%Y-%m-%d') "입사일", 
	d.dname "학과명"
FROM t_professor p, t_department d
WHERE p.deptno = d.deptno
	AND p.hiredate > (SELECT hiredate FROM t_professor WHERE name = '송도권');

SELECT hiredate FROM t_professor WHERE name = '송도권';

SELECT p.name "교수명", 
	date_format(p.hiredate, '%Y-%m-%d') "입사일", 
	d.dname "학과명"
FROM t_professor p, t_department d
WHERE p.deptno = d.deptno AND p.hiredate > (SELECT hiredate FROM t_professor WHERE name = '송도권')
;

-- 과제
-- #7105) 연습
-- t_student 테이블 : 
-- 1전공이 101번인 학과의 평균 몸무게보다 몸무게가 많은 학생들의 
-- 이름과 몸무게를 출력하세요

SELECT name "이름", weight "몸무게"
FROM t_student
WHERE weight > (SELECT avg(weight) FROM t_student WHERE deptno1=101);
			
-- #7106) 연습
-- t_professor 테이블에서 
-- 심슨 교수와 같은 입사일에 입사한 교수 중, 
-- 조인형 교수보다 월급을 적게 받는 교수의 
-- 이름과 급여, 입사일을 출력하세요

SELECT 
	name "이름", 
	pay "급여", 
	hiredate "입사일"
FROM 
	t_professor
WHERE 
	hiredate = 
			( SELECT hiredate
			FROM t_professor
			WHERE name = '심슨')
	AND 
	pay < ( 
		SELECT pay
		FROM t_professor
		WHERE name = '조인형'
	);




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
-- #7109) 연습
-- t_student 테이블 : 
-- 전체학생중에서 체중이 4학년 학생들의 체중에서 
-- 가장 적게 나가는 학생보다 
-- 몸무게가 적은 학생의 이름과 학년과 몸무게를 출력하세요

SELECT name "이름", grade "학년", weight "몸무게"
FROM t_student
WHERE weight <ALL (SELECT weight FROM t_student WHERE grade = 4 );

-- WHERE weight < (SELECT min(weight) FROM t_student WHERE grade = 4 );  -- 가능
		
		
-- #7110) 연습
-- t_emp2, t_dept2 테이블 : 
-- 각 부서별 평균 연봉을 구하고 그 중에서 평균 연봉이 가장 적은 부서의 평균연봉보다 
-- 적게 받는 직원들의 부서명, 직원명, 연봉을 출력 하세요
		
SELECT d.dname "부서명", e.name "사원명", e.pay "연봉"
FROM t_emp2 e, t_dept2 d
WHERE e.deptno = d.dcode
AND e.pay < ALL ( SELECT AVG(pay) FROM t_emp2 GROUP BY deptno )
ORDER BY e.pay;




