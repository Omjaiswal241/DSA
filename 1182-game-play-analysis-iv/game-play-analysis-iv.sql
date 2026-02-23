# Write your MySQL query statement below
Select 
Round(Sum(date_login)/Count(Distinct player_id),2) as fraction
From
(SELECT player_id,
datediff(event_date,min(event_date) Over (partition by player_id))=1 as date_login
From Activity) as New_table