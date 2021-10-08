package e4;

public class Resta extends Operacion
{
    public Resta(float... values)
    {
        super(values);
    }


    @Override
    public char signo()
    {
        return '-';
    }


    @Override
    float calculo(float numero1, float numero2) throws ArithmeticException
    {
        return (numero1-numero2);
    }
}
