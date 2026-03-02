# Write your MySQL query statement below
select employee_id,department_id
from Employee
where primary_flag='Y'
Group by employee_id
UNION 
select employee_id,department_id
from Employee
Group by employee_id
Having count(employee_id)=1