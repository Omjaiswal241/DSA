# Write your MySQL query statement below
select person_name
from
(
    select person_name,Sum(weight) Over (Order by turn ASC) as TotalWeight
    from Queue
) t
Where TotalWeight<=1000
Order by TotalWeight desc
Limit 1