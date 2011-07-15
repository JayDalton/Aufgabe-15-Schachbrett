/*############################################################################
  Kodierung: UTF-8 ohne BOM - üöä
############################################################################*/

//############################################################################
/** Steuert den Aufruf und Durchlauf eines Spieles von 'SchachJagd'
  *
  * @author Thomas Gerlach
*/
//############################################################################
public class SchachJagdMain
{
  //##########################################################################
  /** Programmaufruf zum Spiel 'SchachJagd'
  */
  //##########################################################################
	public static void main(String[] args)
	{
    do {

      Ausgabe.leere();
  		Ausgabe.zeile("\n\n\tS p i e l f e l d - J a g d\n\n");
  		Ausgabe.zeile("Jage die Beute ...");
      
      SchachJagd spielfeld = new SchachJagd();
      Ausgabe.zeile("\n... die Beute ist vorhanden");
      
      spielfeld.setPlayer();
      spielfeld.spielen();
                  
    } while (Eingabe.auswahl("Noch einmal spielen [j/n] ? : ", "j", "n"));

    Ausgabe.zeile("\n\n\tAuf Wiedersehen!\n\n");
  }
}


