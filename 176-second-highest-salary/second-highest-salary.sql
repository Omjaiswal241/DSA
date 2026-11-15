# Write your MySQL query statement below
Select
(Select DISTINCT salary
from Employee
Order by salary DESC
LIMIT 1 Offset 1)  as SecondHighestSalary 