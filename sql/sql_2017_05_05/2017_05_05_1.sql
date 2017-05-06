/*字典表*/
ALTER TABLE t_base_sys_dic RENAME englist_name TO english_name;

/*修改卡的字段 period_id vachar(20) 为varchar(40)*/
ALTER TABLE t_base_period_setting ALTER COLUMN period_id TYPE VARCHAR(40);
