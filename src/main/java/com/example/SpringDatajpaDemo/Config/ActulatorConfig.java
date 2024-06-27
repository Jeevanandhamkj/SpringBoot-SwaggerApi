package com.example.SpringDatajpaDemo.Config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
@Component
@Endpoint(id="kj")
public class ActulatorConfig {
	
	private Map<String, String>kMap=new HashMap<String, String>();
	@ReadOperation
	
	Map<String, String>config(){
		kMap.put("jeeva", "Hi im jeeva");
		return kMap;
	}
	

}
