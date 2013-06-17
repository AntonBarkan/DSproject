package GUI;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.util.LinkedList;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class MainScrean extends JPanel{
	
	private JTabbedPane tabbedPane;
	private JTree tree;
	
	private MainScrean() {
		setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		add(splitPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		splitPane.setRightComponent(tabbedPane);
		
		tree = new JTree();
		splitPane.setLeftComponent(tree);
	}
	
	private static class Holder
	{
		private static final MainScrean instance = new MainScrean();
	}
	
	public static MainScrean getInstance()
	{
		return Holder.instance;
	}
	

	public synchronized void openPage(String html) 
	{
		JEditorPane pane = new JEditorPane("text/html",html);
		pane.setEditable(false);
		this.tabbedPane.add(pane);
	}


	public synchronized void addToTree(String peerName , LinkedList<Object[]>  sites) 
	{
		DefaultMutableTreeNode top =   new DefaultMutableTreeNode( peerName );
		((DefaultMutableTreeNode)this.tree.getModel().getRoot()).add(top);
		((DefaultTreeModel)this.tree.getModel()).reload();
		
	}
	
	
	
}
