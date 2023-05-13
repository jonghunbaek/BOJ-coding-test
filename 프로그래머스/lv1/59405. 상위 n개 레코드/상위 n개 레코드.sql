-- 코드를 입력하세요
SELECT NAME
FROM (SELECT name
      from animal_ins
      order by datetime)
WHERE ROWNUM <= 1;
