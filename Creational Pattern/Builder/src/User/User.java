package User;

public class User {
    private final String firstName;    //required
    private final String lastName;    //required
    private final int age;    //optional
    private final String phone;    //optional
    private final String address;    //optional

    User(String firstName, String lastName, int age, String phone, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        String str = firstName + " " + lastName ;

        if(age != 0){
            str += " " + age;
        }

        if(phone != null){
            str += " " + phone;
        }
        if(address != null){
            str += " " + address;
        }

        return str;
    }
}
