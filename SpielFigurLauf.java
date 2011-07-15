/*############################################################################
  Kodierung: UTF-8 ohne BOM - üöä
############################################################################*/

//############################################################################
/** Repräsentiert eine SpielFigur im Spiel 'SchachJagd'
  *
  * @author Thomas Gerlach
*/
//############################################################################
public class SpielFigurLauf extends SpielFigur
{
  //##########################################################################
  /** Konstruiert eine SpielFigur Läufer mit Namen, Position und möglichen 
    * Bewegungsrichtungen
  */
  //##########################################################################
	public SpielFigurLauf()
  {
    super("Läufer", "A1");
    orient = new String[]{"/", "\\\\"};
  }

  //##########################################################################
  /** Konstruiert eine SpielFigur Läufer mit übergebenen Werten für Name, Position 
    * und möglichen Bewegungsrichtungen
  */
  //##########################################################################
  public SpielFigurLauf(String derName, String position)
  {
    super(derName, position);
    orient = new String[]{"/", "\\\\"};
  }

  //##########################################################################
  /** 
  */
  //##########################################################################
	public boolean treffe(String position)
  {
    boolean ergebnis = false;

    if (position.length() == 2) {
      int xBeute = position.codePointAt(0) - 65;
      int yBeute = Integer.parseInt(position.substring(1, 2)) - 1;
      if (Math.abs(xPosition - xBeute) == Math.abs(yPosition - yBeute)) {
        ergebnis = true;
      }
    }
    return ergebnis;
  }
}
