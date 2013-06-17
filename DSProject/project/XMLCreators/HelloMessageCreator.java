package XMLCreators;

public class HelloMessageCreator 
{
	public static String getMessage()
	{
		return "<?xml version=\"1.0\"?>"+
					"<message type=\"hello\">"+
						"<name>"+
							"First"+
						"</name>"+
						"<sites>"+
							"<site>"+
								"<name>"+
									"Firs site"+
								"</name>"+
								"<id>"+
									"1"+
								"</id>"+
							"</site>"+
						"</sites>"+
					"</message>";
	}
}
