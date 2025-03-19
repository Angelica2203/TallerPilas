import java.util.Scanner;
import java.util.Stack;
import javax.swing.JOptionPane;
public class metodos 
{
    Scanner sc = new Scanner(System.in);
    public Stack<ObjRepuesto> IngresarRepuesto(Stack<ObjRepuesto> pila) 
    {
        ObjRepuesto o = new ObjRepuesto();
        o.setMarca(JOptionPane.showInputDialog("Ingrese la marca"));
        String entrada;
        // Validar referencia
        entrada = JOptionPane.showInputDialog("Ingrese la referencia");
        while (!entrada.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número entero válido.");
            entrada = JOptionPane.showInputDialog("Ingrese la referencia (número entero):");
        }
        o.setReferencia(Integer.parseInt(entrada));

        // Validar cantidad
        entrada = JOptionPane.showInputDialog("Ingrese la cantidad");
        while (!entrada.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número entero válido.");
            entrada = JOptionPane.showInputDialog("Ingrese la cantidad (número entero):");
        }
        o.setCantidad(Integer.parseInt(entrada));
        
        // Validar precio
        entrada = JOptionPane.showInputDialog("Ingrese el precio");
        while (!entrada.matches("\\d+(\\.\\d+)?")) {
            JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido.");
            entrada = JOptionPane.showInputDialog("Ingrese el precio (número válido):");
        }
        o.setPrecio(Double.parseDouble(entrada));
        pila.push(o);
        JOptionPane.showMessageDialog(null, "Repuesto ingresado correctamente");
        MostrarPila(pila);
        return pila;
    }
    public void MostrarPila(Stack<ObjRepuesto> pila) 
    {
        for (ObjRepuesto o : pila) 
        {
            System.out.println("Marca: " + o.getMarca());
            System.out.println("Referencia: " + o.getReferencia());
            System.out.println("Cantidad: " + o.getCantidad());
            System.out.println("Precio " + o.getPrecio());
            System.out.println();
        }
    }
    public void BuscarRepuesto(Stack<ObjRepuesto> pila)
    {
        while (pila.isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay repuestos ingresados");
            //pila = IngresarRepuesto(pila); //para llevarlo a ingresar repuesto
            return;
        }
        System.out.println("--CONSULTAR-- \n" + "1.Por Marca\n" + "2.Por Referencia\n");
        int opt = sc.nextInt();
        String dato = "";
        int dato2 = 0;
        if (opt == 1) 
        {
            System.out.println("Ingrese la marca a consultar");
            dato = sc.next();
        } else 
        {
            System.out.println("Ingrese la referencia a consultar");
            dato2 = sc.nextInt();
        }
        for (ObjRepuesto repuesto : pila) 
        { 
            if(opt == 1)
            {
                if (repuesto.getMarca().equalsIgnoreCase(dato)) 
                {
                    System.out.println("REPUESTO ENCONTRADO\n" +
                                    "Marca: " + repuesto.getMarca() + "\n" +
                                    "Referencia: " + repuesto.getReferencia() + "\n" +
                                    "Cantidad: " + repuesto.getCantidad() + "\n" +
                                    "Precio: " + repuesto.getPrecio() + "\n");
                } 
                else
                {
                    System.out.println("Repuesto no encontrado");
                }
            }
            else
            {
                if (repuesto.getReferencia() == dato2) 
                {
                    System.out.println("REPUESTO ENCONTRADO\n" +
                                    "Marca: " + repuesto.getMarca() + "\n" +
                                    "Referencia: " + repuesto.getReferencia() + "\n" +
                                    "Cantidad: " + repuesto.getCantidad() + "\n" +
                                    "Precio: " + repuesto.getPrecio() + "\n");
                } 
                else
                {
                    System.out.println("Repuesto no encontrado");
                }
            }
        }
    }
    public void ModificarRepuesto(Stack<ObjRepuesto> pila) 
    {
        while (pila.isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay repuestos ingresados");
            return;
        }
        System.out.println("Ingrese la referencia del repuesto a modificar");
        int ref = sc.nextInt();
        boolean encontrado = false;
        for (ObjRepuesto repuesto : pila) 
        {
            if (repuesto.getReferencia() == ref) 
            {
                encontrado = true;
                System.out.println("---MODIFICAR--- \n" + "1.Marca\n" + "2.Referencia\n" + "3.Cantidad\n" + "4.Precio\n");
                int opt = sc.nextInt();
                switch (opt) 
                {
                    case 1:
                        System.out.println("Ingrese la nueva marca");
                        repuesto.setMarca(sc.next());
                        break;
                    case 2:
                        System.out.println("Ingrese la nueva referencia");
                        repuesto.setReferencia(sc.nextInt());
                        break;
                    case 3:
                        System.out.println("Ingrese la nueva cantidad");
                        repuesto.setCantidad(sc.nextInt());
                        break;
                    case 4:
                        System.out.println("Ingrese el nuevo precio");
                        repuesto.setPrecio(sc.nextDouble());
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
                System.out.println("REPUESTO MODIFICADO\n" +
                                    "Marca: " + repuesto.getMarca() + "\n" +
                                    "Referencia: " + repuesto.getReferencia() + "\n" +
                                    "Cantidad: " + repuesto.getCantidad() + "\n" +
                                    "Precio: " + repuesto.getPrecio() + "\n");
                return;
            }
        }
        if (!encontrado) 
        {
            System.out.println("Repuesto no encontrado");
            return;
        }
    }
    public void EliminarRepuesto(Stack<ObjRepuesto> pila) 
    {
        while (pila.isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay repuestos ingresados");
            return;
        }
        System.out.println("Ingrese la referencia del repuesto a eliminar");
        int ref = sc.nextInt();
        boolean encontrado = false;
        for (ObjRepuesto repuesto : pila) 
        {
            if (repuesto.getReferencia() == ref) 
            {
                encontrado = true;
                pila.remove(repuesto);
                System.out.println("REPUESTO ELIMINADO");
                MostrarPila(pila);
                return;
            }
        }
        if (!encontrado) 
        {
            System.out.println("Repuesto no encontrado");
            return;
        }
        
    }
    public void VenderRepuesto(Stack<ObjRepuesto> pila) 
    {
        while (pila.isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay repuestos ingresados");
            return;
        }
        System.out.println("Ingrese la referencia del repuesto a vender");
        int ref = sc.nextInt();
        boolean encontrado = false;
        for (ObjRepuesto repuesto : pila) 
        {
            if (repuesto.getReferencia() == ref) 
            {
                encontrado = true;
                System.out.println("Ingrese la cantidad a vender");
                int cant = sc.nextInt();
                if (cant > repuesto.getCantidad()) 
                {
                    System.out.println("No hay suficiente cantidad para vender");
                    return;
                }
                repuesto.setCantidad(repuesto.getCantidad() - cant);
                System.out.println("VENTA REALIZADA\n" + 
                                   "Marca: " + repuesto.getMarca() + "\n" +
                                    "Referencia: " + repuesto.getReferencia() + "\n" +
                                    "Cantidad: " + repuesto.getCantidad() + "\n" +
                                    "Precio: " + repuesto.getPrecio() + "\n");
                return;
            }
        }
        if (!encontrado) 
        {
            System.out.println("Repuesto no encontrado");
            return;
        }
    }
}
    

