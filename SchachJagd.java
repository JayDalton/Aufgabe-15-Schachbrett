/*############################################################################
  Kodierung: UTF-8 ohne BOM - üöä
############################################################################*/

import java.util.ArrayList;

//############################################################################
/** Repräsentiert Verkauf von Zeitungen eines Verlages
  *
  * @author Thomas Gerlach
*/
//############################################################################
public class SchachJagd
{
  /** die zu suchende Beute */
  SpielFigur beute;

  /** Liste der Spielfiguren */
  ArrayList<SpielFigur> figuren;
  
  //##########################################################################
  /** Konstruiert ein Spiel und setzt die Beute zufällig
  */
  //##########################################################################
	public SchachJagd()
	{
    beute = new SpielFigur("Beute", posiZufall());
    figuren = new ArrayList<SpielFigur>();
  }

  //##########################################################################
  /** Fordert den Nutzer zur Angabe und Positionierung einer oder mehrerer 
    * Figuren auf.
  */
  //##########################################################################
  public void setPlayer()
  {
    SpielFigur figur = new SpielFigur();
    String auswahl = new String("\nWelche Figur möchten Sie einfügen? : ");
    String ausgabe = new String("\nBitte setzen Sie die Position für %s:");
    
    do {
      switch (Eingabe.auswahl(auswahl, new String[]{"1 Dame", "1 Läufer", "1 Turm"})) {
        case 0:
          figur = new SpielFigurDame("Dame", "A1");
          System.out.format(ausgabe, figur.getName());
          break;
        case 1:
          figur = new SpielFigurLauf("Läufer", "A1");
          System.out.format(ausgabe, figur.getName());
          break;
        case 2:
          figur = new SpielFigurTurm("Turm", "A1");
          System.out.format(ausgabe, figur.getName());
          break;
      }
      figur.setPosition(new String(Eingabe.symbole("Spalte (A - H) : ", 1, "[A-H]") + Eingabe.ganzzahl("Zeile  (1 - 8) : ", 1, 8)));
      figuren.add(figur);
    } while (Eingabe.auswahl("Noch eine Figur? [j/n] ? : ", "j", "n"));
  }

  //##########################################################################
  /** Stellt die Positionen aller Figuren auf dem Feld grafisch dar. Die Typen
    * werden dabei nicht unterschieden.
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
        String feld = new String(" - ");
        for (SpielFigur figur : figuren)
        {
          if (figur.getPosition().contains(String.format("%c%d", j + 65, i + 1))) {
            feld = " # ";
          }
        }
        System.out.format(feld);
      }
    }
    System.out.format("\n");
  }

  //##########################################################################
  /** Durchläuft das Spiel bis die Versuche aufgebraucht oder der Erfolg 
    * eingetreten ist.
  */
  //##########################################################################
  public void spielen()
  {
    boolean erfolg = false;
    
    for (int i = 0; i < 20 && !erfolg; i++)
    {
      zeigen();
      SpielFigur figur = figuren.get(0);
      
      System.out.format("\nDie Figur %s befindet sich im Feld %s.", figur.getName(), figur.getPosition());

      if (figur.getPosition().contains(beute.getPosition())) {
        erfolg = true;
      } else { 
        if (figur.treffe(beute.getPosition())) {
          System.out.format("\nDie Beute kann im nächsten Zug getroffen werden.");
        } else {
          System.out.format("\nDie Beute ist woanders! %s", beute.getPosition());
        }
        System.out.format("\nIhr %d. Zug.", i + 1);
        figur.ziehen();
        figur.testen();
      }
      figuren.add(figuren.remove(0));
    }
    if (erfolg) {
      System.out.format("\n\nHerzlichen Glückwunsch!\n");
      System.out.format("\nDie Beute wurde gefunden!\n");
    } else {
      System.out.format("\n\nDas Spiel ist vorbei...\n");
      System.out.format("\nBeute nicht gefunden... !\n");
    }
  }

  //##########################################################################
  /** Erzeugt eine zufällige Position einer Figur und liefert diese zurück
  */
  //##########################################################################
  public String posiZufall()
  {
    Generator zufall = new Generator();
    return new String(zufall.symbol("A", "H") + zufall.ganzzahl(1, 8));
  }
}


