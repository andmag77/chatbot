package chatbot.model;

public class Chatbot
{
	private String name;
	private int numberOfChats;

	public Chatbot(String name)
	{
		this.name = name;
		numberOfChats = 0;
	}

	public String getName()
	{
		return name;
	}

	public int getNumberOfChats()
	{
		return numberOfChats;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void incrementChats()
	{
		numberOfChats++;
	}

}
