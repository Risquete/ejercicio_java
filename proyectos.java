public class proyectos {
    private String idProyecto;
    private int horas;
    private String[] caracteristicas;
    private String titulo;

    
    public proyectos() {
        idProyecto="";
        horas=0;
        //caracteristicas[]="";
    }


    public proyectos(String idProyecto, int horas, String[] caracteristicas, String titulo) {
        this.idProyecto = idProyecto;
        this.horas = horas;
        this.caracteristicas = caracteristicas;
        this.titulo = titulo;
    }
    
    
    
    
}
