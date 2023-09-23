# Write your MySQL query statement below
select eid.unique_id,e.name from Employees e
left join EmployeeUNI eid
on e.id=eid.id