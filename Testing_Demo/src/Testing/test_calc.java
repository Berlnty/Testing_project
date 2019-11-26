package Testing;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Code.Calculator;

public class test_calc {
Calculator calculator;
	
	@BeforeClass
	public void beforeClass(){
        //Ideal place to perform some setup which is shared among all tests.
        //E.g. Initializing DB connection, setting environment properties
        System.out.println("@BeforeClass: I run only once, before first test start.");
        calculator = new Calculator();
    }
	
	@AfterClass
    public void afterClass(){
        //Ideal place to perform some cleanup of setup which is shared among all tests.
        System.out.println("@AfterClass: I run only once, after all tests have been done.\n");
        calculator = null;
    }
	//@BeforeMethod
    /*public void beforeEachTestMethod(){
        //May perform some initialization/setup before each test.
        //E.g. Initializing User whose properties may be altered by actual @Test
        System.out.println("\n@BeforeMethod: I run before each test method. Test to be executed is : ");
    }*/
     
    @AfterMethod
    public void afterEachTestMethod(Method method){
        //May perform cleanup of initialization/setup after each test.
        System.out.println("@AfterMethod: I run after each test method. Test just executed is : "+method.getName()+"\n");
        if(method.getName() == "testAdd")
        {
          Assert.assertEquals(calculator.LastResOperation, 5);        	
        }
        else if (method.getName() == "testMultiply")
        {
        	Assert.assertEquals(calculator.LastResOperation, 15);
        	
        }
        else
        {
        	Assert.assertEquals(calculator.LastResOperation, 2);
        	
        }
    }
 
    @Test
    public void testAdd(){
        System.out.println("@Test add");
        Assert.assertEquals(calculator.add(2, 3), 5);
    }
     
    @Test
    public void testSubtract(){
        System.out.println("@Test subtract");
        Assert.assertEquals(calculator.subtract(5, 3) , 2);
    }
     
    @Test
    public void testMultiply(){
        System.out.println("@Test multiply");
        Assert.assertEquals(calculator.multiply(5, 3) , 15);
    }
}
