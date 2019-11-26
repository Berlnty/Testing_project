package Testing;


import org.testng.Assert;
import org.testng.annotations.*;

import Code.Employee;
import Code.Employees;

import java.io.*;
import java.util.*;

public class Emploees_test {
	Employees employees;
	
	@BeforeClass
	public void creat_instance() {
		
		employees=new Employees();
		
	}
	
	
	 @Test (groups= {"basic"}) // (priority=1)//(expectedExceptions = Exception.class) 
	 public void test_readfromfile() throws IOException {
		 File file= new File("resources/employees.txt");
		 String file_name=file.getAbsolutePath();
		 employees.Read_from_file(file_name, " ");
		 
		 
	 }
	 @Test(groups= {"basic"})  //(priority=2)
	 public void test_selectionsort() {
		 
		 ArrayList<Employee> temp=new ArrayList<Employee>();
		 temp = employees.Selection_sort();
		 
		 Collections.sort( temp);
		 
		 Assert.assertEquals(employees.Selection_sort(), temp);
	 }
	 
	 
	@Test(dataProvider="provide_data",dependsOnMethods="test_readfromfile",groups= {"basic"},enabled=false)
	 public void test_quiksort(int l,int u) {
		 ArrayList<Employee> temp=new ArrayList<Employee>();
		 temp = employees.Quick_sort(0,u);
		 Collections.sort( temp);
		 
		 Assert.assertEquals(employees.Quick_sort(l,u), temp);
	 
	 }
	 
		 @DataProvider
		 public Object[][] provide_data(){
			 
			Object arguments[][]= {{0,employees.arrli.size()-1}};
			 
			 return arguments;
		 }
		 
		 @Test(dependsOnMethods= {"test_readfromfile","check_listsize"}) //(priority= 2)
		 public void tets_averagesalary() {
			 employees.Average_salary();
			 
			 
			 
			 
			 
			 
		 }

		 @Test (groups= {"basic"}) 
		 public void check_listsize() {
			
			 Assert.assertNotEquals(employees.arrli.size(), 0);
			 
			 
		 }
		 
		 @Test(dependsOnMethods= {"test_readfromfile","check_listsize"},groups= {"basic","penality"})
		 public void test_penality() {
			 
			Employee temp= new Employee();
			temp= employees.arrli.get(0);
			 temp.salary-=50;
			 Assert.assertEquals(employees.penality( 0),temp );
		 }
		 
		 
		 @Test(dependsOnMethods= {"test_readfromfile","check_listsize"},groups= {"basic","reward"})
		 public void test_reward() {
			 
			Employee temp= new Employee();
			temp= employees.arrli.get(0);
			 temp.salary+=50;
			 Assert.assertEquals(employees.penality( 0),temp );
		 }

}
