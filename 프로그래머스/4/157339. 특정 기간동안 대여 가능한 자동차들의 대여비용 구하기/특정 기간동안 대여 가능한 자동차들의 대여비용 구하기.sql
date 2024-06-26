# 차종 '세단' 또는 'SUV'
# 대여가능한지 22년 11월 1일~ 22년 11월 30일
# 대여금액 50만 ~ 200만 미만

# WITH A AS (
#     SELECT HISTORY_ID, CAR.CAR_ID, CAR_TYPE, DAILY_FEE, START_DATE, END_DATE
#     FROM CAR_RENTAL_COMPANY_CAR AS CAR
#     INNER JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS HISTORY
#     ON CAR.CAR_ID = HISTORY.CAR_ID
#     WHERE CAR_TYPE IN ('세단', 'SUV')
#     AND ((DATEDIFF(START_DATE, '2022-11-01 00:00:00') < 0 AND DATEDIFF(END_DATE, '2022-11-01 00:00:00') < 0)
#         OR (DATEDIFF(START_DATE, '2022-11-30 00:00:00') > 0 AND DATEDIFF(END_DATE, '2022-11-30 00:00:00') > 0))
# ), B AS (
#     SELECT CAR_ID, A.CAR_TYPE, CONVERT(DAILY_FEE*30*(100-DISCOUNT_RATE)*0.01, UNSIGNED) AS FEE
#     FROM A INNER JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS DISCOUNT
#     ON A.CAR_TYPE = DISCOUNT.CAR_TYPE
#     WHERE DURATION_TYPE = '30일 이상'
# )
# SELECT *
# FROM B
# WHERE FEE >= 500000 AND FEE < 2000000
# GROUP BY CAR_ID
# ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC

WITH ID_LIST AS (
    SELECT CAR_ID, CAR.CAR_TYPE, DISCOUNT_RATE, DAILY_FEE
    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS DISCOUNT
    LEFT JOIN CAR_RENTAL_COMPANY_CAR AS CAR
    ON DISCOUNT.CAR_TYPE = CAR.CAR_TYPE
    WHERE DURATION_TYPE = '30일 이상' AND CAR.CAR_TYPE IN ('SUV', '세단')
), UNAVAILABLE AS (
    SELECT CAR_ID, START_DATE, END_DATE
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE <= '2022-11-30'
      AND END_DATE >= '2022-11-01'
        # (START_DATE BETWEEN '2022-11-01 00:00:00' AND '2022-12-01 00:00:00')
        # OR (END_DATE BETWEEN '2022-11-01 00:00:00' AND '2022-12-01 00:00:00')
    GROUP BY CAR_ID
    ORDER BY CAR_ID
)
SELECT ID_LIST.CAR_ID, CAR_TYPE, CONVERT(DAILY_FEE*30*(100-DISCOUNT_RATE)*0.01, UNSIGNED) FEE
FROM UNAVAILABLE
RIGHT JOIN ID_LIST
ON UNAVAILABLE.CAR_ID = ID_LIST.CAR_ID
WHERE UNAVAILABLE.CAR_ID IS NULL
AND DAILY_FEE*30*(100-DISCOUNT_RATE)*0.01 >= 500000
AND DAILY_FEE*30*(100-DISCOUNT_RATE)*0.01 < 2000000
ORDER BY FEE DESC, CAR_TYPE ASC, ID_LIST.CAR_ID DESC