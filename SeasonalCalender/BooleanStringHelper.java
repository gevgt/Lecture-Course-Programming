
/**
 * Write a description of class BooleanStringHelper here.
 *
 * @author Gedeon, Reinhold
 * @version 08.12.2020
 */
public class BooleanStringHelper
{
    /**
     * Überprüft String und gibt einen Array zurück mit Einträgen true und false. true, wenn Zeichen im String mit dem Übergebenen
     * Parameter übereinstimmt.
     * @param s String
     * @param c Character, mit dem die Zeichen im String verglichen werden sollen
     */
    public static boolean[] parse(String s, char c){
        char[] array = s.toCharArray();
        boolean[] bool = new boolean[array.length];
        Character a = new Character(c);
        for(int i=0; i < array.length; i++){
            if(a.equals(array[i])){
                bool[i] = true;
            }else{
                bool[i] = false;
            }
        }
        return bool;
    }
    
    
    /**
     * Diese Methode erhält ein Array bestehend aus true und false und gibt einen String aus mit jeweils dem ersten Character wenn
     * Eintrag true ist und sonst dem zweiten Character.
     * @param boolean Array mit Einträgen true oder false.
     * @param c_1 Erster Character, der eingesetzt wird, falls Eintrag im Array true ist.
     * @param c_2 Zweiter Character, der eingesetzt wird, falls Eintrag im Array false ist.
     */
    public static String stringify(boolean[] array, char c_1, char c_2){
        char[] ca = new char[array.length];
        
        for(int i=0; i < array.length; i++){
            Boolean b = array[i];
            if(b.equals(true)){
                ca[i] = c_1;
            }else{
                ca[i] = c_2;
            }
        }
        
        Character first = ca[0];
        StringBuilder builder = new StringBuilder(first.toString());
        
        for(int i=1; i < array.length; i++){
            Character following = ca[i];
            builder.append(following.toString());
        }
        
        String result = builder.toString();
        
        return result;
    }
    
}
