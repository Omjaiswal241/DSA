# Write your MySQL query statement below
Select p.product_name, s.year , s.price
from Sales s
Left Join Product p
On p.product_id=s.product_id 