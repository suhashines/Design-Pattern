package Report;

public class Report {
    String type;
    String header;
    String body ;
    String footer ;
}

enum ReportType {

    descriptive("descriptive"),
    narrative("narrative"),
    analysis("header") ;

    //will add more report types if necessary
     String type;
    

    ReportType(String type){
        this.type = type;
    }

}
