package e4;

public class Division extends Operacion
{
    public Division(float... values)
    {
        super(values);
    }


    @Override
    public char signo()
    {
        return '/';
    }

    @Override
    float calculo(float numero1, float numero2) throws ArithmeticException
    {
        if (numero2==0.f) throw new ArithmeticException("division by zero");
        return numero1/numero2;
    }

}
