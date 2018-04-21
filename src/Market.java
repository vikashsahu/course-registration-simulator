import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Market {

	static ArrayList<Course> courses = new ArrayList<Course>();
	static double pVal = 1.0;

	static ArrayList<Student> seniors = new ArrayList<Student>();
	static ArrayList<Student> juniors = new ArrayList<Student>();
	static ArrayList<Student> students = new ArrayList<Student>();//all students in one group, for the GS algo

	static HashMap<Integer, Course> rankedCourses = new HashMap<Integer, Course>();
	static HashMap<Course, Integer> rankedPreferences = new HashMap<Course, Integer>();

	static HashMap<Integer, Course> popCourses = new HashMap<Integer, Course>();

	static int jrSat=0;
	static int srSat=0;

	//create Random instance
	static Random rand = new Random();

	public static void main (String [] args) {
		//Course(String pName, int pCapacity, double pRanking, double pJuniorProb)

		Course fourEleven = new Course("411", 100, 3, pVal);
		courses.add(fourEleven);
		Course fourTwelve = new Course("412", 50, 16, pVal);
		courses.add(fourTwelve);
		Course fourFourteen = new Course("414", 85, 5, pVal);
		courses.add(fourFourteen);
		Course fourSeventeen = new Course("417", 70, 10, pVal);
		courses.add(fourSeventeen);
		Course fourTwenty = new Course("420", 80, 1, pVal);
		courses.add(fourTwenty);
		Course fourTwentyOne = new Course("421", 85, 6, pVal);
		courses.add(fourTwentyOne);
		Course fourTwentyTwo = new Course("422", 75, 8, pVal);
		courses.add(fourTwentyTwo);
		Course fourTwentyFour = new Course("424", 70, 11, pVal);
		courses.add(fourTwentyFour);
		Course fourTwentyFive = new Course("425", 50, 13, pVal);
		courses.add(fourTwentyFive);
		Course fourTwentySix = new Course("426", 40, 19, pVal);
		courses.add(fourTwentySix);
		Course fourThirty = new Course("430", 50, 14, pVal);
		courses.add(fourThirty);
		Course fourThirtyThree = new Course("433", 80, 7, pVal);
		courses.add(fourThirtyThree);
		Course fourThirtyFour = new Course("434", 48, 17, pVal);
		courses.add(fourThirtyFour);
		Course fourThirtyFive = new Course("435", 50, 15, pVal);
		courses.add(fourThirtyFive);
		Course fourThirtySix = new Course("436", 150, 2, pVal);
		courses.add(fourThirtySix);
		Course fourFiftyOne = new Course("451", 75, 9, pVal);
		courses.add(fourFiftyOne);
		Course fourFiftyTwo = new Course("452", 46, 18, pVal);
		courses.add(fourFiftyTwo);
		Course fourFiftySix = new Course("456", 70, 12, pVal);
		courses.add(fourFiftySix);
		Course fourSixty = new Course("460", 88, 4, pVal);
		courses.add(fourSixty);
		Course fourSixtySix = new Course("466", 32, 21, pVal);
		courses.add(fourSixtySix);
		Course fourSeventyFour = new Course("474", 40, 20, pVal);
		courses.add(fourSeventyFour);
		Course fourSeventyFive = new Course("475", 32, 22, pVal);
		courses.add(fourSeventyFive);

		popCourses.put(0, fourSeventyFive);
		popCourses.put(1, fourSeventyFive);
		popCourses.put(2, fourSixtySix);
		popCourses.put(3, fourSixtySix);
		popCourses.put(4, fourSeventyFour);
		popCourses.put(5, fourSeventyFour);
		popCourses.put(6, fourSeventyFour);
		popCourses.put(7, fourTwentySix);
		popCourses.put(8, fourTwentySix);
		popCourses.put(9, fourTwentySix);
		popCourses.put(10, fourFiftyTwo);
		popCourses.put(11, fourFiftyTwo);
		popCourses.put(12, fourFiftyTwo);
		popCourses.put(13, fourThirtyFour);
		popCourses.put(14, fourThirtyFour);
		popCourses.put(15, fourThirtyFour);
		popCourses.put(16, fourTwelve);
		popCourses.put(17, fourTwelve);
		popCourses.put(18, fourTwelve);
		popCourses.put(19, fourThirtyFive);
		popCourses.put(20, fourThirtyFive);
		popCourses.put(21, fourThirtyFive);
		popCourses.put(22, fourThirty);
		popCourses.put(23, fourThirty);
		popCourses.put(24, fourThirty);
		popCourses.put(25, fourTwentyFive);
		popCourses.put(26, fourTwentyFive);
		popCourses.put(27, fourTwentyFive);
		popCourses.put(28, fourFiftySix);
		popCourses.put(29, fourFiftySix);
		popCourses.put(30, fourFiftySix);
		popCourses.put(31, fourFiftySix);
		popCourses.put(32, fourFiftySix);
		popCourses.put(33, fourTwentyFour);
		popCourses.put(34, fourTwentyFour);
		popCourses.put(35, fourTwentyFour);
		popCourses.put(36, fourTwentyFour);
		popCourses.put(37, fourTwentyFour);
		popCourses.put(38, fourSeventeen);
		popCourses.put(39, fourSeventeen);
		popCourses.put(40, fourSeventeen);
		popCourses.put(41, fourSeventeen);
		popCourses.put(42, fourSeventeen);
		popCourses.put(43, fourFiftyOne);
		popCourses.put(44, fourFiftyOne);
		popCourses.put(45, fourFiftyOne);
		popCourses.put(46, fourFiftyOne);
		popCourses.put(47, fourFiftyOne);
		popCourses.put(48, fourTwentyTwo);
		popCourses.put(49, fourTwentyTwo);
		popCourses.put(50, fourTwentyTwo);
		popCourses.put(51, fourTwentyTwo);
		popCourses.put(52, fourTwentyTwo);
		popCourses.put(53, fourThirtyThree);
		popCourses.put(54, fourThirtyThree);
		popCourses.put(55, fourThirtyThree);
		popCourses.put(56, fourThirtyThree);
		popCourses.put(57, fourThirtyThree);
		popCourses.put(58, fourTwentyOne);
		popCourses.put(59, fourTwentyOne);
		popCourses.put(60, fourTwentyOne);
		popCourses.put(61, fourTwentyOne);
		popCourses.put(62, fourTwentyOne);
		popCourses.put(63, fourFourteen);
		popCourses.put(64, fourFourteen);
		popCourses.put(65, fourFourteen);
		popCourses.put(66, fourFourteen);
		popCourses.put(67, fourFourteen);
		popCourses.put(68, fourSixty);
		popCourses.put(69, fourSixty);
		popCourses.put(70, fourSixty);
		popCourses.put(71, fourSixty);
		popCourses.put(72, fourSixty);
		popCourses.put(73, fourSixty);
		popCourses.put(74, fourEleven);
		popCourses.put(75, fourEleven);
		popCourses.put(76, fourEleven);
		popCourses.put(77, fourEleven);
		popCourses.put(78, fourEleven);
		popCourses.put(79, fourEleven);
		popCourses.put(80, fourThirtySix);
		popCourses.put(81, fourThirtySix);
		popCourses.put(82, fourThirtySix);
		popCourses.put(83, fourThirtySix);
		popCourses.put(84, fourThirtySix);
		popCourses.put(85, fourThirtySix);
		popCourses.put(86, fourThirtySix);
		popCourses.put(87, fourThirtySix);
		popCourses.put(88, fourThirtySix);
		popCourses.put(89, fourThirtySix);
		popCourses.put(90, fourTwenty);
		popCourses.put(91, fourTwenty);
		popCourses.put(92, fourTwenty);
		popCourses.put(93, fourTwenty);
		popCourses.put(94, fourTwenty);
		popCourses.put(95, fourTwenty);
		popCourses.put(96, fourTwenty);
		popCourses.put(97, fourTwenty);
		popCourses.put(98, fourTwenty);
		popCourses.put(99, fourTwenty);

		//hashmap of courses, with key as their rank (so we can sort them)
		for (Course c: courses) {
			rankedCourses.put(c.ranking, c);
		}

		for (Course c: courses) {
			rankedPreferences.put(c, c.ranking);
		}


		juniors.clear();
		//creating the juniors
		for (int i=0; i<413; i++) {
			Student s = new Student(true);//student has both courseList and courseSet
			while (s.courseList.size()<7) {

				Course c;
				//pick a random number between 0 and 99
				int r = rand.nextInt(100);

				c = popCourses.get(r);

				if (!s.courseSet.contains(c)) {//this course is not already in their list of preferences
					s.courseSet.add(c);
					s.courseList.add(c);//courses are not added in ranked order. need to sort before doing other operations
					s.listOfRanks.add(c.ranking);
					s.listOfRanks2.add(c.ranking);
					Collections.sort(s.listOfRanks);
				}
			}
			juniors.add(s);
		}

		seniors.clear();
		//creating the seniors
		for (int i=0; i<413; i++) {
			Student s = new Student(false);
			while (s.courseList.size()<7) {
				Course c;
				//pick a random number between 0 and 99 (excludes 100)
				int r = rand.nextInt(100);

				c = popCourses.get(r);

				if (!s.courseSet.contains(c)) {
					s.courseSet.add(c);
					s.courseList.add(c);//courses are not added in ranking order. need to sort before doing the matching
					s.listOfRanks.add(c.ranking);
					s.listOfRanks2.add(c.ranking);
					Collections.sort(s.listOfRanks);
				}
			}
			seniors.add(s);
		}

		//doing the matching

		int baselineSeniorBenefit = 0;

		//BASELINE: SENIORS FIRST, JUNIORS SECOND
		/*for (Student st : seniors) {
			boolean loopcond = true;
			int dc=0;
			while (dc<2) {

				int currBenefit = st.courseList.size();//as courses on the list fill up, they will be removed from this list and the student's satisfaction will go down accordingly
				int pref=Integer.MAX_VALUE;
				Course currCourse=null;
				if (st.courseList.size()!=0) {
					for (Course c: st.courseList) {

						if (c.ranking < pref) {
							pref = c.ranking;
							currCourse = c;
						}
					}
					//System.out.println("currCourse: " + currCourse);
					if (currCourse.isFilled()) {
						st.courseList.remove(currCourse);
					} else {
						//match
						currCourse.addStudent(st);
						baselineSeniorBenefit+=currBenefit;
						st.courseList.remove(currCourse);
						loopcond = false;
						dc+=1;
					}	
				} else {
					loopcond = false;
					dc+=2;
				}

			}
		}

		int baselineJuniorBenefit =0;

		for (Student st : juniors) {
			boolean loopcond = true;
			int dc=0;
			while (dc<2) {

				int currBenefit = st.courseList.size();//as courses on the list fill up, they will be removed from this list and the student's satisfaction will go down accordingly
				int pref=Integer.MAX_VALUE;
				Course currCourse=null;
				if(st.courseList.size()!=0) {
					for (Course c: st.courseList) {

						if (c.ranking < pref) {
							//System.out.println("ranking: " + c.ranking);
							pref = c.ranking;
							currCourse = c;
						}
					}
					//currCourse is now the most desired course of the student
					if (currCourse.isFilled()) {
						st.courseList.remove(currCourse);
					} else {
						//match
						currCourse.addStudent(st);
						baselineJuniorBenefit+=currBenefit;
						st.courseList.remove(currCourse);
						loopcond = false;
						dc++;
					}
				} else {
					loopcond = false;
					dc+=2;
				}

			}
		}

		int baselineTotalBenefit = baselineJuniorBenefit + baselineSeniorBenefit;
		System.out.println(baselineJuniorBenefit + ", " + baselineSeniorBenefit + ", " + baselineTotalBenefit);*/
		//end baseline

		//MODIFIED GS MATCHING BASED ON PROBABILITY OF EJECTION
		/*int totalBenefit=0;
		students.addAll(seniors);
		students.addAll(juniors);

		Student evicted;

		HashSet<Integer> attemptedSet = new HashSet<Integer>();

		while(students.size()!=0) {//for all students
			Student st = students.get(0);
			while (st.numClasses<2) {//register a student for 2 courses
				Course currCourse = null;
				if(st.courseList.size()!=0) {//are there still classes on their list of 7 that they haven't registered for?

					for (int i=0; i<st.courseList.size(); i++) {//for each of the 7 courses on a student's preference list
						int rank = st.listOfRanks.get(i);//list of ranks is sorted, so we're getting ranks in order of preference
						currCourse = rankedCourses.get(rank);//get the course corresponding to this rank

						if(st.enrolledCourses.size()<2) {
								evicted = currCourse.addStudent(st);
								if(evicted==null) {//not added
									attemptedSet.add(rank);
								} else if (evicted.equals(st)) {//they were added in with no eviction
									//System.out.println("no eviction");
									attemptedSet.add(rank);
									totalBenefit+=(7-st.listOfRanks.indexOf(rank));
									st.satisfaction+=(7-st.listOfRanks.indexOf(rank));
								} else {//eviction and add.
									attemptedSet.add(rank);
									totalBenefit+=(7-st.listOfRanks.indexOf(rank));//add the benefit of the person who got in
									st.satisfaction+=(7-st.listOfRanks.indexOf(rank));

									//subtract from totalBenefit the amount lost by the eviction
									totalBenefit-=(7-evicted.listOfRanks.indexOf(rank));
									evicted.satisfaction-=(7-evicted.listOfRanks.indexOf(rank));

									//add the evicted person back into students
									students.add(evicted);
								}
						} else {
							break;
						}
					}
					if(st.enrolledCourses.size()!=0) {
						st.numClasses+=st.enrolledCourses.size();
					} else {
						st.numClasses+=999;
					}
				} else {//no more utility to be gained. add 999 to st.numCLasses to exit the while loop
					st.numClasses+=999;
				}
			}
			students.remove(st);
		}

		jrSat=0;
		for (Student j: juniors) {
			jrSat+=j.satisfaction;
		}

		srSat=0;
		for (Student sr : seniors) {
			srSat+=sr.satisfaction;
		}

		System.out.println(jrSat + ", " + srSat + ", " + totalBenefit);*/

		//GS WHERE A COURSE GIVES PREFERENCE TO THE STUDENT WHO WANTS IT MOST
		students.addAll(seniors);
		students.addAll(juniors);

		HashMap<Course, ArrayList<Integer>> prefSorted = new HashMap<Course, ArrayList<Integer>>();
		HashMap<Course, ArrayList<Student>> studentsByCourse = new HashMap<Course, ArrayList<Student>>();

		for (Course crs : courses) {
			prefSorted.put(crs, new ArrayList<Integer>());
			studentsByCourse.put(crs, new ArrayList<Student>());
		}


		int totJrSatPlus = 0;
		int totJrSatMinus =0;
		int totSrSatPlus = 0;
		int totSrSatMinus = 0;
		

		while (students.size()!=0) {

			for (int k=0; k<2; k++) {//iterate twice for 2 classes

				if (students.size()>0) {

					Student s1 = students.remove(0);

					if(s1.numClasses<2 && s1.listOfRanks.size()>0) {

						int rank = s1.listOfRanks.get(0);

						if(s1.courseList.size()>0) {
							Course c1 = rankedCourses.get(rank);
							s1.courseList.remove(c1);

							int lowestBenefit=Integer.MAX_VALUE;

							//get lowest benefit from prefSorted's arrayList
							for (int i=0; i<prefSorted.get(c1).size(); i++) {
								if (prefSorted.get(c1).size()>0 && prefSorted.get(c1).get(i) < lowestBenefit)
									lowestBenefit = prefSorted.get(c1).get(i);
							}

							if (prefSorted.get(c1).size() < c1.capacity) {//there is room. just add them in

								prefSorted.get(c1).add(7-s1.listOfRanks2.indexOf(rank));
								studentsByCourse.get(c1).add(s1);
								
								if (s1.isJunior) {
									totJrSatPlus+=(7-s1.listOfRanks2.indexOf(rank));
									//System.out.println("junior: " + totJrSatPlus);
									//System.out.println(7-s1.listOfRanks2.indexOf(rank));
								} else {
									totSrSatPlus+=(7-s1.listOfRanks2.indexOf(rank));
									//System.out.println("senior: " + totSrSatPlus);
								}
								
								s1.numClasses++;
								s1.satisfaction+=(7-s1.listOfRanks2.indexOf(rank));
								
								

							} else if (prefSorted.get(c1).size()==c1.capacity) {//no room. perform a swap if total benefit will increase
									if((7-s1.listOfRanks2.indexOf(rank)) > lowestBenefit) {
										prefSorted.get(c1).remove(lowestBenefit);
										
										for (Student s2: studentsByCourse.get(c1)) {
											if ((7-s2.listOfRanks2.indexOf(rank))==lowestBenefit) {//to give preference to senior: add in '&& s2.isjunior'
												s2.numClasses--;
												//System.out.println("before: " + s2.satisfaction);
												s2.satisfaction-=lowestBenefit;
												//System.out.println("after: " + s2.satisfaction);
												//System.out.println();
												//System.out.println(lowestBenefit + ", " + (7-s2.listOfRanks2.indexOf(rank)));
												
												
												//System.out.println("eviction");
												
												if (s2.isJunior) {
													totJrSatPlus-=lowestBenefit;
													//System.out.println("junior subtraction");
												} else {
													totSrSatPlus-=lowestBenefit;
													//System.out.println("senior subtraction");
												}
												
												//System.out.println(s2.satisfaction);
												students.add(s2);
												studentsByCourse.get(c1).remove(s2);
												break;
											}
										}

										prefSorted.get(c1).add(7-s1.listOfRanks2.indexOf(rank));
										s1.satisfaction+=(7-s1.listOfRanks2.indexOf(rank));
										
										if (s1.isJunior) {
											totJrSatPlus+=(7-s1.listOfRanks2.indexOf(rank));
											//System.out.println("jr add");
										} else {
											totSrSatPlus+=(7-s1.listOfRanks2.indexOf(rank));
											//System.out.println("sr add");
										}
										
										//System.out.println("+" + (7-s1.listOfRanks2.indexOf(rank)));
										studentsByCourse.get(c1).add(s1);
									} else {
										//not a better option, don't swap
									}
							}


						}
						s1.listOfRanks.remove(0);

						if(s1.courseList.size()>0)
							students.add(s1);
					}
				}
			}
		}

		jrSat=0;
		for (Student jr: juniors) {
			jrSat+=jr.satisfaction;
		}

		srSat=0;
		for (Student sr : seniors) {
			srSat+=sr.satisfaction;
		}

		int prefBenefit=0;
		int prefTotBenefit=0;
		int srBenefit=0;
		int jrBenefit=0;

		for (Course cKey: prefSorted.keySet()) {
			ArrayList al = prefSorted.get(cKey);
			for (int i=0; i<al.size(); i++) {
				prefBenefit+=prefSorted.get(cKey).get(i);
			}
		}
		System.out.println((prefBenefit-srSat) + ", " + srSat + ", " + prefBenefit);
		System.out.println("junior: " + totJrSatPlus + ", senior: " + totSrSatPlus + ", total: " + prefBenefit);
	}

	public static int baseline() {

		populate();

		int baselineSeniorBenefit = 0;
		int baselineJuniorBenefit =0;

		//BASELINE: SENIORS FIRST, JUNIORS SECOND
		for (Student st : seniors) {
			int dc=0;
			while (dc<2) {

				int currBenefit = st.courseList.size();//as courses on the list fill up, they will be removed from this list and the student's satisfaction will go down accordingly
				int pref=Integer.MAX_VALUE;
				Course currCourse=null;
				if (st.courseList.size()!=0) {
					for (Course c: st.courseList) {

						if (c.ranking < pref) {
							//System.out.println("ranking: " + c.ranking);
							pref = c.ranking;
							currCourse = c;
						}
					}
					//System.out.println("currCourse: " + currCourse);
					//currCourse is now the most desired course of the student
					if (currCourse.isFilled()) {
						st.courseList.remove(currCourse);
					} else {
						//match
						currCourse.addStudent(st);
						baselineSeniorBenefit+=currBenefit;
						st.courseList.remove(currCourse);
						dc+=1;
					}	
				} else {
					dc+=2;
				}

			}
		}

		for (Student st : juniors) {
			int dc=0;
			while (dc<2) {

				int currBenefit = st.courseList.size();//as courses on the list fill up, they will be removed from this list and the student's satisfaction will go down accordingly
				int pref=Integer.MAX_VALUE;
				Course currCourse=null;
				if(st.courseList.size()!=0) {
					for (Course c: st.courseList) {

						if (c.ranking < pref) {
							//System.out.println("ranking: " + c.ranking);
							pref = c.ranking;
							currCourse = c;
						}
					}
					//System.out.println("currCourse: " + currCourse);
					//currCourse is now the most desired course of the student
					if (currCourse.isFilled()) {
						st.courseList.remove(currCourse);
					} else {
						//match
						currCourse.addStudent(st);
						baselineJuniorBenefit+=currBenefit;
						st.courseList.remove(currCourse);
						dc++;
					}
				} else {
					dc+=2;
				}

			}
		}

		//System.out.println("baseline junior benefit: " + baselineJuniorBenefit);
		//System.out.println("baseline senior benefit: " + baselineSeniorBenefit);
		int baselineTotalBenefit = baselineJuniorBenefit + baselineSeniorBenefit;
		//System.out.println("baseline total benefit: " + baselineTotalBenefit);

		return baselineTotalBenefit;
	}

	static void populate() {

		juniors.clear();

		for (int i=0; i<413; i++) {
			Student s = new Student(true);//student has both courseList and courseSet
			while (s.courseList.size()<7) {

				Course c;
				//pick a random number between 0 and 99
				int r = rand.nextInt(100);

				c = popCourses.get(r);

				if (!s.courseSet.contains(c)) {//this course is not already in their list of preferences
					s.courseSet.add(c);
					s.courseList.add(c);//courses are not added in ranked order. need to sort before doing other operations
					s.listOfRanks.add(c.ranking);
					Collections.sort(s.listOfRanks);
				}
			}
			juniors.add(s);
		}

		seniors.clear();

		//creating the seniors
		for (int i=0; i<413; i++) {
			Student s = new Student(false);
			while (s.courseList.size()<7) {
				Course c;
				//pick a random number between 0 and 99 (excludes 100)
				int r = rand.nextInt(100);

				c = popCourses.get(r);

				if (!s.courseSet.contains(c)) {
					s.courseSet.add(c);
					s.courseList.add(c);//courses are not added in ranking order. need to sort before doing the matching
					s.listOfRanks.add(c.ranking);
					Collections.sort(s.listOfRanks);
				}
			}
			seniors.add(s);
		}
	}
}
