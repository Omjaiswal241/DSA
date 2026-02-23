# Write your MySQL query statement below
Select r.contest_id,Round(((Count(r.user_id)*100.0) / (Select Count(*) from Users)),2) as percentage 
From Register r 
Group By r.contest_id 
Order By percentage desc,r.contest_id asc;