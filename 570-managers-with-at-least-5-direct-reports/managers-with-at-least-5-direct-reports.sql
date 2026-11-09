# Write your MySQL query statement below
Select e1.name
from Employee e1
Inner Join Employee e2
On e1.id=e2.managerId
Group By e1.id
Having Count(e1.id)>=5