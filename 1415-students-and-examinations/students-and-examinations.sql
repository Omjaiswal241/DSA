Select s.student_id,s.student_name,sub.subject_name,Count(e.subject_name) as attended_exams
From Students s
Cross Join Subjects sub
Left Join Examinations e
On s.student_id=e.student_id
And sub.subject_name=e.subject_name
Group BY s.student_id,s.student_name,sub.subject_name
ORDER BY s.student_id,sub.subject_name;