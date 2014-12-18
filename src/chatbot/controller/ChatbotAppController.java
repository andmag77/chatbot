package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotFrame;
import chatbot.view.ChatbotView;
import chatbot.controller.*;
import chatbot.model.*;
import chatbot.view.*;
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
	private ChatbotFrame appFrame;

	public ChatbotAppController()
	{
		applicationView = new ChatbotView(this);
		appFrame = new ChatbotFrame(this);
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
	public void start()
	{
		((ChatbotPanel) appFrame.getContentPane()).showTextMessage(startMessage);

		// String result = applicationView.showChatbotDialog(startMessage);
		// testPanel.showTextMessage(startMessage);

	}
//checks to see if quit has bin calles
	public String getChatbotDialog(String input)
	{
		String result = "";
		if (mySillyChatbot.quitChecker(input))
		{
			quit();
		}
		result = mySillyChatbot.processText(input);

		return result;
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
