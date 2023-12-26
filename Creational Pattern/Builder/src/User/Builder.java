package User;

public class Builder {

    String firstname, lastname, address,phone ;
    int age ;

    Builder(String firstname,String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
        
    }

    public Builder setAge(int age){
        this.age = age;
        return this;
    }

    public Builder setAddress(String address){
        this.address = address;
        return this;
    }

    public Builder setPhone(String phone){
        this.phone = phone;
        return this;
    }

    public User build(){

        return new User(firstname,lastname,age,address,phone);
    }
}

