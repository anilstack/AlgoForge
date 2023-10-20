--display duplicate employee names count
SELECT EmployeeName, COUNT(EmployeeName) FROM Employees GROUP BY EmployeeName HAVING COUNT(EmployeeName) > 1
--display second highest salary
SELECT max(salary) AS secondHighestSalary FROM students.employees WHERE salary < (SELECT max(salary) from  students.employees);
--display first three highest salary
SELECT DISTINCT salary FROM  students.employees ORDER BY salary DESC LIMIT 3;