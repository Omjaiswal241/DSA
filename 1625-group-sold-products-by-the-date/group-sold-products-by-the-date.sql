# Write your MySQL query statement below
select sell_date,Count(distinct product) as num_sold,
Group_concat(distinct product Order by product Separator ',') as products
From Activities
Group by sell_date
Order by sell_date ASC