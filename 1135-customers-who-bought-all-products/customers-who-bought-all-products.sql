# Write your MySQL query statement below
Select customer_id
from Customer
Group by customer_id
Having Count(Distinct product_key)=(Select Count(product_key) from Product)