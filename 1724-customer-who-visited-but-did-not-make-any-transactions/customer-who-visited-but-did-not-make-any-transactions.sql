# Write your MySQL query statement below
Select v.customer_id, Count(v.customer_id) as count_no_trans
from Visits v
Left Join Transactions t
On v.visit_id=t.visit_id
Where t.transaction_id is null
Group By v.customer_id