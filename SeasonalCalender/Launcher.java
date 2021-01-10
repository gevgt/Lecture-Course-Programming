/**
 * Write a description of class Launcher here.
 *
 * @author Gedeon, Reinhold
 * @version 08.12.2020
 */
public class Launcher
{
    /**
     * Main Methode
     */
    public static void main(String[] args){
        Product apfel = new Product("Apfel", "111000111000", "101010101010");
        Product birne = new Product("Birne", "111111000111", "000000000001");
        Product tomate = new Product("Tomate", "000011111111", "101010111111");
        
        SeasonalCalendar produkte = new SeasonalCalendar(new Product[] {tomate, birne, apfel});
        String kalendar = produkte.stringify();
        System.out.println(kalendar);
    }
}