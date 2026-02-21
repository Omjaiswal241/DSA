# Write your MySQL query statement below
Select p.project_id,Round(Avg(e.experience_years),2) as average_years
From Project p
Left join Employee e
on e.employee_id=p.employee_id
Group by p.project_id