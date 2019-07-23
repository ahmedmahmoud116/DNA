package pkj;

public class SimplifiedMethods {
	
	public SimplifiedMethods() {
		
	}
	
	public String findSimpleGene(String dna) {
		String result = "";
		int start_index = dna.indexOf("ATG");
		if(start_index == -1) {
			return "";
		}
		int end_index = dna.indexOf("TAA",start_index+3);
		if(end_index == -1) {
			return "";
		}
		result = dna.substring(start_index,end_index+3);
		if(result.length() % 3 == 0)
			return result;
		else
			return "";
	}
	
	public void testSimpleGene() {
		String dna = "AAATGCCCTAACTAGATTAAGAAACC";
		System.out.println("Your gene is " + findSimpleGene(dna));
		
		dna = "AATGHTACTTT";
		System.out.println("Your gene is " + findSimpleGene(dna));
		
		dna = "TGGTCACCTCA";
		System.out.println("Your gene is " + findSimpleGene(dna));
		
		dna = "ATGACCTGACCTAA";
		System.out.println("Your gene is " + findSimpleGene(dna));
		
		dna = "GGTCTCACTGATGACCTGACCCTAATGA";
		System.out.println("Your gene is " + findSimpleGene(dna));
	}
}
