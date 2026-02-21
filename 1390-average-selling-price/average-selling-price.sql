Select p.product_id,ifnull(Round(Sum(p.price*u.units)/SUM(u.units),2),0) as average_price
From Prices p
Left Join UnitsSold u
On p.product_id=u.product_id
AND u.purchase_date Between p.start_date and p.end_date
GROUP BY p.product_id