//Esta clase es para guardar datos personales
public class personas{
    private String nombre;
    private String apellidos;
    private int edad;
    private String dni;

    //constructor
    public personas(){
        nombre="";
        apellidos="";
        edad=0;
        dni="00000000x";
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
    



}