
/* 修改级联删除 删除报警类型级联删除报警信息总表*/

ALTER TABLE t_base_alarm_info DROP CONSTRAINT fk_t_base_alarm_info_t_base_alarm_sound_setting;

ALTER TABLE t_base_alarm_info ADD CONSTRAINT fk_t_base_alarm_info_t_base_alarm_sound_setting FOREIGN KEY (alarm_type_id) REFERENCES t_base_alarm_sound_setting (alarm_type_id) ON DELETE CASCADE;


/* 修改级联删除 报警总表删除信息级联删除报警信息分表*/

ALTER TABLE t_overman_alarm DROP CONSTRAINT fk_t_overman_alarm_t_base_alarm_info;

ALTER TABLE t_overman_alarm ADD CONSTRAINT fk_t_overman_alarm_t_base_alarm_info FOREIGN KEY (alarm_id) REFERENCES t_base_alarm_info (alarm_id) ON DELETE CASCADE;

ALTER TABLE t_overtime_alarm DROP CONSTRAINT fk_t_overtime_alarm_t_base_alarm_info;

ALTER TABLE t_overtime_alarm ADD CONSTRAINT fk_t_overtime_alarm_t_base_alarm_info FOREIGN KEY (alarm_id) REFERENCES t_base_alarm_info (alarm_id) ON DELETE CASCADE;

ALTER TABLE t_region_special_alarm DROP CONSTRAINT fk_t_region_special_alarm_t_base_alarm_info;

ALTER TABLE t_region_special_alarm ADD CONSTRAINT fk_t_region_special_alarm_t_base_alarm_info FOREIGN KEY (alarm_id) REFERENCES t_base_alarm_info (alarm_id) ON DELETE CASCADE;

ALTER TABLE t_ls_staff_alarm DROP CONSTRAINT fk_t_ls_staff_alarm_t_base_alarm_info;

ALTER TABLE t_ls_staff_alarm ADD CONSTRAINT fk_t_ls_staff_alarm_t_base_alarm_info FOREIGN KEY (alarm_id) REFERENCES t_base_alarm_info (alarm_id) ON DELETE CASCADE;
