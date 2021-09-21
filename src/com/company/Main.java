package com.company;



import com.toedter.calendar.JCalendar;

import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Main {


    public static LocalDateTime convertDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

    }

    public static double sumTotal;
    public static String externalGrad;
    public static double extGraduationDouble;
    public static double competitionsSum;

    public static double addPoints(double source) {
        if (source == 5.0) {
            sumTotal = 15.0;
            return sumTotal;
        }
        if (source == 4.9) {
            sumTotal = 14.5;

            return sumTotal;
        }
        if (source == 4.8) {
            sumTotal = 14.0;
            return sumTotal;
        }
        if (source == 4.7) {
            sumTotal = 13.0;
            return sumTotal;
        }
        if (source == 4.6) {
            sumTotal = 12.0;
            return sumTotal;
        }
        if (source == 4.5) {
            sumTotal = 11.0;
            return sumTotal;
        }
        if (source == 4.0) {
            sumTotal = 10.0;
            return sumTotal;
        }
        if (source == 3.0) {
            sumTotal = 6.0;
            return sumTotal;
        }
        if (source == 2.0) {
            sumTotal = 4.0;
            return sumTotal;
        } else {
            sumTotal = 0;
        }

        return sumTotal;


    }

    public static double addPointsRp(double source) {
        if (source == 5.0) {
            sumTotal = 2.5;
            return sumTotal;
        }
        if (source == 4.0) {
            sumTotal = 2.0;

            return sumTotal;
        }
        if (source == 3.0) {
            sumTotal = 1.5;
            return sumTotal;
        }
        if (source == 2.0) {
            sumTotal = 1.0;
            return sumTotal;
        } else {
            sumTotal = 0;
        }

        return sumTotal;


    }

    public static double exCalc(String input) {
        externalGrad = input;
        if (externalGrad.length() > 3) {
            System.out.println("Unešen je procenat veci od 100");
            JDialog error = new JDialog(new JFrame());
            error.setSize(new Dimension(400, 200));
            error.add(new JLabel("Unešen je procenat veci od 100"));
            error.setLayout(new GridBagLayout());
            error.setVisible(true);

        } else {
            extGraduationDouble = Double.parseDouble(externalGrad);

            extGraduationDouble = extGraduationDouble / 10;

        }
        return extGraduationDouble;

    }


    public static void main(String[] args) throws SQLException {


        //JDBC
        ConnectionHandler connectionHandler = new ConnectionHandler();


        // Creating JFrame

        MyFrame<JFrame> obj = new MyFrame<JFrame>(new JFrame());
        obj.getTheObject().setSize(new Dimension(1280, 768));
        obj.getTheObject().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.getTheObject().setTitle("Glavni panel");

        MyFrame<JFrame> popUpFrame = new MyFrame<JFrame>(new JFrame());
        popUpFrame.getTheObject().setSize(new Dimension(1280, 768));
        popUpFrame.getTheObject().setTitle("Školska godina i datum upisa");
        popUpFrame.getTheObject().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        MyFrame<JFrame> popUpFrameTwo = new MyFrame<JFrame>(new JFrame());
        popUpFrameTwo.getTheObject().setSize(new Dimension(1280, 768));
        popUpFrameTwo.getTheObject().setTitle("Opšti podaci");
        popUpFrameTwo.getTheObject().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        MyFrame<JFrame> popUpFrameThree = new MyFrame<JFrame>(new JFrame());
        popUpFrameThree.getTheObject().setSize(new Dimension(1280, 768));
        popUpFrameThree.getTheObject().setTitle("Uspjeh");
        popUpFrameThree.getTheObject().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        MyFrame<JFrame> loginJFrame = new MyFrame<JFrame>(new JFrame());
        loginJFrame.getTheObject().setPreferredSize(new Dimension(1280, 768));
        loginJFrame.getTheObject().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loginJFrame.getTheObject().setTitle("Prijava");

        loginJFrame.getTheObject().setVisible(true);

        MyFrame<JFrame> resultsJFrame = new MyFrame<JFrame>(new JFrame());
        resultsJFrame.getTheObject().setPreferredSize(new Dimension(1600, 900));
        resultsJFrame.getTheObject().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resultsJFrame.getTheObject().setTitle("Rezultati");
        //resultsJFrame.getTheObject().pack();
        resultsJFrame.getTheObject().setVisible(false);

        JFrame RsFrame = new JFrame("Tabela");
        RsFrame.setSize(new Dimension(1600, 900));
        RsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        MyFrame<JFrame> deleteJFrame = new MyFrame<JFrame>(new JFrame());
        deleteJFrame.getTheObject().setPreferredSize(new Dimension(1600, 900));
        deleteJFrame.getTheObject().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteJFrame.getTheObject().setTitle("Brisanje unosa");




        //<div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
        ////"Icon made by Freepik from www.flaticon.com"

        // Creating layouts
        BorderLayout borderLayout = new BorderLayout();
        GridLayout gridLayout = new GridLayout(0, 3, 10, 10);
        Box verticalBox = Box.createVerticalBox();
        verticalBox.setSize(new Dimension(100, 50));
        GridBagConstraints constraints = new GridBagConstraints();
        GridBagConstraints constraints2 = new GridBagConstraints();
        GridBagConstraints gridBagConstraintsTwo = new GridBagConstraints();


        // Set main JPanel
        MyFrame<JPanel> mainPanelObj = new <JPanel>MyFrame(new JPanel());
        mainPanelObj.getTheObject().setSize(new Dimension(1280, 768));
        mainPanelObj.getTheObject().setBackground(Color.darkGray);
        mainPanelObj.getTheObject().setLayout(borderLayout);

        // Set JPanels
        MyFrame<JPanel> sidePanel = new MyFrame<JPanel>(new JPanel());
        sidePanel.getTheObject().setSize(new Dimension(180, 768));
        sidePanel.getTheObject().setBackground(Color.decode("#1a1a1a"));
        sidePanel.getTheObject().setLayout(new GridLayout(6, 1, 10, 10));

        MyFrame<JPanel> plusPanel = new MyFrame<JPanel>(new JPanel());
        plusPanel.getTheObject().setSize(new Dimension(1280, 768));
        plusPanel.getTheObject().setBackground(Color.darkGray);
        plusPanel.getTheObject().setLayout(new GridBagLayout());

        MyFrame<JPanel> plusPanelTwo = new MyFrame<JPanel>(new JPanel());
        plusPanelTwo.getTheObject().setSize(new Dimension(1280, 768));
        plusPanelTwo.getTheObject().setBackground(Color.darkGray);
        plusPanelTwo.getTheObject().setLayout(new GridBagLayout());

        MyFrame<JPanel> plusPanelThree = new MyFrame<JPanel>(new JPanel());
        plusPanelThree.getTheObject().setSize(new Dimension(1280, 768));
        plusPanelThree.getTheObject().setBackground(Color.darkGray);
        plusPanelThree.getTheObject().setLayout(new GridBagLayout());

        MyFrame<JPanel> loginPanel = new MyFrame<JPanel>(new JPanel());
        loginPanel.getTheObject().setSize(new Dimension(1280, 768));
        loginPanel.getTheObject().setBackground(Color.darkGray);
        loginPanel.getTheObject().setLayout(new GridBagLayout());


        MyFrame<JPanel> resultsPanel = new MyFrame<JPanel>(new JPanel());
        resultsPanel.getTheObject().setSize(new Dimension(1600, 900));
        resultsPanel.getTheObject().setBackground(Color.darkGray);
        resultsPanel.getTheObject().setLayout(new GridBagLayout());

        MyFrame<JPanel> deletePanel = new MyFrame<JPanel>(new JPanel());
        deletePanel.getTheObject().setSize(new Dimension(1600, 900));
        deletePanel.getTheObject().setBackground(Color.darkGray);
        deletePanel.getTheObject().setLayout(new GridBagLayout());


        // Creating icons
        // all icons wil be attributed in Credit page when the project is over
        ImageIcon iconPlus = new ImageIcon("/home/emir/IdeaProjects/JavaSwingApp/src/com/company/plus(1).png");
        //<div>Icons made by <a href="https://www.flaticon.com/authors/pixel-perfect" title="Pixel perfect">Pixel perfect</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
        //"Icon made by Pixel perfect from www.flaticon.com"
        MyFrame<JLabel> labelIconOne = new MyFrame<JLabel>(new JLabel(iconPlus));
        labelIconOne.getTheObject().setSize(new Dimension(32, 32));
        labelIconOne.getTheObject().setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        labelIconOne.getTheObject().setToolTipText("Unos novih podataka");

        ImageIcon iconList = new ImageIcon("/home/emir/IdeaProjects/JavaSwingApp/src/com/company/list(1).png");
        //<div>Icons made by <a href="https://icon54.com/" title="Pixel perfect">Pixel perfect</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
        //"Icon made by Pixel perfect from www.flaticon.com"
        MyFrame<JLabel> labelIconTwo = new MyFrame<JLabel>(new JLabel(iconList));
        labelIconTwo.getTheObject().setSize(new Dimension(32, 32));
        labelIconTwo.getTheObject().setToolTipText("Pregled unešenih podataka");

        ImageIcon iconDelete = new ImageIcon("/home/emir/IdeaProjects/JavaSwingApp/src/com/company/delete(1).png");
        //<div>Icons made by <a href="https://www.flaticon.com/authors/pixelmeetup" title="Pixelmeetup">Pixelmeetup</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
        //"Icon made by Pixelmeetup from www.flaticon.com"
        MyFrame<JLabel> labelIconThree = new MyFrame<JLabel>(new JLabel(iconDelete));
        labelIconThree.getTheObject().setSize(new Dimension(32, 32));
        labelIconThree.getTheObject().setToolTipText("Brisanje podataka");

        ImageIcon iconShutDown = new ImageIcon("/home/emir/IdeaProjects/JavaSwingApp/src/com/company/power-button(1).png");
        //<div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
        //"Icon made by Freepik from www.flaticon.com"
        MyFrame<JLabel> labelIconFour = new MyFrame<JLabel>(new JLabel(iconShutDown));
        labelIconFour.getTheObject().setSize(new Dimension(32, 32));
        labelIconFour.getTheObject().setToolTipText("Odjava");

        ImageIcon iconBigPlus = new ImageIcon("/home/emir/IdeaProjects/JavaSwingApp/src/com/company/bigPlus.png");
        //<div>Icons made by <a href="https://www.flaticon.com/authors/pixel-perfect" title="Pixel perfect">Pixel perfect</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
        //"Icon made by Pixel perfect from www.flaticon.com"
        MyFrame<JLabel> labelBigPlus = new MyFrame<JLabel>(new JLabel(iconBigPlus));
        labelBigPlus.getTheObject().setSize(new Dimension(64, 64));
        labelBigPlus.getTheObject().setToolTipText("Za unos novog podatka pritisnite na oznaku + ili bilo gdje na sivom pravougaoniku");


        // School year and date panel
        MyFrame<JLabel> schoolYearLabel = new MyFrame<JLabel>(new JLabel("Školska godina"));
        schoolYearLabel.getTheObject().setPreferredSize(new Dimension(200, 50));
        schoolYearLabel.getTheObject().setForeground(Color.gray);
        schoolYearLabel.getTheObject().setHorizontalAlignment(JLabel.CENTER);

        MyFrame<JLabel> currentDateLabel = new MyFrame<JLabel>(new JLabel("Datum upisa"));
        currentDateLabel.getTheObject().setPreferredSize(new Dimension(200, 50));
        currentDateLabel.getTheObject().setForeground(Color.gray);
        currentDateLabel.getTheObject().setHorizontalAlignment(JLabel.CENTER);

        MyFrame<JButton> nextButton = new MyFrame<JButton>(new JButton("Dalje"));
        nextButton.getTheObject().setForeground(Color.decode("#66d9ff"));
        nextButton.getTheObject().setPreferredSize(new Dimension(200, 50));
        nextButton.getTheObject().setBackground(Color.darkGray);

        String[] schoolYears = {"2022/2023", "2023/2024", "2024/2025", "2025/2026", "2026/2027"};
        MyFrame<JComboBox> schoolYearsListData = new MyFrame<JComboBox>(new JComboBox(schoolYears));
        schoolYearsListData.getTheObject().setPreferredSize(new Dimension(400, 50));
        schoolYearsListData.getTheObject().setBackground(Color.darkGray);
        schoolYearsListData.getTheObject().setForeground(Color.white);
        schoolYearsListData.getTheObject().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#66d9ff")));


        MyFrame<JCalendar> jCalendar = new MyFrame<>(new JCalendar());
        jCalendar.getTheObject().setBackground(Color.darkGray);
        jCalendar.getTheObject().setPreferredSize(new Dimension(400, 200));
        jCalendar.getTheObject().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#66d9ff")));

        ImageIcon calendarIcon = new ImageIcon("/home/emir/IdeaProjects/JavaSwingApp/src/com/company/calendar.png");
        JLabel calendarIconLabel = new JLabel(calendarIcon);
        calendarIconLabel.setPreferredSize(new Dimension(32, 32));
        // <div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
        // "Icon made by Freepik from www.flaticon.com"


        // Components for plusPanelTwo
        MyFrame<JTextField> studentName = new MyFrame<JTextField>(new JTextField());
        studentName.getTheObject().setPreferredSize(new Dimension(400, 50));
        studentName.getTheObject().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#66d9ff")));
        studentName.getTheObject().setBackground(Color.darkGray);
        studentName.getTheObject().setForeground(Color.lightGray);
        studentName.getTheObject().setHorizontalAlignment(JTextField.CENTER);

        MyFrame<JLabel> studentNameLabel = new MyFrame<JLabel>(new JLabel("Ime"));
        studentNameLabel.getTheObject().setPreferredSize(new Dimension(200, 50));
        studentNameLabel.getTheObject().setHorizontalAlignment(JLabel.CENTER);
        studentNameLabel.getTheObject().setBackground(Color.DARK_GRAY);
        studentNameLabel.getTheObject().setForeground(Color.gray);

        MyFrame<JTextField> studentFatherName = new MyFrame<JTextField>(new JTextField());
        studentFatherName.getTheObject().setPreferredSize(new Dimension(400, 50));
        studentFatherName.getTheObject().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#66d9ff")));
        studentFatherName.getTheObject().setBackground(Color.darkGray);
        studentFatherName.getTheObject().setForeground(Color.lightGray);
        studentFatherName.getTheObject().setHorizontalAlignment(JTextField.CENTER);

        MyFrame<JLabel> studentFatherNameLabel = new MyFrame<JLabel>(new JLabel("Ime oca"));
        studentFatherNameLabel.getTheObject().setPreferredSize(new Dimension(200, 50));
        studentFatherNameLabel.getTheObject().setHorizontalAlignment(JLabel.CENTER);
        studentFatherNameLabel.getTheObject().setBackground(Color.DARK_GRAY);
        studentFatherNameLabel.getTheObject().setForeground(Color.gray);

        MyFrame<JTextField> studentSurname = new MyFrame<JTextField>(new JTextField());
        studentSurname.getTheObject().setPreferredSize(new Dimension(400, 50));
        studentSurname.getTheObject().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#66d9ff")));
        studentSurname.getTheObject().setBackground(Color.darkGray);
        studentSurname.getTheObject().setForeground(Color.lightGray);
        studentSurname.getTheObject().setHorizontalAlignment(JTextField.CENTER);


        MyFrame<JLabel> studentSurnameLabel = new MyFrame<JLabel>(new JLabel("Prezime"));
        studentSurnameLabel.getTheObject().setPreferredSize(new Dimension(200, 50));
        studentSurnameLabel.getTheObject().setHorizontalAlignment(JLabel.CENTER);
        studentSurnameLabel.getTheObject().setBackground(Color.DARK_GRAY);
        studentSurnameLabel.getTheObject().setForeground(Color.gray);

        MyFrame<JCalendar> dob = new MyFrame<>(new JCalendar());
        dob.getTheObject().setBackground(Color.darkGray);
        dob.getTheObject().setPreferredSize(new Dimension(400, 200));
        dob.getTheObject().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#66d9ff")));

        MyFrame<JLabel> dobLabel = new MyFrame<JLabel>(new JLabel("Datum rođenja"));
        dobLabel.getTheObject().setPreferredSize(new Dimension(200, 50));
        dobLabel.getTheObject().setHorizontalAlignment(JLabel.CENTER);
        dobLabel.getTheObject().setBackground(Color.DARK_GRAY);
        dobLabel.getTheObject().setForeground(Color.gray);

        MyFrame<JButton> nextButtonPPT = new MyFrame<JButton>(new JButton("Dalje"));
        nextButtonPPT.getTheObject().setForeground(Color.decode("#66d9ff"));
        nextButtonPPT.getTheObject().setPreferredSize(new Dimension(200, 50));
        nextButtonPPT.getTheObject().setBackground(Color.darkGray);

        MyFrame<JButton> previousButtonPPT = new MyFrame<JButton>(new JButton("Nazad"));
        previousButtonPPT.getTheObject().setForeground(Color.decode("#66d9ff"));
        previousButtonPPT.getTheObject().setPreferredSize(new Dimension(200, 50));
        previousButtonPPT.getTheObject().setBackground(Color.darkGray);

        // Components for plusPanelThree
        MyFrame<JLabel> sixthGradeLabel = new MyFrame<>(new JLabel("Opšti uspjeh 6. razred"));
        sixthGradeLabel.getTheObject().setPreferredSize(new Dimension(200, 50));
        sixthGradeLabel.getTheObject().setHorizontalAlignment(JLabel.CENTER);
        sixthGradeLabel.getTheObject().setBackground(Color.DARK_GRAY);
        sixthGradeLabel.getTheObject().setForeground(Color.gray);

        MyFrame<Double[]> gradesVi = new MyFrame<>(new Double[9]);
        gradesVi.getTheObject()[0] = 5.0;
        gradesVi.getTheObject()[1] = 4.9;
        gradesVi.getTheObject()[2] = 4.8;
        gradesVi.getTheObject()[3] = 4.7;
        gradesVi.getTheObject()[4] = 4.6;
        gradesVi.getTheObject()[5] = 4.5;
        gradesVi.getTheObject()[6] = 4.0;
        gradesVi.getTheObject()[7] = 3.0;
        gradesVi.getTheObject()[8] = 2.0;

        MyFrame<JComboBox> gradesData = new MyFrame<JComboBox>(new JComboBox(gradesVi.getTheObject()));
        gradesData.getTheObject().setPreferredSize(new Dimension(200, 50));
        gradesData.getTheObject().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#66d9ff")));

        MyFrame<JLabel> seventhGradeLabel = new MyFrame<>(new JLabel("Opšti uspjeh 7. razred"));
        seventhGradeLabel.getTheObject().setPreferredSize(new Dimension(200, 50));
        seventhGradeLabel.getTheObject().setHorizontalAlignment(JLabel.CENTER);
        seventhGradeLabel.getTheObject().setBackground(Color.DARK_GRAY);
        seventhGradeLabel.getTheObject().setForeground(Color.gray);

        MyFrame<Double[]> gradesVII = new MyFrame<>(new Double[9]);
        gradesVII.getTheObject()[0] = 5.0;
        gradesVII.getTheObject()[1] = 4.9;
        gradesVII.getTheObject()[2] = 4.8;
        gradesVII.getTheObject()[3] = 4.7;
        gradesVII.getTheObject()[4] = 4.6;
        gradesVII.getTheObject()[5] = 4.5;
        gradesVII.getTheObject()[6] = 4.0;
        gradesVII.getTheObject()[7] = 3.0;
        gradesVII.getTheObject()[8] = 2.0;

        MyFrame<JComboBox> gradesDataVII = new MyFrame<JComboBox>(new JComboBox(gradesVII.getTheObject()));
        gradesDataVII.getTheObject().setPreferredSize(new Dimension(200, 50));
        gradesDataVII.getTheObject().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#66d9ff")));

        MyFrame<JLabel> eightGradeLabel = new MyFrame<>(new JLabel("Opšti uspjeh 8. razred"));
        eightGradeLabel.getTheObject().setPreferredSize(new Dimension(200, 50));
        eightGradeLabel.getTheObject().setHorizontalAlignment(JLabel.CENTER);
        eightGradeLabel.getTheObject().setBackground(Color.DARK_GRAY);
        eightGradeLabel.getTheObject().setForeground(Color.gray);

        MyFrame<Double[]> gradesVIII = new MyFrame<>(new Double[9]);
        gradesVIII.getTheObject()[0] = 5.0;
        gradesVIII.getTheObject()[1] = 4.9;
        gradesVIII.getTheObject()[2] = 4.8;
        gradesVIII.getTheObject()[3] = 4.7;
        gradesVIII.getTheObject()[4] = 4.6;
        gradesVIII.getTheObject()[5] = 4.5;
        gradesVIII.getTheObject()[6] = 4.0;
        gradesVIII.getTheObject()[7] = 3.0;
        gradesVIII.getTheObject()[8] = 2.0;

        MyFrame<JComboBox> gradesDataVIII = new MyFrame<JComboBox>(new JComboBox(gradesVIII.getTheObject()));
        gradesDataVIII.getTheObject().setPreferredSize(new Dimension(200, 50));
        gradesDataVIII.getTheObject().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#66d9ff")));

        MyFrame<JLabel> ninthGradeLabel = new MyFrame<>(new JLabel("Opšti uspjeh 9. razred"));
        ninthGradeLabel.getTheObject().setPreferredSize(new Dimension(200, 50));
        ninthGradeLabel.getTheObject().setHorizontalAlignment(JLabel.CENTER);
        ninthGradeLabel.getTheObject().setBackground(Color.DARK_GRAY);
        ninthGradeLabel.getTheObject().setForeground(Color.gray);

        MyFrame<Double[]> gradesIX = new MyFrame<>(new Double[9]);
        gradesIX.getTheObject()[0] = 5.0;
        gradesIX.getTheObject()[1] = 4.9;
        gradesIX.getTheObject()[2] = 4.8;
        gradesIX.getTheObject()[3] = 4.7;
        gradesIX.getTheObject()[4] = 4.6;
        gradesIX.getTheObject()[5] = 4.5;
        gradesIX.getTheObject()[6] = 4.0;
        gradesIX.getTheObject()[7] = 3.0;
        gradesIX.getTheObject()[8] = 2.0;

        MyFrame<JComboBox> gradesDataIX = new MyFrame<JComboBox>(new JComboBox(gradesIX.getTheObject()));
        gradesDataIX.getTheObject().setPreferredSize(new Dimension(200, 50));
        gradesDataIX.getTheObject().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#66d9ff")));

        MyFrame<Double[]> relSubjList = new MyFrame<>(new Double[4]);
        relSubjList.getTheObject()[0] = 5.0;
        relSubjList.getTheObject()[1] = 4.0;
        relSubjList.getTheObject()[2] = 3.0;
        relSubjList.getTheObject()[3] = 2.0;


        MyFrame<JComboBox> relSubj1 = new MyFrame<JComboBox>(new JComboBox(relSubjList.getTheObject()));
        relSubj1.getTheObject().setPreferredSize(new Dimension(200, 50));
        relSubj1.getTheObject().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#66d9ff")));

        MyFrame<JLabel> relSubj8Gr = new MyFrame<>(new JLabel("Relevantni predmet I (VIII)"));
        relSubj8Gr.getTheObject().setPreferredSize(new Dimension(200, 50));
        relSubj8Gr.getTheObject().setHorizontalAlignment(JLabel.CENTER);
        relSubj8Gr.getTheObject().setBackground(Color.DARK_GRAY);
        relSubj8Gr.getTheObject().setForeground(Color.gray);

        MyFrame<Double[]> relSubjList2 = new MyFrame<>(new Double[4]);
        relSubjList2.getTheObject()[0] = 5.0;
        relSubjList2.getTheObject()[1] = 4.0;
        relSubjList2.getTheObject()[2] = 3.0;
        relSubjList2.getTheObject()[3] = 2.0;

        MyFrame<JComboBox> relSubj2 = new MyFrame<JComboBox>(new JComboBox(relSubjList2.getTheObject()));
        relSubj2.getTheObject().setPreferredSize(new Dimension(200, 50));
        relSubj2.getTheObject().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#66d9ff")));

        MyFrame<JLabel> relSubj8Gr2 = new MyFrame<>(new JLabel("Relevantni predmet II (VIII)"));
        relSubj8Gr2.getTheObject().setPreferredSize(new Dimension(200, 50));
        relSubj8Gr2.getTheObject().setHorizontalAlignment(JLabel.CENTER);
        relSubj8Gr2.getTheObject().setBackground(Color.DARK_GRAY);
        relSubj8Gr2.getTheObject().setForeground(Color.gray);

        MyFrame<Double[]> relSubjList3 = new MyFrame<>(new Double[4]);
        relSubjList3.getTheObject()[0] = 5.0;
        relSubjList3.getTheObject()[1] = 4.0;
        relSubjList3.getTheObject()[2] = 3.0;
        relSubjList3.getTheObject()[3] = 2.0;

        MyFrame<JComboBox> relSubj3 = new MyFrame<JComboBox>(new JComboBox(relSubjList3.getTheObject()));
        relSubj3.getTheObject().setPreferredSize(new Dimension(200, 50));
        relSubj3.getTheObject().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#66d9ff")));

        MyFrame<JLabel> relSubj8Gr3 = new MyFrame<>(new JLabel("Relevantni predmet III (VIII)"));
        relSubj8Gr3.getTheObject().setPreferredSize(new Dimension(200, 50));
        relSubj8Gr3.getTheObject().setHorizontalAlignment(JLabel.CENTER);
        relSubj8Gr3.getTheObject().setBackground(Color.DARK_GRAY);
        relSubj8Gr3.getTheObject().setForeground(Color.gray);


        MyFrame<Double[]> relSubjList4 = new MyFrame<>(new Double[4]);
        relSubjList4.getTheObject()[0] = 5.0;
        relSubjList4.getTheObject()[1] = 4.0;
        relSubjList4.getTheObject()[2] = 3.0;
        relSubjList4.getTheObject()[3] = 2.0;

        MyFrame<JComboBox> relSubj4 = new MyFrame<JComboBox>(new JComboBox(relSubjList4.getTheObject()));
        relSubj4.getTheObject().setPreferredSize(new Dimension(200, 50));
        relSubj4.getTheObject().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#66d9ff")));

        MyFrame<JLabel> relSubj9Gr = new MyFrame<>(new JLabel("Relevantni predmet I (IX)"));
        relSubj9Gr.getTheObject().setPreferredSize(new Dimension(200, 50));
        relSubj9Gr.getTheObject().setHorizontalAlignment(JLabel.CENTER);
        relSubj9Gr.getTheObject().setBackground(Color.DARK_GRAY);
        relSubj9Gr.getTheObject().setForeground(Color.gray);

        MyFrame<Double[]> relSubjList5 = new MyFrame<>(new Double[4]);
        relSubjList5.getTheObject()[0] = 5.0;
        relSubjList5.getTheObject()[1] = 4.0;
        relSubjList5.getTheObject()[2] = 3.0;
        relSubjList5.getTheObject()[3] = 2.0;

        MyFrame<JComboBox> relSubj5 = new MyFrame<JComboBox>(new JComboBox(relSubjList5.getTheObject()));
        relSubj5.getTheObject().setPreferredSize(new Dimension(200, 50));
        relSubj5.getTheObject().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#66d9ff")));

        MyFrame<JLabel> relSubj9Gr2 = new MyFrame<>(new JLabel("Relevantni predmet II (IX)"));
        relSubj9Gr2.getTheObject().setPreferredSize(new Dimension(200, 50));
        relSubj9Gr2.getTheObject().setHorizontalAlignment(JLabel.CENTER);
        relSubj9Gr2.getTheObject().setBackground(Color.DARK_GRAY);
        relSubj9Gr2.getTheObject().setForeground(Color.gray);

        MyFrame<Double[]> relSubjList6 = new MyFrame<>(new Double[4]);
        relSubjList6.getTheObject()[0] = 5.0;
        relSubjList6.getTheObject()[1] = 4.0;
        relSubjList6.getTheObject()[2] = 3.0;
        relSubjList6.getTheObject()[3] = 2.0;

        MyFrame<JComboBox> relSubj6 = new MyFrame<JComboBox>(new JComboBox(relSubjList6.getTheObject()));
        relSubj6.getTheObject().setPreferredSize(new Dimension(200, 50));
        relSubj6.getTheObject().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#66d9ff")));

        MyFrame<JLabel> relSubj9Gr3 = new MyFrame<>(new JLabel("Relevantni predmet III (IX)"));
        relSubj9Gr3.getTheObject().setPreferredSize(new Dimension(200, 50));
        relSubj9Gr3.getTheObject().setHorizontalAlignment(JLabel.CENTER);
        relSubj9Gr3.getTheObject().setBackground(Color.DARK_GRAY);
        relSubj9Gr3.getTheObject().setForeground(Color.gray);

        JCheckBox internationalComp = new JCheckBox("Međunarnodno takmičenje");
        internationalComp.setPreferredSize(new Dimension(250, 50));
        internationalComp.setBackground(Color.darkGray);
        internationalComp.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#66d9ff")));
        internationalComp.setForeground(Color.lightGray);

        JCheckBox federalComp = new JCheckBox("Federalno takmičenje");
        federalComp.setPreferredSize(new Dimension(250, 50));
        federalComp.setBackground(Color.darkGray);
        federalComp.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#66d9ff")));
        federalComp.setForeground(Color.lightGray);

        JCheckBox cantonalComp = new JCheckBox("Kantonalno takmičenje");
        cantonalComp.setPreferredSize(new Dimension(250, 50));
        cantonalComp.setBackground(Color.darkGray);
        cantonalComp.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#66d9ff")));
        cantonalComp.setForeground(Color.lightGray);

        JCheckBox specialDiplom = new JCheckBox("Posebna diploma");
        specialDiplom.setPreferredSize(new Dimension(250, 50));
        specialDiplom.setBackground(Color.darkGray);
        specialDiplom.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#66d9ff")));
        specialDiplom.setForeground(Color.lightGray);

        JTextField extGradData = new JTextField();
        extGradData.setPreferredSize(new Dimension(220, 50));
        extGradData.setBackground(Color.darkGray);
        extGradData.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#66d9ff")));
        extGradData.setForeground(Color.lightGray);


        MyFrame<JLabel> extGrad = new MyFrame<>(new JLabel("Rezultat eksterne mature u %"));
        extGrad.getTheObject().setPreferredSize(new Dimension(240, 50));
        extGrad.getTheObject().setHorizontalAlignment(JLabel.CENTER);
        extGrad.getTheObject().setBackground(Color.DARK_GRAY);
        extGrad.getTheObject().setForeground(Color.gray);


        MyFrame<JButton> backButtonPoPThree = new MyFrame<JButton>(new JButton("Nazad"));
        backButtonPoPThree.getTheObject().setForeground(Color.decode("#66d9ff"));
        backButtonPoPThree.getTheObject().setPreferredSize(new Dimension(200, 50));
        backButtonPoPThree.getTheObject().setBackground(Color.darkGray);

        MyFrame<JButton> finishButtonPoPThree = new MyFrame<JButton>(new JButton("Zavši unos"));
        finishButtonPoPThree.getTheObject().setForeground(Color.decode("#66d9ff"));
        finishButtonPoPThree.getTheObject().setPreferredSize(new Dimension(200, 50));
        finishButtonPoPThree.getTheObject().setBackground(Color.darkGray);

        // Components for loginPanel
        MyFrame<JLabel> usernameIcon = new MyFrame<JLabel>(new JLabel(new ImageIcon("/home/emir/IdeaProjects/JavaSwingApp/src/com/company/user(1).png")));
        // <div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
        //"Icon made by Freepik from www.flaticon.com"
        usernameIcon.getTheObject().setPreferredSize(new Dimension(32, 32));
        usernameIcon.getTheObject().setBackground(Color.DARK_GRAY);
        usernameIcon.getTheObject().setForeground(Color.gray);

        MyFrame<JTextField> username = new MyFrame<JTextField>(new JTextField());
        username.getTheObject().setPreferredSize(new Dimension(400, 50));
        username.getTheObject().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#66d9ff")));
        username.getTheObject().setBackground(Color.darkGray);
        username.getTheObject().setForeground(Color.lightGray);
        username.getTheObject().setHorizontalAlignment(JTextField.CENTER);

        MyFrame<JLabel> usernameLabel = new MyFrame<JLabel>(new JLabel("Ime"));
        usernameLabel.getTheObject().setPreferredSize(new Dimension(200, 50));
        usernameLabel.getTheObject().setBackground(Color.DARK_GRAY);
        usernameLabel.getTheObject().setForeground(Color.gray);

        MyFrame<JLabel> passwordIcon = new MyFrame<JLabel>(new JLabel(new ImageIcon("/home/emir/IdeaProjects/JavaSwingApp/src/com/company/padlock(1).png")));
        //<div>Icons made by <a href="https://www.flaticon.com/authors/pixel-perfect" title="Pixel perfect">Pixel perfect</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
        //"Icon made by Pixel perfect from www.flaticon.com"
        passwordIcon.getTheObject().setPreferredSize(new Dimension(32, 32));
        passwordIcon.getTheObject().setBackground(Color.DARK_GRAY);
        passwordIcon.getTheObject().setForeground(Color.gray);

        MyFrame<JPasswordField> password = new MyFrame<JPasswordField>(new JPasswordField());
        password.getTheObject().setPreferredSize(new Dimension(400, 50));
        password.getTheObject().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#66d9ff")));
        password.getTheObject().setBackground(Color.darkGray);
        password.getTheObject().setForeground(Color.lightGray);
        password.getTheObject().setHorizontalAlignment(JTextField.CENTER);

        MyFrame<JLabel> paswordLabel = new MyFrame<JLabel>(new JLabel("Ime"));
        paswordLabel.getTheObject().setPreferredSize(new Dimension(200, 50));
        paswordLabel.getTheObject().setHorizontalAlignment(JLabel.CENTER);
        paswordLabel.getTheObject().setBackground(Color.DARK_GRAY);
        paswordLabel.getTheObject().setForeground(Color.gray);

        MyFrame<JLabel> newAccountLink = new MyFrame<JLabel>(new JLabel("Kreirajte novi račun"));
        newAccountLink.getTheObject().setPreferredSize(new Dimension(200, 50));
        newAccountLink.getTheObject().setHorizontalAlignment(JLabel.CENTER);
        newAccountLink.getTheObject().setBackground(Color.DARK_GRAY);
        newAccountLink.getTheObject().setForeground(Color.decode("#66d9ff"));

        MyFrame<JButton> loginButton = new MyFrame<JButton>(new JButton("Prijava"));
        loginButton.getTheObject().setForeground(Color.decode("#66d9ff"));
        loginButton.getTheObject().setPreferredSize(new Dimension(200, 50));
        loginButton.getTheObject().setBackground(Color.darkGray);

        MyFrame<JLabel> error = new MyFrame<JLabel>(new JLabel("Korisničko ime ili šifra nisu ispravni"));
        error.getTheObject().setPreferredSize(new Dimension(300, 50));
        error.getTheObject().setHorizontalAlignment(JLabel.CENTER);
        error.getTheObject().setBackground(Color.DARK_GRAY);
        error.getTheObject().setForeground(Color.red);

        // Components for resultsPanel

        String[] listForSorting = {"Filter", "id", "Ime", "Prezime", "Bodovi"};
        MyFrame<JComboBox> sortList = new MyFrame<>(new JComboBox(listForSorting));
        sortList.getTheObject().setPreferredSize(new Dimension(200, 50));
        sortList.getTheObject().setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.decode("#66d9ff")));

        String[] listForSorting1 = {"ASC/DESC" , "ASC", "DESC"};
        MyFrame<JComboBox> sortList1 = new MyFrame<>(new JComboBox(listForSorting1));
        sortList1.getTheObject().setPreferredSize(new Dimension(200, 50));
        sortList1.getTheObject().setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.decode("#66d9ff")));


        MyFrame<JTextField> searchData = new MyFrame<>(new JTextField());
        searchData.getTheObject().setPreferredSize(new Dimension(400, 50));
        searchData.getTheObject().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#66d9ff")));
        searchData.getTheObject().setBackground(Color.darkGray);
        searchData.getTheObject().setForeground(Color.lightGray);
        searchData.getTheObject().setHorizontalAlignment(JTextField.CENTER);

        MyFrame<JTextField> searchData2 = new MyFrame<>(new JTextField());
        searchData2.getTheObject().setPreferredSize(new Dimension(400, 50));
        searchData2.getTheObject().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#66d9ff")));
        searchData2.getTheObject().setBackground(Color.darkGray);
        searchData2.getTheObject().setForeground(Color.lightGray);
        searchData2.getTheObject().setHorizontalAlignment(JTextField.CENTER);

        MyFrame<JLabel> searchLabel = new MyFrame<>(new JLabel("Pretraga po imenu ili prezimenu"));
        searchLabel.getTheObject().setPreferredSize(new Dimension(250, 50));
        searchLabel.getTheObject().setHorizontalAlignment(JLabel.CENTER);
        searchLabel.getTheObject().setBackground(Color.DARK_GRAY);
        searchLabel.getTheObject().setForeground(Color.lightGray);


        JButton showButton = new JButton("Prikaži tabelu");
        showButton.setForeground(Color.decode("#66d9ff"));
        showButton.setPreferredSize(new Dimension(200, 50));
        showButton.setBackground(Color.darkGray);

        // Components for delete panel

        MyFrame<JTextField> searchForDeletion = new MyFrame<>(new JTextField());
        searchForDeletion.getTheObject().setPreferredSize(new Dimension(400, 50));
        searchForDeletion.getTheObject().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#66d9ff")));
        searchForDeletion.getTheObject().setBackground(Color.darkGray);
        searchForDeletion.getTheObject().setForeground(Color.lightGray);
        searchForDeletion.getTheObject().setHorizontalAlignment(JTextField.CENTER);

        MyFrame<JLabel> deleteLabel = new MyFrame<>(new JLabel("Brisanje prema id-u, imenu, prezimenu"));
        deleteLabel.getTheObject().setPreferredSize(new Dimension(300, 50));
        deleteLabel.getTheObject().setHorizontalAlignment(JLabel.CENTER);
        deleteLabel.getTheObject().setBackground(Color.DARK_GRAY);
        deleteLabel.getTheObject().setForeground(Color.lightGray);


        JButton deleteButton = new JButton("Izbriši podatak");
        deleteButton.setForeground(Color.white);
        deleteButton.setBackground(Color.decode("#a83232"));
        deleteButton.setPreferredSize(new Dimension(200, 50));




        // Add to loginPanel
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(30, 0, 0, 140);
        loginPanel.getTheObject().add(usernameIcon.getTheObject(), constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.insets = new Insets(20, -130, 0, 0);
        loginPanel.getTheObject().add(username.getTheObject(), constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(30, 0, 0, 140);
        loginPanel.getTheObject().add(passwordIcon.getTheObject(), constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.insets = new Insets(20, -130, 0, 0);
        loginPanel.getTheObject().add(password.getTheObject(), constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.insets = new Insets(20, 0, 0, -60);
        loginPanel.getTheObject().add(newAccountLink.getTheObject(), constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.insets = new Insets(20, 70, 0, 0);
        loginPanel.getTheObject().add(loginButton.getTheObject(), constraints);


        // Add to plusPanel
        constraints.gridx = 0;
        constraints.gridy = 0;
        plusPanel.getTheObject().add(schoolYearsListData.getTheObject(), constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        plusPanel.getTheObject().add(schoolYearLabel.getTheObject(), constraints);


        constraints.gridx = 0;
        constraints.gridy = 2;
        plusPanel.getTheObject().add(jCalendar.getTheObject(), constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        plusPanel.getTheObject().add(currentDateLabel.getTheObject(), constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.insets = new Insets(0, 650, 0, 0);
        plusPanel.getTheObject().add(nextButton.getTheObject(), constraints);

        // Add to plusPanelTwo

        gridBagConstraintsTwo.gridx = 0;
        gridBagConstraintsTwo.gridy = 0;
        plusPanelTwo.getTheObject().add(studentName.getTheObject(), gridBagConstraintsTwo);

        gridBagConstraintsTwo.gridx = 0;
        gridBagConstraintsTwo.gridy = 1;
        plusPanelTwo.getTheObject().add(studentNameLabel.getTheObject(), gridBagConstraintsTwo);

        gridBagConstraintsTwo.gridx = 0;
        gridBagConstraintsTwo.gridy = 2;
        plusPanelTwo.getTheObject().add(studentFatherName.getTheObject(), gridBagConstraintsTwo);

        gridBagConstraintsTwo.gridx = 0;
        gridBagConstraintsTwo.gridy = 3;
        plusPanelTwo.getTheObject().add(studentFatherNameLabel.getTheObject(), gridBagConstraintsTwo);

        gridBagConstraintsTwo.gridx = 0;
        gridBagConstraintsTwo.gridy = 4;
        plusPanelTwo.getTheObject().add(studentSurname.getTheObject(), gridBagConstraintsTwo);

        gridBagConstraintsTwo.gridx = 0;
        gridBagConstraintsTwo.gridy = 5;
        plusPanelTwo.getTheObject().add(studentSurnameLabel.getTheObject(), gridBagConstraintsTwo);

        gridBagConstraintsTwo.gridx = 0;
        gridBagConstraintsTwo.gridy = 6;
        plusPanelTwo.getTheObject().add(dob.getTheObject(), gridBagConstraintsTwo);

        gridBagConstraintsTwo.gridx = 0;
        gridBagConstraintsTwo.gridy = 7;
        plusPanelTwo.getTheObject().add(dobLabel.getTheObject(), gridBagConstraintsTwo);

        gridBagConstraintsTwo.gridx = 0;
        gridBagConstraintsTwo.gridy = 8;
        plusPanelTwo.getTheObject().add(previousButtonPPT.getTheObject(), gridBagConstraintsTwo);


        gridBagConstraintsTwo.gridx = 0;
        gridBagConstraintsTwo.gridy = 8;
        gridBagConstraintsTwo.insets = new Insets(0, 600, 0, 0);
        plusPanelTwo.getTheObject().add(nextButtonPPT.getTheObject(), gridBagConstraintsTwo);


        // Add to plusPanelThree
        GridBagConstraints gridBagConstraintsThree = new GridBagConstraints();
        gridBagConstraintsThree.gridx = 0;
        gridBagConstraintsThree.gridy = 0;
        plusPanelThree.getTheObject().add(gradesData.getTheObject(), gridBagConstraintsThree);

        gridBagConstraintsThree.gridx = 0;
        gridBagConstraintsThree.gridy = 1;
        plusPanelThree.getTheObject().add(sixthGradeLabel.getTheObject(), gridBagConstraintsThree);

        gridBagConstraintsThree.gridx = 0;
        gridBagConstraintsThree.gridy = 2;
        plusPanelThree.getTheObject().add(gradesDataVII.getTheObject(), gridBagConstraintsThree);

        gridBagConstraintsThree.gridx = 0;
        gridBagConstraintsThree.gridy = 3;
        plusPanelThree.getTheObject().add(seventhGradeLabel.getTheObject(), gridBagConstraintsThree);

        gridBagConstraintsThree.gridx = 0;
        gridBagConstraintsThree.gridy = 4;
        plusPanelThree.getTheObject().add(gradesDataVIII.getTheObject(), gridBagConstraintsThree);


        gridBagConstraintsThree.gridx = 0;
        gridBagConstraintsThree.gridy = 5;
        plusPanelThree.getTheObject().add(eightGradeLabel.getTheObject(), gridBagConstraintsThree);

        gridBagConstraintsThree.gridx = 0;
        gridBagConstraintsThree.gridy = 6;
        plusPanelThree.getTheObject().add(gradesDataIX.getTheObject(), gridBagConstraintsThree);

        gridBagConstraintsThree.gridx = 0;
        gridBagConstraintsThree.gridy = 7;
        plusPanelThree.getTheObject().add(ninthGradeLabel.getTheObject(), gridBagConstraintsThree);

        gridBagConstraintsThree.gridx = 1;
        gridBagConstraintsThree.gridy = 0;
        gridBagConstraintsThree.insets = new Insets(10, 20, 0, 0);
        plusPanelThree.getTheObject().add(relSubj1.getTheObject(), gridBagConstraintsThree);

        gridBagConstraintsThree.gridx = 1;
        gridBagConstraintsThree.gridy = 1;
        gridBagConstraintsThree.insets = new Insets(10, 20, 0, 0);
        plusPanelThree.getTheObject().add(relSubj8Gr.getTheObject(), gridBagConstraintsThree);

        gridBagConstraintsThree.gridx = 1;
        gridBagConstraintsThree.gridy = 2;
        gridBagConstraintsThree.insets = new Insets(10, 20, 0, 0);
        plusPanelThree.getTheObject().add(relSubj2.getTheObject(), gridBagConstraintsThree);

        gridBagConstraintsThree.gridx = 1;
        gridBagConstraintsThree.gridy = 3;
        gridBagConstraintsThree.insets = new Insets(10, 20, 0, 0);
        plusPanelThree.getTheObject().add(relSubj8Gr2.getTheObject(), gridBagConstraintsThree);

        gridBagConstraintsThree.gridx = 1;
        gridBagConstraintsThree.gridy = 4;
        gridBagConstraintsThree.insets = new Insets(10, 20, 0, 0);
        plusPanelThree.getTheObject().add(relSubj3.getTheObject(), gridBagConstraintsThree);

        gridBagConstraintsThree.gridx = 1;
        gridBagConstraintsThree.gridy = 5;
        constraints.insets = new Insets(10, 20, 0, 0);
        plusPanelThree.getTheObject().add(relSubj8Gr3.getTheObject(), gridBagConstraintsThree);

        gridBagConstraintsThree.gridx = 2;
        gridBagConstraintsThree.gridy = 0;
        gridBagConstraintsThree.insets = new Insets(10, 20, 0, 0);
        plusPanelThree.getTheObject().add(relSubj4.getTheObject(), gridBagConstraintsThree);

        gridBagConstraintsThree.gridx = 2;
        gridBagConstraintsThree.gridy = 1;
        gridBagConstraintsThree.insets = new Insets(10, 20, 0, 0);
        plusPanelThree.getTheObject().add(relSubj9Gr.getTheObject(), gridBagConstraintsThree);

        gridBagConstraintsThree.gridx = 2;
        gridBagConstraintsThree.gridy = 2;
        gridBagConstraintsThree.insets = new Insets(10, 20, 0, 0);
        plusPanelThree.getTheObject().add(relSubj5.getTheObject(), gridBagConstraintsThree);

        gridBagConstraintsThree.gridx = 2;
        gridBagConstraintsThree.gridy = 3;
        gridBagConstraintsThree.insets = new Insets(10, 20, 0, 0);
        plusPanelThree.getTheObject().add(relSubj9Gr2.getTheObject(), gridBagConstraintsThree);

        gridBagConstraintsThree.gridx = 2;
        gridBagConstraintsThree.gridy = 4;
        constraints.insets = new Insets(10, 20, 0, 0);
        plusPanelThree.getTheObject().add(relSubj6.getTheObject(), gridBagConstraintsThree);

        gridBagConstraintsThree.gridx = 2;
        gridBagConstraintsThree.gridy = 5;
        gridBagConstraintsThree.insets = new Insets(10, 20, 0, 0);
        plusPanelThree.getTheObject().add(relSubj9Gr3.getTheObject(), gridBagConstraintsThree);

        gridBagConstraintsThree.gridx = 3;
        gridBagConstraintsThree.gridy = 0;
        gridBagConstraintsThree.insets = new Insets(10, 20, 0, 0);
        plusPanelThree.getTheObject().add(internationalComp, gridBagConstraintsThree);

        gridBagConstraintsThree.gridx = 3;
        gridBagConstraintsThree.gridy = 1;
        gridBagConstraintsThree.insets = new Insets(10, 20, 0, 0);
        plusPanelThree.getTheObject().add(federalComp, gridBagConstraintsThree);

        gridBagConstraintsThree.gridx = 3;
        gridBagConstraintsThree.gridy = 2;
        gridBagConstraintsThree.insets = new Insets(10, 20, 0, 0);
        plusPanelThree.getTheObject().add(cantonalComp, gridBagConstraintsThree);

        gridBagConstraintsThree.gridx = 3;
        gridBagConstraintsThree.gridy = 3;
        gridBagConstraintsThree.insets = new Insets(10, 20, 0, 0);
        plusPanelThree.getTheObject().add(specialDiplom, gridBagConstraintsThree);

        gridBagConstraintsThree.gridx = 3;
        gridBagConstraintsThree.gridy = 4;
        gridBagConstraintsThree.insets = new Insets(10, 20, 0, 0);
        plusPanelThree.getTheObject().add(extGradData, gridBagConstraintsThree);

        gridBagConstraintsThree.gridx = 3;
        gridBagConstraintsThree.gridy = 5;
        gridBagConstraintsThree.insets = new Insets(10, 20, 0, 0);
        plusPanelThree.getTheObject().add(extGrad.getTheObject(), gridBagConstraintsThree);

        gridBagConstraintsThree.gridx = 2;
        gridBagConstraintsThree.gridy = 7;
        gridBagConstraintsThree.insets = new Insets(10, 20, 0, 0);
        plusPanelThree.getTheObject().add(backButtonPoPThree.getTheObject(), gridBagConstraintsThree);

        gridBagConstraintsThree.gridx = 3;
        gridBagConstraintsThree.gridy = 7;
        gridBagConstraintsThree.insets = new Insets(10, 20, 0, 0);
        plusPanelThree.getTheObject().add(finishButtonPoPThree.getTheObject(), gridBagConstraintsThree);


        // add to results panel


        constraints.gridx = 0;
        constraints.gridy = 0;
        // constraints.insets=new Insets(0,0,0,0);
        resultsPanel.getTheObject().add(sortList.getTheObject(), constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        //constraints.insets=new Insets(0,0,0,0);
        resultsPanel.getTheObject().add(sortList1.getTheObject(), constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        //constraints.insets=new Insets(0,0,0,0);
        resultsPanel.getTheObject().add(searchData2.getTheObject(), constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;
        resultsPanel.getTheObject().add(searchLabel.getTheObject(), constraints);

        constraints.gridx = 3;
        constraints.gridy = 0;
        //constraints.insets = new Insets(50, 50, 0, 0);
        resultsPanel.getTheObject().add(showButton, constraints);

        // add to delete panel

        constraints.gridx=0;
        constraints.gridy=0;
        deletePanel.getTheObject().add(searchForDeletion.getTheObject(), constraints);

        constraints.gridx=0;
        constraints.gridy=1;
        deletePanel.getTheObject().add(deleteLabel.getTheObject(), constraints);

        constraints.gridx=1;
        constraints.gridy=0;
        deletePanel.getTheObject().add(deleteButton, constraints);




        // Add to main JPanel
        mainPanelObj.getTheObject().add(sidePanel.getTheObject(), BorderLayout.WEST);
        mainPanelObj.getTheObject().add(labelBigPlus.getTheObject(), BorderLayout.CENTER);


        // Adding icons to panelOne
        sidePanel.getTheObject().add(labelIconOne.getTheObject());
        sidePanel.getTheObject().add(labelIconThree.getTheObject());
        sidePanel.getTheObject().add(labelIconTwo.getTheObject());
        sidePanel.getTheObject().add(labelIconFour.getTheObject());


        // Add to JFrame
        obj.getTheObject().add(mainPanelObj.getTheObject());
        popUpFrame.getTheObject().add(plusPanel.getTheObject());
        popUpFrameTwo.getTheObject().add(plusPanelTwo.getTheObject());
        popUpFrameThree.getTheObject().add(plusPanelThree.getTheObject());
        loginJFrame.getTheObject().add(loginPanel.getTheObject());
        loginJFrame.getTheObject().pack();
        resultsJFrame.getTheObject().add(resultsPanel.getTheObject());
        resultsJFrame.getTheObject().pack();


        // Event handlers
        labelIconOne.getTheObject().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("New entry");
                popUpFrame.getTheObject().setVisible(true);
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
        });

        labelBigPlus.getTheObject().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                popUpFrame.getTheObject().setVisible(true);
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
        });


        nextButton.getTheObject().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                popUpFrameTwo.getTheObject().setVisible(true);
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
        });

        previousButtonPPT.getTheObject().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                popUpFrameTwo.getTheObject().setVisible(false);
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
        });
        nextButtonPPT.getTheObject().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                popUpFrameThree.getTheObject().setVisible(true);
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
        });


        loginButton.getTheObject().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String usernameCred = username.getTheObject().getText();
                String stringifyPassword = new String(password.getTheObject().getPassword());


                ResultSet set = connectionHandler.connectAndLogin("SELECT * FROM users");
                try {
                    while (set.next()) {
                        if (set.getString("username").equals(usernameCred) && set.getString("password").equals(stringifyPassword)) {
                            System.out.println("Validno");
                            loginJFrame.getTheObject().setVisible(false);
                            obj.getTheObject().setVisible(true);

                        } else {
                            System.out.println("Korisnicko ime ili šifra nisu tačni");
                            GridBagConstraints localGBC = new GridBagConstraints();
                            localGBC.gridx = 1;
                            localGBC.gridy = 4;
                            localGBC.insets = new Insets(10, 0, 0, 0);
                            loginPanel.getTheObject().add(error.getTheObject(), localGBC);
                        }
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
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
        });


        finishButtonPoPThree.getTheObject().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                resultsJFrame.getTheObject().setVisible(true);
                popUpFrame.getTheObject().setVisible(false);
                popUpFrameTwo.getTheObject().setVisible(false);
                popUpFrameThree.getTheObject().setVisible(false);


                String schoolYear = (String) schoolYearsListData.getTheObject().getSelectedItem();

                Date jcalValue = jCalendar.getTheObject().getDate();
                LocalDateTime currentDates = convertDate(jcalValue);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String stringify = formatter.format(currentDates);


                String student = studentName.getTheObject().getText();
                String father = studentFatherName.getTheObject().getText();
                String studentLastname = studentSurname.getTheObject().getText();

                Date dobValue = dob.getTheObject().getDate();
                LocalDateTime selectedDob = convertDate(dobValue);
                DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String stringifyDob = formatter1.format(selectedDob);


                Double generalVI = (Double) gradesData.getTheObject().getSelectedItem();
                String genVIS = generalVI.toString();
                double genVI = Double.parseDouble(genVIS);

                Double generalVII = (Double) gradesDataVII.getTheObject().getSelectedItem();
                String genVIIS = generalVII.toString();
                double genVII = Double.parseDouble(genVIIS);

                Double generalVIII = (Double) gradesDataVIII.getTheObject().getSelectedItem();
                String genVIIIS = generalVIII.toString();
                double genVIII = Double.parseDouble(genVIIIS);

                Double generalIX = (Double) gradesDataIX.getTheObject().getSelectedItem();
                String genIXS = generalIX.toString();
                double genIX = Double.parseDouble(genIXS);

                Double subj1 = (Double) relSubj1.getTheObject().getSelectedItem();
                String sb1 = subj1.toString();
                double dsb1 = Double.parseDouble(sb1);

                Double subj2 = (Double) relSubj2.getTheObject().getSelectedItem();
                String sb2 = subj2.toString();
                double dsb2 = Double.parseDouble(sb2);

                Double subj3 = (Double) relSubj3.getTheObject().getSelectedItem();
                String sb3 = subj3.toString();
                double dsb3 = Double.parseDouble(sb3);

                Double subj4 = (Double) relSubj4.getTheObject().getSelectedItem();
                String sb4 = subj4.toString();
                double dsb4 = Double.parseDouble(sb4);

                Double subj5 = (Double) relSubj5.getTheObject().getSelectedItem();
                String sb5 = subj5.toString();
                double dsb5 = Double.parseDouble(sb5);

                Double subj6 = (Double) relSubj6.getTheObject().getSelectedItem();
                String sb6 = subj6.toString();
                double dsb6 = Double.parseDouble(sb6);

                String extString = extGradData.getText();


                boolean internationalC = internationalComp.isSelected();
                String intC;
                double resultSum = 0;
                if (internationalC == true) {
                    intC = "DA";
                    competitionsSum = 10;
                    System.out.println("intsum" + competitionsSum);
                } else {
                    intC = "NE";
                }
                boolean federalC = federalComp.isSelected();
                String fedC;
                if (federalC == true) {
                    fedC = "DA";
                    competitionsSum = 8;
                    System.out.println("fedsum" + competitionsSum);
                } else {
                    fedC = "NE";
                }
                boolean cantonalC = cantonalComp.isSelected();
                String canC;
                if (cantonalC == true) {
                    canC = "DA";
                    competitionsSum = 5;
                    System.out.println("cantsum" + competitionsSum);
                } else {
                    canC = "NE";
                }
                if (internationalC == true && federalC == true && cantonalC == true) {
                    competitionsSum = 10;
                    System.out.println("All competitions" + competitionsSum);
                }
                boolean specialD = specialDiplom.isSelected();
                String speC;
                double hasSpecialDiplom = 0;
                if (specialD == true) {
                    speC = "DA";
                    hasSpecialDiplom = 15;
                    System.out.println("hasspecial diplom" + hasSpecialDiplom);
                } else {
                    speC = "NE";
                }

                double sumSumare = addPoints(genVI) + addPoints(genVII) + addPoints(genVIII) + addPoints(genIX) +
                        addPointsRp(dsb1) + addPointsRp(dsb2) + addPointsRp(dsb3) + addPointsRp(dsb4) + addPointsRp(dsb5) + addPointsRp(dsb6)
                        + exCalc(extString) + competitionsSum + hasSpecialDiplom;


                //String q=String.format(Locale.US, "INSERT INTO info(schoolYear, entryDate, name, fatherName, surname, dob, gs7, gs8, gs9, relSubj18, relSubj28, relSubj38, relSubj19, relSubj29, relSubj39, iC, fC, cC, sD) VALUES ('"+schoolYear+"','"+stringify+"','"+student+"', '"+father+"', '"+studentLastname+"','"+stringifyDob+"', '"+generalVII+"','"+generalVIII+"','"+generalIX+"', '"+relSubj1+"', '"+relSubj2+"','"+relSubj3+"','"+relSubj4+"', '"+relSubj5+"', '"+relSubj6+"', '"+internationalC+"','"+federalC+"', '"+cantonalC+"','"+specialD+"')",123456789);
                String insertQuery = "INSERT INTO info(schoolYear, entryDate, name, fatherName, surname, dob, gs7, gs8, gs9, relSubj18, relSubj28, relSubj38, relSubj19, relSubj29, relSubj39, iC, fC, cC, sD, ex, sum) VALUES ('" + schoolYear + "','" + stringify + "','" + student + "', '" + father + "', '" + studentLastname + "','" + stringifyDob + "', '" + generalVII + "','" + generalVIII + "','" + generalIX + "', '" + dsb1 + "' , '" + dsb2 + "','" + dsb3 + "','" + dsb4 + "', '" + dsb5 + "', '" + dsb6 + "', '" + intC + "','" + fedC + "', '" + canC + "','" + speC + "','" + extString + "', '" + sumSumare + "')";
                connectionHandler.connectAndCrud(insertQuery);

                //create table info (id int not null auto_increment primary key, schoolYear varchar (256) not null, entryDate varchar (256) not null, name varchar (256) not null, fatherName varchar (256) not null, surname varchar (256) not null, dob varchar (256) not null, gs7 double not null, gs8 double not null, gs9 double not null, relSubj18 double not null, relSubj28 double not null, relSubj38 double not null, relSubj19 double not null, relSubj29 double not null, relSubj39 double not null, iC varchar(256) not null, fC varchar(256) not null, cC varchar(256) not null, sD varchar(256) not null, ex double not null, sum double not null);
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
        });
        searchData2.getTheObject().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                sortList.getTheObject().setSelectedIndex(0);
                sortList1.getTheObject().setSelectedIndex(0);
            }
        });


        showButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //////////////////////////////////////////////////////////////////////////////////////////////





                //////////////////////////////////////////////////////////////////////////////////////////////

                if (sortList.getTheObject().getSelectedItem().equals("Prezime") && sortList1.getTheObject().getSelectedItem().equals("ASC")) {
                    String[] columns = {"id", "ŠG", "Datum", "Ime", "Ime oca", "Prezime", "Datum rođenja", "Opšti uspjeh VII", "Opšti uspjeh VIII", "Opšti uspjeh IX", "Rel. pred. I (VIII)", "Rel. pred. II (VIII)", "Rel. pred. III (VIII)", "Rel. pred. I (IX)", "Rel. pred. II (IX)", "Rel. pred. III (IX)", "Međunarodno takmičenje", "Federalno takmičenje", "Kantonalno takmčenje", "Posebna diploma", "Externa matura", "Broj bodova"};
                    Object[][] values = new Object[0][];
                    System.out.println(sortList.getTheObject().getSelectedItem());
                    System.out.println(sortList1.getTheObject().getSelectedItem());
                    Object[] tempArray;
                    DefaultTableModel tableModel = new DefaultTableModel(values, columns);
                    ResultSet set = null;

                    try {
                        PreparedStatement preparedStatement = connectionHandler.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT * FROM info ORDER BY surname ASC");
                        set = preparedStatement.executeQuery();
                        //set1 = connectionHandler.connectAndFetch("SELECT * FROM info ORDER BY surname ASC");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        while (set.next()) {

                            tempArray = new Object[]{
                                    set.getInt("id"), set.getString("schoolYear"), set.getString("entryDate"), set.getString("name"),
                                    set.getString("fatherName"), set.getString("surname"), set.getString("dob"), set.getDouble("gs7"),
                                    set.getDouble("gs8"), set.getDouble("gs9"), set.getDouble("relSubj18"), set.getDouble("relSubj28"),
                                    set.getDouble("relSubj38"), set.getDouble("relSubj19"), set.getDouble("relSubj29"), set.getDouble("relSubj39"), set.getString("iC"),
                                    set.getString("fC"), set.getString("cC"), set.getString("sD"), set.getDouble("ex"), set.getString("sum")};


                            tableModel.addRow(tempArray);


                        }


                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    JTable jTable = new JTable(tableModel);

                    JScrollPane jScrollPane = new JScrollPane(jTable);
                    jScrollPane.createHorizontalScrollBar();
                    jScrollPane.createVerticalScrollBar();

                    JPanel resPanel = new JPanel();
                    resPanel.setPreferredSize(new Dimension(1600,900));
                    resPanel.setBackground(Color.darkGray);

                    resPanel.add(jScrollPane);
                    jScrollPane.setPreferredSize(new Dimension(1600, 900));


                    JFrame jFrame = new JFrame();
                    jFrame.setPreferredSize(new Dimension(1600, 900));
                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jFrame.add(resPanel);
                    jFrame.pack();
                    jFrame.setVisible(true);



                }

                if (sortList.getTheObject().getSelectedItem().equals("Prezime") && sortList1.getTheObject().getSelectedItem().equals("DESC")) {
                    String[] columns = {"id", "ŠG", "Datum", "Ime", "Ime oca", "Prezime", "Datum rođenja", "Opšti uspjeh VII", "Opšti uspjeh VIII", "Opšti uspjeh IX", "Rel. pred. I (VIII)", "Rel. pred. II (VIII)", "Rel. pred. III (VIII)", "Rel. pred. I (IX)", "Rel. pred. II (IX)", "Rel. pred. III (IX)", "Međunarodno takmičenje", "Federalno takmičenje", "Kantonalno takmčenje", "Posebna diploma", "Externa matura", "Broj bodova"};
                    Object[][] values = new Object[0][];
                    System.out.println(sortList.getTheObject().getSelectedItem());
                    System.out.println(sortList1.getTheObject().getSelectedItem());
                    Object[] tempArray;
                    DefaultTableModel tableModel = new DefaultTableModel(values, columns);
                    ResultSet set = null;

                    try {
                        PreparedStatement preparedStatement = connectionHandler.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT * FROM info ORDER BY surname DESC");
                        set = preparedStatement.executeQuery();
                        //set1 = connectionHandler.connectAndFetch("SELECT * FROM info ORDER BY surname ASC");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        while (set.next()) {

                            tempArray = new Object[]{
                                    set.getInt("id"), set.getString("schoolYear"), set.getString("entryDate"), set.getString("name"),
                                    set.getString("fatherName"), set.getString("surname"), set.getString("dob"), set.getDouble("gs7"),
                                    set.getDouble("gs8"), set.getDouble("gs9"), set.getDouble("relSubj18"), set.getDouble("relSubj28"),
                                    set.getDouble("relSubj38"), set.getDouble("relSubj19"), set.getDouble("relSubj29"), set.getDouble("relSubj39"), set.getString("iC"),
                                    set.getString("fC"), set.getString("cC"), set.getString("sD"), set.getDouble("ex"), set.getString("sum")};


                            tableModel.addRow(tempArray);


                        }


                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    JTable jTable = new JTable(tableModel);

                    JScrollPane jScrollPane = new JScrollPane(jTable);
                    jScrollPane.createHorizontalScrollBar();
                    jScrollPane.createVerticalScrollBar();

                    JPanel resPanel = new JPanel();
                    resPanel.setPreferredSize(new Dimension(1600,900));
                    resPanel.setBackground(Color.darkGray);

                    resPanel.add(jScrollPane);
                    jScrollPane.setPreferredSize(new Dimension(1600, 900));


                    JFrame jFrame = new JFrame();
                    jFrame.setPreferredSize(new Dimension(1600, 900));
                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jFrame.add(resPanel);
                    jFrame.pack();
                    jFrame.setVisible(true);



                }

                if (sortList.getTheObject().getSelectedItem().equals("Ime") && sortList1.getTheObject().getSelectedItem().equals("ASC")) {
                    String[] columns = {"id", "ŠG", "Datum", "Ime", "Ime oca", "Prezime", "Datum rođenja", "Opšti uspjeh VII", "Opšti uspjeh VIII", "Opšti uspjeh IX", "Rel. pred. I (VIII)", "Rel. pred. II (VIII)", "Rel. pred. III (VIII)", "Rel. pred. I (IX)", "Rel. pred. II (IX)", "Rel. pred. III (IX)", "Međunarodno takmičenje", "Federalno takmičenje", "Kantonalno takmčenje", "Posebna diploma", "Externa matura", "Broj bodova"};
                    Object[][] values = new Object[0][];
                    System.out.println(sortList.getTheObject().getSelectedItem());
                    System.out.println(sortList1.getTheObject().getSelectedItem());
                    Object[] tempArray;
                    DefaultTableModel tableModel = new DefaultTableModel(values, columns);
                    ResultSet set = null;

                    try {
                        PreparedStatement preparedStatement = connectionHandler.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT * FROM info ORDER BY name ASC");
                        set = preparedStatement.executeQuery();
                        //set1 = connectionHandler.connectAndFetch("SELECT * FROM info ORDER BY surname ASC");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        while (set.next()) {

                            tempArray = new Object[]{
                                    set.getInt("id"), set.getString("schoolYear"), set.getString("entryDate"), set.getString("name"),
                                    set.getString("fatherName"), set.getString("surname"), set.getString("dob"), set.getDouble("gs7"),
                                    set.getDouble("gs8"), set.getDouble("gs9"), set.getDouble("relSubj18"), set.getDouble("relSubj28"),
                                    set.getDouble("relSubj38"), set.getDouble("relSubj19"), set.getDouble("relSubj29"), set.getDouble("relSubj39"), set.getString("iC"),
                                    set.getString("fC"), set.getString("cC"), set.getString("sD"), set.getDouble("ex"), set.getString("sum")};


                            tableModel.addRow(tempArray);


                        }


                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    JTable jTable = new JTable(tableModel);

                    JScrollPane jScrollPane = new JScrollPane(jTable);
                    jScrollPane.createHorizontalScrollBar();
                    jScrollPane.createVerticalScrollBar();
                    //JButton button = new JButton("Ime asc");
                    JPanel resPanel = new JPanel();
                    resPanel.setPreferredSize(new Dimension(1600,900));
                    resPanel.setBackground(Color.darkGray);
                    //resPanel.add(button);
                    resPanel.add(jScrollPane);
                    jScrollPane.setPreferredSize(new Dimension(1600, 900));


                    JFrame jFrame = new JFrame();
                    jFrame.setPreferredSize(new Dimension(1600, 900));
                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jFrame.add(resPanel);
                    jFrame.pack();
                    jFrame.setVisible(true);



                }

                if (sortList.getTheObject().getSelectedItem().equals("Ime") && sortList1.getTheObject().getSelectedItem().equals("DESC")) {
                    String[] columns = {"id", "ŠG", "Datum", "Ime", "Ime oca", "Prezime", "Datum rođenja", "Opšti uspjeh VII", "Opšti uspjeh VIII", "Opšti uspjeh IX", "Rel. pred. I (VIII)", "Rel. pred. II (VIII)", "Rel. pred. III (VIII)", "Rel. pred. I (IX)", "Rel. pred. II (IX)", "Rel. pred. III (IX)", "Međunarodno takmičenje", "Federalno takmičenje", "Kantonalno takmčenje", "Posebna diploma", "Externa matura", "Broj bodova"};
                    Object[][] values = new Object[0][];
                    System.out.println(sortList.getTheObject().getSelectedItem());
                    System.out.println(sortList1.getTheObject().getSelectedItem());
                    Object[] tempArray;
                    DefaultTableModel tableModel = new DefaultTableModel(values, columns);
                    ResultSet set = null;

                    try {
                        PreparedStatement preparedStatement = connectionHandler.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT * FROM info ORDER BY name DESC");
                        set = preparedStatement.executeQuery();
                        //set1 = connectionHandler.connectAndFetch("SELECT * FROM info ORDER BY surname ASC");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        while (set.next()) {

                            tempArray = new Object[]{
                                    set.getInt("id"), set.getString("schoolYear"), set.getString("entryDate"), set.getString("name"),
                                    set.getString("fatherName"), set.getString("surname"), set.getString("dob"), set.getDouble("gs7"),
                                    set.getDouble("gs8"), set.getDouble("gs9"), set.getDouble("relSubj18"), set.getDouble("relSubj28"),
                                    set.getDouble("relSubj38"), set.getDouble("relSubj19"), set.getDouble("relSubj29"), set.getDouble("relSubj39"), set.getString("iC"),
                                    set.getString("fC"), set.getString("cC"), set.getString("sD"), set.getDouble("ex"), set.getString("sum")};


                            tableModel.addRow(tempArray);


                        }


                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    JTable jTable = new JTable(tableModel);

                    JScrollPane jScrollPane = new JScrollPane(jTable);
                    jScrollPane.createHorizontalScrollBar();
                    jScrollPane.createVerticalScrollBar();
                    JPanel resPanel = new JPanel();
                    resPanel.setPreferredSize(new Dimension(1600,900));
                    resPanel.setBackground(Color.darkGray);
                    resPanel.add(jScrollPane);
                    jScrollPane.setPreferredSize(new Dimension(1600, 900));


                    JFrame jFrame = new JFrame();
                    jFrame.setPreferredSize(new Dimension(1600, 900));
                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jFrame.add(resPanel);
                    jFrame.pack();
                    jFrame.setVisible(true);



                }

                if (sortList.getTheObject().getSelectedItem().equals("Bodovi") && sortList1.getTheObject().getSelectedItem().equals("ASC")) {
                    String[] columns = {"id", "ŠG", "Datum", "Ime", "Ime oca", "Prezime", "Datum rođenja", "Opšti uspjeh VII", "Opšti uspjeh VIII", "Opšti uspjeh IX", "Rel. pred. I (VIII)", "Rel. pred. II (VIII)", "Rel. pred. III (VIII)", "Rel. pred. I (IX)", "Rel. pred. II (IX)", "Rel. pred. III (IX)", "Međunarodno takmičenje", "Federalno takmičenje", "Kantonalno takmčenje", "Posebna diploma", "Externa matura", "Broj bodova"};
                    Object[][] values = new Object[0][];
                    System.out.println(sortList.getTheObject().getSelectedItem());
                    System.out.println(sortList1.getTheObject().getSelectedItem());
                    Object[] tempArray;
                    DefaultTableModel tableModel = new DefaultTableModel(values, columns);
                    ResultSet set = null;

                    try {
                        PreparedStatement preparedStatement = connectionHandler.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT * FROM info ORDER BY sum ASC");
                        set = preparedStatement.executeQuery();
                        //set1 = connectionHandler.connectAndFetch("SELECT * FROM info ORDER BY surname ASC");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        while (set.next()) {

                            tempArray = new Object[]{
                                    set.getInt("id"), set.getString("schoolYear"), set.getString("entryDate"), set.getString("name"),
                                    set.getString("fatherName"), set.getString("surname"), set.getString("dob"), set.getDouble("gs7"),
                                    set.getDouble("gs8"), set.getDouble("gs9"), set.getDouble("relSubj18"), set.getDouble("relSubj28"),
                                    set.getDouble("relSubj38"), set.getDouble("relSubj19"), set.getDouble("relSubj29"), set.getDouble("relSubj39"), set.getString("iC"),
                                    set.getString("fC"), set.getString("cC"), set.getString("sD"), set.getDouble("ex"), set.getString("sum")};


                            tableModel.addRow(tempArray);


                        }


                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    JTable jTable = new JTable(tableModel);

                    JScrollPane jScrollPane = new JScrollPane(jTable);
                    jScrollPane.createHorizontalScrollBar();
                    jScrollPane.createVerticalScrollBar();
                    JPanel resPanel = new JPanel();
                    resPanel.setPreferredSize(new Dimension(1600,900));
                    resPanel.setBackground(Color.darkGray);
                    resPanel.add(jScrollPane);
                    jScrollPane.setPreferredSize(new Dimension(1600, 900));


                    JFrame jFrame = new JFrame();
                    jFrame.setPreferredSize(new Dimension(1600, 900));
                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jFrame.add(resPanel);
                    jFrame.pack();
                    jFrame.setVisible(true);



                }

                if (sortList.getTheObject().getSelectedItem().equals("Bodovi") && sortList1.getTheObject().getSelectedItem().equals("DESC")) {
                    String[] columns = {"id", "ŠG", "Datum", "Ime", "Ime oca", "Prezime", "Datum rođenja", "Opšti uspjeh VII", "Opšti uspjeh VIII", "Opšti uspjeh IX", "Rel. pred. I (VIII)", "Rel. pred. II (VIII)", "Rel. pred. III (VIII)", "Rel. pred. I (IX)", "Rel. pred. II (IX)", "Rel. pred. III (IX)", "Međunarodno takmičenje", "Federalno takmičenje", "Kantonalno takmčenje", "Posebna diploma", "Externa matura", "Broj bodova"};
                    Object[][] values = new Object[0][];
                    System.out.println(sortList.getTheObject().getSelectedItem());
                    System.out.println(sortList1.getTheObject().getSelectedItem());
                    Object[] tempArray;
                    DefaultTableModel tableModel = new DefaultTableModel(values, columns);
                    ResultSet set = null;

                    try {
                        PreparedStatement preparedStatement = connectionHandler.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT * FROM info ORDER BY sum DESC");
                        set = preparedStatement.executeQuery();
                        //set1 = connectionHandler.connectAndFetch("SELECT * FROM info ORDER BY surname ASC");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        while (set.next()) {

                            tempArray = new Object[]{
                                    set.getInt("id"), set.getString("schoolYear"), set.getString("entryDate"), set.getString("name"),
                                    set.getString("fatherName"), set.getString("surname"), set.getString("dob"), set.getDouble("gs7"),
                                    set.getDouble("gs8"), set.getDouble("gs9"), set.getDouble("relSubj18"), set.getDouble("relSubj28"),
                                    set.getDouble("relSubj38"), set.getDouble("relSubj19"), set.getDouble("relSubj29"), set.getDouble("relSubj39"), set.getString("iC"),
                                    set.getString("fC"), set.getString("cC"), set.getString("sD"), set.getDouble("ex"), set.getString("sum")};


                            tableModel.addRow(tempArray);


                        }


                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    JTable jTable = new JTable(tableModel);

                    JScrollPane jScrollPane = new JScrollPane(jTable);
                    jScrollPane.createHorizontalScrollBar();
                    jScrollPane.createVerticalScrollBar();

                    JPanel resPanel = new JPanel();
                    resPanel.setPreferredSize(new Dimension(1600,900));
                    resPanel.setBackground(Color.darkGray);

                    resPanel.add(jScrollPane);
                    jScrollPane.setPreferredSize(new Dimension(1600, 900));


                    JFrame jFrame = new JFrame();
                    jFrame.setPreferredSize(new Dimension(1600, 900));
                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jFrame.add(resPanel);
                    jFrame.pack();
                    jFrame.setVisible(true);



                }

                if (sortList.getTheObject().getSelectedItem().equals("id") && sortList1.getTheObject().getSelectedItem().equals("ASC")) {
                    String[] columns = {"id", "ŠG", "Datum", "Ime", "Ime oca", "Prezime", "Datum rođenja", "Opšti uspjeh VII", "Opšti uspjeh VIII", "Opšti uspjeh IX", "Rel. pred. I (VIII)", "Rel. pred. II (VIII)", "Rel. pred. III (VIII)", "Rel. pred. I (IX)", "Rel. pred. II (IX)", "Rel. pred. III (IX)", "Međunarodno takmičenje", "Federalno takmičenje", "Kantonalno takmčenje", "Posebna diploma", "Externa matura", "Broj bodova"};
                    Object[][] values = new Object[0][];
                    System.out.println(sortList.getTheObject().getSelectedItem());
                    System.out.println(sortList1.getTheObject().getSelectedItem());
                    Object[] tempArray;
                    DefaultTableModel tableModel = new DefaultTableModel(values, columns);
                    ResultSet set = null;

                    try {
                        PreparedStatement preparedStatement = connectionHandler.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT * FROM info ORDER BY id ASC");
                        set = preparedStatement.executeQuery();
                        //set1 = connectionHandler.connectAndFetch("SELECT * FROM info ORDER BY surname ASC");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        while (set.next()) {

                            tempArray = new Object[]{
                                    set.getInt("id"), set.getString("schoolYear"), set.getString("entryDate"), set.getString("name"),
                                    set.getString("fatherName"), set.getString("surname"), set.getString("dob"), set.getDouble("gs7"),
                                    set.getDouble("gs8"), set.getDouble("gs9"), set.getDouble("relSubj18"), set.getDouble("relSubj28"),
                                    set.getDouble("relSubj38"), set.getDouble("relSubj19"), set.getDouble("relSubj29"), set.getDouble("relSubj39"), set.getString("iC"),
                                    set.getString("fC"), set.getString("cC"), set.getString("sD"), set.getDouble("ex"), set.getString("sum")};


                            tableModel.addRow(tempArray);


                        }


                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    JTable jTable = new JTable(tableModel);

                    JScrollPane jScrollPane = new JScrollPane(jTable);
                    jScrollPane.createHorizontalScrollBar();
                    jScrollPane.createVerticalScrollBar();

                    JPanel resPanel = new JPanel();
                    resPanel.setPreferredSize(new Dimension(1600,900));
                    resPanel.setBackground(Color.darkGray);

                    resPanel.add(jScrollPane);
                    jScrollPane.setPreferredSize(new Dimension(1600, 900));


                    JFrame jFrame = new JFrame();
                    jFrame.setPreferredSize(new Dimension(1600, 900));
                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jFrame.add(resPanel);
                    jFrame.pack();
                    jFrame.setVisible(true);



                }

                if (sortList.getTheObject().getSelectedItem().equals("id") && sortList1.getTheObject().getSelectedItem().equals("DESC")) {
                    String[] columns = {"id", "ŠG", "Datum", "Ime", "Ime oca", "Prezime", "Datum rođenja", "Opšti uspjeh VII", "Opšti uspjeh VIII", "Opšti uspjeh IX", "Rel. pred. I (VIII)", "Rel. pred. II (VIII)", "Rel. pred. III (VIII)", "Rel. pred. I (IX)", "Rel. pred. II (IX)", "Rel. pred. III (IX)", "Međunarodno takmičenje", "Federalno takmičenje", "Kantonalno takmčenje", "Posebna diploma", "Externa matura", "Broj bodova"};
                    Object[][] values = new Object[0][];
                    System.out.println(sortList.getTheObject().getSelectedItem());
                    System.out.println(sortList1.getTheObject().getSelectedItem());
                    Object[] tempArray;
                    DefaultTableModel tableModel = new DefaultTableModel(values, columns);
                    ResultSet set = null;

                    try {
                        PreparedStatement preparedStatement = connectionHandler.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT * FROM info ORDER BY id DESC");
                        set = preparedStatement.executeQuery();
                        //set1 = connectionHandler.connectAndFetch("SELECT * FROM info ORDER BY surname ASC");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        while (set.next()) {

                            tempArray = new Object[]{
                                    set.getInt("id"), set.getString("schoolYear"), set.getString("entryDate"), set.getString("name"),
                                    set.getString("fatherName"), set.getString("surname"), set.getString("dob"), set.getDouble("gs7"),
                                    set.getDouble("gs8"), set.getDouble("gs9"), set.getDouble("relSubj18"), set.getDouble("relSubj28"),
                                    set.getDouble("relSubj38"), set.getDouble("relSubj19"), set.getDouble("relSubj29"), set.getDouble("relSubj39"), set.getString("iC"),
                                    set.getString("fC"), set.getString("cC"), set.getString("sD"), set.getDouble("ex"), set.getString("sum")};


                            tableModel.addRow(tempArray);


                        }


                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    JTable jTable = new JTable(tableModel);

                    JScrollPane jScrollPane = new JScrollPane(jTable);
                    jScrollPane.createHorizontalScrollBar();
                    jScrollPane.createVerticalScrollBar();

                    JPanel resPanel = new JPanel();
                    resPanel.setPreferredSize(new Dimension(1600,900));
                    resPanel.setBackground(Color.darkGray);

                    resPanel.add(jScrollPane);
                    jScrollPane.setPreferredSize(new Dimension(1600, 900));


                    JFrame jFrame = new JFrame();
                    jFrame.setPreferredSize(new Dimension(1600, 900));
                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jFrame.add(resPanel);
                    jFrame.pack();
                    jFrame.setVisible(true);



                }

               /* if (sortList.getTheObject().getSelectedItem().equals("Filter") && sortList1.getTheObject().getSelectedItem().equals("ASC/DESC")) {
                    String[] columns = {"id", "ŠG", "Datum", "Ime", "Ime oca", "Prezime", "Datum rođenja", "Opšti uspjeh VII", "Opšti uspjeh VIII", "Opšti uspjeh IX", "Rel. pred. I (VIII)", "Rel. pred. II (VIII)", "Rel. pred. III (VIII)", "Rel. pred. I (IX)", "Rel. pred. II (IX)", "Rel. pred. III (IX)", "Međunarodno takmičenje", "Federalno takmičenje", "Kantonalno takmčenje", "Posebna diploma", "Externa matura", "Broj bodova"};
                    Object[][] values = new Object[0][];
                    System.out.println(sortList.getTheObject().getSelectedItem());
                    System.out.println(sortList1.getTheObject().getSelectedItem());
                    Object[] tempArray;
                    DefaultTableModel tableModel = new DefaultTableModel(values, columns);
                    ResultSet set = null;

                    try {
                        PreparedStatement preparedStatement = connectionHandler.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT * FROM info");
                        set = preparedStatement.executeQuery();
                        //set1 = connectionHandler.connectAndFetch("SELECT * FROM info ORDER BY surname ASC");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        while (set.next()) {

                            tempArray = new Object[]{
                                    set.getInt("id"), set.getString("schoolYear"), set.getString("entryDate"), set.getString("name"),
                                    set.getString("fatherName"), set.getString("surname"), set.getString("dob"), set.getDouble("gs7"),
                                    set.getDouble("gs8"), set.getDouble("gs9"), set.getDouble("relSubj18"), set.getDouble("relSubj28"),
                                    set.getDouble("relSubj38"), set.getDouble("relSubj19"), set.getDouble("relSubj29"), set.getDouble("relSubj39"), set.getString("iC"),
                                    set.getString("fC"), set.getString("cC"), set.getString("sD"), set.getDouble("ex"), set.getString("sum")};


                            tableModel.addRow(tempArray);


                        }


                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    JTable jTable = new JTable(tableModel);

                    JScrollPane jScrollPane = new JScrollPane(jTable);
                    jScrollPane.createHorizontalScrollBar();
                    jScrollPane.createVerticalScrollBar();
                    //JButton button = new JButton("Ime asc");
                    JPanel resPanel = new JPanel();
                    resPanel.setPreferredSize(new Dimension(1600,900));
                    resPanel.setBackground(Color.darkGray);
                    //resPanel.add(button);
                    resPanel.add(jScrollPane);
                    jScrollPane.setPreferredSize(new Dimension(1600, 900));


                    JFrame jFrame = new JFrame();
                    jFrame.setPreferredSize(new Dimension(1600, 900));
                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jFrame.add(resPanel);
                    jFrame.pack();
                    jFrame.setVisible(true);



                }*/
                if (sortList.getTheObject().getSelectedItem().equals("Filter") && sortList1.getTheObject().getSelectedItem().equals("ASC/DESC") && searchData2.getTheObject().getText().isEmpty() ){
                    JDialog jDialog= new JDialog();
                    jDialog.setTitle("Upozorenje");
                    jDialog.setPreferredSize(new Dimension(400,300));
                    JPanel jPanel= new JPanel(new GridBagLayout());
                    jPanel.setPreferredSize(new Dimension(250, 250));
                    jPanel.setBackground(Color.darkGray);
                    JLabel jLabel= new JLabel("Molimo izaberite filtere ili upišite traženi pojam");
                    jLabel.setPreferredSize(new Dimension(350, 50));
                    jLabel.setForeground(Color.decode("#cc0000"));
                    jPanel.add(jLabel);
                    jDialog.add(jPanel);
                    jDialog.pack();
                    jDialog.setVisible(true);

                }



                if (!(searchData2.getTheObject().getText().isEmpty())){



                    String enteredData=searchData2.getTheObject().getText();
                    String[] columns = {"id", "ŠG", "Datum", "Ime", "Ime oca", "Prezime", "Datum rođenja", "Opšti uspjeh VII", "Opšti uspjeh VIII", "Opšti uspjeh IX", "Rel. pred. I (VIII)", "Rel. pred. II (VIII)", "Rel. pred. III (VIII)", "Rel. pred. I (IX)", "Rel. pred. II (IX)", "Rel. pred. III (IX)", "Međunarodno takmičenje", "Federalno takmičenje", "Kantonalno takmčenje", "Posebna diploma", "Externa matura", "Broj bodova"};
                    Object[][] values = new Object[0][];
                    System.out.println(sortList.getTheObject().getSelectedItem());
                    System.out.println(sortList1.getTheObject().getSelectedItem());
                    Object[] tempArray;
                    DefaultTableModel tableModel = new DefaultTableModel(values, columns);
                    ResultSet set = null;

                    try {
                        PreparedStatement preparedStatement = connectionHandler.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT * FROM info WHERE name LIKE '%" + enteredData + "%'  OR surname LIKE '%" + enteredData + "%'  ");
                        set = preparedStatement.executeQuery();
                        //set1 = connectionHandler.connectAndFetch("SELECT * FROM info ORDER BY surname ASC");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        while (set.next()) {

                            tempArray = new Object[]{
                                    set.getInt("id"), set.getString("schoolYear"), set.getString("entryDate"), set.getString("name"),
                                    set.getString("fatherName"), set.getString("surname"), set.getString("dob"), set.getDouble("gs7"),
                                    set.getDouble("gs8"), set.getDouble("gs9"), set.getDouble("relSubj18"), set.getDouble("relSubj28"),
                                    set.getDouble("relSubj38"), set.getDouble("relSubj19"), set.getDouble("relSubj29"), set.getDouble("relSubj39"), set.getString("iC"),
                                    set.getString("fC"), set.getString("cC"), set.getString("sD"), set.getDouble("ex"), set.getString("sum")};


                            tableModel.addRow(tempArray);


                        }


                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    JTable jTable = new JTable(tableModel);

                    JScrollPane jScrollPane = new JScrollPane(jTable);
                    jScrollPane.createHorizontalScrollBar();
                    jScrollPane.createVerticalScrollBar();

                    JPanel resPanel = new JPanel();
                    resPanel.setPreferredSize(new Dimension(1600,900));
                    resPanel.setBackground(Color.darkGray);

                    resPanel.add(jScrollPane);
                    jScrollPane.setPreferredSize(new Dimension(1600, 900));


                    JFrame jFrame = new JFrame();
                    jFrame.setPreferredSize(new Dimension(1600, 900));
                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jFrame.add(resPanel);
                    jFrame.pack();
                    jFrame.setVisible(true);


                    searchData2.getTheObject().setText("");



                }

                /*else {
                    //if (sortList.getTheObject().getSelectedItem().equals("Filter") && sortList1.getTheObject().getSelectedItem().equals("ASC/DESC")) {
                        String[] columns = {"id", "ŠG", "Datum", "Ime", "Ime oca", "Prezime", "Datum rođenja", "Opšti uspjeh VII", "Opšti uspjeh VIII", "Opšti uspjeh IX", "Rel. pred. I (VIII)", "Rel. pred. II (VIII)", "Rel. pred. III (VIII)", "Rel. pred. I (IX)", "Rel. pred. II (IX)", "Rel. pred. III (IX)", "Međunarodno takmičenje", "Federalno takmičenje", "Kantonalno takmčenje", "Posebna diploma", "Externa matura", "Broj bodova"};
                        Object[][] values = new Object[0][];
                        System.out.println(sortList.getTheObject().getSelectedItem());
                        System.out.println(sortList1.getTheObject().getSelectedItem());
                        Object[] tempArray;
                        DefaultTableModel tableModel = new DefaultTableModel(values, columns);
                        ResultSet set = null;

                        try {
                            PreparedStatement preparedStatement = connectionHandler.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT * FROM info");
                            set = preparedStatement.executeQuery();
                            //set1 = connectionHandler.connectAndFetch("SELECT * FROM info ORDER BY surname ASC");
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }

                        try {
                            while (set.next()) {

                                tempArray = new Object[]{
                                        set.getInt("id"), set.getString("schoolYear"), set.getString("entryDate"), set.getString("name"),
                                        set.getString("fatherName"), set.getString("surname"), set.getString("dob"), set.getDouble("gs7"),
                                        set.getDouble("gs8"), set.getDouble("gs9"), set.getDouble("relSubj18"), set.getDouble("relSubj28"),
                                        set.getDouble("relSubj38"), set.getDouble("relSubj19"), set.getDouble("relSubj29"), set.getDouble("relSubj39"), set.getString("iC"),
                                        set.getString("fC"), set.getString("cC"), set.getString("sD"), set.getDouble("ex"), set.getString("sum")};


                                tableModel.addRow(tempArray);


                            }


                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                        JTable jTable = new JTable(tableModel);

                        JScrollPane jScrollPane = new JScrollPane(jTable);
                        jScrollPane.createHorizontalScrollBar();
                        jScrollPane.createVerticalScrollBar();
                        //JButton button = new JButton("Ime asc");
                        JPanel resPanel = new JPanel();
                        resPanel.setPreferredSize(new Dimension(1600,900));
                        resPanel.setBackground(Color.darkGray);
                        //resPanel.add(button);
                        resPanel.add(jScrollPane);
                        jScrollPane.setPreferredSize(new Dimension(1600, 900));


                        JFrame jFrame = new JFrame();
                        jFrame.setPreferredSize(new Dimension(1600, 900));
                        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        jFrame.add(resPanel);
                        jFrame.pack();
                        jFrame.setVisible(true);



                    }*/



               // }

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

        });

        labelIconTwo.getTheObject().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                resultsJFrame.getTheObject().setVisible(true);


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


        });
