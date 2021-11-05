-- 1102

/*
SELECT (Projection + Selection)
Projection : 컬럼명을 직접 지정함, distinct 컬럼의 중복을 제거함
Selection : where절을 추가해서 원하는 행만 검색
            ORDER BY 정렬, ALIAS 지정 방법
*/

-- 문제 1.  emp 테이블에서 업무가 SALESMAN 사원과 사원의 이름이 FROD인 사원의 이름, 업무, 급여를 검색
SELECT ename, job, sal
FROM emp
WHERE job='SALESMAN' or ename='FORD'; 

-- 위 결과에서 sal값이 점점 높은 순으로 출력되도록 결과를 정렬
-- ORDER BY 절이 필요
-- 1) 절의 순서 : SELECT -> FROM -> WHERE -> ... -> ORDER BY
SELECT ename, job, sal
FROM emp
WHERE job='SALESMAN' or ename='FORD'
ORDER BY sal DESC; 

-- 문제 2.  emp 테이블에서 이름, 월급, 연봉을 출력, 이때 연봉순으로 내림차순 정렬
-- 1) 
SELECT ename, sal, sal*12 + comm
FROM emp
ORDER BY sal*12 + comm DESC; 
-- 2) Alias를 지정(as를 사용)
SELECT ename, sal, sal*12 + comm as "Annual Salary"
FROM emp
ORDER BY sal*12 + comm DESC;
-- 2-2) as 생략 가능.. 가능하면 뺀다
SELECT ename, sal, sal*12 + comm "Annual Salary"
FROM emp
ORDER BY sal*12 + comm DESC; 
-- 2-3) 원래는 한칸 띄우고 바로 별칭을 붙이면 된다
SELECT ename, sal, sal*12 + comm AnnualSalary
FROM emp
ORDER BY sal*12 + comm DESC; 	-- 별칭으로 정렬

-- 정리
-- 1) 별칭을 지정할 때 as는 굳이 붙이지 않고 생략 가능
-- 2) 별칭에 " "을 지정하는 경우는 별칭에 공백이 있을때만 붙인다

/*
null
sql에서 null값은 연산이 적용되지 않는 값이다.

null을 다른 값으로 치환해서 계산을 해야한다.
ifNull()를 사용

ifNull(comm, 0) : comm이 null값이 아니면 그대로 리턴 / null이면 0으로 리턴
*/

SELECT ename, sal, sal * 12 + ifnull(comm , 0) AnnualSalary
FROM emp
ORDER BY sal*12 + comm DESC; 

/*
SQL 명령어의 종류 

1. DML : 
	1) INSERT INTO table명 VALUES(0,0,0,0)
    2) DELETE FROM table명 WEHRE emono=7786
	   DELETE FROM table명;								-- table의 모든 데이터가 다 삭제 
	3) UPDATE table명 SET sal=2000 WHERE ename='SMITH';
	4) SELECT * FROM table명;							-- 모든 데이터를 다 가지고 옴
       SELECT * FROM table명 WHERE deptno=10; 			-- 조건에 맞는 데이터 행을 가지고 옴
2. DDL : 

3. DCL :

*/

