# Write your MySQL query statement below


Select Department,Employee,Salary from
(select d.name as Department, e.name as Employee, e.salary as Salary,
Dense_Rank() Over (Partition By d.name Order by e.salary desc) as Ranks
from Employee e
Left Join Department d
On e.departmentId=d.id ) t
Where Ranks<=3