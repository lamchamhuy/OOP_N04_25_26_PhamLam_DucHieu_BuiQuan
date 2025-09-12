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


public class NNCollection {
    private NameNumber[] nnArray = new NameNumber[100];
    private int free;

    public NNCollection() {
        free = 0;
    }

    // Method to insert a NameNumber object into the array in sorted order
    public void insert(NameNumber n) {
        int index = 0;
        for (int i = free++; 
             i != 0 && nnArray[i - 1].getLastName().compareTo(n.getLastName()) > 0; 
             i--) {
            nnArray[i] = nnArray[i - 1]; // Shift elements right
            index = i;
        }
        nnArray[index] = n;
    }
}

