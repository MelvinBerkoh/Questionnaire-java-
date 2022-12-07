// create questions interface and include all methods in Prompt.java
public interface Questions 
{
	public String showPrompt();
    public void addResult(boolean answer);
    public float[] calcResults();
}
