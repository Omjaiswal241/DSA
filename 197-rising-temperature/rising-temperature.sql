# Write your MySQL query statement below
select w2.id as Id from Weather w1
Inner Join
Weather w2
ON DATEDIFF(w2.recordDate,w1.recordDate)=1 
Where w2.temperature>w1.temperature