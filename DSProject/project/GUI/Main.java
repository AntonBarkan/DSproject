package GUI;



import java.awt.Toolkit;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import PeerLogic.Peer;

import net.jxta.exception.PeerGroupException;



public class Main {
	private String name;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("what you name ?");
		if( name == null || name.isEmpty() )
		{
			System.exit(-1);
		}
		
		
		int port = 9000 + new Random().nextInt(100);
        
        Peer p  = new Peer(port , name );
        try {
			p.start();
		} catch (PeerGroupException|IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        p.getDiscovery().start();


		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.getContentPane().add(MainScrean.getInstance());
		frame.pack();
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.setVisible(true);
	}

}
