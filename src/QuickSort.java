
/**
 * CLase que va a implementar el Ordenamiento Rápido de un arrrayList.
 */

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
//import java.util.Iterator;
import java.util.Random;


import org.junit.Test;

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

    @Test
    public void testOrdenar(){
        
        Random rand = new Random(System.nanoTime() % Integer.MAX_VALUE);

        ArrayList<Integer> dePrueba = new ArrayList<>();

        for (int i=0 ; i < rand.nextInt(100); i++){
            dePrueba.add(rand.nextInt(100));
        }
        System.out.println("Arreglo Original.");
        System.out.println(dePrueba.toString());

        ArrayList<Integer> original = new ArrayList<>(dePrueba);
        original.sort(null);
        
        QuickSort.ordenar(dePrueba);

        System.out.println("Arreglo Ordenado");

        System.out.println(dePrueba.toString());

        assertEquals(original, dePrueba);
    }

}