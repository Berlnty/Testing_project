package Testing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Code.Emp_stat;

public class testEmp_stat {
 
	
	Emp_stat emp_stat;
	
	@Test(dataProvider="getData")
	public void test_std_salary(double salary1,double salary2,double salary3,double salary4,double salary5,double salary6)
	{
		System.out.println("Inside setData");
		
		System.out.println("get sal1::"+salary1);
		System.out.println("get sal2::"+salary2);
		System.out.println("get sal3::"+salary3);
		System.out.println("get sal4::"+salary4);
		System.out.println("get sal5::"+salary5);
		System.out.println("get sal6::"+salary6);
		
		//calculate std 
		
		List<Double> emp_salary = new ArrayList<Double>();
		emp_salary.add(salary1);
		emp_salary.add(salary2);
		emp_salary.add(salary3);
		emp_salary.add(salary4);
		emp_salary.add(salary5);
		emp_salary.add(salary6);
		
		
		double sum = 0.0, standardDeviation = 0.0;
        int length = emp_salary.size();

        for(double num : emp_salary) {
            sum += num;
        }

        double mean = sum/length;

        for(double num: emp_salary) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        double st_dev= Math.sqrt(standardDeviation/length);
        System.out.println("expected::"+st_dev);
        System.out.println("Actual::"+emp_stat.populationStandardDeviation(emp_salary));
        
        Assert.assertEquals(emp_stat.populationStandardDeviation(emp_salary), st_dev);
		
	}

	@BeforeClass
	public void Verify_fileExist() {
	
		System.out.println("Verify_fileExist");	
		
	boolean isFound=false;	
	 File file= new File("resources/inp.txt");
	 String file_name=file.getAbsolutePath();
		if(file.exists()) { 
			isFound=true;
		}
				
	Assert.assertEquals(isFound, true);
	System.out.println(" Before Method will execute before every test method");
	}
	
	@AfterClass
	public void Verify_fileClosed() 
	{
		
		boolean isClosed=false;	
		 File file= new File("resources/inp.txt");
		 String file_name=file.getAbsolutePath();
	 // try to rename the file with the same name
	 File sameFileName = new File(file_name);

	 if(file.renameTo(sameFileName)){
	 // if the file is renamed
	 System.out.println("file is closed");
	 }else{
	 // if the file didnt accept the renaming operation
	 System.out.println("file is opened");
	 } 
					
		
	System.out.println("After Method will execute after every test method ");
	}
	
	@DataProvider
	public Object[][] getData()  throws Exception
	{
		
		System.out.println("getData");
		
	  List<String> emp_salaries = new ArrayList<String>();	
  
	  File file= new File("resources/inp.txt");
		 String file_name=file.getAbsolutePath();
	 
	  BufferedReader br = new BufferedReader(new FileReader(file)); 
	  
	  String st; 
	  while ((st = br.readLine()) != null) 
		  emp_salaries.add(st);
	  
		  
	  List<Double>sal_double=new ArrayList<Double>();
	  
	  for(int i=0;i<emp_salaries.size();i++)
		  sal_double.add(Double.parseDouble(emp_salaries.get(i)));
	  
	 br.close();
	  
	 return new Object[][]{
         {sal_double.get(0),sal_double.get(1), sal_double.get(2), sal_double.get(3),sal_double.get(4),sal_double.get(5)}};
	}
		
}
