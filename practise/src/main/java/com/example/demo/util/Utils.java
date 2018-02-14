package com.example.demo.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Utils {

	private final static Logger LOGGER = LoggerFactory.getLogger(Utils.class);
	private static String DATE_FORMAT = "yyyy-MM-dd";
	
	private static ObjectMapper objectMapper = 
			new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	
	@SuppressWarnings("unchecked")
	public static Object buildMockObject(String json, @SuppressWarnings("rawtypes") Class clazz)
			throws JsonParseException, JsonMappingException, IOException {
		return objectMapper.readValue(json, clazz);
	}
	
	/*
	 * Create Failure Message
	 */
//	public static KarmaResponse createFailureMessage(Long appId, Exception ex, String messageType) throws PayloadException {
//		KarmaResponse result = null;
//		try {
//			result = new KarmaResponse();
//			result.setSuccess(false);
//			result.setMessage(ex.getMessage());
//			result.setSuccessType(messageType);
//			if(isNotNullEmpty(ex.getCause()))
//				result.setCause(ex.getCause().toString());
//			else
//				result.setCause(null);
//			if(isNullEmpty(appId)){
//				result.setMessage("Exception: "+Constants.APPID_NULL_EMPTY.getValue());
//				result.setAppId(0);
//			}
//
//		} catch (Exception e) {
//			pringErr(LOGGER, "Exception: " + Constants.PAYLOAD_FAILURE_EXCEPTION.getValue());
//			throw new PayloadException(Constants.PAYLOAD_FAILURE_EXCEPTION.getValue());
//		}
//		return result;
//	}
	
	/*
	 * Create Success message
	 */
//	public static KarmaResponse createSuccessMessage(Long appId, String name, Object responseData) throws PayloadException{
//		KarmaResponse result = null;
//		try {
//			result = new KarmaResponse();
//			result.setSuccess(true);
//			result.setSuccessType(name);
//			result.setAppId(appId);
//			result.setResponseData(responseData.toString());
//		} catch (Exception e) {
//			LOGGER.error("Exception: " + Constants.PAYLOAD_FAILURE_EXCEPTION.getValue());
//			throw new PayloadException(Constants.PAYLOAD_FAILURE_EXCEPTION.getValue());
//		}
//		return result;
//	}
//	
//	public static boolean isNullEmpty(Object obj){
//		return !isNotNullEmpty(obj);
//	}

//	public static Long getAppId(App request) {
//		return (request != null && request.getAppId() != null) ? request.getAppId() : null;
//	}
//	public static Long getAppId(KarmaEventData request) {
//		return (request != null && request.getAppId() != null) ? request.getAppId() : null;
//	}
//	public static Long getAppId(Session request) {
//		return (request != null && request.getAppId() != null) ? request.getAppId() : null;
//	}
	
//	public static boolean isNotNullEmpty(String str) {
//
//        if (str == null || str.equalsIgnoreCase(Constants.STRING_NULL.getValue()) || str.isEmpty()) {
//            return false;
//        }
//        return true;
//    }
    
    public static boolean isNotNullEmpty(Object obj) {
        if (obj == null)
            return false;
        return true;
    }
    
    public static String getStackTrace(Exception e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		String exceptionMessage = sw.toString();
		pw.close();
		return exceptionMessage;
	}
    
    public static String getUTCFormattedDate(Date date) {
        SimpleDateFormat df = new SimpleDateFormat(
        Utils.DATE_FORMAT);
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        return df.format(date);
    }

	public static void pringLogs(Logger logger, String msg) {
		logger.debug(msg);
		System.out.println(msg);
	}
	
	public static void pringErr(Logger logger, String msg) {
		logger.error(msg);
		System.out.println(msg);
	}
	
	public static Calendar getTodayDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal;
	}
	
	public static List<Long> getTimestampBetweenDates(String startdateStr, String enddateStr) throws ParseException
    {
        DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        Date startdate = formatter.parse(startdateStr);
        Date enddate = formatter.parse(enddateStr);
        
        if(enddate.before(startdate)){
            return new ArrayList<>();
        }
        
        List<Long> dates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startdate);

        while (calendar.getTime().before(enddate))
        {
            Date result = calendar.getTime();
            dates.add(result.getTime());
            calendar.add(Calendar.DATE, 1);
        }
        dates.add(formatter.parse(enddateStr).getTime());
        Collections.reverse(dates);
        return dates;
    }
	
//	public static JSONObject rangeCounterToJsonObject(RangeCounter rangeCounter) throws JSONException {
//        return new JSONObject().put("name", rangeCounter.getName())
//                .put("data", JSONObject.wrap(rangeCounter.getCounter()));
//    }
//	
	public static String format(Date date) {
		DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
		return formatter.format(date);
	}
	
	public static List<Map<String, Object>> convertListOfBeanToListOfMap(List<?> list){
		List<Map<String, Object>> result = new ArrayList<>();
		for(Object obj : list) {
			result.add(convertBeanToMap(obj));
		}
		return result;
	}
	
	public static Map<String, Object> convertBeanToMap(Object bean){
		ObjectMapper m = new ObjectMapper();
		return m.convertValue(bean, Map.class);
	}
}
