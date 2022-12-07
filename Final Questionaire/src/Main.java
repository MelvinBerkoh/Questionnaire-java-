import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        // question bank
        String[] questions = {" Do you trust people easily?",
        					  " Have you ever written a song for someone?",
                              " Have you ever judged someone for a secret that you have been told?",
                              " Do you ever pick your nose when you think nobody is watching?",
                              " Have you ever lied about having seen a movie?",
                              " Do you sing in the shower?",
                              " Would you betray a friend for a million dollars?",
                              " Do you consider yourself superior to others?",
                              " Do you speak more than one language?",
                              " Can you recite Pi to more than 10 digits?"};
        Poll election = new Election();
        // feeds in the questions into election.java
        for (String question: questions) 
        {
            election.addQuestion(new Prompt(question));
        }

        // gets the number of voters/users
        Scanner sc = new Scanner(System.in);
        
        boolean isMoreVoters = true;
        
        while (isMoreVoters) 
        {
	        System.out.println("For all of the following 10 questions please respond with either yes or"
	        		         + " no (Results will be shown at the end)\n");
	        //System.out.println("How many users are there? (please enter a numeric value)");
	        // polls the number of voters
	        election.poll(sc);
	
	        // display the results
	        System.out.println(election.generateResultsReport(false));
	        
	        System.out.println("Please enter yes/no if there are additional users");
	        
	        boolean loop = true;
	        while(loop) 
	        {
		        String response = sc.nextLine().toLowerCase();
	            if (response.equals("yes")) 
	            {
	                loop = false;
	            } else if (response.equals("no")) 
	            {
	                isMoreVoters = false;
	                loop = false;
	            } else 
	            {
	                System.out.println("Invalid response. Please enter yes or no.");
	            }
	        }
        }
        
        System.out.println(election.generateResultsReport(true));
    }


}
