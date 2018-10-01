
//Avery Higgins 2017 
import java.util.ArrayList;

public class ScheduleCalendar
{
    protected String name;

    protected ArrayList<Slot> slots;

    /**
     * Creates schedule calendar, and initializes 14 slots for each week. 
     * @param name
     */
    public ScheduleCalendar(String name)
    {
        this.name = name;
        slots = new ArrayList<Slot>();
        for (int i = 0; i < 14; i++)
        {
            slots.add(new Slot(4));

        }

    }

    /**
     * Currently doesn't do anything lol my b.
     * @param slot
     * @return
     */
    public boolean isOpen(int slot)
    {
        Lifeguard testGuar = new Lifeguard(1, "tst");
        return slots.get(slot).addGuard(testGuar);
    }

    /**
     * Sets the guard to the given slot. 
     * @param guard
     * @param slot
     * @return
     */
    public boolean setGuard(Lifeguard guard, int slot)
    {
        return slots.get(slot).addGuard(guard);

    }

    /**
     * toString, duh. 
     */
    public String toString()
    {
        String output = "";
        output += name + "\n";
        int dayCount = 0;
        for (Slot s : slots)
        {
            output += "Day " + (dayCount / 2) + ": ";
            output += s.toString();
            output += "\n";
            dayCount++;
        }

        return output;

    }

    /**
     * Private class to only be used in Schedule Calendar that represents each slot, 
     * morning and afternoon that lifeguards work in. There are 2 for each day, so 14 in 
     * total. 
     * @author Avery Higgins
     *
     */
    private class Slot
    {
        private ArrayList<Lifeguard> guards;
        private int numOfGuards;

        public Slot(int num)
        {
            guards = new ArrayList<Lifeguard>();
            numOfGuards = num;
        }

        /**
         * Adds given guard, returns true if successful, false if not. 
         * @param g is the given guard. 
         * @return boolean
         */
        public boolean addGuard(Lifeguard g)
        {
            if (guards.size() < numOfGuards)
            {
                guards.add(g);
                return true;
            }
            else
            {
                return false;
            }

        }

        public String toString()
        {
            
            String output = "";
            
            for (int i = 0; i < numOfGuards; i++)
            {
                if (i < guards.size())
                {
                    output += "Guard #" + i + " " + guards.get(i) + "\t";
                }
                else{
                    output += "Empty.";
                }
            }
            return output;
        }

    }

}

