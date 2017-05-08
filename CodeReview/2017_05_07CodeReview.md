# 2017/05/07 代码审核记录

## 后台

### bean

### common

PageConstants.java 和 ModalPageConstants.java
	- a)为了一个变量多写了一个类，代码可以共享。
	- b)类名不规范。
	- c)一个为 final，一个不是。
### util

?.java
	double x, y;
	等同于
	double x;
	double y;

### controller

HomeControl.java
	- a)方法注释：描述，参数，返回值，异常不规范。
	- b)List,Stack,Queue.
		``` bash
		List<Map<Object, Object>> realStaffByUnit = new Stack<Map<Object, Object>>();
		```
	- c)撤离呼叫：使用 for 循环替代 for-in 循环形式。
		``` bash
		for (String regionId : regionIdArr) {}
		```
	- d)修改注释。
		``` bash
		/**
		 * @modifyDescription
		 * @date
		 * @
		 */
		```
	- e) @Deprecated.
		evacuationCall();
		callStaffBack();

ReaderControl.java
	- a) updateReader()，当reader为null可能会有空指针异常。
		``` bash
		if (Objects.nonNull(reader.getGeoPoint()) && Objects.nonNull(reader.getGeoPointRef())) {
			Map<String, Double> sinCos = null;
			sinCos = pointSincos.getSinCos(reader.getGeoPoint().toString(), reader.getGeoPointRef().toString());
			reader.setRefSin(sinCos.get("sin"));
			reader.setRefCos(sinCos.get("cos"));
		}
		```
RegionControl.java

HistoryAlarmControl
	- a) 同 HomeController 调用同样的方法。

HistoryTrackControl.java

RealtimeStaffInfoControl.java

CardControl.java
	- a) Response 随性?。

JobTypeControl.java
	- a) getJobTypeListByCondition()接收参数。

UnitControl.java
	- a)注释：部门树

DictionaryControl.java
	- a)用户，角色，权限，关系

## 前台
	- 1)else缩进
	- 2)each方法，使用join，添加分隔符
