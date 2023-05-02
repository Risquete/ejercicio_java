import java.util.ArrayList;
import java.util.HashMap;

public class Proyectos {
    private String idProyecto;
    private int horas;
    private ArrayList<String> caracteristicas;
    private String titulo;
    private HashMap<String, Integer> trabajaores;

    public Proyectos() {
        idProyecto = "";
        horas = 0;
        this.caracteristicas = new ArrayList<String>();
        this.titulo = "";
        this.trabajaores = new HashMap<String, Integer>();

    }

    public Proyectos(String idProyecto, int horas, ArrayList<String> caracteristicas, String titulo,
            HashMap<String, Integer> trabajadores) {
        this.idProyecto = idProyecto;
        this.horas = horas;
        this.caracteristicas = caracteristicas;
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

    public ArrayList<String> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(ArrayList<String> caracteristicas) {
        this.caracteristicas = caracteristicas;
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