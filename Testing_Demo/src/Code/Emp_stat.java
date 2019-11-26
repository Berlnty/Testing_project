package Code;

import java.util.List;


/* This class calcualte standard dev of salaries of an employee */


public class Emp_stat {

	public static strictfp double populationStandardDeviation(List<Double> values) {
        double mean = mean(values);
        double n = values.size();
        double dv = 0;
        for (double d : values) {
            double dm = d - mean;
            dv += dm * dm;
        }
        return Math.sqrt(dv / n);
    }


    public static strictfp double mean(List<Double> values) {
        return sum(values) / values.size();
    }
    
    public static strictfp double sum(List<Double> values) {
        if (values == null || values.size() == 0) {
            throw new IllegalArgumentException("The data array either is null or does not contain any data.");
        }
        else {
            double sum = 0;
            for (int i = 0; i < values.size(); i++) {
                sum += values.get(i);
            }
            return sum;
        }
    }
	
	
}
