/**
 * @author (Gedeon Vogt)
 */
public class ZinsRechner
{
    public static void main(String[] args){
        // Initialisierung der Variablen
        double startBetrag = SimpleIO.getDouble ("Bitte geben Sie den Startbetrag ein.");
        double zinssatz = SimpleIO.getDouble ("Bitte geben Sie den Zinssatz als Prozentwert ein.");
        String auswahl = SimpleIO.getString ("Ziel: Berechnet die Zeit, bis ein gegebener Betrag angespart wurde.\nZeit: Berechnet den Betrag, der nach einer gegebenen Zeit angespart wurde.");
        
        // Bedingte Anweisung die vom Input des Users abhängt
        if (auswahl.equals("Ziel")){
            // Ziel: berechnet, wie lange es dauert bis ein bestimmter Betrag erreicht ist.
            double zielBetrag = SimpleIO.getDouble("Bitte geben Sie den Zielbetrag ein.");
            double betrag = startBetrag;
            int dauer = 0;
            
            while (betrag < zielBetrag) {
                betrag *= 1 + (zinssatz/100);
                dauer++;
            }
            
            // Antwort
            String antwort = "Es dauert " + dauer + " Jahre bei einem Zinssatz von " + zinssatz + 
                                "%, um von " + startBetrag + " auf den Betrag " + zielBetrag + 
                                " zu sparen. Nach dieser Zeit hat man " + round(betrag,2) + ".";
            System.out.println(antwort);
        } 
        
        else if (auswahl.equals("Zeit")){   
            // Zeit: berechnet den Betrag, nach einer bestimmten Anzahl an Jahren
            int zielJahr = SimpleIO.getInt("Bitte geben Sie die Anzahl der Jahre ein.");
            double endBetrag = startBetrag;
            
            for(int i = 0; i < zielJahr; i++){
                endBetrag *= 1 + (zinssatz/100);
            }
            
            //Antwort
            String antwort = "Nach " + String.valueOf(zielJahr) + " Jahren, bei einem Zinssatz von " + String.valueOf(zinssatz) + 
                             "% und einem Startbetrag von " + String.valueOf(startBetrag) + ", kommt man auf einen Betrag von " + 
                             String.valueOf(round(endBetrag, 2)) + ".";
            System.out.println(antwort);
        }
        
        else {
            SimpleIO.output("Falsche Eingabe", "Fehler"); // Das statt print
            System.out.println("Sie haben eine falsche Eingabe getätigt. Das Programm wird nun abgebrochen.");
            System.exit(1);
        }
    }
    
    // Funktion um ein Double auf zwei Nachkommastellen zu runden. Quelle: stackoverflow
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
    
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}