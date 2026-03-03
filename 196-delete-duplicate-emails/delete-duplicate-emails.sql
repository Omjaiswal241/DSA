# Write your MySQL query statement below
delete p1
from person p1
inner join person p2
On p1.email=p2.email
And p1.id>p2.id