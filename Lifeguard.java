//Avery Higgins 2017 


public class Lifeguard implements Comparable
{
    protected int rank;
    protected String name;
    protected int hoursWorked;
    private boolean[][] availability;

    /**
     * Sets the availability of the said Lifegaurd to always available. 
     * @return
     */
    public static boolean[][] ALWAYS_AVAILABLE()
    {
        boolean[][] avail = new boolean[7][2];
        for (int i = 0; i < avail.length; i++)
        {
            for (int j = 0; j < avail[i].length; j++)
            {
                avail[i][j] = true;
            }
        }
        return avail;

    }

    /**
     * sets the guard to being unavailable on the given day and given time
     * @param day
     * @param section
     * @throws IllegalArgumentException
     */
    public void setUnavailable(int day, int section) throws IllegalArgumentException
    {
        try
        {
            availability[day][section] = false;

        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Incorrect value.");

        }
    }

    /**
     * checks the availability of the guard. 
     * @param day
     * @param time
     * @return boolean
     */
    public boolean checkAvailability(int day, int time)
    {
        return availability[day][time];

    }

    /**
     * Creates a new lifegaurd. 
     * @param rank is the given rank.
     * @param name is the given name. 
     */
    public Lifeguard(int rank, String name)
    {
        this.rank = rank;
        this.name = name;
        hoursWorked = 0;

        availability = ALWAYS_AVAILABLE();

    }

    @Override
    public int compareTo(Object other)
    {
        int output = 0;
        Lifeguard mandem;
        if(other instanceof Lifeguard){
            mandem = (Lifeguard)other;           

            if (this.rank > mandem.rank)
            {
                output = 1;
            }
            if (this.rank < mandem.rank)
            {
                output = -1;
            }
            
            
        }
        

        return output;
    }
    
    @Override
    public String toString(){
        return name;
    }


}
