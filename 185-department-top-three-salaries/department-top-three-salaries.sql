# Write your MySQL query statement below
select Department,Employee,Salary from
(select d.name as Department,e.name as Employee,e.salary as Salary,
DENSE_RANK() OVER (PARTITION by d.name order by e.salary desc) as Ranks
from Employee e
left Join Department d
On e.departmentId=d.id) temp
Where Ranks<=3