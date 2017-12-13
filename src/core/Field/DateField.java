package core.Field;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
/**
 *
 * @author Ace Z.Swift
 * int[] arr is a array for
 */
public class DateField extends BasicCSVField implements BasicField{

	public static final int CONTINUOUS_TIME = 1;
	public static final int FIXEDINTERVAL_TIME = 2;
	
    private long startTime;
    private long endTime;
//    private Date start;
//    private Date end;
    private SimpleDateFormat format;
    private Random random;
    private int[] schedule;
    private int timeStyle = 1;
    private int fixedInterval = 60 * 1000;
    
    //just for the interval time output
    private int tmpCount = 0;

    /**if you dont need the ending of date,plz use the other constructor
     * @param startDate the beginning of the date
     * @param endDate the ending of the date
     * @param random the random device that you need
     * @param schedule the size of this array is 24,represent the 24 hours of one day,and the value is the density of that hour
     * when the date has reached to the ending date,it would return null,and the generator will stop
     */
    public DateField(String startDate, String endDate, Random random, int schedule[]) {
    	//set the start Time format
		format = new SimpleDateFormat("yyyyMMddHHmmss");
		Date start,end;
        try {
			start = format.parse(startDate);
			end = format.parse(endDate);
			startTime = start.getTime();
	        endTime = end.getTime();
	        if(startTime > endTime)
	        {
	        	throw new IllegalArgumentException("check your startTime must less than endTime");
	        }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Plz check your format satisfy 'yyyyMMddHHmmss' ");
			e.printStackTrace();
		}
        this.random = random;
		this.schedule = schedule;
	}
    
    public DateField(String startDate, Random random, int schedule[])
    {
    	format = new SimpleDateFormat("yyyyMMddHHmmss");
		Date start,end;
        try {
			start = format.parse(startDate);
			startTime = start.getTime();
	        endTime = -1;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Plz check your format of date satisfy 'yyyyMMddHHmmss' ");
			e.printStackTrace();
		}
        this.random = random;
		this.schedule = schedule;
    }

    private Long getRandomTime(){
    	int Hour = new Date(startTime).getHours();
    	while(schedule[Hour] < 0) {
    		//the time of Hour add
    		startTime = startTime + 3600000;
    		Hour = new Date(startTime).getHours();
    	}
    	switch (timeStyle) {
		case CONTINUOUS_TIME:
			startTime += getRandomTimeIncrement_Continuous(schedule[Hour]);
			break;
		case FIXEDINTERVAL_TIME:
			startTime += getRandomTimeIncrement_FixedInterval(schedule[Hour]);
			break;
		default:
			break;
		}
        return startTime;
    }
    
    private int getRandomTimeIncrement_Continuous(int density)
    {
    	return random.nextInt(density)*1000;
    }
    
    private int getRandomTimeIncrement_FixedInterval(int density)
    {
    	if(tmpCount == 0)
    	{
    		//check the expand scale value,this value may change
    		tmpCount = random.nextInt(density) * 10;
    		return fixedInterval;
    	}
    	else if(tmpCount > 0)
    	{
    		tmpCount--;
    		return 0;
    	}
    	else {
			throw new IllegalArgumentException("Error internal status!");
		}
    }

    @Override
    public String getData() {

        long date = getRandomTime();
        
        if(endTime != -1 && date > endTime)
        {
        	return null;
        }
        
        Date rDate = new Date(date);
        
        //reset the output Time format
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(rDate);
    }

	public int getTimeStyle() {
		return timeStyle;
	}

	public void setTimeStyle(int timeStyle) {
		if(timeStyle != CONTINUOUS_TIME && timeStyle != FIXEDINTERVAL_TIME)
		{
			throw new IllegalArgumentException("plz check your timeStyle");
		}
		this.timeStyle = timeStyle;
	}

	public int getFixedInterval() {
		return fixedInterval;
	}

	public void setFixedInterval(int fixedInterval) {
		if(fixedInterval < 1)
		{
			throw new IllegalArgumentException("plz ensure your interval more than one millisecond");
		}
		this.fixedInterval = fixedInterval;
	}
}
