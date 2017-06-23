package com.webleader.appms.controller.staff;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webleader.appms.annotation.SystemLogController;
import com.webleader.appms.bean.staff.DutyDate;
import com.webleader.appms.bean.staff.DutyUnit;
import com.webleader.appms.db.service.staff.DutyDateService;
import com.webleader.appms.db.service.staff.DutyUnitService;
import com.webleader.appms.util.Response;
import com.webleader.appms.util.UUIDUtil;

/**
 * @className DutyControl
 * @description 排班管理
 * @author ding
 * @date 2017年6月3日 下午5:12:57
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/v1/main")
public class DutyControl {

	@Autowired
	private UUIDUtil uuidUtil;
	@Autowired
	private DutyDateService dutyDateService;
	@Autowired
	private DutyUnitService dutyUnitService;

	/**
	 * @description 进行排班
	 * @param days
	 * @param unitIdArr
	 * @return
	 */
	@RequestMapping(value = "/base/duty/{days}", method = RequestMethod.POST)
	@SystemLogController(opType="排班",opContent="进行排班")
	public Map<Object, Object> arrangeDuty(@PathVariable int days, @RequestBody List<Map<String, Object>> dutyList) {
		Response response = new Response();
		int m = 0;
		DutyDate record = new DutyDate();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = Date.valueOf(formatter.format(Timestamp.from(Instant.now())));
		String[] unitIdArr = new String[dutyList.size()];
		String[] dutyIdArr = new String[dutyList.size()];
		
		for (int n = 0; n < dutyList.size(); n++) {
			unitIdArr[n] = dutyList.get(n).get("units").toString();
			dutyIdArr[n] = dutyList.get(n).get("dutyId").toString();
		}
		
		try {
			dutyDateService.deleteDutyDateListByDate(date);
		} catch (SQLException e1) {
			e1.printStackTrace();
			return response.failure("排班失败，请重试").toSimpleResult();
		}

		for (int i = 0; i < days; i++) {

			try {
				if (m != 1) {
					new DutyControl().saveSchedule(unitIdArr, dutyIdArr, record, i, uuidUtil, dutyDateService, dutyUnitService);
					m++;
				} else {
					unitIdArr = fanban(unitIdArr);
					new DutyControl().saveSchedule(unitIdArr, dutyIdArr, record, i, uuidUtil, dutyDateService, dutyUnitService);
					m = 1;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return response.failure("排班失败，请重试").toSimpleResult();
			}

		}

		return response.success("排班成功").toSimpleResult();
		
	}

	/**
	 * @description 将排班结果保存到数据库
	 * @param unitIdArr
	 * @param record
	 * @param i
	 * @throws SQLException
	 */
	public void saveSchedule(String[] unitIdArr, String[] dutyIdArr, DutyDate record, int i, UUIDUtil uuidUtil, 
			DutyDateService dutyDateService, DutyUnitService dutyUnitService) throws SQLException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = Date.valueOf(formatter.format(Timestamp.from(Instant.now().plus(i, ChronoUnit.DAYS))));
		record.setWorkDate(date);
		/* 添加早班 */
		String morning = uuidUtil.getUUID();
		String middle = uuidUtil.getUUID();
		String night = uuidUtil.getUUID();

		record.setdId(morning);
		record.setDutyId(dutyIdArr[0]);
		dutyDateService.insert(record);
		/* 添加中班 */
		record.setdId(middle);
		record.setDutyId(dutyIdArr[1]);
		dutyDateService.insert(record);
		/* 添加晚班 */
		record.setdId(night);
		record.setDutyId(dutyIdArr[2]);
		dutyDateService.insert(record);

		String[] morningIds = unitIdArr[0].trim().split(";");
		String[] middleIds = unitIdArr[1].trim().split(";");
		String[] nightIds = unitIdArr[2].trim().split(";");
		DutyUnit dutyUnit = new DutyUnit();

		/* 添加当天早班的班组 */
		for (int j = 0; j < morningIds.length; j++) {
			dutyUnit.setuId(uuidUtil.getUUID());
			dutyUnit.setdId(morning);
			dutyUnit.setUnitId(morningIds[j]);
			dutyUnitService.insert(dutyUnit);
		}
		/* 添加当天中班的班组 */
		for (int j = 0; j < middleIds.length; j++) {
			dutyUnit.setuId(uuidUtil.getUUID());
			dutyUnit.setdId(middle);
			dutyUnit.setUnitId(middleIds[j]);
			dutyUnitService.insert(dutyUnit);
		}
		/* 添加当天晚班的班组 */
		for (int j = 0; j < nightIds.length; j++) {
			dutyUnit.setuId(uuidUtil.getUUID());
			dutyUnit.setdId(night);
			dutyUnit.setUnitId(nightIds[j]);
			dutyUnitService.insert(dutyUnit);
		}
	}

	/**
	 * @description 正班倒
	 * @param p
	 * @return
	 */
	public static String[] zhengban(String[] p) {
		String three = p[2];

		p[2] = p[1];
		p[1] = p[0];
		p[0] = three;

		return p;
	}

	/**
	 * @description 反班倒
	 * @param p
	 * @return
	 */
	public static String[] fanban(String[] p) {
		String one = p[0];

		p[0] = p[1];
		p[1] = p[2];
		p[2] = one;

		return p;
	}
}
