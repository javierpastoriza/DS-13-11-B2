package e3;

public enum Accidentals
{
    NATURAL,SHARP,FLAT;

    @Override
    public String toString()
    {
        if (this==Accidentals.NATURAL) return("");
        else
        {
            if(this==Accidentals.SHARP) return("#");
            else return("b");
        }
    }
}
