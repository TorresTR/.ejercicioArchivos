package com.udec.ejercicioarchivos;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;




/**
 * Esta clase se encarga de toda la logica del proyecto
 * @author David
 */
public class Logica {
    /**
     * se inicializa el scanner para capturar los datos que se ingresan
     */
    Scanner scanner = new Scanner(System.in);
    /**
     * se inicializan las listas para trabajar con ellas
     */
    ArrayList<Persona> listaPerona = new ArrayList<Persona>();
    ArrayList<Record> record = new ArrayList<Record>();
    
    /**
     * constructor el cual le dara el sentido de funcionamiento a el programa
     */
    public Logica() {
        datosIniciales();
        menu();
    }
    
    /**
     * este metodo se encarga de capturar y enviar los datos, para que sean guardados en el archivo
     */
    public void datosIniciales(){
        Persona content = new Persona(123, "julian", "Bustos");
        Record red = new Record(177,"movistar",false,5000);
        content.getHistoriaCredito().add(red);
        listaPerona.add(content);
        insertar(listaPerona);
        //////////////////////////////////////////////////////////////////////////
        Persona content1 = new Persona(234, "sosa", "cortez");
        Record red1 = new Record(233,"claro",false,5000);
        content1.getHistoriaCredito().add(red1);
        listaPerona.add(content1);
        insertar(listaPerona);
    }
    
    /**
     * este metodo es un menu el cual le da el sentido a el programa
     */
    public void menu(){
        System.out.println("1. insertar");
        System.out.println("2. insertar Record");
        System.out.println("3. eliminar Record");
        System.out.println("4. leer");
        System.out.println("5. salir");
        int variableControl = scanner.nextInt();
        if(variableControl == 1){
            escribir();
        }else if(variableControl == 2){
            record();
        }else if(variableControl == 3){
            eliminar();
        }else if(variableControl == 4){
            leer();
        }else if(variableControl == 5){
            System.exit(0);
        }else{
            System.out.println("\nIngrese una opcion valida");
            menu();
        }
    }
    
    
    /**
     * Este metodo captura los datos para ingresar usuarios a la lista
     */
    public void escribir(){
        System.out.println("inserte su cedula");
        int ced = scanner.nextInt();
        System.out.println("inserte su nombre");
        String nombre = scanner.next();
        System.out.println("inserte su apellido");
        String apellido = scanner.next();
        Persona content = new Persona(ced, nombre, apellido);
        content.setHistoriaCredito(new ArrayList<Record>());
        listaPerona.add(content);
        menu();
    }

    
   
    /**
     * este metodo que se encarga de eliminar los recor negativos
     */
    public void eliminar(){
        System.out.println("Ingrese la cedula de quien quiera eliminar un record");
        int num = scanner.nextInt();
        for (Iterator<Persona> iterator = listaPerona.iterator(); iterator.hasNext(); ) {
            Persona value = iterator.next();
            if (value.getCod() == num) {
                System.out.println("Ingrese el id del record a eliminar");
                 int numRecord = scanner.nextInt();
                     for (Iterator<Record> iteratorR = value.getHistoriaCredito().iterator(); iteratorR.hasNext(); ) {
                         Record val = iteratorR.next();
                         if(val.getCodi() == numRecord && val.getEstado() == false){
                         iteratorR.remove();
                         break;
                       }else if(val.getCodi() == numRecord && val.getEstado() == true){
                             System.out.println("<<----El record no es negativo lo lamento ingrese uno valido---->>");
                             eliminar();
                       }
                     }
            }   
        }
        
        File data = new File("archvivo\\documento.txt");
        data.delete();
        insertar(listaPerona);
        menu();
    
    
  }
    
    
    
    /**
     * metodo que se encarga de añadir record a la persona especificada
     */
     public void record(){
        System.out.println("Ingrese la cedula de quien quiera añadir un record");
        int num = scanner.nextInt();
        //num = num - 1;
        for(Persona p : listaPerona){
            if(p.getCod() == num){
                boolean verif=true;
                System.out.println("---------Record----------");
                System.out.println("inserte el codigo: ");
                int cod = scanner.nextInt();
                System.out.println("inserte el nombre de la empresa: ");
                String empresa = scanner.next();
                System.out.println("inserte el estado: ");
                int estado = scanner.nextInt();
                if(estado <0){
                    verif=false;
                }else if(estado >0){
                    verif=true;
                }
                System.out.println("inserte el valor: ");
                int valor = scanner.nextInt();
                Record red = new Record(cod, empresa, verif, valor);
                record.add(red);
                p.agregarRecord(red);
            }
        }
        System.out.println("\n----------------");
        System.out.println("Desea Continuar Agregar otro record?(s/n): ");
        String conti = scanner.next();
        if(conti.charAt(0) == 's'){
             record();
        }else if(conti.charAt(0) == 'n'){
            //listaPerona.add();
            insertar(listaPerona);
            menu();
        }else if(conti.charAt(0) != 's' || conti.charAt(0) != 'n' ){
             System.out.println("ingrese un caracter valido");
             record();
        }
         
   }
     
     
     /**
      * metodo que lee del archivo e imprime los datos
      */
    public void leer(){
        ObjectInputStream entrada= null; 
        try {
            File data = new File("archvivo\\documento.txt");
            entrada=new ObjectInputStream(new FileInputStream(data));
            Object actual = null;
            ArrayList<Persona> lista = null;
            while((actual = entrada.readObject()) != null) {
              lista = (ArrayList<Persona>) actual;
             for (int u = 0; u < lista.size(); ++u) {
                 System.out.println("-------------------------------------------------------");
                System.out.println("cedula:"+lista.get(u).getCod());
                System.out.println("Nombre:"+lista.get(u).getNombre());
                System.out.println("Apellido:"+lista.get(u).getApellido());
                    for(int i=0;i<lista.get(u).getHistoriaCredito().size();i++){
                        System.out.println("codigo: "+ lista.get(u).getHistoriaCredito().get(i).getCodi()+
                                "\nEmpresa: "+lista.get(u).getHistoriaCredito().get(i).getEmpresa()+
                                "\nEstado: "+lista.get(u).getHistoriaCredito().get(i).getEstado()+
                                "\nValor: "+lista.get(u).getHistoriaCredito().get(i).getValor());
                         System.out.println("-------------------------------------------------------");
                    }
                }
            }
            
            //entrada.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("No se encuentra la clase ");
            menu();
       }catch (IOException ex){
            menu();
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                    menu();
                } catch (IOException ignored) {
                    menu();
                }
            }
         }
    }
    
    
    /**
     * metodo que se encargade crear y guardar la informacion en el archivo previamente especificado 
     * @param content : es la lista de persona con los datos ya cargados
     */
    public void insertar(ArrayList<Persona> content) {
        ObjectOutputStream salida = null;
        try {
            File data = new File("archvivo\\documento.txt");
            salida = new ObjectOutputStream(new FileOutputStream(data));
            salida.writeObject(content);
            salida.close();
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            menu();
        } catch (IOException e) {
            //e.printStackTrace();
            menu();
        } 
        
    }
      
    
    
}
