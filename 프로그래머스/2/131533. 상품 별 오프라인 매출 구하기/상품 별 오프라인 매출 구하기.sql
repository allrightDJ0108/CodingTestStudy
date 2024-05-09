-- 코드를 입력하세요
SELECT P.PRODUCT_CODE, SUM(P.PRICE * SA.SALES_AMOUNT) AS PRICE
FROM OFFLINE_SALE SA
LEFT JOIN PRODUCT P
ON SA.PRODUCT_ID = P.PRODUCT_ID
GROUP BY P.PRODUCT_CODE
ORDER BY PRICE DESC, P.PRODUCT_CODE