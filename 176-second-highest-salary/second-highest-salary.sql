# Write your MySQL query statement below
select 
(
    select Distinct salary from Employee
    Order by salary desc
    Limit 1 Offset 1
) as SecondHighestSalary