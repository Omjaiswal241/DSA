# Write your MySQL query statement below
Select Round((Sum(valid)/Count(Distinct customer_id))*100,2) as immediate_percentage
from
(
    Select customer_id, DateDiff(customer_pref_delivery_date,MIN(order_date) Over (Partition By customer_id))=0 as valid
    from Delivery 
) as temp