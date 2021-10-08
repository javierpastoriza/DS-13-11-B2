package e3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class NoteEquivalente
{
    private Notes notaA;
    private Accidentals alteracionA;
    private Notes notaB;
    private Accidentals alteracionB;

    private static List<NoteEquivalente> notasEquivalentes =new ArrayList<>();


    NoteEquivalente(Notes notaA, Accidentals alteracionA, Notes notaB, Accidentals alteracionB)
    {
        this.notaA = notaA;
        this.alteracionA = alteracionA;
        this.notaB = notaB;
        this.alteracionB = alteracionB;
    }

    public static boolean sonEquivalentes(Notes notaA, Accidentals alteracionA, Notes notaB, Accidentals alteracionB)
    {
        cargaNotas();
        NoteEquivalente a=new NoteEquivalente(notaA, alteracionA, notaB, alteracionB);
        NoteEquivalente b=new NoteEquivalente(notaB, alteracionB, notaA, alteracionA);
/*
        boolean mismoSonido=false;
        for (int i=0; i<notasEquivalentes.size(); i++)
        {
            if(notasEquivalentes.)
        }*/

        if (notasEquivalentes.contains(a)) return(true);
        else return(notasEquivalentes.contains(b));
    }

    private static void cargaNotas()
    {
        notasEquivalentes.add(new NoteEquivalente(Notes.DO, Accidentals.SHARP,Notes.RE, Accidentals.FLAT));
        notasEquivalentes.add(new NoteEquivalente(Notes.RE, Accidentals.SHARP,Notes.MI, Accidentals.FLAT));
        notasEquivalentes.add(new NoteEquivalente(Notes.MI, Accidentals.NATURAL,Notes.FA, Accidentals.FLAT));
        notasEquivalentes.add(new NoteEquivalente(Notes.MI, Accidentals.SHARP,Notes.FA, Accidentals.NATURAL));
        notasEquivalentes.add(new NoteEquivalente(Notes.FA, Accidentals.SHARP,Notes.SOL, Accidentals.FLAT));
        notasEquivalentes.add(new NoteEquivalente(Notes.SOL, Accidentals.SHARP,Notes.LA, Accidentals.FLAT));
        notasEquivalentes.add(new NoteEquivalente(Notes.LA, Accidentals.SHARP,Notes.SI, Accidentals.FLAT));
        notasEquivalentes.add(new NoteEquivalente(Notes.SI, Accidentals.NATURAL,Notes.DO, Accidentals.FLAT));
        notasEquivalentes.add(new NoteEquivalente(Notes.SI, Accidentals.SHARP,Notes.DO, Accidentals.NATURAL));
    }

    /*
    public static void prueba()
    {
        System.out.println("inicio prueba");
        System.out.println(sonEquivalentes(Notes.DO, Accidentals.SHARP,Notes.RE, Accidentals.FLAT));
        System.out.println(sonEquivalentes(Notes.FA, Accidentals.SHARP,Notes.RE, Accidentals.FLAT));
        System.out.println(sonEquivalentes(Notes.SOL, Accidentals.SHARP,Notes.LA, Accidentals.FLAT));
        System.out.println(sonEquivalentes(Notes.DO, Accidentals.SHARP,Notes.LA, Accidentals.NATURAL));
        System.out.print(notaEquivalente(new Note(Notes.DO, Accidentals.SHARP, 1.f)).getNote());
        System.out.println(notaEquivalente(new Note(Notes.DO, Accidentals.SHARP, 1.f)).getAccidentals());
        System.out.print(notaEquivalente(new Note(Notes.SOL, Accidentals.NATURAL, 1.f)).getNote());
        System.out.println(notaEquivalente(new Note(Notes.SOL, Accidentals.NATURAL, 1.f)).getAccidentals());
        System.out.println("fin prueba");
    }

    public static Note notaEquivalente(Note nota)
    {
        List<Note> comparadorNotasA = new ArrayList<>();
        List<Note> comparadorNotasB = new ArrayList<>();
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
        Note notaBuscada=new Note(nota.getNote(), nota.getAccidentals(), 1.f);
        if (comparadorNotasA.contains(notaBuscada))
        {
            return(comparadorNotasB.get(comparadorNotasA.indexOf(notaBuscada)));
        }
        else return(nota);
    }
*/
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteEquivalente that = (NoteEquivalente) o;
        return notaA == that.notaA && alteracionA == that.alteracionA && notaB == that.notaB && alteracionB == that.alteracionB;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(notaA, alteracionA, notaB, alteracionB);
    }
}
