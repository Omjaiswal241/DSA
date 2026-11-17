# Write your MySQL query statement below
Select Department, Employee, Salary
from
(
    Select d.name as Department,e.name as Employee,e.salary as Salary,
    Dense_Rank() Over (Partition By d.name Order By e.salary DESC) as RANKS
    from Employee e
    Inner Join Department d
    On e.departmentId=d.id
) as t
Where RANKS<=3