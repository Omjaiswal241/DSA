# Write your MySQL query statement below
Select s.student_id,s.student_name,sub.subject_name,Count(e.subject_name) as attended_exams
from Students s
Cross JOin Subjects sub
Left join Examinations e
On s.student_id=e.student_id
and e.subject_name=sub.subject_name
Group BY s.student_id,s.student_name,sub.subject_name
Order by s.student_id,sub.subject_name;