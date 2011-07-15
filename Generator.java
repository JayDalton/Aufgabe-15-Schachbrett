/*############################################################################
  Kodierung: UTF-8 ohne BOM - öäüß
############################################################################*/

//############################################################################
/** Die Klasse Generator dient der Generierung einzelner Zahlen, Symbole und
  * Listen.
  *
  * @author Thomas Gerlach
*/
//############################################################################
public class Generator
{
  private int intMin;
  
  private int intMax;
  
  private long lngMin;
  
  private long lngMax;
  
  private double dblMin;
  
  private double dblMax;
  
  private String strMin;
  
  private String strMax;
  
  //##########################################################################
  /** 
  */
  //##########################################################################
	public Generator()
  {
    intMin = 0;
    intMax = 1;
    lngMin = 0;
    lngMax = 1;
    dblMin = 0;
    dblMax = 1;
    strMin = new String("a");
    strMax = new String("b");
  }
  
  //##########################################################################
  /** 
  */
  //##########################################################################
	public Generator(int minimum, int maximum)
  {
    intMin = minimum;
    intMax = maximum;
    if (intMin > intMax)
    {
      int temp = intMin;
      intMin = intMax;
      intMax = temp;
    }
  }
  
  //##########################################################################
  /** 
  */
  //##########################################################################
	public Generator(long minimum, long maximum)
  {
    lngMin = minimum;
    lngMax = maximum;
    if (lngMin > lngMax)
    {
      long temp = lngMin;
      lngMin = lngMax;
      lngMax = temp;
    }
  }
  
  //##########################################################################
  /**
  */
  //##########################################################################
	public Generator(double minimum, double maximum)
  {
    dblMin = minimum;
    dblMax = maximum;
    if (dblMin > dblMax)
    {
      double temp = dblMin;
      dblMin = dblMax;
      dblMax = temp;
    }
  }
  
  //##########################################################################
  /** Erzeugt und liefert eine Ganzzahl im Wertebereich der Attribute min und max
    *
    * @return Generierte Ganzzahl
  */
  //##########################################################################
	public int ganzzahl()
  {
    return ganzzahl(intMin, intMax);
  }

  //##########################################################################
  /** Erzeugt und liefert eine Ganzzahl im Wertebereich von min und max
    *
    * @param min Untere Grenze des Wertebereich
    * @param max Obere Grenze des Wertebereich
    *
    * @return Generierte Ganzzahl
  */
  //##########################################################################
	public static int ganzzahl(int min, int max)
  {
    return min + (int)Math.floor(Math.random() * (max - min + 1));
  }

  //##########################################################################
  /** Erzeugt und liefert eine Ganzzahl im Wertebereich der Attribute min und max
    *
    * @return Generierte Ganzzahl
  */
  //##########################################################################
	public long langzahl()
  {
    return langzahl(lngMin, lngMax);
  }

  //##########################################################################
  /** Erzeugt und liefert eine Ganzzahl im Wertebereich der Attribute min und max
    *
    * @return Generierte Ganzzahl
  */
  //##########################################################################
	public static long langzahl(long min, long max)
  {
    return min + (long)Math.floor(Math.random() * (max - min + 1));
  }

  //##########################################################################
  /** Erzeugt und liefert eine Liste von Ganzzahlen im Wertebereich von den 
    * Attributen min und max
    *
    * @param anzahl Anzahl der Elemente der zu generierenden Liste
    *
    * @return Generierte Liste mit Ganzzahlen
  */
  //##########################################################################
  public int[] listeGanzzahl(int anzahl)
  {
    return listeGanzzahl(anzahl, intMin, intMax);
  }
  
  //##########################################################################
  /** Erzeugt und liefert eine Liste von Ganzzahlen im Wertebereich von min und max
    *
    * @param anzahl Anzahl der Elemente der zu generierenden Liste
    * @param min Untere Grenze des Wertebereich
    * @param max Obere Grenze des Wertebereich
    *
    * @return Generierte Liste mit Ganzzahlen
  */
  //##########################################################################
  public int[] listeGanzzahl(int anzahl, int min, int max)
  {
    int[] ergebnis = new int[anzahl];
    for (int i = 0; i < anzahl; i++)
    {
      ergebnis[i] = ganzzahl(min, max);
    }
    return ergebnis;
  }

