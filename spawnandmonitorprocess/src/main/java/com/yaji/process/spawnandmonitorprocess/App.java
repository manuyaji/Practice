package com.yaji.process.spawnandmonitorprocess;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        //testUsingProcessBuilder();
        //testSuccessfulUsingRuntimeExec();
    	//testFailureUsingRuntimeExec();
    	testSuccessfulUsingProcessBuilder();
    	testFailureUsingProcessBuilder();
    }
    
    public static void testSuccessfulUsingProcessBuilder() throws IOException, InterruptedException{
    	ProcessBuilder pb = new ProcessBuilder();
    	pb.command("java", "-cp", 
    			"/Users/mgy0002/Work/Eclipse-Workspaces/Default-2-Workspace/Test/src/", "Test", "1");
    	
        Thread t = new Thread(()->{
        	Process p = null;
			try {
				p = pb.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	try {
        		if(p != null) {
        			p.waitFor();
        		}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	System.out.println(p.exitValue());
        });
        t.start();
    	/*Process p = pb.start();
    	int exitVal = p.waitFor();
    	System.out.println(exitVal);
    	System.out.println(p.exitValue());*/
    }
    
    public static void testFailureUsingProcessBuilder() throws IOException, InterruptedException{
    	ProcessBuilder pb = new ProcessBuilder();
    	pb.command("java", "-cp", 
    			"/Users/mgy0002/Work/Eclipse-Workspaces/Default-2-Workspace/Test/src/", "Test", "2");
    	
        Thread t = new Thread(()->{
        	Process p = null;
			try {
				p = pb.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	try {
        		if(p != null) {
        			p.waitFor();
        		}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	System.out.println(p.exitValue());
        });
        t.start();
    	/*Process p = pb.start();
    	int exitVal = p.waitFor();
    	System.out.println(exitVal);
    	System.out.println(p.exitValue());*/
    }
    
    public static void testSuccessfulUsingRuntimeExec() throws IOException, InterruptedException{
    	//SUCCESSFUL PROCESS
    	Process process = Runtime.getRuntime().exec(
    			"java -cp /Users/mgy0002/Work/Eclipse-Workspaces/Default-2-Workspace/Test/src/ Test 1");
    	
    	int exitValue = process.waitFor();
    	System.out.println(exitValue);
    	System.out.println(process.exitValue());
    }
    
    public static void testFailureUsingRuntimeExec() throws IOException, InterruptedException{
    	//FAILED PROCESS
    	Process process = Runtime.getRuntime().exec(
    			"java -cp /Users/mgy0002/Work/Eclipse-Workspaces/Default-2-Workspace/Test/src/ Test 2");
    	int exitValue = process.waitFor();
    	System.out.println(exitValue);
    	System.out.println(process.exitValue());
    }
}
