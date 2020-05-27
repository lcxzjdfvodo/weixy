package com.planegame;

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Game01 extends JFrame {

    public void launchFrame(){
        this.setTitle("魏晓阳-程序猿作品");
        this.setVisible(true);
        this.setSize(600,600);
        this.setLocation(270,200);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        Game01 f=new Game01();
        f.launchFrame();
    }
}
