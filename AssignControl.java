package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.File;

public class AssignControl {


	// PROVIDED DATA
	
	TreeMap<Integer, Boolean> assignedTroopSource;
	private Map<Integer, Integer> cityAssignments; // city -> nation
	private Map<Integer, Set<Integer>> adjacencyList; // city -> set of neighbours

	// PROVIDED CODE
	
	public Vector<Road> readRoadsFromFile(File f) throws IOException {
		// Reads list of edges from a file, one pair of integers per line 
		BufferedReader fIn = new BufferedReader(
							 new FileReader(f));
		String s;
		Vector<Road> rList = new Vector<Road>();
		Integer x, y;
		
		while ((s = fIn.readLine()) != null) {
			java.util.StringTokenizer line = new java.util.StringTokenizer(s);
			while (line.hasMoreTokens()) {
				x = Integer.parseInt(line.nextToken());
				y = Integer.parseInt(line.nextToken());
				rList.add(new Road(x,y));
			}
		}
		fIn.close();
		
		return rList;
	}

	public Vector<Assign> readAssignsFromFile(File f) throws IOException {
		// Reads list of edges from a file, one pair of integers per line 
		BufferedReader fIn = new BufferedReader(
							 new FileReader(f));
		String s;
		Vector<Assign> rList = new Vector<Assign>();
		Integer x, y;
		
		while ((s = fIn.readLine()) != null) {
			java.util.StringTokenizer line = new java.util.StringTokenizer(s);
			while (line.hasMoreTokens()) {
				x = Integer.parseInt(line.nextToken());
				y = Integer.parseInt(line.nextToken());
				rList.add(new Assign(x,y));
			}
		}
		fIn.close();
		
		return rList;
	}

	public Boolean clashExists(Integer[] cities) {
		// PRE: cities is an array of existing cities
		// POST: Returns True if any assignments at cities clash,
		//         False otherwise
		
		Vector<Integer> neighbours;
		for (Integer c: cities) {
			neighbours = this.getNeighbours(c);
			for (Integer n: neighbours) {
				if (this.isAssigned(c) &&
						this.isAssigned(n) &&
						this.getAssign(c) == this.getAssign(n))
					return Boolean.TRUE;
			}
		}
		
		return Boolean.FALSE;
	}

	public Integer countAssignedTroopSource(Integer[] cities) {
		// PRE: cities is an array of existing cities
		// POST: Returns the count of nations with troops assigned

		assignedTroopSource.clear();
		
		for (Integer c: cities) {
			if (this.getAssign(c) != null)
				assignedTroopSource.put(this.getAssign(c), Boolean.TRUE);
		}
		
		return this.assignedTroopSource.size();
	}
	
	public void setAllAssigns(Integer[] assigns) {
		// PRE: assigns has length N, where N is number of cities
		// POST: Sets troop assignment for city i to assigns[i-1]
		
		for (int i = 0; i < assigns.length; i++)
			this.setAssign(i+1, assigns[i]);
		
		// NOTE: This will obviously only work as intended once setAssign() is implemented.
	}
	

	// PASS
	
	public AssignControl() {
		// Constructor
		
		// TODO: Add other initialisation
		assignedTroopSource = new TreeMap<>();
		cityAssignments = new HashMap<>();
		adjacencyList = new HashMap<>();
		
		assignedTroopSource = new TreeMap<Integer, Boolean>();
	}

	public void instantiateMap(Vector<Road> roads, Vector<Assign> assigns) {
		// PRE: -
		// POST: New Mordor configuration is set up, including initial assignments
		
		// TODO
		for (Road r : roads) {
			Integer c1 = r.getCity1();
			Integer c2 = r.getCity2();

			adjacencyList.computeIfAbsent(c1, k -> new HashSet<>()).add(c2);
			adjacencyList.computeIfAbsent(c2, k -> new HashSet<>()).add(c1);

			// Ensure both cities are initialized in the assignment map
			cityAssignments.putIfAbsent(c1, null);
			cityAssignments.putIfAbsent(c2, null);
		}

		// Apply the initial troop assignments
		for (Assign a : assigns) {
			Integer city = a.getCity();
			Integer nation = a.getAssign();
			cityAssignments.put(city, nation);
		}
	
	}

	public void setAssign(Integer city, Integer nation) {
		// PRE: city exists
		// POST: city is assigned troops from nation assign

		// TODO
		cityAssignments.put(city, nation);
	}
	
