import java.io.*;
import java.util.*;
import java.util.regex.*;

public class UnLinker
{	
	public final String prefix1 = "http://";
	public final String prefix2 = "www";
	public final String prefix3 = "http://www";
	public final String postfix1 = "com";
	public final String postfix2 = "edu";
	public final String postfix3 = "org";
	public final String postfix4 = "info";
	public final String postfix5 = "tv";
	public final String check = "OMIT";
	public int num_OMIT = 0;
	String clean(String text) {
		String myregex = "("+prefix1+"|" + prefix2 + "\\.|" +prefix3 +"\\.)(\\w+|\\.?)*\\.(" +postfix1+"|"+postfix2+"|"+postfix3+"|"+postfix4+"|"+postfix5+")";
		int count = 0;
		Pattern regex_p = Pattern.compile(myregex);
		Matcher regex_m = regex_p.matcher(text); 
		StringBuffer mystring = new StringBuffer();
        	while (regex_m.find()) {
		  	count++;
			num_OMIT = count;
                  	regex_m.appendReplacement(mystring, check+num_OMIT);
        	}
        	regex_m.appendTail(mystring);
			String omitans = mystring.toString();
        	return omitans;
	}
	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(new File("UnLinker.in"));
		String text;
		UnLinker ul = new UnLinker();
		while (in.hasNextLine())
		{
			text = in.nextLine();
			System.out.println(ul.clean(text));
		}
		in.close();
	}
}
