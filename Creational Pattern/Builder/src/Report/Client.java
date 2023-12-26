package Report;

public class Client {
    public static void main(String[] args) {

        Report report = new Director()
                        .getBuilder(ReportType.analysis)
                        .addHeader("This is my analysis report")
                         .build();

        
    }
}
