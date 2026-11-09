# Write your MySQL query statement below
Select w2.id 
from Weather w1
Inner Join Weather w2
On DATEDIFF(w2.recordDate,w1.recordDate)=1
Where w2.temperature>w1.temperature