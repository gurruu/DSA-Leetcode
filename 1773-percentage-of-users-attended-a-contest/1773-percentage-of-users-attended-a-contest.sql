# Write your MySQL query statement below
select contest_id,round(count(Register.user_id)/(select count(Users.user_id) from Users)*100,2) as percentage
from Register
group by contest_id
order by percentage desc, contest_id asc