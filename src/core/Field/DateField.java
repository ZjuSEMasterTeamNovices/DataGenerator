package core.Field;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 *
 * @author Ace Z.Swift
 * int[] arr is a array for
 */
public class DateField extends BasicCSVField implements BasicField{

    private long startTime;
    private Date start;
    private Date end;
    private SimpleDateFormat format;
    private Random random;
    private int[] arr;

    public DateField(String startDate, String endDate, Random random, int arr[]) {
    	//set the start Time format
		format = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
			start = format.parse(startDate);
			end = format.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        startTime = start.getTime();

		this.random = random;

		this.arr = arr;
	}

    public long getRandomTime(long begin,long end){

        /*long randomTime = begin+(long)(Math.random()*(end-begin));
        if(randomTime == begin || randomTime == end){
            return getRandomTime(begin,end);
        }*/
    	int Hour = new Date(startTime).getHours();
//    	System.out.println(Hour);
    	startTime = begin + random.nextInt(arr[Hour])*1000;
        return startTime;
    }

    @Override
    public String getData() {

        if(startTime >= end.getTime()){
            System.err.print("startDate shouldn't big than end");
            return "bye";
        }
//      long date = getRandomTime(start.getTime(),end.getTime());
        long date = getRandomTime(startTime, end.getTime());
        Date rDate = new Date(date);
        //reset the output Time format
        format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = format.format(rDate);
        return result;
    }
}
