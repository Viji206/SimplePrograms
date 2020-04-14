package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import util.Student;

public class ArrayListSample {
	
	private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public static void main(String args[]){
		
		//simpleArrayList();
		customArrayList();
		
	}
	
	private static void customArrayList(){
		
		List<Student> studentList = new ArrayList<>();
		
		studentList.add(new Student(1, "Praveen", 28));
		studentList.add(new Student(2, "Viji", 28));
		studentList.add(new Student(3, "Murali", 30));
		
		List<Student> studentList2 = new ArrayList<>();
		studentList2.add(new Student(4, "Prashant", 29));
		
		printStudentList(studentList);		
		
		
		/*studentList.addAll(studentList2);
		printStudentList(studentList);
		
		Collections.sort(studentList);		
		printStudentList(studentList);
		
		Collections.sort(studentList, Collections.reverseOrder());
		printStudentList(studentList);
		
		Collections.sort(studentList,Student.nameComparator);
		printStudentList(studentList);
		
		Collections.sort(studentList,Student.idComparator);
		printStudentList(studentList);*/
		
		studentList.remove(new Student(1, "Praveen", 28));
		printStudentList(studentList);
		
		
	}
	
	
	private static void printStudentList(List<Student> studentList){
		
		for(Student student: studentList){
			logger.log(Level.INFO, student.getName());
		}
	}
	
	private static void printResult(List<String> sampleList)
	{
		for(String sample: sampleList){
			logger.log(Level.INFO, sample);
		}
	}

	private static void simpleArrayList(){
		List<String> sampleList = new ArrayList<>();
		
		LinkedList<String> sampleList1 = new LinkedList<>();
		
		
	
		sampleList.add("Z-One");
		sampleList.add("A-Two");
		sampleList.add("C-Three");
		sampleList.add(2, "2 - Test");
		
		ArrayList<String> sampleList2 = new ArrayList<>();
		sampleList2.add("V-Four");
		sampleList2.add("G-Five");
		sampleList2.add("I-Six");
				
		printResult(sampleList);
		
		sampleList.addAll(sampleList2);
		
		
		logger.log(Level.INFO,"Array List Length: {0}", sampleList.size());
	
		Collections.sort(sampleList);		
		printResult(sampleList);
		
		Collections.sort(sampleList,Collections.reverseOrder());
		printResult(sampleList);
	}
}
