package oopguid;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Collections;
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
    private static JButton[] gombok;
    private static final int DB = 10;
     private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private JLabel lblLeiras;
    private JTextField textField;
    private boolean keveres;
    private JCheckBox kever;
    
    

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
        /*
        Ugyanigy meg kell csináln i a pinkódosat is
        PIN kód panelhez adom a gombokat hozzá
        a pinkódpanelt pedig a bejelentkezés panelhez adom hozzá
        
        ha megvannak a gombok, akkor bele kell rakni egy listába
        újra-akkor alaphelyzet - settext-alaphelyzetbe átirogatjuk a gombokat - nem alaphelyzetbe rakjuk
        keverésnél a számlista megkeverése
        
        kilép - popup belső oszhtály,window adapterből öröklődik, a window closi ng metódust kell felülírni
        a frame add window listener paramétere az új postály, kilép metódus
        
        */
        
        JPanel bejelentkezesPanel = new JPanel();
        bejelentkezesPanel.add(new JLabel("Bejelentkezés"));
        //bejelentkezés - pin kód
        JPanel pin = new JPanel();
        bejelentkezesPanel.setLayout(new BorderLayout());
        
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
        
       gombok = new JButton[DB];
        
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
        
         GridLayout grid = new GridLayout(4,3);
         pin.setLayout(grid);
        
         for (int i = 0; i < DB; i++) {
            pin.add(gombok[i]);
        }
        
        bejelentkezesPanel.add(pin,BorderLayout.WEST);
        
        //bejelentkezés - beállítás
        JPanel beall1 = new JPanel();
        GridLayout grid2 = new GridLayout(1,1);
        beall1.setLayout(grid2);
        
        kever = new JCheckBox("kever");
        lblLeiras = new JLabel("<html><p>Kód:</center></html>");
        textField = new JTextField();
        
        beall1.add(kever);
        beall1.add(lblLeiras);
        beall1.add(textField);
        
        bejelentkezesPanel.add(beall1,BorderLayout.EAST);
        ful.addTab("Bejelentkezés", bejelentkezesPanel);
        JPanel jatekPanel = new JPanel();
        jatekPanel.add(new JLabel("Jatek"));
        ful.addTab("Játék", jatekPanel);
        
        frame.add(ful);
        //Fülecskék vége 
        
        frame.setVisible(true);

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
            int i = hanyadik((JButton)e.getSource());
            String istring = String.valueOf(i);
            String pinkod = "";
            pinkod = pinkod+istring;
            //textField.setText(pinkod);
            
        }
        private int hanyadik(JButton b){
            int i = 0;
            while(b != gombok[i]){
                i++;
            }
            gombok[i].setBackground(Color.BLUE);
            return i;
        }
    }/*
 private void chbKozepreItemStateChanged(java.awt.event.ItemEvent evt) {                                            
        
        keveres = kever.isSelected();
        Collections.shuffle(gombok);
        
    }                                           
*/
    

}
