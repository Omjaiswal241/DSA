# Write your MySQL query statement below
select distinct v1.author_id as id
from Views v1
Where v1.author_id=v1.viewer_id
Order by id asc