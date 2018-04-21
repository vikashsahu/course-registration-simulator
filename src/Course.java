import java.util.ArrayList;
import java.util.Random;

public class Course{

	public static Random rand = new Random();

	public String name;
	public String section;
	public int capacity;
	public int seatsFilled;
	public int ranking;
	public double juniorProb;//probability that a junior gets evicted
	public ArrayList<Student> juniors;
	public ArrayList<Student> seniors;
	public int relativeRanking;

	public Course(String pName, int pCapacity, int pRanking, double pJuniorProb) {
		name = pName;
		section = "0101";
		capacity = pCapacity;
		seatsFilled = 0;
		ranking = pRanking;
		juniorProb = pJuniorProb;
		juniors = new ArrayList<Student>();
		seniors = new ArrayList<Student>();
	}

	public Course(String pName, String pSection, int pCapacity, int pRanking, double pJuniorProb) {
		name = pName;
		section = pSection;
		capacity = pCapacity;
		seatsFilled = 0;
		ranking = pRanking;
		juniorProb = pJuniorProb;
		juniors = new ArrayList<Student>();
		seniors = new ArrayList<Student>();
	}

	public boolean isFilled() {
		return capacity == seatsFilled;
	}

	//returns: the student who was evicted (if any), or null otherwise
	public Student addStudent(Student s) {
		Student retStudent = null;
		if (s.isJunior) {
			if (isFilled()) {//no seats available and we're trying to add a junior. in this case
				//evict a senior with probability p=1-juniorPreference and add the junior in if the senior was evicted

				if (rand.nextDouble() < 1-juniorProb) {//evict
					//System.out.println("EVICT SENIOR");
					if(this.seniors.size()>0) {
						int index = rand.nextInt(seniors.size());//generate a random int from [0,seniors.size)
						retStudent = this.seniors.remove(index);//remove the senior @ that randomly generated int
						retStudent.numClasses-=1;
						retStudent.enrolledCourses.remove(this);//remove this course from the senior's list of enrolled courses
						this.juniors.add(s);
						s.enrolledCourses.add(this);//add this course to their list of enrolled courses
					}

				}
				//else don't evict, do nothing

			} else {//seats available and we're trying to add a junior. Just add them in
				this.juniors.add(s);
				s.enrolledCourses.add(this);
				this.seatsFilled+=1;
				retStudent = s;
			}
		} else {//student is a senior
			if (isFilled()) {//no seats available and we're trying to add a senior. in this case
				//evict a junior with probability p=juniorPreference and add the senior in if the junior was evicted

				if (rand.nextDouble() < juniorProb) {
					//System.out.println("EVICT JUNIOR");
					if (this.juniors.size()>0) {
						int index = rand.nextInt(this.juniors.size());
						retStudent = this.juniors.remove(index);
						retStudent.numClasses-=1;
						retStudent.enrolledCourses.remove(this);
						this.seniors.add(s);
						s.enrolledCourses.add(this);
					}

				}

			} else {//seats available and we're trying to add a senior. Just add them in
				this.seniors.add(s);
				s.enrolledCourses.add(this);
				this.seatsFilled+=1;
				retStudent = s;
			}

		}

		return retStudent;
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;

		if (!(o instanceof Course)) 
			return false;

		Course c = (Course) o;

		return this.name.equals(c.name);
	}

}
