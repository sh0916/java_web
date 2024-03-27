


-- 줄의 끝까지 주석
/* 범위
    주석*/

/* emp 라는 이름의 테이블 */
/* select = 선택한 테이블을 보여준다 * => 전체열 선택 */
/* 실무에서는 *로 전체선택하기보다는 원하는 열, 열, 열식으로 선택하는것이 좋다 */
select * from emp;
select * from dept;
select * from salgrade;

/* desc = 테이블의 구조를 보여준다 => 설명하다 */
desc emp;
/* VARCHAR2() 안에 오는숫자는 올수있는 글자길이다 */
/* NUMBER() 안에 오는숫자가 4 라면 9999 까지라는 뜻이다 */
/* NUMBER() 안에 들어오는 숫자가 7,2 라면 앞자리 7자리까지 소수점은 2자리 까지이다 */

/*  emp 테이블에있는 원하는 열들만 선택해서 보여준다 */
select empno, ename, deptno
from emp;

select deptno from emp;
/* DISTINCT => 중복된 값들만 뽑아준다(중복제거) */
select DISTINCT deptno from emp;
/* 중복된 job 의 값만 뽑아준다 */
select DISTINCT job from emp;

/* deptno 와 job 두개의 열의 값이 중복된것들을 제외해준다 */
/* 결과에서 중복되는 내용을 제외하고 조회(두개의 값이 같으면 제외) */
/* DISTINCT 를 사용하지않으면 기본값으로 조회된다 (기본값은 all) */
/* SELECT 
    ALL deptno, job
FROM
    emp;*/
SELECT 
    DISTINCT deptno, job
FROM
    emp;
    
    
    
/* 별칭 */
/* sal 열을 조회할건데 sal 의 값에 12를 곱하고 comm 을 더한값을 출력 */
/* comm 값이 없는 행들은 null 값이 나옴 */
SELECT 
    sal, sal*12+comm
FROM
    emp;
    
/* AS newsal => as 전에 나온 열의 제목을 newsal 이란 이름으로 바꿔준다 */
/* 열의 제목을 뛰어쓰기 해주고싶으면 "new sal" 로 묶으면됨 */
/* FROM 전에는 "" FROM 후에는 '' */
/* AS 는 생략가능 */
SELECT 
    sal, sal*12+comm AS "new sal"
FROM
    emp;
    
    
    
/* ORDER BY => ASC 가 기본값(오름차순) */
/* 오름차순 */
/* ORDER BY sal "ASC" 가 생략된것 => ASC 는 오름차순이다 */
SELECT *
FROM emp
ORDER BY sal;

/* 내림차순 */
/* DESC 를 붙히면 내림차순된다 */
SELECT *
FROM emp
ORDER BY sal DESC;

/* ORDER BY 를 사용을 안하면 정렬이 마음대로된다(항상똑같은걸 보장못한다) */
/* 매일 달라질수있음 */

/* ASC => 오름차순 DESC => 내림차순 */
/* 내림차순은 높은수부터 밑으로 내려감 오름차순은 낮은값부터 밑으로 점점올라감 */
/* deptno 의 값으로 오름차순을 하고 이 값이 우열을 가리기 힘들면 */
/* 두번째 조건으로 sal 을 둬서 이조건대로 내림차순이된다 */
/* 만약 첫번째 조건으로 우열을 가릴수있으면 두번째 조건은 가지않는다 */
SELECT *
FROM emp
ORDER BY deptno ASC, sal DESC;

/* 이름이 A 부터 밑으로 Z 로 오름차순된다 */
SELECT *
FROM emp
ORDER BY ename ASC;

/* QUIZ */
SELECT DISTINCT job
FROM EMP;

SELECT DISTINCT job
FROM emp
ORDER BY job ASC;

SELECT 
    empno AS EMPLOYEE_NO,
    ename AS EMPLOYEE_NAME,
    mgr AS MANAGER,
    sal AS SALARY,
    comm AS COMMISSION,
    deptno AS DEPARTMENT_NO
FROM emp
ORDER BY department_no DESC, employee_name ASC;


/* WHERE */
/* WHERE 는 FROM 다음에 쓴다 */
/* 뒤에 쓴값과 true 값을 조회한다(조건문) */
SELECT *
FROM emp
WHERE deptno = 30;

/* sal 값이 2000 이상인 것들만 조회 */
SELECT * 
FROM EMP
WHERE sal >= 2000;

/* sal 값이 2000 이상인 것들만 조회하고 오름차순으로 정렬 */
SELECT 
    *
FROM 
    emp
WHERE 
    sal >= 2000
ORDER BY 
    sal ASC;

/* FROM 뒤에는 '' 로 조회한다 */
SELECT 
    *
FROM
    emp
WHERE
    job = 'CLERK';

/* job 안에 'CLERK' 를 찾고 그리고 deptno 가 30인것을 조회 */
SELECT 
    *
FROM
    emp
WHERE
    job = 'CLERK' AND deptno = 30;
    
/* 'CLERK' 거나 또는 deptno 의 값이 30인것을 조회 */
SELECT 
    *
FROM
    emp
WHERE
    job = 'CLERK' OR deptno = 30;
    
/* AND 가 먼저 연산이 된다 */
SELECT 
    *
FROM
    emp
WHERE
    job = 'CLERK' AND (deptno = 30 OR deptno = 20);
    
/* job 에서 'CLERK' 를 찾고 그것을 ename 을 오름차순으로 정리 */
SELECT 
    *
FROM
    emp
WHERE
    job = 'CLERK'
ORDER BY ename ASC;

/* sal 의 값이 3000 이 아닌것들을 조회 */
SELECT 
    *
FROM
    emp
WHERE 
/*  sal != 3000;
    sal ^= 3000; */
    sal <> 3000;
    
/* sal 의 값이 3000 이 아닌것의 아닌것을 조회(3000만 조회) */
SELECT 
    *
FROM
    emp
WHERE NOT
    sal <> 3000;

/* job 안에 저값들이 있는것들만 조회 */
SELECT 
    *
FROM
    emp
WHERE 
    job IN ('MANAGER', 'SALESMAN', 'CLERK');
  
/* job 안에 저값들이 없는것들만 조회 */  
SELECT 
    *
FROM
    emp
WHERE 
    job NOT IN ('MANAGER', 'SALESMAN', 'CLERK');
    
SELECT 
    *
FROM
    emp
