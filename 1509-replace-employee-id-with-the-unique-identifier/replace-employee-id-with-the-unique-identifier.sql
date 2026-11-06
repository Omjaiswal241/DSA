Select b.unique_id , a.name 
from Employees as a
Left Join EmployeeUNI as b
On a.id=b.id