
/**
 * Write a description of class Adsbtester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Adsbtester
{

    public static void main(String[] args)
    {
        Adsb data = new Adsb();
        
        data.read_file("adsb_17aug17.dat");
        
        data.print_data(0);
        data.print_data(10);
        data.print_data(345);
        
    }
}
