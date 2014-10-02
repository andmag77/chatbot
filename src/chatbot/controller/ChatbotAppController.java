package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotView;

/**
 * runs the chatbot project. owns the model and assocated views
 *
 * @author Michael Greenlief
 * @version 1.2 10/2/14 - cleaned the quit method.
 */
public class ChatbotAppController
{
	private ChatbotView applicationView;
	private Chatbot mySillyChatbot;
	private String startMessage;
	private String quitMessage;

	public ChatbotAppController()
	{
		applicationView = new ChatbotView(this);
		mySillyChatbot = new Chatbot(" John ");
		startMessage = "Welcome to the" + mySillyChatbot.getName() + " chatbot. what is your name?";
		quitMessage = "goodbye";
	}

	public Chatbot getMySillyChatbot()
	{
		return mySillyChatbot;
	}

	/**
	 * starts the chat
	 */
	void start()
	{
		String result = applicationView.showChatbotDialog(startMessage);
		/**
		 * loop
		 */
		while (!mySillyChatbot.quitChecker(result))
		{
			result = mySillyChatbot.processText(result);
			result = applicationView.showChatbotDialog(result);
		}

		quit();

	}

	/**
	 * kills the program
	 */
	private void quit()
	{
		applicationView.showChatbotMessage(quitMessage);
		System.exit(0);

	}

}
