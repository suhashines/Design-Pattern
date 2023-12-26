package Electronics;

class Processor{
    String type;
    int clock;
    int cores;
    //add other attributes as well
}

public abstract class Builder {
    String type;
    Builder(String type) {
        this.type = type;
    }

    public abstract void reset();
    public abstract Processor build();
}

class CPUBuilder extends Builder {
    Processor processor;

    CPUBuilder(String type) {
       
        super(type); 
        reset();
        processor.type = type;
    }

    public Builder addClock(int pulse){
        processor.clock = pulse;
        return this;
    }

    public Builder addCores(int cores){
        processor.cores = cores;
        return this;
    }

    @Override
    public void reset() {
        processor = new Processor();
    }

    @Override
    public Processor build() {
        return processor;
    }


}

//add GPU and FPGA builder according to properties



class Director{
    public Builder buildCPU(){
        return new CPUBuilder("CPU");
    }

//     public Builder buildGPU(){
        
//     }
//similarly add other builders
 }

 