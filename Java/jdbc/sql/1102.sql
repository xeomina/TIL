-- 1102

/*
select (Projection + Selection)
Projection : 컬럼명을 직접 지정함, distinct 컬럼의 중복을 제거함
Selection : where절을 추가해서 원하는 행만 검색, order by 정렬, alias 지정 방법
*/
-- 문제 1.  emp 테이블에서 업무가 SALESMAN 사원과 사원의 이름이 FROD인 사원의 이름, 업무, 급여를 검색
select ename, job, sal
from emp
where job = 'SALESMAN' or ename='FORD';

-- 위 결과에서 sal값이 점점 높은 순으로 출력되도록 결과를 정렬
-- order by 절이 필요
-- 1) 절의 순서 : select -> from -> where -> ... -> order by
select ename, job, sal
from emp
where job = 'SALESMAN' or ename='FORD'
order by sal asc;

-- 문제 2.  emp 테이블에서 업무가 SALESMAN 사원과 사원의 이름이 FROD인 사원의 이름, 업무, 급여를 검색
