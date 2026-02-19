Select (
    Select DISTINCT salary
    From Employee
    Order By salary desc
    Limit 1 OFFSET 1
) AS SecondHighestSalary

