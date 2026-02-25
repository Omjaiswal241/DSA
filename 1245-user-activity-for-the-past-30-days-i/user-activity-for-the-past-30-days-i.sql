# Write your MySQL query statement below
select activity_date as day,Count(distinct user_id) as active_users
from Activity
WHere activity_date between date_sub('2019-07-27',interval 29 day) AND '2019-07-27'
Group by day