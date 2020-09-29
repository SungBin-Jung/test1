package test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpRequest;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TestJob implements Job{
	private final String USER_AGENT = "Mozilla/5.0";
	 @Override
	    public void execute(JobExecutionContext arg0) throws JobExecutionException {
		 try {
			TestJob.get("http://localhost:8080/test/result.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("Job Executed [" + new Date(System.currentTimeMillis()) + "]"); 
	    }
	 private static void get(String targeturl) throws Exception{
		 URL url = new URL(targeturl);
		 HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		 conn.setRequestMethod("GET");
		 //conn.setRequestProperty("User-Agent", USER_AGENT);
		 int responseCode = conn.getResponseCode();
		 System.out.println("HTTP 응답 코드 : "+responseCode);
	 }
}
