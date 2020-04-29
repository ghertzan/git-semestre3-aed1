/**
 * CLase que va a implementar el Ordenamiento Rápido de un arrrayList.
 */
import java.util.ArrayList;

public class QuickSort{

    public static void ordenar(ArrayList<Integer> items){

        if(items.size() > 1){
            ArrayList<Integer> menores = new ArrayList<>();
            ArrayList<Integer> mayores = new ArrayList<>();
            ArrayList<Integer> iguales = new ArrayList<>();

            int pivote = items.get(items.size()-1); 

            for (Integer i : items) {
                if(i.intValue() < pivote){
                    menores.add(i);
                }else if( i.intValue() > pivote){
                    mayores.add(i);
                }else{
                    iguales.add(i);
                }
            }
            ordenar(menores);
            ordenar(mayores);

            items.clear();
            items.addAll(menores);
            items.addAll(iguales);
            items.addAll(mayores);
        }
    }

}