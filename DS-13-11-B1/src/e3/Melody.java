package e3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Melody
{
    /**
     * Creates an empty Melody instance .
     */

    private List<Note> notas;

    public Melody ()
    {
        notas=new ArrayList<>();
    }
    /**
     * Add a note at the end of this melody .
     * @param note The note to add
     * @param accidental The accidental of the note
     * @param time The duration of the note in milliseconds
     * @throws IllegalArgumentException if the note , the accidental
     * or the time are not valid values .
     */
    public void addNote ( Notes note , Accidentals accidental , float time ) throws IllegalArgumentException
    {
            Note nota = new Note(note, accidental, time);
            notas.add(nota);
    }
    /**
     * Returns the note on the given position
     * @param index The position of the note to get .
     * @return The note on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */
    public Notes getNote ( int index ) throws IllegalArgumentException
    {
        try
        {
            return (this.notas.get(index).getNote());
        }
        catch (IndexOutOfBoundsException ioobe)
        {
            throw new IllegalArgumentException(ioobe);
        }
    }
    /**
     * Returns the accidental of the note on the given position
     * @param index The position of the accidental to get .
     * @return The accidental on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */
    public Accidentals getAccidental (int index ) throws IllegalArgumentException
    {
        return(this.notas.get(index).getAccidentals());
    }
    /**
     * Returns the duration of the note on the given position
     * @param index The position of the time to get .
     * @return The time on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */
    public float getTime ( int index ) throws IllegalArgumentException
    {
        return(this.notas.get(index).getTime());
    }
    /**
     * Returns the number of notes in this melody .
     */
    public int size ()
    {
        return(this.notas.size());
    }
    /**
     * Returns the duration of this melody .
     * @return The duration of this melody in milliseconds .
     */
    public float getDuration ()
    {
        double tiempo=this.notas.stream().mapToDouble(item -> item.getTime()).sum();
        return((float)tiempo);
    }
    /**
     * Performs the equality tests of the current melody with another melody
     * passed as a parameter . Two melodies are equal if they represent the same
     * music fragment regardless of the name of its notes .
     * @param o The melody to be compared with the current melody .
     * @return true if the melodies are equals , false otherwise .
     */
    @Override
    public boolean equals ( Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Melody melody= (Melody) o;
        return(this.notas.equals(melody.notas));
    }
    /**
     * Returns an integer that is a hash code representation of the melody .
     * Two melodies m1 , m2 that are equals (m1. equals (m2) == true ) must
     * have the same hash code .
     * @return The hash code of this melody .
     */
    @Override
    public int hashCode ()
    {
        return Objects.hash (this.notas.hashCode());
    }
    /**
     * The string representation of this melody .
     * @return The String representantion of this melody .
     */
    @Override
    public String toString ()
    {
        String melodia=" ";
        if (this.notas.isEmpty()) return(melodia);
        else
        {
            Note nota=this.notas.get(0);
            melodia=nota.getNote()+nota.getAccidentals().toString()+"("+nota.getTime()+")";
            if(this.notas.size()>1)
            {
                for (int i = 1; i < this.notas.size(); i++)
                {
                    nota = this.notas.get(i);
                    melodia = melodia + " " + nota.getNote() + nota.getAccidentals().toString() + "(" + nota.getTime() + ")";
                }
            }
            return(melodia);
        }
    }
}