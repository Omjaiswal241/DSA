# Write your MySQL query statement below
(select u.name as results
from Users u
left join MovieRating mr
On u.user_id=mr.user_id
Group by u.user_id
Order by Count(u.user_id) DESC,u.name
Limit 1)
union all
(select m.title as results
from Movies m
left join MovieRating mr
On m.movie_id=mr.movie_id
Where extract(year_month from created_at)=202002
Group by m.movie_id
Order by AVG(mr.rating) DESC,m.title
LIMIT 1)