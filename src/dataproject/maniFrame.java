package dataproject;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class maniFrame extends JFrame {
    private JLabel sliderComment = new JLabel("Delay Amount");
    protected JSlider slider = new JSlider();
    private String st = null;
    public JScrollPane sc;
    public JLabel shm = new JLabel();
    private JLabel comt = new JLabel("Stack     Simulation");
    private Istack<String> st1 = new Istack<>();
    private DefaultListModel<String> list = new DefaultListModel<>();
    private JList<String> model = new JList<>(list);
    public JTextArea stack1 = new JTextArea();
    public JTextArea stack2 = new JTextArea();
    private JLabel background = new JLabel();
    private JLabel valuePoped = new JLabel("", SwingConstants.CENTER);
    private JLabel peek = new JLabel("", SwingConstants.CENTER);
    protected JButton exitButton = new JButton();
    private JButton push = new JButton();
    private JButton clear = new JButton("Clear");
    private JButton pop = new JButton();
    private JButton calculate = new JButton("Evaluate");
    private JButton Go2EE = new JButton();
    private JButton back = new JButton("<-Back");
    private JPanel EEPanel = new JPanel();
    public JTextField txt = new JTextField();
    private JLabel comment = new JLabel("Write Your equ here ^");
    private Timer t;
    private Timer t2;

    public maniFrame() {
        setLayout(null);
        sc = new JScrollPane(stack2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        addObjects();
        setLocations();
        customize();
        loadCode();

        stack2.setForeground(Color.blue);
        stack1.setForeground(Color.blue);
        model.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        list.addElement("omar");
        list.addElement("ali");
        list.addElement("ahmad");
        list.addElement("pap");
        list.addElement("lol");
        list.addElement("hye");
        EEPanel.setVisible(false);
        EEPanel.setLayout(null);

        setSize(500, 400);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void addObjects() {
        EEPanel.add(sliderComment);
        EEPanel.add(slider);
        EEPanel.add(sc);
        EEPanel.add(comt);
        EEPanel.add(shm);
        add(EEPanel);
        add(clear);
        add(Go2EE);
        add(valuePoped);
        add(peek);
        add(model);
        add(push);
        add(pop);
        EEPanel.add(calculate);
        EEPanel.add(stack1);
        EEPanel.add(stack2);
        EEPanel.add(back);
        EEPanel.add(comment);
        EEPanel.add(txt);
        add(exitButton);
        add(background);
    }

    public void setLocations() {
        sliderComment.setBounds(0, 220, 150, 20);
        slider.setBounds(20, 250, 100, 20);
        shm.setBounds(15, -5, 30, 60);
        comt.setBounds(120, 105, 330, 50);
        stack1.setBounds(150, 150, 40, 210);
        stack2.setBounds(230, 150, 230, 210);
        calculate.setBounds(385, 45, 100, 40);
        back.setBounds(10, 340, 100, 40);
        txt.setBounds(25, 55, 350, 30);
        comment.setBounds(25, 90, 200, 30);
        exitButton.setBounds(398, 15, 40, 15);
        EEPanel.setBounds(0, 0, 500, 400);
        background.setBounds(0, 0, 500, 400);
        model.setBounds(65, 55, 100, 280);
        valuePoped.setBounds(275, 160, 150, 30);
        peek.setBounds(275, 230, 150, 30);
        push.setBounds(180, 300, 90, 40);
        pop.setBounds(275, 300, 90, 40);
        Go2EE.setBounds(370, 300, 80, 40);
        clear.setBounds(75, 340, 80, 30);
    }

    public void customize() {
        slider.setValue(2000);
        sliderComment.setForeground(Color.white);
        slider.setMinimum(100);
        slider.setMaximum(10000);
        slider.setBackground(new Color(77, 79, 78));
        shm.setVisible(false);
        shm.setIcon(new ImageIcon(getClass().getResource("/images/shm.jpg")));
        comt.setFont(new Font("Arial", 10, 35));
        comt.setForeground(Color.red);
        comment.setFont(new Font("Arial", 18, 18));
        txt.setFont(new Font("Arial", 18, 18));
        back.setBackground(new Color(79, 77, 78));
        calculate.setBackground(new Color(79, 77, 78));
        calculate.setForeground(Color.white);
        txt.setForeground(new Color(79, 77, 78));
        back.setForeground(Color.white);
        comment.setForeground(Color.white);
        EEPanel.setBackground(new Color(79, 77, 78));
        valuePoped.setForeground(Color.white);
        peek.setForeground(Color.white);
        peek.setFont(new Font("Arial", 18, 18));
        valuePoped.setFont(new Font("Arial", 18, 18));
        push.setIcon(new ImageIcon(getClass().getResource("/images/push1.jpg")));
        pop.setIcon(new ImageIcon(getClass().getResource("/images/pop1.jpg")));
        Go2EE.setIcon(new ImageIcon(getClass().getResource("/images/go2.jpg")));
        Go2EE.setRolloverIcon(new ImageIcon(getClass().getResource("/images/go22.jpg")));
        push.setRolloverIcon(new ImageIcon(getClass().getResource("/images/push2.jpg")));
        pop.setRolloverIcon(new ImageIcon(getClass().getResource("/images/pop2.jpg")));
        background.setIcon(new ImageIcon(getClass().getResource("/images/Background_.jpg")));
        exitButton.setIcon(new ImageIcon(getClass().getResource("/images/ex1.jpg")));
        exitButton.setRolloverIcon(new ImageIcon(getClass().getResource("/images/ex2.jpg")));
        exitButton.setBorder(null);
        push.setBorder(null);
        Go2EE.setBorder(null);
        pop.setBorder(null);
        model.setBackground(Color.darkGray);
        model.setForeground(new Color(255, 255, 255));
        clear.setForeground(Color.white);
        clear.setBackground(new Color(79, 77, 78));
    }

    public void loadCode() {
        st = null;
        calculate.addActionListener((ActionEvent e) -> {
            int x = slider.getValue();
            drawAnswer d = new drawAnswer();
            d.x.hideP();
            d.x.txt.setText(new myString(txt.getText()).toPostfix());
            d.x.slider.setValue(2000);
            this.setVisible(false);
            Thread th = new Thread(d);
            th.start();
            exitButton.setVisible(true);
            d.x.slider.setValue(x);

        });

        exitButton.addActionListener((ActionEvent a) -> {
            JOptionPane.showMessageDialog(null, "see you again ^_^");
            System.exit(0);
        });
        push.addActionListener((ActionEvent ae) -> {
            if (list.getSize() == 0) {
                valuePoped.setText("");
            }
            String s = JOptionPane.showInputDialog(null, "Please Enter The value you want to push");
            if (s == null || s.length() == 0) {
                return;
            }

            list.addElement(s);
            peek.setText(s);
        });
        pop.addActionListener((ActionEvent ae) -> {

            if (list.getSize() == 0) {
                valuePoped.setText("Stack is empty !");
                return;
            }
            String s = list.get(list.getSize() - 1);
            list.removeElementAt(list.getSize() - 1);
            valuePoped.setText(s);
            if (list.size() != 0) {
                peek.setText(list.get(list.size() - 1));
            } else {
                peek.setText(null);
            }
        });
        clear.addActionListener((ActionEvent ae) -> {
            if (list.getSize() == 0) {
                JOptionPane.showMessageDialog(null, "the stack is already empty");
                return;
            }
            valuePoped.setText("");
            t2 = new Timer(10, (ActionEvent sf) -> {
                if (model.getSize().height == 270) {
                    t2.stop();
                }
                model.setSize(100, model.getSize().height + 10);
            });
            t = new Timer(5, (ActionEvent av) -> {
                if (model.getSize().height == 0) {
                    t.stop();
                    t2.start();
                    list.clear();
                    peek.setText("");
                    valuePoped.setText("");
                }
                model.setSize(100, model.getSize().height - 10);

            });
            t.start();
        });

        Go2EE.addActionListener((ActionEvent booring) -> {
            hideP();
        });
        back.addActionListener((ActionEvent booring) -> {
            showP();
        });
        slider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                sliderComment.setText("Delay  : " + slider.getValue() + " mi sec");
            }
        });

    }

    public void hideP() {
        getContentPane().removeAll();
        this.setSize(500, 401);
        this.setSize(500, 400);
        add(exitButton);
        add(EEPanel);
        EEPanel.setVisible(true);

    }

    public void showP() {
        EEPanel.setVisible(false);
        getContentPane().removeAll();
        this.setSize(500, 401);
        this.setSize(500, 400);
        addObjects();
    }

    private boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception sf) {
            return false;
        }
        return true;
    }

}
