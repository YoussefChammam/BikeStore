public class kundenkonto {
    double credits;
    //constructor
    public kundenkonto(double credits){
        this.credits = credits;
    }

    //1 euros = 3 credits (euros).
    public double Radkilomtern(int added){
        return credits + added;
    }
    public double retrievekilometern(int retrieved){
        return credits - retrieved;
    }

}
