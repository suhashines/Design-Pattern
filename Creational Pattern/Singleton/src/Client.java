public class Client {
   public static void main(String[] args) {

        Database mongo = Database.getInstance("MongoDB");
        Database sql = Database.getInstance("MySQL");   

        System.out.println(mongo.dbType);
        System.out.println(sql.dbType);

        //output will be MongoDB, because mongo instance were created before


       
   } 
}
