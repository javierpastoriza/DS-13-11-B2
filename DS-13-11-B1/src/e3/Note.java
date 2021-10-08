package e3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * Clase Note.
 * Clase que tiene las características de una nota.
 */
public class Note
{
    //************************** ATRIBUTOS ************************
    private final Notes note;
    private final Accidentals accidentals;
    private final float time;


    //************************** CONSTRUCTOR ***********************

    /**
     * Constructor de la clase Note. Se crea una nota con todas sus características.
     *
     * @param note        Nota.
     * @param accidentals Alteracion.
     * @param time        Tiempo.
     * @throws IllegalArgumentException Si la nota, la alteracion o el tiempo no son correctos.
     */
    public Note(Notes note, Accidentals accidentals, float time) throws IllegalArgumentException
    {
        if (note == null) throw new IllegalArgumentException("Nota no válida");
        else this.note = note;
        if (accidentals == null) throw new IllegalArgumentException("Alteracion no válida");
        else this.accidentals = accidentals;
        if (time <= 0f) throw new IllegalArgumentException("Duracion no valida");
        else this.time = time;
    }


    public Notes getNote() {
        return note;
    }

    public Accidentals getAccidentals() {
        return accidentals;
    }

    public float getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        if (Float.compare(this.getTime(),note.getTime())==0)
        {
            if (this.note == note.note && accidentals == note.accidentals) return (true);
            else
            {
                if (this.getAccidentals()==note.getAccidentals()) return(false);
                else return(this.equivalenciaNotas(note));
            }
        }
        else return (false);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(note, accidentals, time);
    }

    private boolean equivalenciaNotas(Note nota)
    {
        List<Note> comparadorNotasA=new ArrayList<Note>();
        List<Note> comparadorNotasB=new ArrayList<Note>();
        comparadorNotasA.add(new Note(Notes.DO, Accidentals.SHARP, 1.f));
        comparadorNotasB.add(new Note(Notes.RE, Accidentals.FLAT, 1.f));
        comparadorNotasA.add(new Note(Notes.RE, Accidentals.SHARP, 1.f));
        comparadorNotasB.add(new Note(Notes.MI, Accidentals.FLAT, 1.f));
        comparadorNotasA.add(new Note(Notes.MI, Accidentals.NATURAL, 1.f));
        comparadorNotasB.add(new Note(Notes.FA, Accidentals.FLAT, 1.f));
        comparadorNotasA.add(new Note(Notes.MI, Accidentals.SHARP, 1.f));
        comparadorNotasB.add(new Note(Notes.FA, Accidentals.NATURAL, 1.f));
        comparadorNotasA.add(new Note(Notes.FA, Accidentals.SHARP, 1.f));
        comparadorNotasB.add(new Note(Notes.SOL, Accidentals.FLAT, 1.f));
        comparadorNotasA.add(new Note(Notes.SOL, Accidentals.SHARP, 1f));
        comparadorNotasB.add(new Note(Notes.LA, Accidentals.FLAT, 1.f));
        comparadorNotasA.add(new Note(Notes.LA, Accidentals.SHARP, 1f));
        comparadorNotasB.add(new Note(Notes.SI, Accidentals.FLAT, 1.f));
        comparadorNotasA.add(new Note(Notes.SI, Accidentals.NATURAL, 1.f));
        comparadorNotasB.add(new Note(Notes.DO, Accidentals.FLAT, 1.f));
        comparadorNotasA.add(new Note(Notes.SI, Accidentals.SHARP, 1.f));
        comparadorNotasB.add(new Note(Notes.DO, Accidentals.NATURAL, 1.f));
        Note notaActual=new Note(this.getNote(), this.getAccidentals(), 1.f);
        Note notaComparativa=new Note (nota.getNote(), nota.getAccidentals(), 1.f);
        System.out.println("Llega hasta aqui");
        System.out.println(comparadorNotasA.size());
        //int posicion=null;
        boolean condicionWhile=true;
        boolean encontradoA=false;
        boolean encontradoB=false;
        int i=0;
        while(condicionWhile)
        {
            if(notaActual.equals(comparadorNotasA.get(i))) encontradoA=true;
            else
            {
                if(notaActual.equals(comparadorNotasB.get(i))) encontradoB=true;
            }
            condicionWhile=(!(encontradoA || encontradoB) || (i+1)<comparadorNotasA.size());
            if(condicionWhile) i++;
        }
        if(encontradoA || encontradoB)
        {
            if(encontradoA) return(notaComparativa.equals(comparadorNotasB.get(i)));
            else return(notaComparativa.equals(comparadorNotasA.get(i)));
        }
        else return(false);

        //System.out.println(comparadorNotasA.contains(new Note(Notes.SI, Accidentals.SHARP, 1.f)));
        /*if (comparadorNotasA.contains(notaActual))
        {
            if (comparadorNotasB.get(comparadorNotasA.indexOf(notaActual)).equals(notaComparativa)) return(true);
            else return (false);
        }
        else
        {
            if(comparadorNotasB.contains(notaActual))
            {
                if (comparadorNotasA.get(comparadorNotasB.indexOf(notaActual)).equals(notaComparativa)) return(true);
                else return (false);
            }
            else return(false);
        }*/
    }

    /*
    private boolean equivalenciaNotas(Note nota)
    {
        if (this.getAccidentals() == nota.getAccidentals()) return (false);
        else
        {
            if (this.getAccidentals()==Accidentals.NATURAL) return(this.equivalenciaNotasAccicentalsNatural(nota));
            else
            {
                if (this.getAccidentals()==Accidentals.SHARP) return(this.equivalenciaNotasAccidentalsSharp(nota));
                else return(this.equivalenciaNotasAccidentalsFlat(nota));
            }
        }
    }

    private boolean equivalenciaNotasAccicentalsNatural(Note nota)
    {
        boolean respuesta=false;
        switch (this.getNote())
        {
            case Notes.MI ->  : if (nota.getNote()==Notes.FA && nota.getAccidentals()==Accidentals.FLAT) respuesta=true; break;
        }
        return(respuesta);
    }

    private boolean equivalenciaNotasAccidentalsSharp(Note nota)
    {
        return(false);
    }

    private boolean equivalenciaNotasAccidentalsFlat(Note nota)
    {
        return(false);
    }
    */
}

