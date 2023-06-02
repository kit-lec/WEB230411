-- 비등가 조인 (Non-Equi Join)

-- #6201) 
-- t_customer 테이블, t_gift 테이블을 join 하여  
-- 고객의 마일리지 포인트별로 받을수 있는 상품을 조회하여 
-- 고객의 '이름(c_name)'과 포인트(c_point) 상품명(g_name)을 출력하세요
-- BETWEEN ~ AND ~ 사용

SELECT * FROM t_customer;
SELECT * FROM t_gift;

-- MySQL
SELECT c.c_name "고객명", c.c_point "POINT", g.g_name "상품명"
FROM t_customer c, t_gift g
WHERE c.c_point BETWEEN g.g_start AND g.g_end
;

-- ANSI 
SELECT c.c_name "고객명", c.c_point "POINT", g.g_name "상품명"
FROM t_customer c JOIN t_gift g
ON c.c_point BETWEEN g.g_start AND g.g_end
;

--  #6202) 연습 
-- 앞 예제에서 조회한 상품의 이름(gname)과 필요수량이 몇개인지 조회하세요
-- (그룹함수 동원되어야 한다)

-- MySQL
SELECT g.g_name "상품명", count(*) "필요수량"
FROM t_customer c, t_gift g
WHERE c.c_point BETWEEN g.g_start AND g.g_end
GROUP BY g.g_name
;

-- ------------------------------------------------------------
-- 지금까지의 Join 은 INNER JOIN 이다

SELECT e.ename, d.dname FROM t_emp e, t_dept d;
SELECT e.ename, d.dname FROM t_emp e CROSS JOIN t_dept d;


-- ------------------------------------------------
-- OUTER JOIN

SELECT
    s.name "학생이름",
    p.name "교수이름"
FROM
    t_student s LEFT OUTER JOIN t_professor p
    ON s.profno = p.profno;

-- OUTER JOIN 은 따로 MySQL 구문 없다.


-- #6207)
-- t_student, t_professor 테이블 join :  
-- 학생이름과 지도교수 이름을 출력, 
-- 단! 지도 학생이 결정되지 않은 교수 명단도 출력

SELECT
    s.name "학생이름",
    p.name "교수이름"
FROM
    t_student s RIGHT OUTER JOIN t_professor p
    ON s.profno = p.profno;

-- #6208)
-- t_student, t_professor 테이블 join :  
-- 학생이름과 지도교수 이름을 출력, 
-- 단! 지도 학생이 결정되지 않은 교수 명단, 
-- 지도교수가 결정되지 않은 학생명단 모두 출력

SELECT
    s.name "학생이름",
    p.name "교수이름"
FROM
    t_student s FULL OUTER JOIN t_professor p  -- MySQL 은 FULL OUTER 지원 안함..
    ON s.profno = p.profno;
   
-- 대신에 UNION 을 사용하여 FULL OUTER 구현   
SELECT
    s.name "학생이름",
    p.name "교수이름"
FROM
    t_student s LEFT OUTER JOIN t_professor p
    ON s.profno = p.profno   
UNION   
SELECT
    s.name "학생이름",
    p.name "교수이름"
FROM
    t_student s RIGHT OUTER JOIN t_professor p
    ON s.profno = p.profno;   
   
-- ---------------------------------
-- self join
   
-- #6209) 
-- t_dept2 테이블에서 
-- 부서명 과 그 부서의 상위부서명을 출력하세요

SELECT * FROM t_dept2;   
   
SELECT d1.dname 부서명, d2.dname 상위부서명
FROM t_dept2 d1, t_dept2 d2
WHERE d1.PDEPT = d2.dcode;
;   
   
-- # 과제
-- #6210
-- t_professor 테이블 : 교수번호, 교수이름, 입사일, 
-- 그리고 자신보다 입사일 빠른 사람의 인원수를 출력하세요, 
-- 단 자신보다 입사일이 빠른 사람수를 오름차순으로 출력하세요
-- hint: left outer 사용 
--         / 그룹함수 사용

-- left outer 를 사용하는 이유는 '조인형' 교수 때문.
-- 조인형 교수보다 먼저 입사한 사람이 없기 때문에 일반 join으론 하면 조인형 교수가 join 에서 빠져버린다.

SELECT	
	a.profno "교수번호",
	a.name "교수명",
	date_format(a.hiredate, '%Y-%m-%d') "입사일",
	count(b.hiredate) "빠른사람"
FROM t_professor a 
	LEFT OUTER JOIN t_professor b 
	ON b.hiredate < a.hiredate
GROUP BY 
	a.profno, a.name, a.hiredate
ORDER BY 빠른사람
;




   