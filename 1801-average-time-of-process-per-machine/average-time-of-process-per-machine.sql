# Write your MySQL query statement below
select a1.machine_id, Round(Avg(a2.timestamp-a1.timestamp),3) as processing_time
from Activity a1
Inner Join Activity a2
On a1.machine_id=a2.machine_id And a1.process_id=a2.process_id
Where a1.activity_type='start' And a2.activity_type='end'
Group By a1.machine_id