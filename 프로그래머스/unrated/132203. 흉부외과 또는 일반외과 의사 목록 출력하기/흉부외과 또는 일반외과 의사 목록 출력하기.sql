-- 코드를 입력하세요
SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d') AS HIRE_YMD
FROM DOCTOR
WHERE MCDP_CD IN ('CS', 'GS') -- MCDP_CD = 'CS' OR MCDP_CD = 'GS' 
ORDER BY HIRE_YMD DESC, DR_NAME;


-- Mysql 문자열 비교는 == 가 아니라 = 이다.
-- 다중정렬 할때는 ,(콤마) 를 빼먹지 말고 적어주자