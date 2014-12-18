/**
 * works
 * 
 * @OverAllVerson 1.5 works don't mess with it for now (as of 11/19/14)
 * @author mgre1690 11/19/14
 */
package chatbot.view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import chatbot.controller.ChatbotAppController;
import javax.swing.SwingConstants;
import javax.swing.*;

public class ChatbotPanel extends JPanel
{
	private ChatbotAppController baseController;
	private JButton firstButton;
	private JTextField firstTextField;
	private SpringLayout baseLayout;
	private JScrollPane chatPane;
	private JTextArea chatArea;

	public ChatbotPanel(ChatbotAppController baseController)
	{
		this.baseController = baseController;
		firstButton = new JButton("Only press if you are ready for the consaquences");
		firstTextField = new JTextField(12);
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextField, 1, SpringLayout.NORTH, firstButton);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 6, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstTextField, -6, SpringLayout.WEST, firstButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstButton, -70, SpringLayout.EAST, this);
		chatPane = new JScrollPane ();
		chatArea = new JTextArea();
		
		setupPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPane()

	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEditable(false);
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
		this.add(chatPane);
		chatArea = new JTextArea (5, 20);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, -183, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 46, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -7, SpringLayout.NORTH, firstTextField);
		this.add(chatArea);
	}

	private void setupLayout()
	{
	}

	private void setupListeners()
	{
		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String currentInput = firstTextField.getText();
				String result = baseController.getChatbotDialog(currentInput);
				showTextMessage(currentInput);
				showTextMessage(result);
				firstTextField.setText("");
				firstTextField.requestFocus();
			}
		});

	}
	
	public void showTextMessage(String userInput)
	{
		chatArea.append("\n" + userInput);		
	}
}
