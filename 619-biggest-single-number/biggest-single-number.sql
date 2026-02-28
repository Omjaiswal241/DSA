# Write your MySQL query statement below
Select max(num) as num from
(Select num
from MyNumbers
Group by num
Having Count(num)=1) as num_table