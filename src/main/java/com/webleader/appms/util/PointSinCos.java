package com.webleader.appms.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

/**
 * @className PointSinCos
 * @description 用于计算分站与参考点的sin，cos
 * @author ding
 * @date 2017年5月7日 下午12:18:19
 * @version 1.0.0
 */
@Component
public class PointSinCos {

	private GeometryFactory geometryFactory = new GeometryFactory();
		
	/** 
	 * @description 传入基站坐标，参考点坐标
	 * @param geoPoint
	 * @param geoPointref
	 * @return sin， cos
	 */
	public Map<String, Double> getSinCos(String geoPoint, String geoPointref){
		WKTReader reader = new WKTReader(geometryFactory);
		Map<String, Double> result = new HashMap<>();
		
		Point point = null;
		Point point2 = null;
		try {
			point = (Point) reader.read(geoPoint);
			point2 = (Point) reader.read(geoPointref);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		double x1 = point.getX();
		double y1 = point.getY();
		double x2 = point2.getX();
		double y2 = point2.getY();
		
		double sin = Math.abs((y2 - y1)/Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)));
		double cos = Math.abs((x2 - x1)/Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)));
		
		result.put("sin", sin);
		result.put("cos", cos);
		return result;
	}
	
}
