/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cliente;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;

/**
 *
 * @author ecasas
 */
public class CRUD {
    public static ArrayList<String[]> buscar2(String operacion, int id) throws IOException{
        String inscripcion = "", asignatura = "", estudiante = "", profesor = "", persona = "";
        try {
            Client client = Client.create();
            Client client2 = Client.create();
            Client client3 = Client.create();
            Client client4 = Client.create();
            Client client5 = Client.create();
            
            //Consulta inscripcion
            WebResource webResource;
            if ("inscripcion".equals(operacion)){
                webResource = client
                   .resource("http://localhost:8080/RestCRUDws1/webresources/com.servicio.inscripcion/"+id);
                ClientResponse response1 = webResource.accept("application/json").get(ClientResponse.class);
                inscripcion = "["+response1.getEntity(String.class)+"]";
                //System.out.println("["+inscripcion+"]");
                System.out.println(inscripcion);
            }else{
                webResource = client
                   .resource("http://localhost:8080/RestCRUDws1/webresources/com.servicio.inscripcion");
                ClientResponse response1 = webResource.accept("application/json").get(ClientResponse.class);
                inscripcion = response1.getEntity(String.class);
                System.out.println(inscripcion);
            
            }
            
            //Consulta asignatura
            if ("asignatura".equals(operacion)){
                webResource = client2
                   .resource("http://localhost:8080/RestCRUDws1/webresources/com.servicio.asignatura/"+id);
                ClientResponse response2 = webResource.accept("application/json").get(ClientResponse.class);
                asignatura = "["+(response2.getEntity(String.class))+"]";
                System.out.println(asignatura);
            }else{
                webResource = client2
                   .resource("http://localhost:8080/RestCRUDws1/webresources/com.servicio.asignatura");
                ClientResponse response2 = webResource.accept("application/json").get(ClientResponse.class);
                asignatura = response2.getEntity(String.class);
                System.out.println(asignatura);
            }
            
            //Consulta estudiante
            if ("estudiante".equals(operacion)){
                webResource = client3
                   .resource("http://localhost:8080/RestCRUDws1/webresources/com.servicio.estudiante/"+id);
                ClientResponse response3 = webResource.accept("application/json").get(ClientResponse.class);
                estudiante = "["+response3.getEntity(String.class)+"]";
            }else{
                webResource = client3
                   .resource("http://localhost:8080/RestCRUDws1/webresources/com.servicio.estudiante");
                ClientResponse response3 = webResource.accept("application/json").get(ClientResponse.class);
                estudiante = response3.getEntity(String.class);
            }
            
            //Consulta profesor
            if ("profesor".equals(operacion)){
                webResource = client4
                   .resource("http://localhost:8080/RestCRUDws1/webresources/com.servicio.profesor/"+id);
                ClientResponse response4 = webResource.accept("application/json").get(ClientResponse.class);
                profesor = "["+response4.getEntity(String.class)+"]";
            } else {
                webResource = client4
                   .resource("http://localhost:8080/RestCRUDws1/webresources/com.servicio.profesor");
                ClientResponse response4 = webResource.accept("application/json").get(ClientResponse.class);
                profesor = response4.getEntity(String.class);
            }
            
            
            //Consulta persona
            webResource = client5
               .resource("http://localhost:8080/RestCRUDws1/webresources/com.servicio.persona");
            ClientResponse response5 = webResource.accept("application/json").get(ClientResponse.class);
            persona = response5.getEntity(String.class);
            

            //System.out.println("Output from Server .... \n");
            //System.out.println(inscripcion);
        
	}catch (Exception e) {
            e.printStackTrace();
        }
        
        return readJson(inscripcion, asignatura, estudiante, profesor, persona);
    }

