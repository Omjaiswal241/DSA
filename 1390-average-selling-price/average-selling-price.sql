# Write your MySQL query statement below
Select p.product_id,ifnull(Round(Sum(p.price*u.units)/Sum(u.units),2) ,0) as average_price
from Prices p
Left Join UnitsSold u
On p.product_id=u.product_id And u.purchase_date Between p.start_date And p.end_date
Group By p.product_id