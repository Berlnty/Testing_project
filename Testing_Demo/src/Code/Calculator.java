package Code;


/*This Class Perform Calculation on two numbers and save the last result operation in LastResOperation variable*/

public class Calculator {
	
	public int LastResOperation;

	public int add(int a, int b){
		LastResOperation=a+b;
        return a+b;
    }
     
    public int subtract(int a, int b){
    	LastResOperation=a-b;
        return a-b;
    }
     
    public int multiply(int a, int b){
    	//LastResOperation=a*b;
        return a*b;
    }
    
}
