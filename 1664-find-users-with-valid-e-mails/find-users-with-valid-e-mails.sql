# Write your MySQL query statement below
select *
from Users
where mail RegexP'^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode[.]com$'
and mail like Binary '%@leetcode.com'