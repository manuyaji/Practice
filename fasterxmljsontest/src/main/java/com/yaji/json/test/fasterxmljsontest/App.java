package com.yaji.json.test.fasterxmljsontest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.yaji.json.test.fasterxmljsontest.models.Data;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try{
    		//testReplaceValues();
    		//testJsonIntoMap();
    		testParentNode();
    	}
        catch(Exception e){
        	e.printStackTrace();
        }
    }
    
    private static void testJsonIntoMap() throws Exception{
    	String content = "{\"data\":{\"one\":{\"age\":26,\"name\":\"Manu\"},\"two\":{\"name\":\"You\",\"age\":32}}}";
    	Data data = new ObjectMapper().readValue(content, Data.class);
    	System.out.println(data);
    }
    
    private static void testParentNode() throws Exception{
    	String content = "{\"data\":{\"one\":{\"age\":26,\"name\":\"Manu\"},\"two\":{\"name\":\"You\",\"age\":32}}}";
    	JsonNode jsonNode = new ObjectMapper().readTree(content);
    	JsonNode parent = jsonNode.findParent("data");
    	System.out.println(parent);
    	JsonNode parent2 = jsonNode.findParent("name");
    	System.out.println(parent2);
    }
    
    private static void testReplaceValues() throws Exception{
    	String content = "{\"me\":\"Manu\",\"place\":\"Bengaluru\"}";
    	
    	System.out.println(content);
    	System.out.println("===================================");
    	
    	JsonNode parent = new ObjectMapper().readTree(content);
    	
    	System.out.println("ORIGINAL JSON:");
    	System.out.println(parent);
    	System.out.println("===================================");
    	
    	replaceJsonNode(parent, "place", "Toronto");
    	
    	System.out.println("NEW JSON:");
    	System.out.println(parent);
    	System.out.println("===================================");
    	
    	
    	System.out.println(content);
    }
    
    private static void replaceJsonNode(JsonNode parentNode, String fieldName, String newValue){
    	ObjectNode parentONode = (ObjectNode) parentNode;
    	parentONode.put(fieldName, newValue);
    }
    
}
