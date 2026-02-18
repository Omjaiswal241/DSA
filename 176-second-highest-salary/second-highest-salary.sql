Select
(Select DISTINCT salary
from Employee
Order By salary desc
LIMIT 1 OFFSET 1) AS SecondHighestSalary;