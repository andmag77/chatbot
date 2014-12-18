package chatbot.view;

import javax.swing.JOptionPane;

import chatbot.controller.ChatbotAppController;

public class ChatbotView
{

	private ChatbotAppController baseController;

	public ChatbotView(ChatbotAppController baseController)
	{
		this.baseController = baseController;
	}

	/**
	 * show a string from the chatbot with the availability of user input.
	 * 
	 * @param currentInput
	 *            the supplied string.
	 * @return The users typed response.
	 */
	public String showChatbotDialog(String currentInput)
	{
		String result = "";

		/**
		 * shows a String from the Chatbot as a popup window.
		 *
		 * @param
		 */
		result = JOptionPane.showInputDialog(null, baseController.getMySillyChatbot().getName() + "say" + currentInput);

		return result;
	}

	public void showChatbotMessage(String currentInput)
	{
		JOptionPane.showMessageDialog(null, baseController.getMySillyChatbot().getName() + " says " + currentInput);
	}

}
