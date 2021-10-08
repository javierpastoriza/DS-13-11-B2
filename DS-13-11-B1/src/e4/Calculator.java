package e4;

import java.util.ArrayList;
import java.util.List;

public class Calculator
{
    List <Operacion> operaciones;
    /**
     * Public constructor of the calculator .
     */
    public Calculator ()
    {
        operaciones=new ArrayList<>();
    }
    /**
     * Clean the internal state of the calculator
     */
    public void cleanOperations ()
    {
        operaciones.clear();
    }
    /**
     * Add a new operation to the internal state of the calculator .
     * It is worth mentioning that the calculator behaves in an accumulative way ,
     * thus only first operation has two operands .
     * The rest of computations work with the accumulated value and only an extra
     * new operand . Second input value must be ignored if the operation does not
     * correspond to the first one .
     *
     * @param operation operation to add , as string , "+" , " -" , "*" , "/".
     * @param values
    Operands of the new operation ( one or two operands ).
     *
    Uses the varargs feature .
     * https://docs.oracle.com/javase/8/docs/technotes/guides/language/varargs.html
     * @throws IllegalArgumentException If the operation does not exist .
     */
    public void addOperation (String operation , float ... values ) throws IllegalArgumentException
    {
        switch (operation.charAt(0))
        {
            case '+': operaciones.add(new Suma(values)); break;
            case '-': operaciones.add(new Resta(values)); break;
            case '*': operaciones.add(new Multiplicacion(values[0])); break;
            case '/': operaciones.add(new Division(values)); break;
            default: throw new IllegalArgumentException("La operacion no existe");
        }
    }
    /**
     * Execute the set of operations of the internal state of the calculator .
     * Once execution is finished , internal state ( operands and operations )
     * is restored ( EVEN if exception occurs ).
     * This calculator works with " Batches " of operations .
     * @return result of the execution
     * @throws ArithmeticException If the operation returns an invalid value
     *
    ( division by zero )
     */
    public float executeOperations () throws ArithmeticException
    {
        float resultado = 0;
        try
        {

            if (!operaciones.isEmpty())
            {
                if (operaciones.get(0).numeros.length>1) resultado = operaciones.get(0).resultado();
                else resultado = operaciones.get(0).numeros[0];
                System.out.println("Resultado="+resultado);
                System.out.println("Operaciones="+operaciones.get(0).numeros.length);
                if (operaciones.size() > 0)
                {

                    for (int i = 1; i < operaciones.size(); i++)
                    {
                        System.out.println("BREAK POINT");
                        System.out.println("Numero1="+resultado+"      Numero2="+operaciones.get(i).resultado());
                            resultado = Operacion.calculaOperacion(operaciones.get(i).signo(), resultado, operaciones.get(i).resultado());
                    }
                }
            }
        }
        finally
        {
            this.cleanOperations();
        }
        return(resultado);
    }
    /**
     * Current internal state of calculator is printed
     * FORMAT :
     * "[{+/ -/"/"/*}] value1_value2 [{+/ -/"/"/*}] value1 [{+/ -/"/"/*}] value1 {...}"
     * EXAMPLES : JUnit tests
     * @return String of the internal state of the calculator
     */
    @Override
    public String toString ()
    {
        String cadena = "[STATE:";
        if (!this.operaciones.isEmpty())
        {
            int i = 0;
            float[] numeros;
            do {
                numeros = operaciones.get(i).getNumeros();
                if (numeros.length > 0)
                {
                    cadena = cadena + "[" + operaciones.get(i).signo() + "]";
                    cadena = cadena+Float.toString(numeros[0]);
                    if (numeros.length > 1) {
                        for (int j = 1; j < numeros.length; j++) {
                            cadena = cadena+"_"+Float.toString(numeros[j]);
                        }
                    }
                }
                i++;
            }
            while (i < operaciones.size());
        }
        cadena = cadena + "]";
        return(cadena);
    }
}
