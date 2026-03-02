# Write your MySQL query statement below
Select e1.employee_id,e1.name,Count(e2.employee_id) as reports_count,Round(Avg(e2.age)) as average_age
from Employees e1
join Employees e2
ON e1.employee_id=e2.reports_to
Group by e1.employee_id
order by e1.employee_id ASC