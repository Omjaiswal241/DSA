# Write your MySQL query statement below
select visited_on,
(
    select Sum(amount)
    from Customer
    where visited_on between date_sub(c.visited_on,interval 6 day) AND c.visited_on
) as amount,
ROUND((
    select sum(amount)/7
    from Customer
    where visited_on between date_sub(c.visited_on,interval 6 day) AND c.visited_on
),2) as average_amount
from Customer c
Where c.visited_on>=(
select date_add(MIN(visited_on),interval 6 day)
from Customer
)
Group by visited_on
order by visited_on