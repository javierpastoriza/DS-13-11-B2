package e4;

import java.util.ArrayList;
import java.util.List;

public abstract class Operacion
{
    float[] numeros;

    public Operacion(float ... values )
    {
        numeros=values.clone();
    }

    public float[] getNumeros()
    {
        return numeros;
    }

    public float resultado()
    {
        float resultado=0;
        if(numeros.length>0) resultado=(numeros[0]);
        if (numeros.length>1)
        {
            for (int i = 1; i < numeros.length; i++) {
                resultado = calculo(resultado, numeros[i]);
            }
        }
        return (resultado);
    }

    public abstract char signo();

    public static float calculaOperacion(char operation, float numero1, float numero2) throws ArithmeticException
    {
        float resultado=0f;
        switch (operation)
        {
            case '+': resultado=new Suma().calculo(numero1,numero2); break;
            case '-': resultado=new Resta().calculo(numero1,numero2); break;
            case '*': resultado=new Multiplicacion().calculo(numero1,numero2); break;
            case '/': resultado=new Division().calculo(numero1,numero2); break;
            default: throw new IllegalArgumentException("La operacion no existe");
        }
        return(resultado);
    }

     abstract float calculo(float numero1, float numero2) throws ArithmeticException;

}
