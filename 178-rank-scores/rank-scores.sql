# Write your MySQL query statement below
Select score,DENSE_RANK() Over (Order By score desc) As 'rank'
from Scores
