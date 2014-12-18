package chatbot.model;

import java.util.ArrayList;

/**
 * 
 * 
 * @OverAllVerson 2.0 only some works... this part sucks
 * @author mgre1690 11/19/14
 */
public class Chatbot
{
	private ArrayList<String> memeList;
	private String name;
	private int numberOfChats;

	private chatbotUser myUser;

	private ArrayList<String> userInputList;

	public Chatbot(String name)
	{
		memeList = new ArrayList<String>();
		userInputList = new ArrayList<String>();
		this.name = name;
		numberOfChats = 0;
		myUser = new chatbotUser();

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
		memeList.add("derp");
		memeList.add("your mother");
	}

	/**
	 * processes in put from the user against the checker methods. returns the
	 * next output from the view
	 * 
	 * @param
	 * @return
	 * @author Michael Greenlief
	 */
	public String processText(String currentInput)
	{
		String result = "";
		if (chatCounter() < 5)
		{
			result = introduceUser(currentInput);
		}

		int randomPosition = (int) (Math.random() * 6);

		if (currentInput != null && currentInput.length() > 0)
		{
			result = randumChat(currentInput);
		}

		return result;
	}

	private String randumChat(String currentInput)
	{

		String result = "";

		// strongChecker hear
		if (numberOfChats == 0)
		{

		}
		// content checker hear
		else if (numberOfChats == 1)
		{
			if (stringLengthChecker(currentInput))
			{
				result = "way toooo long";
			}
			else
			{
				result = "way toooo short";
			}

		}
		else if (numberOfChats == 2)
		{
			if (memeChecker(currentInput))
			{
				result = "wow, " + currentInput + "is a meme wahoo!";
			}

			else
			{
				// Talk about the user
			}
		}
		else if (numberOfChats == 3)
		{

		}
		else if (numberOfChats == 4)
		{
			userInputList.add(currentInput);
		}
		else if (numberOfChats == 5)
		{
			if (mashChecker(currentInput))
			{
				result = massingDetected(currentInput);
			}
			else
			{
				result = noMashingDected(currentInput);
			}
		}
		else
		{
			if (userInputChecker(currentInput))
			{
				result = "that was nice - you removed it from the list";
			}
			else
			{

				result = "that wasn't in the conversation befor";
			}

		}

		return result;
	}

	private String massingDetected(String input)
	{
		String mashed = "";

		mashed = input.substring(input.length() / 2);
		mashed += input.substring(input.length() / 2);
		mashed += input.substring(input.length() / 2);
		mashed += input.substring(input.length() / 2);
		mashed += input.substring(input.length() / 2);
		mashed += input.substring(input.length() / 2);
		mashed += input.substring(input.length() / 2);
		mashed += input.substring(input.length() / 2);

		return mashed;
	}

	private String noMashingDected(String input)
	{
		String noMashing = " Thank you for not massing you don't know how good that makes me feel";
if(input.length() > 0)
{
		noMashing += input.substring(input.length() / 3, input.length() / 2);
}
		return noMashing;
	}

	/**
	 * checker for keyboard massing
	 * 
	 * @param userInput
	 *            the user supplys text
	 * @return whether massing has bin dectected
	 * 
	 */
	private boolean mashChecker(String userInput)
	{
		boolean isMashing = false;

		if (userInput.indexOf("asdf") > -1)
		{
			isMashing = true;
		}

		return isMashing;
	}

	private String introduceUser(String input)
	{
		String userQuestion = "";
		// you will need ifs or a switch
		if (chatCounter() == 0)
		{
			myUser.setUserName(input);
			userQuestion = "good name" + myUser.getUserName() + " how old are you?";

		}
		else if (numberOfChats == 1)
		{
			int userAge = Integer.parseInt(input);
			myUser.setAge(userAge);
		}
		// continue for other user info fields
		return userQuestion;
	}

	private boolean userInputChecker(String userInput)
	{
		boolean matchesInput = false;
		for (int loopCount = 0; loopCount < userInputList.size(); loopCount++)
		{
			if (userInput.equalsIgnoreCase(userInputList.get(loopCount)))
			{
				matchesInput = true;
				userInputList.remove(loopCount);
				loopCount--;
			}
		}

		return matchesInput;
	}

	// checks if input is too long or too short
	private boolean stringLengthChecker(String input)
	{
		boolean isTooLong = false;

		if (input.length() >= 20)
		{
			isTooLong = true;
		}

		return isTooLong;
	}

	// updates the number of inputs
	public int chatCounter()

	{
		numberOfChats++;
		return numberOfChats;
	}

	// checks if input is a meme
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

	// lets the program quit if input equals "quit"

	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;

		if (input != null && input.equals("132"))
		{
			okToQuit = true;
		}

		return okToQuit;
	}
}
