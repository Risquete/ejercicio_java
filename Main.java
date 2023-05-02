import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public ArrayList<Personas> stemdoers = new ArrayList<Personas>();
    public ArrayList<Proyectos> proyectos = new ArrayList<Proyectos>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a STEMDO!!!");
        System.out.println("Que desea modificar?");
        System.out.println("1. Nombre");
        System.out.println("2. Apellido");
        System.out.println("3. Edad");
        System.out.println("4. Salir");

        int opcion;
        opcion = sc.nextInt();
    }

    public void addPersona(Personas p) {
        stemdoers.add(p);
    }

    public void borrarPersona(Personas p) {
        stemdoers.remove(p);
    }

    public void modificar(String dni) {
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

    public int buscarPersona(String dni) {
        for (int i = 0; i < stemdoers.size(); i++) {
            if (stemdoers.get(i).getDni() == dni) {
                return i;
            }
        }
        return -1;
    }
}
