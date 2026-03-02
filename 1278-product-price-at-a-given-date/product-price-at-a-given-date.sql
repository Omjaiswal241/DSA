# Write your MySQL query statement below
select product_id,new_price as price 
from Products
where (product_id,change_date) IN
(
    select product_id,Max(change_date)
    from Products
    where change_date<='2019-08-16'
    Group by product_id
)
UNION
select product_id,10 as price
from Products
where product_id Not in 
(
    select Distinct product_id
    from Products
    where change_date<='2019-08-16'
)