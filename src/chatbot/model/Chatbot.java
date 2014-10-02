package chatbot.model;

import java.util.ArrayList;

public class Chatbot
{
	private ArrayList<String> memeList;
	private String name;
	private int numberOfChats;

	public Chatbot(String name)
	{
		memeList = new ArrayList<String>();
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

	private void fillThememeList()
	{
		memeList.add("kitties");
		memeList.add("one does not simply");
		memeList.add("Ive go 99 probloms");
		memeList.add("y u no");
		memeList.add("doge");
		// + 2
	}

	/**
	 * processes in put from the user aginst the checker methods. returns the
	 * next output from the view
	 * 
	 * @param
	 * @return
	 * @author Michael Greenlief
	 */
	public String processText(String currentInput)
	{
		String result = "";

		if (memeChecker(currentInput))
		{
			result = "wow, " + currentInput + "is a meme wahoo!";
		}

		else
		{
			result = "not a meme, try again";
		}
		return result;
	}

	private void updateChatCounter()
	{
		numberOfChats++;
	}

	private boolean memeChecker(String input)
	{
		boolean isAMeme = false;
		for (String currentMeme : memeList)
		{
			if (input.equalsIgnoreCase(currentMeme))
			{
				isAMeme = true;
			}
		}
		for (int loopCounter = 0; loopCounter < memeList.size(); loopCounter++)
		{
			if (input.equalsIgnoreCase(memeList.get(loopCounter)))
			{
				isAMeme = true;
			}
		}
		return isAMeme;
	}

	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;

		if (input != null && input.equals("sudo quit"))
		{
			okToQuit = true;
		}

		return okToQuit;
	}
}