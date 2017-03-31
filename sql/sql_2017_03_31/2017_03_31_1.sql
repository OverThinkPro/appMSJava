
/* 修改级联删除  t_base_role_module*/

ALTER TABLE t_base_role_module DROP CONSTRAINT fk_t_base_role_module_t_base_defined_url;

ALTER TABLE t_base_role_module ADD CONSTRAINT fk_t_base_role_module_t_base_defined_url FOREIGN KEY (module_id) REFERENCES t_base_defined_url (module_id) ON DELETE CASCADE;

ALTER TABLE t_base_role_module DROP CONSTRAINT fk_t_base_role_module_t_base_role_info;

ALTER TABLE t_base_role_module ADD CONSTRAINT fk_t_base_role_module_t_base_role_info FOREIGN KEY (role_id) REFERENCES t_base_role_info (role_id) ON DELETE CASCADE;