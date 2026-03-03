# Write your MySQL query statement below
select p.product_name,Sum(o.unit) as unit
from Products p
left join Orders o
on p.product_id=o.product_id
where extract(year_month from o.order_date)=202002
Group by p.product_id
having unit>=100