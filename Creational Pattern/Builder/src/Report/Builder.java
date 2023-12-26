package Report;

public class Builder {
    private Report report ;
    String builderType ;

    Builder(String builderType){
        reset();
        this.builderType = builderType;
    }
    private void reset(){
        report = new Report();
    }

    //create appropriate components according to builder type

    Builder addHeader(String header){
        
        report.header += builderType + " " + header;
        return this;
    }

    Builder addFooter(String footer){
        report.footer += builderType+" "+footer;
        return this;
    }

    Builder addBody(String body){
        report.body += builderType + " " + body;
        return this; 
    }

    Report build(){
        return report ;
    }
}
