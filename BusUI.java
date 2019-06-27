package start;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author Suyash
 */
public class BusUI extends Start {

    private final JFrame busFrame;
    private final JLabel sourceLabel;
    private final JLabel destLabel;
    private final JLabel dateLabel;
    private final JTextField sourceField;
    private final JTextField destField;
    private final JButton backButton;
    private final JButton nextButton;
    private final JPanel cbuspane;
    private final JPanel seatPanel;

    public BusUI() {
        busFrame = new JFrame("Book a Bus");
        sourceLabel = new JLabel("Enter Source : ");
        destLabel = new JLabel("Enter Destination : ");
        dateLabel = new JLabel("Select Date : ");
        backButton = new JButton("Cancel");
        nextButton = new JButton("Next");
        sourceField = new JTextField();
        destField = new JTextField();
        cbuspane = new JPanel();
        seatPanel = new JPanel(new GridLayout(4, 2));
    }
//        myBusFrame.setSize(new Dimension(700,500));
//        myBusFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    public void busFun() {

        cbuspane.setBackground(Color.cyan);
        cbuspane.setLayout(new GridLayout(4, 2, 10, 10));

        sourceLabel.setBackground(Color.cyan);
        sourceLabel.setForeground(Color.BLACK);
        sourceLabel.setPreferredSize(new Dimension(70, 30));
        sourceLabel.setOpaque(true);
        sourceLabel.setHorizontalAlignment(JLabel.LEFT);
        sourceLabel.setVerticalAlignment(JLabel.CENTER);
        sourceLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        cbuspane.add(sourceLabel);

        sourceField.setPreferredSize(new Dimension(70, 30));
        cbuspane.add(sourceField);

        destLabel.setBackground(Color.cyan);
        destLabel.setForeground(Color.BLACK);
        destLabel.setPreferredSize(new Dimension(70, 30));
        destLabel.setOpaque(true);
        destLabel.setHorizontalAlignment(JLabel.LEFT);
        destLabel.setVerticalAlignment(JLabel.CENTER);
        destLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        cbuspane.add(destLabel);

        destField.setPreferredSize(new Dimension(70, 30));
        cbuspane.add(destField);

        dateLabel.setBackground(Color.cyan);
        dateLabel.setForeground(Color.BLACK);
        dateLabel.setPreferredSize(new Dimension(70, 30));
        dateLabel.setOpaque(true);
        dateLabel.setHorizontalAlignment(JLabel.LEFT);
        dateLabel.setVerticalAlignment(JLabel.CENTER);
        dateLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        cbuspane.add(dateLabel);

        UtilDateModel model = new UtilDateModel();
        //model.setDate(20,04,2014);
        // Need this...
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        // Don't know about the formatter, but there it is...
        JDatePickerImpl datePicker;
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setVisible(true);
        cbuspane.add(datePicker);

        cbuspane.add(backButton);

        cbuspane.add(nextButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("sahdja");
//                myBusFrame.dispose();
//                myFrame.setVisible(true);
                launchfunc();
                busFrame.setVisible(false);
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(busFrame, "Ticket Booked Successfuly!", "Succes", JOptionPane.INFORMATION_MESSAGE);
//                busFrame.dispose();
//                launchfunc();

                setSeatUI();

            }
        });
        busFrame.setLocation(new Point(700, 300));
        busFrame.setContentPane(cbuspane);
        busFrame.setResizable(true);
        busFrame.validate();
        busFrame.pack();
        busFrame.setVisible(true);
    }

    public void setSeatUI() {
        JLabel msg = new JLabel("Select Your Seat/seats");
        msg.setFont(new Font("Arial", Font.BOLD, 22));
        seatPanel.add(msg);
        seatPanel.add(new JLabel());
        JCheckBox cb1 = new JCheckBox(); // 1 
        cb1.setSize(new Dimension(60, 60));
        cb1.setIcon(new ImageIcon("download.png"));
        seatPanel.add(cb1);
        cb1.setSelectedIcon(new ImageIcon("download1.png"));
        cb1.setContentAreaFilled(false);

        JCheckBox cb2 = new JCheckBox(new ImageIcon("download.png")); // 2
        cb2.setSize(new Dimension(60, 60));
        seatPanel.add(cb2);
        cb2.setSelectedIcon(new ImageIcon("download1.png"));
        cb2.setContentAreaFilled(false);
//        cb1.setIcon(new ImageIcon("download.png"));
//        JLabel l = new JLabel();
//        l.setIcon(new ImageIcon("download.png"));
        JCheckBox cb3 = new JCheckBox(new ImageIcon("download.png")); // 3
        cb3.setSize(new Dimension(60, 60));
        seatPanel.add(cb3);
        cb3.setSelectedIcon(new ImageIcon("download1.png"));
        cb3.setContentAreaFilled(false);

        JCheckBox cb4 = new JCheckBox(new ImageIcon("download.png")); // 4
        cb4.setSize(new Dimension(60, 60));
        seatPanel.add(cb4);
        cb4.setSelectedIcon(new ImageIcon("download1.png"));
        cb4.setContentAreaFilled(false);

        JCheckBox cb5 = new JCheckBox(new ImageIcon("download.png")); // 5
        cb5.setSize(new Dimension(60, 60));
        seatPanel.add(cb5);
        cb5.setSelectedIcon(new ImageIcon("download1.png"));
        cb5.setContentAreaFilled(false);

        JCheckBox cb6 = new JCheckBox(new ImageIcon("download.png")); // 6
        cb6.setSize(new Dimension(60, 60));
        seatPanel.add(cb6);
        cb6.setSelectedIcon(new ImageIcon("download1.png"));
        cb6.setContentAreaFilled(false);

        busFrame.setDefaultCloseOperation(busFrame.EXIT_ON_CLOSE);
        busFrame.setResizable(false);
        busFrame.remove(cbuspane);
        busFrame.setContentPane(seatPanel);
        busFrame.repaint();
        busFrame.validate();
//        
        busFrame.pack();

    }

}
