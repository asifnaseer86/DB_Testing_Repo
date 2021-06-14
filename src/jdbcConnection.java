import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class jdbcConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String host = "localhost";
		String port = "3306";
		Connection con =DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/qadbt", "root", "Matrix1");
		
		Statement s = con.createStatement();
		
		
		ResultSet rs = s.executeQuery("select * from employeeinfo where age = 21");
		
		
		while(rs.next()) 
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Cyborg Tech\\Automation Testing Selenium\\ChromeDriver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://login.salesforce.com/");
			
			driver.findElement(By.cssSelector("#username")).sendKeys(rs.getString("Name"));
			driver.findElement(By.cssSelector("#password")).sendKeys(rs.getString("Location"));
			
			System.out.println(rs.getString("Name"));
			System.out.println(rs.getString("Location"));
		}
		
	}

}
