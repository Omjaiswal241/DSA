# Write your MySQL query statement below
select s.user_id,Round(Avg(If(c.action='confirmed',1,0)),2) as confirmation_rate
from Signups s
Left Join Confirmations c
On s.user_id=c.user_id
Group By s.user_id