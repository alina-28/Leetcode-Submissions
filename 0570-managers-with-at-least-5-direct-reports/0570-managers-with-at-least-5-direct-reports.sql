# Write your MySQL query statement below
select name FROM Employee
where id in (select managerId from Employee group by managerId having count(*)>=5);