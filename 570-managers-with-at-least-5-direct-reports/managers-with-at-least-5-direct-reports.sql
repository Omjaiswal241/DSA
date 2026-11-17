# Write your MySQL query statement below
Select e.name 
from Employee e
Inner Join Employee e2
On e.id=e2.managerId
Group By e.id
Having Count(e.id)>=5