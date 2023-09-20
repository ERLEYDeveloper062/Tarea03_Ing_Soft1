package edu.software1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;


public class ConvertirCvsAJson {


    private BufferedReader lector;
    private String linea;
    private String[] partes = null;

    public void leerArchivo(String nombreArchivo) {
        try {
            lector = new BufferedReader(new FileReader(nombreArchivo));
            List<Estudiante> estudiantes = new ArrayList<>();

            while ((linea = lector.readLine()) != null) {
                partes = linea.split(",");
                Estudiante estudiante = crearEstudiante();
                estudiantes.add(estudiante);
            }

            guardarComoJSON(estudiantes);
            lector.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Estudiante crearEstudiante() {
        String id = partes[0];
        String nombre = partes[1];
        String apellido = partes[2];
        return new Estudiante(id, nombre, apellido);
    }

    private void guardarComoJSON(List<Estudiante> estudiantes) {
        JSONArray jsonArray = new JSONArray();
        for(Estudiante estudiante : estudiantes){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", estudiante.getId());
            jsonObject.put("nombre", estudiante.getNombre());
            jsonObject.put("apellido", estudiante.getApellido());
            jsonArray.put(jsonObject);
            System.out.println(jsonObject);
        }

        String estudiantesArchivoJSON = "estudiantes.json";

        try (FileWriter fileWriter = new FileWriter(estudiantesArchivoJSON)) {
            fileWriter.write(jsonArray.toString(4)); // El segundo argumento establece la indentación
            System.out.println("Archivo JSON creado exitosamente: " + estudiantesArchivoJSON);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


