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

    public String[] getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String[] caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    

}
