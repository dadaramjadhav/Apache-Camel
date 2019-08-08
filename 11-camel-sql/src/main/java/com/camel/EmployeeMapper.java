package com.camel;

import java.util.HashMap;
import java.util.Map;

public class EmployeeMapper {

	public Map<String, Object> getMap(Employee emp){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", emp.getId());
		map.put("name", emp.getName());
		return map;
	}
}