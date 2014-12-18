package chatbot.model;

public class chatbotUser
{
	private String userName;
	private int age;
	private boolean isAGoodPerson;
	private boolean needsGlasses;
	private double amountOfTriplesAchieved;
	private int numberOfEyes;

	public int getNumberOfEyes()
	{
		return numberOfEyes;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public boolean isAGoodPerson()
	{
		return isAGoodPerson;
	}

	public void setAGoodPerson(boolean isAGoodPerson)
	{
		this.isAGoodPerson = isAGoodPerson;
	}

	public boolean isNeedsGlasses()
	{
		return needsGlasses;
	}

	public void setNeedsGlasses(boolean needsGlasses)
	{
		this.needsGlasses = needsGlasses;
	}

}
