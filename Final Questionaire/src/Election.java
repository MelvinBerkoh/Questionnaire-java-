import java.lang.Math;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Election implements Poll
{	  //  list of questions to ask in the poll/election
    private List<Questions> questions = new ArrayList<>();   
    // added so that i can keep adding new users to the poll 
    private int numVoters;
    public Election()
    {
    	numVoters = 0;	
    }
    // adds a question to the questions list
    public void addQuestion(Questions question)
    {
        this.questions.add(question);
    }

    // asks the questions to numberOfRespondents number of people
    public void poll(Scanner sc) 
    {
    	numVoters++;
    	for (int i = 0; i < this.questions.size(); i++) 
    	{ //the question  asked
            Questions question = this.questions.get(i);    
         // ask question
            System.out.println("Question # " + (i + 1) + ": " + question.showPrompt());    

       /** for (int i = 0; i < this.questions.size(); i++) 
        {	// the question we're going to ask.
            Questions question = this.questions.get(i);
            // ask question
            System.out.println("Question # " + (i + 1) + ": " + question.showPrompt());
            // get the responses
            for (int j = 1; j <= numberOfRespondents; j++) 
            {
                // if 'yes', adds 'yes' response to question. if 'no', adds 'no' response to question.
            	// else, says "invalid response" and asks for input again.
                while (true) 
                {
                    System.out.println("Voter " + j + "? ");
                    String response = sc.nextLine();
                    if (response.equals("yes")) 
                    {
                        question.addResult(true);
                    } else if (response.equals("no")) 
                    {
                        question.addResult(false);
                    } else 
                    {
                        System.out.println("invalid response. please enter 'yes' or 'no'.");
                        // continue skips the break, and the break exits the loop.
                        //continue makes the loop go on and on.
                        continue;  // remove this make it into a boolean
                    }
                          break;
                 }
            }
        }**/
            //for (int j = 1; j <= numberOfRespondents; j++)
            //{
                // if 'yes', adds 'yes' response to question. if 'no', adds 'no' response to question. 
            	//else, "invalid response" and asks for input again.
                boolean loop = true;
                while (loop) 
                {
                    System.out.println("User" + numVoters + ": ");
                    // in case user uses CAPS 
                    String response = sc.nextLine().toLowerCase();
                    if (response.equals("yes")) 
                    {
                        question.addResult(true);
                        loop = false;
                    } else if (response.equals("no")) 
                    {
                        question.addResult(false);
                        loop = false;
                    } else 
                    {
                        System.out.println("Invalid response. Please enter yes or no.");
                    }
                }
            //}
        }
    }
    public String generateResultsReport(boolean isFinal) 
    {
    	String report;
    	
        if(!isFinal)
        	report = " Poll Results:\n";
        else 
        	report = " The Election is now over!\n Final Results:\n";
        // goes through each question. gives the question and its voting result.
        //the results are rounded to whole number percentages.
        for (int i = 0; i < this.questions.size(); i++)
        {
            Questions question = this.questions.get(i);
            report += "For Question # " + (i + 1) + " : " + question.showPrompt() + "\n";
            float[] results = question.calcResults();
            report += Math.round(results[1] * 100) + "% voted Yes." + "\n";
            report += Math.round(results[0] * 100) + "% voted No." + "\n";
        }
        return report;
    }
}
    
    
    
    
    
