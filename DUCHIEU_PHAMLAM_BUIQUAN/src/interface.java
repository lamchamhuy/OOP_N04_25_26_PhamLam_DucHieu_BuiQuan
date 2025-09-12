public class NameNumber {
    private String lastName;    // tên (last name)
    private String telNumber;   // số điện thoại (telephone number)

    // Default constructor
    public NameNumber() {}

    // Constructor with parameters
    public NameNumber(String name, String num) {
        lastName = name;
        telNumber = num;
    }

    // Getter method for lastName
    public String getLastName() {
        return lastName;
    }

    // Getter method for telNumber
    public String getTelNumber() {
        return telNumber;
    }
}
