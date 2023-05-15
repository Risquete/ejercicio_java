import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Personas> stemdoers = new ArrayList<Personas>();
    public ArrayList<Proyectos> proyectos = new ArrayList<Proyectos>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a STEMDO!!!");
        System.out.println("Que desea hacer?");
        System.out.println("1. Alta de usuario nuevo");
        System.out.println("2. Eliminar usuario");
        System.out.println("3. Modificar usuario");
        System.out.println("4. Nuevo proyecto");
        System.out.println("5. Eliminar proyecto");
        System.out.println("6. Modificar proyecto");
        System.out.println("7. Asignar usuario a proyecto");
        System.out.println("8. Asignar proyecto a usuario");
        //horas
        System.out.println("9. Salir");

        int opcion;
        opcion = sc.nextInt();
        
        //Valida que no eliga una opcion invalida
        while (opcion > 9) {
            System.out.println("Opcion no valida. Vuelva a seleccionar opcion");
            opcion = sc.nextInt();
        }

        while (opcion != 9) {

            switch (opcion) {
                case 1:
                    addPersona();
                    break;
                case 2:
                    borrarPersona();
                    break;
                case 3:
                    modificar();
                    break;
                case 4:
                    addProyecto();
                    break;
                case 5:
                    borrarPersona();
                    break;
                case 6:
                    modificarProyecto();
                    break;
                case 7:
                    usuarioProyecto();
                    break;
                case 8:
                    proyectoUsuario();
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
            }
        }



    }

    private static void proyectoUsuario() {
    }

    private static void usuarioProyecto() {
    }

    private static void modificarProyecto() {
    }

    private static void addProyecto() {
    }

    public static void addPersona() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el DNI del nuevo usuario: ");
        String nif;
        nif = sc.nextLine();
        int id = buscarPersona(nif);
        while (id == -1) {
            System.out.println("El DNI introducido EXISTE, vuelve a introducirlo: ");
            nif = sc.nextLine();
            id = buscarPersona(nif);
        }
 
        System.out.println("Introduzca el nombre: ");
        String name = sc.nextLine();
        stemdoers.get(id).setNombre(name);
        System.out.println("Introduzca el apellidos: ");
        String apellidos = sc.nextLine();
        stemdoers.get(id).setApellidos(apellidos);
        System.out.println("Introduzca el apellidos: ");
        int edad = sc.nextInt();
        stemdoers.get(id).setEdad(edad);

        
        //stemdoers.add();
    }

    public static void borrarPersona() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el DNI de la persona que desea eliminar: ");
        String nif;
        nif = sc.nextLine();
        int id = buscarPersona(nif);
        while (id != -1) {
            System.out.println("El DNI introducido no existe, vuelve a introducirlo: ");
            nif = sc.nextLine();
            id = buscarPersona(nif);
        }
       
        System.out.println("El usuario con dni: "+ nif +"Va a ser borrado, ¿esta seguro?(y/n)");
        String confirmacion = sc.nextLine();
        
        if(confirmacion.equals("y")){
            stemdoers.remove(stemdoers.get(id));
        }
    }

    public static void modificar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el DNI de la persona que desea modificar: ");
        String nif;
        nif = sc.nextLine();
        int id = buscarPersona(nif);
        while (id != -1) {
            System.out.println("El DNI introducido no existe, vuelve a introducirlo: ");
            nif = sc.nextLine();
            id = buscarPersona(nif);
        }

        System.out.println("Que desea modificar?");
        System.out.println("1. Nombre");
        System.out.println("2. Apellido");
        System.out.println("3. Edad");
        System.out.println("4. Salir");

        int opcion;
        opcion = sc.nextInt();
        while (opcion > 4) {
            System.out.println("Vulve a introducir el número, fuera de rango.");
            opcion = sc.nextInt();
        }

        while (opcion != 4) {

            switch (opcion) {
                case 1:
                    System.out.println("Introduzca el nombre: ");
                    String name = sc.nextLine();
                    stemdoers.get(id).setNombre(name);
                    break;
                case 2:
                    System.out.println("Introduzca el apellidos: ");
                    String apellidos = sc.nextLine();
                    stemdoers.get(id).setApellidos(apellidos);
                    break;
                case 3:
                    System.out.println("Introduzca el apellidos: ");
                    int edad = sc.nextInt();
                    stemdoers.get(id).setEdad(edad);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
            }
        }
    }

    public static int buscarPersona(String dni) {
        for (int i = 0; i < stemdoers.size(); i++) {
            if (stemdoers.get(i).getDni() == dni) {
                return i;
            }
        }
        return -1;
    }
}
