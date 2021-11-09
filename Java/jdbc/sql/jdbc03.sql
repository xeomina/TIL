--  1108
/*
그룹함수 
count() - 테이블 행의 갯수를 리턴 
          count(column)
          count(*) or count(-1)
avg() - 평균값을 리턴
sum() - 총합을 리턴 
max() - 최대값 리턴 
min() - 최소값 리턴 
*/
SELECT * FROM emp;
-- 부서의 수를 출력 
--  10,20,30 ...3개의 부서
SELECT COUNT(deptno) FROM emp; 				--  14개로 중복되어 출력
SELECT COUNT(distinct(deptno)) FROM emp; 	-- 3개로 중복 제거되어 출력

-- emp 테이블의 전체 행의 수를 출력 
SELECT COUNT(empno) FROM emp; 	-- 14
SELECT COUNT(*) FROM emp; 		-- 14
SELECT COUNT(-1) FROM emp; 		-- 14

 -- 문제1. 
 -- emp 테이블에서 가장 최근에 입사한 사원의 입사일
SELECT MAX(hiredate) FROM emp;		-- 1987-05-23 00:00:00
 -- 회사에 입사한지 가장 오래된 사원의 입사일
SELECT MIN(hiredate) FROM emp;		-- 1980-12-17 00:00:00

 -- 문제2. 모든 사람의 평균급여를 소수점 2자리까지 출력
SELECT ROUND(AVG(sal),2) AvgSal FROM emp;	-- 2073.21


/*
그룹함수와 null값
:
null값은 그룹함수에서 제외시킨다. 
*/
-- 문제3.
SELECT COUNT(deptno) FROM emp; 	-- 14 Column에 대한 Row의 수 (== 전체 행의 수)
SELECT COUNT(empno) FROM emp; 	-- 14
SELECT COUNT(comm) FROM emp; 	-- 4 

-- 문제4. 모든 사원의 보너스(COMM)의 평균을 구하시오
SELECT AVG(comm) FROM emp; -- 550 : 잘못된 결과값, COMM이 Null인 부서의 사람들은 카운팅이 안 됨
SELECT ROUND(AVG(ifnull(comm,0))) AvgSal FROM emp; -- 157 : 바른 결과 값

/*
GROUP BY 절 
1.
그룹함수에서 적용되지 않는 컬럼이 
SELECT절에 명시되어서는 안된다. 

2.
그룹함수에서 적용되지 않는 컬럼이 
SELECT절에 명시되기 위해서는 GROUP BY절에 나열되어져야 한다.

3. 
SELECT deptno, AVG(sal) FROM emp;
그룹함수에서 적용되지 않는 컬럼이 있다는 것은
해당 컬럼으로 그룹을 세분화 시키겠다는 저의...
*/

-- 문제5. emp테이블에서 모든 사원의 급여 평균
SELECT deptno, AVG(sal) AvgSal FROM emp; -- 잘못된 결과값..oracle은 에러

SELECT deptno, ROUND(AVG(sal)) AvgSal FROM emp GROUP BY deptno; -- deptno별 평균

SELECT deptno, ROUND(AVG(sal)) AvgSal FROM emp GROUP BY deptno ORDER BY AvgSal; -- AvgSal 오름차순 정렬

-- 문제6. 부서별 평균급여가 2000달러 이상인 부서와 평균급여를 검색
SELECT deptno, ROUND(AVG(sal)) AvgSal FROM emp WHERE ROUND(AVG(sal))>2000  GROUP BY deptno; -- WHERE절 에러


/*
HAVING절 
1. where절에서는 그룹함수 사용할수 없다 
   where절은 일종의 조건을 부여해서 select해오는 절이기 때문에 
   grouping이 일어나기 전에 먼저 실행된다. 
   
2. 문제6번의 경우,
   "부서별 평균급여를 구했다."
   10 --- 2517
   20 --- 1790
   30 --- 2190
   
   "이중에서 평균급여가 2000이상인 부서와 그 부서의 평균급여를 구하라"
   포인트는 group by절의 결과를 다시 조건을 줘서 디스플레이 하려한다....
   
	이때 HAVING절을 사용한다.
    HAVING절은 GROUP BY절 뒤에 나온다 
*/
-- 문제6. 부서별 평균급여가 2000달러 이상인 부서와 평균급여를 검색 
SELECT deptno, ROUND(AVG(sal)) avgSal FROM emp WHERE ROUND(AVG(sal))>2000 GROUP BY deptno;   -- 에러

SELECT deptno, ROUND(AVG(sal)) avgSal FROM emp GROUP BY deptno HAVING avgSal>2000; 

