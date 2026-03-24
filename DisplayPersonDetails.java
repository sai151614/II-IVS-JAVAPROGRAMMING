class Person {
    String name;
    int age;
    String address;
    String degree;
    String university;

    public Person(String name, int age, String address, String degree, String university) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.degree = degree;
        this.university = university;
    }

    public void displayPersonalDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }

    public void displayQualificationDetails() {
        System.out.println("Degree: " + degree);
        System.out.println("University: " + university);
    }
}

public class DisplayPersonDetails {
    public static void main(String[] args) {
        Person p = new Person("John Doe", 25, "123 Main St", "BSc Computer Science", "XYZ University");
        p.displayPersonalDetails();
        p.displayQualificationDetails();
    }
}