package com.company;



import com.toedter.calendar.JCalendar;


import javax.swing.JFrame;

import java.awt.*;
import java.awt.Color;
import java.awt.event.*;

import java.awt.print.PrinterException;
import java.io.*;

import java.sql.*;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import org.jfree.data.category.DefaultCategoryDataset;

import org.jfree.data.general.DefaultPieDataset;




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
        resultsJFrame.getTheObject().setVisible(false);

        JFrame RsFrame = new JFrame();
        RsFrame.setTitle("Tabelarni prikaz podataka");
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
        ImageIcon iconPlus = new ImageIcon("src/com/company/plus(1).png");
        //<div>Icons made by <a href="https://www.flaticon.com/authors/pixel-perfect" title="Pixel perfect">Pixel perfect</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
        //"Icon made by Pixel perfect from www.flaticon.com"
        MyFrame<JLabel> labelIconOne = new MyFrame<JLabel>(new JLabel(iconPlus));
        labelIconOne.getTheObject().setSize(new Dimension(32, 32));
        labelIconOne.getTheObject().setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        labelIconOne.getTheObject().setToolTipText("Unos novih podataka");

        ImageIcon iconList = new ImageIcon("src/com/company/list(1).png");
        //<div>Icons made by <a href="https://icon54.com/" title="Pixel perfect">Pixel perfect</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
        //"Icon made by Pixel perfect from www.flaticon.com"
        MyFrame<JLabel> labelIconTwo = new MyFrame<JLabel>(new JLabel(iconList));
        labelIconTwo.getTheObject().setSize(new Dimension(32, 32));
        labelIconTwo.getTheObject().setToolTipText("Pregled unešenih podataka");

        ImageIcon iconDelete = new ImageIcon("src/com/company/delete(1).png");
        //<div>Icons made by <a href="https://www.flaticon.com/authors/pixelmeetup" title="Pixelmeetup">Pixelmeetup</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
        //"Icon made by Pixelmeetup from www.flaticon.com"
        MyFrame<JLabel> labelIconThree = new MyFrame<JLabel>(new JLabel(iconDelete));
        labelIconThree.getTheObject().setSize(new Dimension(32, 32));
        labelIconThree.getTheObject().setToolTipText("Brisanje podataka");

        ImageIcon statsIcon= new ImageIcon("src/com/company/stats.png");
        //<div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
        //"Icon made by Freepik from www.flaticon.com"
        MyFrame<JLabel> labelIconStats = new MyFrame<JLabel>(new JLabel(statsIcon));
        labelIconStats.getTheObject().setSize(new Dimension(32, 32));
        labelIconStats.getTheObject().setToolTipText("Statistika");


        ImageIcon iconShutDown = new ImageIcon("src/com/company/power-button(1).png");
        //<div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
        //"Icon made by Freepik from www.flaticon.com"
        MyFrame<JLabel> labelIconFour = new MyFrame<JLabel>(new JLabel(iconShutDown));
        labelIconFour.getTheObject().setSize(new Dimension(32, 32));
        labelIconFour.getTheObject().setToolTipText("Odjava i gašenje programa");

        ImageIcon iconBigPlus = new ImageIcon("src/com/company/bigPlus.png");
        //<div>Icons made by <a href="https://www.flaticon.com/authors/pixel-perfect" title="Pixel perfect">Pixel perfect</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
        //"Icon made by Pixel perfect from www.flaticon.com"
        MyFrame<JLabel> labelBigPlus = new MyFrame<JLabel>(new JLabel(iconBigPlus));
        labelBigPlus.getTheObject().setSize(new Dimension(64, 64));
        labelBigPlus.getTheObject().setToolTipText("Za unos novog podatka pritisnite na oznaku + ili bilo gdje na sivom pravougaoniku");

        ImageIcon iconInfo = new ImageIcon("src/com/company/info.png");
        //<div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
        //"Icon made by Freepik from www.flaticon.com"
        MyFrame<JLabel> iconInfoLabel = new MyFrame<JLabel>(new JLabel(iconInfo));
        iconInfoLabel.getTheObject().setSize(new Dimension(32, 32));
        iconInfoLabel.getTheObject().setToolTipText("Informacije o aplikaciji");

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

        ImageIcon calendarIcon = new ImageIcon("src/com/company/calendar.png");
        JLabel calendarIconLabel = new JLabel(calendarIcon);
        calendarIconLabel.setPreferredSize(new Dimension(32, 32));
        // <div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
        // "Icon made by Freepik from www.flaticon.com"


        MyFrame<JLabel> directionLabel = new MyFrame<JLabel>(new JLabel("Smjer"));
         directionLabel.getTheObject().setPreferredSize(new Dimension(200, 50));
        directionLabel.getTheObject().setForeground(Color.gray);
        directionLabel.getTheObject().setHorizontalAlignment(JLabel.CENTER);

        String[] directionList = {"Opšta gimnazija", "IT gimnazija"};
        MyFrame<JComboBox> directionData = new MyFrame<JComboBox>(new JComboBox(directionList));
        directionData.getTheObject().setPreferredSize(new Dimension(400, 50));
        directionData.getTheObject().setBackground(Color.darkGray);
        directionData.getTheObject().setForeground(Color.white);
        directionData.getTheObject().setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#66d9ff")));


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
        MyFrame<JLabel> usernameIcon = new MyFrame<JLabel>(new JLabel(new ImageIcon("src/com/company/user(1).png")));
        // <div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
        //"Icon made by Freepik from www.flaticon.com"
        usernameIcon.getTheObject().setPreferredSize(new Dimension(32, 32));
        usernameIcon.getTheObject().setBackground(Color.DARK_GRAY);
        usernameIcon.getTheObject().setForeground(Color.gray);
        usernameIcon.getTheObject().setToolTipText("Molimo unesite korisničko ime");

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

        MyFrame<JLabel> passwordIcon = new MyFrame<JLabel>(new JLabel(new ImageIcon("src/com/company/padlock(1).png")));
        //<div>Icons made by <a href="https://www.flaticon.com/authors/pixel-perfect" title="Pixel perfect">Pixel perfect</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
        //"Icon made by Pixel perfect from www.flaticon.com"
        passwordIcon.getTheObject().setPreferredSize(new Dimension(32, 32));
        passwordIcon.getTheObject().setBackground(Color.DARK_GRAY);
        passwordIcon.getTheObject().setForeground(Color.gray);
        passwordIcon.getTheObject().setToolTipText("Molimo unesite šifru");

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

        String[] listForSorting = {"Filter", "id", "Ime", "Prezime", "Bodovi", "Školska godina"};
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

        MyFrame<JLabel> searchLabel = new MyFrame<>(new JLabel("Pretraga prema pojmu (ime, ime oca, prezime...)"));
        searchLabel.getTheObject().setPreferredSize(new Dimension(400, 50));
        searchLabel.getTheObject().setHorizontalAlignment(JLabel.CENTER);
        searchLabel.getTheObject().setBackground(Color.DARK_GRAY);
        searchLabel.getTheObject().setForeground(Color.lightGray);


        JButton showButton = new JButton("Prikaži tabelu");
        showButton.setForeground(Color.decode("#66d9ff"));
        showButton.setPreferredSize(new Dimension(200, 50));
        showButton.setBackground(Color.darkGray);

        //<div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
        ImageIcon searchIcon= new ImageIcon("src/com/company/search.png");
        MyFrame<JLabel> searchIL = new MyFrame<>(new JLabel(searchIcon));
        searchIL.getTheObject().setPreferredSize(new Dimension(250, 64));
        searchIL.getTheObject().setHorizontalAlignment(JLabel.CENTER);
        searchIL.getTheObject().setBackground(Color.DARK_GRAY);

        // Components for delete panel

        MyFrame<JTextField> searchForDeletion = new MyFrame<>(new JTextField());
        searchForDeletion.getTheObject().setPreferredSize(new Dimension(400, 50));
        searchForDeletion.getTheObject().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#66d9ff")));
        searchForDeletion.getTheObject().setBackground(Color.darkGray);
        searchForDeletion.getTheObject().setForeground(Color.lightGray);
        searchForDeletion.getTheObject().setHorizontalAlignment(JTextField.CENTER);

        MyFrame<JLabel> deleteLabel = new MyFrame<>(new JLabel("Molimo unesite ID podatka za brisanje"));
        deleteLabel.getTheObject().setPreferredSize(new Dimension(300, 50));
        deleteLabel.getTheObject().setHorizontalAlignment(JLabel.CENTER);
        deleteLabel.getTheObject().setBackground(Color.DARK_GRAY);
        deleteLabel.getTheObject().setForeground(Color.lightGray);


        JButton deleteButton = new JButton("Izbriši podatak");
        deleteButton.setForeground(Color.white);
        deleteButton.setBackground(Color.decode("#f44336"));
        deleteButton.setPreferredSize(new Dimension(200, 50));
// za zutu kantu <div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
        //<div>Icons made by <a href="https://www.flaticon.com/authors/freepik" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
        // za plavu vecu kantu sa poklopce<div>Icons made by <a href="https://www.flaticon.com/authors/freepik" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
// za orange kanu sa krugom <div>Icons made by <a href="https://www.flaticon.com/authors/dinosoftlabs" title="DinosoftLabs">DinosoftLabs</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
        ImageIcon iIcon= new ImageIcon("src/com/company/trash.png");
        JLabel traschCanIcon= new JLabel(iIcon);

        // for 64 big remove<div>Icons made by <a href="https://www.flaticon.com/authors/freepik" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
