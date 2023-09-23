# I see some others solving this question using case when and sum.... which is nice... but
# That would not work if the timestamp is an actual date/time format. So I decided to just use join.

select a.machine_id, round(avg(b.timestamp - a.timestamp), 3) as processing_time 
from activity a join activity b
on a.machine_id = b.machine_id and a.process_id = b.process_id and a.activity_type = 'start' and b.activity_type = 'end'
group by a.machine_id;