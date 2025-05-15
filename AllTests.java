package code;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Vector;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class AllTests {

	String dataDir = "C:\\Users\\rekit\\OneDrive\\Desktop\\Semester 4\\Data Structure and Algorithms\\assignment 2\\a2-sample-data\\data";

	@Test
	public void testSetGetAssignA() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;


		try {

			String fileBaseName = "sample1";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);

			g.setAssign(1, 5);

			assertEquals((Integer) 5, g.getAssign(1));

		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

	@Test
	public void testSetGetAssignB() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;


		try {

			String fileBaseName = "sample1";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);

			assertEquals(null, g.getAssign(3));
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

	@Test
	public void testIsAssignedA() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;


		try {

			String fileBaseName = "sample1";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);

			assertTrue(g.isAssigned(2));
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

	@Test
	public void testIsAssignedB() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;


		try {

			String fileBaseName = "sample1";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);

			assertFalse(g.isAssigned(1));
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

	@Test
	public void testIsNeighbourA() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;

		try {

			String fileBaseName = "sample1";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);

			assertTrue(g.isNeighbour(1, 2));
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

	@Test
	public void testIsNeighbourB() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;

		try {

			String fileBaseName = "sample1";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);

			assertFalse(g.isNeighbour(2, 3));
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

	@Test
	public void testGetNeighboursA() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;
		Integer[] ans = {1, 4};

		try {

			String fileBaseName = "sample1";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);

			Vector<Integer> neighbours = g.getNeighbours(2);
			Collections.sort(neighbours);

			assertArrayEquals(ans, neighbours.toArray());
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

	@Test
	public void testIsAssignedSameA() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;

		try {

			String fileBaseName = "sample1";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);

			assertFalse(g.isAssignedSame(2, 3));
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

	@Test
	public void testIsAssignedSameB() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;

		try {

			String fileBaseName = "sample1";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);
			
			g.setAssign(1, 5);

			assertFalse(g.isAssignedSame(1, 2));
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

	@Test
	public void testIsAssignedSameC() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;

		try {

			String fileBaseName = "sample1";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);
			
			g.setAssign(1, 1);

			assertTrue(g.isAssignedSame(1, 2));
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

	@Test
	public void testIsValidAssignA() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;

		try {

			String fileBaseName = "sample1";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);
			
			g.setAssign(1, 5);

			assertTrue(g.isValidAssign());
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

	@Test
	public void testIsValidAssignB() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;

		try {

			String fileBaseName = "sample1";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);
			
			g.setAssign(1, 1);

			assertFalse(g.isValidAssign());
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}
	
	@Test
	public void testIsValidAssignC() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;
		Integer[] assigns = {1, 1, 2, 3, 1, 2, 1, 3};

		try {

			String fileBaseName = "sample3";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);

			g.setAllAssigns(assigns);
			assertTrue(g.isValidAssign());
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

	@Test
	public void testIsValidAssignD() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;
		Integer[] assigns = {1, 1, 1, 3, 1, 2, 1, 3};

		try {

			String fileBaseName = "sample3";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);
			
			g.setAllAssigns(assigns);
			assertFalse(g.isValidAssign());
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

	@Test
	public void testNumDiffAssignsA() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;

		try {

			String fileBaseName = "sample1";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);
			
			g.setAssign(1, 5);
			assertEquals((Integer) 2, g.numDiffAssigns());
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

	@Test
	public void testNumDiffAssignsB() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;
		Integer[] assigns = {1, 1, 2, 3, 1, 2, 1, 3};

		try {

			String fileBaseName = "sample3";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);
			
			g.setAllAssigns(assigns);
			assertEquals((Integer) 3, g.numDiffAssigns());
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

	@Test
	public void testIsEveryCityAssignedA() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;

		try {

			String fileBaseName = "sample1";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);
			
			g.setAssign(1, 5);
			assertFalse(g.isEveryCityAssigned());
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

	@Test
	public void testIsEveryCityAssignedB() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;
		Integer[] assigns = {1, 1, 2, 3, 1, 2, 1, 3};

		try {

			String fileBaseName = "sample3";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);
			
			g.setAllAssigns(assigns);
			assertTrue(g.isEveryCityAssigned());
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

	@Test
	public void testGiveAnyAssignA() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;
		Integer[] cities = {3, 4};

		try {

			String fileBaseName = "sample1";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);
			
			g.setAssign(1, 5);
			g.giveAnyAssignment();
			assertTrue(!g.clashExists(cities) && g.isEveryCityAssigned());
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

	@Test
	public void testGiveAnyAssignB() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;
		Integer[] cities = {1, 2, 3, 4, 5, 6, 7, 8};

		try {

			String fileBaseName = "sample3";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);
			
			g.giveAnyAssignment();
			assertTrue(!g.clashExists(cities) && g.isEveryCityAssigned());
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

	@Test
	public void testExistsPathA() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;

		try {

			String fileBaseName = "sample4";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);
			
			assertTrue(g.existsPath(1, 3));
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

	@Test
	public void testExistsPathB() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;

		try {

			String fileBaseName = "sample4";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);
			
			assertFalse(g.existsPath(1, 6));
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

	@Test
	public void testAssignCityA() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;
		Integer[] cities = {1};

		try {

			String fileBaseName = "sample1";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);
			
			g.assignCity(1);
			
			assertTrue((g.isAssigned(1) && !g.clashExists(cities)));
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

	@Test
	public void testAssignCityLowestA() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;

		try {

			String fileBaseName = "sample1";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);
			
			g.assignCityLowest(1);
			
			assertTrue((g.isAssigned(1) && (g.getAssign(1) == 2)));
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

	@Test
	public void testGiveGreedyCityOrderingAssignmentA() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;
		Integer[] assigns = {1, 1, 2, 3, 1, 2, 1, 3};
		Boolean ans = Boolean.TRUE;

		try {

			String fileBaseName = "sample2";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);
			
			g.giveGreedyCityOrderingAssignment();
			for (int i = 0; i < assigns.length; i++) {
				ans = ans && (g.getAssign(i+1) == assigns[i]); 
			}
			assertTrue(ans);
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

	@Test
	public void testGiveGreedyRoadOrderingAssignmentA() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;
		Integer[] assigns = {1, 3, 3, 2, 1, 2};
		Boolean ans = Boolean.TRUE;

		try {

			String fileBaseName = "sample4";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);
			
			g.giveGreedyRoadOrderingAssignment();
			for (int i = 0; i < assigns.length; i++) {
				ans = ans && (g.getAssign(i+1) == assigns[i]); 
			}

			assertTrue(ans);
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}


	@Test
	public void testCanDoWithNSourcesA() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;

		try {

			String fileBaseName = "sample1";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);
			
			assertTrue(g.canDoWithNSources(3));
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

	@Test
	public void testCanDoWithNSourcesB() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;

		try {

			String fileBaseName = "sample1";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);
			
			assertFalse(g.canDoWithNSources(2));
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}
	
	@Test
	public void testCanDoWithNSourcesC() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;

		try {

			String fileBaseName = "sample2";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);
			
			assertTrue(g.canDoWithNSources(2));  // should be True
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

		@Test
		public void testCanFindBetterSolnA() {
			AssignControl g = new AssignControl();
			Vector<Road> rList;
			Vector<Assign> aList;
			Integer[] initAssigns = {2, 1, 3, 4};
			Integer[] cities = {1, 2, 3, 4};
			Integer initCount;
			
			try {

				String fileBaseName = "sample1";
				FileNames fNames = new FileNames(dataDir, fileBaseName);

				rList = g.readRoadsFromFile(fNames.getRoadFile());
				aList = g.readAssignsFromFile(fNames.getAssignFile());
				g.instantiateMap(rList, aList);
				
				g.setAllAssigns(initAssigns);
				initCount = g.numDiffAssigns();
				g.canFindBetterSoln();
				
				assertTrue((!g.clashExists(cities) && g.isEveryCityAssigned() && (g.numDiffAssigns() < initCount)));
			}
			catch (IOException e) {
				System.out.println("in exception: " + e);
			}
		}

	@Test
	public void testPathWithAssignA() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;
		Integer[] initAssigns = {1, 2, 2, 3};
		Integer[][] ans = {
				{2, 4, 3},
				{2, 1, 4, 3},
				{2, 4, 1, 3} 
		};
		Boolean match = Boolean.FALSE;
		Vector<Integer> chosenPath; 
		
		try {

			String fileBaseName = "sample1";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);
			
			g.setAllAssigns(initAssigns);
			chosenPath = g.pathWithAssign(2, 3, 3);
			for (Integer[] p : ans) { // check path has correctly assigned city
				if (Arrays.equals(chosenPath.toArray(), p)) {
					match = Boolean.TRUE;
					break;
				}
			}
			
			assertTrue(match);
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

	@Test
	public void testMakePathWithAssignA() {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;
		Integer[][] ans = {
				{2, 1, 3},
				{2, 1, 4, 3},
				{2, 4, 3},
				{2, 4, 1, 3} 
		};
		Integer[] cities = {1, 3, 4};
		Boolean match = Boolean.FALSE;
		Vector<Integer> chosenPath; 
		
		try {

			String fileBaseName = "sample1";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);
			
			chosenPath = g.makePathWithAssign(2, 3, 3);
			for (Integer[] p : ans) { // check path has correctly assigned city
				if (Arrays.equals(chosenPath.toArray(), p)) {
					match = Boolean.TRUE;
					break;
				}
			}
			
			assertTrue((match && !g.clashExists(cities) && g.isEveryCityAssigned()));
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
	}

}
