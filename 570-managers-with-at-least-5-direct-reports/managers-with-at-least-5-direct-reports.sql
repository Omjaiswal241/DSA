# Write your MySQL query statement below
Select e1.name from Employee e1
Inner Join Employee e2
Where e1.id=e2.managerid
Group by e1.id
Having Count(e1.id)>=5