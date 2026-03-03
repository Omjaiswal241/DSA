# Write your MySQL query statement below
select Department,Employee,Salary
from
(select d.name as Department,e.name as Employee,e.salary as Salary,
dense_rank() Over (partition by d.name Order by e.salary desc) as ranks
from Employee e
Left join Department d
ON e.departmentId=d.id) temp
where ranks<=3