/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BouncingBall.java
 *
 * Created on Mar 28, 2010, 9:38:36 AM
 */

/*
<applet code = "BouncingBall" width = 450 height = 400>
</applet>
*/


import java.awt.Graphics;
import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Ball implements Runnable{

    boolean updirection = true;
    int power;
    Thread thread;

    boolean start = false;
    int radius;
    Point curposition;
    int topedge;
    int bottomedge;

    BouncingBall bouncingball;

    public Ball(String name,int power,int radius,Point position,BouncingBall bouncingball,int top,int bottom){
        this.power = power;
        this.radius = radius;
        curposition = position;
        topedge = top;
        bottomedge = bottom;

        thread = new Thread(this,name);
        thread.start();

        this.bouncingball = bouncingball;
    }

    @SuppressWarnings({"static-access", "empty-statement"})
    public void run(){

        while(true){

            if(!start)
                continue;
            
            if(curposition.y <= topedge){
                updirection = false;
            }

            if(curposition.y >= bottomedge){
                updirection = true;
            }

            if(updirection)
                curposition.y--;
            else
                curposition.y++;
                
            bouncingball.repaint();
            try {
                thread.sleep(100 - power);
            }
            catch (InterruptedException ex) {
                System.out.println("InterruptedException in run for " + thread.getName() + " error is " + ex.getMessage());
            }
       
        }

    }
}


public class BouncingBall extends Applet{

    private Button btn_launchstop;

    private Ball ball1,ball2,ball3;
    
    /** Initializes the applet BouncingBall */
    @Override
    public void init() {
     
        ball1 = new Ball("ball1",90,30,new Point(100,350),this,200,350);
        ball2 = new Ball("ball2",70,40,new Point(200,340),this,140,340);
        ball3 = new Ball("ball2",50,50,new Point(300,330),this,240,330);
        
        btn_launchstop = new Button("Launch");
        initButtonListener();
        
        add(btn_launchstop);
        
    }

    @Override
    public void start(){
        
    }

    @Override
    public void stop(){
    
    }
    
    @Override
    public void paint(Graphics g){

        g.setColor(Color.BLACK);
        g.drawLine(0,80,getWidth(),80);
        g.drawLine(0,380,getWidth(),380);

        g.setColor(Color.RED);
        g.drawOval(ball1.curposition.x,ball1.curposition.y,ball1.radius,ball1.radius);
        g.fillOval(ball1.curposition.x,ball1.curposition.y,ball1.radius,ball1.radius);

        g.setColor(Color.BLUE);
        g.drawOval(ball2.curposition.x,ball2.curposition.y,ball2.radius,ball2.radius);
        g.fillOval(ball2.curposition.x,ball2.curposition.y,ball2.radius,ball2.radius);

        g.setColor(Color.GREEN);
        g.drawOval(ball3.curposition.x,ball3.curposition.y,ball3.radius,ball3.radius);
        g.fillOval(ball3.curposition.x,ball3.curposition.y,ball3.radius,ball3.radius);

    }
    
    private void initButtonListener(){

        btn_launchstop.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(btn_launchstop.getLabel().equalsIgnoreCase("launch")){
                    btn_launchstop.setLabel("Stop");
                    launchBalls();
                }
                else{
                    btn_launchstop.setLabel("Launch");
                    stopBalls();
                }
            }
        });
    }

    private void stopBalls(){

        /*ball1.thread.stop();
        ball2.thread.stop();
        ball3.thread.stop();*/

        //stop is unsafe as it kills the thread & all locked monitors are unlocked hence dprecated
        ball1.start = false;
        ball2.start = false;
        ball3.start = false;
    }
    
    private void launchBalls(){
        ball1.start = true;
        ball2.start = true;
        ball3.start = true;        
    }

}
