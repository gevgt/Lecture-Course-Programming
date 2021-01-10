/**
 * Write a description of class SeasonalCalendar here.
 *
 * @author Gedeon, Reinhold
 * @version 08.12.2020
 */
public class SeasonalCalendar
{
    /**
     * Array mit der Produktpalette.
     */
    Product[] alleProdukte;
    
    
    /**
     * Konstruktor
     * @param alleProdukte Array mit allen Produkten
     */
    public SeasonalCalendar(Product[] alleProdukte){
        this.alleProdukte = alleProdukte;
    }
    
    
    /**
     * Findet das Produkt mit dem laengsten Namen und gibt die Laenge als int zurück.
     */
    public int getLongestProductName(){
        int max = -1;
        for(Product p : this.alleProdukte){
            int nameLaenge = p.getName().toCharArray().length;
            if(nameLaenge > max){
                max = nameLaenge;
            }
        }
        return max;
    }
    
    
    
    /**
     * Fuellt einen String mit beliebigen Fuellzeichen auf, bis eine gewuenschte Laenge des Strings erreicht ist.
     * @param s String der aufgefuellt werden soll.
     * @param p Gewuenschte Laenge des Strings.
     * @param c Gewuenschtes Zeichen mit dem der String aufgefuellt werden soll.
     */
    public static String pad(String s, int p, char c){
        char[] newChar = new char[p];
        char[] sChar = s.toCharArray();
        
        int i = 0;
        for(char sc : sChar){
            newChar[i] = sc;
            i++;
        }
        
        
        for(int j=i; j < p; j++){
            newChar[j] = c;
        }
        
        Character first = newChar[0];
        StringBuilder builder = new StringBuilder(first.toString());
        
        for(int k=1; k < p; k++){
            Character following = newChar[k];
            builder.append(following.toString());
        }
        
        String result = builder.toString();
        
        return result;
    }
    
    
    
    /**
     * Gibt als String den Saisonkalender zurueck.
     */
    public String stringify(){
        StringBuilder builder = new StringBuilder(pad(" ", getLongestProductName()+2, ' '));
        builder.append("JFMAMJJASOND\n");
        
        for(Product p : alleProdukte){
            builder.append(p.getName());
            builder.append(":");
            builder.append(pad("", getLongestProductName()+1 - p.getName().toCharArray().length, ' '));
            builder.append(p.stringifyIsRegional());
            builder.append("\n");
            builder.append(pad(" ", getLongestProductName()+2, ' '));
            builder.append(p.stringifyIsImported());
            builder.append("\n");
        }
        
        String result = builder.toString();
        
        return result;
    }
}




