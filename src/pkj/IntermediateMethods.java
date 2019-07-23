package pkj;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import java.io.BufferedReader;

public class IntermediateMethods extends SimplifiedMethods{
	
	public IntermediateMethods() {	
	}
	
	public String findSimpleGene(String dna,String startCodon ,String endCodon) {
		String result = "";
		int start_index = dna.indexOf(startCodon);
		if(start_index == -1) {
			return "";
		}
		int end_index = dna.indexOf(endCodon,start_index+3);
		if(end_index == -1) {
			return "";
		}
		result = dna.substring(start_index,end_index+3);
		if(result.length() % 3 == 0)
		{
			return result;
		}
		else
			return "";
	}
	
	public void testSimpleGene() {
		String dna = "TGCGGTCACTAA";
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
	
	public int findStopCodon(String dna,int start_index,String stopCodon) {
		String result = "";
		int end_index = dna.indexOf(stopCodon,start_index+3);
		while(end_index != -1) {
			
		result = dna.substring(start_index,end_index+3);

		if(result.length() % 3 == 0)
		{
			return end_index;
		}
		end_index = dna.indexOf(stopCodon,end_index+3);
		}
		return -1;
		
	}
	
	public void testFindStopCodon() {
		String Dna = "ATGACCCCTTAGTAATGA";
		int start_index = Dna.indexOf("ATG");
		if(start_index != -1)
		 {
			int TAG_index = findStopCodon(Dna, start_index, "TAG");
			int TGA_index = findStopCodon(Dna, start_index, "TGA");
			int TAA_index = findStopCodon(Dna, start_index, "TAA");
		
			System.out.println("TAG index is "+ TAG_index);
			System.out.println("TAA index is "+ TAA_index);
			System.out.println("TGA index is "+ TGA_index);
		 }
		else
			System.out.println("we couldn't find any gene");
	}
	
	public String findGene(String dna) {
		int start_index;
		if(dna.equals(dna.toUpperCase()))
			start_index = dna.indexOf("ATG");
		else
			start_index = dna.indexOf("atg");
		
		if(start_index == -1)
		{
			return "";
		}
		
		int TAG_index;
		int TGA_index;
		int TAA_index;
		
		if(dna.equals(dna.toUpperCase())) {
			TAG_index = findStopCodon(dna, start_index, "TAG");
		 	TGA_index = findStopCodon(dna, start_index, "TGA");
		 	TAA_index = findStopCodon(dna, start_index, "TAA");
		}
		else {
			TAG_index = findStopCodon(dna, start_index, "tag");
		 	TGA_index = findStopCodon(dna, start_index, "tga");
		 	TAA_index = findStopCodon(dna, start_index, "taa");
		}
		int min_index;
		if(TAG_index == -1 || (TGA_index != -1 && TGA_index < TAG_index))
			min_index = TGA_index;
		else
			min_index = TAG_index;
		if(TAA_index == -1 || (min_index != -1 && min_index < TAA_index))
			min_index = min_index;
		else
			min_index = TAA_index;
		if(min_index == -1)
			return "";
		return dna.substring(start_index,min_index + 3);
	}
	
	public void testFindGene() {
		String dna = "atgcctattggatccaaagagaggccaacattttttgaaatttttaagacacgctgcaacaaagcagatttaggaccaataagtcttaattggtttgaagaactttcttcagaagctccaccctataattctgaacctgcagaagaatctgaacataaaaacaacaattacgaaccaaacctatttaaaactccacaaaggaaaccatcttataatcagctggcttcaactccaataatattcaaagagcaagggctgactctgccgctgtaccaatctcctgtaaaagaattagataaattcaaattagacttaggaaggaatgttcccaatagtagacataaaagtcttcgcacagtgaaaactaaaatggatcaagcagatgatgtttcctgtccacttctaaattcttgtcttagtgaaagtcctgttgttctacaatgtacacatgtaacaccacaaagagataagtcagtggtatgtgggagtttgtttcatacaccaaagtttgtgaagggtcgtcagacaccaaaacatatttctgaaagtctaggagctgaggtggatcctgatatgtcttggtcaagttctttagctacaccacccacccttagttctactgtgctcatagtcagaaatgaagaagcatctgaaactgtatttcctcatgatactactgctaatgtgaaaagctatttttccaatcatgatgaaagtctgaagaaaaatgatagatttatcgcttctgtgacagacagtgaaaacacaaatcaaagagaagctgcaagtcatggatttggaaaaacatcagggaattcatttaaagtaaatagctgcaaagaccacattggaaagtcaatgccaaatgtcctagaagatgaagtatatgaaacagttgtagatacctctgaagaagatagtttttcattatgtttttctaaatgtagaacaaaaaatctacaaaaagtaagaactagcaagactaggaaaaaaattttccatgaagcaaacgctgatgaatgtgaaaaatctaaaaaccaagtgaaagaaaaatactcatttgtatctgaagtggaaccaaatgatactgatccattagattcaaatgtagcaaatcagaagccctttgagagtggaagtgacaaaatctccaaggaagttgtaccgtctttggcctgtgaatggtctcaactaaccctttcaggtctaaatggagcccagatggagaaaatacccctattgcatatttcttcatgtgaccaaaatatttcagaaaaagacctattagacacagagaacaaaagaaagaaagattttcttacttcagagaattctttgccacgtatttctagcctaccaaaatcagagaagccattaaatgaggaaacagtggtaaataagagagatgaagagcagcatcttgaatctcatacagactgcattcttgcagtaaagcaggcaatatctggaacttctccagtggcttcttcatttcagggtatcaaaaagtctatattcagaataagagaatcacctaaagagactttcaatgcaagtttttcaggtcatatgactgatccaaactttaaaaaagaaactgaagcctctgaaagtggactggaaatacatactgtttgctcacagaaggaggactccttatgtccaaatttaattgataatggaagctggccagccaccaccacacagaattctgtagctttgaagaatgcaggtttaatatccactttgaaaaagaaaacaaataagtttatttatgctatacatgatgaaacatcttataaaggaaaaaaaataccgaaagaccaaaaatcagaactaattaactgttcagcccagtttgaagcaaatgcttttgaagcaccacttacatttgcaaatgctgattcaggtttattgcattcttctgtgaaaagaagctgttcacagaatgattctgaagaaccaactttgtccttaactagctcttttgggacaattctgaggaaatgttctagaaatgaaacatgttctaataatacagtaatctctcaggatcttgattataaagaagcaaaatgtaat";
		System.out.println("Your dna is " + dna);
		System.out.println("your gene is " + findGene(dna));

		
//		dna = "AATGCCTGCTCTGTAA";
//		System.out.println("Your dna is " + dna);
//		System.out.println("your gene is " + findGene(dna));
//		
//		dna = "ATGACCCCTTAGTAATGA";
//		System.out.println("Your dna is " + dna);
//		System.out.println("your gene is " + findGene(dna));
//		
//		dna = "ATGACCTCGTGC";
//		System.out.println("Your dna is " + dna);
//		System.out.println("your gene is " + findGene(dna));
//		
//		dna = "ATGTCCTGTACTACTTAATCCATGtcctacctactgtga";
//		printAllGenes(dna.toUpperCase());
	}
	
	public void printAllGenes(String dna) {
		System.out.println("Your dna is " + dna);
		String result;
		while(true) {
			result = findGene(dna);
			if(result.isEmpty()) {
				System.out.println("There is no gene left");
				break;
			}
			System.out.println("Your gene is "+ result);
			dna = dna.substring(dna.indexOf(result) + result.length());
		}
	}
	
	public int countGenes(String dna) {
		
		String result;
		for(int i = 0 ;; i++){
			result = findGene(dna);
			if(result.isEmpty()) {
				return i;
			}
			dna = dna.substring(dna.indexOf(result) + result.length());
		}
	}
	
	public void testCountGenes() {
		
		String dna = "ATGTAAGATGCCCTAGT";
		System.out.println("there are " + countGenes(dna) + " in dna " + dna);
		
		dna = "TCCTGAATGTAATCC";
		System.out.println("there are " + countGenes(dna) + " in dna " + dna);
		
		dna="TCCTGCTACGACCTG";
		System.out.println("there are " + countGenes(dna) + " in dna " + dna);
	}
	
	public ArrayList<String> getAllGenes(String dna){
		ArrayList<String> al = new ArrayList<>();
		String result;
		while(true) {
			result = findGene(dna);
			if(result.isEmpty()) {
				break;
			}
			al.add(result);
			dna = dna.substring(dna.indexOf(result) + result.length());
		}
		return al;
	}
	
	public void testGetAllGenes() {
		String dna = "ATGTAAGATGCCCTAGT";
//		dna="atgtaagatgccctagt";
		
		ArrayList<String> al = getAllGenes(dna);
		Iterable<String> it = al;
		for(String s: it) {
			System.out.println(s);
		}
	}
	
	public float cgRatio(String dna) {
		int count = 0;
		for(int i=0;i<dna.length();i++) {
			if(dna.charAt(i) == 'C' || dna.charAt(i) == 'c' || dna.charAt(i) == 'G' || dna.charAt(i) == 'g') {
				count++;
			}	
		}
		return (float)count/dna.length();
	}
	
	public void testcgRatio() {
		String dna = "ATGTAAGATGCCCTAGT";
		System.out.println("CG Ratio: " + cgRatio(dna));
	}
	
	public void processGenes(ArrayList<String> al) {
		Iterable<String> it = al;
		int count = 0;
		float cgratio;
		int max = 0;
		
		System.out.println("Genes that are longer than 60 characters is: ");
		for(String s: it) {
			if(s.length()> 60) {
				System.out.println(s);
				count++;
			}
			if(max<s.length())
				max = s.length();
		}
		System.out.println("There Number is: " + count);
		
		count=0;
		System.out.println("Genes that has cg Ratio higher than 0.35 is: ");
		for(String s:it) {
			cgratio = cgRatio(s);
			if(cgratio > 0.35) {
				System.out.println(s);
				count++;
			}
		}
		System.out.println("There Number is " + count);
		
		System.out.println("The length of the longest gene is: " + max);
	}
	
	public void testProcessGenes() throws IOException {
		FileReader fr = new FileReader("C:\\Users\\lenovo\\Documents\\Downloads\\Compressed\\Java1\\Week2\\dna\\GRch38dnapart.fa");
		BufferedReader br = new BufferedReader(fr,8*1024);
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = br.readLine()) != null) {
			sb.append(line);
		}
		
		ArrayList<String> al = getAllGenes(sb.toString());
		System.out.println("Number of genes: " + al.size());
		processGenes(al);
		String codon = "CTG";
		System.out.println("count of " + codon + " in dna is: " + searchForCodon(sb.toString(), codon));
		br.close();
		fr.close();
	}
	
	public int searchForCodon(String dna,String codon) {
		int count = 0;
		int test = dna.indexOf(codon);
		while(test!=-1)
		{
			count++;
			test = dna.indexOf(codon,test+1);
		}
		return count;
	}
	
	public void testsearch() {
		String dna = "ATGCTGATGATGATG";
		String codon = "ATG"; 
		System.out.println("count of " + codon + " in dna is: " + searchForCodon(dna, codon));
	}

}
