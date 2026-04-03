select(
    select DISTINCT salary
    from Employee
    Order by salary desc
    LIMIT 1 OFFSET 1
)as SecondHighestSalary