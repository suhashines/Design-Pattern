public class Database{

    private static Database db ;
    public String dbType;

    private Database(String dbType){
        //some connection code here
        this.dbType = dbType;
    }


    public static Database getInstance(String dbType){

        if(db==null){
            db = new Database(dbType);
        }

        return db;
        
    }


}