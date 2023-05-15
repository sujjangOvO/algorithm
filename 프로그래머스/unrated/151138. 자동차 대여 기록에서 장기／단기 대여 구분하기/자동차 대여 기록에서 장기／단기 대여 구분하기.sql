-- DATEDIFF(날짜1, 날짜2): 날짜 차이(날짜1-날짜2) 가져오는 함수 
-- +1 해주는 이유는 반납일과 시작일이 같으면 0으로 카운트 되므로 이를 방지하기 위해 +1
-- 그 외, TIMESTAMPDIFF 함수로 다양한 단위의 날짜 계산도 할 수 있다

SELECT HISTORY_ID, CAR_ID,
    DATE_FORMAT(START_DATE, '%Y-%m-%d') AS START_DATE,
    DATE_FORMAT(END_DATE, '%Y-%m-%d') AS END_DATE,
    IF(DATEDIFF(END_DATE, START_DATE) + 1 >= 30, '장기 대여', '단기 대여') AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE DATE_FORMAT(start_date, '%Y-%m-%d') BETWEEN '2022-09-01' AND '2022-09-31'
ORDER BY HISTORY_ID DESC;