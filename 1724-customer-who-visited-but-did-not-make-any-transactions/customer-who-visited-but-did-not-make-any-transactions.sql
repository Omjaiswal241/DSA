SELECT v.customer_id,Count(v.visit_id) AS count_no_trans
From Visits v
Left Join Transactions t
On v.visit_id=t.visit_id
Where t.Transaction_id is null
Group By customer_id;
