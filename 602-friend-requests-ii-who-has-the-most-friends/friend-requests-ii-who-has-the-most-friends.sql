# Write your MySQL query statement below
select id,COUNT(id) as num from
(SELECT requester_id as id from RequestAccepted
UNION ALL 
SELECT accepter_id as id from RequestAccepted) temp
Group by id
Order by num Desc
LIMIT 1