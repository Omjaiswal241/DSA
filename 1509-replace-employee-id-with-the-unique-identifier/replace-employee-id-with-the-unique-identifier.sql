# Write your MySQL query statement below
select f.unique_id as unique_id, e.name as name
from Employees e
left Join EmployeeUNI f
ON e.id=f.id