package model;


/**
 * Lav en beskrivelse af klassen BookCopy her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */
public class BookCopy
{
    // instansvariabler - erstat eksemplet herunder med dine egne variabler
    private int copyNumber;

    /**
     * Konstruktør for objekter af klassen BookCopy
     */
    public BookCopy(int copyNumber)
    {
        this.copyNumber = copyNumber;
    }

    /**
     * Et eksempel på en metode - erstat denne kommentar med din egen
     * 
     * @param  y  eksempel på en parameter til en metode
     * @return    summen af x og y 
     */
    public int getCopyNumber()
    {
        return this.copyNumber;
    }
}