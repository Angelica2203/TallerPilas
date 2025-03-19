import java.util.Stack;

import javax.swing.JOptionPane;

public class principal 
{
    public int Menu()
    {
        int vrUsu; 
        do 
        {
            vrUsu = Integer.parseInt(JOptionPane.showInputDialog("---------- MENU ----------\n" +
                                                                 "1.Ingresar Repuesto\n" +
                                                                 "2.Buscar Repuesto\n" +
                                                                 "3.Modificar Repuesto\n" +
                                                                 "4.Eliminar Repuesto\n" + 
                                                                 "5.Vender Repuesto\n" + 
                                                                 "6.Salir\n"));
            if (vrUsu > 6 || vrUsu < 1)
                JOptionPane.showMessageDialog(null,"Opcion no valido, reintente por favor");

        } while (vrUsu > 6 || vrUsu < 1);
        return vrUsu;
    }
    public static void main(String[] args) 
    {
        Stack<ObjRepuesto> pila = new Stack<>();
        int opc;
        do 
        {
            metodos met = new metodos();
            principal m = new principal();
            opc = m.Menu();
            switch (opc) 
            {
                case 1:
                    pila = met.IngresarRepuesto(pila);
                    break;
                case 2:
                    met.BuscarRepuesto(pila);
                    break;
                case 3:
                    met.ModificarRepuesto(pila);
                    break;
                case 4:
                    met.EliminarRepuesto(pila);
                    break;
                case 5:
                    met.VenderRepuesto(pila);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "El programa ha terminado");
                    break;
            }
            
        } while (opc != 6);
    }
}
