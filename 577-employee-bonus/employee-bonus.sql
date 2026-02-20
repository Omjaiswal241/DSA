-- Write your PostgreSQL query statement below
SELECT name,bonus
From Employee
left Join Bonus
ON Employee.empId=Bonus.empId
WHERE Bonus.bonus<1000 OR Bonus.bonus is null