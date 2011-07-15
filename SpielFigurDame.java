/*############################################################################
  Kodierung: UTF-8 ohne BOM - üöä
############################################################################*/

//############################################################################
/** Repräsentiert eine SpielFigur im Spiel 'SchachJagd'
  *
  * @author Thomas Gerlach
*/
//############################################################################
public class SpielFigurDame extends SpielFigur
{
  //##########################################################################
  /** Konstruiert eine SpielFigur Dame mit Namen, Position und möglichen 
    * Bewegungsrichtungen
  */
  //##########################################################################
	public SpielFigurDame()
  {
    super("Dame", "A1");
    orient = new String[]{"-", "|", "/", "\\\\"};
  }

  //##########################################################################
  /** Konstruiert eine SpielFigur Dame mit übergebenen Werten für Name, Position 
    * und möglichen Bewegungsrichtungen
  */
  //##########################################################################
  public SpielFigurDame(String derName, String position)
  {
    super(derName, position);
    orient = new String[]{"-", "|", "/", "\\\\"};
  }
}
