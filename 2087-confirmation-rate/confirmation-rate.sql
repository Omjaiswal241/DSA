# Write your MySQL query statement below
Select s.user_id, Round(AVG(IF(c.action='confirmed',1,0)),2) as confirmation_rate
from Signups s
Left Join Confirmations c
On s.user_id=c.user_id
Group By s.user_id