WHERE
    /* sal >= 2000 AND sal <= 3000; */
    /* 2000을 포함해서 3000 까지 일경우 조회 */
    /* BETWEEN 앞에 NOT 을 붙힐경우 아래의 조건이 아닌값들을 조회한다 */
    sal BETWEEN 2000 AND 3000;

/* ename 의 'S' 가 붙은 모든것을 조회 */
/* LIKE => 이것처럼 % => 앞에오면 S 로 끝나는것 뒤에오면 S 로 시작하는것 */
/* _ => 한글자만 */
/* LIKE 는 인덱스를 안타기때문에 느려진다 */
SELECT 
    *
FROM
    emp
WHERE
    ename LIKE 'S%';
/*  ename LIKE '%S'; */
/*  ename LIKE '%S%'; */
/*  ename LIKE '%AR%'; */

/* 두번째 글자가 A 인것을 찾아줌 */
/*  ename LIKE '_A%'; */

/* % 는 예약어기 때문에 % 가 들어간 값을 찾으려면 \ 를 붙혀줘야한다 */
/* ESCAPE 로 '\' 를 탈출한다 \ 가 ESCAPE 라는것을 알려준다 */
/*  ename LIKE '\%' ESCAPE '\' */

/* comm 의 값중에 값이 null 인것들을 찾아준다 IS NULL */
SELECT
    *
FROM
    emp
WHERE
    /* comm = null; */
    comm IS NULL;
    
/* NULL 이 아닌것들을 찾아준다 */
SELECT
    *
FROM
    emp
WHERE
    comm IS NOT NULL;


/* 집합연산자 */
/* UNION => 두개를 같이 조회해준다 */
/* 두개의 찾는 데이터 타입이 같아야 한다 */
SELECT
    empno, ename, sal, deptno
FROM
    emp
WHERE
    deptno = 10
UNION    
SELECT
    empno, ename, sal, deptno
FROM
    emp
WHERE
    deptno = 20;
    
/* UNION 을 사용하면 이값들이 중복되는거를 제외하고 축약시켜준다 */    
SELECT
    sal, deptno
FROM
    emp
WHERE
    deptno = 10
UNION    
SELECT
    sal, deptno
FROM
    emp
WHERE
    deptno = 20;

SELECT 
    *
FROM
    emp
WHERE
    sal = 3000 AND deptno = 20;

/* 중복된 값을 제거하지 않고 보기위해서는 UNION 옆에 ALL 을 붙혀주면된다 */
SELECT
    sal, deptno
FROM
    emp
WHERE
    deptno = 10
UNION ALL    
SELECT
    sal, deptno
FROM
    emp
WHERE
    deptno = 20;

/* comm 이 1000 보다작고 또는 NULL 인것 */
SELECT
    *
FROM 
    emp
WHERE
    comm < 1000 OR comm IS NULL
ORDER BY
    comm DESC;
  
/* UNION 을 이용해 두개의 결과를 합쳤기 때문에 */
/* ODER BY 를 맨밑에 붙혀준다 => 두개의 합친값을 정렬 */
SELECT
    empno, ename, sal, deptno
FROM
    emp
WHERE
    deptno = 10
UNION ALL  
SELECT
    empno, ename, sal, deptno
FROM
    emp
WHERE
    deptno = 20
ORDER BY
    deptno ASC, ename ASC;

/* QUIZ */

/* Q1 */
SELECT
    *
FROM
    emp
WHERE
    ename LIKE '%S';
    
/* Q2 */
SELECT
    empno, ename, job, sal, deptno
FROM 
    emp
WHERE
    deptno = 30 AND 
    job IN ('SALESMAN');
    
/* Q3 */
SELECT
    empno, ename, job, sal, deptno
FROM
    emp
WHERE
    deptno IN (20, 30) AND --(deptno = 20 OR deptno = 30)
    (sal > 2000 AND sal <= 3000);

/* Q3_2 */    
SELECT
    empno, ename, job, sal, deptno
FROM
    emp
WHERE
    deptno IN (20) AND 
    (sal > 2000 AND sal <= 3000)
UNION
SELECT
    empno, ename, job, sal, deptno
FROM
    emp
WHERE
    deptno IN (30) AND 
    sal BETWEEN 2000 AND 3000;

/* Q4 */
SELECT
    *
FROM
    emp
WHERE
    NOT (sal >= 2000 AND sal <= 3000);
--      (sal < 2000 OR sal > 3000)
    
/* Q5 */
/* 
    이름에 E 포함
    부서 30
    급여 1000 이상 2000 이하가 아닌
*/
SELECT
    ename, empno, sal, deptno
FROM
    emp
WHERE
    ename LIKE ('%E%') AND 
    deptno IN (30) AND 
    NOT (sal > 1000 AND sal <= 2000);

/* Q6 */
/*
    comm = null
    mgr  = not null
    job  = MANAGER, CLERK
    ename = _L% 가 아닌
*/
SELECT
    *
FROM
    emp
WHERE
    comm IS NULL AND 
    mgr IS NOT NULL AND 
    job IN ('MANAGER', 'CLERK') AND 
    ename NOT LIKE ('_L%');

--  SELECT 에 원하는 글자를 emp 열의 개수만큼 쓸수있다
SELECT 
    ename, 'hello world' 
FROM 
    emp;

SELECT
    1, 2
FROM
    dual;


-- 함수

-- UPPER => 대문자로 바꿔줌
-- LOWER => 소문자로 바꿔줌
-- INITCAP => 첫글자는 대문자로 나머지는 소문자로 바꿔줌
SELECT 
    ename, UPPER(ename), LOWER(ename), INITCAP(ename), UPPER('SungHyun')
FROM
    emp;
    
-- 찾는 행의 제목을 소문자로 변경해주고 들어온값도 소문자로 변경해준뒤
-- 행의 값안에 찾는 값을 찾아준다
SELECT
    *
FROM
    emp
WHERE
    LOWER(ename) LIKE LOWER('%Am%');

-- LENGTH => 글자수를 세어준다
-- LENGTHB => 바이트 크기를 알려준다
SELECT
    ename, LENGTH(ename), LENGTHB('한글'), LENGTHB(ename), LENGTHB('한')
FROM
    emp
WHERE
    -- ename 의 값이 5이상인 것들을 찾아준다
    LENGTH(ename) >= 5;
    
