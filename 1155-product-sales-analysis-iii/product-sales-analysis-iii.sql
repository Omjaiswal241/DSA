# Write your MySQL query statement below
Select product_id,year as first_year,quantity,price
from Sales
Where ((product_id,year) IN (select product_id,min(year) from Sales Group By product_id))