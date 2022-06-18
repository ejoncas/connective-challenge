SELECT max(salary) as second_highest_salary
FROM employee
where salary < (select max(salary) from employee)