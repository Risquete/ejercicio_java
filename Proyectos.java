import java.util.ArrayList;
import java.util.HashMap;

public class Proyectos {
    private String idProyecto;
    private int horas;
    private ArrayList<String> skills;
    private String titulo;
    private HashMap<String, Integer> trabajaores;

    public Proyectos() {
        idProyecto = "";
        horas = 0;
        this.skills = new ArrayList<String>();
        this.titulo = "";
        this.trabajaores = new HashMap<String, Integer>();

    }

    public Proyectos(String idProyecto, int horas, ArrayList<String> caracteristicas, String titulo,
            HashMap<String, Integer> trabajadores) {
        this.idProyecto = idProyecto;
        this.horas = horas;
        this.skills = caracteristicas;
        this.titulo = titulo;
        this.trabajaores = trabajadores;
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
        return "Proyectos [idProyecto=" + idProyecto + ", horas=" + horas + ", caracteristicas=" + caracteristicas
                + ", titulo=" + titulo + "]";
    }

    public HashMap<String, Integer> getTrabajaores() {
        return trabajaores;
    }

    public void setTrabajaores(HashMap<String, Integer> trabajaores) {
        this.trabajaores = trabajaores;
    }

}