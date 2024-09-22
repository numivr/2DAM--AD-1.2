import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    String ruta = "alumnos.csv";




    // Creamos un método al que poder llamar las veces que queramos en formato lista
    public List<Alumno> LeerDatos() throws IOException {
        // Leemos el archivo línea por línea
        FileReader fr = new FileReader(ruta);
        BufferedReader br = new BufferedReader(fr);
        String line;

        // Creamos un objeto lista que contendra los datos de los alumnos
        List<Alumno> alumnos = new ArrayList<>();

        try (br) {
            // Leemos todo el archivo (siempre que haya líneas)
            while ((line = br.readLine()) != null) {
                // Creamos una lista en la que guardaremos los datos (separando las lineas según las ",")
                String[] listaDatos = line.split(",");

                // Creamos las variables para guardar la lista de datos
                String nombre = listaDatos[0];
                Integer edad = Integer.valueOf(listaDatos[1]);
                String curso = listaDatos[2];
                Double nota = Double.valueOf(listaDatos[3]);

                // Creamos el objeto Alumno con los datos anteriores
                Alumno alumno = new Alumno(nombre, edad, curso, nota);

                // Añadimos el alumno
                alumnos.add(alumno);
            }
        }
        // Devolvemos la lista de alumnos (por ende, los setters y getters)
        return alumnos;
    }




    public void MejorNota() throws IOException {
        // Llamamos al método LeerDatos para obtener la lista de alumnos
        List<Alumno> alumnos = LeerDatos();
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }


        // Inicializamos variables para almacenar la mejor nota y el mejor alumno.
        Double mejorNota = 0.0; // con la menor nota para compararla próximamente
        Alumno mejorAlumno = null;

        // Recorremos la lista de alumnos
        for (Alumno alumno : alumnos) {
            // Si la nota de este alumno es mayor que la mejorNota actual, actualizamos la mejorNota y el mejorAlumno.
            if (alumno.getNota() > mejorNota) {
                mejorNota = alumno.getNota();
                mejorAlumno = alumno;
            }
        }
        System.out.println("\nEl alumno con mayor nota es " + mejorAlumno.getNombre() +
                ", con una nota de " + mejorAlumno.getNota() + "\n");
    }




    public void RepresentacionCSV() throws IOException {
        // Cogemos los datos de la lista de alumnos y mostramos con comas y saltos de línea
        List<Alumno> alumnos = LeerDatos();
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.getNombre() + "," + alumno.getEdad() + "," + alumno.getCurso() + "," + alumno.getNota());
        }
    }





    public void GenerarFicheroAprobados() throws IOException {
        String nombreArchivo = "AlumnosAprobados.csv";

        // Usamos FileWriter para escribir en un archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {

            List<Alumno> alumnos = LeerDatos();
            // Recorremos la lista cuyas notas sean >= 5
            for (Alumno alumno : alumnos) {
                if (alumno.getNota() >= 5) {
                    String representacionCSV = alumno.getNombre() + "," + String.valueOf(alumno.getEdad()) + "," + alumno.getCurso() + "," + String.valueOf(alumno.getNota() + "\n");
                    writer.write(representacionCSV);}
            }
            System.out.println("\n" + "Archivo creado exitosamente: " + nombreArchivo);


        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }

    }








    
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.MejorNota();
        main.RepresentacionCSV();
        main.GenerarFicheroAprobados();
    }
}