-- SUBSTR
-- ORACLE 은 기본적으로 1부터 시작 하지만 0도 상관없음
SELECT
    job, SUBSTR(job, 1, 2), 
    SUBSTR(job, 3, 2), 
    SUBSTR(job, 5), 
    SUBSTR(job, 0, 5), 
    SUBSTR(job, -4, 3)
--  SUBSTR(job, -4, -2) => NULL
FROM
    emp;
    
-- REPLACE
-- (문자데이터 또는 열이름(필수), 찾는문자(필수), 대체할문자)
SELECT
    job, REPLACE(job, 'E', '*')
FROM
    emp;
    
SELECT
    job, REPLACE(REPLACE(job, 'E'), 'A')
FROM
    emp;

-- LPAD => 왼쪽부터 설정한 갯수를 글자에서 제외한 수를 채워줌
-- LPAD => 오른쪽부터 설정한 갯수를 글자에서 제외한 수를 채워줌
SELECT
    'Oracle',
    LPAD('Oracle', 10, '*'),
    RPAD('Oracle', 10, '*'),
    LPAD('Oracle', 4, '*'),
    RPAD('Oracle', 4, '*')
FROM
    dual;
    
SELECT
    '240111-3456789' AS 원본,
    SUBSTR('240111-3456789', 1, 8) AS 표시,
    RPAD(SUBSTR('240111-3456789', 1, 8), LENGTH('240111-3456789'), '*') AS 최종
FROM
    dual;
    
-- 문제1
/*
    사원 이름을 앞에 두글자만 보이게 하고 나머지는 * 로 표시
*/
SELECT
    ename, 
    RPAD(SUBSTR(ename, 1, 2), LENGTH(ename), '*') AS 변경
FROM
    emp;
    
-- 문제2
/*
    사원 이름 앞글자 하나만 * 로 표시
*/
SELECT
    ename, 
    LPAD(SUBSTR(ename, 2), LENGTH(ename), '*') AS 변경
FROM
    emp;
-- FROM emp emp2 => emp 테이블명을 emp2 로 변경해준다 이땐 AS 를 사용하면 안된다
    

-- CONCAT
-- CONCAT => 두개의 열을 붙여서 보여준다(오라클에만 있다)
-- 같은 의미로 empno || ename 중간에 || 를 붙힘으로써 두열이 합쳐서 보여진다
SELECT
    CONCAT(empno, ename),
    empno || ename
FROM
    emp;
  
-- '1' + 2 => 문자를 숫자로 변경해서 값을 보여준다
-- '1'  || 2 => '' 안에있는 숫자를 문자로 인식해서 두개를 합쳐준다
SELECT
    '1' + 2,
    '1' || 2
FROM
    dual;
    
-- 문제3
-- 사원 이름의 두번째 글씨만 * 로 마스킹 처리
SELECT
    ename,
    SUBSTR(ename, 1, 1) || LPAD(SUBSTR(ename, 3), LENGTH(ename) -1, '*') AS FIRST,
    RPAD(SUBSTR(ename, 1, 1), 2, '*') || SUBSTR(ename, 3) AS SECOND
FROM
    emp;
    
-- 문제4
-- 사원 이름의 두번째 글씨만 보이고 나머지 * 로 마스킹
SELECT
    ename,
    RPAD(LPAD(SUBSTR(ename, 2, 1),  2, '*'), LENGTH(ename), '*')
FROM
    emp;
    
 
-- 숫자함수
-- ROUND => 0.5 이상 반올림 이하 반내림 을 해준다
-- ROUND(1234, -2) - 를 넣어주면 정수를 반올림해준다
-- ROUND(3.14, 1) 은 실수를 반올림해준다
SELECT
    ROUND(4.4), ROUND(4.5), ROUND(1234, -2), ROUND(3.14, 1)
FROM
    dual;
    
-- TRUNC => 소수점을 버려준다
SELECT
    TRUNC(3.14), TRUNC(-3.14)
FROM
    dual;
    
-- CEIL => 소수점이 있으면 올려서 정수로 바꿔준다 - 는 실수쪽으로 올라가는것이다
SELECT
    CEIL(3.14), CEIL(-3.14)
FROM
    dual;
  
-- FLOOR => 소수점이 있으면 내려서 정수로 바꿔준다
SELECT
    FLOOR(3.14), FLOOR(-3.14)
FROM
    dual;  
    
-- MOD => 안에 넣은 두값을 나누고 나머지 값을 준다
SELECT
    MOD(10, 4)
FROM
    dual;
    
-- 날짜 데이터 함수
-- SYSDATE => 컴퓨터기준 시간을 조회해줌
SELECT
    SYSDATE
FROM
    dual;

-- TO_CHAR => 날짜, 숫자 데이터를 문자데이터로 변환해줌
SELECT
    TO_CHAR(SYSDATE, 'yyyy"년"mm-dd DAY PM hh24:mi:ss')
FROM
    dual;
    
SELECT
    ename,
    TO_CHAR(hiredate, 'yyyy"년"mm-dd PM hh24:mi:ss')
FROM
    emp
ORDER BY hiredate;
    
