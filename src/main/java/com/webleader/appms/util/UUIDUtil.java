package com.webleader.appms.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class UUIDUtil {
	public String getUUID() {
		return UUID.randomUUID().toString();
	}
	
}
