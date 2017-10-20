import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;

/**
 * Write a description of class Adsb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Adsb
{
    private ArrayList<Double> altitude = new ArrayList<Double>();
    private ArrayList<Double> latitude = new ArrayList<Double>();
    private ArrayList<Double> longitude = new ArrayList<Double>();
    private ArrayList<Double> speed = new ArrayList<Double>();
    private ArrayList<Double> heading = new ArrayList<Double>();
    private ArrayList<String> id = new ArrayList<String>();
    private ArrayList<Time> time = new ArrayList<Time>();
    
    public void print_data(int index)
    {
        if (index < 0)
        {
            for (int i=0; i < time.size(); i++)
            {
                System.out.println("ID: " + id.get(i));
                time.get(i).print();
                System.out.println(altitude.get(i) + " " + latitude.get(i) + " " + longitude.get(i) 
                    + " " + speed.get(i) + " " + heading.get(i));
            }
            
        }
        else
        {
            System.out.println("ID: " + id.get(index));
            time.get(index).print();
            System.out.println(altitude.get(index) + " " + latitude.get(index) + " " + longitude.get(index) 
                + " " + speed.get(index) + " " + heading.get(index));
        }
    }
    
    
    
    
    public void read_file(String filename)
    {
        String [] temp_str = new String[26];
        String t_str;
        
        try 
        {
            FileReader fileptr = new FileReader(filename);
            Scanner in = new Scanner(new BufferedReader(fileptr));
            in.useDelimiter(", *");
            
            t_str = in.nextLine();
            
            while (in.hasNext())
            {
                for (int i=0; i < 25; i++)
                {
                    temp_str[i] = in.next();
                }
                
                String time_str = temp_str[2];  // Time
                String id_str = temp_str[8];   // ID
                String altitude_str = temp_str[11];  // altitude (meters)
                String latitude_str = temp_str[14];  // latitude (deg)
                String longitude_str = temp_str[15];  // longitude (deg)
                String speed_str = temp_str[20]; // speed m/s
                String heading_str = temp_str[21];  // heading degrees
                
                id.add(id_str);
                double altitude_d = Double.valueOf(altitude_str);
                double latitude_d = Double.valueOf(latitude_str);
                double longitude_d = Double.valueOf(longitude_str);
                double speed_d = Double.valueOf(speed_str);
                double heading_d = Double.valueOf(heading_str);
                
                altitude.add(altitude_d);
                latitude.add(latitude_d);
                longitude.add(longitude_d);
                speed.add(speed_d);
                heading.add(heading_d);
                
                Time tADSB = convert2TimeADSB(time_str);
                time.add(tADSB);
                
            }
            
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        
        catch (NoSuchElementException e)
        {
            System.out.println("No such element error");
        }
        
        
        
        
    }
    
    
    private Time convert2TimeADSB(String time_str)
    {
        int index, index2;
        String temp_str;
        
        // Get day
        index = time_str.indexOf('-');
        temp_str = time_str.substring(0, index);
        int day = Integer.parseInt(temp_str);
        
        // Get month
        index2 = time_str.indexOf('-', index+1);
        temp_str = time_str.substring(index+1,index2);
        String month = temp_str;
        
        // Get Year
        index = time_str.indexOf(' ');
        temp_str = time_str.substring(index2+1, index);
        int year = Integer.parseInt(temp_str);
        
        // Get Hour
        index2 = time_str.indexOf(':');
        temp_str = time_str.substring(index+1, index2);
        temp_str = temp_str.trim();
        int hour = Integer.parseInt(temp_str);  // int hour = Integer.parseInt(temp_str.trim());
        
        // Get minute
        index = time_str.indexOf(':', index2+1);
        temp_str = time_str.substring(index2+1, index);
        int minute = Integer.parseInt(temp_str);
        
        // Get second
        temp_str = time_str.substring(index+1);
        temp_str = temp_str.trim();
        int second = Integer.parseInt(temp_str);
        
        Time tADSB = new Time();
        
        tADSB.setday(day);
        tADSB.setmonth(month);
        tADSB.setyear(year);
        tADSB.sethour(hour);
        tADSB.setminute(minute);
        tADSB.setsecond(second);
        
        return (tADSB);
    }
}
