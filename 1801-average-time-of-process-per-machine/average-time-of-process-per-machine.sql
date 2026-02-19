-- Write your PostgreSQL query statement below
Select a1.machine_id,round(AVG(a2.timestamp-a1.timestamp)::numeric,3) AS processing_time
From Activity a1
join Activity a2
ON a1.machine_id=a2.machine_id
And a1.process_id=a2.process_id
and a1.activity_type='start'
and a2.activity_type='end'
GROUP By a1.machine_id;