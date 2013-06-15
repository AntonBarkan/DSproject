package PeerLogic;

import java.io.IOException;

import net.jxta.discovery.DiscoveryEvent;
import net.jxta.discovery.DiscoveryListener;
import net.jxta.discovery.DiscoveryService;
import net.jxta.peergroup.PeerGroup;
import net.jxta.protocol.ModuleSpecAdvertisement;

public class Discovery extends Thread {

	private DiscoveryService discovery;
	private Peer peer;

	public Discovery(PeerGroup subgroup, Peer peer){
		this.discovery = subgroup.getDiscoveryService();
		this.discovery = subgroup.getDiscoveryService();
		this.peer = peer;
		this.discovery.addDiscoveryListener(new DiscoveryListener() {

			public void discoveryEvent(DiscoveryEvent event) {
				// Found another peer! Let's say hello shall we!
		        // Reformatting to create a real peer id string
		        String found_peer_id = "urn:jxta:" + event.getSource().toString().substring(7);
		        Discovery.this.peer.send_to_peer(Discovery.this.xml , found_peer_id);

			}
		});
	}

	public void publish(ModuleSpecAdvertisement mdadv)
	{
		try {
			this.discovery.publish(mdadv);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.discovery.remotePublish(mdadv);
	}

	public void run() {
		while(true) {
			System.out.println("in run");
			discovery.getRemoteAdvertisements(null, DiscoveryService.ADV, "Name", "HELLO", 1, null);
			try {
				sleep(10000);

			}
			catch(InterruptedException e) {} 
		}
	}

	String xml = "<?xml version=\"1.0\"?>"+
			"<message type=\"sitePage\">" +
		"<site id=\"1\" modified=\"17:50 12/06/2013\" >"+
			"<page id=\"1\" modified=\"17:50 12/06/2013\">"+
				"<![CDATA["+
				"<!DOCTYPE html>"+
				"<html>"+
				"<body>"+
				"<h1>My First Sendet Page</h1>"+
				"</body>"+
				"</html>"+
				"]]>"+
			"</page>"+
		"</site>"+
			"</message>";

}