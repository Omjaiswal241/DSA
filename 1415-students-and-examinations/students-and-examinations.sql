# Write your MySQL query statement below
select s.student_id,s.student_name,sub.subject_name,Count(e.student_id) as attended_exams
from Students s
Cross Join Subjects sub
Left Join Examinations e
ON s.student_id=e.student_id AND sub.subject_name=e.subject_name
group by s.student_id,s.student_name,sub.subject_name
Order by s.student_id,sub.subject_name