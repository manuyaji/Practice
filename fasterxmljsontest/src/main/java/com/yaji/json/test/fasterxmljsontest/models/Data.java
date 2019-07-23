package com.yaji.json.test.fasterxmljsontest.models;

import java.util.HashMap;
import java.util.Map;

public class Data {
	
	private Map<String, MyData> data = new HashMap<String, MyData>();

	public Map<String, MyData> getData() {
		return data;
	}

	public void setData(Map<String, MyData> map) {
		this.data = map;
	}

	@Override
	public String toString() {
		return "Data [data=" + data + "]";
	}

}
