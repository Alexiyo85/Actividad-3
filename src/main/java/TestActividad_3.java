


import com.google.gson.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class TestActividad_3 {
    /*
    Creado: Francisco Alejandro Fernandez Ferron
     */

    public static void main(String[] args) {

        //Definicion de variables
        String web = "https://petstore.swagger.io/v2/";
        Gson message = new Gson();//se inicia el objeto Gson
        UserDate userDate = new UserDate();//se inicia el objeto UserDate
        PET pet = new PET();
        //creamos el usuario
        userDate.setUser(
                "50",
                "Pedro",
                "Fulano",
                "Mengano",
                "0",
                "contraseña",
                "656666565",
                "pruebas@pruebas.com");//introducimos los datos del Json
        String msg = message.toJson(userDate); //creamos la cadena de datos en formato Json
        try {
            var uri = new URI(web + userDate.createUser);//se crea el objeto
            var client = HttpClient.newHttpClient();//se crea el cliente
            var request = HttpRequest.newBuilder(uri)
                    .POST(BodyPublishers.ofString(msg))
                    .header("Content-type", "application/json")
                    .build();//creamos la peticion
            var response = client.send(request, BodyHandlers.ofString());//lo que queremos que responda
            if (response.statusCode() == 200) {
                System.out.println("-----------------------------------");
                System.out.println("1 - Crea tu usuario mediante petición HTTP y posteriormente recupera sus datos llamando al servicio correspondiente.");
                System.out.println("-----------------------------------");
                System.out.println("Se ha creado el usuario con los siguientes datos: " + msg);
            } else {
                System.out.println("Error" + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //creamos peticion para que nos devuelvan los datos
        try {
            var uri1 = new URI(web + userDate.createUser + userDate.getUsername());
            var client1 = HttpClient.newHttpClient();
            var request1 = HttpRequest.newBuilder(uri1).
                    GET().
                    header("Content-type", "application/json").
                    build();
            var respnse1 = client1.send(request1, HttpResponse.BodyHandlers.ofString());
            System.out.println("Estos son los datos obtenidos: " + respnse1.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------");
        //Lista de Mascotas
        System.out.println("-----------------------------------");
        System.out.println("2 - El formato de salida deberá estar formado por la tupla {id, name}.");
        System.out.println("-----------------------------------");
        System.out.println("Introduzca un valor: 1 - available ; 2 - pending ; 3 - sold");
        Scanner sca = new Scanner(System.in);
        /*
        Creamos un validador para poder seleccionar los 3 estados
         */
        int valor = sca.nextInt();
        String opcion = null;
        while (valor > 0 && valor <= 4) {
            if (valor == 1) {
                opcion = pet.avaible;
                break;
            } else if (valor == 2) {
                opcion = pet.pending;
                break;
            } else if (valor == 3) {
                opcion = pet.sold;
                break;
            } else {
                System.out.println("Introduzca un valor: 1 - available ; 2 - pending ; 3 - sold. Vuelva a intentarlo");
                valor = sca.nextInt();
            }
        }
        /*
        realizamos la llamada segun la opcion elegida
         */
        try {
            var uri2 = new URI(web + pet.pet + opcion);
            System.out.println(uri2);
            var client2 = HttpClient.newHttpClient();
            var request2 = HttpRequest.newBuilder(uri2)
                .GET()
                .header("Content-type", "application/json; charset=UTF-8")
                .build();
            var respnse2 = client2.send(request2, HttpResponse.BodyHandlers.ofString());
            var texto = respnse2.body();
            JSONArray jsonArray = new JSONArray(texto);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                try {
                    //obtenemos del Json el name
                    if(jsonObject.has ("name")) {
                        pet.name = jsonObject.getString("name");
                    }
                    //obtenemos del Json el id
                    if(jsonObject.has ("id")) {
                        pet.ident = jsonObject.getLong("id");
                    }
                    //Se imprime el resultado
                    System.out.println("id: " + pet.ident + ", name: " + pet.name);
                    //metemos el name en un arrayList en el objeto vectorNombre de la clase PET
                    pet.vectorNombre(pet.name);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            System.out.println("-----------------------------------");
            System.out.println("3 - Crea una clase cuyo constructor requiera de la estructura de datos anterior y realiza un método que pueda recorrerla para poder identificar cuantas mascotas se llaman igual.");
            System.out.println("-----------------------------------");
            /*llamamos al objeto repetidos que tenemos en la clase PET, que es el que se encarga de realizar
              la tarea de comprobar cuantas veces aparece el nombre de mascota en el json
             */
            pet.repetidos();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
