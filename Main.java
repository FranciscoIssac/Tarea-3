package com.company;

// modificadores de acceso --> Encapsulación

class Student {
    private String name;
    private String lastName;
    private String code;

    // Constructores

    Student(String name, String lastName, String code){
        this.name = name;
        this.lastName = lastName;
        this.code = code;
    }

    // Setters

    public void setName(String name){ // Setters
        this.name = name;
    }

    public void setLastName(String LastName){
        this.lastName = LastName;
    }

    public void setCode(String code){
        this.code = code;
    }

    // Getters

    public String getName(){
        return name;
    }

    public String getLastName(){
        return lastName;
    }

    public String getCode(){
        return code;
    }
}

class Group {
    private String code;
    private Student[] students;
    private int enrolled;
    private int rejected;

    public Group(String code, int capacity) {
        this.code = code;
        students = new Student[capacity];
    }

    public String getCode(){
        return code;
    }

    private boolean addStudent(Student student){
        if(enrolled < students.length){
            students[enrolled++] = student; // el ++ se ejecuta después de que la variable haya sido utilizada
            return true;
        }
        rejected++;
        return false;
    }

    public void removeStudent(String code){
        int i;
        for (i = 0; i < enrolled && students[i].getCode() != code; i++);
        if(students[i].getCode() == code){
            students[i] = students[enrolled - 1];
            enrolled--;
        }
    }

    public void inscribe(Student student){
        if(!addStudent(student)){
            System.out.println("Estudiante no fue añadido: " + student.getName() + " " + student.getLastName());
        }
        else{
            System.out.println("Estudiante fue añadido: " + student.getName() + " " + student.getLastName());
        }
    }

    public void printGroup(){
        System.out.println();
        System.out.println("Alumnos del grupo: " + code);

        for (int i = 0; i < enrolled; i++) {
            Student student = getStudent(i);
            System.out.println(student.getCode() + ": " + student.getName() + " " + student.getLastName());
        }
    }

    public int getEnrolled(){
        return enrolled;
    }

    public int getRejected() {
        return rejected;
    }

    public Student getStudent(int index){
        return students[index];
    }
}

public class Main {

    public static void main(String[] args) {
        Student student1; // Referencia a un Alumno
        Student student2 = new Student("Ivan", "Uresti", "972196");
        student1 = new Student("José", "González", "456789"); // Creando un objeto alumno

        Group group = new Group("230401", 8);
        Group group2 = new Group("230402", 6);

        group.inscribe(student1);
        group.inscribe(student2);
        group.inscribe(new Student("Jorge", "Acosta", "1"));
        group.inscribe(new Student("Arturo", "Aleman", "2"));
        group.inscribe(new Student("Antonio", "Angel", "3"));
        group.inscribe(new Student("Francisco", "Arreguin", "4"));
        group2.inscribe(new Student("Misael", "Cabrera", "5"));
        group2.inscribe(new Student("Roberto", "Cisneros", "6"));
        group.inscribe(new Student("Juan", "Coronado", "7"));
        group.inscribe(new Student("José", "González", "8"));
        group.inscribe(new Student("Jesús", "Lara", "9"));
        group.inscribe(new Student("José", "Limón", "10"));

        System.out.println("Grupo: " + group.getCode() + ", inscritos: " + group.getEnrolled() + ", rechazados: " + group.getRejected());
        System.out.printf("Grupo: %s, inscritos: %d, rechazados: %d%n", group2.getCode(), group2.getEnrolled(), group2.getRejected());

        System.out.println();
        group.removeStudent("4");
        group2.removeStudent("6");
        group2.removeStudent("12");
        System.out.println("Luego de eliminar alumnos:");

        System.out.println("Grupo: " + group.getCode() + ", inscritos: " + group.getEnrolled() + ", rechazados: " + group.getRejected());
        System.out.printf("Grupo: %s, inscritos: %d, rechazados: %d%n", group2.getCode(), group2.getEnrolled(), group2.getRejected());

        group.printGroup();
        group2.printGroup();
    }
}
