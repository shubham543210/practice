package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
//import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Service;


import com.example.demo.bean.CurrentStatus;
import com.example.demo.bean.Studentbean;
import com.example.demo.domain.Idomain;


@Service
public class service1 {

	@Autowired
	private Idomain idomain;
	List<String> data = new ArrayList<>();
	{
		System.out.println("hi2");
	}
	
	public List<String> data() {
		
		data.add("shubham");
		data.add("78");
		data.add("52");
		Studentbean student=new Studentbean();
		student.setName("shubham12345");
		student.setPercentage(78);
		student.setRollno(100);
		int k = student.getRollno();
		String s=student.getName();
		//String s2=idomain.data();
		data.add(s);
	//	data.add(s2);
		return data;

	}

	public List<Map> Object(CurrentStatus currentStatus) throws Exception
	{
		List<Map> result=idomain.Output1(currentStatus.getName());
		
		return result;
		
		
	}
	//private Session session = null;


}