/*
Sub Query
서브쿼리는 반드시 (  )안에 싸여져야 한다. 
()의 의미는 우선먼저 진행된다는 뜻이다 
서브쿼리로 진행된 결과값이 전체 메인쿼리에서 돌아간다. 
Sub Query       vs     Main Query
Inner Query     vs    Outer Query
*/

-- 문제 7. CLARK의 급여보다 더 많은 급여를 받는 사원의 이름과 급여를 검색  
-- 1)
SELECT  sal  FROM emp WHERE ename='CLARK'; -- 2450

-- 2) 1)결과의 값을 가지고 다시 쿼리문으로 질의를 진행한다. 
SELECT ename, sal FROM emp WHERE sal>2450; -- Jones Blake Scott King Ford

-- 위 결과처럼 먼저 질의를 통해서 값을 받은후에 그 값을 다시 전체 쿼리문에 넣어서 돌릴때 
-- 우리는 Sub Query를 사용해서 하나의 쿼리문으로 수행할 수 있다.
SELECT ename, sal FROM emp WHERE sal>(SELECT  sal  FROM emp WHERE ename='CLARK');

-- 문제 8. ename이 KING인 사원과 같은 부서에서 일하는 사원을 검색 
SELECT * FROM emp WHERE deptno=(SELECT deptno FROM emp WHERE ename='KING');

-- 문제 9. 사원중에서 급여를 2000이상 받는 사원과 동일한 부서에서 일하는 사원을 검색 
-- 1) 다중행 서브쿼리인데 = 라는 단일행 연산자와 비교를 해서 에러남
SELECT * FROM emp WHERE deptno=(SELECT DISTINCT(deptno) FROM emp WHERE sal>2000); 
-- 2) 다중행 서브쿼리 결과는 다중행 연산자 in으로 연결시켜야 한다 
SELECT * FROM emp WHERE deptno IN (SELECT DISTINCT(deptno) FROM emp WHERE sal>2000); 

-- 문제 10. emp 테이블에서 사원번호가 7369이거나 7566이거나 7782인 사원을 검색
-- 1) 성능이 가장 안좋은 경우 
SELECT ename, empno FROM emp WHERE empno=7369;	-- SMITH
SELECT ename, empno FROM emp WHERE empno=7566;	-- JONES
SELECT ename, empno FROM emp WHERE empno=7782;	-- CLARK

-- 2) OR로 연결
SELECT ename, empno FROM emp WHERE empno=7369 OR empno=7566 OR empno=7782;	-- SMITH, JONES, CLARK

-- 3) IN 연산자 
SELECT ename, empno FROM emp WHERE empno IN(7369,7566,7782);	-- SMITH, JONES, CLARK

-- 문제 11. 사원번호가 7369가 아니고 7566도 아니도 7782도 아닌 사원을 검색 
-- 1) AND로 연결
SELECT ename, empno FROM emp WHERE empno!=7369 AND empno!=7566 AND  empno!=7782;
-- 2) NOT IN 연산자
SELECT ename, empno FROM emp WHERE empno NOT IN(7369,7566,7782);


/*
JOIN
:
2개이상(하나이상)의 테이블에서 질의를 던지는 경우 
각각의 사원이 어느 부서에서 일하는지를 검색... 사원의 이름과 업무, 부서위치를 검색  
*/
SELECT * FROM emp; -- 14
SELECT * FROM dept; -- 14

SELECT * FROM emp, dept;  -- 56
SELECT ename, dname, loc FROM emp, dept;  -- 56

/*
이렇게 나온 결과를  Cartesian Product라 부른다 

Cartesian Product는 두 테이블의 단순한 수평적인 결과를 의미한다.
emp --> 14
dept --> 4
Cartesian Product 14 * 4 = 56

Cartesian Product는 언제 발생할까? 
1) 조인조건을 안줬거나 
2) 조인조건을 잘못줬거나 
*/


-- 문제 12. emp, dept테이블에서 사원의 이름과 부서명, 부서위치를 검색 
-- 1) 성능에 가장 안좋다. 모든 테이블을 일일히 다 검색해서 컬럼을 찾아낸다. 
SELECT ename, dname, loc FROM emp,dept WHERE emp.deptno = dept.deptno;

-- 2) 각각의 컬럼을 어느 테이블에서 검색하는지를 지정하는것이 좋다 - alias 이용
SELECT e.ename, d.dname, d.loc FROM emp e, dept d WHERE e.deptno = d.deptno;

-- WHERE절에는 조인조건과 함께 비조인 조건이 당연히 같이 사용된다 
-- 문제 13.  사원이름, 급여, 부서번호, 부서이름, 부서위치를 검색. 단, 급여가 2000달러 이상이고 30번 부서에 한해서
SELECT e.sal, e.deptno, d.dname, d.loc FROM emp e, dept d  WHERE e.deptno = d.deptno AND e.sal>2000 AND e.deptno = 30;

