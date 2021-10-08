package e4;

public class Multiplicacion extends Operacion
{
    public Multiplicacion(float... values)
    {
        super(values);
    }


    @Override
    public float resultado()
    {
        return(numeros[0]);

    }

    @Override
    public char signo()
    {
        return '*';
    }


    @Override
    float calculo(float numero1, float numero2) throws ArithmeticException
    {
        return numero1*numero2;
    }
}
