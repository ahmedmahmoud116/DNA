package pkj;

import java.io.IOException;
import java.util.ArrayList;

public class TestMain {

	public static void main(String[] args) throws IOException {
//		SimplifiedMethods sim = new SimplifiedMethods();
		IntermediateMethods intr = new IntermediateMethods();
//		sim.testSimpleGene();
		Occurences oc = new Occurences();
//		oc.testing();
//		oc.testHowMany();
//		intr.testCountGenes();
//		intr.testFindGene();
//		new URLresource().URLFind("http://www.dukelearntoprogram.com/course2/data/manylinks.html");

//		intr.testFindStopCodon();
//		intr.testCountGenes();
//		intr.testGetAllGenes();
//		intr.testcgRatio();
//		String dna = "atgcctattggatccaaagagaggccaacattttttgaaattttttaa";
//		ArrayList<String> al = intr.getAllGenes(dna);
//		intr.processGenes(al);
		intr.testProcessGenes();
//		intr.testsearch();
	}

}
