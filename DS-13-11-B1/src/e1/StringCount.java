package e1;

public class StringCount
{
    /**
     * Counts the number of words in a given String .
     * Words are groups of characters separated by one or more spaces .
     *
     * @param text String with the words
     * @return Number of words in the String or zero if it is null
     */
    public static int countWords ( String text )
    {
        int palabras=0;
        boolean espacioBlanco=false;
        try {
            if (text.isEmpty()) return (palabras);
            else
            {
                if (Character.isWhitespace(text.charAt(0))) palabras=0;
                else palabras=1;
                for (int i = 0; i < text.length(); i++) {
                if (Character.isWhitespace(text.charAt(i)))
                {
                    if (!espacioBlanco)
                    {
                        espacioBlanco=true;
                        palabras++;
                    }
                }
                else espacioBlanco = false;
            }
            if(espacioBlanco) return(palabras-1);
            else return(palabras);
            }
        }
        catch (NullPointerException npe)
        {
            return(palabras);
        }
    }
    /**
     * Counts the number of times the given character appears in the String .
     * Accented characters are considered different characters .
     * @param text String with the characters
     * @param c the character to be found
     * @return Number of times the character appears in the String or zero if null
     */
    public static int countChar ( String text , char c)
    {
        int contador=0;
        try
        {
            for(int i=0; i<text.length(); i++)
            {
                if(c==text.charAt(i)) contador++;
            }
        }
        catch (NullPointerException npe)
        {
            return(contador);
        }
        return(contador);
    }
    /**
     * Counts the number of times the given character appears in the String .
     * The case is ignored so an ’a’ is equal to an ’A ’.
     * Accented characters are considered different characters .
     * @param text String with the characters
     * @param c the character to be found
     * @return Number of times the character appears in the String or zero if null
     */
    public static int countCharIgnoringCase ( String text , char c )
    {
        try
        {
            return (StringCount.countChar(text.toUpperCase(), Character.toUpperCase(c)));
        }
        catch (NullPointerException npe)
        {
            return(0);
        }
    }
    /**
     * Checks if a password is safe according to the following rules :
     * - Has at least 8 characters
     * - Has an uppercase character
     * - Has a lowercase character
     * - Has a digit
     * - Has a special character among these : ’? ’, ’@ ’, ’#’, ’$ ’, ’. ’ and ’,’
     * @param password The password , we assume it is not null .
     * @return true if the password is safe , false otherwise
     */
    public static boolean isPasswordSafe ( String password )
    {
        if (password.length()<8) return(false);
        else
        {
            boolean mayuscula = false;
            boolean minuscula = false;
            boolean digito = false;
            boolean caracterEspecial = false;
            for (int i=0; i<password.length(); i++)
            {
                if(Character.isLetterOrDigit(password.charAt(i))) {
                    if (Character.isUpperCase(password.charAt(i))) mayuscula = true;
                    else {
                        if (Character.isLowerCase(password.charAt(i))) minuscula = true;
                        else
                        {
                            if (Character.isDigit(password.charAt(i))) digito = true;
                        }
                    }
                }
                else caracterEspecial=true;
            }
            return(mayuscula&&minuscula&&digito&&caracterEspecial);
        }
    }
}
