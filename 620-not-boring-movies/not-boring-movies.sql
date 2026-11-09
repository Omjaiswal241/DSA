# Write your MySQL query statement below
Select id, movie, description, rating 
from Cinema
Where (id%2=1) And description <> 'boring'
Order by rating desc