/**
 * Write a description of class Time here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Time
{
    private String month;
    private int day;
    private int year;
    private int hour;
    private int minute;
    private int second;
    
    public void print()
    {
        System.out.println(day + "-" + month + "-" + year + " " + hour + ":" + minute + ":" + second);
    }
    
    public void setmonth(String m)
    {
        month = m;
    }
    
    public String getmonth()
    {
        return (month);
    }
    
    public void setday(int d)
    {
        day = d;
    }
    
    public int getday()
    {
        return(day);
    }
    
    public void setyear(int y)
    {
        year = y;
    }
    
    public int getyear()
    {
        return (year);
    }
    
    public void sethour(int h)
    {
        hour = h;
    }
    
    public int gethour()
    {
        return (hour);
    }
    
    public void setminute(int m)
    {
        minute = m;
    }
    
    public int getminute()
    {
        return (minute);
    }
    
    public void setsecond(int s)
    {
        second = s;
    }
    
    public int getsecond()
    {
        return (second);
    }
}
