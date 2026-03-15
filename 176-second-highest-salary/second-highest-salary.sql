# Write your MySQL query statement below
select
(
    Select distinct salary
    from Employee
    Order by salary desc
    Limit 1 offset 1
) as SecondHighestSalary