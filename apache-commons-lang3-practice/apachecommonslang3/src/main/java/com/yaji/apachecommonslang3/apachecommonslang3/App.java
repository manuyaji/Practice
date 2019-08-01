package com.yaji.apachecommonslang3.apachecommonslang3;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        test();
    }
    
    public static void test(){
    	List<Integer>  h = Arrays.asList(3,4,5);
    	String x = StringUtils.join(h,",");
    	System.out.println(x);
    	
    }
}
