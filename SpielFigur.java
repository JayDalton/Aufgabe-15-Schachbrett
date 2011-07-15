/*############################################################################
  Kodierung: UTF-8 ohne BOM - üöä
############################################################################*/

//############################################################################
/** Repräsentiert Verkauf von Zeitungen eines Verlages
  *
  * @author Thomas Gerlach
*/
//############################################################################
public class SpielFigur
{
  /** der Name der Figur */
  String name;

  /** die Position der Figur auf der x-Achse */
  int xPosition;

  /** die Position der Figur auf der y-Achse */
  int yPosition;

  /** die Schrittzahl der Figur entlang der Richtung */
  int nSchritte;

  /** die Richtung eines Zuges */
  String richtung;

  /** alle möglichen Richtungen der Figur */
  String[] orient;
  
  //##########################################################################
  /** Konstruiert eine Figur mit gegebenem Namen und Position
  */
  //##########################################################################
	public SpielFigur()
  {
    name = "Figur";
    setPosition("A1");
    orient = new String[]{"-", "|", "/", "\\\\"};
  }

  //##########################################################################
  /** Konstruiert eine Figur mit übergebenem Namen und Position
    *
    * @param derName Name der Figur als Zeichenkette
    * @param diePosition Position der Figur als Zeichenkette
  */
  //##########################################################################
	public SpielFigur(String derName, String diePosition)
  {
    name = derName;
    setPosition(diePosition);
    orient = new String[]{"-", "|", "/", "\\\\"};
  }

  //##########################################################################
  /** Liefert den Namen der Figur
    *
    * @return Name der Figur
  */
  //##########################################################################
  public String getName()
  {
    return name;
  }
  
  //##########################################################################
  /** Liefert die Position der Figur als Zeichenkette
    *
    * @return Position als Zeichenkette
  */
  //##########################################################################
  public String getPosition()
  {
    return String.format("%c%d", xPosition + 65, yPosition + 1);
  }
  
  //##########################################################################
  /** Setzt die Position der Figur und liefert den Erfolg davon
    *
    * @param position Position als Zeichenkette
    *
    * @return Ergebnis als Wahrheitswert
  */
  //##########################################################################
  public boolean setPosition(String position)
  {
    boolean ergebnis = false;

    if (position.length() == 2) {
      xPosition = position.codePointAt(0) - 65;
      yPosition = Integer.parseInt(position.substring(1, 2)) - 1;
      ergebnis = true;
    }

    return ergebnis;
  }
  
  //##########################################################################
  /** Stellt die Positionen der Figur auf dem Feld grafisch dar.
  */
  //##########################################################################
  public void zeigen()
  {
    System.out.format("\n\n   A  B  C  D  E  F  G  H ");
    for (int i = 0; i < 8; i++)
    {
      System.out.format("\n%d ", i + 1);
      for (int j = 0; j < 8; j++)
      {
        System.out.format(j == xPosition && i == yPosition ? " # " : " - ");
      }
    }
    System.out.format("\n");
  }

  //##########################################################################
  /** Positioniert anhand abgefragter Werte die Figur an eine neue Stelle
  */
  //##########################################################################
	public void ziehen()
  {
    richtung = Eingabe.symbole("Wie wollen Sie ziehen (" + Listen.format(orient, ", ") + ")?: ", 1, "[" + Listen.format(orient, "") + "]");

    switch (richtung.codePointAt(0)) {
      case 45:  // -
        nSchritte = Eingabe.ganzzahl("Wie viele Felder (-7 <= links < 0 < rechts < +7): ", -7, 7);
        xPosition += nSchritte;
        break;
      case 124: // |
        nSchritte = Eingabe.ganzzahl("Wie viele Felder (-7 <= hoch < 0 < runter < +7): ", -7, 7);
        yPosition += nSchritte;
        break;
      case 47:  // /
        nSchritte = Eingabe.ganzzahl("Wie viele Felder (-7 <= links unten < 0 < rechts oben < +7): ", -7, 7);
        xPosition += nSchritte;
        yPosition -= nSchritte;
        break;
      case 92:  // \
        nSchritte = Eingabe.ganzzahl("Wie viele Felder (-7 <= links oben < 0 < rechts unten < +7): ", -7, 7);
        xPosition += nSchritte;
        yPosition += nSchritte;
        break;
    }
  }