-- TO_CHAR(SYSDATE + 1 날짜를 더할수있다(+1 하면 내일날짜)
SELECT
    TO_CHAR(SYSDATE + 1, 'yyyy"년"mm-dd PM hh24:mi:ss')
FROM
    dual;
  
-- ADD_MONTHS(SYSDATE, 1) => 현재날짜의 몇달뒤를 자동으로 계산해준다  
SELECT
    TO_CHAR(ADD_MONTHS(SYSDATE, 1), 'yyyy"년"mm-dd PM hh24:mi:ss')
FROM
    dual;   
    
SELECT
    ename, 
    hiredate,
    ADD_MONTHS(hiredate, 120) AS "10주년"
FROM
    emp;
    
-- ADD_MONTHS(조회할 데이터열, (38*12) => 몇달인지)
SELECT
    ename,
    hiredate,
    ADD_MONTHS(hiredate, (38*12)),
    SYSDATE
FROM
    emp
WHERE
    ADD_MONTHS(hiredate, (38*12)) < SYSDATE;
    
-- TO_DATE 함수 => 문자 데이터를 날짜 데이터로 변환해줌
SELECT
    TO_DATE('2018-07-14', 'yy-mm-dd'),
    TO_CHAR(
        TO_DATE('2018-07-14', 'yy-mm-dd'), 'yyyy"년"mm-dd PM hh24:mi:ss')
FROM
    dual;
    
SELECT
    ename, hiredate
FROM
    emp
WHERE
    hiredate > TO_DATE('1981/06/01', 'YYYY/MM/DD');
    
SELECT
    TO_DATE('2024/05/03', 'YYYY/MM/DD') - SYSDATE 
FROM
    dual;
    
-- NVL => NULL 인지 확인(오라클에만 있다)
-- NVL(NULL 인지 확인할 열,NULL 일경우 반환할데이터)
SELECT
    ename, sal, comm, NVL(comm, 0), sal + NVL(comm, 0)
FROM
    emp;
    
SELECT
    *
FROM
    emp
WHERE
    -- comm 의 값중에 NULL 값인걸 0으로 바꾸고 값이 0과 같은 데이터를 출력
    NVL(comm, 0) = 0;
    
-- NVL2 => NVL2(NULL 인지 검사할 데이터열, NULL 이 아닐경우 반환할 데이터 또는 계산식, NULL 일 경우 반환할 데이터 또는 계산식)
SELECT
    ename, 
    sal, 
    comm, 
    NVL2(comm, 'O', 'X')
FROM
    emp;
    
-- DECODE => if else 문과 비슷하다(switch 문)
/*
DECODE(검사대상할 열(데이터),
        조건1, 조건1과 일치할경우 반환할 결과,
        조건2, 조건2과 일치할경우 반환할 결과,
        조건3, 조건3과 일치할경우 반환할 결과,
        위의 조건이 일치하지 않을때 반환할 결과) 아닐경우의 조건을 달지않으면 NULL 값으로 바뀐다
*/
SELECT
    ename, 
    job, 
    sal,
    DECODE(job,
        'MANAGER', sal * 1.1,
        'SALESMAN', sal * 1.05,
        'ANALYST', sal,
        sal * 1.03) AS sal2
FROM
    emp;
-- CASE 조건대상이 될 열또는 데이터를 굳이 안넣어도된다 안넣을 경우에는 각각의 조건을 붙혀줘야 한다
-- WHEN(조건) THEN(실행블럭)
-- CASE 문안에 조건이 일치할경우 CASE 를 또 넣어줘도 된다 2중 3중 가능
/*
CASE 조건대상 열또는 데이터(필수는아님)
        WHEN 조건1 THEN 조건1과 맞으면 실행
        WHEN 조건2 THEN 조건2과 맞으면 실행
        WHEN 조건3 THEN 조건3과 맞으면 실행
        ELSE 위 조건들이 모두 아닐경우 실행블럭 (필수아님)
    END AS upsal    끝에 END 를 붙혀줘야함
*/
SELECT
    ename,
    job,
    sal,
    CASE job
        WHEN 'MANAGER' THEN sal * 1.1
        WHEN 'SALESMAN' THEN sal * 1.05
        WHEN 'ANALYST' THEN sal
        ELSE sal * 1.03
    END AS sal2
FROM
    emp;

SELECT
    ename,
    job,
    sal,
    comm,
    CASE
        WHEN comm IS NULL THEN '해당사항 없음'
        WHEN comm = 0 THEN '수당없음'
        WHEN comm > 0 THEN CASE
                                WHEN comm > 1000 THEN '많이 받음'
                                ELSE '분발하자'
                            END
    END
FROM
    emp;
    
-- QUIZ
-- Q1
SELECT
    empno,
    RPAD(SUBSTR(empno, 1, 2), LENGTH(ename) -1,'*') AS masking_empno,
    ename,
    RPAD(SUBSTR(ename, 1, 1), LENGTH(ename), '*') AS masking_ename,
    CASE LENGTH(ename)
        WHEN 5 THEN RPAD(SUBSTR(ename, 1, 1), LENGTH(ename), '*')
    END AS masking_ename2
FROM
    emp
WHERE
    LENGTH(ename) >= 5 AND LENGTH(ename) < 6;

-- Q2
SELECT
    empno,
    ename,
    sal,
    -- FLOOR 와 CEIL 은 정수만 반환됨
    -- TRUNC 와 ROUND 는 소수점 몇째 자리까지 표현 가능함
    TRUNC(sal / 21.5, 2) AS day_pay,
    ROUND((sal / 21.5) / 8, 1) AS time_pay
FROM
    emp;
    
-- Q3
SELECT
    empno,
    ename,
    TO_CHAR(hiredate, 'YYYY-MM-DD') AS hiredate,
    -- TO_CHAR 은 문자로 변환, 원하는 문자로 변환
    TO_CHAR(
        -- ADD_MONTHS 는 개월수 계산
        ADD_MONTHS(hiredate, 3),'YYYY-MM-DD') AS r_job,
    TO_CHAR(
        -- NEXT_DAY 는 요일계산
        NEXT_DAY(
            ADD_MONTHS(hiredate, 3), '월요일'), 'YYYY-MM-DD') AS r_job2,
    DECODE(comm,
        NULL, 'N/A',
        comm) AS comm
FROM
    emp;
 
 -- Q3_2
 SELECT
    empno,
    ename,
    TO_CHAR(
        TO_DATE(hiredate), 
        'YYYY-MM-DD') AS hiredate,   
    TO_CHAR(       
        ADD_MONTHS(
            TO_DATE(hiredate), 3),
        'YYYY-MM-DD') AS r_job,
    NVL(TO_CHAR(comm), 'N/A') AS comm
FROM
    emp;
-- NVL(TO_CHAR(comm), 'N/A') 이경우 CHAR 로 NULL 값을 문자로 바꿔도 NULL 로 처리된다
-- Q4
SELECT
    empno,
    ename,
    mgr,
    CASE
        WHEN mgr IS NULL 
        THEN '0000'
        WHEN SUBSTR(mgr, 1, 2) = 75 
        THEN '5555'
        WHEN SUBSTR(mgr, 1, 2) = 76 
        THEN '6666'
        WHEN SUBSTR(mgr, 1, 2) = 77 
        THEN '7777'
        WHEN SUBSTR(mgr, 1, 2) = 78 
        THEN '8888'
        ELSE TO_CHAR(mgr)
    END AS chg_mgr,
    CASE
        WHEN mgr IS NULL THEN '0000'
        ELSE 
            -- CASE 옆에 대상을 적으면
            -- SWITCH 문처럼 사용 가능
            CASE SUBSTR(mgr, 1, 2)
                WHEN '75' THEN '5555'
                WHEN '76' THEN '6666'
                WHEN '77' THEN '7777'
                WHEN '78' THEN '8888'
                ELSE TO_CHAR(mgr)
            END
    END AS chg_mgr2,
    CASE
        WHEN mgr IS NULL THEN '0000'
        WHEN mgr LIKE '75%' THEN '5555'
        WHEN mgr LIKE '76%' THEN '6666'
        WHEN mgr LIKE '77%' THEN '7777'
        WHEN mgr LIKE '78%' THEN '8888'
        ELSE TO_CHAR(mgr)
    END AS chg_mgr3,
    CASE
        WHEN mgr IS NULL THEN '0000'
     -- WHEN SUBSTR(mgr, 2, 1) = '5' OR SUBSTR(mgr, 2, 1) = '6'
        -- mgr 의 2번째 자리 안에 5,6,7,8 중에 하나가 있으면
        WHEN SUBSTR(mgr, 2, 1) IN ('5', '6', '7', '8')
        -- 그 숫자를 mgr의 길이만큼 출력해준다
        THEN LPAD(
                SUBSTR(mgr, 2, 1), 4, SUBSTR(mgr, 2, 1))
        ELSE TO_CHAR(mgr)
    END AS chg_mgr3
FROM
    emp;
        
        
-- 다중행 함수
-- SUM 은 안에있는 열을 합해서 한행으로 보여준다
-- SUM 의 안에 들어가는 데이터값은 숫자만 가능하다
SELECT 
    SUM(sal) 
FROM 
    emp;
-- 결과가 한줄로 나오는 것과 여러줄로 나오는 것은 같이 사용할수 없다
-- SELECT SUM(sal), ename FROM emp;

-- COUNT
-- COUNT => 데이터의 개수를 출력해준다
SELECT
    COUNT(*)
FROM
    EMP;
-- COUNT 는 NULL 은 제외되고 계산해준다    
SELECT
    COUNT(*)
FROM
    emp
WHERE
    comm IS NOT NULL;

-- MAX MIN 함수
-- MAX => 선택한 데이터 값중에 제일 높은값을 출력
-- MIN => 선택한 데이터 값중에 제일 낮은값을 출력
-- MAX, MIN 은 날씨데이터도 조회가 가능하다
SELECT
    MAX(sal),
    MIN(sal),
    MAX(hiredate),
    MIN(hiredate),
    COUNT(*)
FROM
    emp;
 
-- WHERE 에서 다중행 함수를 사용할수 없음   
/*
SELECT
    *
FROM
    emp
WHERE
    hiredate = MAX(hiredate);
*/

-- AVG 함수
-- AVG => 안에있는 데이터값의 평균값을 구해준다
SELECT
    AVG(sal)
FROM
    emp;

SELECT
    AVG(sal),
    SUM(sal)
FROM
    emp
WHERE
    deptno = 10
UNION ALL
SELECT
    AVG(sal),
    SUM(sal)
FROM
    emp
WHERE
    deptno = 20
UNION ALL
SELECT
    AVG(sal),
    SUM(sal)
FROM
    emp
WHERE
    deptno = 30;

-- GROUP BY
-- GROUP BY => 그룹화 하려는 열을 중복제거후 한줄씩 그룹화 시켜줌
/*
순서
SELECT
FROM
WHERE
GROUP BY
ORDER BY
*/
-- DISTINCT 처럼 분류 해줌
-- SELECT 에는 GROUP BY 한 것이나 다중행 함수(집계 함수)만 사용할수있다
SELECT
    deptno,
    AVG(sal),
    COUNT(*)
FROM
    emp
GROUP BY
    deptno;

SELECT
    deptno, job, COUNT(*)
FROM
    emp
GROUP BY
    deptno, job
ORDER BY
    deptno;

-- HAVING
-- HAVING => GROUP BY 에 조건을 달고싶을때 사용한다
SELECT
    deptno, job, COUNT(*)
FROM
    emp
WHERE
    deptno IN (10, 20)
GROUP BY
    deptno, job
ORDER BY
    deptno;
    
SELECT
    deptno, job, AVG(sal)
FROM
    emp
GROUP BY deptno, job
HAVING AVG(sal) >= 2000
ORDER BY deptno, job;

-- GROUP BY 여러개가 겹치는 데이터를 한줄로 합쳐서 보여준다
-- 부서별 직책이 2명 이상으로 구성된 결과 표시
SELECT
    deptno, job, COUNT(*)
FROM
    emp
GROUP BY
    deptno, job
HAVING COUNT(*) >= 2
ORDER BY
    deptno, job;

-- HAVING 은 GROUP BY 절에 사용된 경우 필터링 조건을 더주기 위해서 사용한다
-- WERER 은 다중행함수가 못들어가지만 HAVING 은 다중행함수가 들어갈수있다
-- WERER 에서 표현할수있는 것들은 가급적 WHERE 에서 처리하는게 싸게 먹힌다
-- 보통은 한줄로 표시되는 함수(다중행/집계 함수) 들을 조건으로 줄때 사용한다

-- QUIZ
-- Q1
SELECT
    deptno,
    FLOOR(AVG(sal)) AS avg_sal,
    MAX(sal) AS max_sal,
    MIN(sal) AS min_sal,
    COUNT(*) AS cnt
FROM
    emp
GROUP BY
    deptno;

-- Q2
SELECT
    job,
    COUNT(*)
FROM
    emp
GROUP BY
    job
HAVING
    COUNT(*) >= 3;

-- Q3
SELECT
    TO_CHAR(hiredate, 'YYYY') AS hire_year,
    deptno,
    COUNT(*) AS cnt
FROM
    emp
GROUP BY
    TO_CHAR(hiredate, 'YYYY'),
    deptno;

-- Q4
SELECT
    CASE
        WHEN comm IS NULL THEN 'X'
        ELSE 'O'
    END,
    COUNT(*)
FROM
    emp
GROUP BY
    comm;

-- 총정리 및 우선순위
/* 5 */ SELECT deptno
/* 1 */ FROM emp
/* 2 */ WHERE job = 'CLERK'
/* 3 */ GROUP BY deptno
/* 4 */ HAVING COUNT(*) > 1
/* 6 */ ORDER BY deptno;

-- JOIN
SELECT
    *
FROM
    emp, dept
ORDER BY
    empno;

-- WHERE emp.deptno = dept.deptno => 서로 같은 데이터값인 데이터만 뽑아주는 조건
SELECT
    *
FROM
    emp, dept
WHERE emp.deptno = dept.deptno
ORDER BY
    empno;

-- 테이블 별칭 설정
-- FROM 테이블 이름 옆에 별칭을 적으면된다
-- ORDER BY 에도 옆에 별칭.정리할 열 을하면 보는사람이 이해하기쉽다(안해도됨)
SELECT
    *
FROM
    emp e, dept d
WHERE e.deptno = d.deptno
ORDER BY
    e.empno;

-- deptno 는 emp 테이블과 dept 테이블에도 있기때문에 중첩되는 데이터를
-- SELECT 문에서 찾을때는 어떤 테이블인지 알려줘야한다 => e.deptno
SELECT
    e.deptno
FROM
    emp e, dept d
WHERE e.deptno = d.deptno
ORDER BY
    e.empno;

-- 두개의 테이블이 조인된 상태에서 * 를 사용하여 정보를 뽑고싶을때 
-- 어느테이블의 * 정보인지 명시를 해줘야한다 
SELECT
    ename, '사원정보' , e.*, d.*
FROM
    emp e, dept d
WHERE e.deptno = d.deptno
ORDER BY
    e.empno;

SELECT
    e.ename,
    e.sal,
    s.grade
FROM
    emp e, salgrade s
WHERE
    e.sal >= s.losal AND e.sal <= s.hisal;

-- QUIZ
/*
    empno, ename, dname, loc
*/
SELECT
    empno,
    ename,
    dname,
    loc
FROM
    emp e, dept d
WHERE
    e.deptno = d.deptno;

-- king 은 상사가 없기때문에 뽑은 데이터에서 빠진다
SELECT
    e1.empno, e1.ename, e1.mgr,
    e2.empno, e2.ename, e2.mgr
FROM
    emp e1, emp e2
WHERE
    e1.mgr = e2.empno;

-- 오라클 전용 외부조인
-- e1.mgr = e2.empno(+) => 왼쪽데이터를 보존하겠다
-- e1.mgr(+) = e2.empno => 오른쪽데이터를 보존하겠다
SELECT
    e1.empno, e1.ename, e1.mgr,
    e2.empno, e2.ename, e2.mgr
FROM
    emp e1, emp e2
WHERE
    e1.mgr = e2.empno(+);

/*
QUIZ2
사번, 이름, 부서명, 급여등급
-- 총 14줄
e.empno, e.ename d.dname s.grade
emp
dept
salgrade
*/

SELECT
    e.empno, e.ename,
    d.dname,
    s.grade
FROM emp e, dept d, salgrade s
WHERE
    e.deptno = d.deptno AND
    e.sal >= s.losal AND e.sal <= s.hisal;

-- JOIN USING
-- 아래코드는 두개의 테이블을 조인해서 deptno 는 두테이블에 있기때문에
-- 어느 테이블의 deptno 데이터인지 알려줘야한다
SELECT
    deptno
FROM
    emp e, dept d
WHERE
    e.deptno = d.deptno;

-- 아래코드는 emp e JOIN dept d USING(deptno) 조인을 사용해서
-- 어느 테이블인지 알려주지않아도 된다
SELECT
    deptno
FROM
    emp e JOIN dept d USING(deptno);

-- 다른 테이블을 더 조인하는 방법
SELECT
    deptno
FROM
    salgrade,
    emp e JOIN dept d USING(deptno);

-- JOIN ON
-- emp e JOIN dept d ON(e.deptno = d.deptno) 이방법은 어떤테이블이 같은지 명시해주고
-- SELECT 에서도 어떤 테이블인지 알려줘야한다
SELECT
    e.deptno
FROM
    emp e JOIN dept d ON(e.deptno = d.deptno);

-- 사원명, 급여등급 조회
-- JOIN ON => WHERE 에서 사용한것과 같이 ON 안에는 조건을 줄수있다
SELECT
    ename, sal,
    grade
FROM
    emp e JOIN salgrade s ON(e.sal >= s.losal AND e.sal <= s.hisal);

/*
QUIZ3
사번, 이름, 부서명, 급여등급
-- 총 14줄
-- JOIN ON 문법으로
e.empno, e.ename d.dname s.grade
emp
dept
salgrade
*/
SELECT
    e.empno, e.ename,
    d.dname,
    s.grade
FROM
    emp e JOIN salgrade s ON (e.sal >= s.losal AND e.sal <= s.hisal)
          JOIN dept d ON (e.deptno = d.deptno);
 
/*
emp e JOIN salgrade s ON (e.sal >= s.losal AND e.sal <= s.hisal)
          JOIN dept d ON (e.deptno = d.deptno)
첫번째 JOIN 에서 나온값을 JOIN 한다
*/   

/*
QUIZ4
사번 이름 상사사번 상사이름 (상사 근무지)
join on 문법으로
empno ename mgr ename loc
*/
SELECT
    e1.empno AS "사번", e1.ename AS "이름", e1.mgr AS "상사 사번",
    e2.ename AS "상사 이름",
    d.loc AS "상사 근무지"
FROM
    emp e1 JOIN emp e2 ON (e1.mgr = e2.empno)
           JOIN dept d ON (e1.deptno = d.deptno);

/*
QUIZ5
상사보다 월급이 많은 직원
*/
SELECT
    e1.ename AS "이름", e1.sal AS "월급",
    e2.ename AS "상사 이름", e2.sal AS "상사 월급"
FROM
    emp e1 JOIN emp e2 ON (e1.mgr = e2.empno AND e1.sal > e2.sal);
-- 위 코드는 e1.mgr = e2.empno AND e1.sal > e2.sal 이렇게 나온값을 원본으로 하겠다 라는 뜻이다

SELECT
    e1.ename AS "이름", e1.sal AS "월급",
    e2.ename AS "상사 이름", e2.sal AS "상사 월급"
FROM
    emp e1 JOIN emp e2 ON (e1.mgr = e2.empno)
WHERE
    e1.sal > e2.sal;
-- 위 코드는 e1.mgr = e2.empno 이렇게 나온값을 원본으로 하고
-- WHERE e1.sal > e2.sal WHERE 에 조건을 걸겠다 라는 뜻이다

-- LEFT OUTER JOIN
-- mgr 이 null 인 데이터는 빠짐
SELECT
    e1.ename AS "이름", e1.sal AS "월급",
    e2.ename AS "상사 이름", e2.sal AS "상사 월급"
FROM
    emp e1 JOIN emp e2 ON (e1.mgr = e2.empno);

-- 왼쪽 즉 emp e1 의 모든 내용을 보존해줌
-- 조건에 맞지 않는 경우 null 로 채워줌
SELECT
    e1.ename AS "이름", e1.sal AS "월급",
    e2.ename AS "상사 이름", e2.sal AS "상사 월급"
FROM
    emp e1 LEFT OUTER JOIN emp e2 ON (e1.mgr = e2.empno);

-- join 에 null 조건때문에 빠지는게 없다면
-- left outer join 과 같다
SELECT
    e.empno, e.ename,
    d.dname,
    s.grade
FROM
    emp e LEFT OUTER JOIN salgrade s ON (e.sal >= s.losal AND e.sal <= s.hisal)
          LEFT OUTER JOIN dept d ON (e.deptno = d.deptno);

SELECT
    e1.ename AS "이름", e1.sal AS "월급",
    e2.ename AS "상사 이름", e2.sal AS "상사 월급"
FROM
    emp e1 RIGHT OUTER JOIN emp e2 ON (e1.mgr = e2.empno);

SELECT
    e1.ename AS "이름", e1.sal AS "월급",
    e2.ename AS "상사 이름", e2.sal AS "상사 월급"
FROM
    emp e1 FULL OUTER JOIN emp e2 ON (e1.mgr = e2.empno);

-- QUIZ
-- Q1
/*
emp = empno, ename, sal
dept = deptno, dname
sal 이 2000 초과
*/
SELECT
    d.deptno, d.dname,
    e.empno, e.ename, e.sal
FROM
    emp e JOIN dept d ON (e.deptno = d.deptno)
WHERE
    e.sal > 2000
ORDER BY
    d.deptno;

-- Q2
/*
dept = deptno, dname
emp = sal
*/
SELECT
    d.deptno, d.dname,
    FLOOR(AVG(e.sal)) AS AVG_SAL, MAX(e.sal) AS MAX_SAL, MIN(e.sal) AS MIN_SAL,
    COUNT(*)
FROM
    emp e JOIN dept d ON (e.deptno = d.deptno)
GROUP BY
    d.deptno, d.dname;

-- Q3
SELECT
    d.deptno, d.dname,
    e.empno, e.ename, e.job, e.sal
FROM
    emp e RIGHT OUTER JOIN dept d ON (e.deptno = d.deptno)
ORDER BY
    d.deptno, e.ename;

-- 서브쿼리
SELECT
	*
FROM 
	emp
WHERE
	sal > (SELECT
				sal
			FROM
				emp
			WHERE
				ename = 'JONES');

-- QUIZ
-- JONES 와 같은 JOB 을 가지는 사원을 모두 출력
SELECT
	*
FROM
	emp
WHERE
	job = (SELECT
				job
			FROM
				emp
			WHERE
				ename = 'JONES')
-- JONES 를 제외하고 출력
AND ename != (SELECT
			  	ename
			  FROM
				emp
			  WHERE
				ename = 'JONES');

SELECT
	e.empno, e.ename, e.sal,
	d.deptno, d.dname
FROM
	emp e, dept d
WHERE
	e.deptno = d.deptno
AND	d.deptno = 20
AND	e.sal > (SELECT
				AVG(e.sal)
			FROM
				emp e);

-- 사원번호, 이름, 상사 사원번호, 상사의 사원번호, 이름
SELECT
	e1.empno, e1.ename, e1.mgr,
	e2.empno, e2.ename
FROM
	emp e1, emp e2
WHERE
	e1.mgr = e2.empno;

SELECT
	e1.ename
FROM
	emp e1
WHERE
	e1.mgr = (SELECT
					e2.empno
				FROM
					emp e2
				WHERE
					e2.empno = e1.mgr);

/*
 * emp 에서	
 * 자신의 부서의 최소 급여자를 출력
 * */
				
-- 부서별 최소급여
SELECT
	deptno, MIN(sal)
FROM
	emp
GROUP BY
	deptno;
			
SELECT
	e1.empno, e1.ename, e1.sal, e1.deptno
FROM
	emp e1
WHERE
	e1.sal = (SELECT
					MIN(sal)
				FROM
					emp
				WHERE
					deptno = e1.deptno)
ORDER BY
	e1.deptno;
			
-- 다중행 서브쿼리
SELECT
	*
FROM
	emp
WHERE
	sal IN (SELECT
					MAX(sal)
				FROM
					emp
				GROUP BY
					deptno)
			
-- 다중열 서브쿼리
SELECT
	*
FROM
	emp
WHERE
	(deptno, sal) IN (SELECT
							deptno, MAX(sal)
						FROM
							emp
						GROUP BY
							deptno);
			
-- WITH
-- 미리 변수를 지정해두고 그안에 가져올 테이블을 담아두고 사용한다
						
WITH
	e10 AS (SELECT 
				*
			FROM
				emp
			WHERE
				deptno = 10)
SELECT
	*
FROM
	e10;
						
-- SELECT 에 서브쿼리
-- 이방법은 하나의 결과만 반환할때 사용가능하다
SELECT
	empno, ename, job, sal,
	(SELECT
		grade
	FROM
		salgrade
	WHERE
		e.sal BETWEEN losal AND hisal) AS salgrade,
	deptno,
	(SELECT
		dname
	FROM
		dept
	WHERE
		e.deptno = dept.deptno) AS dname
FROM
	emp e;
						
-- QUIZ
-- Q1						
SELECT
	job, empno, ename, sal, emp.deptno, dept.dname
FROM
	emp JOIN dept ON (emp.deptno = dept.deptno)
WHERE
	job = (SELECT
				job
			FROM
				emp
			WHERE
				ename = 'ALLEN')
ORDER BY
	sal DESC, ename;
						
-- Q2
SELECT
	e.empno, e.ename, d.dname, e.hiredate, d.loc, e.sal, s.grade
FROM
	emp e JOIN dept d ON (e.deptno = d.deptno)
		  JOIN salgrade s ON (e.sal >= s.losal AND e.sal <= s.hisal)
WHERE
	e.sal > (SELECT
				AVG(sal)
			FROM
				emp)
ORDER BY
	e.sal DESC, e.empno;

-- Q3
SELECT
	e.empno, e.ename, e.job, d.deptno, d.dname, d.loc
FROM
	emp e JOIN dept d ON (e.deptno = d.deptno)
WHERE
	e.deptno = 10 AND
	e.job NOT IN (SELECT
						job
					FROM
						emp
					WHERE
						deptno = 30);

-- Q4
SELECT
	e.empno, e.ename, e.sal, s.grade
FROM
	emp e JOIN salgrade s ON (e.sal >= s.losal AND e.sal <= s.hisal)
WHERE
	e.sal > (SELECT
				MAX(sal)
	 		 FROM
				emp
			 WHERE
				job = 'SALESMAN')
ORDER BY
	e.empno;


-- 테이블 생성, 변경, 삭제
-- 테이블 생성 CREATE
CREATE TABLE EMP_DDL(
	EMPNO  NUMBER(4),
	ENAME  VARCHAR2(10),
	JOB    VARCHAR2(9),
	MGR    NUMBER(4),
	HIREDATE DATE,
	SAL    NUMBER(7, 2),
	COMM   NUMBER(7, 2),
	DEPTNO NUMBER(2)
);

-- 생성된 테이블 조회 DBEAVER 에서는 안됨
DESC EMP_DDL;

SELECT * FROM EMP_DDL;

-- 다른 테이블을 복사하여 테이블 생성
CREATE TABLE DEPT_DDL
	AS SELECT * FROM DEPT;

SELECT * FROM DEPT_DDL;

-- 다른 테이블의 일부를 복사해서 새테이블 생성
CREATE TABLE EMP_DDL_30
	AS SELECT *
		FROM EMP
		WHERE DEPTNO = 30;

SELECT * FROM EMP_DDL_30;

-- 기존 테이블의 열구조만 복사하여 새테이블 생성
CREATE TABLE EMPDEPT_DDL
	AS SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE,
			  E.SAL, E.COMM, D.DEPTNO, D.DNAME, D.LOC
		FROM EMP E, DEPT D
		WHERE 1 <> 1;
-- WHERE 의 결과가 언제나 false 가 나오게함
	
SELECT * FROM EMPDEPT_DDL;

-- 테이블 변경 ALTER
-- 테이블 생성
CREATE TABLE EMP_ALTER
	AS SELECT * FROM EMP;

SELECT * FROM EMP_ALTER;

-- 테이블에 열추가
ALTER TABLE EMP_ALTER
	ADD HP VARCHAR2(20);
-- ADD 열이름 데이터타입

-- 숫자도 초기값을 NULL 로 들어간다
ALTER TABLE EMP_ALTER
	ADD HP2 NUMBER(20);

SELECT * FROM EMP_ALTER;

-- 열의 이름변경 RENAME
ALTER TABLE EMP_ALTER
	RENAME COLUMN HP TO TEL;
-- RENAME 열중에 HP 에서 TEL 로 변경 

SELECT * FROM EMP_ALTER;

-- 열의 데이터 타입 변경 MODIFY
ALTER TABLE EMP_ALTER
	MODIFY EMPNO NUMBER(5);
-- MODIFY EMPNO 의 데이터타입을 NUMBER(5) 로 바꿈
-- MODIFY 로 열의 데이터 타입을 변경하면 바꾼 데이터타입보다 작은값으론 바꿀수없다
-- 큰값만 가능

SELECT * FROM EMP_ALTER;

-- 특정열을 삭제할때 사용하는 DROP
ALTER TABLE EMP_ALTER 
	DROP COLUMN TEL;
-- DROPT TEL 열을 지움

SELECT * FROM EMP_ALTER;

-- 열안에 데이터가 있어도 열이 삭제가 된다
ALTER TABLE EMP_ALTER
	DROP COLUMN HIREDATE;

-- 테이블 이름을 변경하는 RENAME
RENAME EMP_ALTER TO EMP_RENAME;

SELECT * FROM EMP_ALTER;
SELECT * FROM EMP_RENAME;

-- 테이블의 데이터를 삭제하는 TRUNCATE						
TRUNCATE TABLE EMP_RENAME;
						
SELECT * FROM EMP_RENAME;
						
-- 테이블을 삭제하는 DROP
DROP TABLE EMP_RENAME;


-- 데이터를 추가, 수정, 삭제하는 데이터 조작어
-- DEPT 테이블을 복사해 새로운 테이블 생성
CREATE TABLE DEPT_TEMP
	AS SELECT * FROM DEPT;

SELECT * FROM DEPT_TEMP;
						
-- 테이블에 데이터를 추가하는 INSERT
INSERT INTO DEPT_TEMP (DEPTNO, DNAME, LOC)
	VALUES (50, 'DATABASE', 'SEOUL');
-- 행의 개수와 벨류 개수가 일치해야된다			
			
			
			
-- 대댓글
SELECT 
	rownum, LEVEL, empno, lpad(' ', 4 * level) || ename, mgr
FROM 
	emp
START WITH 
	mgr IS NULL	-- 시작점
CONNECT BY /* where 에 해당하는 영역 */ (empno != 7844) 
AND /* 계층관계 */ PRIOR empno = mgr
ORDER siblings BY empno DESC;	-- 계층을 유지하면서 정렬	


-- DB 종류 상관없는 대댓글
-- 재귀호출
WITH
	emp_recu (lv, empno, ename, mgr) AS  (
		SELECT
			1 AS lv,
			empno, mgr, ename
		FROM
			emp	-- 대상 테이블
		WHERE	
			mgr IS NULL	-- 원글
			
		UNION ALL
		
		SELECT
			er.lv + 1 AS lv,
			e.empno, e.mgr, e.ename
		FROM
			emp_recu er	-- 재귀호출
		LEFT OUTER JOIN emp e ON e.mgr = er.empno	-- 대상테이블
		WHERE
			e.mgr IS NOT NULL	-- 원글을 제외하는 조건
	)
SEARCH DEPTH FIRST BY empno SET sort_empno	-- 졍렬에 대한 별칭
SELECT
	*
FROM
	emp_recu
ORDER BY sort_empno;


SELECT
	rownum, empno, hiredate
FROM 
	emp
;


-- 페이징 수식
-- 시작 ( (보여줄페이지갯수 * 선택한페이지)  - (보여줄페이지갯수 - 1) ) 끝 (보여줄페이지갯수 * 선택한페이지)
-- 총페이지수 올림처리(총글갯수 / 보여줄페이지갯수)

SELECT 
	*
FROM
	(
	SELECT 
		rownum rnum, t1.*
	FROM
		(
		SELECT 
			emp3.*
		FROM
			emp3
		ORDER BY
			empno
		) t1
	)
WHERE rnum >= ( (3 * 3) - (3 - 1) ) AND rnum <= (3 * 3);













