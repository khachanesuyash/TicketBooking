package start;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Suyash
 */

public class Start {

    final JFrame parentFrame;
    private final JLabel titleLabel;
    private final JLabel modeLabel;
    private final JButton busButton;
    private final JButton trainButton;
    private final JButton flightButton;
    protected final JPanel myPanel;
    private final JPanel myPanel2;
    private final JLabel imgLbl;
    public static Start s = new Start();

    public Start() {
        imgLbl = new JLabel();
        myPanel = new JPanel(new BorderLayout());
        myPanel2 = new JPanel(new BorderLayout());
        parentFrame = new JFrame("Ticket Booking");
        titleLabel = new JLabel("Online Ticket Booking");
        modeLabel = new JLabel("Select Mode of Transport");
        busButton = new JButton("Bus");
        trainButton = new JButton("Train");
        flightButton = new JButton("Flight");
    }

    public void setFrameVisible() {
        parentFrame.setVisible(true);
    }

    public void launchfunc() {
        parentFrame.setPreferredSize(new Dimension(700, 500));
        parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel cpane1 = new JPanel();

        cpane1.setBackground(Color.LIGHT_GRAY);
        GridBagLayout grdB = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        cpane1.setLayout(grdB);

        c.gridwidth = 3;
        c.weightx = 1.0;
        c.weighty = 1.5;
//        c.gridx = 0;
//        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        cpane1.add(titleLabel, c);

        c.gridx = 0;
        c.gridy = 1;
        cpane1.add(modeLabel, c);

        c.gridwidth = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 2;
        cpane1.add(busButton, c);

        c.gridx = 1;
        c.gridy = 2;
        cpane1.add(trainButton, c);

        c.gridx = 2;
        c.gridy = 2;
        cpane1.add(flightButton, c);

        titleLabel.setBackground(Color.red);
        titleLabel.setForeground(Color.BLACK);
//        titleLabel.setPreferredSize(new Dimension(280,40));
        titleLabel.setOpaque(true);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));

        modeLabel.setBackground(Color.BLACK);
        modeLabel.setForeground(Color.WHITE);
        //myLabel2.setPreferredSize(new Dimension(400,30));
        modeLabel.setOpaque(true);
        modeLabel.setHorizontalAlignment(JLabel.CENTER);
        modeLabel.setVerticalAlignment(JLabel.CENTER);
        modeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));

        busButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(cpane1,
                        "You Selected " + busButton.getText() + " as mode of Transport. \n          Would you like to Continue?",
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//                    myPanel.remove(cpane1);
                    parentFrame.setVisible(false);
                    BusUI bus = new BusUI();
                    bus.busFun();
//                    parentFrame.setContentPane(myPanel);
                }

            }
        });

        trainButton.addActionListener((ActionEvent e) -> {
            if (JOptionPane.showConfirmDialog(cpane1,
                    "You Selected " + trainButton.getText() + " as mode of Transport. \n          Would you like to Continue?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//                parentFrame.setVisible(false);
//                BusUI bus = new BusUI();
//                bus.busFunc();

            }
        });

        flightButton.addActionListener((ActionEvent e) -> {
            if (JOptionPane.showConfirmDialog(cpane1,
                    "You Selected " + flightButton.getText() + " as mode of Transport. \n          Would you like to Continue?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//                parentFrame.setVisible(false);
//                BusUI bus = new BusUI();
//                bus.busFunc();
            }
        });

        parentFrame.setLocation(new Point(700, 300));
//        URL urlObj = new URL("shadowman.ico");
//        ImageIcon i = new ImageIcon(urlObj);
        try {
            BufferedImage bi = ImageIO.read(new File("plane.jpg"));
//        imgLbl.setIcon(i);
            parentFrame.setIconImage(bi);

        } catch (IOException e) {

            System.out.println("sjhdkf");
        }
//        imgLbl.setOpaque(true);
//        imgLbl.setBackground(Color.red);
        myPanel.add(imgLbl);
        myPanel.add(cpane1);

        parentFrame.setContentPane(myPanel);
        parentFrame.setResizable(true);
        parentFrame.validate();
        parentFrame.pack();
        parentFrame.setVisible(true);

    }

}
