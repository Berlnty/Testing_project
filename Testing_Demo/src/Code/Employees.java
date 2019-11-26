package Code;

import org.testng.annotations.*;
import java.io.*;
import java.util.ArrayList; 

public class Employees {
	
	
	 public ArrayList<Employee> arrli = new ArrayList<Employee>();
	 
	 
	 
	
	 public void Read_from_file(String file_name,String separator) throws IOException{
		 File file = new File(file_name); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		  String st; 
		  while ((st = br.readLine()) != null) 
		  {  String[] parts = st.split(separator);         //"-"     Exception
		   arrli.add(new Employee(Integer.valueOf(parts[1]),parts[0]));
		  //  System.out.println(parts[0]+"--"+ parts[1]); 
		  }
	 
	 }
	 
	 
	 public ArrayList<Employee> Selection_sort(){
		 int i, j, min_idx; 
		 
		 for (i = 0; i < arrli.size()-1; i++) 
		    { 
		        // Find the minimum element in unsorted array 
		        min_idx = i; 
		        for (j = i+1; j < arrli.size(); j++) 
		          if (arrli.get(j).salary < arrli.get(min_idx).salary) 
		            min_idx = j; 
		  
		        // Swap the found minimum element with the first element 
		        exchangeNumbers(min_idx, i); 
		    } 
		 return arrli;
		 
	 }
	
	 
	 

	 public ArrayList<Employee> Quick_sort(int lowerIndex, int higherIndex){
		
		 int i = lowerIndex;
	        int j = higherIndex;
	        int pivot = arrli.get(lowerIndex+(higherIndex-lowerIndex)/2).salary;
	        
	        while (i <= j) {
	           
	            while (arrli.get(i).salary < pivot) {
	                i++;
	            }
	            while (arrli.get(j).salary > pivot) {
	                j--;
	            }
	            if (i <= j) {
	            	exchangeNumbers(i, j);
	                //move index to next position on both sides
	                i++;
	                j--;
	            }
	        }
	        // call quickSort() method recursively
	        if (lowerIndex < j)
	            Quick_sort(lowerIndex, j);
	        if (i < higherIndex)
	            Quick_sort(i, higherIndex);
	        return arrli;
		 
	 }
	 private void exchangeNumbers(int i, int j) {
	        Employee temp = arrli.get(i);
	        arrli.set(i,arrli.get(j));
	        arrli.set(j, temp);
	    }
	 
	 
	 
	 public int Average_salary(){
		 int sum=0;
		 for(Employee temp:arrli) {
			 
			 sum+= temp.salary;
			 
		 }
		 
		 return sum/arrli.size();
		 
	 }
	 
	
	public Employee reward(int i){
		
		
		
			arrli.get(i).salary+=50;
			 Employee returned=arrli.get(i);
				
			
		return returned;
	}
	

	public Employee penality(int i){
		
		arrli.get(i).salary-=50;
		 Employee returned=arrli.get(i);
			
		
	return returned;
	}
	
	
}
