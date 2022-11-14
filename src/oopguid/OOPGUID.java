package oopguid;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class OOPGUID {
    
    private static JFrame frame;
    private JButton[] gombok;
    private JLabel bejelentkezes, jatek;
    private JLabel pin, beall1;
    
    

    public static void main(String[] args) {
        
        new OOPGUID();
        
    }
    
    public OOPGUID(){
        ini();
    }
    
    public void ini(){
        
        frame = new JFrame("GUI- OOP 1.dolgozat");
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        Dimension kep = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(kep.width/2-150, kep.height/2-125, 300, 250);
        frame.setSize(410, 350);
        
        //Menük
        
        JMenuBar menuBar = new JMenuBar();
        JMenu mnuPrg = new JMenu("Program");
        mnuPrg.setMnemonic(KeyEvent.VK_P);
        JMenu mnuElhelyez = new JMenu("Játék elrendezése");
        mnuElhelyez.setMnemonic(KeyEvent.VK_E);
        menuBar.add(mnuPrg);
        menuBar.add(mnuElhelyez);
        
        JMenuItem menu1ujr = new JMenuItem("Újra");
        mnuPrg.addSeparator();
        JMenuItem menu1kil = new JMenuItem("Kilépés");
        
        mnuPrg.add(menu1ujr);
        mnuPrg.add(menu1kil);
        
        //Menüitem esemény
        
        menu1kil.addActionListener(new MenuKilep());
        menu1ujr.addActionListener(new MenuUjatek());
        
        //Menüitem esemény vége
        
        JMenuItem menu2viz = new JMenuItem("Vízszintes");
        JMenuItem menu2fug = new JMenuItem("Függőleges");
        
        mnuElhelyez.add(menu2viz);
        mnuElhelyez.add(menu2fug);
        
        frame.setJMenuBar(menuBar);
        
        //Menü vége
       
        //Fülecskék
        JTabbedPane ful = new JTabbedPane();
        ful.setOpaque(true);
        
        bejelentkezes = new JLabel();
        jatek = new JLabel();
        
        JPanel bejelentkezesPanel = new JPanel();
        bejelentkezesPanel.add(bejelentkezes = new JLabel());
        ful.addTab("Bejelentkezés", bejelentkezesPanel);
        JPanel jatekPanel = new JPanel();
        jatekPanel.add(jatek = new JLabel());
        ful.addTab("Játék", jatekPanel);
        
        frame.add(ful);
        //Fülecskék vége 
        //gombokini();
        //Jpanelek 
        //Bejelentkezés
        
        pin = new JLabel();
        /* alsó tartalma 
        for (JButton b:gombok) {
            pin.add(b);
        }
        
        beall1 = new JLabel();
        
        JCheckBox kever = new JCheckBox("kever");
        JLabel lblLeiras = new JLabel("<html><p>Kód:</center></html>");
        JTextField textField = new JTextField();
        
        beall1.add(kever);
        beall1.add(lblLeiras);
        beall1.add(textField);
        
        bejelentkezes.add(pin);
        bejelentkezes.add(beall1);
        
         JButton gomb1 = new JButton("1");
        bejelentkezes.add(gomb1);*/ 
        
        
        JButton gomb1 = new JButton("1");
        pin.add(gomb1);
        
        frame.setVisible(true);

    }

    private void gombokini() {
        JButton gomb1 = new JButton("1");
        JButton gomb2 = new JButton("2");
        JButton gomb3 = new JButton("3");
        JButton gomb4 = new JButton("4");
        JButton gomb5 = new JButton("5");
        JButton gomb6 = new JButton("6");
        JButton gomb7 = new JButton("7");
        JButton gomb8 = new JButton("8");
        JButton gomb9 = new JButton("9");
        JButton gomb0 = new JButton("0");
        
        gombok[0] = gomb0;
        gombok[1] = gomb1;
        gombok[2] = gomb2;
        gombok[3] = gomb3;
        gombok[4] = gomb4;
        gombok[5] = gomb5;
        gombok[6] = gomb6;
        gombok[7] = gomb7;
        gombok[8] = gomb8;
        gombok[9] = gomb9;
        
         for (JButton b : gombok) {
            b.addActionListener(new KattintasListener());
        }
    }
    
    
    private static class MenuKilep implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            kilepes();
        }
    }
    
    
    private static class MenuUjatek implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ujra();
        }
    }
    
     private static void kilepes(){
        int valasz = JOptionPane.showConfirmDialog(frame, "Kilépés", "Biztos kilép?", JOptionPane.YES_NO_OPTION);
        if(valasz == JOptionPane.YES_OPTION){
            System.exit(valasz);
        }
    }
     
     private static void ujra(){
         
     }

    private static class KattintasListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }


}
