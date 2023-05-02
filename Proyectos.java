import java.util.ArrayList;
import java.util.HashMap;

public class Proyectos {
    private String idProyecto;
    private int horas;
    private ArrayList<String> skills;
    private String titulo;
    private HashMap<String, Integer> trabajadores;

    public Proyectos() {
        idProyecto = "";
        horas = 0;
        this.skills = new ArrayList<String>();
        this.titulo = "";
        this.trabajadores = new HashMap<String, Integer>();
    }

    public Proyectos(String idProyecto, int horas, ArrayList<String> caracteristicas, String titulo,
            HashMap<String, Integer> trabajadores) {
        this.idProyecto = idProyecto;
        this.horas = horas;
        this.skills = caracteristicas;
        this.titulo = titulo;
        this.trabajadores = trabajadores;
    }

    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    @Override
    public String toString() {
        return "Proyectos [idProyecto=" + idProyecto + ", horas=" + horas + ", caracteristicas=" + skills 
                + ", titulo=" + titulo + "]";
    }

    public HashMap<String, Integer> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(HashMap<String, Integer> trabajadores) {
        this.trabajadores = trabajadores;
    }

    public void addTrabajadores(String dni, int horas) {
        if (trabajadores.get(dni) == null || contarHoras() + horas > this.horas) {
            trabajadores.put(dni, horas);
        } else {
            System.out.println("El trabajador ya está añadido a esta proyecto.");
        }
    }

    public void eliminarTrabajadores(String dni) {
        trabajadores.remove(dni);
    }

    public int contarHoras() {
        return trabajadores.values().stream().mapToInt(Integer::intValue).sum();
    }

}