Select score,DENSE_RANK() Over (ORDER BY score desc) as 'rank'
from Scores;