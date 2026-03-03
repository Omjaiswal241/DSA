# Write your MySQL query statement below
select employee_id
from Employees
Where salary<30000
AND manager_id NOT In (select employee_id from Employees)
Order by employee_id ASC