import java.util.Stack;

import javax.swing.JOptionPane;

public class metodos 
{
    public void LlenarPila() 
    {
        Stack<ObjRepuesto> pila = new Stack<>();
        boolean continuar = true;
        String agregar = " ";
        while (continuar) 
        {
            ObjRepuesto o = new ObjRepuesto();
            o.setMarca(JOptionPane.showInputDialog("Ingrese la marca"));
            o.setReferencia(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la referencia")));
            o.setCantidad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad")));
            o.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio")));
            pila.push(o);
            agregar = JOptionPane.showInputDialog("Desea agregar mas Registros S/N");
            if (agregar.equalsIgnoreCase("N")) 
            {
                JOptionPane.showMessageDialog(null, "Se ha salido ");
                continuar = false;
            }

        }
        MostrarPila(pila);
        int opt = Integer.parseInt(JOptionPane.showInputDialog("-------- MENU ---------\n" +
                                                               "1.Ingresa Repuesto\n" +
                                                               "2.Buscar Repuesto\n" +
                                                               "3.Modificar Repuesto\n" +
                                                               "4.Eliminar Repuesto\n"));
        pila = AccionesRegistro(pila, opt);
        MostrarPila(pila);
    }
    public void MostrarPila(Stack<ObjRepuesto> pila) 
    {
        for (ObjRepuesto o : pila) {
            System.out.println("Marca: " + o.getMarca());
            System.out.println("Referencia: " + o.getReferencia());
            System.out.println("Cantidad: " + o.getCantidad());
            System.out.println("Precio " + o.getPrecio());
            System.out.println();
        }
    }
    public Stack<ObjRepuesto> AccionesRegistro(Stack<ObjRepuesto> pila, int opt) {
        String dato = "";
        if (opt == 1) {
            dato = JOptionPane.showInputDialog("Ingrese el registro a consultar");
        } else if (opt == 2) {
            dato = JOptionPane.showInputDialog("Ingrese el registro al que desea eliminar");
        } else {
            dato = JOptionPane.showInputDialog("Ingrese el registro al que desea Modificar");
        }
        for (Vehiculo vehiculo : pila) {
            if (vehiculo.getMarca().equalsIgnoreCase(dato)) {
                if (opt == 1) {
                    System.out.println(
                            "el registro se encuentras y es: " + vehiculo.getMarca() + " " + vehiculo.getPrecio());
                } else if (opt == 2) {
                    pila.remove(vehiculo);
                } else {
                    vehiculo.setMarca(JOptionPane.showInputDialog("Ingrese La marca"));

                }
            }
        }

        return pila;

    }

    
}
