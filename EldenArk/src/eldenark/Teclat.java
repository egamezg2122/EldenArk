// =============================================================================
// Classe Teclat

// Paquet
package eldenark;

// Imports
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Conté diferents mètodes per llegir dades des del teclat, en funció del tipus 
 * de dada a llegir. Aquesta versió no llença excepcions explícites.
 * Data de creació: 24/08/2020
 * @author José Luis García Mañas
 */
public class Teclat
{
	/**
	 * Llegeix una cadena des del teclat i la retorna.
	 * @return La cadena llegida des del teclat
	 */
	public static String llegirString()
	{
		return new Scanner(System.in).nextLine();
	}

	/**
	 * Llegeix un caràcter des del teclat i el retorna. Si es produeix un error 
	 * perquè allò introduït no és un caràcter, mostra un missatge d'error i 
	 * retorna el caràcter ASCII 0.
	 * @return El caràcter llegit des del teclat
	 */
	public static char llegirChar()
	{
		// Inicialitzem el caràcter a caràcter buit. Si es produeix algun error,
		// es retornarà aquest valor
		char c = 0;

		// Si no es produeix cap error, es retornarà el caràcter llegit
		String s = llegirString();

		// Controlem que el que s'ha llegit és un caràcter
		if(s.length() == 1)
		{
			c = s.charAt(0);
		}
		else
		{
			System.err.println("La dada introduïda no és un caràcter.");
		}

		return c;
	}

	/**
	 * Llegeix un número enter (short) des del teclat i el retorna.
	 * @return El número enter (short) llegit des del teclat
	 */
	public static short llegirShort()
	{
		return new Scanner(System.in).nextShort();
	}

	/**
	 * Llegeix un número enter des del teclat i el retorna.
	 * @return El número enter llegit des del teclat
	 */
	public static int llegirInt()
	{
		return new Scanner(System.in).nextInt();
	}

	/**
	 * Llegeix un número enter (long) des del teclat i el retorna.
	 * @return El número enter (long) llegit des del teclat
	 */
	public static long llegirLong()
	{
		return new Scanner(System.in).nextLong();
	}

	/**
	 * Llegeix un número enter (BigInteger) des del teclat i el retorna.
	 * @return El número enter (BigInteger) llegit des del teclat
	 */
	public static BigInteger llegirBigInteger()
	{
		return new Scanner(System.in).nextBigInteger();
	}

	/**
	 * Llegeix un número real (float) des del teclat i el retorna. 
	 * @return El número real (float) llegit des del teclat
	 */
	public static float llegirFloat()
	{
		return new Scanner(System.in).nextFloat();
	}

	/**
	 * Llegeix un número real (double) des del teclat i el retorna. 
	 * @return El número real (double) llegit des del teclat
	 */
	public static double llegirDouble()
	{
		return new Scanner(System.in).nextDouble();
	}

	/**
	 * Llegeix un número real (BigDecimal) des del teclat i el retorna. 
	 * @return El número real (BigDecimal) llegit des del teclat
	 */
	public static BigDecimal llegirBigDecimal()
	{
		return new Scanner(System.in).nextBigDecimal();
	}

	/**
	 * Llegeix un valor booleà des del teclat i el retorna. 
	 * @return El valor booleà llegit des del teclat
	 */
	public static boolean llegirBoolean()
	{
		return new Scanner(System.in).nextBoolean();
	}
}
// =============================================================================
