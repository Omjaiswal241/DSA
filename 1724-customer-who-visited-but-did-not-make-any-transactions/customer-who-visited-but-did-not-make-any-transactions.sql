# Write your MySQL query statement below
Select v.customer_id,Count(v.customer_id) as count_no_trans
from Visits v
left Join Transactions t
On v.visit_id=t.visit_id
where t.amount is null
Group by v.customer_id 
