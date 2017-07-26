import java.io.FileNotFoundException;

public class CalendarDriver
{
    public static void main(String [] args) throws FileNotFoundException{
        
        CalendarManager yo = new CalendarManager();
        System.out.print(yo);
        yo.load("names.txt");
        yo.setGuards();
        System.out.print(yo);
    }

}
