package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame implements KeyListener {

    private static final int FRAME_WIDTH = 900;
    private static final int FRAME_HEIGHT = 950;

    private static VeldItem [][] level =  Speelveld.getHuidigLevelObj();
    private JPanel pnlMain = new JPanel(new BorderLayout());
    private JPanel pnlSpel = new JPanel();
    private JPanel pnlKnoppen = new JPanel();
    private JPanel pnlText = new JPanel();
    private static int resetCounter = 3;
    private JLabel message = new JLabel(" ");

    public Frame(){
        setResizable(false);
        createComponents();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/img/Poggers.jpg"));
        setTitle("Pepe is verdrietig");
        addKeyListener(this);
        setFocusable(true);
    }

    /**
     * Kijkt respectievelijk naar welke directie de gebruiker heen wilt gaan. Gaat dan eerst na of de bestemmings-tegel
     * beloopbaar is, zoja; beweeg Player naar de bestemming en zonee; doe niks.
     *
     * Kijkt ook na elke key press of het eindeBereikt boolean true is. Zoja, geef een dialog scherm weer die het
     * volgende level inschakelt.
     *
     * @param e is de ingedrukte toets op het keybord.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int curX = Speelveld.huidigX();
        int curY = Speelveld.huidigY();
        int newX = curX;
        int newY = curY;
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                newY = curY - 1;
                break;
            case KeyEvent.VK_DOWN:
                newY = curY + 1;
                break;
            case KeyEvent.VK_LEFT:
                newX = curX - 1;
                break;
            case KeyEvent.VK_RIGHT:
                newX = curX + 1;
                break;
            case KeyEvent.VK_ENTER:
                dispose();
                new Speelveld(3);
                break;
        }
        VeldItem itemNieuw = Speelveld.getVeldItem(newY, newX);
        this.message.setText(itemNieuw.getMessage(Speelveld.getPlayer()));
        if (itemNieuw.isBeloopbaar(Speelveld.getPlayer())) {
            itemNieuw.uitvoeren(Speelveld.getPlayer());
            Speelveld.beweegPlayerNaar(newX, newY);
            if(Eindveld.isEindeBereikt() && Speelveld.getHuidigLevelNr() == 3){
                dispose();
                stopInGevangenis();
            }
            if(Eindveld.isEindeBereikt() && Speelveld.getHuidigLevelNr() != 3){
                JOptionPane.showMessageDialog(this, "Je hebt het level gehaald! Op naar 't volgende level");
                dispose();
                Eindveld.eindeBereikt = false;
                new Speelveld(Speelveld.getHuidigLevelNr()+1);
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}

    /**
     * Actionlistener op de exitknop. Het verwijdert het huidige frame.
     */
    class ExitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    /**
     * Actionlistener op de resetknop. Het verwijdert eerst het huidige frame en maakt een nieuwe frame aan
     * waar alle objecten en images weer op hun originele plek stonden
     */
    class ResetListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            resetCounter = resetCounter - 1;
            new Speelveld(Speelveld.getHuidigLevelNr());
        }
    }

    /**
     * Maakt een achtergrond Panel: pnlMain en twee Panels die hierop komen: pnlGame en pnlButtons
     * Op pnlButtons worden de exit en reset buttons aangemaakt met actionlisteners
     */
    private void createComponents(){
        pnlText.setBackground(new Color(253,227,167));
        pnlText.add(message);
        pnlMain.add(pnlText);

        pnlSpel.setLayout(new GridLayout(11,11));
        pnlKnoppen.setBackground(new Color(41,182,246));
        pnlSpel.setBackground(new Color(253,227,167));
        maakMap();

        JButton btnExit = new JButton("Exit");
        JButton btnReset = new JButton("Reset (" + resetCounter + ")");
        if(resetCounter == 0){
            btnReset.setEnabled(false);
        }
        pnlKnoppen.add(btnExit);
        pnlKnoppen.add(btnReset);
        ActionListener resetListener = new ResetListener();
        ActionListener exitListener = new ExitListener();
        btnExit.addActionListener(exitListener);
        btnReset.addActionListener(resetListener);

        pnlMain.add(pnlSpel, BorderLayout.CENTER);
        pnlMain.add(pnlKnoppen, BorderLayout.PAGE_END);
        pnlMain.add(pnlText, BorderLayout.PAGE_START);
        add(pnlMain);
    }

    private void stopInGevangenis() {
            JLabel image = new JLabel((new ImageIcon(new ImageIcon("src/img/Pepe_prison2.gif").getImage().getScaledInstance(1000, 950, Image.SCALE_DEFAULT))));
            JFrame jeBaiter = new JFrame("Pepe is in gevangenis");
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            jeBaiter.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
            jeBaiter.setSize(1000, 1000);
            jeBaiter.add(image);

            JOptionPane.showMessageDialog(jeBaiter, "CHEATER");
            jeBaiter.setIconImage(Toolkit.getDefaultToolkit().getImage("src/img/Poggers.jpg"));
            jeBaiter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jeBaiter.getContentPane().setBackground(new Color(255, 79, 196));
            jeBaiter.setVisible(true);
    }

    /**
     * Kijkt voor elke coordinaat in de twee dimensionale array 'huidigLevelObj' van Speelveld welk object er is aangemaakt
     * en maakt ImageIcon aan die hiermee overeenkomt. Deze images worden dan weergegeven op de Panel 'pnlGame'.
     *
     */
    private void maakMap(){
        for(int i = 0; i < level.length; i++){
            for (int j = 0; j < level.length; j++){
                JLabel image = new JLabel((new ImageIcon(new ImageIcon(Speelveld.getHuidigLevelObj()[i][j].getImageURL()).getImage().getScaledInstance(81, 80, Image.SCALE_DEFAULT))));
                Speelveld.addLabel(image, i, j);
                pnlSpel.add(image);
            }
        }
    }
}
