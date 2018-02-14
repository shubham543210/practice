package com.example.demo.domain;

import java.util.List;
import java.util.Map;

import com.mongodb.DBObject;

public interface Idomain {

	//mongo
	public String data();

	public DBObject data(String name);

	public List<Map> output(String name);

	//cassandra
	//List<Map<String, Object>> getData(String name) throws Exception ;

	public List<Map> Output1(String name);

}
