/* 
 * 
 * 
 * 
 */
package examentapunidad1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
Escribir un programa que pida un número que represente segundos,
inferior a un millón y calcule su equivalente desglosándolo en 
días, horas, minutos y segundos. Ejemplo

43300 segundos

equivale a 0 días 12 horas 1 minuto 40 segundo

*/

// Autor: Diego Jesús Medina López
public class CalculadoraDeTiempo extends JFrame{
    private JButton Boton;
    private JTextField Campo;
    public CalculadoraDeTiempo(){
        //Poner título a la ventada, generar el Layout con GridBagLayout y Crear sus restricciones base
        super("Calculadora analítica de Tiempo");
        Container Contain = this.getContentPane();
        Contain.setLayout(new GridBagLayout());
        GridBagConstraints Restr = new GridBagConstraints();
        
        Font Fuente = new Font ("Dialog", Font.PLAIN, 15);
        
        //Generar un Texto pidiendo los segunndos
        JLabel Texto = new JLabel("Introduzca el tiempo en segundos: ");
        Texto.setFont(Fuente);
        Restr.gridy=0;
        Restr.gridx=0;
        Restr.gridwidth=1;
        Restr.gridheight=1;
        Restr.weighty=1;
        Restr.weightx=1;
        //Agregarlo al Contenedor
        Contain.add(Texto, Restr);
        
        //Generar un campo para ingresar un texto
        Campo = new JTextField("Aqui solo ingrese numeros");
        Campo.setSize(200, 400);
        
        Restr.gridy=1;
        Restr.gridx=0;
        Restr.gridwidth=1;
        Restr.gridheight=1;
        Restr.weighty=0;
        Restr.weightx=1;
        //Agregarlo al Contenedor
        Contain.add(Campo, Restr);
        
        Boton = new JButton("Calcular");
        AccionBoton oyenteBoton = new AccionBoton();
        Boton.addActionListener(oyenteBoton);
        Restr.gridy=2;
        Restr.gridx=0;
        Restr.gridwidth=1;
        Restr.gridheight=1;
        Restr.weighty=1;
        Restr.weightx=1;
        Contain.add(Boton, Restr);
        
    }
    
    
    public static void main(String[]args){
        CalculadoraDeTiempo Ventana = new CalculadoraDeTiempo();
        Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Ventana.setLocation(500, 300);
        Ventana.pack();
        Ventana.setVisible(true);
    }
    //"Calcular" Recibe: Tiempo en segundos
    public static String Calcular(int Sec){
        int Secs=Sec;
        int Min=0;
        for(; !(Secs < 60);Min++){
            Secs = Secs-60;
        }
        int Hrs=0;
        for(; !(Min < 60);Hrs++){
            Min = Min-60;
        }
        int Dias=0;
        for(; !(Hrs <= 24);Dias++){
            Hrs = Hrs-60;
        }
        String STR= Dias+" Dia/s "+Hrs+" Hora/s "+Min+" Minuto/s "+Secs+" Segundo/s ";
        
        return STR;
    }
    
    class AccionBoton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if((JButton)e.getSource() == Boton){
                int Var = Integer.parseInt(Campo.getText());
                JOptionPane.showMessageDialog(null, "El Resultado es: "+Calcular(Var), "Resultado" , JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