labelIconThree.getTheObject().addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        deleteJFrame.getTheObject().add(deletePanel.getTheObject());
        deleteJFrame.getTheObject().pack();
        deleteJFrame.getTheObject().setVisible(true);
    }
});

deleteButton.addMouseListener(new MouseListener() {
    @Override
    public void mouseClicked(MouseEvent e) {
        GridBagLayout gridBagLayout= new GridBagLayout();
        GridBagConstraints gridBagConstraints= new GridBagConstraints();
        JDialog deleteDialog= new JDialog();
        deleteDialog.setTitle("Dialog za brisanje");
        deleteDialog.setPreferredSize(new Dimension(800,500));
         JPanel jPanel= new JPanel();
         jPanel.setPreferredSize(new Dimension(800,500));
         jPanel.setBackground(Color.darkGray);
         jPanel.setLayout(gridBagLayout);

        JLabel jLabel= new JLabel();
        jLabel.setPreferredSize(new Dimension(500,100));
        jLabel.setForeground(Color.white);
        jLabel.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.decode("#66d9ff")));


        JButton no= new JButton("Odustani");
        no.setPreferredSize(new Dimension(200, 50));
        no.setBackground(Color.darkGray);
        no.setForeground(Color.lightGray);

        JButton yes= new JButton("Izbriši");
        yes.setPreferredSize(new Dimension(200, 50));
        yes.setBackground(Color.decode("#ad070d"));
        yes.setForeground(Color.WHITE);





        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=0;

        gridBagConstraints.insets=new Insets(20,50,0,0);

        jPanel.add(jLabel, gridBagConstraints);


        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=1;
        gridBagConstraints.insets=new Insets(20,0,0,160);
        jPanel.add(no, gridBagConstraints);


        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=1;
        gridBagConstraints.insets=new Insets(20,300,0,0);
        jPanel.add(yes,gridBagConstraints);

        deleteDialog.add(jPanel);
        deleteDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        deleteDialog.pack();
        //deleteDialog.setVisible(false);

        if (!(searchForDeletion.getTheObject().getText().isEmpty())){

            ConnectionHandler connectionHandler1= new ConnectionHandler();
            try {
                PreparedStatement statement=connectionHandler1.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT * FROM info WHERE id='"+searchForDeletion.getTheObject().getText()+"' ");
                ResultSet resultSet=statement.executeQuery();
                while (resultSet.next()){
                    constraints.gridx=0;
                    constraints.gridy=0;
                    jPanel.add(jLabel);
                    jLabel.setText(String.valueOf("Potvrdite brisanje unosa sa id brojem "+resultSet.getInt("id")+" "+ resultSet.getString("name")+ " (" +resultSet.getString("fatherName")+ ") "+ resultSet.getString("surname")));
                    deleteDialog.setVisible(true);


                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            yes.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //searchForDeletion.getTheObject().setText("");
                    jLabel.setText("");
                    deleteDialog.setVisible(false);
                    String deleteQuery=("DELETE FROM info WHERE id='"+searchForDeletion.getTheObject().getText()+"'");

                    try {
                        Connection connection=connectionHandler1.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-" );

                        PreparedStatement preparedStatement= connection.prepareStatement(deleteQuery);
                        preparedStatement.executeUpdate();
                        searchForDeletion.getTheObject().setText("");
                        connection.close();


                    } catch (SQLException ex) {
                        ex.printStackTrace();
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
            });

        }else {
            GridBagLayout gridBagLayout1= new GridBagLayout();
            GridBagConstraints gridBagConstraints1= new GridBagConstraints();
            JDialog deleteDialog1= new JDialog();
            deleteDialog1.setTitle("Nije unešena vrijednost");
            deleteDialog1.setPreferredSize(new Dimension(500,300));
            JPanel jPanel1= new JPanel();
            jPanel1.setPreferredSize(new Dimension(500,300));
            jPanel1.setBackground(Color.darkGray);
            jPanel1.setLayout(gridBagLayout1);

            JLabel jLabel1= new JLabel();
            jLabel1.setPreferredSize(new Dimension(400,100));
            jLabel1.setForeground(Color.decode("#ad070d"));
            jLabel1.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.decode("#66d9ff")));
            jLabel1.setText("Morate unijeti vrijednost u polje za brisanje");



            gridBagConstraints1.gridx=0;
            gridBagConstraints1.gridy=0;


            jPanel1.add(jLabel1, gridBagConstraints1);


            deleteDialog1.add(jPanel1);
            deleteDialog1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            deleteDialog1.pack();
            deleteDialog1.setVisible(true);



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
});


    }

}

