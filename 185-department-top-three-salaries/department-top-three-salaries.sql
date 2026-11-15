# Write your MySQL query statement below
Select Department,Employee,Salary
from
(
    Select d.name as Department,e.name as Employee,e.salary as Salary,
    Dense_Rank() Over(Partition by d.name Order By e.salary desc) as Ranks
    from Department d
    Inner Join Employee e
    On d.id=e.departmentId
) as f
Where Ranks<=3