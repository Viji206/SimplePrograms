package util;

import java.util.Comparator;

public class Student implements Comparable<Student>{

	private Integer id;
	private String name;
	private Integer age;
	

	public static final Comparator<Student> nameComparator = (Student s1, Student s2)->s1.getName().compareTo(s2.getName());
	
	public static final Comparator<Student> idComparator = (Student s1, Student s2)->s1.getId().compareTo(s2.getId());
	
	public Student(Integer id, String name, Integer age){
		this.id=id;
		this.name = name;
		this.age = age;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public int compareTo(Student student){
		
		return this.age - student.getAge();
		
	//	return student.getAge() - this.age;
	}
	@Override
	public boolean equals(Object object){
		
		if(this == object){
			return true;
		}		
		if(object == null){
			return false;
		}		
		if(getClass() != object.getClass()){
			return false;
		}
		Student other = (Student)object;
		if(id == null){
			if(other.getId() != null){
				return false;
			}			
		}else if(id != other.getId()){
			return false;
		}
		return true;	
	}
	
	/*public static final Comparator<Student> NameComparator1 = new Comparator<Student>(){
		
		public int compare(Student s1, Student s2){
			
			return s1.getName().compareTo(s2.getName());
		}
	};*/
	
	
}
