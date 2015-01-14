/**
 * works
 * 
 * @OverAllVerson 1.7 does not work but is better than before
 * @author mgre1690 1/14/15
 */
package chatbot.view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import chatbot.controller.ChatbotAppController;

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
		chatArea = new JTextArea();
		chatPane = new JScrollPane (chatArea);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 23, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 26, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatPane, 245, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatPane, 45, SpringLayout.EAST, firstButton);
		
		setupPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPane()

	{
		chatPane.setAutoscrolls(true);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEditable(false);
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(baseLayout);
		
		
	
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextField, 5, SpringLayout.NORTH, firstButton);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 6, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstTextField, -6, SpringLayout.WEST, firstButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstButton, -70, SpringLayout.EAST, this);

		
		this.add(firstButton);
		this.add(firstTextField);
		this.add(chatPane);
		
		
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 20, SpringLayout.SOUTH, chatPane);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 30, SpringLayout.EAST, chatPane);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -10, SpringLayout.NORTH, firstButton);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, 400, SpringLayout.WEST, this);
	
		//baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 27, SpringLayout.NORTH, this);
		//baseLayout.putConstraint(SpringLayout.WEST, chatArea, 0, SpringLayout.WEST, firstTextField);
		//baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -6, SpringLayout.NORTH, firstButton);
		//baseLayout.putConstraint(SpringLayout.EAST, chatArea, 351, SpringLayout.WEST, this);
		
		
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
		
		firstTextField.addKeyListener(new KeyListener()
		 {
		 @Override
			public void keyPressed(KeyEvent Key)
			{
				if (Key.getKeyCode() == KeyEvent.VK_ENTER)
				{
					//your code here
					String currentInput = firstTextField.getText();
					String result = baseController.getChatbotDialog(currentInput);
					showTextMessage(currentInput);
					showTextMessage(result);
					firstTextField.setText("");
					firstTextField.requestFocus();
				}

			}

			@Override
			public void keyReleased(KeyEvent arg0)
			{
			}

			@Override
			public void keyTyped(KeyEvent arg0)
			{
			}

		});


	}
	
	public void showTextMessage(String userInput)
	{
		chatArea.append("\n" + userInput);		
	}
}
