package entity;

public class Customer {
    private int id ;
    private String name ;
    private String phone ;
    private int adhaar ;

    public Customer( int id, String name, String phone , int adhaar) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.adhaar = adhaar;
    }

    public int getAdhaar() {
        return adhaar;
    }

    public void setAdhaar(int adhaar) {
        this.adhaar = adhaar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "[ Customer ID : "+id+" , Name : "+name+" Phone No : "+phone+" ]";
    }
}
