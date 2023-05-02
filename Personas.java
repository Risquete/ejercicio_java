//Esta clase es para guardar datos personales

import java.util.HashMap;

public class Personas {
    private String nombre;
    private String apellidos;
    private int edad;
    private String dni;
    private HashMap<String, Integer> proyectos;

    // constructor
    public Personas() {
        nombre = "";
        apellidos = "";
        edad = 0;
        dni = "";
        proyectos = new HashMap<String, Integer>();
    }

    public Personas(String nombre, String apellidos, int edad, String dni, HashMap<String, Integer> proyectos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.dni = dni;
        this.proyectos = proyectos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public HashMap<String, Integer> getProyectos() {
        return proyectos;
    }

    public void setProyectos(HashMap<String, Integer> proyectos) {
        this.proyectos = proyectos;
    }


    @Override
    public String toString() {
        return "Personas [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", dni=" + dni
                + ", proyectos=" + proyectos + "]";
    }

}