package info.androidhive.materialtabs.activity;

import info.androidhive.materialtabs.R;

/**
 * Created by ADMIN on 25/07/2016.
 */

public class Coche {
    private String nombre;
    private int idDrawable;

    public Coche(String nombre, int idDrawable) {
        this.nombre = nombre;
        this.idDrawable = idDrawable;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public int getId() {
        return nombre.hashCode();
    }

    public static Coche[] ITEMS = {
            new Coche("Jaguar F-Type 2015", R.drawable.asistido),
            new Coche("Mercedes AMG-GT", R.drawable.home),
            new Coche("Mazda MX-5", R.drawable.asistido),
            new Coche("Porsche 911 GTS", R.drawable.home),
            new Coche("BMW Serie 6", R.drawable.asistido),
            new Coche("Ford Mondeo", R.drawable.home),
            new Coche("Volvo V60 Cross Country", R.drawable.asistido),
            new Coche("Jaguar XE", R.drawable.home),
            new Coche("VW Golf R Variant", R.drawable.asistido),
            new Coche("Seat León ST Cupra", R.drawable.home),
    };

    /**
     * Obtiene item basado en su identificador
     *
     * @param id identificador
     * @return Coche
     */
    public static Coche getItem(int id) {
        for (Coche item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}