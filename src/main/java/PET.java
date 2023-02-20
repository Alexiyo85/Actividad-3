

import java.util.*;
public class PET {
    long ident;
    String name;
    /*
    String categoriaId;
    String categoriaName;

    String photoUrls;
    String tagsId;
    String tagsName;
    String status;
    */
    String pet = "pet/findByStatus?status=";
    String avaible = "available";
    String pending = "pending";
    String sold = "sold";
    //En este arrayList vamos guardando los nombre de mascota
    ArrayList<String> nombreMascotas = new ArrayList<>();
    /*public void getPet(String identidad, String idCategoria, String nombreCategoria, String nombre, String foto,
                       String nombreEtiqueta, String estado){
    }

    //Getters
    public double getId() {
        return this.ident;
    }
    public String getName (){
        return this.name;
    }
    public String getCategoriaId() {
        return this.categoriaId;
    }
    public String getCategoriaName() {
        return categoriaName;
    }
    public String getPhotoUrls() {
        return this.photoUrls;
    }
    public String getTagsId() {
        return this.tagsId;
    }
    public String getTagsName() {return this.tagsName;}
    public String getStatus() {
        return this.status;
    }
    //Setters
    public void setId(int identidad) {this.ident = identidad;}
    public void setName(String nombre) {this.name = nombre;}
    public void setCategoriaId(String categoriaIden){this.categoriaId = categoriaIden;}
    public void setCategoriaName(String categoriaName){this.categoriaName = categoriaName;}
    public void setPhotoUrls(String fotoUrl){this.photoUrls = fotoUrl;}
    public void setTagsId(String tagsId){this.tagsId = tagsId;}
    public void setTagsName(String tagsName){this.tagsName = tagsName;}
    public void setStatus(String estado){this.status = estado;}
    */
    //En el objeto vamos guardando los nombres de las mascotas en el arrayList declarados anteriormente
    public void vectorNombre(String nombre) {
        nombreMascotas.add(nombre);
    }
    /*
    se pretende recorrec el array nombre mascotas y realizar una comprobacion si hay repetidos o no, y contarlos.
     */
    public void repetidos() {
        /*
        creamos el Map, lo recoremos y si contiene el elemento se añade y se suma 1, si no se queda en 1
         */
        Map<String, Integer> map = new HashMap<>();
        for (String element : nombreMascotas) {
            if (map.containsKey(element)) {
                map.put(element, map.get(element) + 1);
            } else {
                map.put(element, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            //si el valor es mayor a 1
            if (entry.getValue() > 1) {
                System.out.println("El nombre de mascota " + entry.getKey() + " se repite " + entry.getValue() + " veces");
                System.out.println("------------");
            //si el valor es 1
            } else {
                System.out.println("El nombre " + entry.getKey() + " aparece " + entry.getValue() + " vez");
                System.out.println("------------");
            }
        }
    }
}
