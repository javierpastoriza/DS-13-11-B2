package e2;

public class Slopes
{
    /**
     * Traverses the slope map making the right and down movements and
     * returns the number of trees found along the way .
     * @param slopeMap A square matrix representing the slope with spaces
     *
    represented as "." and trees represented as "#".
     * @param right Movement to the right
     * @param down Downward movement
     * @return Number of trees
     * @throws I l l e g a l A r g u m e n t E x c e p t i o n if the matrix is incorrect because :
     *
    - It is not square .
     *
    - It has characters other than "." and "#"
     *
    - right >= number of columns or right < 1
     *
    - down >= number of rows of the matrix or down < 1
     */
    public static int downTheSlope ( char [][] slopeMap , int right , int down ) throws IllegalArgumentException
    {
        if (excepciones(slopeMap, right, down)) throw new IllegalArgumentException("Mapa no valido");
        int contador=0;
        int fila=0;
        int columna=0;
        //while (fila<nFilas(slopeMap))
        while (fila<nFilas(slopeMap))
        {
            contador=contador+cuentaArboles(slopeMap, fila, columna, right, down);
            fila=fila+down;
            columna=(columna+right)%nColumnas(slopeMap);
            //System.out.println("contador="+contador+"    fila="+fila+"    columna="+columna);
        }

        return(contador);
    }
    /**
     * Traverses the slope map making the right and down movements and
     * returns the number of trees found along the way .
     * Since it " jumps " from the initial position to the final position ,
     * only takes into account the trees on those initial / final positions .
     *
     * Params , return value and thrown expections as in downTheSlope ...
     */
    public static int jumpTheSlope ( char [][] slopeMap , int right , int down ) throws IllegalArgumentException
    {
        if (excepciones(slopeMap, right, down)) throw new IllegalArgumentException("Mapa no valido");
        int contador=0;
        int fila=0;
        int columna=0;
        while ((fila)<nFilas(slopeMap))
        {
            if(slopeMap[fila][columna]=='#') contador++;
            fila=fila+down;
            columna=(columna+right)%nColumnas(slopeMap);
        }
        return(contador);
    }

    private static int nFilas (char [][] slopeMap)
    {
        return(slopeMap.length);
    }

    private static int nColumnas (char [][] slopeMap)
    {
        return(slopeMap[0].length);
    }

    private static int cuentaArboles (char [][] slopeMap, int fila, int columna , int right , int down )
    {
        int contador=0;
        int nFil=nFilas(slopeMap);
        int nCol=nColumnas(slopeMap);
        for(int i=0; i<right; i++)
        {
            if (slopeMap[fila][(columna+i)%nCol]=='#') contador++;
        }
        int i=0;
        while((i<down) && ((fila+i)<nFil))
        {
            //System.out.println("Fila="+(fila+i)+"\tFilasTOT="+nFil+"\tCond="+((fila+i)<nFil));
            if (slopeMap[fila+i][(columna+right)%nCol]=='#') contador++;
            i++;
            //System.out.println("condicion="+((i<down) && ((fila+i)>nFil))+"   "+ (i<down)+"    "+ ((fila+i)>nFil)+ "   "+i+"    "+(fila+i));
        }
        return (contador);
    }


    public static boolean excepcionesMapa(char [][] slopeMap)
    {
        if(!(nColumnas(slopeMap)==nFilas(slopeMap))) return(true);
        else
        {
            boolean mapaIncorrecto = false;
            try
            {
                for (int i = 0; i < nFilas(slopeMap); i++) {
                    for (int j = 0; j < nColumnas(slopeMap); j++) {
                        if (slopeMap[i][j] == ('.')) {
                        } else {
                            if (slopeMap[i][j] == ('#')) {
                            } else return (true);
                        }
                    }
                }
            }
            catch (ArrayIndexOutOfBoundsException aio)
            {
                return(true);
            }
            return(mapaIncorrecto);
        }
    }

    private static boolean excepciones ( char [][] slopeMap , int right , int down )
    {
        if (excepcionesMapa(slopeMap)) return(true);
        else
        {
            if (right<0 || right>=nColumnas(slopeMap)) return(true);
            else
            {
                if (down<0 || down>=nFilas(slopeMap)) return(true);
                else return(false);
            }
        }
    }
}
