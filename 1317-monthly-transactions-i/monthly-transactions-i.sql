# Write your MySQL query statement below
Select date_format(trans_date,'%Y-%m') as month,country,
Count(state) as trans_count,
Sum(IF(state='approved',1,0))as approved_count,
Sum(amount) as trans_total_amount,
Sum(If(state='approved',amount,0)) as approved_total_amount
From Transactions
Group By month,country