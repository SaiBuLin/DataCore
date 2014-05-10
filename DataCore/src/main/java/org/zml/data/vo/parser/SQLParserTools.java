package org.zml.data.vo.parser;

import org.zml.data.vo.bind.FieldLogical;
import org.zml.data.vo.bind.TableRelation;
import org.zml.util.UtilTools;
import org.zml.vo.AIVOEngine;

/* 抽象类， 装载Parser 使用的工具方法 */
public abstract class SQLParserTools extends AIVOEngine {	
	
	
	public static String PROPERTY_KEY_CONNECTION = "VO_CONNECTION";
	public static String PROPERTY_KEY_ACTION_TOOL = "VO_ACTION_TOOL";
	public static String PROPERTY_KEY_FIELDS =  "PROPERTIES_FIELD";
	
	public static int DATA_MODE_FOR_UNKNOW = -1;
	public static int DATA_MODE_FOR_SELECT = 1;
	public static int DATA_MODE_FOR_UPDATE = 2;
	public static int DATA_MODE_FOR_INSERT = 3;
	public static int DATA_MODE_FOR_DELETE = 4;

	public static Boolean isSQLSelectString(String stringvalue) {
		Boolean result = false;
		
		try{
			if(UtilTools.isNull(stringvalue)){
				return result;
			}
			
			String[] words = stringvalue.split(" ");
			
			if( words == null ){
				return result;
			}
			
			if( words.length == 0 ){
				return result;
			}
			
			for( int ii = 0; ii < words.length; ii++ ){
				String oneword = UtilTools.getTrim( words[ii] );
				if( oneword.equalsIgnoreCase("Select") ){
					result = true;
					break;
				}
			}
			
			
		}catch(Exception e){
			result = false;
		}
		return result;
	}
	
	public static String parserTableRelation(TableRelation tableRelation){
		String result = "";
		
		try{
			
			if( tableRelation == TableRelation.INNER_JOIN ){
				
			}
			
			return result;
		}catch(Exception e){
			result = "";
		}
		return result;
		
	}
	
	public static String parserFieldRelation(TableRelation tableRelation){
		String result = "";
		
		try{
			
			if( tableRelation == TableRelation.INNER_JOIN ){
				
			}
			
			return result;
		}catch(Exception e){
			result = "";
		}
		return result;
		
	}
	
	public static String parserFieldLogical(FieldLogical value){
		String result = "";
		
		try{
			
			if( value == FieldLogical.EQUALS ){
				result = "=";
			}
			else if( value == FieldLogical.LARGER ){
				result = ">";
			}
			else if( value == FieldLogical.LOWER ){
				result = "<";
			}
			else if( value == FieldLogical.NOT_LARGER ){
				result = "<=";
			}
			else if( value == FieldLogical.NOT_LOWER ){
				result = ">=";
			}
			else if( value == FieldLogical.NOTEQUALS ){
				result = "<>";
			}
			
			return result;
		}catch(Exception e){
			result = "";
		}
		return result;
	}
	
	public static String[] splitSQLName(String namevalue){
		String[] result = null;
		try{
			if(UtilTools.isNull(namevalue)){
				return result;
			}
			
			String tmpNamevalue = UtilTools.getTrim( namevalue );
			
			result = tmpNamevalue.split(".");
			
			if( result == null ){
				result = new String[1];
				result[0] = tmpNamevalue;
			}else if( result.length == 0){
				result = new String[1];
				result[0] = tmpNamevalue;
			}
			
			return result;
		}catch(Exception e){
			result = null;
		}
		
		return result;
	}
	
	public static String[] splitString(String namevalue,String charstr){
		String[] result = null;
		try{
			if(UtilTools.isNull(namevalue)){
				return result;
			}
			
			if(UtilTools.isNull(charstr)){
				return result;
			}
			
			String tmpNamevalue = UtilTools.getTrim( namevalue );
			
			String tmpcharstr = UtilTools.getTrim(charstr);
			
			result = tmpNamevalue.split(tmpcharstr);
			
			if( result == null ){
				result = new String[1];
				result[0] = tmpNamevalue;
			}else if( result.length == 0){
				result = new String[1];
				result[0] = tmpNamevalue;
			}
			
			return result;
		}catch(Exception e){
			result = null;
		}
		
		return result;
	}
}
