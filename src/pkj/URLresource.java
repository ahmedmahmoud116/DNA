package pkj;
import java.io.IOException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class URLresource {

	public URLresource(){	
	}
	
	public void URLFind(String url) throws IOException {
		URL Url = new URL(url);
		BufferedReader br = new BufferedReader(new InputStreamReader(Url.openStream()));
		
		String line;
		String result;
		while((line = br.readLine()) != null)
		{
		int test = line.toLowerCase().indexOf("youtube");
		if(test != -1)
		{
//			System.out.println(test);
//			int beg = line.lastIndexOf("\"");
//			int end = line.indexOf("\"", test+1);
//			System.out.println(beg + " " + end);
//			System.out.println(line.substring(beg+1,end));
			int test1 = line.indexOf("\"");
			int test2 = line.lastIndexOf("\"");
			int test3 = line.indexOf("http");
			
			if(test1 != -1 && test2 !=-1)
			{
				if(test1 != (test3-1))
				{
					test1 = test3-1;
				}
				result = line.substring(test1+1,test2);
				System.out.println(result);
			}	
		}
	}
  }
}
