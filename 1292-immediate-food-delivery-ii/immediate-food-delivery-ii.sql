# Write your MySQL query statement below
Select Round(Sum(If(min_order_date=min_customer_pref_delivery_date,1,0))*100.0/Count(min_order_date),2) as immediate_percentage
From (Select delivery_id,customer_id,
min(order_date) as min_order_date,
min(customer_pref_delivery_date) as min_customer_pref_delivery_date
From Delivery
Group by customer_id) as New_Table