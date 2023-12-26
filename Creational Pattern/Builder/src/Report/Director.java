package Report;

public class Director {

    public Builder getBuilder(ReportType type) {
        
        return new Builder(type.type);
      
    }


}
