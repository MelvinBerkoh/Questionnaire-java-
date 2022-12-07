import java.util.Scanner;
// create poll interface and include all methods in Election.java
public interface Poll 
{
	public void addQuestion(Questions question);
    public void poll(Scanner sc);
    public String generateResultsReport(boolean isFinal);
    
}
