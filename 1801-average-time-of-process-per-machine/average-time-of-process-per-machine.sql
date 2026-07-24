# Write your MySQL query statement below
select a1.machine_id,Round((AVG(a2.timestamp-a1.timestamp)),3) as processing_time
from Activity a1
Cross Join Activity a2
On a1.machine_id=a2.machine_id
AND a1.process_id=a2.process_id
AND a2.activity_type='end'
AND a1.activity_type='start'
Group By a1.machine_id