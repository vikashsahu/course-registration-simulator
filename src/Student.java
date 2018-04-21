import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Student{

	public ArrayList<Course> courseList;
	public HashSet<Course> courseSet;
	public boolean isMatched;
	public int satisfaction;
	public boolean isJunior;
	public int numClasses;
	public ArrayList<Course> enrolledCourses;
	public ArrayList<Integer> listOfRanks;
	public ArrayList<Integer> listOfRanks2;
	
	public Student() {
		courseList = new ArrayList<Course>();
		courseSet = new HashSet<Course>();
		isMatched = false;
		satisfaction = 0;
		numClasses=0;
		enrolledCourses = new ArrayList<Course>();
		listOfRanks=new ArrayList<Integer>();
		listOfRanks2 = new ArrayList<Integer>();
	}
	
	public Student(boolean junior) {
		courseList = new ArrayList<Course>();
		courseSet = new HashSet<Course>();
		isMatched = false;
		satisfaction = 0;
		isJunior = junior;
		numClasses=0;
		enrolledCourses = new ArrayList<Course>();
		listOfRanks=new ArrayList<Integer>();
		listOfRanks2 = new ArrayList<Integer>();
	}
	
	public void match() {
		isMatched = true;
	}
	
	public void unmatch() {
		isMatched = false;
	}
	
	public int updateSatisfaction(int i) {
		satisfaction += i;
		return satisfaction;
	}
}
