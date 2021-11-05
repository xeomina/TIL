-- 1105
/*
limit
::
출력 갯수를 제한하는 기능 
시작은 0부터...0,5...상위 5개만 출력
*/
-- 문제 1. emp 테이블에서 sal가 가장 많은 사원 3명 출력 (sal ORDER BY DESC)
SELECT * FROM emp ORDER BY sal DESC;
SELECT * FROM emp ORDER BY sal DESC limit 3;

/*
SQL에서 Null값은 제대로 다룰 수 있어야 한다
1) Null값은 아직 정해지지 않았거나 (미확정) 자격이 없을 때 사용되는 값
2) 0을 의미하는 값이 아니다
3) 값이 없는 것도 아니다. 나름 의미를 가지는 값이다. -1)에서 언급
4) 0과는 전혀 다른 값이기 때문에 비교,연산 적용이 안된다
	-> =, 1= 와 같은 연산자 사용 불가
    -> +, -, *, / 사용 불가. 대신에 ifnull()을 사용해서 값을 치환시키고 연산 적용 가능 
*/

-- 문제 2. emp 테이블에서 comm을 받지 않는 사원을 검색..이름, 업무, comm 출력
SELECT ename,job,comm FROM emp WHERE comm = null;
SELECT ename,job,comm FROM emp WHERE comm is null;
SELECT ename,job,comm FROM emp WHERE comm is not null;

SELECT sal, sal*12 + comm AnnualSalry FROM emp;
SELECT sal, sal*12 + ifnull(comm,0) AnnualSalry FROM emp;

/*
숫자함수 : abs(), round(), floor(), mod(), ...

문자함수 : concat(), substr(), trim()

날짜함수 : now(), sysdate(), curdate(), year(), month()
*/

-- 문제 3. 업무가 사장인 사람과 업무가 SALESMAN인 사람의 급여 차이를 출력 
-- abs(): 절대값 함수
SELECT * FROM emp;
SELECT sal FROM emp WHERE job = 'PRESIDENT'; -- 5000
SELECT sal FROM emp WHERE job = 'SALESMAN'; -- 1600, 1250, 1250, 1500

-- SELECT DISTINCT ABS((SELECT sal FROM emp WHERE job = 'PRESIDENT') - (SELECT sal FROM emp WHERE job = 'SALESMAN')) SalaryGap FROM emp; -- 오류

SELECT DISTINCT ABS((SELECT sal FROM emp WHERE ename = 'KING') - -- 5000
(SELECT sal FROM emp WHERE ename = 'ALLEN')) SalaryGap FROM emp; -- 1600

SELECT DISTINCT ((SELECT sal FROM emp WHERE ename = 'ALLEN') - -- 1600
(SELECT sal FROM emp WHERE ename = 'KING')) SalaryGap FROM emp; -- 5000 -> -3400
SELECT DISTINCT ABS((SELECT sal FROM emp WHERE ename = 'ALLEN') - -- 1600
(SELECT sal FROM emp WHERE ename = 'KING')) SalaryGap FROM emp; -- 5000 -> 3400


-- 문제 4. 사원 번호 중에서 홀수번호만 출력 
-- mod(): 나머지 함수
SELECT ename, empno, job FROM emp WHERE MOD(empno,2)=1; -- 2로 나눴을 때 나머지 1

-- round()
SELECT ROUND(45.923); -- 46
SELECT ROUND(45.923,0); -- 46
SELECT ROUND(45.923,2); -- 45.92 - 소수점 2번째 자리까지 출력

-- now(), sysdate(), curdate()
SELECT NOW() today; -- 2021-11-05 11:20:21
SELECT SYSDATE() today; -- 2021-11-05 11:20:22 - sysdate(): 시간까지
SELECT CURDATE() today; -- 2021-11-05 - curdate() : 날짜만

-- 문제 5. emp 테이블에서 사원들의 입사년도를 출력. 이때 사원의 이름과 함께 출력 
-- year(), month()
SELECT ename, YEAR(hiredate) 입사년도, MONTH(hiredate) 입사월 FROM emp;
-- substr() 
SELECT ename, SUBSTR(hiredate,1,4) 입사년도, SUBSTR(hiredate,6,2) 입사월 FROM emp; -- substr(hiredate,시작위치,글자길이)

/*
like와 와일드카드
::

ex) 훈련생들중 김씨로 시작하는 학생들의 명단을 검색... 
    제품중에서 삼성 2글자 포함되는 모든 제품을 검색... 
    
와일드카드 : 
	% : (0~many),  _ : (정확하게 1대1매핑) 
*/
SELECT ename FROM emp;
-- 문제 6. 사원 이름중에서 S로 시작하는 사원의 이름 검색 - like
SELECT ename FROM emp WHERE ename LIKE 'S%';
-- 문제 7. 사원 이름중에서 두번째 철자가 A인 사원의 이름 검색 - like_a
SELECT ename FROM emp WHERE ename LIKE '_A%';
-- 문제 8. 사원의 이름중에서 R철자가 포함된 모든 사원을 검색
SELECT ename FROM emp WHERE ename LIKE '%R%';

