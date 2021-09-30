package com.company;

import javax.swing.*;
import java.awt.*;

public class ThreadClass implements Runnable{
    public ThreadClass() {
    }

    @Override
    public void run() {
        JDialog defaultJDialogW= new JDialog();
        defaultJDialogW.setPreferredSize(new Dimension(600,400));
        defaultJDialogW.setTitle("Upozorenje");
        JPanel defaultJPanelW= new JPanel();
        defaultJPanelW.setPreferredSize(new Dimension(600,400));
        defaultJPanelW.setBackground(Color.darkGray);
        defaultJPanelW.setLayout(new GridBagLayout());
        ImageIcon warningIconW= new ImageIcon("src/com/company/remove.png");
        JLabel defaultJLabelW=new JLabel(warningIconW);
        JLabel defaultJLabelTextW= new JLabel("Unešena šifra ili korisničko ime je zauzeto");
        defaultJLabelTextW.setForeground(Color.white);

        GridBagConstraints constraintsW= new GridBagConstraints();

        constraintsW.gridx=0;
        constraintsW.gridy=0;
        constraintsW.insets= new Insets(0, 0, 20, 0);
        defaultJPanelW.add(defaultJLabelW, constraintsW);
        constraintsW.gridx=0;
        constraintsW.gridy=1;
        defaultJPanelW.add(defaultJLabelTextW, constraintsW);
        defaultJDialogW.add(defaultJPanelW);
        defaultJDialogW.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        defaultJDialogW.pack();
        defaultJDialogW.setVisible(true);

    }
}
