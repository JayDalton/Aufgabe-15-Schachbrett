/*############################################################################
  Kodierung: UTF-8 ohne BOM - üöä
############################################################################*/

//############################################################################
/** Repräsentiert eine SpielFigur im Spiel 'SchachJagd'
  *
  * @author Thomas Gerlach
*/
//############################################################################
public class SpielFigurTurm extends SpielFigur
{
  //##########################################################################
  /** Konstruiert eine SpielFigur Turm mit Namen, Position und möglichen 
    * Bewegungsrichtungen
  */
  //##########################################################################
	public SpielFigurTurm()
  {
    super("Turm", "A1");
    orient = new String[]{"-", "|"};
  }

  //##########################################################################
  /** Konstruiert eine SpielFigur Turm mit übergebenen Werten für Name, Position 
    * und möglichen Bewegungsrichtungen
  */
  //##########################################################################
  public SpielFigurTurm(String derName, String position)
  {
    super(derName, position);
    orient = new String[]{"-", "|"};
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
      if (xPosition == xBeute) {
        ergebnis = true;
      }
      if (yPosition == yBeute) {
        ergebnis = true;
      }
    }
    return ergebnis;
  }
}
