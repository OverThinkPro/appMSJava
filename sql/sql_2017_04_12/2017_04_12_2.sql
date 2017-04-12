/*由于对于不同的报警信息都需要一个处理的结果和时间，而有的字表不一致*/
/*所以提取共有的字段添加到总表中，并删除各个表中冗余的字段*/
/*报警总表*/
ALTER TABLE t_base_alarm_info RENAME alarm_time to alarm_start_time;
 
ALTER TABLE t_base_alarm_info ADD alarm_end_time TIMESTAMP;

/*报警分表*/
ALTER TABLE t_overman_alarm DROP alarm_start_time;
ALTER TABLE t_overman_alarm DROP alarm_state;
ALTER TABLE t_overman_alarm DROP alarm_end_time;
ALTER TABLE t_ls_staff_alarm DROP alarm_time;
ALTER TABLE t_region_special_alarm DROP alert_time;

