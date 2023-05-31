SELECT 100;
SELECT 100 * 2;
SELECT 'abcde';
SELECT '안녕하세요', '수요일입니다', 100 + 10;

-- SELECT - 데이터 조회/질의
-- SELECT [컬럼명 또는 표현식] FROM [테이블명, 뷰명]

-- '모든 컬럼' 조회 : * 사용
SELECT * FROM t_professor;


SELECT * FROM t_emp;

SELECT empno, ename
FROM t_emp;

SELECT empno, ename
FROM t_emp;

SELECT ename, empno, empno, empno
FROM t_emp;

-- select 컬럼에 별칭 (alias) 
SELECT studno 학번, name 이름
FROM t_student;

SELECT studno "학생 학번", name AS 이름
FROM t_student;

-- t_dept 테이블을 사용하여 deptno를 '부서#', dname을 '부서명', loc를 '위치' 로 별명을 설정하여 출력
SELECT deptno "부서#", dname "부서명", loc "위치" FROM t_dept;

-- DISTINCT - 중복값 제거하고 출력
-- SELECT  DISTINCT [컬럼명 또는 표현식] FROM [테이블명, 뷰명] ;

SELECT DISTINCT deptno FROM t_emp;

-- 문자열 연결 concat()

SELECT 'hello' + 'world';

SELECT concat('hello', 'world');

SELECT name, position FROM t_professor ;
SELECT concat(name, '-', POSITION) AS 교수님목록 FROM t_professor ;

