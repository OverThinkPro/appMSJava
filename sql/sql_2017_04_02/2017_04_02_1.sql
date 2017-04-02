/* 修改级联删除  t_base_user_role*/

ALTER TABLE t_base_user_role DROP CONSTRAINT fk_t_base_user_role_t_base_user_info;

ALTER TABLE t_base_user_role ADD CONSTRAINT fk_t_base_user_role_t_base_user_info FOREIGN KEY (user_id) REFERENCES t_base_user_info (user_id) ON DELETE CASCADE;


ALTER TABLE t_base_user_role DROP CONSTRAINT fk_t_base_user_role_t_base_role_info;

ALTER TABLE t_base_user_role ADD CONSTRAINT fk_t_base_user_role_t_base_role_info FOREIGN KEY (role_id) REFERENCES t_base_role_info (role_id) ON DELETE CASCADE;


