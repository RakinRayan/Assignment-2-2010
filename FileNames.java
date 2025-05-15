package code;
import java.io.File;

public class FileNames {

	File roadsName;
	File assignsName;
	
	public FileNames(String dataDir, String fileName) {
		File f = new File(dataDir);
		roadsName = new File(f, fileName+"-roads.txt");
		assignsName = new File(f, fileName+"-assigns.txt");
	}
	
	public File getRoadFile() {
		return roadsName;
	}

	public File getAssignFile() {
		return assignsName;
	}

//	String baseName;
	
//	public FileNames(String b) {
//		baseName = b;
//	}
//	
//	public String getRoadFile() {
//		return baseName + "-roads.txt";
//	}
//
//	public String getAssignFile() {
//		return baseName + "-assigns.txt";
//	}

}
