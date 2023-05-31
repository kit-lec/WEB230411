-- 산술연산자
-- +, -, *, /

-- t_emp 테이블
-- 직원이름(ename), 급여(sal), 급여10%인상분

SELECT ename, sal, sal * 1.1
FROM t_emp;

-- WHERE : 원하는 조건만 검색

-- SELECT [컬럼명 또는 표현식] 
-- FROM [테이블명, 뷰명]  
-- WHERE [조건절] ;

SELECT * FROM t_emp WHERE job = 'SALESMAN';
SELECT * FROM t_emp WHERE job = 'SALESMAn';  -- MySQL 은 대소문자 구분없이 비교 (기본동작)
SELECT * FROM t_emp WHERE BINARY(job) = 'SALESMAn';  -- MySQL 에서 대소문자 구분없이 비교

-- t_emp 테이블에서 10번 부서에 근무하는 사원의 이름과 급여와 부서번호 출력
SELECT ename, sal, deptno FROM t_emp WHERE deptno = 10;


-- t_emp 테이블에서 급여(sal) 가 4000보다 큰 사람의 이름과 급여를 출력하세요
SELECT ename, sal FROM t_emp WHERE sal > 4000;


-- t_emp 테이블에서 이름이 SCOTT인 사람의 이름과 사원번호, 급여 출력
SELECT ename, empno, sal FROM t_emp WHERE ename = 'SCOTT';

-- 학생 테이블(t_student) 에서
-- 2,3 학년(grade) 학생의  이름(name), 학년(grade) 출력

SELECT name, grade FROM t_student
WHERE grade = 2 OR grade = 3;

SELECT name, grade FROM t_student
WHERE grade IN(2, 3);

SELECT name, grade FROM t_student
WHERE grade NOT IN(1, 4);

SELECT name, grade FROM t_student
WHERE grade BETWEEN 2 AND 3;

-- 교수님 (t_professor) 중에서
-- 급여 (pay) 가 300 보다 크고,
-- 직급 (position) 이 '정교수' 인 분들의
-- 이름(name), 급여(pay), 직급(position) 을 출력하세요
SELECT name, pay, position
FROM t_professor 
WHERE pay > 300 AND POSITION = '정교수'
;

-- 보너스(bonus)를 못받고 있는 
-- 교수님의 이름(name)과 직급(position)를 출력하세요
SELECT  name, position FROM t_professor 
WHERE bonus is null;

-- LIKE 와 같이 쓰는 와일드 카드  % ,  _
-- % : 글자수 제한 없고 어떤 글자가 와도 됨
-- _ : 글자수는 한글자가 반드시 와야 되고 어떤 글자 와도 좋음

--  교수님 중에서 김씨 성을 가진 교수님의 이름만 출력 (LIKE 사용)
SELECT name FROM t_professor WHERE name LIKE '김%'
;

-- 직원 테이블(t_emp)에서 직원이름 (ename) 중에
-- NE 문자열이 포함된 직원만 출력

SELECT ename FROM t_emp WHERE ename LIKE '%NE%';

-- 직원 테이블(t_emp)에서 직원이름 (ename) 중에
-- 두번째 글자가 'A' 인 사람의 이름(ename)만 출력

SELECT ename FROM t_emp WHERE ename LIKE '_A%';

---------------------------------

-- ORDER BY
-- 직원중 이름에 L 이 들어간 사람의 이름을 사전오름차순으로 출력하기

SELECT ename FROM t_emp
-- ORDER BY ename ASC
ORDER BY ename DESC
;

-- SELECT [컬럼명 또는 표현식] 
-- FROM [테이블명, 뷰명]  
-- WHERE [조건절] ;
-- ORDER BY [정렬할 컬럼] [ASC|DESC]...    (ORDER BY 절 SELECT 의 가장 마지막)

-- 직원의 이름,직책, 급여를 출력하되
-- 우선은 직책(job) 사전 내림차순으로, 
-- 그리고 급여(sal) 오름차순으로 출력

SELECT ename, job, sal FROM t_emp
ORDER BY job DESC, sal ASC
;



