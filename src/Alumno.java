import java.io.Serializable;

public class Alumno {
    String nombre;
    Integer edad;
    String curso;
    Double nota;

    public Alumno(String nombre, Integer edad, String curso, Double nota) {
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return  "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", curso='" + curso + '\'' +
                ", nota=" + nota;
    }



}