    public static ArrayList<String[]> readJson(String inscripcion, String asignatura, String estudiante,
            String profesor, String persona) throws FileNotFoundException, IOException{
        
        InputStream fis1 = new ByteArrayInputStream(inscripcion.getBytes(StandardCharsets.UTF_8));	
        JsonReader jsonReader1 = Json.createReader(fis1);
        
        InputStream fis2 = new ByteArrayInputStream(asignatura.getBytes(StandardCharsets.UTF_8));	
        JsonReader jsonReader2 = Json.createReader(fis2);
        
        InputStream fis3 = new ByteArrayInputStream(estudiante.getBytes(StandardCharsets.UTF_8));	
        JsonReader jsonReader3 = Json.createReader(fis3);
        
        InputStream fis4 = new ByteArrayInputStream(profesor.getBytes(StandardCharsets.UTF_8));	
        JsonReader jsonReader4 = Json.createReader(fis4);
        
        InputStream fis5 = new ByteArrayInputStream(persona.getBytes(StandardCharsets.UTF_8));	
        JsonReader jsonReader5 = Json.createReader(fis5);
        
        JsonArray jsonObject1 = jsonReader1.readArray();
        JsonArray jsonObject2 = jsonReader2.readArray();
        JsonArray jsonObject3 = jsonReader3.readArray();
        JsonArray jsonObject4 = jsonReader4.readArray();
        JsonArray jsonObjectx = jsonReader5.readArray();
        
        //JsonStructure jsonObject = jsonReader.read();
        
        ArrayList<String[]> list = new ArrayList<>();
        
        jsonReader1.close();
        fis1.close();
        
        jsonReader2.close();
        fis2.close();
        
        jsonReader3.close();
        fis3.close();
        
        jsonReader4.close();
        fis4.close();
        
        jsonReader5.close();
        fis5.close();
        
        String asi = "", est = "", pro = "";
        for (int i=0; i<(jsonObject1.size()); i++){
        //for (int i=0; i<(0); i++){
            JsonObject jsonObject5 = jsonObject1.getJsonObject(i);
            for (int j=0; (j<jsonObject2.size()); j++){
                JsonObject jsonObject6 = jsonObject2.getJsonObject(j);
                if (jsonObject5.getInt("idAsignatura") == 
                        jsonObject6.getInt("idAsignatura")){
                    asi = jsonObject6.getString("nombre");
                    break;
                }
            }
            for (int k=0; (k<jsonObject3.size()); k++){
                JsonObject jsonObject7 = jsonObject3.getJsonObject(k);
                if (jsonObject5.getInt("idEstudiante")==
                        jsonObject7.getInt("idEstudiante")){
                    for (int m=0; (m<jsonObjectx.size()); m++){
                        JsonObject jsonObject10 = jsonObjectx.getJsonObject(m);
                        if (jsonObject7.getInt("idPersona")==
                                jsonObject10.getInt("idPersona")){  
                            est = jsonObject10.getString("nombre")+" "+jsonObject10.getString("apellido");
                        }      
                    }
                    break;
                }
            }
            for (int l=0; (l<jsonObject4.size()); l++){
                JsonObject jsonObject8 = jsonObject4.getJsonObject(l);
                if (jsonObject5.getInt("idProfesor")==
                        jsonObject8.getInt("idProfesor")){
                    for (int m=0; (m<jsonObjectx.size()); m++){
                        JsonObject jsonObject10 = jsonObjectx.getJsonObject(m);
                        if (jsonObject8.getInt("idPersona")==
                                jsonObject10.getInt("idPersona")){  
                            pro = jsonObject10.getString("nombre")+" "+jsonObject10.getString("apellido");
                        }      
                    }
                    break;
                }
            }
            String[] name = {
                jsonObject5.getInt("idInscripcion")+"",
                //jsonObject5.getInt("idEstudiante")+"",
                est+"",
                asi+"",
                pro+"",
                jsonObject5.getString("horario")+""
            }; 
            if (!"".equals(name[0]) && !"".equals(name[1]) && !"".equals(name[2]) && !"".equals(name[3])){
                list.add(name);
            }
            asi = ""; est = ""; pro = "";
        }
        System.out.println("resultado");
        System.out.println("0:"+list.get(0)[0]);
        System.out.println("1:"+list.get(0)[1]);
        System.out.println("2:"+list.get(0)[2]);
        System.out.println("3:"+list.get(0)[3]);
        System.out.println("4:"+list.get(0)[4]);
        //System.out.println("5:"+list.get(0)[5]);
        
        return list;
    }
    