// for orange 32 traschcan<div>Icons made by <a href="https://www.flaticon.com/authors/dinosoftlabs" title="DinosoftLabs">DinosoftLabs</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>


        JDialog defaultJDialog= new JDialog();
        defaultJDialog.setPreferredSize(new Dimension(600,400));
        defaultJDialog.setTitle("Upozorenje");
        JPanel defaultJPanel= new JPanel();
        defaultJPanel.setPreferredSize(new Dimension(600,400));
        defaultJPanel.setBackground(Color.darkGray);
        defaultJPanel.setLayout(new GridBagLayout());
        ImageIcon warningIcon= new ImageIcon("src/com/company/remove.png");
        JLabel defaultJLabel=new JLabel(warningIcon);
        JLabel defaultJLabelText= new JLabel("Upozorenje");
        defaultJLabelText.setForeground(Color.white);

        constraints.gridx=0;
        constraints.gridy=0;
        constraints.insets= new Insets(0, 0, 20, 0);
        defaultJPanel.add(defaultJLabel, constraints);
        constraints.gridx=0;
        constraints.gridy=1;
        defaultJPanel.add(defaultJLabelText, constraints);
        defaultJDialog.add(defaultJPanel);
        defaultJDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        defaultJDialog.pack();
        defaultJDialog.setVisible(false);




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
        plusPanel.getTheObject().add(directionData.getTheObject(), constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        plusPanel.getTheObject().add(directionLabel.getTheObject(), constraints);



        constraints.gridx = 0;
        constraints.gridy = 4;
        plusPanel.getTheObject().add(jCalendar.getTheObject(), constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        plusPanel.getTheObject().add(currentDateLabel.getTheObject(), constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
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
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.insets=new Insets(0,-200,50,0);
        resultsPanel.getTheObject().add(searchIL.getTheObject(), constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets=new Insets(0,0,0,0);
        resultsPanel.getTheObject().add(sortList.getTheObject(), constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.insets=new Insets(0,50,0,0);
        resultsPanel.getTheObject().add(sortList1.getTheObject(), constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;
        //constraints.insets=new Insets(0,0,0,0);
        resultsPanel.getTheObject().add(searchData2.getTheObject(), constraints);

        constraints.gridx = 2;
        constraints.gridy = 2;
        resultsPanel.getTheObject().add(searchLabel.getTheObject(), constraints);

        constraints.gridx = 3;
        constraints.gridy = 1;
        //constraints.insets = new Insets(50, 50, 0, 0);
        resultsPanel.getTheObject().add(showButton, constraints);

        // add to delete panel

        ImageIcon dI= new ImageIcon("src/com/company/delBig.png");
        JLabel dJl= new JLabel(dI);

        constraints.gridx=1;
        constraints.gridy=0;
        constraints.insets= new Insets(0,-610,50,25);
        deletePanel.getTheObject().add(dJl, constraints);



        constraints.gridx=0;
        constraints.gridy=1;
        constraints.insets= new Insets(0,230,0,0);
        deletePanel.getTheObject().add(searchForDeletion.getTheObject(), constraints);

        constraints.gridx=1;
        constraints.gridy=1;
        constraints.insets= new Insets(0,25,0,0);
        deletePanel.getTheObject().add(deleteButton, constraints);

        constraints.gridx=0;
        constraints.gridy=3;
        constraints.insets= new Insets(0,230,0,0);
        deletePanel.getTheObject().add(deleteLabel.getTheObject(), constraints);



        // Add to main JPanel
        mainPanelObj.getTheObject().add(sidePanel.getTheObject(), BorderLayout.WEST);
        mainPanelObj.getTheObject().add(labelBigPlus.getTheObject(), BorderLayout.CENTER);


        // Adding icons to panelOne
        sidePanel.getTheObject().add(labelIconOne.getTheObject());
        sidePanel.getTheObject().add(labelIconThree.getTheObject());
        sidePanel.getTheObject().add(labelIconTwo.getTheObject());
        sidePanel.getTheObject().add(labelIconStats.getTheObject());
        sidePanel.getTheObject().add(iconInfoLabel.getTheObject());
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
                popUpFrame.getTheObject().setVisible(false);
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
        nextButtonPPT.getTheObject().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (studentName.getTheObject().getText().equals("")){
                    defaultJLabelText.setText("Sva polja nemaju unešenu vrijednost");
                    defaultJDialog.setVisible(true);
                    popUpFrameThree.getTheObject().setVisible(false);


                }if (studentFatherName.getTheObject().getText().equals("")){
                    defaultJLabelText.setText("Sva polja nemaju unešenu vrijednost");
                    defaultJDialog.setVisible(true);
                    popUpFrameThree.getTheObject().setVisible(false);


                }
                if (studentSurname.getTheObject().getText().equals("")){
                    defaultJLabelText.setText("Sva polja nemaju unešenu vrijednost");
                    defaultJDialog.setVisible(true);
                    popUpFrameThree.getTheObject().setVisible(false);


                }

                if (!(studentName.getTheObject().getText().isEmpty())){
                    if (!(studentFatherName.getTheObject().getText().isEmpty())){
                        if (!(studentSurname.getTheObject().getText().isEmpty())){
                            popUpFrameThree.getTheObject().setVisible(true);
                            popUpFrameTwo.getTheObject().setVisible(false);
                        }
                    }

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                popUpFrameTwo.getTheObject().setVisible(true);
                popUpFrame.getTheObject().setVisible(false);
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
                            obj.getTheObject().setVisible(true);
                            loginJFrame.getTheObject().setVisible(false);
                            defaultJDialog.setVisible(false);
                            return;


                        }

                          if (!(set.getString("username").equals(usernameCred) && set.getString("password").equals(stringifyPassword))) {
                                System.out.println("Korisnicko ime ili šifra nisu tačni");
                                GridBagConstraints localGBC = new GridBagConstraints();
                                localGBC.gridx = 1;
                                localGBC.gridy = 4;
                                localGBC.insets = new Insets(10, 0, 0, 0);

                                defaultJLabelText.setText("Korisnicko ime ili šifra nisu tačni");
                                defaultJDialog.setVisible(true);



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
                if (extGradData.getText().isEmpty()){
                    resultsJFrame.getTheObject().setVisible(false);
                    defaultJLabelText.setText("Polje za eksternu maturu ne može biti prazno");
                    defaultJDialog.setVisible(true);
                }else {

                    resultsJFrame.getTheObject().setVisible(true);
                    popUpFrame.getTheObject().setVisible(false);
                    popUpFrameTwo.getTheObject().setVisible(false);
                    popUpFrameThree.getTheObject().setVisible(false);


                    String schoolYear = (String) schoolYearsListData.getTheObject().getSelectedItem();
                    String direction = (String) directionData.getTheObject().getSelectedItem();

                    Date jcalValue = jCalendar.getTheObject().getDate();
                    LocalDateTime currentDates = convertDate(jcalValue);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    String stringify = formatter.format(currentDates);

                    String student = null;
                    String father = null;
                    String studentLastname = null;


                    student = studentName.getTheObject().getText();


                    father = studentFatherName.getTheObject().getText();


                    studentLastname = studentSurname.getTheObject().getText();


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
                    String insertQuery = "INSERT INTO info(schoolYear, direction, entryDate, name, fatherName, surname, dob, gs7, gs8, gs9, relSubj18, relSubj28, relSubj38, relSubj19, relSubj29, relSubj39, iC, fC, cC, sD, ex, sum) VALUES ('" + schoolYear + "','" + direction + "','" + stringify + "','" + student + "', '" + father + "', '" + studentLastname + "','" + stringifyDob + "', '" + generalVII + "','" + generalVIII + "','" + generalIX + "', '" + dsb1 + "' , '" + dsb2 + "','" + dsb3 + "','" + dsb4 + "', '" + dsb5 + "', '" + dsb6 + "', '" + intC + "','" + fedC + "', '" + canC + "','" + speC + "','" + extString + "', '" + sumSumare + "')";
                    connectionHandler.connectAndCrud(insertQuery);
                }
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
                    String[] columns = {"id", "ŠG", "Smjer", "Datum", "Ime", "Ime oca", "Prezime", "Datum rođenja", "Opšti uspjeh VII", "Opšti uspjeh VIII", "Opšti uspjeh IX", "Rel. pred. I (VIII)", "Rel. pred. II (VIII)", "Rel. pred. III (VIII)", "Rel. pred. I (IX)", "Rel. pred. II (IX)", "Rel. pred. III (IX)", "Međunarodno takmičenje", "Federalno takmičenje", "Kantonalno takmčenje", "Posebna diploma", "Externa matura", "Broj bodova"};
                    Object[][] values = new Object[0][];
                    System.out.println(sortList.getTheObject().getSelectedItem());
                    System.out.println(sortList1.getTheObject().getSelectedItem());
                    Object[] tempArray;
                    DefaultTableModel tableModel = new DefaultTableModel(values, columns);
                    ResultSet set = null;

                    try {
                        PreparedStatement preparedStatement = connectionHandler.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT * FROM info ORDER BY surname ASC");
                        set = preparedStatement.executeQuery();

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        while (set.next()) {

                            tempArray = new Object[]{
                                    set.getInt("id"), set.getString("schoolYear"),set.getString("direction"), set.getString("entryDate"), set.getString("name"),
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
                    jScrollPane.setVerticalScrollBar(jScrollPane.createVerticalScrollBar());


                    JPanel resPanel = new JPanel();
                    resPanel.setPreferredSize(new Dimension(1600,900));
                    resPanel.setBackground(Color.darkGray);



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    BoxLayout boxLayout= new BoxLayout(resPanel, BoxLayout.X_AXIS);
                    resPanel.setLayout(boxLayout);
                    resPanel.add(Box.createRigidArea(new Dimension(0,10)));

                    JPanel resPanelSide= new JPanel();
                    resPanelSide.setPreferredSize(new Dimension(64,900));
                    resPanelSide.setBackground(Color.black);
                    resPanelSide.setLayout(new GridLayout(6,1, 10, 20 ));

// za printer icona
//<div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
                    ImageIcon ii= new ImageIcon("src/com/company/printer.png");
                    JLabel jl= new JLabel(ii);

                    resPanelSide.add(jl);
                    jl.setToolTipText("Pritisnite za printanje dokumenta");



                    ////<div>Icons made by <a href="https://icon54.com/" title="Pixel perfect">Pixel perfect</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
                    //Slika za snimanje dokumenta

                    ImageIcon iO= new ImageIcon("src/com/company/export.png");
                    JLabel jlO= new JLabel(iO);

                    jlO.setToolTipText("Pritisnite za snimanje tabele na PC");
                    resPanelSide.add(jlO);





                    resPanel.add(resPanelSide);
                    resPanel.add(jScrollPane);



                    jScrollPane.setPreferredSize(new Dimension(1600, 900));


                    JFrame jFrame = new JFrame("Tabelarni prikaz podataka");
                    jFrame.setPreferredSize(new Dimension(1600, 900));
                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jFrame.add(resPanel);

                    jFrame.pack();
                    jFrame.setVisible(true);



                    jl.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            try {
                                MessageFormat msgH= new MessageFormat("Spisak učenika");
                                boolean printJob=jTable.print(JTable.PrintMode.FIT_WIDTH);
                                if (printJob){
                                    System.out.println("Printanje je uspješno");
                                }else{
                                    System.out.println("Printanje nije uspjelo");
                                }
                            } catch (PrinterException ex) {
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

                   jlO.addMouseListener(new MouseListener() {
                       @Override
                       public void mouseClicked(MouseEvent e) {
                           saveTable(jTable,RsFrame);


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

                if (sortList.getTheObject().getSelectedItem().equals("Prezime") && sortList1.getTheObject().getSelectedItem().equals("DESC")) {
                    String[] columns = {"id", "ŠG","Smjer", "Datum", "Ime", "Ime oca", "Prezime", "Datum rođenja", "Opšti uspjeh VII", "Opšti uspjeh VIII", "Opšti uspjeh IX", "Rel. pred. I (VIII)", "Rel. pred. II (VIII)", "Rel. pred. III (VIII)", "Rel. pred. I (IX)", "Rel. pred. II (IX)", "Rel. pred. III (IX)", "Međunarodno takmičenje", "Federalno takmičenje", "Kantonalno takmčenje", "Posebna diploma", "Externa matura", "Broj bodova"};
                    Object[][] values = new Object[0][];
                    System.out.println(sortList.getTheObject().getSelectedItem());
                    System.out.println(sortList1.getTheObject().getSelectedItem());
                    Object[] tempArray;
                    DefaultTableModel tableModel = new DefaultTableModel(values, columns);
                    ResultSet set = null;

                    try {
                        PreparedStatement preparedStatement = connectionHandler.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT * FROM info ORDER BY surname DESC");
                        set = preparedStatement.executeQuery();

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        while (set.next()) {

                            tempArray = new Object[]{
                                    set.getInt("id"), set.getString("schoolYear"),set.getString("direction"), set.getString("entryDate"), set.getString("name"),
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


                    BoxLayout boxLayout= new BoxLayout(resPanel, BoxLayout.X_AXIS);
                    resPanel.setLayout(boxLayout);
                    resPanel.add(Box.createRigidArea(new Dimension(0,10)));

                    JPanel resPanelSide= new JPanel();
                    resPanelSide.setPreferredSize(new Dimension(64,900));
                    resPanelSide.setBackground(Color.black);
                    resPanelSide.setLayout(new GridLayout(6,1, 10, 20 ));

// za printer icona
//<div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
                    ImageIcon ii= new ImageIcon("/home/emir/IdeaProjects/JavaSwingApp/src/com/company/printer.png");
                    JLabel jl= new JLabel(ii);

                    resPanelSide.add(jl);
                    jl.setToolTipText("Pritisnite za printanje dokumenta");



                    ////<div>Icons made by <a href="https://icon54.com/" title="Pixel perfect">Pixel perfect</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
                    //Slika za snimanje dokumenta

                    ImageIcon iO= new ImageIcon("src/com/company/export.png");
                    JLabel jlO= new JLabel(iO);

                    jlO.setToolTipText("Pritisnite za snimanje tabele na PC");
                    resPanelSide.add(jlO);





                    resPanel.add(resPanelSide);
                    resPanel.add(jScrollPane);
                    jScrollPane.setPreferredSize(new Dimension(1600, 900));


                    JFrame jFrame = new JFrame("Tabelarni prikaz podataka");
                    jFrame.setPreferredSize(new Dimension(1600, 900));
                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jFrame.add(resPanel);
                    jFrame.pack();
                    jFrame.setVisible(true);
                    jl.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            try {
                                MessageFormat msgH= new MessageFormat("Spisak učenika");
                                boolean printJob=jTable.print(JTable.PrintMode.FIT_WIDTH);
                                if (printJob){
                                    System.out.println("Printanje je uspješno");
                                }else{
                                    System.out.println("Printanje nije uspjelo");
                                }
                            } catch (PrinterException ex) {
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
                    jlO.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            saveTable(jTable,RsFrame);
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

                if (sortList.getTheObject().getSelectedItem().equals("Ime") && sortList1.getTheObject().getSelectedItem().equals("ASC")) {
                    String[] columns = {"id", "ŠG","Smjer", "Datum", "Ime", "Ime oca", "Prezime", "Datum rođenja", "Opšti uspjeh VII", "Opšti uspjeh VIII", "Opšti uspjeh IX", "Rel. pred. I (VIII)", "Rel. pred. II (VIII)", "Rel. pred. III (VIII)", "Rel. pred. I (IX)", "Rel. pred. II (IX)", "Rel. pred. III (IX)", "Međunarodno takmičenje", "Federalno takmičenje", "Kantonalno takmčenje", "Posebna diploma", "Externa matura", "Broj bodova"};
                    Object[][] values = new Object[0][];
                    System.out.println(sortList.getTheObject().getSelectedItem());
                    System.out.println(sortList1.getTheObject().getSelectedItem());
                    Object[] tempArray;
                    DefaultTableModel tableModel = new DefaultTableModel(values, columns);
                    ResultSet set = null;

                    try {
                        PreparedStatement preparedStatement = connectionHandler.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT * FROM info ORDER BY name ASC");
                        set = preparedStatement.executeQuery();

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        while (set.next()) {

                            tempArray = new Object[]{
                                    set.getInt("id"), set.getString("schoolYear"),set.getString("direction"), set.getString("entryDate"), set.getString("name"),
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
                    BoxLayout boxLayout= new BoxLayout(resPanel, BoxLayout.X_AXIS);
                    resPanel.setLayout(boxLayout);
                    resPanel.add(Box.createRigidArea(new Dimension(0,10)));

                    JPanel resPanelSide= new JPanel();
                    resPanelSide.setPreferredSize(new Dimension(64,900));
                    resPanelSide.setBackground(Color.black);
                    resPanelSide.setLayout(new GridLayout(6,1, 10, 20 ));

// za printer icona
//<div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
                    ImageIcon ii= new ImageIcon("src/com/company/printer.png");
                    JLabel jl= new JLabel(ii);

                    resPanelSide.add(jl);
                    jl.setToolTipText("Pritisnite za printanje dokumenta");



                    ////<div>Icons made by <a href="https://icon54.com/" title="Pixel perfect">Pixel perfect</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
                    //Slika za snimanje dokumenta

                    ImageIcon iO= new ImageIcon("src/com/company/export.png");
                    JLabel jlO= new JLabel(iO);

                    jlO.setToolTipText("Pritisnite za snimanje tabele na PC");
                    resPanelSide.add(jlO);





                    resPanel.add(resPanelSide);
                    resPanel.add(jScrollPane);
                    jScrollPane.setPreferredSize(new Dimension(1600, 900));


                    JFrame jFrame = new JFrame("Tabelarni prikaz podataka");
                    jFrame.setPreferredSize(new Dimension(1600, 900));
                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jFrame.add(resPanel);
                    jFrame.pack();
                    jFrame.setVisible(true);

                    jl.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            try {
                                MessageFormat msgH= new MessageFormat("Spisak učenika");
                                boolean printJob=jTable.print(JTable.PrintMode.FIT_WIDTH);
                                if (printJob){
                                    System.out.println("Printanje je uspješno");
                                }else{
                                    System.out.println("Printanje nije uspjelo");
                                }
                            } catch (PrinterException ex) {
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
                    jlO.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            saveTable(jTable,RsFrame);
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

                if (sortList.getTheObject().getSelectedItem().equals("Ime") && sortList1.getTheObject().getSelectedItem().equals("DESC")) {
                    String[] columns = {"id", "ŠG","Smjer", "Datum", "Ime", "Ime oca", "Prezime", "Datum rođenja", "Opšti uspjeh VII", "Opšti uspjeh VIII", "Opšti uspjeh IX", "Rel. pred. I (VIII)", "Rel. pred. II (VIII)", "Rel. pred. III (VIII)", "Rel. pred. I (IX)", "Rel. pred. II (IX)", "Rel. pred. III (IX)", "Međunarodno takmičenje", "Federalno takmičenje", "Kantonalno takmčenje", "Posebna diploma", "Externa matura", "Broj bodova"};
                    Object[][] values = new Object[0][];
                    System.out.println(sortList.getTheObject().getSelectedItem());
                    System.out.println(sortList1.getTheObject().getSelectedItem());
                    Object[] tempArray;
                    DefaultTableModel tableModel = new DefaultTableModel(values, columns);
                    ResultSet set = null;

                    try {
                        PreparedStatement preparedStatement = connectionHandler.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT * FROM info ORDER BY name DESC");
                        set = preparedStatement.executeQuery();

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        while (set.next()) {

                            tempArray = new Object[]{
                                    set.getInt("id"), set.getString("schoolYear"),set.getString("direction"), set.getString("entryDate"), set.getString("name"),
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
                    BoxLayout boxLayout= new BoxLayout(resPanel, BoxLayout.X_AXIS);
                    resPanel.setLayout(boxLayout);
                    resPanel.add(Box.createRigidArea(new Dimension(0,10)));

                    JPanel resPanelSide= new JPanel();
                    resPanelSide.setPreferredSize(new Dimension(64,900));
                    resPanelSide.setBackground(Color.black);
                    resPanelSide.setLayout(new GridLayout(6,1, 10, 20 ));

// za printer icona
//<div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
                    ImageIcon ii= new ImageIcon("src/com/company/printer.png");
                    JLabel jl= new JLabel(ii);

                    resPanelSide.add(jl);
                    jl.setToolTipText("Pritisnite za printanje dokumenta");



                    ////<div>Icons made by <a href="https://icon54.com/" title="Pixel perfect">Pixel perfect</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
                    //Slika za snimanje dokumenta

                    ImageIcon iO= new ImageIcon("src/com/company/export.png");
                    JLabel jlO= new JLabel(iO);

                    jlO.setToolTipText("Pritisnite za snimanje tabele na PC");
                    resPanelSide.add(jlO);





                    resPanel.add(resPanelSide);
                    resPanel.add(jScrollPane);
                    jScrollPane.setPreferredSize(new Dimension(1600, 900));


                    JFrame jFrame = new JFrame("Tabelarni prikaz podataka");
                    jFrame.setPreferredSize(new Dimension(1600, 900));
                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jFrame.add(resPanel);
                    jFrame.pack();
                    jFrame.setVisible(true);

                    jl.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            try {
                                MessageFormat msgH= new MessageFormat("Spisak učenika");
                                boolean printJob=jTable.print(JTable.PrintMode.FIT_WIDTH);
                                if (printJob){
                                    System.out.println("Printanje je uspješno");
                                }else{
                                    System.out.println("Printanje nije uspjelo");
                                }
                            } catch (PrinterException ex) {
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

                    jlO.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            saveTable(jTable, RsFrame);
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

                if (sortList.getTheObject().getSelectedItem().equals("Bodovi") && sortList1.getTheObject().getSelectedItem().equals("ASC")) {
                    String[] columns = {"id", "ŠG","Smjer", "Datum", "Ime", "Ime oca", "Prezime", "Datum rođenja", "Opšti uspjeh VII", "Opšti uspjeh VIII", "Opšti uspjeh IX", "Rel. pred. I (VIII)", "Rel. pred. II (VIII)", "Rel. pred. III (VIII)", "Rel. pred. I (IX)", "Rel. pred. II (IX)", "Rel. pred. III (IX)", "Međunarodno takmičenje", "Federalno takmičenje", "Kantonalno takmčenje", "Posebna diploma", "Externa matura", "Broj bodova"};
                    Object[][] values = new Object[0][];
                    System.out.println(sortList.getTheObject().getSelectedItem());
                    System.out.println(sortList1.getTheObject().getSelectedItem());
                    Object[] tempArray;
                    DefaultTableModel tableModel = new DefaultTableModel(values, columns);
                    ResultSet set = null;

                    try {
                        PreparedStatement preparedStatement = connectionHandler.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT * FROM info ORDER BY sum ASC");
                        set = preparedStatement.executeQuery();

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        while (set.next()) {

                            tempArray = new Object[]{
                                    set.getInt("id"), set.getString("schoolYear"),set.getString("direction"), set.getString("entryDate"), set.getString("name"),
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

                    BoxLayout boxLayout= new BoxLayout(resPanel, BoxLayout.X_AXIS);
                    resPanel.setLayout(boxLayout);
                    resPanel.add(Box.createRigidArea(new Dimension(0,10)));

                    JPanel resPanelSide= new JPanel();
                    resPanelSide.setPreferredSize(new Dimension(64,900));
                    resPanelSide.setBackground(Color.black);
                    resPanelSide.setLayout(new GridLayout(6,1, 10, 20 ));

// za printer icona
//<div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
                    ImageIcon ii= new ImageIcon("src/com/company/printer.png");
                    JLabel jl= new JLabel(ii);

                    resPanelSide.add(jl);
                    jl.setToolTipText("Pritisnite za printanje dokumenta");



                    ////<div>Icons made by <a href="https://icon54.com/" title="Pixel perfect">Pixel perfect</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
                    //Slika za snimanje dokumenta

                    ImageIcon iO= new ImageIcon("src/com/company/export.png");
                    JLabel jlO= new JLabel(iO);

                    jlO.setToolTipText("Pritisnite za snimanje tabele na PC");
                    resPanelSide.add(jlO);





                    resPanel.add(resPanelSide);
                    resPanel.add(jScrollPane);
                    jScrollPane.setPreferredSize(new Dimension(1600, 900));


                    JFrame jFrame = new JFrame("Tabelarni prikaz podataka");
                    jFrame.setPreferredSize(new Dimension(1600, 900));
                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jFrame.add(resPanel);
                    jFrame.pack();
                    jFrame.setVisible(true);

                    jl.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            try {
                                MessageFormat msgH= new MessageFormat("Spisak učenika");
                                boolean printJob=jTable.print(JTable.PrintMode.FIT_WIDTH);
                                if (printJob){
                                    System.out.println("Printanje je uspješno");
                                }else{
                                    System.out.println("Printanje nije uspjelo");
                                }
                            } catch (PrinterException ex) {
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
                    jlO.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            saveTable(jTable, RsFrame);
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

                if (sortList.getTheObject().getSelectedItem().equals("Bodovi") && sortList1.getTheObject().getSelectedItem().equals("DESC")) {
                    String[] columns = {"id", "ŠG", "Smjer", "Datum", "Ime", "Ime oca", "Prezime", "Datum rođenja", "Opšti uspjeh VII", "Opšti uspjeh VIII", "Opšti uspjeh IX", "Rel. pred. I (VIII)", "Rel. pred. II (VIII)", "Rel. pred. III (VIII)", "Rel. pred. I (IX)", "Rel. pred. II (IX)", "Rel. pred. III (IX)", "Međunarodno takmičenje", "Federalno takmičenje", "Kantonalno takmčenje", "Posebna diploma", "Externa matura", "Broj bodova"};
                    Object[][] values = new Object[0][];
                    System.out.println(sortList.getTheObject().getSelectedItem());
                    System.out.println(sortList1.getTheObject().getSelectedItem());
                    Object[] tempArray;
                    DefaultTableModel tableModel = new DefaultTableModel(values, columns);
                    ResultSet set = null;

                    try {
                        PreparedStatement preparedStatement = connectionHandler.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT * FROM info ORDER BY sum DESC");
                        set = preparedStatement.executeQuery();

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        while (set.next()) {

                            tempArray = new Object[]{
                                    set.getInt("id"), set.getString("schoolYear"),set.getString("direction"), set.getString("entryDate"), set.getString("name"),
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

                    BoxLayout boxLayout= new BoxLayout(resPanel, BoxLayout.X_AXIS);
                    resPanel.setLayout(boxLayout);
                    resPanel.add(Box.createRigidArea(new Dimension(0,10)));

                    JPanel resPanelSide= new JPanel();
                    resPanelSide.setPreferredSize(new Dimension(64,900));
                    resPanelSide.setBackground(Color.black);
                    resPanelSide.setLayout(new GridLayout(6,1, 10, 20 ));

// za printer icona
//<div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
                    ImageIcon ii= new ImageIcon("src/com/company/printer.png");
                    JLabel jl= new JLabel(ii);

                    resPanelSide.add(jl);
                    jl.setToolTipText("Pritisnite za printanje dokumenta");



                    ////<div>Icons made by <a href="https://icon54.com/" title="Pixel perfect">Pixel perfect</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
                    //Slika za snimanje dokumenta

                    ImageIcon iO= new ImageIcon("src/com/company/export.png");
                    JLabel jlO= new JLabel(iO);

                    jlO.setToolTipText("Pritisnite za snimanje tabele na PC");
                    resPanelSide.add(jlO);





                    resPanel.add(resPanelSide);
                    resPanel.add(jScrollPane);
                    jScrollPane.setPreferredSize(new Dimension(1600, 900));


                    JFrame jFrame = new JFrame("Tabelarni prikaz podataka");
                    jFrame.setPreferredSize(new Dimension(1600, 900));
                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jFrame.add(resPanel);
                    jFrame.pack();
                    jFrame.setVisible(true);

                    jl.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            try {
                                MessageFormat msgH= new MessageFormat("Spisak učenika");
                                boolean printJob=jTable.print(JTable.PrintMode.FIT_WIDTH);
                                if (printJob){
                                    System.out.println("Printanje je uspješno");
                                }else{
                                    System.out.println("Printanje nije uspjelo");
                                }
                            } catch (PrinterException ex) {
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

                    jlO.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            saveTable(jTable, RsFrame);
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

                if (sortList.getTheObject().getSelectedItem().equals("id") && sortList1.getTheObject().getSelectedItem().equals("ASC")) {
                    String[] columns = {"id", "ŠG","Smjer", "Datum", "Ime", "Ime oca", "Prezime", "Datum rođenja", "Opšti uspjeh VII", "Opšti uspjeh VIII", "Opšti uspjeh IX", "Rel. pred. I (VIII)", "Rel. pred. II (VIII)", "Rel. pred. III (VIII)", "Rel. pred. I (IX)", "Rel. pred. II (IX)", "Rel. pred. III (IX)", "Međunarodno takmičenje", "Federalno takmičenje", "Kantonalno takmčenje", "Posebna diploma", "Externa matura", "Broj bodova"};
                    Object[][] values = new Object[0][];
                    System.out.println(sortList.getTheObject().getSelectedItem());
                    System.out.println(sortList1.getTheObject().getSelectedItem());
                    Object[] tempArray;
                    DefaultTableModel tableModel = new DefaultTableModel(values, columns);
                    ResultSet set = null;

                    try {
                        PreparedStatement preparedStatement = connectionHandler.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT * FROM info ORDER BY id ASC");
                        set = preparedStatement.executeQuery();

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        while (set.next()) {

                            tempArray = new Object[]{
                                    set.getInt("id"), set.getString("schoolYear"),set.getString("direction"), set.getString("entryDate"), set.getString("name"),
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

                    BoxLayout boxLayout= new BoxLayout(resPanel, BoxLayout.X_AXIS);
                    resPanel.setLayout(boxLayout);
                    resPanel.add(Box.createRigidArea(new Dimension(0,10)));

                    JPanel resPanelSide= new JPanel();
                    resPanelSide.setPreferredSize(new Dimension(64,900));
                    resPanelSide.setBackground(Color.black);
                    resPanelSide.setLayout(new GridLayout(6,1, 10, 20 ));

// za printer icona
//<div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
                    ImageIcon ii= new ImageIcon("src/com/company/printer.png");
                    JLabel jl= new JLabel(ii);

                    resPanelSide.add(jl);
                    jl.setToolTipText("Pritisnite za printanje dokumenta");



                    ////<div>Icons made by <a href="https://icon54.com/" title="Pixel perfect">Pixel perfect</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
                    //Slika za snimanje dokumenta

                    ImageIcon iO= new ImageIcon("src/com/company/export.png");
                    JLabel jlO= new JLabel(iO);

                    jlO.setToolTipText("Pritisnite za snimanje tabele na PC");
                    resPanelSide.add(jlO);





                    resPanel.add(resPanelSide);
                    resPanel.add(jScrollPane);
                    jScrollPane.setPreferredSize(new Dimension(1600, 900));


                    JFrame jFrame = new JFrame("Tabelarni prikaz podataka");
                    jFrame.setPreferredSize(new Dimension(1600, 900));
                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jFrame.add(resPanel);
                    jFrame.pack();
                    jFrame.setVisible(true);

                    jl.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            try {
                                MessageFormat msgH= new MessageFormat("Spisak učenika");
                                boolean printJob=jTable.print(JTable.PrintMode.FIT_WIDTH);
                                if (printJob){
                                    System.out.println("Printanje je uspješno");
                                }else{
                                    System.out.println("Printanje nije uspjelo");
                                }
                            } catch (PrinterException ex) {
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
                    jlO.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            saveTable(jTable, RsFrame);
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

                if (sortList.getTheObject().getSelectedItem().equals("id") && sortList1.getTheObject().getSelectedItem().equals("DESC")) {
                    String[] columns = {"id", "ŠG","Smjer", "Datum", "Ime", "Ime oca", "Prezime", "Datum rođenja", "Opšti uspjeh VII", "Opšti uspjeh VIII", "Opšti uspjeh IX", "Rel. pred. I (VIII)", "Rel. pred. II (VIII)", "Rel. pred. III (VIII)", "Rel. pred. I (IX)", "Rel. pred. II (IX)", "Rel. pred. III (IX)", "Međunarodno takmičenje", "Federalno takmičenje", "Kantonalno takmčenje", "Posebna diploma", "Externa matura", "Broj bodova"};
                    Object[][] values = new Object[0][];
                    System.out.println(sortList.getTheObject().getSelectedItem());
                    System.out.println(sortList1.getTheObject().getSelectedItem());
                    Object[] tempArray;
                    DefaultTableModel tableModel = new DefaultTableModel(values, columns);
                    ResultSet set = null;

                    try {
                        PreparedStatement preparedStatement = connectionHandler.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT * FROM info ORDER BY id DESC");
                        set = preparedStatement.executeQuery();

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        while (set.next()) {

                            tempArray = new Object[]{
                                    set.getInt("id"), set.getString("schoolYear"),set.getString("direction"), set.getString("entryDate"), set.getString("name"),
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

                    BoxLayout boxLayout= new BoxLayout(resPanel, BoxLayout.X_AXIS);
                    resPanel.setLayout(boxLayout);
                    resPanel.add(Box.createRigidArea(new Dimension(0,10)));

                    JPanel resPanelSide= new JPanel();
                    resPanelSide.setPreferredSize(new Dimension(64,900));
                    resPanelSide.setBackground(Color.black);
                    resPanelSide.setLayout(new GridLayout(6,1, 10, 20 ));

// za printer icona
//<div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
                    ImageIcon ii= new ImageIcon("src/com/company/printer.png");
                    JLabel jl= new JLabel(ii);

                    resPanelSide.add(jl);
                    jl.setToolTipText("Pritisnite za printanje dokumenta");



                    ////<div>Icons made by <a href="https://icon54.com/" title="Pixel perfect">Pixel perfect</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
                    //Slika za snimanje dokumenta

                    ImageIcon iO= new ImageIcon("src/com/company/export.png");
                    JLabel jlO= new JLabel(iO);

                    jlO.setToolTipText("Pritisnite za snimanje tabele na PC");
                    resPanelSide.add(jlO);





                    resPanel.add(resPanelSide);
                    resPanel.add(jScrollPane);
                    jScrollPane.setPreferredSize(new Dimension(1600, 900));


                    JFrame jFrame = new JFrame("Tabelarni prikaz podataka");
                    jFrame.setPreferredSize(new Dimension(1600, 900));
                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jFrame.add(resPanel);
                    jFrame.pack();
                    jFrame.setVisible(true);

                    jl.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            try {
                                MessageFormat msgH= new MessageFormat("Spisak učenika");
                                boolean printJob=jTable.print(JTable.PrintMode.FIT_WIDTH);
                                if (printJob){
                                    System.out.println("Printanje je uspješno");
                                }else{
                                    System.out.println("Printanje nije uspjelo");
                                }
                            } catch (PrinterException ex) {
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
                    jlO.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            saveTable(jTable,RsFrame);
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
                ////////////////////////////////////////////////////////////////////////////

                if (sortList.getTheObject().getSelectedItem().equals("Školska godina") && sortList1.getTheObject().getSelectedItem().equals("ASC")) {
                    String[] columns = {"id", "ŠG","Smjer", "Datum", "Ime", "Ime oca", "Prezime", "Datum rođenja", "Opšti uspjeh VII", "Opšti uspjeh VIII", "Opšti uspjeh IX", "Rel. pred. I (VIII)", "Rel. pred. II (VIII)", "Rel. pred. III (VIII)", "Rel. pred. I (IX)", "Rel. pred. II (IX)", "Rel. pred. III (IX)", "Međunarodno takmičenje", "Federalno takmičenje", "Kantonalno takmčenje", "Posebna diploma", "Externa matura", "Broj bodova"};
                    Object[][] values = new Object[0][];
                    System.out.println(sortList.getTheObject().getSelectedItem());
                    System.out.println(sortList1.getTheObject().getSelectedItem());
                    Object[] tempArray;
                    DefaultTableModel tableModel = new DefaultTableModel(values, columns);
                    ResultSet set = null;

                    try {
                        PreparedStatement preparedStatement = connectionHandler.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT * FROM info ORDER BY schoolYear ASC");
                        set = preparedStatement.executeQuery();

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        while (set.next()) {

                            tempArray = new Object[]{
                                    set.getInt("id"), set.getString("schoolYear"),set.getString("direction"), set.getString("entryDate"), set.getString("name"),
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

                    BoxLayout boxLayout= new BoxLayout(resPanel, BoxLayout.X_AXIS);
                    resPanel.setLayout(boxLayout);
                    resPanel.add(Box.createRigidArea(new Dimension(0,10)));

                    JPanel resPanelSide= new JPanel();
                    resPanelSide.setPreferredSize(new Dimension(64,900));
                    resPanelSide.setBackground(Color.black);
                    resPanelSide.setLayout(new GridLayout(6,1, 10, 20 ));

// za printer icona
//<div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
                    ImageIcon ii= new ImageIcon("src/com/company/printer.png");
                    JLabel jl= new JLabel(ii);

                    resPanelSide.add(jl);
                    jl.setToolTipText("Pritisnite za printanje dokumenta");



                    ////<div>Icons made by <a href="https://icon54.com/" title="Pixel perfect">Pixel perfect</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
                    //Slika za snimanje dokumenta

                    ImageIcon iO= new ImageIcon("src/com/company/export.png");
                    JLabel jlO= new JLabel(iO);

                    jlO.setToolTipText("Pritisnite za snimanje tabele na PC");
                    resPanelSide.add(jlO);





                    resPanel.add(resPanelSide);
                    resPanel.add(jScrollPane);
                    jScrollPane.setPreferredSize(new Dimension(1600, 900));


                    JFrame jFrame = new JFrame("Tabelarni prikaz podataka");
                    jFrame.setPreferredSize(new Dimension(1600, 900));
                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jFrame.add(resPanel);
                    jFrame.pack();
                    jFrame.setVisible(true);

                    jl.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            try {
                                MessageFormat msgH= new MessageFormat("Spisak učenika");
                                boolean printJob=jTable.print(JTable.PrintMode.FIT_WIDTH);
                                if (printJob){
                                    System.out.println("Printanje je uspješno");
                                }else{
                                    System.out.println("Printanje nije uspjelo");
                                }
                            } catch (PrinterException ex) {
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
                    jlO.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            saveTable(jTable, RsFrame);
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

                if (sortList.getTheObject().getSelectedItem().equals("Školska godina") && sortList1.getTheObject().getSelectedItem().equals("DESC")) {
                    String[] columns = {"id", "ŠG","Smjer", "Datum", "Ime", "Ime oca", "Prezime", "Datum rođenja", "Opšti uspjeh VII", "Opšti uspjeh VIII", "Opšti uspjeh IX", "Rel. pred. I (VIII)", "Rel. pred. II (VIII)", "Rel. pred. III (VIII)", "Rel. pred. I (IX)", "Rel. pred. II (IX)", "Rel. pred. III (IX)", "Međunarodno takmičenje", "Federalno takmičenje", "Kantonalno takmčenje", "Posebna diploma", "Externa matura", "Broj bodova"};
                    Object[][] values = new Object[0][];
                    System.out.println(sortList.getTheObject().getSelectedItem());
                    System.out.println(sortList1.getTheObject().getSelectedItem());
                    Object[] tempArray;
                    DefaultTableModel tableModel = new DefaultTableModel(values, columns);
                    ResultSet set = null;

                    try {
                        PreparedStatement preparedStatement = connectionHandler.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT * FROM info ORDER BY schoolYear DESC");
                        set = preparedStatement.executeQuery();

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        while (set.next()) {

                            tempArray = new Object[]{
                                    set.getInt("id"), set.getString("schoolYear"),set.getString("direction"), set.getString("entryDate"), set.getString("name"),
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

                    BoxLayout boxLayout= new BoxLayout(resPanel, BoxLayout.X_AXIS);
                    resPanel.setLayout(boxLayout);
                    resPanel.add(Box.createRigidArea(new Dimension(0,10)));

                    JPanel resPanelSide= new JPanel();
                    resPanelSide.setPreferredSize(new Dimension(64,900));
                    resPanelSide.setBackground(Color.black);
                    resPanelSide.setLayout(new GridLayout(6,1, 10, 20 ));

// za printer icona
//<div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
                    ImageIcon ii= new ImageIcon("src/com/company/printer.png");
                    JLabel jl= new JLabel(ii);

                    resPanelSide.add(jl);
                    jl.setToolTipText("Pritisnite za printanje dokumenta");



                    ////<div>Icons made by <a href="https://icon54.com/" title="Pixel perfect">Pixel perfect</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
                    //Slika za snimanje dokumenta

                    ImageIcon iO= new ImageIcon("src/com/company/export.png");
                    JLabel jlO= new JLabel(iO);

                    jlO.setToolTipText("Pritisnite za snimanje tabele na PC");
                    resPanelSide.add(jlO);





                    resPanel.add(resPanelSide);
                    resPanel.add(jScrollPane);
                    jScrollPane.setPreferredSize(new Dimension(1600, 900));


                    JFrame jFrame = new JFrame("Tabelarni prikaz podataka");
                    jFrame.setPreferredSize(new Dimension(1600, 900));
                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jFrame.add(resPanel);
                    jFrame.pack();
                    jFrame.setVisible(true);

                    jl.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            try {
                                MessageFormat msgH= new MessageFormat("Spisak učenika");
                                boolean printJob=jTable.print(JTable.PrintMode.FIT_WIDTH);
                                if (printJob){
                                    System.out.println("Printanje je uspješno");
                                }else{
                                    System.out.println("Printanje nije uspjelo");
                                }
                            } catch (PrinterException ex) {
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
                    jlO.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            saveTable(jTable, RsFrame);
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

                ///////////////////////////////////////////////////////////////////////////


                if (sortList.getTheObject().getSelectedItem().equals("Filter") && sortList1.getTheObject().getSelectedItem().equals("ASC/DESC") && searchData2.getTheObject().getText().isEmpty() ){
                    JDialog jDialog= new JDialog();
                    jDialog.setTitle("Upozorenje");
                    jDialog.setPreferredSize(new Dimension(400,300));
                    JPanel jPanel= new JPanel(new GridBagLayout());
                    jPanel.setPreferredSize(new Dimension(250, 250));
                    jPanel.setBackground(Color.darkGray);

                    defaultJLabelText.setText("Molimo izaberite filtere ili upišite traženi pojam");
                    defaultJDialog.setVisible(true);

                }



                if (!(searchData2.getTheObject().getText().isEmpty())){



                    String enteredData=searchData2.getTheObject().getText();
                    String[] columns = {"id", "ŠG","Smjer", "Datum", "Ime", "Ime oca", "Prezime", "Datum rođenja", "Opšti uspjeh VII", "Opšti uspjeh VIII", "Opšti uspjeh IX", "Rel. pred. I (VIII)", "Rel. pred. II (VIII)", "Rel. pred. III (VIII)", "Rel. pred. I (IX)", "Rel. pred. II (IX)", "Rel. pred. III (IX)", "Međunarodno takmičenje", "Federalno takmičenje", "Kantonalno takmčenje", "Posebna diploma", "Externa matura", "Broj bodova"};
                    Object[][] values = new Object[0][];
                    System.out.println(sortList.getTheObject().getSelectedItem());
                    System.out.println(sortList1.getTheObject().getSelectedItem());
                    Object[] tempArray;
                    DefaultTableModel tableModel = new DefaultTableModel(values, columns);
                    ResultSet set = null;

                    try {
                        PreparedStatement preparedStatement = connectionHandler.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT * FROM info WHERE name LIKE '%" + enteredData + "%'  OR surname LIKE '%" + enteredData + "%' OR schoolYear LIKE '%" + enteredData + "%' OR direction LIKE '%" + enteredData + "%' OR fatherName LIKE '%" + enteredData + "%'OR dob LIKE '%" + enteredData + "%'   ");
                        set = preparedStatement.executeQuery();
                        //set1 = connectionHandler.connectAndFetch("SELECT * FROM info ORDER BY surname ASC");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        while (set.next()) {

                            tempArray = new Object[]{
                                    set.getInt("id"), set.getString("schoolYear"),set.getString("direction"), set.getString("entryDate"), set.getString("name"),
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

                    BoxLayout boxLayout= new BoxLayout(resPanel, BoxLayout.X_AXIS);
                    resPanel.setLayout(boxLayout);
                    resPanel.add(Box.createRigidArea(new Dimension(0,10)));

                    JPanel resPanelSide= new JPanel();
                    resPanelSide.setPreferredSize(new Dimension(64,900));
                    resPanelSide.setBackground(Color.black);
                    resPanelSide.setLayout(new GridLayout(6,1, 10, 20 ));

// za printer icona
//<div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
                    ImageIcon ii= new ImageIcon("src/com/company/printer.png");
                    JLabel jl= new JLabel(ii);

                    resPanelSide.add(jl);
                    jl.setToolTipText("Pritisnite za printanje dokumenta");



                    ////<div>Icons made by <a href="https://icon54.com/" title="Pixel perfect">Pixel perfect</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
                    //Slika za snimanje dokumenta

                    ImageIcon iO= new ImageIcon("src/com/company/export.png");
                    JLabel jlO= new JLabel(iO);

                    jlO.setToolTipText("Pritisnite za snimanje tabele na PC");
                    resPanelSide.add(jlO);





                    resPanel.add(resPanelSide);
                    resPanel.add(jScrollPane);
                    jScrollPane.setPreferredSize(new Dimension(1600, 900));


                    JFrame jFrame = new JFrame("Tabelarni prikaz podataka");
                    jFrame.setPreferredSize(new Dimension(1600, 900));
                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jFrame.add(resPanel);
                    jFrame.pack();
                    jFrame.setVisible(true);

                    jl.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            try {
                                MessageFormat msgH= new MessageFormat("Spisak učenika");
                                boolean printJob=jTable.print(JTable.PrintMode.FIT_WIDTH);
                                if (printJob){
                                    System.out.println("Printanje je uspješno");
                                }else{
                                    System.out.println("Printanje nije uspjelo");
                                }
                            } catch (PrinterException ex) {
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
                    jlO.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            saveTable(jTable, RsFrame);
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


                    searchData2.getTheObject().setText("");



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

         ImageIcon icon= new ImageIcon("src/com/company/deleteTrasch.png");
         JLabel labelForIcon= new JLabel(icon);

        JLabel jLabel= new JLabel("",SwingConstants.CENTER);
        jLabel.setPreferredSize(new Dimension(500,100));
        jLabel.setForeground(Color.white);
        jLabel.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.decode("#66d9ff")));



        JButton no= new JButton("Odustani");
        no.setPreferredSize(new Dimension(200, 50));
        no.setBackground(Color.darkGray);
        no.setForeground(Color.lightGray);

        JButton yes= new JButton("Izbriši");
        yes.setPreferredSize(new Dimension(200, 50));
        yes.setBackground(Color.decode("#f44336"));
        yes.setForeground(Color.WHITE);



        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=0;
        gridBagConstraints.insets=new Insets(0,0,170,-500);
        jPanel.add(labelForIcon, gridBagConstraints);

        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=1;
        gridBagConstraints.insets=new Insets(20,0,-70,0);
        jPanel.add(jLabel, gridBagConstraints);


        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=2;
        gridBagConstraints.insets=new Insets(-20,0,0,160);
        jPanel.add(no, gridBagConstraints);


        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=2;
        gridBagConstraints.insets=new Insets(-20,300,0,0);
        jPanel.add(yes,gridBagConstraints);

        deleteDialog.add(jPanel);
        deleteDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        deleteDialog.pack();
        //deleteDialog.setVisible(false);


        //////////////////////////////////////////////////////////////////////7
        JDialog defaultJDialog= new JDialog();
        defaultJDialog.setPreferredSize(new Dimension(600,400));
        defaultJDialog.setTitle("Upozorenje");
        JPanel defaultJPanel= new JPanel();
        defaultJPanel.setPreferredSize(new Dimension(600,400));
        defaultJPanel.setBackground(Color.darkGray);
        defaultJPanel.setLayout(new GridBagLayout());
        ImageIcon warningIcon= new ImageIcon("src/com/company/remove.png");
        JLabel defaultJLabel=new JLabel(warningIcon);
        JLabel defaultJLabelText= new JLabel("Morate unijeti ID za brisanje");
        defaultJLabelText.setForeground(Color.white);

        constraints.gridx=0;
        constraints.gridy=0;
        constraints.insets= new Insets(0, 0, 20, 0);
        defaultJPanel.add(defaultJLabel, constraints);
        constraints.gridx=0;
        constraints.gridy=1;
        defaultJPanel.add(defaultJLabelText, constraints);
        defaultJDialog.add(defaultJPanel);
        defaultJDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        defaultJDialog.pack();
        defaultJDialog.setVisible(false);

        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteDialog.setVisible(false);
            }
        });

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
            //deleteDialog1.setVisible(true);
            defaultJLabelText.setText("Morate unijeti vrijednost u polje za brisanje");
            defaultJDialog.setVisible(true);



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





labelIconStats.getTheObject().addMouseListener(new MouseListener() {

    @Override
    public void mouseClicked(MouseEvent e) {

        JFrame infoFrame= new JFrame();
      infoFrame.setPreferredSize(new Dimension(1280,768));
      infoFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      infoFrame.setTitle("Statistički podaci");
      String [] list= {"Školska godina","2022/2023","2023/2024","2024/2025","2025/2026","2026/2027"};
      JComboBox sy=new JComboBox(list);
      sy.setPreferredSize(new Dimension(200,50));
      JLabel jLabelTip= new JLabel("Molimo izaberite školsku godinu");
      jLabelTip.setForeground(Color.lightGray);
      JButton jButtonShowStats= new JButton("Prikaži statistiku");
      jButtonShowStats.setPreferredSize(new Dimension(200,50));
      jButtonShowStats.setBackground(Color.darkGray);
      jButtonShowStats.setForeground(Color.lightGray);
      JPanel wrapper= new JPanel(new GridBagLayout());
      GridBagConstraints gbc= new GridBagConstraints();
      wrapper.setPreferredSize(new Dimension(1280,768));
      wrapper.setBackground(Color.darkGray);
      //<div>Icons made by <a href="https://www.flaticon.com/authors/ultimatearm" title="ultimatearm">ultimatearm</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
      ImageIcon icon= new ImageIcon("src/com/company/research.png");
      JLabel labelIcon= new JLabel(icon);

      gbc.gridx=1;
      gbc.gridy=0;
      gbc.insets= new Insets(20,-450,50,0);
      wrapper.add(labelIcon, gbc);

     gbc.gridx=0;
     gbc.gridy=1;
     gbc.insets= new Insets(0,220,0,0);
     wrapper.add(sy, gbc);

     gbc.gridx=0;
     gbc.gridy=2;
     gbc.insets= new Insets(20,220,0,0);
     wrapper.add(jLabelTip, gbc);

     gbc.gridx=1;
     gbc.gridy=1;
     gbc.insets= new Insets(0,20,0,0);
     wrapper.add(jButtonShowStats, gbc);


     infoFrame.add(wrapper);
      infoFrame.pack();
      infoFrame.setVisible(true);
      //////////////////////////////////////////////////////////////////////////
        jButtonShowStats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double it21=16.0;
                double og21=34.0;
                double it22=0;
                double og22=0;
                double it23=0;
                double og23=0;
                double it24=0;
                double og24=0;
                double it25=0;
                double og25=0;
                double it26=0;
                double og26=0;


                if (sy.getSelectedItem().equals("2022/2023")) {
                    DefaultCategoryDataset categoryDataset= new DefaultCategoryDataset();
                    JFreeChart lineChart= ChartFactory.createLineChart("Statistički prikaz kroz godine", "Školske godine", "Broj upisanih učenika", categoryDataset);

                    ConnectionHandler ch = new ConnectionHandler();
                try {
                    PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2022/2023' AND direction='IT gimnazija'");
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                       it22=Double.valueOf(resultSet.getRow());


                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2022/2023' AND direction='Opšta gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                           og22=Double.valueOf(resultSet.getRow());
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }


                    categoryDataset.setValue(og21,"Opšta gimnazija", "2021/2022");
                    categoryDataset.setValue(og22,"Opšta gimnazija", "2022/2023");

                    categoryDataset.setValue(it21,"IT gimnazija", "2021/2022");
                    categoryDataset.setValue(it22,"IT gimnazija", "2022/2023");




                    JFrame jFrameTwo= new JFrame();
                    jFrameTwo.setPreferredSize(new Dimension(1280,768));
                    jFrameTwo.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    ChartPanel chartPanel= new ChartPanel(lineChart);
                    jFrameTwo.add(chartPanel);
                    jFrameTwo.pack();
                    jFrameTwo.setVisible(true);



                    try {
                        DefaultPieDataset defaultPieDataset= new DefaultPieDataset();
                        JFreeChart pieChart= ChartFactory.createPieChart3D("Broj prijavljenih i primljenih učenika", defaultPieDataset);
                        double numberOfApplications=0;
                        double numberOfAcceptances=0;
                        ConnectionHandler c= new ConnectionHandler();
                        PreparedStatement preparedSt= c.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2022/2023'");
                        ResultSet resultSet=preparedSt.executeQuery();
                        while (resultSet.next()){
                            numberOfAcceptances=resultSet.getRow();

                        }
                        //System.out.println(numberOfAcceptances);
                        PreparedStatement preparedStTwo= c.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE schoolYear='2022/2023'");
                        ResultSet resultSetTwo=preparedStTwo.executeQuery();
                        while (resultSetTwo.next()){
                            numberOfApplications=resultSetTwo.getRow();

                        }
                        //System.out.println(numberOfApplications);
                        JFrame pieChartJFrame= new JFrame();
                        pieChartJFrame.setPreferredSize(new Dimension(1280,768));
                        pieChartJFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                        defaultPieDataset.setValue("Broj prijavljenih učenika", numberOfApplications);
                        defaultPieDataset.setValue("Broj primljenih učenika", numberOfAcceptances);

                        ChartPanel chartPaneLforPieC=new ChartPanel(pieChart);
                        pieChartJFrame.add(chartPaneLforPieC);
                        //pieChartJFrame.setTitle("Broj prijavljenih učenika/broj primljenih učenika");
                        pieChartJFrame.pack();
                        pieChartJFrame.setVisible(true);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
                if (sy.getSelectedItem().equals("2023/2024")) {
                    DefaultCategoryDataset categoryDataset= new DefaultCategoryDataset();
                    JFreeChart lineChart= ChartFactory.createLineChart("Statistički prikaz kroz godine", "Školske godine", "Broj upisanih učenika", categoryDataset);

                    ConnectionHandler ch = new ConnectionHandler();
                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2022/2023' AND direction='IT gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            it22=Double.valueOf(resultSet.getRow());


                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2022/2023' AND direction='Opšta gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            og22=Double.valueOf(resultSet.getRow());
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }



                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2023/2024' AND direction='IT gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            double d=resultSet.getRow();
                            it23=Double.valueOf(resultSet.getRow());



                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2023/2024' AND direction='Opšta gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            og23=Double.valueOf(resultSet.getRow());
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }



                    categoryDataset.setValue(og21,"Opšta gimnazija", "2021/2022");
                    categoryDataset.setValue(it21,"IT gimnazija", "2021/2022");

                    categoryDataset.setValue(og22,"Opšta gimnazija", "2022/2023");
                    categoryDataset.setValue(it22,"IT gimnazija", "2022/2023");

                    categoryDataset.setValue(og23,"Opšta gimnazija", "2023/2024");

                    categoryDataset.setValue(it23,"IT gimnazija", "2023/2024");




                    JFrame jFrameTwo= new JFrame();
                    jFrameTwo.setPreferredSize(new Dimension(1280,768));
                    jFrameTwo.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    ChartPanel chartPanel= new ChartPanel(lineChart);
                    jFrameTwo.add(chartPanel);
                    jFrameTwo.pack();
                    jFrameTwo.setVisible(true);


                    try {
                        DefaultPieDataset defaultPieDataset= new DefaultPieDataset();
                        JFreeChart pieChart= ChartFactory.createPieChart3D("Broj prijavljenih i primljenih učenika", defaultPieDataset);
                        double numberOfApplications=0;
                        double numberOfAcceptances=0;
                        ConnectionHandler c= new ConnectionHandler();
                        PreparedStatement preparedSt= c.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2023/2024'");
                        ResultSet resultSet=preparedSt.executeQuery();
                        while (resultSet.next()){
                            numberOfAcceptances=resultSet.getRow();

                        }

                        PreparedStatement preparedStTwo= c.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE schoolYear='2023/2024'");
                        ResultSet resultSetTwo=preparedStTwo.executeQuery();
                        while (resultSetTwo.next()){
                            numberOfApplications=resultSetTwo.getRow();

                        }
                        //System.out.println(numberOfApplications);
                        JFrame pieChartJFrame= new JFrame();
                        pieChartJFrame.setPreferredSize(new Dimension(1280,768));
                        pieChartJFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                        defaultPieDataset.setValue("Broj prijavljenih učenika", numberOfApplications);
                        defaultPieDataset.setValue("Broj primljenih učenika", numberOfAcceptances);

                        ChartPanel chartPaneLforPieC=new ChartPanel(pieChart);
                        pieChartJFrame.add(chartPaneLforPieC);

                        pieChartJFrame.pack();
                        pieChartJFrame.setVisible(true);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
                if (sy.getSelectedItem().equals("2024/2025")) {
                    DefaultCategoryDataset categoryDataset= new DefaultCategoryDataset();
                    JFreeChart lineChart= ChartFactory.createLineChart("Statistički prikaz kroz godine", "Školske godine", "Broj upisanih učenika", categoryDataset);

                    ConnectionHandler ch = new ConnectionHandler();
                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2022/2023' AND direction='IT gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            it22=Double.valueOf(resultSet.getRow());


                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2022/2023' AND direction='Opšta gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            og22=Double.valueOf(resultSet.getRow());
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }



                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2023/2024' AND direction='IT gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            double d=resultSet.getRow();
                            it23=Double.valueOf(resultSet.getRow());



                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2023/2024' AND direction='Opšta gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            og23=Double.valueOf(resultSet.getRow());
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2024/2025' AND direction='IT gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {

                            it24=Double.valueOf(resultSet.getRow());
                            System.out.println("2024/2025 it"+it24);


                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2024/2025' AND direction='Opšta gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            og24=Double.valueOf(resultSet.getRow());

                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }


                    categoryDataset.setValue(og21,"Opšta gimnazija", "2021/2022");
                    categoryDataset.setValue(it21,"IT gimnazija", "2021/2022");

                    categoryDataset.setValue(og22,"Opšta gimnazija", "2022/2023");
                    categoryDataset.setValue(it22,"IT gimnazija", "2022/2023");

                    categoryDataset.setValue(og23,"Opšta gimnazija", "2023/2024");

                    categoryDataset.setValue(it23,"IT gimnazija", "2023/2024");

                    categoryDataset.setValue(og24,"Opšta gimnazija", "2024/2025");

                    categoryDataset.setValue(it24,"IT gimnazija", "2024/2025");



                    JFrame jFrameTwo= new JFrame();
                    jFrameTwo.setPreferredSize(new Dimension(1280,768));
                    jFrameTwo.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    ChartPanel chartPanel= new ChartPanel(lineChart);
                    jFrameTwo.add(chartPanel);
                    jFrameTwo.pack();
                    jFrameTwo.setVisible(true);
                    try {
                        DefaultPieDataset defaultPieDataset= new DefaultPieDataset();
                        JFreeChart pieChart= ChartFactory.createPieChart3D("Broj prijavljenih i primljenih učenika", defaultPieDataset);
                        double numberOfApplications=0;
                        double numberOfAcceptances=0;
                        ConnectionHandler c= new ConnectionHandler();
                        PreparedStatement preparedSt= c.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2024/2025'");
                        ResultSet resultSet=preparedSt.executeQuery();
                        while (resultSet.next()){
                            numberOfAcceptances=resultSet.getRow();

                        }

                        PreparedStatement preparedStTwo= c.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE schoolYear='2024/2025'");
                        ResultSet resultSetTwo=preparedStTwo.executeQuery();
                        while (resultSetTwo.next()){
                            numberOfApplications=resultSetTwo.getRow();

                        }
                        //System.out.println(numberOfApplications);
                        JFrame pieChartJFrame= new JFrame();
                        pieChartJFrame.setPreferredSize(new Dimension(1280,768));
                        pieChartJFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                        defaultPieDataset.setValue("Broj prijavljenih učenika", numberOfApplications);
                        defaultPieDataset.setValue("Broj primljenih učenika", numberOfAcceptances);

                        ChartPanel chartPaneLforPieC=new ChartPanel(pieChart);
                        pieChartJFrame.add(chartPaneLforPieC);
                        //pieChartJFrame.setTitle("Broj prijavljenih učenika/broj primljenih učenika");
                        pieChartJFrame.pack();
                        pieChartJFrame.setVisible(true);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }

                if (sy.getSelectedItem().equals("2025/2026")) {
                    DefaultCategoryDataset categoryDataset= new DefaultCategoryDataset();
                    JFreeChart lineChart= ChartFactory.createLineChart("Statistički prikaz kroz godine", "Školske godine", "Broj upisanih učenika", categoryDataset);

                    ConnectionHandler ch = new ConnectionHandler();
                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2022/2023' AND direction='IT gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            it22=Double.valueOf(resultSet.getRow());


                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2022/2023' AND direction='Opšta gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            og22=Double.valueOf(resultSet.getRow());
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }



                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2023/2024' AND direction='IT gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            double d=resultSet.getRow();
                            it23=Double.valueOf(resultSet.getRow());



                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2023/2024' AND direction='Opšta gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            og23=Double.valueOf(resultSet.getRow());
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2024/2025' AND direction='Opšta gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            og24=Double.valueOf(resultSet.getRow());
                            System.out.println(og24);
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2024/2025' AND direction='IT gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            double d=resultSet.getRow();
                            it24=Double.valueOf(resultSet.getRow());



                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2025/2026' AND direction='Opšta gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            og25=Double.valueOf(resultSet.getRow());

                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2025/2026' AND direction='IT gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {

                            it25=Double.valueOf(resultSet.getRow());



                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }


                    categoryDataset.setValue(og21,"Opšta gimnazija", "2021/2022");
                    categoryDataset.setValue(it21,"IT gimnazija", "2021/2022");

                    categoryDataset.setValue(og22,"Opšta gimnazija", "2022/2023");
                    categoryDataset.setValue(it22,"IT gimnazija", "2022/2023");

                    categoryDataset.setValue(og23,"Opšta gimnazija", "2023/2024");

                    categoryDataset.setValue(it23,"IT gimnazija", "2023/2024");

                    categoryDataset.setValue(og24,"Opšta gimnazija", "2024/2025");

                    categoryDataset.setValue(it24,"IT gimnazija", "2024/2025");

                    categoryDataset.setValue(og25,"Opšta gimnazija", "2025/2026");

                    categoryDataset.setValue(it25,"IT gimnazija", "2025/2026");



                    JFrame jFrameTwo= new JFrame();
                    jFrameTwo.setPreferredSize(new Dimension(1280,768));
                    jFrameTwo.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    ChartPanel chartPanel= new ChartPanel(lineChart);
                    jFrameTwo.add(chartPanel);
                    jFrameTwo.pack();
                    jFrameTwo.setVisible(true);
                    try {
                        DefaultPieDataset defaultPieDataset= new DefaultPieDataset();
                        JFreeChart pieChart= ChartFactory.createPieChart3D("Broj prijavljenih i primljenih učenika", defaultPieDataset);
                        double numberOfApplications=0;
                        double numberOfAcceptances=0;
                        ConnectionHandler c= new ConnectionHandler();
                        PreparedStatement preparedSt= c.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2025/2026'");
                        ResultSet resultSet=preparedSt.executeQuery();
                        while (resultSet.next()){
                            numberOfAcceptances=resultSet.getRow();

                        }
                        //System.out.println(numberOfAcceptances);
                        PreparedStatement preparedStTwo= c.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE schoolYear='2025/2026'");
                        ResultSet resultSetTwo=preparedStTwo.executeQuery();
                        while (resultSetTwo.next()){
                            numberOfApplications=resultSetTwo.getRow();

                        }
                        //System.out.println(numberOfApplications);
                        JFrame pieChartJFrame= new JFrame();
                        pieChartJFrame.setPreferredSize(new Dimension(1280,768));
                        pieChartJFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                        defaultPieDataset.setValue("Broj prijavljenih učenika", numberOfApplications);
                        defaultPieDataset.setValue("Broj primljenih učenika", numberOfAcceptances);

                        ChartPanel chartPaneLforPieC=new ChartPanel(pieChart);
                        pieChartJFrame.add(chartPaneLforPieC);
                        //pieChartJFrame.setTitle("Broj prijavljenih učenika/broj primljenih učenika");
                        pieChartJFrame.pack();
                        pieChartJFrame.setVisible(true);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }

                if (sy.getSelectedItem().equals("2026/2027")) {
                    DefaultCategoryDataset categoryDataset= new DefaultCategoryDataset();
                    JFreeChart lineChart= ChartFactory.createLineChart("Statistički prikaz kroz godine", "Školske godine", "Broj upisanih učenika", categoryDataset);

                    ConnectionHandler ch = new ConnectionHandler();
                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2022/2023' AND direction='IT gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            it22=Double.valueOf(resultSet.getRow());


                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2022/2023' AND direction='Opšta gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            og22=Double.valueOf(resultSet.getRow());
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }



                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2023/2024' AND direction='IT gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            double d=resultSet.getRow();
                            it23=Double.valueOf(resultSet.getRow());



                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2023/2024' AND direction='Opšta gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            og23=Double.valueOf(resultSet.getRow());
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2024/2025' AND direction='Opšta gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            og24=Double.valueOf(resultSet.getRow());
                            System.out.println(og24);
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2024/2025' AND direction='IT gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            double d=resultSet.getRow();
                            it24=Double.valueOf(resultSet.getRow());



                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2025/2026' AND direction='Opšta gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            og25=Double.valueOf(resultSet.getRow());

                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2025/2026' AND direction='IT gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {

                            it25=Double.valueOf(resultSet.getRow());



                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2026/2027' AND direction='Opšta gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            og26=Double.valueOf(resultSet.getRow());

                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        PreparedStatement preparedStatement = ch.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2026/2027' AND direction='IT gimnazija'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {

                            it26=Double.valueOf(resultSet.getRow());



                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }



                    categoryDataset.setValue(og21,"Opšta gimnazija", "2021/2022");
                    categoryDataset.setValue(it21,"IT gimnazija", "2021/2022");

                    categoryDataset.setValue(og22,"Opšta gimnazija", "2022/2023");
                    categoryDataset.setValue(it22,"IT gimnazija", "2022/2023");

                    categoryDataset.setValue(og23,"Opšta gimnazija", "2023/2024");

                    categoryDataset.setValue(it23,"IT gimnazija", "2023/2024");

                    categoryDataset.setValue(og24,"Opšta gimnazija", "2024/2025");

                    categoryDataset.setValue(it24,"IT gimnazija", "2024/2025");

                    categoryDataset.setValue(og25,"Opšta gimnazija", "2025/2026");

                    categoryDataset.setValue(it25,"IT gimnazija", "2025/2026");

                    categoryDataset.setValue(og26,"Opšta gimnazija", "2026/2027");

                    categoryDataset.setValue(it26,"IT gimnazija", "2026/2027");




                    JFrame jFrameTwo= new JFrame();
                    jFrameTwo.setPreferredSize(new Dimension(1280,768));
                    jFrameTwo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    ChartPanel chartPanel= new ChartPanel(lineChart);
                    jFrameTwo.add(chartPanel);
                    jFrameTwo.pack();
                    jFrameTwo.setVisible(true);

                    try {
                        DefaultPieDataset defaultPieDataset= new DefaultPieDataset();
                        JFreeChart pieChart= ChartFactory.createPieChart3D("Broj prijavljenih i primljenih učenika", defaultPieDataset);
                        double numberOfApplications=0;
                        double numberOfAcceptances=0;
                        ConnectionHandler c= new ConnectionHandler();
                        PreparedStatement preparedSt= c.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE sum>=54 AND schoolYear='2026/2027'");
                        ResultSet resultSet=preparedSt.executeQuery();
                        while (resultSet.next()){
                            numberOfAcceptances=resultSet.getRow();

                        }
                        //System.out.println(numberOfAcceptances);
                        PreparedStatement preparedStTwo= c.getCon("jdbc:mysql://localhost:3306/datei", "root", "Arsenal2001-").prepareStatement("SELECT sum FROM info WHERE schoolYear='2026/2027'");
                        ResultSet resultSetTwo=preparedStTwo.executeQuery();
                        while (resultSetTwo.next()){
                            numberOfApplications=resultSetTwo.getRow();

                        }
                        //System.out.println(numberOfApplications);
                        JFrame pieChartJFrame= new JFrame();
                        pieChartJFrame.setPreferredSize(new Dimension(1280,768));
                        pieChartJFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                        defaultPieDataset.setValue("Broj prijavljenih učenika", numberOfApplications);
                        defaultPieDataset.setValue("Broj primljenih učenika", numberOfAcceptances);

                        ChartPanel chartPaneLforPieC=new ChartPanel(pieChart);
                        pieChartJFrame.add(chartPaneLforPieC);
                        //pieChartJFrame.setTitle("Broj prijavljenih učenika/broj primljenih učenika");
                        pieChartJFrame.pack();
                        pieChartJFrame.setVisible(true);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }

            }
        });

    ////////////////////////////////////////////////////////////////////////////


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

        backButtonPoPThree.getTheObject().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                popUpFrameThree.getTheObject().setVisible(false);
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

        newAccountLink.getTheObject().addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

                 MyFrame<JLabel> newAccountHeadline = new MyFrame<JLabel>(new JLabel("Kreirajte novi račun"));
                newAccountHeadline.getTheObject().setPreferredSize(new Dimension(200, 50));
                newAccountHeadline.getTheObject().setHorizontalAlignment(JLabel.CENTER);
                newAccountHeadline.getTheObject().setBackground(Color.DARK_GRAY);
                newAccountHeadline.getTheObject().setForeground(Color.decode("#66d9ff"));

                MyFrame<JLabel> usernameIcon = new MyFrame<JLabel>(new JLabel(new ImageIcon("src/com/company/user(1).png")));
                // <div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
                //"Icon made by Freepik from www.flaticon.com"
                usernameIcon.getTheObject().setPreferredSize(new Dimension(32, 32));
                usernameIcon.getTheObject().setBackground(Color.DARK_GRAY);
                usernameIcon.getTheObject().setForeground(Color.gray);
                usernameIcon.getTheObject().setToolTipText("Molimo unesite korisničko ime");

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

                MyFrame<JLabel> passwordIcon = new MyFrame<JLabel>(new JLabel(new ImageIcon("src/com/company/padlock(1).png")));
                //<div>Icons made by <a href="https://www.flaticon.com/authors/pixel-perfect" title="Pixel perfect">Pixel perfect</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
                //"Icon made by Pixel perfect from www.flaticon.com"
                passwordIcon.getTheObject().setPreferredSize(new Dimension(32, 32));
                passwordIcon.getTheObject().setBackground(Color.DARK_GRAY);
                passwordIcon.getTheObject().setForeground(Color.gray);
                passwordIcon.getTheObject().setToolTipText("Molimo unesite šifru");

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



                MyFrame<JButton> cancelButton= new MyFrame<JButton>(new JButton("Odustani"));
                cancelButton.getTheObject().setForeground(Color.decode("#66d9ff"));
                cancelButton.getTheObject().setPreferredSize(new Dimension(200, 50));
                cancelButton.getTheObject().setBackground(Color.darkGray);


                MyFrame<JButton> createButon = new MyFrame<JButton>(new JButton("Kreiraj račun"));
                createButon.getTheObject().setForeground(Color.decode("#66d9ff"));
                createButon.getTheObject().setPreferredSize(new Dimension(200, 50));
                createButon.getTheObject().setBackground(Color.darkGray);

                JPanel createAccJPanel= new JPanel();
                createAccJPanel.setPreferredSize(new Dimension(1280,768));
                createAccJPanel.setLayout(new GridBagLayout());
                createAccJPanel.setBackground(Color.darkGray);


                GridBagConstraints gridBagConstraintsCreate= new GridBagConstraints();





                gridBagConstraintsCreate.gridx=0;
                gridBagConstraintsCreate.gridy=0;
                gridBagConstraintsCreate.insets=new Insets(30, 0, 0,450);
                createAccJPanel.add(usernameIcon.getTheObject(), gridBagConstraintsCreate);

                gridBagConstraintsCreate.gridx=0;
                gridBagConstraintsCreate.gridy=0;
                gridBagConstraintsCreate.insets=new Insets(20, 10, 0,0);
                createAccJPanel.add(username.getTheObject(), gridBagConstraintsCreate);

                gridBagConstraintsCreate.gridx=0;
                gridBagConstraintsCreate.gridy=1;
                gridBagConstraintsCreate.insets=new Insets(30, 0, 0,450);
                createAccJPanel.add(passwordIcon.getTheObject(), gridBagConstraintsCreate);

                gridBagConstraintsCreate.gridx=0;
                gridBagConstraintsCreate.gridy=1;
                gridBagConstraintsCreate.insets=new Insets(20, 10, 0,0);
                createAccJPanel.add(password.getTheObject(), gridBagConstraintsCreate);

                gridBagConstraintsCreate.gridx=0;
                gridBagConstraintsCreate.gridy=2;
                gridBagConstraintsCreate.insets=new Insets(20, 0, 0,190);
                createAccJPanel.add(cancelButton.getTheObject(), gridBagConstraintsCreate);

                gridBagConstraintsCreate.gridx=0;
                gridBagConstraintsCreate.gridy=2;
                gridBagConstraintsCreate.insets=new Insets(20, 300, 0,0);
                createAccJPanel.add(createButon.getTheObject(), gridBagConstraintsCreate);

                JFrame createAccJFrame= new JFrame();
                createAccJFrame.setPreferredSize(new Dimension(1280,768));
                createAccJFrame.add(createAccJPanel);
                createAccJFrame.setTitle("Kreiranje novog računa");
                createAccJFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                createAccJFrame.pack();
                createAccJFrame.setVisible(true);


                createButon.getTheObject().addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        boolean ok=false;
                        boolean no=false;
                        int noAccount=0;
                        String convertPassword=String.valueOf(password.getTheObject().getPassword());

                        ConnectionHandler connectionHandlerA=new ConnectionHandler();
                        if (convertPassword.equals("") || username.getTheObject().getText().equals("")) {

                            defaultJLabelText.setText("Polja ne smiju biti prazna");
                            defaultJDialog.setVisible(true);
                            createAccJFrame.revalidate();
                            createAccJFrame.repaint();
                            return;
                        }else {
                            try {
                                PreparedStatement preparedStatement = connectionHandlerA.getCon("jdbc:mysql://localhost:3306/login", "root", "Arsenal2001-").prepareStatement("SELECT username,password FROM users");
                                ResultSet resultSet = preparedStatement.executeQuery();
                                while (resultSet.next()) {
                                    noAccount = resultSet.getRow();
                                    if (!(resultSet.getString("username").equals(username.getTheObject().getText()) && resultSet.getString("password").equals(convertPassword))) {
                                        ok = true;

                                    }
                                    if (resultSet.getString("username").equals(username.getTheObject().getText()) || resultSet.getString("password").equals(convertPassword)) {

                                        Thread thread = new Thread(new ThreadClass());
                                        thread.start();
                                        thread.interrupt();
                                        return;

                                    }


                                }

                                if (ok) {
                                    String newPsTm = "INSERT INTO users(username, password) VALUES('" + username.getTheObject().getText() + "', '" + convertPassword + "')";
                                    PreparedStatement preparedStatement1 = connectionHandlerA.getCon("jdbc:mysql://localhost:3306/login", "root", "Arsenal2001-").prepareStatement(newPsTm);
                                    preparedStatement1.executeUpdate();
                                    preparedStatement1.close();
                                    accountCreatedDialog();
                                    createAccJFrame.repaint();
                                    createAccJFrame.revalidate();
                                    createAccJFrame.setVisible(false);

                                }
                                /////////////////////////////// Provjeriti da li funkcionise
                                if (noAccount == 0 && !(username.getTheObject().getText().equals(null)||convertPassword.equals(null))) {
                                    String newPsTm = "INSERT INTO users(username, password) VALUES('" + username.getTheObject().getText() + "', '" + username.getTheObject().getText() + "')";
                                    PreparedStatement preparedStatement1 = connectionHandlerA.getCon("jdbc:mysql://localhost:3306/login", "root", "Arsenal2001-").prepareStatement(newPsTm);
                                    preparedStatement1.executeUpdate();
                                    preparedStatement1.close();
                                    accountCreatedDialog();
                                    createAccJFrame.repaint();
                                    createAccJFrame.revalidate();
                                    createAccJFrame.setVisible(false);

                                }
                                ///////////////////////////////
                                preparedStatement.close();
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
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
                    cancelButton.getTheObject().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            createAccJFrame.setVisible(false);
                        }
                    });


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

iconInfoLabel.getTheObject().addMouseListener(new MouseListener() {
    @Override
    public void mouseClicked(MouseEvent e) {
        JFrame infoFrame= new JFrame();
        infoFrame.setPreferredSize(new Dimension(1280, 768));
        infoFrame.setTitle("Informacije o aplikaciji");

        JPanel infoPanel= new JPanel();
        infoPanel.setPreferredSize(new Dimension(1280, 768));
        BoxLayout boxLayout= new BoxLayout(infoPanel, BoxLayout.Y_AXIS);
        infoPanel.setLayout(boxLayout);

        ImageIcon image= new ImageIcon("src/com/company/ventus.png");
        JLabel jInfoLabel= new JLabel(image);
        jInfoLabel.setPreferredSize(new Dimension(1280,768));
        JScrollPane jScrollPane= new JScrollPane(jInfoLabel);
        jScrollPane.setPreferredSize(new Dimension(1280,768));

        infoPanel.add(jScrollPane);




        infoFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        infoFrame.add(infoPanel);
        infoFrame.pack();
        infoFrame.setVisible(true);

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

labelIconFour.getTheObject().addMouseListener(new MouseListener() {
    @Override
    public void mouseClicked(MouseEvent e) {
        //obj.getTheObject().dispose();
        System.exit(0);
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






    public static void accountCreatedDialog(){
        JDialog defaultJDialogOk= new JDialog();
        defaultJDialogOk.setPreferredSize(new Dimension(600,400));
        defaultJDialogOk.setTitle("Korisnik kreiran");
        JPanel defaultJPanelOk= new JPanel();
        defaultJPanelOk.setPreferredSize(new Dimension(600,400));
        defaultJPanelOk.setBackground(Color.darkGray);
        defaultJPanelOk.setLayout(new GridBagLayout());
        ImageIcon warningIconOk= new ImageIcon("src/com/company/checked.png");
        JLabel defaultJLabelOk=new JLabel(warningIconOk);
        JLabel defaultJLabelTextOk= new JLabel("Korisnik je uspješno kreiran, želimo Vam ugodno korištenje");
        defaultJLabelTextOk.setForeground(Color.white);

        GridBagConstraints constraintsOk= new GridBagConstraints();

        constraintsOk.gridx=0;
        constraintsOk.gridy=0;
        constraintsOk.insets= new Insets(0, 0, 20, 0);
        defaultJPanelOk.add(defaultJLabelOk, constraintsOk);
        constraintsOk.gridx=0;
        constraintsOk.gridy=1;
        defaultJPanelOk.add(defaultJLabelTextOk, constraintsOk);
        defaultJDialogOk.add(defaultJPanelOk);
        defaultJDialogOk.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        defaultJDialogOk.pack();
        defaultJDialogOk.setVisible(true);


    }
    public static void saveTable(JTable jTable,JFrame RsFrame){
        Workbook workbook=new XSSFWorkbook();
        Sheet sheet= workbook.createSheet("Resultati");




        File file= new File("c:\\");
        JFileChooser fileChooser= new JFileChooser();
        //fileChooser.setCurrentDirectory(file);






        //FileOutputStream fileOutputStream= new FileOutputStream(file);
        for (int i=0; i<jTable.getRowCount();i++){



            Row row= sheet.createRow(i);
            for (int j=0;j<jTable.getColumnCount();j++){
                Cell cell= row.createCell(j);
                cell.setCellValue(jTable.getValueAt(i,j).toString());




            }
        }
        int returnValue=fileChooser.showSaveDialog(RsFrame);

        if (returnValue==JFileChooser.APPROVE_OPTION){

            File file1=new File(fileChooser.getSelectedFile().getAbsolutePath());


            try {
                workbook.write(new FileOutputStream(file1));
                workbook.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


    }




}

