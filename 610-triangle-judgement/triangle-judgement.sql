# Write your MySQL query statement below
select x,y,z,If((x+y)>z AND (y+z)>x And (z+x)>y,'Yes','No') as triangle
from Triangle
