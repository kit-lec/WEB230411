-- 숫자형
-- 문자형
-- 날짜/시간형

SELECT 1 + '1'; -- 2

SELECT 1 + CAST('1' AS SIGNED);

-- 명시적 형변환 
-- CAST(expr AS type) 
-- CONVERT(expr, type)

SELECT 38.8, CAST(38.8 AS CHAR);


-- now() : 현재시간
SELECT now();

SELECT CAST(now() AS signed);
SELECT CONVERT(now(), SIGNED);

SELECT YEAR(now()), MONTH(now()), DAY(now()), HOUR(now());

-- DATE_FORMAT()
SELECT DATE_FORMAT(now(), '%Y%m%d');
SELECT DATE_FORMAT(now(), '%Y-%m-%d %H:%m:%s');
SELECT DATE_FORMAT(now(), '%Y년 %m월 %d일 %H시 %m분 %s초');


-- 숫자 3자리 마다 콤마 찍기
SELECT 1234567, format(1234567, 0);

-- #4304

SELECT 
	name,
	date_format(hiredate, '%Y-%m-%d') "입사일",
	format(pay * 12, 0) "연봉",
	format((pay * 12) * 1.1, 0) "인상후"
FROM t_professor 
WHERE year(hiredate) < 2000;










