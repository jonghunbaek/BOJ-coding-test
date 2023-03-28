SELECT member_id, member_name, gender, to_char(date_of_birth, 'YYYY-MM-DD')
from member_profile
where to_char(date_of_birth, 'MM') = '03'
AND tlno is not null
AND gender = 'W'
order by member_id asc;