  //##########################################################################
  /** 
  */
  //##########################################################################
  public void testen()
  {
    if (!(0 <= xPosition && xPosition <= 7) || !(0 <= yPosition && yPosition <= 7))
    {
      int xDiv = 0;
      int yDiv = 0;

      // unten rechts
      if (7 < xPosition && 7 < yPosition) {
        xDiv = 7 - xPosition;
        yDiv = 7 - yPosition;
        xPosition += Math.abs(xDiv) < Math.abs(yDiv) ? yDiv : xDiv ;
        yPosition += Math.abs(xDiv) < Math.abs(yDiv) ? yDiv : xDiv ;
      }
      // oben links
      if (xPosition < 0 && yPosition < 0) {
        xDiv = 0 - xPosition;
        yDiv = 0 - yPosition;
        xPosition += Math.abs(xDiv) < Math.abs(yDiv) ? yDiv : xDiv ;
        yPosition += Math.abs(xDiv) < Math.abs(yDiv) ? yDiv : xDiv ;
      }
      // unten links
      if (xPosition < 0 && 7 < yPosition) {
        xDiv = 0 - xPosition;
        yDiv = 7 - yPosition;
        xPosition += Math.abs(xDiv) < Math.abs(yDiv) ? yDiv : xDiv ;
        yPosition -= Math.abs(xDiv) < Math.abs(yDiv) ? yDiv : xDiv ;
      }
      // oben rechts
      if (7 < xPosition && yPosition < 0) {
        xDiv = 7 - xPosition;
        yDiv = 0 - yPosition;
        xPosition -= Math.abs(xDiv) < Math.abs(yDiv) ? yDiv : xDiv ;
        yPosition += Math.abs(xDiv) < Math.abs(yDiv) ? yDiv : xDiv ;
      }
      // oben mitte
      if (0 <= xPosition && xPosition < 8 && yPosition < 0) {
        if (richtung.contains("|")) {
          yPosition = 0;
        }
        if (richtung.contains("/")) {
          xPosition -= 0 - yPosition;
          yPosition = 0;
        }
        if (richtung.contains("\\")) {
          xPosition += 0 - yPosition;
          yPosition = 0;
        }
      }
      // unten mitte
      if (0 <= xPosition && xPosition < 8 && 7 < yPosition) {
        if (richtung.contains("|")) {
          yPosition = 7;
        }
        if (richtung.contains("/")) {
          xPosition -= 7 - yPosition;
          yPosition = 7;
        }
        if (richtung.contains("\\")) {
          xPosition += 7 - yPosition;
          yPosition = 7;
        }
      }
      // links (mitte)
      if (0 <= yPosition && yPosition < 8 && xPosition < 0) {
        if (richtung.contains("-")) {
          xPosition = 0;
        }
        if (richtung.contains("/")) {
          yPosition -= 0 - xPosition;
          xPosition = 0;
        }
        if (richtung.contains("\\")) {
          yPosition += 0 - xPosition;
          xPosition = 0;
        }
      }
      // rechts (mitte)
      if (0 <= yPosition && yPosition < 8 && 7 < xPosition) {
        if (richtung.contains("-")) {
          xPosition = 7;
        }
        if (richtung.contains("/")) {
          yPosition += xPosition - 7;
          xPosition = 7;
        }
        if (richtung.contains("\\")) {
          yPosition -= xPosition - 7;
          xPosition = 7;
        }
      }
    }
  }

  //##########################################################################
  /** Prüft anhand der eigenen Position die Möglichkeit eines Treffers der Beute
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
      if (Math.abs(xPosition - xBeute) == Math.abs(yPosition - yBeute)) {
        ergebnis = true;
      }
    }
    return ergebnis;
  }
}
