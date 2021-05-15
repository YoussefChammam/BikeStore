import java.math.*;

public class Fahrradverleih {
    String name;
    String type;
    int[] position;
    int longitude;
    int latitude;
    String present;
    public Fahrradverleih(String bikename , String biketype , int x , int y){
        this.name = bikename;
        this.type = biketype;
        this.longitude = x;
        this.latitude = y;
    }
    public int[] getPosition(){
        position = new int[] {longitude , latitude};
        return position;
    }
    //den Fahrrad nennen, mit dem wi den Abstand rechnen wollen. zbp: fahrrad1.Distance(Fahrrad1 , Fahrrad2);

    public double Distance( Fahrradverleih a , Fahrradverleih b){
        int x1 = a.longitude;
        int y1 = a.latitude;
        int x2 = b.longitude;
        int y2 = b.latitude;
        double dist =Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
        return dist;
    }
    @Override
    public String toString(){
        present = ("this is a " + name + " , " + type + "and it it's location is " + "[" + longitude + " , " + latitude + "]");
        return present;
    }
    //find bikes from north to south --> find bikes with highest y value first.

}
