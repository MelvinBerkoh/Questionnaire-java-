public class Prompt implements Questions 
{
	    // question
	    private String prompt;
	    //  responses: `{2, 1}` would be 2 no and 1 yes.
	    private int[] results = new int[2];

	    // constructor
	    public Prompt(String prompt)
	    {
	        this.prompt = prompt;
	    }

	    //  getter method
	    public String showPrompt() 
	    {
	        return this.prompt;
	    }

	    // if true, increments the "yes" count. if false, increments the "no" count.
	    public void addResult(boolean answer)
	    {
	        if (answer) 
	        {
	            this.results[1]++;
	        } else 
	        {
	            this.results[0]++;
	        }
	    }

	    // gives the percentages. if `results` is `{2, 1}` then this outputs 
	    //`float[] {0.66666667, 0.33333333}`.
	    public float[] calcResults() 
	    {
	        int totalVotes = this.results[0] + this.results[1];
	        // `(float)` is necessary because otherwise Java will do integer division.
	        //i don't want to get `float[] {0.00, 0.00}`, so float division is a must.
	        return new float[] {(float) this.results[0] / totalVotes, (float)this.results[1] / totalVotes};
	    }
	}

