import javafx.scene.shape.Circle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;
import java.awt.PointerInfo.*;
public class SwingTutorial extends JFrame implements ActionListener, MouseMotionListener, MouseListener, ChangeListener {
    private JButton button1,button2;
    JTextField textField1;
    private int size = 0;
    String loc ="";
    private Graphics g;
    private Color c = Color.BLACK;
    private JRadioButton radio1,radio2,radio3;
    private JSlider sizeOfPen;
    private ArrayList<Objectobject> obj = new ArrayList<>();
    private File file;
    public static void main(String[] args)
    {
        new SwingTutorial();
    }
    private SwingTutorial()
    {
        this.setLayout(new BorderLayout());
        this.setSize(800,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.requestFocus();
        this.setTitle("Simple Drawing Application");
        this.setResizable(false);

        JPanel JPanel1 = new JPanel();
        JPanel jpanel2 = new JPanel();
        jpanel2.setBackground(Color.ORANGE);
        radio1 = new JRadioButton("Red");
        radio2 = new JRadioButton("Magenta");
        radio3 = new JRadioButton("Black");
        JLabel label2 = new JLabel("Size of your pen/drawing utensil:");
        sizeOfPen = new JSlider(0,30,0);
        sizeOfPen.setMajorTickSpacing(10);
        sizeOfPen.setMinorTickSpacing(1);
        sizeOfPen.setPaintTicks(true);
        sizeOfPen.setPaintLabels(true);
        sizeOfPen.addChangeListener(this);
        jpanel2.add(radio1);
        jpanel2.add(radio2);
        jpanel2.add(radio3);
        jpanel2.add(label2);
        jpanel2.add(sizeOfPen);
        radio1.addActionListener(this);
        radio2.addActionListener(this);
        radio3.addActionListener(this);
        ButtonGroup btnGrp = new ButtonGroup();
        btnGrp.add(radio1);
        btnGrp.add(radio2);
        btnGrp.add(radio3);
        radio3.setSelected(true);
        JPanel1.setLayout(new FlowLayout());
        button1 = new JButton("Clear");
        button1.setPreferredSize(new Dimension(80,30));
        button1.addActionListener(this);
        button2 = new JButton("Save");
        button2.setPreferredSize(new Dimension(80,30));
        button2.addActionListener(this);
        JPanel1.setSize(800,600);
        JPanel1.addMouseMotionListener(this);
        JPanel1.addMouseListener(this);
        JLabel label = new JLabel();
//        JPanel1.add(label);
        this.add(jpanel2,BorderLayout.PAGE_END);
        jpanel2.add(button1);
        jpanel2.add(button2);
        this.add(JPanel1);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
if(e.getSource()==button1)
{
    for (Objectobject objectobject : obj) {
        g.clearRect(objectobject.getXpos(), objectobject.getYpos(), objectobject.getSize1(), objectobject.getSize1());
    }
}
else if (e.getSource()==button2) {
BufferedImage bufferedImage = new BufferedImage(800,600,BufferedImage.TYPE_INT_ARGB);
g = bufferedImage.createGraphics();
for(Objectobject o : obj)
{
    g.setColor(o.getC());
    g.fillOval(o.getXpos(),o.getYpos(),size,size);
}
g.dispose();
file = new File("MyImage.png");
try{
    ImageIO.write(bufferedImage,"png",file);
}
catch (IOException ew)
{
    ew.printStackTrace();
}

}

if(e.getSource()==radio1)
{
    c=Color.RED;
}
else if(e.getSource()==radio2)
{
    c=Color.MAGENTA;
}
else if(e.getSource()==radio3)
{
    c=Color.black;
}
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        g = getGraphics();
        if(e.getY()<726-size) {
            g.setColor(c);
            g.fillOval(e.getX() - 10, e.getY() + 15, size, size);
            obj.add(new Objectobject(e.getX() - 10,e.getY() + 15,c,size));
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
//   label.setText("X= "+e.getX()+ " Y= "+e.getY());
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        g = getGraphics();
        if(e.getY()<716-size) {
            g.setColor(c);
            g.fillOval(e.getX() - 10, e.getY() + 15, size, size);
            obj.add(new Objectobject(e.getX() - 10,e.getY() + 15,c,size));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        size = sizeOfPen.getValue();
    }
}
