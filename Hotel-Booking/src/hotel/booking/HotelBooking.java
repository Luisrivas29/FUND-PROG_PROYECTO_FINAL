package hotel.booking;

import java.util.Scanner;


public class HotelBooking {
    
    //variables  estaticas de menu
    static Scanner input = new Scanner(System.in);
    static int select = -1;
    static int select2;
    static int select3;
    
    //variables estaticas de tipo entero
    public static int HabSencilla = 10;
    public static int HabDoble = 10;
    public static int HabFamiliar = 10;
    public static int CanHuesped;
    
    //variables estaticas tipo String y arreglos
    public static String[][] BD = new String[100][4];
    public static String ID;
  
    public static void main(String[] args) {
       
     //menu general
        
        while (select != 0) {
        
        
        //impresion de opciones del menu
            System.out.println("Elige una opcion:"
                             + "\n1.- Verificar Disponibilidad" 
                             + "\n2.- Consultar Huesped" 
                             + "\n3.- Registrar Huesped" 
                             + "\n4.- Eliminar Reservacion"
                             + "\n5.- Mostrar Reservaciones"
                             + "\n0.- Salir");
            
            select = Integer.parseInt( input.nextLine());
            
            //seleccion de menu
            switch (select){
                case 1:
                    ValDisponibilidad();
                    break;
                case 2:
                    consultarClientes();
                    break;
                case 3:
                    registrarHuesped();
                    break;       
                case 4:
                    Eliminar();        
                case 5:
                    mostrarReservacion();
                    break;
                case 0:
                    System.out.println("Adios!");
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
            
            System.out.println("\n");
            
    }
        
}
    
//funcion para verificar disponibilidad
    
    public static void ValDisponibilidad(){
        
        System.out.println("\n\nDisponibilidad de Habitaciones");
        System.out.println("\nHabitaciones Sencillas Registradas: " + HabSencilla);
        System.out.println("Habitaciones Dobles Registradas: " + HabDoble);
        System.out.println("Habitaciones Familiares Registradas: " + HabFamiliar);
        
        System.out.println("");        
    }
    
    //funcion para consultar clientes
    
    public static void consultarClientes(){
        
        System.out.println("Ingresar el Numero de Identificacion a Consultar: ");
        ID = input.nextLine();
        
        
        for(int i = 0; i <= 99; i++){
            
            if (BD[i][0] == null){
                
            } else{
                
                if(BD[i][0].contains(ID)) {
                    
                    System.out.println("\n\nCliente Registrado ");
                    System.out.println("ID: " + BD[i][0]);
                    System.out.println("Nombre: " + BD[i][1]);
                    System.out.println("Tipo de Habitacion: " + BD[i][2]);
                    System.out.println("Desayuno: " + BD[i][3]);
                    
                }
            
            }
            
        }
    
    }
    
    //funcion para eliminar reservaciones
    
    public static void Eliminar() {
        
        System.out.println("Ingresar Numero de Identificacion a Eliminar: ");
        
        ID = input.nextLine();
        
        for(int i = 0; i <= 99; i++) {
        
            if (BD[i][0] == null) {
                
            } else {
                
                if (BD[i][0].contains(ID)){
                    
                    System.out.println("\n\nReservacion Eliminada con Exito ");
                    System.out.println("ID: " + BD[i][0]);
                    System.out.println("Nombre: " + BD[i][1]);
                    System.out.println("Tipo de Habitacion: " + BD[i][2]);
                    System.out.println("Desayuno: " + BD[i][3]);
                    
                    BD[i][0] = "";
                    BD[i][1] = "";
                    BD[i][2] = "";
                    BD[i][3] = "";
                 
                }
                
            }
                
        }
        
    }
    
    // funcion para registro de clientes
    
    public static void registrarHuesped() {
        
        System.out.println("Ingresar el Numero de Identificacion del Huesped: ");
        
        BD[CanHuesped][0] = input.nextLine();
        
        System.out.println("Ingresar el Nombre del Huesped: ");
        
        BD[CanHuesped][1] = input.nextLine();
        
        // menu de seleccion de habitacion
        
        System.out.println("Ingresar Tipo de Habitacion");
        System.out.println("Tipo de Habitacion: " 
                + "\n1.- Habitacion Sencilla" 
                + "\n2.- Habitacion Doble"
                + "\n3.- Habitacion familiar");
        
        // captura de seleccion
        
        select2 = Integer.parseInt( input.nextLine());
                
        
        if (select2 == 1){
            
            BD[CanHuesped][2] = "Habitacion Sencilla";
            HabSencilla = HabSencilla - 1;
       
        } else {
            if(select2 == 2){
                
                BD[CanHuesped][2] = "Habitacion Doble";
                
                HabDoble = HabDoble - 1;
               
                } else {
                if(select2 == 3) {
                    
                    BD[CanHuesped][2] = "Habitacion Familiar";
                    
                    HabFamiliar = HabFamiliar - 1;
                    
                    } else {
                    
                    System.out.println("Ha Ingresado una Opcion no Valida, Registro Invalido");
                    
                }
              
            }
            
        }
        
        // consulta de desayuno
        
        System.out.println("Desayuno: " 
                           + "\n1.- Si" 
                           + "\n2.- No");
        
        select3 = Integer.parseInt( input.nextLine());
        
        if (select3 == 1){
            
            BD[CanHuesped][3] = "Si";
            
        } else {
            
            if (select3 == 2){
                
                BD[CanHuesped][3] = "No";
         
            } else {
                
                System.out.println("Ha ingresado una opcion no valida, Resgistro Invalido");
            
            }
        
        }
        
        // variable que se autoincrementa aumentando la cantidad de clientes en el hotel
        
        CanHuesped = CanHuesped + 1;
        
    }
    
    // funcion para mostrar la base de datos de reservaciones ( arreglo BD )
    
    public static void mostrarReservacion(){
        
        System.out.println("\n\nBase de Datos de Reservaciones: \n");
        
        // dos ciclos for para mostrar arreglo de dos dimensiones
        
        for (int i = 0; i <= 99; i++){
            
            for (int j = 0; j <= 3; j++){
                
                if(BD[i][j] == null) {
            
            } else {
                
                System.out.print(BD[i][j] + "   ");
                
            }
                
        }
            
            // se valida si la posicion esta vacia para no mostrar valores nulos
            
            if(BD[i][0] == null){
        
            } else {
                
                System.out.println("\n");    
                    
            }
            
        }
        
    }
        
}