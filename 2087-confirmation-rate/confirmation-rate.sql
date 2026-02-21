# Write your MySQL query statement below
Select s.user_id,Round(Avg(if(c.action='confirmed',1,0)),2) as confirmation_rate
From Signups s
Left join Confirmations c
ON s.user_id=c.user_id
Group By s.user_id



