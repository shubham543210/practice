package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.CurrentStatus;
import com.example.demo.bean.Studentbean;
//import com.example.demo.domain.CassandraDbManager;
import com.example.demo.service.service1;
import com.fasterxml.jackson.databind.ObjectMapper;

//import com.example.demo.service.service1;

@RestController
public class Controller1 {
	@Autowired
	private service1 service3;

//	@RequestMapping("/data")
//	public void controller1() {
//		 try {
//			service3.data4();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//System.out.println("////////////" + n);
//	
//	}

//	@RequestMapping(value = "/new", method = RequestMethod.POST)
//	public List<Map<String, Object>> controller2(@RequestBody String stringRequest) throws Exception  {
//		System.out.println("hi2");
//		List<Map> n = null;
//		List<Map<String, Object>> obj1=null;
//		// System.out.println("////////////"+n);
//		try {
//			CurrentStatus currentStatus = new ObjectMapper().readValue(stringRequest, CurrentStatus.class);
//			//n = (List<Map>) service3.data2(student);
//		obj1=service3.data3(currentStatus);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return obj1;
//	}
	@RequestMapping(value = "/new2", method = RequestMethod.POST)
	public List<Map> controller3(@RequestBody String stringRequest) throws Exception  {
		System.out.println("hi2");
		List<Map> n = null;
		List<Map> obj1=null;
		// System.out.println("////////////"+n);
		try {
			CurrentStatus currentStatus = new ObjectMapper().readValue(stringRequest, CurrentStatus.class);
			//n = (List<Map>) service3.data2(student);
		obj1=service3.Object(currentStatus);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj1;
	}

}