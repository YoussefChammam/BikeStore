import org.junit.Assert;
import org.junit.Test;

public class Testing {
    @Test
    public void testing() {
        kundenkonto chamam = new kundenkonto(30);
        Assert.assertTrue(chamam.Radkilomtern(30) == 60);
    }
    //error
    @Test
    public void testing2() {
        kundenkonto chamam = new kundenkonto(30);
        Assert.assertTrue(chamam.retrievekilometern(10) == 80);
    }
    //error
    @Test
    public void testing3() {
        kundenkonto chamam = new kundenkonto(30);
        Assert.assertTrue(chamam.Radkilomtern(1) == 100);
    }
}
