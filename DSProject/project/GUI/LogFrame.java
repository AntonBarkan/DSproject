package GUI;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JPanel;

public class LogFrame extends JFrame 
{
	private JTextArea textArea;
	private LogFrame()
	{
		
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		//getContentPane().add(textArea);
		
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.EAST);
		
		this.setVisible(true);
		
	}
	
	private static class Holder
	{
		private final static LogFrame instance = new LogFrame();
	}
	
	public static LogFrame getInstance()
	{
		return Holder.instance;
	}

	public synchronized void  toLog(String message) 
	{
		this.textArea.append( message + "\n" );
		
	}
}
