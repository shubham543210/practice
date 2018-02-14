package com.example.demo.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import com.datastax.driver.core.BoundStatement;
import com.example.demo.bean.CurrentStatus;
import com.example.demo.domain.domainImpl.Operator;
import com.example.demo.util.Utils;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;


@Component("domainImpl")
public class domainImpl implements Idomain {
	
	//@Autowired
	//private CassandraDbUtils psCassendra;

	
	
	public enum Operator {
		// Database details
		
		TEST_KEYSPACE_NAME("current_data_management"),
		
		// Tables
		TABLE_CURRENT_DATA("data"),
		
		// Columns
		
		COLUMN_NAME("name"),
		COLUMN_CURRENT_DATA("current_data"),
		NAME("name"),
		ROLL_NO("roll_no"),
		
		EQUALS("$eq"), NOT_EQUALS("$ne"), GREATER_THAN("$gt"),
		LESS_THAN("$lt"), GREATER_THAN_EQUALTO(
		"$gte"), LESS_THAN_EQUALTO("$lte"), LIKE("$lk"),
		AND("$and"), OR(
		"$or"), INLIST("$in"),
		GET_DATA("SELECT " + COLUMN_CURRENT_DATA.getValue()  + " FROM " + TEST_KEYSPACE_NAME.getValue() + "." + TABLE_CURRENT_DATA.getValue() + " WHERE " + NAME.getValue() + " = ? ;");	
		private String value;
		private Operator(String value) {
		this.value = value;
		}
		public String getValue() {
		return value;
		}
		}
	
	//System.out.println("hi33");
	MongoClient mongoclient = new MongoClient(new MongoClientURI("mongodb://192.168.1.164:27017"));
	DB database = mongoclient.getDB("new");
	DBCollection collection = database.getCollection("first");
	

	
	public String data()
	{
		String s="data from mongodb";
		return s;
	}

	@Override
	public DBObject data(String name) {
	Map data =new HashMap();
String operator=Operator.EQUALS.getValue();
Operator op=Operator.EQUALS;
data.put("key", "name");
data.put("value",name );
data.put("operator", "EQUALS");
data.put("operator", op.getValue());
DBObject query3 = new BasicDBObject();
query3=project2(data);
return query3;
}
	
	public static DBObject project2(Map data) {
		  BasicDBObject query2 = new BasicDBObject();
		  query2.put(data.get("key").toString(), new BasicDBObject(data.get("operator").toString(), data.get("value")));
		  System.out.println("inside project");
		  return query2;
	}

	@Override
	public List<Map> output(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Map> Output1(String name) {
		List<Map> resultm=new ArrayList<>();
		DBCursor output2 = collection.find(data(name));
		{
			
			for (DBObject result : output2) {
				result.toMap();
				resultm.add((Map) result);
			}
			System.out.println("new/////" + resultm);
		}
		return resultm;
	}
}