  //##########################################################################
  /** Erzeugt und liefert eine Gleitzahl im Wertebereich der Attribute min und max
    *
    * @return Generierte Gleitzahl
  */
  //##########################################################################
	public double gleitzahl()
  {
    return gleitzahl(dblMin, dblMax);
  }

  //##########################################################################
  /** Erzeugt und liefert eine Gleitzahl im Wertebereich von min und max
    *
    * @param min Untere Grenze des Wertebereich
    * @param max Obere Grenze des Wertebereich
    *
    * @return Generierte Gleitzahl
  */
  //##########################################################################
	public static double gleitzahl(double min, double max)
  {
    return Math.random() * (max - min) + min;
  }

  //##########################################################################
  /** Erzeugt und liefert eine Liste von Gleitzahlen im Wertebereich der 
    * Attribute min und max
    *
    * @param anzahl Anzahl der Elemente der zu generierenden Liste
    *
    * @return Generierte Liste mit Gleitzahlen
  */
  //##########################################################################
  public double[] listeGleitzahl(int anzahl)
  {
    return listeGleitzahl(anzahl, dblMin, dblMax);
  }
  
  //##########################################################################
  /** Erzeugt und liefert eine Liste von Gleitzahlen im Wertebereich von min und max
    *
    * @param anzahl Anzahl der Elemente der zu generierenden Liste
    * @param min Untere Grenze des Wertebereich
    * @param max Obere Grenze des Wertebereich
    *
    * @return Generierte Liste mit Gleitzahlen
  */
  //##########################################################################
  public double[] listeGleitzahl(int anzahl, double min, double max)
  {
    double[] ergebnis = new double[anzahl];
    for (int i = 0; i < anzahl; i++)
    {
      ergebnis[i] = gleitzahl(min, max);
    }
    return ergebnis;
  }

  //##########################################################################
  /** Erzeugt und liefert eine Liste von Ganzzahlen im Wertebereich von min und max
    * als Zeichenkette
    *
    * @param anzahl Anzahl der Elemente der zu generierenden Liste
    * @param min Untere Grenze des Wertebereich
    * @param max Obere Grenze des Wertebereich
    *
    * @return Generierte Liste mit Symbolen
  */
  //##########################################################################
	public String symboleGanzzahl(int anzahl, int min, int max)
  {
    String ergebnis = new String();
    while (ergebnis.length() < anzahl)
    {
      ergebnis += ganzzahl(min, max);
    }
    return ergebnis;
  }

  //##########################################################################
  /** Erzeugt und liefert eine Liste von Ganzzahlen im Wertebereich von min und max
    * als Zeichenkette deren Elemente einmalig sind
    *
    * @param anzahl Anzahl der Elemente der zu generierenden Liste
    *
    * @return Generierte Liste mit Symbolen
  */
  //##########################################################################
	public String symboleGanzzahlUnikat(int anzahl)
  {
    String ergebnis = new String();
    Integer ziffer = 0;

    while (ergebnis.length() < anzahl)
    {
      ziffer = ganzzahl(0, 9);
      if (!ergebnis.contains(ziffer.toString()))
      {
        ergebnis += ziffer;
      }
    }

    return ergebnis; 
  }  

  //##########################################################################
  /** Erzeugt und liefert ein Symbol im Wertebereich von min und max
    * als Zeichenkette 
    *
    * @param minimum Untere Grenze des Symbol
    * @param maximum Obere Grenze des Symbol
    *
    * @return Generierte Zeichenkette mit einem Symbol
  */
  //##########################################################################
	public static String symbol(String minimum, String maximum)
  {
    return new String().format("%c", ganzzahl(minimum.codePointAt(0), maximum.codePointAt(0)));
  }  

  //##########################################################################
  /** Erzeugt und liefert eine Liste von Symbolenim Wertebereich von min und max
    * als Zeichenkette 
    *
    * @param anzahl Anzahl der Symbole
    * @param minimum Untere Grenze des Symbol
    * @param maximum Obere Grenze des Symbol
    *
    * @return Generierte Zeichenkette mit einem Symbol
  */
  //##########################################################################
	public static String symbole(int anzahl, String minimum, String maximum)
  {
    String ergebnis = new String();
    for (int i = 0; i < anzahl; i++)
    {
      ergebnis += symbol(minimum, maximum);
    }
    return ergebnis;
  }

}