# Write your MySQL query statement below
select "Low Salary" as category,
Sum(If(income<20000,1,0)) as accounts_count
from Accounts
Union
Select "Average Salary" as category,
Sum(If(income>=20000 And income<=50000,1,0)) as accounts_count
from Accounts
Union
Select "High Salary" as category,
Sum(If(income>50000,1,0)) as accounts_count
from Accounts