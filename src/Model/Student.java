
package Model;


public abstract class Student {
    private int id;
    private String fullName;
    private Address address;
    protected double averageScore;

    public Student() {
    }

    public Student(int id, String fullName, Address address) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Address getAddress() {
        return address;
    }
    
    public double getAverageScore(){
        return averageScore;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    public abstract void CaculateAverageScore();

}
