import java.io.*;

public class Main {
    //FileReader file;
    //BufferedReader br;
    String ruta = "alumnos.csv";

    public void LeerDatos() throws IOException {
        FileReader fr = new FileReader(ruta);
        BufferedReader br = new BufferedReader(fr);
        String line;

        try (br){   // Leemos línea por línea
            while ((line = br.readLine()) != null){
                String[] listaDatos = line.split(",");  // Creamos una lista de datos usando las "," como separadores

                // organizamos cada dato a un campo
                String nombre = listaDatos[0];
                Integer edad = Integer.valueOf(listaDatos[1]);
                String curso = listaDatos[2];
                Double nota = Double.valueOf(listaDatos[3]);

                Alumno alumno = new Alumno( nombre, edad, curso, nota);
                System.out.println(alumno.toString());
            }
        }
    }

    public void MejorNota() throws FileNotFoundException {
        FileReader fr = new FileReader(ruta);
        BufferedReader br = new BufferedReader(fr);
        String line;
        Double mejor = 0.0;

        try (br){   // Leemos línea por línea
            while ((line = br.readLine()) != null){
                String[] listaDatos = line.split(",");  // Creamos una lista de datos usando las "," como separadores

                // organizamos cada dato a un campo
                String nombre = listaDatos[0];
                Integer edad = Integer.valueOf(listaDatos[1]);
                String curso = listaDatos[2];
                Double nota = Double.valueOf(listaDatos[3]);

                Alumno alumno = new Alumno( nombre, edad, curso, nota);
                System.out.println(alumno.toString());

                for (int i = 0; i < listaDatos.length; i++) {
                    if (nota != null){
                        if (nota > mejor){
                            mejor = nota;
                        }}else{
                        System.out.println("No hay notas guardadas.");
                    }
                }
            }
            System.out.println("El alumno con mayor nota es "+alumno+", con una nota de "+nota);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.LeerDatos();
        main.MejorNota();
    }
}


