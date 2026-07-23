# Write your MySQL query statement below
select w2.id
from Weather w1
Cross join Weather w2
On DateDiff(w2.recordDate,w1.recordDate)=1 AND w2.temperature>w1.temperature