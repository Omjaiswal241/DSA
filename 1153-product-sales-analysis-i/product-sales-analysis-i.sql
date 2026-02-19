# Write your MySQL query statement below
Select product_name,year,price
from Sales
Cross Join Product
On Sales.product_id=Product.product_id;