    public static ArrayList<String[]> getEstudiante() throws IOException{
        String estudiante = "", profesor = "", persona = "";
        ArrayList<String[]> list = new ArrayList<>();

        try {
            Client client1 = Client.create();
            Client client2 = Client.create();
            Client client3 = Client.create();
            
            //Consulta estudiante
            WebResource webResource = client1
               .resource("http://localhost:8080/RestCRUDws1/webresources/com.servicio.estudiante");
            ClientResponse response1 = webResource.accept("application/json").get(ClientResponse.class);
            estudiante = response1.getEntity(String.class);
            
            //Consulta estudiante
            webResource = client2
               .resource("http://localhost:8080/RestCRUDws1/webresources/com.servicio.profesor");
            ClientResponse response2 = webResource.accept("application/json").get(ClientResponse.class);
            profesor = response2.getEntity(String.class);
            
            //Consulta persona
            webResource = client3
               .resource("http://localhost:8080/RestCRUDws1/webresources/com.servicio.persona");
            ClientResponse response3 = webResource.accept("application/json").get(ClientResponse.class);
            persona = response3.getEntity(String.class);
            
            InputStream fis1 = new ByteArrayInputStream(estudiante.getBytes(StandardCharsets.UTF_8));	
            JsonReader jsonReader1 = Json.createReader(fis1);

            InputStream fis2 = new ByteArrayInputStream(profesor.getBytes(StandardCharsets.UTF_8));	
            JsonReader jsonReader2 = Json.createReader(fis2);
            
            InputStream fis3 = new ByteArrayInputStream(persona.getBytes(StandardCharsets.UTF_8));	
            JsonReader jsonReader3 = Json.createReader(fis3);

            JsonArray jsonObject1 = jsonReader1.readArray();
            JsonArray jsonObject2 = jsonReader2.readArray();
            JsonArray jsonObject3 = jsonReader3.readArray();
            
            
            jsonReader1.close();
            fis1.close();

            jsonReader2.close();
            fis2.close();
            
            jsonReader3.close();
            fis3.close();
            
            //System.out.println(jsonObject1);
            
            String est = "";
            for (int k=0; (k<jsonObject1.size()); k++){
                JsonObject jsonObject7 = jsonObject1.getJsonObject(k);
                for (int m=0; (m<jsonObject3.size()); m++){
                    JsonObject jsonObject8 = jsonObject3.getJsonObject(m);
                    if (jsonObject7.getInt("idPersona")==
                            jsonObject8.getInt("idPersona")){  
                        est = jsonObject8.getString("nombre")+" "+jsonObject8.getString("apellido");
                        System.out.println("lala: "+est);
                    }      
                }
                String[] name = {
                    jsonObject7.getInt("idEstudiante")+"",
                    est
                }; 
                list.add(name);
                est = "";
            }
            //updates(20134,409,5,"Tarde");
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public static ArrayList<String[]> getProfesor() throws IOException{
        String profesor = "", persona = "";
        ArrayList<String[]> list = new ArrayList<>();

        try {
            Client client1 = Client.create();
            Client client3 = Client.create();
            
            //Consulta estudiante
            WebResource webResource = client1
               .resource("http://localhost:8080/RestCRUDws1/webresources/com.servicio.profesor");
            ClientResponse response1 = webResource.accept("application/json").get(ClientResponse.class);
            profesor = response1.getEntity(String.class);
            
            //Consulta persona
            webResource = client3
               .resource("http://localhost:8080/RestCRUDws1/webresources/com.servicio.persona");
            ClientResponse response3 = webResource.accept("application/json").get(ClientResponse.class);
            persona = response3.getEntity(String.class);
            
            InputStream fis1 = new ByteArrayInputStream(profesor.getBytes(StandardCharsets.UTF_8));	
            JsonReader jsonReader1 = Json.createReader(fis1);
            
            InputStream fis3 = new ByteArrayInputStream(persona.getBytes(StandardCharsets.UTF_8));	
            JsonReader jsonReader3 = Json.createReader(fis3);

            JsonArray jsonObject1 = jsonReader1.readArray();
            JsonArray jsonObject3 = jsonReader3.readArray();
            
            
            jsonReader1.close();
            fis1.close();

            jsonReader3.close();
            fis3.close();
            
            String est = "";
            for (int k=0; (k<jsonObject1.size()); k++){
                JsonObject jsonObject7 = jsonObject1.getJsonObject(k);
                for (int m=0; (m<jsonObject3.size()); m++){
                    JsonObject jsonObject8 = jsonObject3.getJsonObject(m);
                    if (jsonObject7.getInt("idPersona")==
                            jsonObject8.getInt("idPersona")){  
                        est = jsonObject8.getString("nombre")+" "+jsonObject8.getString("apellido");
                    }      
                }
                String[] name = {
                    jsonObject7.getInt("idProfesor")+"",
                    est
                }; 
                list.add(name);
                est = "";
            }
            

            
	}catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public static ArrayList<String[]> getAsignatura() throws IOException{
        String asignatura = "";
        ArrayList<String[]> list = new ArrayList<>();

        try {
            Client client1 = Client.create();
            
            //Consulta estudiante
            WebResource webResource = client1
               .resource("http://localhost:8080/RestCRUDws1/webresources/com.servicio.asignatura");
            ClientResponse response1 = webResource.accept("application/json").get(ClientResponse.class);
            asignatura = response1.getEntity(String.class);
            
            InputStream fis1 = new ByteArrayInputStream(asignatura.getBytes(StandardCharsets.UTF_8));	
            JsonReader jsonReader1 = Json.createReader(fis1);
            
            JsonArray jsonObject1 = jsonReader1.readArray();
            
            jsonReader1.close();
            fis1.close();

            String est = "";
            for (int k=0; (k<jsonObject1.size()); k++){
                JsonObject jsonObject7 = jsonObject1.getJsonObject(k);
                String[] name = {
                    jsonObject7.getInt("idAsignatura")+"",
                    jsonObject7.getString("nombre")+""
                }; 
                list.add(name);
                est = "";
            }
            

            
	}catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public static boolean create(int id_estudiante, int id_asignatura, 
            int id_profesor, String horario){
        try {

            Client client = Client.create();

            WebResource webResource = client
               .resource("http://localhost:8080/RestCRUDws1/webresources/com.servicio.inscripcion");

            String input = "{\"horario\":\""+horario+"\","
                    + "\"idAsignatura\":"+id_asignatura+","
                    + "\"idEstudiante\":"+id_estudiante+","
                    + "\"idInscripcion\":1,"
                    + "\"idProfesor\":"+id_profesor+"}";
            //String input = "[{\"id\":1,\"nombre\":\"daniel\"},{\"id\":2,\"nombre\":\"elias\"},{\"id\":3,\"nombre\":\"julian\"},{\"id\":4,\"nombre\":\"nidia\"},{\"id\":5,\"nombre\":\"samuel\"},{\"id\":6,\"nombre\":\"valentina\"},{\"id\":7,\"nombre\":\"jonathan\"},{\"id\":8,\"nombre\":\"jonis\"},{\"id\":9,\"nombre\":\"jula\"},{\"id\":10,\"nombre\":\"javier\"},{\"id\":11,\"nombre\":\"julas\"},{\"id\":12,\"nombre\":\"diana\"},{\"id\":13,\"nombre\":\"diana\"},{\"id\":14,\"nombre\":\"dianas\"},{\"id\":15,\"nombre\":\"aidecita\"}]";

            ClientResponse response = webResource.type("application/json")
               .post(ClientResponse.class, input);

            System.out.println("Output from Server .... \n");
            String output = response.getEntity(String.class);
            System.out.println(output);

	} catch (Exception e) {
            e.printStackTrace();
            //return false;
        }
        return true;
    }
    
    public static String[] getData(int id) throws IOException{
        String inscripcion = "";
        try {
            Client client = Client.create();
            
            //Consulta inscripcion
            WebResource webResource;
            webResource = client
               .resource("http://localhost:8080/RestCRUDws1/webresources/com.servicio.inscripcion/"+id);
            ClientResponse response1 = webResource.accept("application/json").get(ClientResponse.class);
            inscripcion = response1.getEntity(String.class);
            
            System.out.println(inscripcion);
            
	}catch (Exception e) {
            e.printStackTrace();
        }
        
        return readJson2(inscripcion);
    }

    public static String[] readJson2(String inscripcion) throws FileNotFoundException, IOException{
        
        InputStream fis1 = new ByteArrayInputStream(inscripcion.getBytes(StandardCharsets.UTF_8));	
        JsonReader jsonReader1 = Json.createReader(fis1);
        
        JsonObject jsonObject1 = jsonReader1.readObject();
        System.out.println("kjdjfdjkfd: "+jsonObject1.getInt("idInscripcion"));
        
        jsonReader1.close();
        fis1.close();
        
        String[] name = {
            jsonObject1.getInt("idInscripcion")+"",
            jsonObject1.getInt("idEstudiante")+"",
            jsonObject1.getInt("idAsignatura")+"",
            jsonObject1.getInt("idProfesor")+"",
            //est+"",
            //asi+"",
            //pro+"",
            //jsonObject1.getString("horario")+""
        }; 
        
        return name;
    }
    
    public static boolean update(int id, String horario){
        try {
            Client client = Client.create();

            WebResource webResource = client
               .resource("http://localhost:8080/RestCRUDws1/webresources/com.servicio.inscripcion/"+id);
            
            String[] list = getData(id);

            String input = "{\"horario\":\""+horario+"\","
                    + "\"idAsignatura\":"+list[2]+","
                    + "\"idEstudiante\":"+list[1]+","
                    + "\"idInscripcion\":"+id+","
                    + "\"idProfesor\":"+list[3]+"}";
            
            //String input = "{\"idInscripcion\":"+id+",\"horario\":\""+horario+"\"}";

            ClientResponse response = webResource.type("application/json")
               .put(ClientResponse.class, input);
            
            System.out.println("Output from Server .... \n");
            String output = response.getEntity(String.class);
            System.out.println(output);

	} catch (Exception e) {
            e.printStackTrace();
            //return false;
        }
        return true;
    }
    
    public static boolean delete(int id){
        try {

            Client client = Client.create();

            WebResource webResource = client
               .resource("http://localhost:8080/RestCRUDws1/webresources/com.servicio.inscripcion/"+id);

            ClientResponse response = webResource.type("application/json")
               .delete(ClientResponse.class);

            System.out.println("Output from Server .... \n");
            String output = response.getEntity(String.class);
            System.out.println(output);

	} catch (Exception e) {
            e.printStackTrace();
            //return false;
	}
        return true;
    }
    
   
    /*
    public static boolean updates(int id_estudiante, int id_asignatura, 
            int id_profesor, String horario) throws IOException{
        String asignatura = "";
        ArrayList<String[]> list = new ArrayList<>();

        try {
            Client client1 = Client.create();
            
            String input = "{\"horario\":\"" + horario + "\","
                    + "\"idAsignatura\":" + id_asignatura + ","
                    + "\"idEstudiante\":" + id_estudiante + ","
                    + "\"idInscripcion\":" + ++serial + ","
                    + "\"idProfesor\":" + id_profesor + "}";
            //Consulta estudiante
            WebResource webResource = client1
               .resource("http://localhost:8080/RestCRUDws1/webresources/com.servicio.inscripcion");
            ClientResponse response1 = webResource.accept("application/json").put(ClientResponse.class, input);
            asignatura = response1.getEntity(String.class);
        
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    private static Connection conn;
    
    private static Connection getConnection() throws Exception {
        if(conn == null){
            String urlDatabase =  "jdbc:postgresql://localhost:5432/CRUDws";
            Class.forName("org.postgresql.Driver"); //cargar el driver manualmente
    
            conn = DriverManager.getConnection(urlDatabase,  "postgres", "daniel");
        }
        return conn;
    }

    
    public static boolean create(int id_estudiante, int id_asignatura, 
            int id_profesor, String horario) throws IOException{
        try { getConnection(); } catch (Exception ex) {}
        Statement stmt;
        try {
            stmt = conn.createStatement();
            int rss = stmt.executeUpdate("INSERT INTO inscripcion( id_asignatura, id_estudiante, "
                    + "id_profesor, horario ) VALUES( " + id_asignatura + ", " 
                    + id_estudiante + ", " + id_profesor + ", '" + horario + "' );");
            stmt.close();
        } catch (SQLException ex) {
            //Logger.getLogger(ConsultaBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public static boolean update(int id, String horario) throws IOException{
        try { getConnection(); } catch (Exception ex) {}
        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("UPDATE inscripcion SET horario='" + horario + "' WHERE "
                    + "id_inscripcion = " + id + ";");
            stmt.close();
        } catch (SQLException ex) {
            //Logger.getLogger(ConsultaBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public static boolean delete(int id) throws IOException{
        try { getConnection(); } catch (Exception ex) {}
        Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("DELETE FROM inscripcion WHERE id_inscripcion = " + id + ";");
            stmt.close();
        } catch (SQLException ex) {
            //Logger.getLogger(ConsultaBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    */
}
