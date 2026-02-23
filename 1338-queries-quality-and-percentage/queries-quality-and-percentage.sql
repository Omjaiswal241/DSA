# Write your MySQL query statement below
Select q.query_name,Round(Avg(q.rating/q.position),2) as quality,Round(((SUM(if(q.rating<3,1,0)))/Count(*))*100.0,2) as poor_query_percentage
from Queries q
Group by q.query_name
