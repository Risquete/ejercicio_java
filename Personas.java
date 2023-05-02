//Esta clase es para guardar datos personales

import java.util.ArrayList;
import java.util.HashMap;

public class Personas {
    private String nombre;
    private String apellidos;
    private int edad;
    private String dni;
    private HashMap<String, Integer> proyectos;
    private ArrayList<String> skills;

    // constructor
    public Personas() {
        nombre = "";
        apellidos = "";
        edad = 0;
        dni = "";
        proyectos = new HashMap<String, Integer>();
        skills = new ArrayList<String>();
    }

    public Personas(String nombre, String apellidos, int edad, String dni, HashMap<String, Integer> proyectos,
            ArrayList<String> skills) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.dni = dni;
        this.proyectos = proyectos;
        this.skills = skills;
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

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public void addSkills(String skills) {
        this.skills.add(skills);
    }

    public void borrarSkills(String skills) {
        if (this.skills.contains(skills)) {
            this.skills.remove(skills);
        } else {
            System.out.println("No existe");
        }

    }

    public void addProyecto(String id, int horas) {
        if (proyectos.get(id) == null) {
            proyectos.put(id, horas);
        } else {
            System.out.println("El proyecto ya está añadido a esta persona.");
        }
    }

    public void eliminarProyecto(String id) {
        proyectos.remove(id);
    }

    public int contarHoras() {
        return proyectos.values().stream().mapToInt(Integer::intValue).sum();
    }

}