# Write your MySQL query statement below
Select id,movie,description,rating
from Cinema
Where MOD(id,2)=1 AND description != 'boring'
ORDER BY rating desc