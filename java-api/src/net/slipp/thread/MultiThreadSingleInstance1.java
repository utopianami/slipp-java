package net.slipp.thread;

public class MultiThreadSingleInstance1 {
	public static void main(String[] args) {
		Student student = new Student();
		MultiThread thread1 = new MultiThread("재성", student);
		thread1.start();
		MultiThread thread2 = new MultiThread("주한", student);
		thread2.start();
	}
}

class MultiThread extends Thread {
	private Student student;
	private String studentName;

	public MultiThread(String studentName, Student student) {
		super(studentName);
		this.student = student;
	}
	
	@Override
	public void run() {
		student.getMessage(studentName);
		System.out.println("after name : " + student.getName());
	}
}


class Student {
	private String name;
	
	public Student() {
	}
	
	public void getMessage(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}