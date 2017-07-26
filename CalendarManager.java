import java.util.ArrayList;
import java.io.*;
import java.util.Collections;
import java.util.Scanner;

//Avery Higgins 2017

public class CalendarManager
{
    private ArrayList<Lifeguard> lifeguards;
    private ArrayList<Lifeguard> rank1;
    private ArrayList<Lifeguard> rank2;
    private ArrayList<Lifeguard> rank3;

    protected ScheduleCalendar calendar;

    /**
     * Arranges the guards and puts them into corresponding 
     * rank arraylist. 
     */
    private void arrangeGuards()
    {
        rank1 = new ArrayList<Lifeguard>();
        rank2 = new ArrayList<Lifeguard>();
        rank3 = new ArrayList<Lifeguard>();
        
        Collections.sort(lifeguards);
        for (Lifeguard g : lifeguards)
        {
            if (g.rank == 1)
            {
                rank1.add(g);
            }
            else if (g.rank == 2)
            {
                rank2.add(g);
            }
            else
            {
                rank3.add(g);
            }
        }

    }

    /**
     * adds a guard to the manager, updates the lists. 
     * @param a
     */
    public void addGuard(Lifeguard a)
    {
        lifeguards.add(a);
        Collections.sort(lifeguards);
        arrangeGuards();
    }
    
    

    /**
     * Sets all of the guards into the slots of the schedule. Currently goes through and adds
     * at least one guard of each rank to each slot. need to fix functionality as it shouldn't
     * work like that. 
     */
    public void setGuards()
    {
        
        //Goes through and sets the Rank 1s, 
        for (int i = 0; i < 14; i++)
        {
            if (rank1.size() > 0)
            {
                int k = i;
                if (i >= rank1.size())
                {
                    k = i % rank1.size(); // once it gets to end of on file rank
                                          // 1 guards,
                } // it sends it back to beginning of list.
                if (rank1.get(k).checkAvailability(i / 2, i % 2))
                {
                    calendar.setGuard(rank1.get(k), i);
                    System.out.println("set r1");

                }
            }
        }

        //Goes through and sets the rank 2s, 
        for (int i = 0; i < 14; i++)
        {
            if (rank2.size() > 0)
            {
                int k = i;
                if (i >= rank2.size())
                {
                    k = i % rank2.size();
                }
                calendar.setGuard(rank2.get(k), i);
                System.out.println("set r2");
            }
        }
        
        //Goes through and sets the rank 3s, 
        for (int i = 0; i < 14; i++)
        {
            if (rank3.size() > 0)
            {
                int k = i;
                if (i >= rank3.size())
                {
                    k = i % rank3.size();
                }
                calendar.setGuard(rank3.get(k), i);
                System.out.println("set r3");
            }
        }

    }

    public CalendarManager(ArrayList<Lifeguard> lifeguards)
    {

        this();
        this.lifeguards = lifeguards;
        arrangeGuards();

    }

    public CalendarManager()
    {
        lifeguards = new ArrayList<Lifeguard>();
        rank1 = new ArrayList<Lifeguard>();
        rank2 = new ArrayList<Lifeguard>();
        rank3 = new ArrayList<Lifeguard>();

        calendar = new ScheduleCalendar("test");
    }

    /**
     * Allows one to load guards from a text file, in this format:
     * 
     * Lifeguard Name:              Lifeguard Rank #:
     * Avery                        1
     * 
     * @param fileName
     * @throws FileNotFoundException
     */
    public void load(String fileName) throws FileNotFoundException
    {
        File file = new File(fileName);
        Scanner scans = new Scanner(file);

        while (scans.hasNext())
        {
            String name = scans.next();
            if (scans.hasNextInt())
            {
                int rank = scans.nextInt();
                lifeguards.add(new Lifeguard(rank, name));
                System.out.println("added" + name);
            }
        }

        scans.close();
        arrangeGuards();

    }

    public String toString()
    {
        return calendar.toString();
    }

}
