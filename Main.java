import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static HashMap<String, Personas> stemdoers = new HashMap<String, Personas>();
    public static ArrayList<Proyectos> proyectos = new ArrayList<Proyectos>();
    public static FileWriter fichero = null;
    public static PrintWriter pw = null;
    public static FileReader fr = null;
    public static BufferedReader br = null;

    public static void main(String[] args) throws IOException {
        cargarFicheros();
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
        System.out.println("9. Listar usuarios");
        System.out.println("10. Listar proyectos");
        // horas
        System.out.println("11. Salir");

        int opcion;
        opcion = sc.nextInt();

        // Valida que no eliga una opcion invalida
        while (opcion > 11) {
            System.out.println("Opcion no valida. Vuelva a seleccionar opcion");
            opcion = sc.nextInt();
        }

        while (opcion != 11) {
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
                    borrarProyecto();
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
                    listarStemdoersCompleto();
                    break;
                case 10:
                    listarProyectosCompleto();
                    break;
                case 11:
                    guardarFicheros();
                    System.out.println("Saliendo...");
                    break;
            }
            System.out.println("Que desea hacer?");
            System.out.println("1. Alta de usuario nuevo");
            System.out.println("2. Eliminar usuario");
            System.out.println("3. Modificar usuario");
            System.out.println("4. Nuevo proyecto");
            System.out.println("5. Eliminar proyecto");
            System.out.println("6. Modificar proyecto");
            System.out.println("7. Asignar usuario a proyecto");
            System.out.println("8. Asignar proyecto a usuario");
            System.out.println("9. Listar usuarios");
            System.out.println("10. Listar proyectos");
            // horas
            System.out.println("11. Salir");
            opcion = sc.nextInt();
        }
        guardarFicheros();
    }

    private static void borrarProyecto() {
        listarProyectos();
        Scanner sc = new Scanner(System.in);
        System.out.println("Escoja el id del proyecto a eliminar: ");
        int id = Integer.parseInt(sc.nextLine());
        proyectos.remove(id);
    }

    private static void proyectoUsuario() {
        Scanner sc = new Scanner(System.in);
        listarProyectos();
        System.out.println("Escoja el id del proyecto: ");
        int id = Integer.parseInt(sc.nextLine());
        listarStemdoers();
        System.out.println("Introduzca el DNI del Stemdoer");
        String dni = sc.nextLine();
        System.out.println("Introduzca el nuevo numero de horas que se le asigan al usuario");
        int horas = sc.nextInt();
        stemdoers.get(dni).addProyecto(dni, horas);
    }

    private static void usuarioProyecto() {
        listarStemdoers();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el DNI del Stemdoer");
        String dni = sc.nextLine();
        listarProyectos();
        System.out.println("Escoja el id del proyecto al que agregar al usuario: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Introduzca el nuevo numero de horas que se le asigan al usuario");
        int horas = sc.nextInt();
        proyectos.get(id).addTrabajadores(dni, horas);
    }

    private static void modificarProyecto() {
        listarProyectos();
        Scanner sc = new Scanner(System.in);
        System.out.println("Escoja el id del proyecto a modificar: ");
        int id = sc.nextInt();
        System.out.println("Que desea hacer?");
        System.out.println("1. Cambiar titulo");
        System.out.println("2. Cambiar horas");
        System.out.println("3. Agregar skills");
        System.out.println("4. Eliminar skills");
        System.out.println("5. Salir");

        int aux = sc.nextInt();
        while (aux != 5) {
            switch (aux) {
                case 1:
                    System.out.println("Introduzca el nuevo titulo");
                    String titulo = sc.nextLine();
                    proyectos.get(id).setTitulo(titulo);
                    break;
                case 2:
                    System.out.println("Introduzca el nuevo numero de horas");
                    int horas = sc.nextInt();
                    proyectos.get(id).setHoras(horas);
                    break;
                case 3:
                    System.out.println("Introduzca la nueva skill a agregar");
                    String skill = sc.nextLine();
                    proyectos.get(id).addSkills(skill);
                    break;
                case 4:
                    listarSkills(id);
                    System.out.println("Introduzc la skill a eliminar");
                    String skill1 = sc.nextLine();
                    proyectos.get(id).borrarSkills(skill1);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
            }
            System.out.println("Que desea hacer?");
            System.out.println("1. Cambiar titulo");
            System.out.println("2. Cambiar horas");
            System.out.println("3. Agregar skills");
            System.out.println("4. Eliminar skills");
            System.out.println("5. Salir");
            aux = sc.nextInt();
        }

    }

    private static void addProyecto() throws IOException {
        Scanner sc = new Scanner(System.in);
        String id = proyectos.size() + "";
        System.out.println("Introduzca el título del proyecto: ");
        String titulo = sc.nextLine();
        System.out.println("Introduzca las horas de trabajo que necesita el proyecto: ");
        String horas = sc.nextLine();
        System.out.println("Introduzca las skills separadas por comas: ");
        String skills = sc.nextLine();
        ArrayList<String> sk = new ArrayList<String>(Arrays.asList(skills.split(",")));
        proyectos.add(new Proyectos(id, Integer.parseInt(horas), sk, titulo));

    }

    public static void addPersona() throws java.io.IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el DNI del nuevo usuario: ");
        String nif;
        nif = sc.nextLine();
        while (stemdoers.containsKey(nif)) {
            System.out.println("El DNI introducido EXISTE, vuelve a introducirlo: ");
            nif = sc.nextLine();
        }

        System.out.println("Introduzca el nombre: ");
        String name = sc.nextLine();
        System.out.println("Introduzca el apellidos: ");
        String apellidos = sc.nextLine();
        System.out.println("Introduzca la edad: ");
        int edad = sc.nextInt();
        stemdoers.put(nif, new Personas(name, apellidos, edad, nif));
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

        System.out.println("El usuario con dni: " + nif + "Va a ser borrado, ¿esta seguro?(y/n)");
        String confirmacion = sc.nextLine();

        if (confirmacion.equals("y")) {
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

    public static void listarProyectos() {
        System.out.println("Lista de Proyectos:");
        for (int i = 0; i < proyectos.size(); i++) {
            System.out.println(proyectos.get(i).getIdProyecto() + ". " + proyectos.get(i).getTitulo());
        }
    }

    public static void listarProyectosCompleto() {
        System.out.println("Lista de Proyectos:");
        for (int i = 0; i < proyectos.size(); i++) {
            System.out.println(proyectos.get(i));
        }
    }

    public static void listarStemdoers() {
        System.out.println("Lista de Stemdoers:");
        for (HashMap.Entry<String, Personas> entry : stemdoers.entrySet()) {
            System.out.println(
                    entry.getKey() + ". " + entry.getValue().getNombre() + " " + entry.getValue().getApellidos());
        }
        System.out.println();

    }

    public static void listarStemdoersCompleto() {
        System.out.println("Lista de Stemdoers:");
        for (HashMap.Entry<String, Personas> entry : stemdoers.entrySet()) {
            System.out.println(
                    entry.getKey() + ". " + entry.getValue());
        }
        System.out.println();
    }

    public static void listarSkills(int id) {
        System.out.println("Lista de Skills:");
        for (int i = 0; i < proyectos.get(id).getSkills().size(); i++) {
            System.out.println(i + ". " + proyectos.get(id).getSkills().get(i));
        }
        System.out.println();

    }

    public static void guardarFicheros() throws IOException {
        try {
            fichero = new FileWriter("stemdoers.txt");
            pw = new PrintWriter(fichero);

            for (HashMap.Entry<String, Personas> entry : stemdoers.entrySet()) {
                System.out.println(entry.getValue());
                pw.println(entry.getKey() + ";" + entry.getValue().getNombre() + ";" + entry.getValue().getApellidos()
                        + ";" + entry.getValue().getEdad() + ";" + entry.getValue().getSkills() + ";"
                        + entry.getValue().getProyectos());
            }
            fichero.close();

            fichero = new FileWriter("proyecto.txt");
            pw = new PrintWriter(fichero);
            for (int i = 0; i < proyectos.size(); i++) {
                System.out.println(proyectos.get(i));
                pw.println(proyectos.get(i).getIdProyecto() + ";" + proyectos.get(i).getTitulo() + ";"
                        + proyectos.get(i).getHoras() + ";" + proyectos.get(i).getSkills() + ";"
                        + proyectos.get(i).getTrabajadores());
            }
            fichero.close();
        } catch (IOException e) {
            System.out.println("Error");
            throw e;
        }

    }

    public static void cargarFicheros() throws IOException {
        try {
            fr = new FileReader("stemdoers.txt");
            br = new BufferedReader(fr);

            String linea;
            String[] usuario;
            String[] skills;
            String[] pro;
            String[] trabajadores;

            while ((linea = br.readLine()) != null) {
                usuario = linea.split(";");
                Personas p = new Personas(usuario[1], usuario[2], Integer.parseInt(usuario[3]), usuario[0]);
                if (!usuario[4].equals("[]")) {
                    skills = usuario[4].split(",");
                    for (int i = 0; i < skills.length; i++) {
                        p.addSkills(skills[i]);
                    }
                }
                if (!usuario[5].equals("{}")) {
                    System.out.println("***" + usuario[5]);
                    pro = usuario[5].split(",");
                    for (int i = 0; i < pro.length; i++) {
                        p.addProyecto(pro[i].split("-")[0], Integer.parseInt(pro[i].split("-")[1]));
                    }
                }
                stemdoers.put(usuario[0], p);
                // System.out.println(linea);
            }
            fr.close();

            fr = new FileReader("proyecto.txt");
            br = new BufferedReader(fr);

            while ((linea = br.readLine()) != null) {
                pro = linea.split(";");
                Proyectos pr = new Proyectos(pro[0], Integer.parseInt(pro[2]), pro[1]);
                if (!pro[3].equals("[]")) {
                    skills = pro[4].split(",");
                    for (int i = 0; i < skills.length; i++) {
                        pr.addSkills(skills[i]);
                    }
                }
                if (!pro[4].equals("{}")) {
                    trabajadores = pro[5].split(",");
                    for (int i = 0; i < trabajadores.length; i++) {
                        pr.addTrabajadores(trabajadores[i].split("-")[0],
                                Integer.parseInt(trabajadores[i].split("-")[1]));
                    }
                }
                proyectos.add(pr);
                // System.out.println(linea);
            }
            fr.close();
        } catch (IOException e) {
            System.out.println("Error");
            throw e;
        }
    }
}
