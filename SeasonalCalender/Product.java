
/**
 * Write a description of class Product here.
 *
 * @author Gedeon, Reinhold
 * @version 08.12.2020
 */
public class Product
{
    /**
     * String mit dem Namen des Produkts
     */
    private String name;
    
    /**
     * Boolean Array mit true wenn Produkt im jeweiligen Monat regional verfügbar ist.
     */
    private boolean[] regional = new boolean[12];
    
    /**
     * Boolean Array mit true wenn Produkt im jeweiligen Monat importiert werden kann.
     */
    private boolean[] importware = new boolean[12];
    
    
    /**
     * Konstruktor 1
     * @param name Name des Produkts
     * @param regional Array mit true wenn Produkt im jeweiligen Monat regional verfügbar ist.
     * @param importware Array mit true wenn Produkt im jeweiligen Monat importiert werden kann.
     */
    private Product(String name, boolean[] regional, boolean[] importware){
        this.name = name;
        this.regional = regional;
        this.importware = importware;
    }
    
    
    /**
     * Konstruktor 2
     * @param name Name des Produkts
     * @param reg Array mit 1 wenn Produkt in dem Monat regional verfügbar ist, sonst 0.
     * @param imp Array mit 1 wenn Produkt in dem Monat importiert werden kann, sonst 0.
     */
    public Product(String name, String reg, String imp){
        this.name = name;
        this.regional = BooleanStringHelper.parse(reg, '1');
        this.importware = BooleanStringHelper.parse(imp, '1');
        
        //return new Product(this.name, this.regional, this.importware);
    }
    
    /**
     * Getter Methode um den Namen des Produkts zu bekommen.
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Gibt einen String zurück mit R, falls das Produkt in dem jeweiligen Monat regional verfügbar ist.
     */
    public String stringifyIsRegional(){
        return BooleanStringHelper.stringify(this.regional, 'R', ' ');
    }
    
    /**
     * Gibt einen String zurück mit I, falls das Produkt in dem jeweiligen Monat importiert werden kann.
     */
    public String stringifyIsImported(){
        return BooleanStringHelper.stringify(this.importware, 'I', ' ');
    }
    
}
