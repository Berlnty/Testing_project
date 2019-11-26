package Code;

public class Employee implements Comparable {
public int salary;
public String name;

Employee(int s,String n){
	salary=s;
	name =n;
};
public Employee(){};


@Override
public int compareTo(Object comp) {
int compare=((Employee)comp).salary;
	
	return this.salary-compare;
	
}

}
