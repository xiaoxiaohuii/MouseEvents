import java.awt.*;
import java.awt.event.*;

public class MouseEvents extends Frame implements MouseListener, MouseMotionListener {

    String msg = "";
    int mouseX = 0, mouseY = 0;
    
    public void mousePressed(MouseEvent e){
        mouseX = 100;
        mouseY = 100;
        msg = "Button down.";
        repaint();
    }

    public MouseEvents(){
        addMouseListener(this);
        addMouseMotionListener(this);
        addWindowListener(new MyWindowAdapter());
    }

    public void mouseClicked(MouseEvent me){
        msg = msg + "--- click received";
        repaint();
    }

    public void mouseEntered(MouseEvent me){
        mouseX = 100;
        mouseY = 100;
        msg = "Mouse entered.";
        repaint();
    }

    public void mouseExited(MouseEvent me){
        mouseX = 100;
        mouseY = 100;
        msg = "Mouse exited.";
        repaint();
    }

    public void mouseReleased(MouseEvent me){
        mouseX = me.getX();
        mouseY = me.getY();
        msg = "Button released.";
        repaint();
    }

    public void mouseDragged(MouseEvent me){
        mouseX = me.getX();
        mouseY = me.getY();
        msg = "*" + " mouse at " + mouseX + ", " + mouseY;
        repaint();
    }

    public void mouseMoved(MouseEvent me){
        msg = "Moving mouse at " + me.getX() + ", " + me.getY();
        repaint();
    }

    public void paint(Graphics g){
        g.drawString(msg, mouseX, mouseY);
    }

    public static void main(String[] args){
        MouseEvents appwin = new MouseEvents();

        appwin.setSize(new Dimension(500, 800));
        appwin.setTitle("MouseEvents.");
        appwin.setVisible(true);
    }
}

class MyWindowAdapter extends WindowAdapter {
    public void windowClosing(WindowEvent we){
        System.exit(0);
    }
}