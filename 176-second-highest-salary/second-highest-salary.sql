# Write your MySQL query statement below
Select
(select distinct salary
from Employee
Order by salary desc
LImit 1 Offset 1) SecondHighestSalary