package User;

public class Client {
    public static void main(String[] args) {
       User user = new Builder("Suhas","Abdullah")
                    .setPhone("01234565")
                    .build();
                    
       System.out.println(user.toString());
    }
}
