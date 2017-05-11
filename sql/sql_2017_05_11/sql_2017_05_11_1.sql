/*菜单模块添加一个字段用于判断这个菜单是基础菜单，还是扩充的菜单 */
/* 基础菜单是 '1' 基础菜单不能删掉 */
ALTER TABLE t_base_defined_url ADD COLUMN base_module CHAR(1) DEFAULT '0';
/* 基础字典是 '1' 基础菜单不能删掉 */
ALTER TABLE t_base_sys_dic ADD COLUMN base_dic CHAR(1) DEFAULT '0';
/*修改菜单的字段 period_id vachar(8) 为varchar(40)*/
ALTER TABLE t_base_defined_url ALTER COLUMN module_id TYPE VARCHAR(40);