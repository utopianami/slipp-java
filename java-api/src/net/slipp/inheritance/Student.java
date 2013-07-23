package net.slipp.inheritance;

class Student {
	private String name;
	private int age;

	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	String getName() {
		return name;
	}
	
	int getAge() {
		return age;
	}
}