	public Integer getAssign(Integer city) {
		// PRE: city exists
		// POST: Returns nation that city is assigned troops from,
		//         null if none

		// TODO
		return cityAssignments.get(city);
	}
	
	public Boolean isAssigned(Integer city) {
		// PRE: city exists
		// POST: Returns True if city has been assigned troops, false otherwise

		// TODO
		return cityAssignments.containsKey(city) && cityAssignments.get(city) != null;
	}
	
	public Boolean isNeighbour(Integer city1, Integer city2) {
		// PRE: city1, city2 exist
		// POST: Returns True if city1 is a neighbour of city2, false otherwise
		
		// TODO
		Set<Integer> neighbours = adjacencyList.get(city1);
		return neighbours != null && neighbours.contains(city2);
	}
	
	public Vector<Integer> getNeighbours(Integer city) {
		// PRE: city exists
		// POST: Returns vector of cities that are neighbours of city
		//         (empty vector if no neighbours)
		
		// TODO
		Set<Integer> neighbours = adjacencyList.getOrDefault(city, new HashSet<>());
		return new Vector<>(neighbours);
	}
	
	public Boolean isAssignedSame(Integer city1, Integer city2) {
		// PRE: city1, city2 exist
		// POST: Returns True if city1 and city2 are assigned troops from the same nation, 
		//         False otherwise

		// TODO
		if (!isAssigned(city1) || !isAssigned(city2)) {
			return false;
		}
		return getAssign(city1).equals(getAssign(city2));
	}
	
	
	public Boolean isValidAssign() {
		// PRE: -
		// POST: Returns True if troop assignment is valid, False otherwise
		
		// TODO
		for (Map.Entry<Integer, Set<Integer>> entry : adjacencyList.entrySet()) {
			Integer city = entry.getKey();
			for (Integer neighbour : entry.getValue()) {
				if (isAssignedSame(city, neighbour)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public Integer numDiffAssigns() {
		// PRE: -
		// POST: Returns the number of different nations from which troops are assigned
		
		// TODO
			Set<Integer> uniqueNations = new HashSet<>();
			for (Integer nation : cityAssignments.values()) {
				if (nation != null) {
					uniqueNations.add(nation);
				}
			}
		return uniqueNations.size();
	}
	
	public Boolean isEveryCityAssigned() {
		// PRE: -
		// POST: Returns True if every city is assigned some troops, False otherwise
		
		// TODO
		for (Integer assignment : cityAssignments.values()) {
			if (assignment == null) {
				return false;
			}
		}
		return true;
	}

	public void giveAnyAssignment() {
		// PRE: -
		// POST: Gives a valid assignment of troops to every city that does not already have troops assigned
		
		// TODO

		for (Integer city : cityAssignments.keySet()) {
			if (!isAssigned(city)) {
				Set<Integer> used = new HashSet<>();
				for (Integer neighbour : getNeighbours(city)) {
					if (isAssigned(neighbour)) {
						used.add(getAssign(neighbour));
					}
				}
				int assignId = 1;
				while (used.contains(assignId)) assignId++;
				setAssign(city, assignId);
			}
		}
	}

	
	// CREDIT
	
	public Boolean existsPath(Integer city1, Integer city2) {
		// PRE: city1 and city2 exist
		// POST: Returns True if there is a path between city1 and city2, False otherwise
		
		// TODO
		if (city1.equals(city2)) return true;
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(city1);
		visited.add(city1);

		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			for (Integer neighbour : adjacencyList.getOrDefault(current, Collections.emptySet())) {
				if (neighbour.equals(city2)) return true;
				if (!visited.contains(neighbour)) {
					visited.add(neighbour);
					queue.add(neighbour);
				}
			}
		}
		return false;
	}

	public void assignCity(Integer city) {
		// PRE: city not assigned
		// POST: Troops from some nation are validly assigned to city 
		
		// TODO
		Set<Integer> used = new HashSet<>();
		for (Integer neighbour : getNeighbours(city)) {
			if (isAssigned(neighbour)) {
				used.add(getAssign(neighbour));
			}
		}
		int id = 1;
		while (used.contains(id)) id++;
		setAssign(city, id);
	}

	public void assignCityLowest(Integer city) {
		// PRE: city not assigned
		// POST: Troops from the lowest possible numbered nation are validly assigned to city 

		// TODO
		assignCity(city);
	}
	
	
	// DISTINCTION
	
	public void giveGreedyCityOrderingAssignment() {
		// PRE: -
		// POST: Assigns troops greedily, starting at city1 and continuing to cityN,
		//         subject to constraints 

		// TODO
		List<Integer> orderedCities = new ArrayList<>(cityAssignments.keySet());
		Collections.sort(orderedCities);
		for (Integer city : orderedCities) {
			if (!isAssigned(city)) {
				assignCityLowest(city);
			}
		}
	}
	
	public void giveGreedyRoadOrderingAssignment() {
		// PRE: -
		// POST: Assigns troops greedily, starting at with most roads and working through to least
		//         (breaking ties by city ordering, so city i before city j if same number of
		//         roads and i < j), subject to constraints 

		// TODO
		List<Integer> cities = new ArrayList<>(cityAssignments.keySet());
		cities.sort((a, b) -> {
			int sizeA = adjacencyList.getOrDefault(a, Collections.emptySet()).size();
			int sizeB = adjacencyList.getOrDefault(b, Collections.emptySet()).size();
			if (sizeA != sizeB) return Integer.compare(sizeB, sizeA); // More roads first
			return Integer.compare(a, b); // Lower city number first on tie
		});

		for (Integer city : cities) {
			if (!isAssigned(city)) {
				assignCityLowest(city);
			}
		}
	}
	
	// Do assignWithNSources
	
	public Boolean canDoWithNSources(Integer N) {
		// PRE: -
		// POST: Returns True if there is some complete and valid assignment of troops that uses at most N nations,
		//         instantiating the map with such a complete and valid assignment;
		//         False otherwise
		
		// TODO

    // Backup current assignments
	Map<Integer, Integer> backup = new HashMap<>(cityAssignments);
	List<Integer> cities = new ArrayList<>(cityAssignments.keySet());
	Collections.sort(cities);

	boolean result = backtrackAssign(0, cities, N);
	if (!result) {
		cityAssignments.clear();
		cityAssignments.putAll(backup);
	}
	return result;
}

private boolean backtrackAssign(int idx, List<Integer> cities, int N) {
	if (idx == cities.size()) return isValidAssign();

	Integer city = cities.get(idx);
	if (isAssigned(city)) return backtrackAssign(idx + 1, cities, N);

	for (int nation = 1; nation <= N; nation++) {
		boolean conflict = false;
		for (Integer neighbour : getNeighbours(city)) {
			if (getAssign(neighbour) != null && getAssign(neighbour).equals(nation)) {
				conflict = true;
				break;
			}
		}
		if (!conflict) {
			setAssign(city, nation);
			if (backtrackAssign(idx + 1, cities, N)) return true;
			setAssign(city, null); // backtrack
		}
	}
	return false;
}

private Set<Integer> getConstrainedNations(Integer city, int N) {
    Set<Integer> constrained = new HashSet<>();
    for (Integer neighbor : getNeighbours(city)) {
        if (isAssigned(neighbor)) {
            constrained.add(getAssign(neighbor));
        }
    }
    return constrained;
}

private boolean backtrackWithOrder(Integer N, List<Integer> cities, int index) {
    if (index == cities.size()) {
        return isValidAssign() && numDiffAssigns() <= N;
    }
    
    Integer currentCity = cities.get(index);
    Set<Integer> constrained = getConstrainedNations(currentCity, N);
    
    // Try nations in order from least constrained to most
    for (int nation = 1; nation <= N; nation++) {
        if (!constrained.contains(nation)) {
            // Save current assignment
            Integer previous = cityAssignments.get(currentCity);
            setAssign(currentCity, nation);
            
            if (backtrackWithOrder(N, cities, index + 1)) {
                return true;
            }
            
            // Backtrack
            if (previous != null) {
                setAssign(currentCity, previous);
            } else {
                cityAssignments.remove(currentCity);
            }
        }
    }
    
    return false;
}

	
	public Boolean canFindBetterSoln() {
		// PRE: There is some initial complete assignment of troops
		// POST: Returns True if there is some complete and valid assignment of troops that is better than the initial,
		//         instantiating the map with such a complete and valid assignment;
		//         False otherwise
		
		// TODO
		if (!isValidAssign() || !isEveryCityAssigned()) return false;
		Map<Integer, Integer> backup = new HashMap<>(cityAssignments);
		int currentSources = numDiffAssigns();
		List<Integer> cities = new ArrayList<>(cityAssignments.keySet());
		Collections.sort(cities);
		for (int n = currentSources - 1; n >= 1; n--) {
			cityAssignments.clear();
			cityAssignments.putAll(backup);
			if (backtrackAssign(0, cities, n)) return true;
		}
		cityAssignments.clear();
		cityAssignments.putAll(backup);
		return false;
	}

	// HIGH DISTINCTION


	public Vector<Integer> pathWithAssign(Integer city1, Integer city2, Integer troopSource) {
		// PRE: city1, city2 are existing cities; troopSource is an existing nation;
		//        there is a complete valid assignment already 
		// POST: Returns a path between city1 and city2 that has at least one city assigned from troopSource,
		//         if such a path exists, as a vector;
		//         returns an empty vector otherwise

		// TODO
		Set<Integer> visited = new HashSet<>();
		Map<Integer, Integer> parent = new HashMap<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(city1);
		visited.add(city1);

		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			for (Integer neighbour : adjacencyList.getOrDefault(current, Collections.emptySet())) {
				if (!visited.contains(neighbour)) {
					visited.add(neighbour);
					parent.put(neighbour, current);
					queue.add(neighbour);
					if (neighbour.equals(city2)) break;
				}
			}
		}

		if (!visited.contains(city2)) return new Vector<>();

		List<Integer> path = new LinkedList<>();
		for (Integer at = city2; at != null; at = parent.get(at)) {
			path.add(0, at);
		}

		for (Integer city : path) {
			if (getAssign(city) != null && getAssign(city).equals(troopSource)) {
				return new Vector<>(path);
			}
		}
		return new Vector<>();
	}

	public Vector<Integer> makePathWithAssign(Integer city1, Integer city2, Integer troopSource) {
		// PRE: city1, city2 are existing cities; troopSource is a nation;
		//        there is NOT a complete valid assignment already 
		// POST: Returns a path between city1 and city2 that has at least one city assigned from troopSource,
		//         if such a path exists, as a vector;
		//         returns an empty vector otherwise

		// TODO
		Set<Integer> visited = new HashSet<>();
		Map<Integer, Integer> parent = new HashMap<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(city1);
		visited.add(city1);

		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			for (Integer neighbour : adjacencyList.getOrDefault(current, Collections.emptySet())) {
				if (!visited.contains(neighbour)) {
					visited.add(neighbour);
					parent.put(neighbour, current);
					queue.add(neighbour);
					if (neighbour.equals(city2)) break;
				}
			}
		}

		if (!visited.contains(city2)) return new Vector<>();

		List<Integer> path = new LinkedList<>();
		for (Integer at = city2; at != null; at = parent.get(at)) {
			path.add(0, at);
		}

		for (Integer city : path) {
			if (!isAssigned(city)) {
				Set<Integer> used = new HashSet<>();
				for (Integer neighbour : getNeighbours(city)) {
					if (isAssigned(neighbour)) used.add(getAssign(neighbour));
				}
				if (!used.contains(troopSource)) {
					setAssign(city, troopSource);
					break;
				}
			}
			if (getAssign(city) != null && getAssign(city).equals(troopSource)) {
				return new Vector<>(path);
			}
		}
		return new Vector<>();
	}



	// MAIN

	public static void main(String[] args) {
		AssignControl g = new AssignControl();
		Vector<Road> rList;
		Vector<Assign> aList;
		
	
		try {

			String dataDir = "C:\\Users\\rekit\\OneDrive\\Desktop\\Semester 4\\Data Structure and Algorithms\\assignment 2\\a2-sample-data\\data";
			// make sure there's a file separator at the end
			String fileBaseName = "sample1";
			FileNames fNames = new FileNames(dataDir, fileBaseName);

			rList = g.readRoadsFromFile(fNames.getRoadFile());
			aList = g.readAssignsFromFile(fNames.getAssignFile());
			g.instantiateMap(rList, aList);

			
			long start = System.nanoTime();
			g.setAssign(1, 5);
			long finish = System.nanoTime();
			double timeElapsed = (double) (finish - start) / 1000000; // in milliseconds
			System.out.print("Milliseconds elapsed: ");
			System.out.println(timeElapsed);

			
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
		
	}
	
}
