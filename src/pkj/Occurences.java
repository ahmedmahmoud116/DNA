package pkj;

public class Occurences {
	
	public Occurences() {
	}
	
	public boolean twoOccurrences(String stringa,String stringb) {
		int firstind = stringb.indexOf(stringa);
		if(firstind == -1) {
			return false;
		}
		int secondind =  stringb.indexOf(stringa,firstind + stringa.length());
		if (secondind == -1)
			return false;
		return true;
	}
	
	public void testing() {
		System.out.println(twoOccurrences("a", "banana"));
		
		System.out.println(twoOccurrences("by", "A Stroy by Abby long"));
		
		System.out.println(twoOccurrences("atg", "ctgtatgta"));
		
		System.out.println("The part of the string after" + "an" + " in " + "banana" + " is " + lastPart("an", "banana"));
		
		System.out.println("The part of the string after" + "zoo" + " in " + "forest" + " is " + lastPart("zoo", "forest"));
		
		
	}
	
	public String lastPart(String stringa ,String stringb) {
		int test = stringb.indexOf(stringa);
		if(test == -1)
			return stringb;
		
		return stringb.substring(test + stringa.length());
	}
	
	public int howMany(String stringa, String stringb) {
		for(int i = 0;;i++) {
			int test = stringb.indexOf(stringa);
			if(test == -1)
			{
				return i;
			}
			stringb = stringb.substring(stringb.indexOf(stringa) + stringa.length());
		}
	}
	
	public void testHowMany() {
		System.out.println("the string " + "GAA" + " is occurence " + howMany("GAA", "ATGAACGAATTGAATC") + " times in String " + 
				"ATGAACGAATTGAATC" );
		System.out.println("the string " + "GAA" + " is occurence " + 
				howMany("GAA", "DOGASD") + " times in String " + "DOGASD" );
	}
}
