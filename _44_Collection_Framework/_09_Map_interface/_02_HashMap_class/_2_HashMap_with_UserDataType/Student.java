package _44_Collection_Framework._09_Map_interface._02_HashMap_class._2_HashMap_with_UserDataType;

public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "Student [id=" + this.id + " ,name=" + this.name + " ]";
    }
}
