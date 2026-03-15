# Write your MySQL query statement below
select Department, Employee,Salary
from
(select d.name as Department, e.name as Employee,e.salary as Salary,
Dense_Rank() Over (partition by d.name Order by e.salary desc) as Ranks
from Employee e
left join Department d
On e.departmentID=d.id) temp
Where Ranks<=3