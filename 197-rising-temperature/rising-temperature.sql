# Write your MySQL query statement below
Select w2.id As Id
from Weather w1
Inner Join Weather w2
Where DateDiff(w2.recordDate,w1.recordDate)=1 And w2.temperature>w1.temperature 