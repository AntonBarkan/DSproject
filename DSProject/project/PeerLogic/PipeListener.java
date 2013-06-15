package PeerLogic;

import XMLReaders.SitePageReader;
import GUI.LogFrame;
import GUI.MainScrean;
import net.jxta.endpoint.Message;
import net.jxta.pipe.PipeMsgEvent;
import net.jxta.pipe.PipeMsgListener;

public class PipeListener implements PipeMsgListener {

	private Peer peer;

	public PipeListener(Peer peer)
	{
		this.peer = peer;
	}

	public void pipeMsgEvent(PipeMsgEvent event)
	{
        // Someone is sending us a message!
        try 
        {
            Message msg = event.getMessage();
            byte[] msgBytes = msg.getMessageElement("Msg").getBytes(true);  
            byte[] fromBytes = msg.getMessageElement("From").getBytes(true); 
            String from = new String(fromBytes);
            String message = new String(msgBytes);
            
//            if( !message.startsWith("Resived by") )
//            {
//            	this.peer.send_to_peer("Resived by " + this.peer.getName() , msg.getMessageElement("From").toString());
//            }
            SitePageReader r = new SitePageReader();
            message = r.read(message);
            MainScrean.getInstance().openPage(message);
            LogFrame.getInstance().toLog(message);
        }
        catch (Exception e) {
            // You will notice that JXTA is not very specific with exceptions...
            e.printStackTrace();
        }
    }

}