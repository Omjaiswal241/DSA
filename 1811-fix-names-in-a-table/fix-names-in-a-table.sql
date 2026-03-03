# Write your MySQL query statement below
select user_id,
concat(Upper(left(name,1)),Lower(right(name,length(name)-1))) as name
from Users
Order by user_id Asc