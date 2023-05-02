public class Proyectos {
    private String idProyecto;
    private int horas;
    private String[] caracteristicas;
    private String titulo;

    public Proyectos() {
        idProyecto = "";
        horas = 0;
        // caracteristicas[]="";
    }

    public Proyectos(String idProyecto, int horas, String[] caracteristicas, String titulo) {
        this.idProyecto = idProyecto;
        this.horas = horas;
        this.caracteristicas = caracteristicas;
        this.titulo = titulo;
    }

}
