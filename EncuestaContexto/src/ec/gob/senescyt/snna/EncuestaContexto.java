/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senescyt.snna;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Text;

/**
 *
 * @author jchalan
 */
public class EncuestaContexto extends javax.swing.JFrame {
  
    HashMap<String,Component> componentesSeccionUno = new HashMap<>();
    HashMap<String,Component> componentesSeccionDos = new HashMap<>();
    HashMap<String,Component> componentesSeccionTres = new HashMap<>();
    HashMap<String,Component> componentesSeccionCuatro = new HashMap<>();
    HashMap<String,Component> componentesSeccionCinco = new HashMap<>();
    HashMap<String,Component> componentesSeccionSeis = new HashMap<>();
    HashMap<String,Component> allComponents = new HashMap<>();
    String ruta = "";
    String fileConfig = "config";
    Integer index = 0;
    /**
     * Creates new form Encuesta
     */
    public EncuestaContexto() {
        initComponents();
        this.setLocationRelativeTo(null);
        /* -------- Seccion 1 ---------- */
        initSeccionUno();
        /*--------Lee todos los componentes de todas las secciones-------------------------*/
        componentesSeccionUno = obtenerComponentesPorPanel(jPanelSec_1);
        componentesSeccionDos = obtenerComponentesPorPanel(jPanelSec_2);
        componentesSeccionTres = obtenerComponentesPorPanel(jPanelSec_3);
        componentesSeccionCuatro = obtenerComponentesPorPanel(jPanelSec_4);
        componentesSeccionCinco = obtenerComponentesPorPanel(jPanelSec_5);
        componentesSeccionSeis = obtenerComponentesPorPanel(jPanelSec_6);
        /*---------Uno todos los componentes de todas las secciones------------------------*/
        allComponents.putAll(componentesSeccionUno);
        allComponents.putAll(componentesSeccionDos);
        allComponents.putAll(componentesSeccionTres);
        allComponents.putAll(componentesSeccionCuatro);
        allComponents.putAll(componentesSeccionCinco);
        allComponents.putAll(componentesSeccionSeis);
        /*-----Carga respuestas almacenadas----------*/
        cargarXml();
        //seguridadPanel();
    }
    /**
     * 
     */
    private void seguridadPanel(){
        login panelLogin = new login();
        //JPanel panelLogin = new JPanel();
        //panelLogin.setBounds(130, 200, 400, 200);
        panelLogin.setSize(400, 200);
        //panelLogin.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        //JLabel texto = new JLabel("xxxxxxxxxxxxxx");
        //panelLogin.add(texto, BorderLayout.CENTER);
        jTabbedPane1.setVisible(false);
        jButton_Atras.setVisible(false);
        jButton_Sigueinte.setVisible(false);
        add(panelLogin, BorderLayout.CENTER);
        //this.pack();
        setSize(400, 250);
    }
    
    /**
     * 
     */
    private void bloqueaPestanias(){
        int inicio = index+1;
        int fin = jTabbedPane1.getTabCount()-1;
        for(int i=inicio;i<=fin;i++){
            jTabbedPane1.setEnabledAt(i,false);
        }
    }
    /**
     * 
     */
    @Override
    public Image getIconImage() {
        Image icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("ec/gob/senescyt/snna/resources/bender.png"));
        return icon;
    }
    
    /**
     * 
     */
    private void initSeccionUno(){
        bgSec1_101.add(rad_1010);
        bgSec1_101.add(rad_1011);
        
        bgSec1_103.add(rad_1020);
        bgSec1_103.add(rad_1021);
        
        bgSec1_105.add(rad_1030);
        bgSec1_105.add(rad_1031);
        bgSec1_105.add(rad_1032);
        bgSec1_105.add(rad_1033);
        
        bgSec1_107.add(rad_1035);
        bgSec1_107.add(rad_1036);
        bgSec1_107.add(rad_1037);
        bgSec1_107.add(rad_1038);
        bgSec1_107.add(rad_1039);
        bgSec1_107.add(rad_1040);
        bgSec1_107.add(rad_1041);
        
        bgSec1_108.add(rad_1042);
        bgSec1_108.add(rad_1043);
        
        bgSec1_110.add(rad_1045);
        bgSec1_110.add(rad_1046);
        bgSec1_110.add(rad_1047);
        bgSec1_110.add(rad_1048);
        bgSec1_110.add(rad_1049);
        bgSec1_110.add(rad_1050);
        bgSec1_110.add(rad_1051);
        bgSec1_110.add(rad_1052);
        
        bgSec1_111.add(rad_1053);
        bgSec1_111.add(rad_1054);
        bgSec1_111.add(rad_1055);
        bgSec1_111.add(rad_1056);
        bgSec1_111.add(rad_1057);
        bgSec1_111.add(rad_1058);
        bgSec1_111.add(rad_1059);
        bgSec1_111.add(rad_1060);
        bgSec1_111.add(rad_1061);
        bgSec1_111.add(rad_1062);
        bgSec1_111.add(rad_1063);
        bgSec1_111.add(rad_1064);
        bgSec1_111.add(rad_1065);
        bgSec1_111.add(rad_1066);
        bgSec1_111.add(rad_1067);
        bgSec1_111.add(rad_1068);
        bgSec1_111.add(rad_1069);
        bgSec1_111.add(rad_1070);
        bgSec1_111.add(rad_1071);
        bgSec1_111.add(rad_1072);
        bgSec1_111.add(rad_1073);
        bgSec1_111.add(rad_1074);
        bgSec1_111.add(rad_1075);
        bgSec1_111.add(rad_1076);
        bgSec1_111.add(rad_1077);
        bgSec1_111.add(rad_1078);
        bgSec1_111.add(rad_1079);
        bgSec1_111.add(rad_1080);
        
        bgSec1_112.add(rad_1081);
        bgSec1_112.add(rad_1082);
        bgSec1_112.add(rad_1083);
        bgSec1_112.add(rad_1084);
        bgSec1_112.add(rad_1085);
        bgSec1_112.add(rad_1086);
        bgSec1_112.add(rad_1087);
        bgSec1_112.add(rad_1088);
        
        bgSec1_113.add(rad_1089);
        bgSec1_113.add(rad_1090);
        bgSec1_113.add(rad_1091);
        bgSec1_113.add(rad_1092);
        bgSec1_113.add(rad_1093);
        bgSec1_113.add(rad_1094);
        bgSec1_113.add(rad_1095);
        bgSec1_113.add(rad_1096);
        bgSec1_113.add(rad_1097);
        bgSec1_113.add(rad_1098);
        bgSec1_113.add(rad_1099);
        bgSec1_113.add(rad_1100);
        bgSec1_113.add(rad_1101);
        bgSec1_113.add(rad_1102);
        bgSec1_113.add(rad_1103);
        bgSec1_113.add(rad_1104);
        bgSec1_113.add(rad_1105);
        bgSec1_113.add(rad_1106);
        bgSec1_113.add(rad_1107);
        bgSec1_113.add(rad_1108);
        bgSec1_113.add(rad_1109);
        bgSec1_113.add(rad_1110);
        bgSec1_113.add(rad_1111);
        bgSec1_113.add(rad_1112);
        bgSec1_113.add(rad_1113);
        bgSec1_113.add(rad_1114);
        bgSec1_113.add(rad_1115);
        bgSec1_113.add(rad_1116);
        
        bgSec1_114.add(rad_1117);
        bgSec1_114.add(rad_1118);
        bgSec1_114.add(rad_1119);
        bgSec1_114.add(rad_1120);
        
        bgSec1_115.add(rad_1121);
        bgSec1_115.add(rad_1122);
        bgSec1_115.add(rad_1123);
        bgSec1_115.add(rad_1124);

        jPanel_102.setVisible(false);
        jPanel_104.setVisible(false);
        jPanel_105.setVisible(false);
        jPanel_106.setVisible(false);
        jPanel_107.setVisible(false);
        jPanel_108.setVisible(false);
        jPanel_109.setVisible(false);
        jPanel_111.setVisible(false);
        jPanel_113.setVisible(false);
        jPanel_114.setVisible(false);
        jPanel_115.setVisible(false);
        
        jLabel_100.setVisible(false);

    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgSec1_101 = new javax.swing.ButtonGroup();
        bgSec1_103 = new javax.swing.ButtonGroup();
        bgSec1_105 = new javax.swing.ButtonGroup();
        bgSec1_107 = new javax.swing.ButtonGroup();
        bgSec1_108 = new javax.swing.ButtonGroup();
        bgSec1_110 = new javax.swing.ButtonGroup();
        bgSec1_111 = new javax.swing.ButtonGroup();
        bgSec1_112 = new javax.swing.ButtonGroup();
        bgSec1_113 = new javax.swing.ButtonGroup();
        bgSec1_114 = new javax.swing.ButtonGroup();
        bgSec1_115 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelSec_1 = new javax.swing.JPanel();
        jPanel_100 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        chk_1000 = new javax.swing.JCheckBox();
        chk_1001 = new javax.swing.JCheckBox();
        chk_1002 = new javax.swing.JCheckBox();
        chk_1003 = new javax.swing.JCheckBox();
        chk_1004 = new javax.swing.JCheckBox();
        chk_1005 = new javax.swing.JCheckBox();
        chk_1006 = new javax.swing.JCheckBox();
        chk_1007 = new javax.swing.JCheckBox();
        chk_1008 = new javax.swing.JCheckBox();
        chk_1009 = new javax.swing.JCheckBox();
        jPanel_101 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        rad_1010 = new javax.swing.JRadioButton();
        rad_1011 = new javax.swing.JRadioButton();
        jPanel_102 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        chk_1012 = new javax.swing.JCheckBox();
        chk_1013 = new javax.swing.JCheckBox();
        chk_1014 = new javax.swing.JCheckBox();
        chk_1015 = new javax.swing.JCheckBox();
        chk_1016 = new javax.swing.JCheckBox();
        chk_1017 = new javax.swing.JCheckBox();
        chk_1018 = new javax.swing.JCheckBox();
        chk_1019 = new javax.swing.JCheckBox();
        jPanel_103 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        rad_1020 = new javax.swing.JRadioButton();
        rad_1021 = new javax.swing.JRadioButton();
        jPanel_104 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        chk_1022 = new javax.swing.JCheckBox();
        chk_1023 = new javax.swing.JCheckBox();
        chk_1024 = new javax.swing.JCheckBox();
        chk_1025 = new javax.swing.JCheckBox();
        chk_1026 = new javax.swing.JCheckBox();
        chk_1027 = new javax.swing.JCheckBox();
        chk_1028 = new javax.swing.JCheckBox();
        chk_1029 = new javax.swing.JCheckBox();
        jPanel_105 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        rad_1030 = new javax.swing.JRadioButton();
        rad_1031 = new javax.swing.JRadioButton();
        rad_1032 = new javax.swing.JRadioButton();
        rad_1033 = new javax.swing.JRadioButton();
        jPanel_106 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txt_1034 = new javax.swing.JTextField();
        jPanel_107 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        rad_1035 = new javax.swing.JRadioButton();
        rad_1036 = new javax.swing.JRadioButton();
        rad_1037 = new javax.swing.JRadioButton();
        rad_1038 = new javax.swing.JRadioButton();
        rad_1039 = new javax.swing.JRadioButton();
        rad_1040 = new javax.swing.JRadioButton();
        rad_1041 = new javax.swing.JRadioButton();
        jPanel_108 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        rad_1042 = new javax.swing.JRadioButton();
        rad_1043 = new javax.swing.JRadioButton();
        jPanel_109 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_1044 = new javax.swing.JTextField();
        jPanel_110 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        rad_1045 = new javax.swing.JRadioButton();
        rad_1046 = new javax.swing.JRadioButton();
        rad_1047 = new javax.swing.JRadioButton();
        rad_1048 = new javax.swing.JRadioButton();
        rad_1049 = new javax.swing.JRadioButton();
        rad_1050 = new javax.swing.JRadioButton();
        rad_1051 = new javax.swing.JRadioButton();
        rad_1052 = new javax.swing.JRadioButton();
        jPanel_111 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        rad_1053 = new javax.swing.JRadioButton();
        rad_1054 = new javax.swing.JRadioButton();
        rad_1055 = new javax.swing.JRadioButton();
        rad_1056 = new javax.swing.JRadioButton();
        rad_1057 = new javax.swing.JRadioButton();
        rad_1058 = new javax.swing.JRadioButton();
        rad_1059 = new javax.swing.JRadioButton();
        rad_1060 = new javax.swing.JRadioButton();
        rad_1061 = new javax.swing.JRadioButton();
        rad_1062 = new javax.swing.JRadioButton();
        rad_1063 = new javax.swing.JRadioButton();
        rad_1064 = new javax.swing.JRadioButton();
        rad_1065 = new javax.swing.JRadioButton();
        rad_1066 = new javax.swing.JRadioButton();
        rad_1067 = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        rad_1068 = new javax.swing.JRadioButton();
        rad_1069 = new javax.swing.JRadioButton();
        rad_1070 = new javax.swing.JRadioButton();
        rad_1071 = new javax.swing.JRadioButton();
        rad_1072 = new javax.swing.JRadioButton();
        rad_1073 = new javax.swing.JRadioButton();
        rad_1074 = new javax.swing.JRadioButton();
        rad_1075 = new javax.swing.JRadioButton();
        rad_1076 = new javax.swing.JRadioButton();
        rad_1077 = new javax.swing.JRadioButton();
        rad_1078 = new javax.swing.JRadioButton();
        rad_1079 = new javax.swing.JRadioButton();
        rad_1080 = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel_112 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        rad_1081 = new javax.swing.JRadioButton();
        rad_1082 = new javax.swing.JRadioButton();
        rad_1083 = new javax.swing.JRadioButton();
        rad_1084 = new javax.swing.JRadioButton();
        rad_1085 = new javax.swing.JRadioButton();
        rad_1086 = new javax.swing.JRadioButton();
        rad_1087 = new javax.swing.JRadioButton();
        rad_1088 = new javax.swing.JRadioButton();
        jPanel_113 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        rad_1103 = new javax.swing.JRadioButton();
        rad_1102 = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        rad_1101 = new javax.swing.JRadioButton();
        rad_1115 = new javax.swing.JRadioButton();
        rad_1114 = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        rad_1116 = new javax.swing.JRadioButton();
        rad_1095 = new javax.swing.JRadioButton();
        rad_1096 = new javax.swing.JRadioButton();
        rad_1099 = new javax.swing.JRadioButton();
        rad_1100 = new javax.swing.JRadioButton();
        rad_1097 = new javax.swing.JRadioButton();
        rad_1098 = new javax.swing.JRadioButton();
        rad_1112 = new javax.swing.JRadioButton();
        rad_1111 = new javax.swing.JRadioButton();
        rad_1094 = new javax.swing.JRadioButton();
        rad_1113 = new javax.swing.JRadioButton();
        rad_1091 = new javax.swing.JRadioButton();
        rad_1090 = new javax.swing.JRadioButton();
        rad_1093 = new javax.swing.JRadioButton();
        rad_1092 = new javax.swing.JRadioButton();
        rad_1104 = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        rad_1105 = new javax.swing.JRadioButton();
        rad_1089 = new javax.swing.JRadioButton();
        rad_1106 = new javax.swing.JRadioButton();
        rad_1107 = new javax.swing.JRadioButton();
        rad_1108 = new javax.swing.JRadioButton();
        rad_1109 = new javax.swing.JRadioButton();
        rad_1110 = new javax.swing.JRadioButton();
        jPanel_114 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        rad_1117 = new javax.swing.JRadioButton();
        rad_1118 = new javax.swing.JRadioButton();
        rad_1119 = new javax.swing.JRadioButton();
        rad_1120 = new javax.swing.JRadioButton();
        jPanel_115 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        rad_1121 = new javax.swing.JRadioButton();
        rad_1122 = new javax.swing.JRadioButton();
        rad_1123 = new javax.swing.JRadioButton();
        rad_1124 = new javax.swing.JRadioButton();
        jLabel_100 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanelSec_2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanelSec_3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanelSec_4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanelSec_5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanelSec_6 = new javax.swing.JPanel();
        jButton_Sigueinte = new javax.swing.JButton();
        jButton_Atras = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txt_nombres = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txt_apellidos = new javax.swing.JTextField();
        jButton_activarEncuesta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Prototipo encuesta");
        setIconImage(getIconImage());
        setLocationByPlatform(true);
        setResizable(false);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTabbedPane1MousePressed(evt);
            }
        });
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jScrollPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jScrollPane1FocusLost(evt);
            }
        });

        jPanel_100.setName("100"); // NOI18N

        jLabel1.setText("1.1 ¿Con quién vives?");
        jLabel1.setName("1"); // NOI18N

        chk_1000.setText("Solo");
        chk_1000.setName("1000"); // NOI18N
        chk_1000.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_1000ActionPerformed(evt);
            }
        });

        chk_1001.setText("Padre");
        chk_1001.setName("1001"); // NOI18N
        chk_1001.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_1001ActionPerformed(evt);
            }
        });

        chk_1002.setText("Madre");
        chk_1002.setName("1002"); // NOI18N
        chk_1002.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_1002ActionPerformed(evt);
            }
        });

        chk_1003.setText("Hermanas/os");
        chk_1003.setName("1003"); // NOI18N
        chk_1003.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_1003ActionPerformed(evt);
            }
        });

        chk_1004.setText("Abuelas/os");
        chk_1004.setName("1004"); // NOI18N
        chk_1004.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_1004ActionPerformed(evt);
            }
        });

        chk_1005.setText("Hija/o");
        chk_1005.setName("1005"); // NOI18N
        chk_1005.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_1005ActionPerformed(evt);
            }
        });

        chk_1006.setText("Cónyuge o conviviente");
        chk_1006.setName("1006"); // NOI18N
        chk_1006.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_1006ActionPerformed(evt);
            }
        });

        chk_1007.setText("Amiga/o");
        chk_1007.setName("1007"); // NOI18N
        chk_1007.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_1007ActionPerformed(evt);
            }
        });

        chk_1008.setText("Otros");
        chk_1008.setName("1008"); // NOI18N
        chk_1008.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_1008ActionPerformed(evt);
            }
        });

        chk_1009.setText("Me encuentro en situación de privación de libertad");
        chk_1009.setName("1009"); // NOI18N

        javax.swing.GroupLayout jPanel_100Layout = new javax.swing.GroupLayout(jPanel_100);
        jPanel_100.setLayout(jPanel_100Layout);
        jPanel_100Layout.setHorizontalGroup(
            jPanel_100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_100Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel_100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chk_1009)
                    .addComponent(chk_1008)
                    .addComponent(chk_1007)
                    .addComponent(chk_1006)
                    .addComponent(chk_1005)
                    .addComponent(chk_1004)
                    .addComponent(chk_1003)
                    .addComponent(chk_1002)
                    .addComponent(chk_1001)
                    .addComponent(chk_1000)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_100Layout.setVerticalGroup(
            jPanel_100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_100Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1000)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1001)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1002)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1003)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1004)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1005)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1006)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1007)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1008)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1009)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("1.- ¿Con quién vives?");

        jPanel_101.setName("101"); // NOI18N

        jLabel2.setText("1.2 ¿Alguien en tu familia tiene discapacidad?");
        jLabel2.setName("1"); // NOI18N

        rad_1010.setText("Sí");
        rad_1010.setName("1010"); // NOI18N
        rad_1010.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1010ActionPerformed(evt);
            }
        });

        rad_1011.setText("No");
        rad_1011.setName("1011"); // NOI18N
        rad_1011.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1011ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_101Layout = new javax.swing.GroupLayout(jPanel_101);
        jPanel_101.setLayout(jPanel_101Layout);
        jPanel_101Layout.setHorizontalGroup(
            jPanel_101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_101Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel_101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rad_1011)
                    .addComponent(rad_1010)
                    .addComponent(jLabel2))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel_101Layout.setVerticalGroup(
            jPanel_101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_101Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1010)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1011)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_102.setName("102"); // NOI18N

        jLabel3.setText("1.3 ¿Qué miembro de tu familia tiene discapacidad?");
        jLabel3.setName("1"); // NOI18N

        chk_1012.setText("Yo");
        chk_1012.setName("1012"); // NOI18N

        chk_1013.setText("Padre");
        chk_1013.setName("1013"); // NOI18N

        chk_1014.setText("Madre");
        chk_1014.setName("1014"); // NOI18N

        chk_1015.setText("Hermanas/os");
        chk_1015.setName("1015"); // NOI18N

        chk_1016.setText("Abuelas/os");
        chk_1016.setName("1016"); // NOI18N

        chk_1017.setText("Hija/o");
        chk_1017.setName("1017"); // NOI18N

        chk_1018.setText("Cónyuge o conviviente");
        chk_1018.setName("1018"); // NOI18N

        chk_1019.setText("Otro");
        chk_1019.setName("1019"); // NOI18N

        javax.swing.GroupLayout jPanel_102Layout = new javax.swing.GroupLayout(jPanel_102);
        jPanel_102.setLayout(jPanel_102Layout);
        jPanel_102Layout.setHorizontalGroup(
            jPanel_102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_102Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel_102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chk_1019)
                    .addComponent(chk_1018)
                    .addComponent(chk_1017)
                    .addComponent(chk_1016)
                    .addComponent(chk_1015)
                    .addComponent(chk_1014)
                    .addComponent(chk_1013)
                    .addComponent(chk_1012)
                    .addComponent(jLabel3))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel_102Layout.setVerticalGroup(
            jPanel_102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_102Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1012)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1013)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1014)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1015)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1016)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1017)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1018)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1019)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_103.setName("103"); // NOI18N

        jLabel4.setText("<html>1.4 ¿Algún miembro de tu familia, incluyéndote a ti, <br/><tab />ha estado en situación de movilidad humana (migración, retorno, refugio)?</html>");
        jLabel4.setName("1"); // NOI18N

        rad_1020.setText("Sí");
        rad_1020.setName("1020"); // NOI18N
        rad_1020.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1020ActionPerformed(evt);
            }
        });

        rad_1021.setText("No");
        rad_1021.setName("1021"); // NOI18N
        rad_1021.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1021ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_103Layout = new javax.swing.GroupLayout(jPanel_103);
        jPanel_103.setLayout(jPanel_103Layout);
        jPanel_103Layout.setHorizontalGroup(
            jPanel_103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_103Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel_103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rad_1020)
                    .addComponent(rad_1021)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_103Layout.setVerticalGroup(
            jPanel_103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_103Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1020)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1021)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_104.setName("104"); // NOI18N

        jLabel5.setText("<html>1.5 ¿Qué miembro de tu familia está en situación de movilidad humana ?</html>\n");
        jLabel5.setName("1"); // NOI18N

        chk_1022.setText("Yo");
        chk_1022.setName("1022"); // NOI18N

        chk_1023.setText("Padre");
        chk_1023.setName("1023"); // NOI18N

        chk_1024.setText("Madre");
        chk_1024.setName("1024"); // NOI18N

        chk_1025.setText("Hermanas/os");
        chk_1025.setName("1025"); // NOI18N
        chk_1025.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_1025ActionPerformed(evt);
            }
        });

        chk_1026.setText("Abuelas/os");
        chk_1026.setName("1026"); // NOI18N

        chk_1027.setText("Hija/o");
        chk_1027.setName("1027"); // NOI18N

        chk_1028.setText("Cónyuge o conviviente");
        chk_1028.setName("1028"); // NOI18N

        chk_1029.setText("Otro");
        chk_1029.setName("1029"); // NOI18N

        javax.swing.GroupLayout jPanel_104Layout = new javax.swing.GroupLayout(jPanel_104);
        jPanel_104.setLayout(jPanel_104Layout);
        jPanel_104Layout.setHorizontalGroup(
            jPanel_104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_104Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel_104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chk_1029)
                    .addComponent(chk_1028)
                    .addComponent(chk_1027)
                    .addComponent(chk_1026)
                    .addComponent(chk_1025)
                    .addComponent(chk_1024)
                    .addComponent(chk_1023)
                    .addComponent(chk_1022)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel_104Layout.setVerticalGroup(
            jPanel_104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_104Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1022)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1023)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1024)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1025)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1026)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1027)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1028)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_1029)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_105.setName("105"); // NOI18N

        jLabel6.setText("1.6 ¿Qué tipo de movilidad?\n");
        jLabel6.setName("1"); // NOI18N

        rad_1030.setText("Migrante Interno");
        rad_1030.setName("1030"); // NOI18N
        rad_1030.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1030ActionPerformed(evt);
            }
        });

        rad_1031.setText("Migrante Internacional ");
        rad_1031.setName("1031"); // NOI18N
        rad_1031.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1031ActionPerformed(evt);
            }
        });

        rad_1032.setText("Migrante Retornado");
        rad_1032.setName("1032"); // NOI18N
        rad_1032.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1032ActionPerformed(evt);
            }
        });

        rad_1033.setText("Refugiado");
        rad_1033.setName("1033"); // NOI18N
        rad_1033.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1033ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_105Layout = new javax.swing.GroupLayout(jPanel_105);
        jPanel_105.setLayout(jPanel_105Layout);
        jPanel_105Layout.setHorizontalGroup(
            jPanel_105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_105Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel_105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rad_1033)
                    .addComponent(rad_1032)
                    .addComponent(rad_1031)
                    .addComponent(rad_1030)
                    .addComponent(jLabel6))
                .addContainerGap(229, Short.MAX_VALUE))
        );
        jPanel_105Layout.setVerticalGroup(
            jPanel_105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_105Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1030)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1031)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1032)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1033)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_106.setName("106"); // NOI18N

        jLabel7.setText("1.7 ¿A que país realizó la migración? \n");
        jLabel7.setName("1"); // NOI18N

        txt_1034.setName("1034"); // NOI18N

        javax.swing.GroupLayout jPanel_106Layout = new javax.swing.GroupLayout(jPanel_106);
        jPanel_106.setLayout(jPanel_106Layout);
        jPanel_106Layout.setHorizontalGroup(
            jPanel_106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_106Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel_106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_1034))
                .addContainerGap(191, Short.MAX_VALUE))
        );
        jPanel_106Layout.setVerticalGroup(
            jPanel_106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_106Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_1034, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_107.setName("107"); // NOI18N

        jLabel8.setText("1.8 ¿Cuál fue el motivo principal ?\n");
        jLabel8.setName("1"); // NOI18N

        rad_1035.setText("Trabajo");
        rad_1035.setName("1035"); // NOI18N

        rad_1036.setText("Estudios");
        rad_1036.setName("1036"); // NOI18N

        rad_1037.setText("Negocios");
        rad_1037.setName("1037"); // NOI18N

        rad_1038.setText("Reagrupación Familiar");
        rad_1038.setName("1038"); // NOI18N

        rad_1039.setText("Conflictos sociales");
        rad_1039.setName("1039"); // NOI18N

        rad_1040.setText("Desastres naturales");
        rad_1040.setName("1040"); // NOI18N

        rad_1041.setText("Persecución política");
        rad_1041.setName("1041"); // NOI18N

        javax.swing.GroupLayout jPanel_107Layout = new javax.swing.GroupLayout(jPanel_107);
        jPanel_107.setLayout(jPanel_107Layout);
        jPanel_107Layout.setHorizontalGroup(
            jPanel_107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_107Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rad_1041)
                    .addComponent(rad_1040)
                    .addComponent(rad_1039)
                    .addComponent(rad_1038)
                    .addComponent(rad_1037)
                    .addComponent(rad_1036)
                    .addComponent(rad_1035)
                    .addComponent(jLabel8))
                .addContainerGap(211, Short.MAX_VALUE))
        );
        jPanel_107Layout.setVerticalGroup(
            jPanel_107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_107Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1035)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1036)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1037)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1038)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_1039)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1040)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1041)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_108.setName("108"); // NOI18N

        jLabel9.setText("1.9 ¿Recibes algún beneficio económico de esta persona?\n");
        jLabel9.setName("1"); // NOI18N

        rad_1042.setText("Sí");
        rad_1042.setName("1042"); // NOI18N
        rad_1042.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1042ActionPerformed(evt);
            }
        });

        rad_1043.setText("No");
        rad_1043.setName("1043"); // NOI18N
        rad_1043.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1043ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_108Layout = new javax.swing.GroupLayout(jPanel_108);
        jPanel_108.setLayout(jPanel_108Layout);
        jPanel_108Layout.setHorizontalGroup(
            jPanel_108Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_108Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_108Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rad_1043)
                    .addComponent(rad_1042)
                    .addComponent(jLabel9))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel_108Layout.setVerticalGroup(
            jPanel_108Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_108Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1042)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1043)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_109.setName("109"); // NOI18N

        jLabel10.setText("1.10 ¿Cuánto dinero en promedio recibes mensualmente de esta persona?\n");
        jLabel10.setName("1"); // NOI18N

        txt_1044.setName("1044"); // NOI18N

        javax.swing.GroupLayout jPanel_109Layout = new javax.swing.GroupLayout(jPanel_109);
        jPanel_109.setLayout(jPanel_109Layout);
        jPanel_109Layout.setHorizontalGroup(
            jPanel_109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_109Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txt_1044, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel_109Layout.setVerticalGroup(
            jPanel_109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_109Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_1044, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_110.setName("110"); // NOI18N

        jLabel11.setText("1.11 ¿Cómo se identifica tu padre según su cultura y costumbres? \n");
        jLabel11.setName("1"); // NOI18N

        rad_1045.setText("Indígena");
        rad_1045.setName("1045"); // NOI18N
        rad_1045.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1045ActionPerformed(evt);
            }
        });

        rad_1046.setText("Mestizo");
        rad_1046.setName("1046"); // NOI18N
        rad_1046.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1046ActionPerformed(evt);
            }
        });

        rad_1047.setText("Afroecuatoriano/afrodescendiente");
        rad_1047.setName("1047"); // NOI18N
        rad_1047.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1047ActionPerformed(evt);
            }
        });

        rad_1048.setText("Negro");
        rad_1048.setName("1048"); // NOI18N
        rad_1048.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1048ActionPerformed(evt);
            }
        });

        rad_1049.setText("Mulato");
        rad_1049.setName("1049"); // NOI18N
        rad_1049.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1049ActionPerformed(evt);
            }
        });

        rad_1050.setText("Montuvio");
        rad_1050.setName("1050"); // NOI18N
        rad_1050.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1050ActionPerformed(evt);
            }
        });

        rad_1051.setText("Blanco");
        rad_1051.setName("1051"); // NOI18N
        rad_1051.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1051ActionPerformed(evt);
            }
        });

        rad_1052.setText("No conozco a mi padre");
        rad_1052.setName("1052"); // NOI18N
        rad_1052.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1052ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_110Layout = new javax.swing.GroupLayout(jPanel_110);
        jPanel_110.setLayout(jPanel_110Layout);
        jPanel_110Layout.setHorizontalGroup(
            jPanel_110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_110Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rad_1052)
                    .addComponent(rad_1051)
                    .addComponent(rad_1050)
                    .addComponent(rad_1049)
                    .addComponent(rad_1048)
                    .addComponent(rad_1047)
                    .addComponent(rad_1046)
                    .addComponent(rad_1045)
                    .addComponent(jLabel11))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel_110Layout.setVerticalGroup(
            jPanel_110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_110Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1045)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1046)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1047)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1048)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1049)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rad_1050)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1051)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1052)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_111.setName("111"); // NOI18N

        jLabel12.setText("1.12 ¿A cuál pueblo o nacionalidad pertenece?\n");
        jLabel12.setName("1"); // NOI18N

        rad_1053.setText("Awa");
        rad_1053.setName("1053"); // NOI18N

        rad_1054.setText("Achuar");
        rad_1054.setName("1054"); // NOI18N

        rad_1055.setText("Chachi");
        rad_1055.setName("1055"); // NOI18N

        rad_1056.setText("Cofan");
        rad_1056.setName("1056"); // NOI18N

        rad_1057.setText("Epera");
        rad_1057.setName("1057"); // NOI18N

        rad_1058.setText("Siona");
        rad_1058.setName("1058"); // NOI18N

        rad_1059.setText("Secoya");
        rad_1059.setName("1059"); // NOI18N

        rad_1060.setText("Shiwiar");
        rad_1060.setName("1060"); // NOI18N

        rad_1061.setText("Shuar");
        rad_1061.setName("1061"); // NOI18N

        rad_1062.setText("Tsachila");
        rad_1062.setName("1062"); // NOI18N

        rad_1063.setText("Waorani");
        rad_1063.setName("1063"); // NOI18N

        rad_1064.setText("Zapara");
        rad_1064.setName("1064"); // NOI18N

        rad_1065.setText("Andoa");
        rad_1065.setName("1065"); // NOI18N

        rad_1066.setText("Kichwa amazonia");
        rad_1066.setName("1066"); // NOI18N

        rad_1067.setText("Kichwa de la sierra");
        rad_1067.setName("1067"); // NOI18N

        jLabel13.setText("Pueblos");

        rad_1068.setText("Pastos");
        rad_1068.setName("1068"); // NOI18N

        rad_1069.setText("Natabuela");
        rad_1069.setName("1069"); // NOI18N

        rad_1070.setText("Otavalo");
        rad_1070.setName("1070"); // NOI18N

        rad_1071.setText("Karanki");
        rad_1071.setName("1071"); // NOI18N

        rad_1072.setText("Kayambi");
        rad_1072.setName("1072"); // NOI18N

        rad_1073.setText("Kitukara");
        rad_1073.setName("1073"); // NOI18N

        rad_1074.setText("Panzaleo");
        rad_1074.setName("1074"); // NOI18N

        rad_1075.setText("Chibuleo");
        rad_1075.setName("1075"); // NOI18N

        rad_1076.setText("Salasaka");
        rad_1076.setName("1076"); // NOI18N

        rad_1077.setText("Kisapincha");
        rad_1077.setName("1077"); // NOI18N

        rad_1078.setText("Tomabela");
        rad_1078.setName("1078"); // NOI18N

        rad_1079.setText("Waranka");
        rad_1079.setName("1079"); // NOI18N

        rad_1080.setText("Puruhá");
        rad_1080.setName("1080"); // NOI18N

        jLabel14.setText("Nacionalidades ");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel_111Layout = new javax.swing.GroupLayout(jPanel_111);
        jPanel_111.setLayout(jPanel_111Layout);
        jPanel_111Layout.setHorizontalGroup(
            jPanel_111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_111Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_111Layout.createSequentialGroup()
                        .addGroup(jPanel_111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_1066)
                            .addComponent(rad_1053)
                            .addComponent(rad_1055)
                            .addComponent(rad_1056)
                            .addComponent(rad_1057)
                            .addComponent(rad_1058)
                            .addComponent(rad_1059)
                            .addComponent(rad_1060)
                            .addComponent(rad_1061)
                            .addComponent(rad_1062)
                            .addComponent(rad_1063)
                            .addComponent(rad_1064)
                            .addComponent(rad_1065)
                            .addComponent(rad_1067)
                            .addGroup(jPanel_111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel13)
                                .addComponent(rad_1054)))
                        .addGap(6, 6, 6)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rad_1069, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(rad_1077, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(rad_1070)
                                .addComponent(rad_1071)
                                .addComponent(rad_1072)
                                .addComponent(rad_1073)
                                .addComponent(rad_1074)
                                .addComponent(rad_1075)
                                .addComponent(rad_1076)
                                .addComponent(rad_1078)
                                .addComponent(rad_1079)
                                .addComponent(rad_1080))
                            .addGroup(jPanel_111Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel14))
                            .addComponent(rad_1068)))
                    .addComponent(jLabel12))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel_111Layout.setVerticalGroup(
            jPanel_111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_111Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_111Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_1068)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_1069)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_1070)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rad_1071)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_1072)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rad_1073)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_1074)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_1075)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_1076)
                        .addGap(3, 3, 3)
                        .addComponent(rad_1077)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_1078)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_1079)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_1080)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_111Layout.createSequentialGroup()
                        .addGroup(jPanel_111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)
                            .addGroup(jPanel_111Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                                .addComponent(rad_1053)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_1054)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_1055)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rad_1056)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_1057)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rad_1058)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_1059)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_1060)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_1061)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_1062)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_1063)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_1064)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_1065)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_1066)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_1067)))
                        .addGap(10, 10, 10))))
        );

        jPanel_112.setName("112"); // NOI18N

        jLabel15.setText("1.13 ¿Cómo se identifica  tu madre según su cultura y costumbres?\n");
        jLabel15.setName("1"); // NOI18N

        rad_1081.setText("Indígena");
        rad_1081.setName("1081"); // NOI18N
        rad_1081.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1081ActionPerformed(evt);
            }
        });

        rad_1082.setText("Mestizo");
        rad_1082.setName("1082"); // NOI18N
        rad_1082.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1082ActionPerformed(evt);
            }
        });

        rad_1083.setText("Afroecuatoriano/afrodescendiente");
        rad_1083.setName("1083"); // NOI18N
        rad_1083.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1083ActionPerformed(evt);
            }
        });

        rad_1084.setText("Negro");
        rad_1084.setName("1084"); // NOI18N
        rad_1084.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1084ActionPerformed(evt);
            }
        });

        rad_1085.setText("Mulato");
        rad_1085.setName("1085"); // NOI18N
        rad_1085.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1085ActionPerformed(evt);
            }
        });

        rad_1086.setText("Montuvio");
        rad_1086.setName("1086"); // NOI18N
        rad_1086.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1086ActionPerformed(evt);
            }
        });

        rad_1087.setText("Blanco");
        rad_1087.setName("1087"); // NOI18N
        rad_1087.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1087ActionPerformed(evt);
            }
        });

        rad_1088.setText("No conozco a mi madre");
        rad_1088.setName("1088"); // NOI18N
        rad_1088.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1088ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_112Layout = new javax.swing.GroupLayout(jPanel_112);
        jPanel_112.setLayout(jPanel_112Layout);
        jPanel_112Layout.setHorizontalGroup(
            jPanel_112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_112Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rad_1088)
                    .addComponent(rad_1087)
                    .addComponent(rad_1086)
                    .addComponent(rad_1085)
                    .addComponent(rad_1084)
                    .addComponent(rad_1083)
                    .addComponent(rad_1082)
                    .addComponent(rad_1081)
                    .addComponent(jLabel15))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel_112Layout.setVerticalGroup(
            jPanel_112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_112Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1081)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1082)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1083)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1084)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1085)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1086)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1087)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1088)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_113.setName("113"); // NOI18N

        jLabel16.setText("Pueblos");

        rad_1103.setText("Kichwa de la sierra");
        rad_1103.setName("1103"); // NOI18N

        rad_1102.setText("Kichwa amazonia");
        rad_1102.setName("1102"); // NOI18N
        rad_1102.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad_1102ActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        rad_1101.setText("Andoa");
        rad_1101.setName("1101"); // NOI18N

        rad_1115.setText("Waranka");
        rad_1115.setName("1115"); // NOI18N

        rad_1114.setText("Tomabela");
        rad_1114.setName("1114"); // NOI18N

        jLabel17.setText("Nacionalidades ");

        rad_1116.setText("Puruhá");
        rad_1116.setName("1116"); // NOI18N

        rad_1095.setText("Secoya");
        rad_1095.setName("1095"); // NOI18N

        rad_1096.setText("Shiwiar");
        rad_1096.setName("1096"); // NOI18N

        rad_1099.setText("Waorani");
        rad_1099.setName("1099"); // NOI18N

        rad_1100.setText("Zapara");
        rad_1100.setName("1100"); // NOI18N

        rad_1097.setText("Shuar");
        rad_1097.setName("1097"); // NOI18N

        rad_1098.setText("Tsachila");
        rad_1098.setName("1098"); // NOI18N

        rad_1112.setText("Salasaka");
        rad_1112.setName("1112"); // NOI18N

        rad_1111.setText("Chibuleo");
        rad_1111.setName("1111"); // NOI18N

        rad_1094.setText("Siona");
        rad_1094.setName("1094"); // NOI18N

        rad_1113.setText("Kisapincha");
        rad_1113.setName("1113"); // NOI18N

        rad_1091.setText("Chachi");
        rad_1091.setName("1091"); // NOI18N

        rad_1090.setText("Achuar");
        rad_1090.setName("1090"); // NOI18N

        rad_1093.setText("Epera");
        rad_1093.setName("1093"); // NOI18N

        rad_1092.setText("Cofan");
        rad_1092.setName("1092"); // NOI18N

        rad_1104.setText("Pastos");
        rad_1104.setName("1104"); // NOI18N

        jLabel18.setText("1.14 ¿A cuál pueblo o nacionalidad pertenece?\n");
        jLabel18.setName("1"); // NOI18N

        rad_1105.setText("Natabuela");
        rad_1105.setName("1105"); // NOI18N

        rad_1089.setText("Awa");
        rad_1089.setName("1089"); // NOI18N

        rad_1106.setText("Otavalo");
        rad_1106.setName("1106"); // NOI18N

        rad_1107.setText("Karanki");
        rad_1107.setName("1107"); // NOI18N

        rad_1108.setText("Kayambi");
        rad_1108.setName("1108"); // NOI18N

        rad_1109.setText("Kitukara");
        rad_1109.setName("1109"); // NOI18N

        rad_1110.setText("Panzaleo");
        rad_1110.setName("1110"); // NOI18N

        javax.swing.GroupLayout jPanel_113Layout = new javax.swing.GroupLayout(jPanel_113);
        jPanel_113.setLayout(jPanel_113Layout);
        jPanel_113Layout.setHorizontalGroup(
            jPanel_113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_113Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_113Layout.createSequentialGroup()
                        .addGroup(jPanel_113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rad_1102)
                            .addComponent(rad_1089)
                            .addComponent(rad_1091)
                            .addComponent(rad_1092)
                            .addComponent(rad_1093)
                            .addComponent(rad_1094)
                            .addComponent(rad_1095)
                            .addComponent(rad_1096)
                            .addComponent(rad_1097)
                            .addComponent(rad_1098)
                            .addComponent(rad_1099)
                            .addComponent(rad_1100)
                            .addComponent(rad_1101)
                            .addComponent(rad_1103)
                            .addGroup(jPanel_113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel16)
                                .addComponent(rad_1090)))
                        .addGap(6, 6, 6)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rad_1105, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(rad_1113, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(rad_1106)
                                .addComponent(rad_1107)
                                .addComponent(rad_1108)
                                .addComponent(rad_1109)
                                .addComponent(rad_1110)
                                .addComponent(rad_1111)
                                .addComponent(rad_1112)
                                .addComponent(rad_1114)
                                .addComponent(rad_1115)
                                .addComponent(rad_1116))
                            .addGroup(jPanel_113Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel17))
                            .addComponent(rad_1104)))
                    .addComponent(jLabel18))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel_113Layout.setVerticalGroup(
            jPanel_113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_113Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_113Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_1104)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_1105)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_1106)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rad_1107)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_1108)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rad_1109)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_1110)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_1111)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_1112)
                        .addGap(3, 3, 3)
                        .addComponent(rad_1113)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_1114)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_1115)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_1116)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_113Layout.createSequentialGroup()
                        .addGroup(jPanel_113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2)
                            .addGroup(jPanel_113Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rad_1089)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_1090)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_1091)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rad_1092)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_1093)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rad_1094)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_1095)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_1096)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_1097)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_1098)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_1099)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_1100)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_1101)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_1102)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rad_1103)))
                        .addGap(10, 10, 10))))
        );

        jPanel_114.setName("114"); // NOI18N

        jLabel21.setText("1.15 ¿Qué idioma habla como lengua principal tu padre?\n");
        jLabel21.setName("1"); // NOI18N

        rad_1117.setText("Español");
        rad_1117.setName("1117"); // NOI18N

        rad_1118.setText("Lengua indígena");
        rad_1118.setName("1118"); // NOI18N

        rad_1119.setText("Lengua extranjera");
        rad_1119.setName("1119"); // NOI18N

        rad_1120.setText("No habla (lenguaje de señas)");
        rad_1120.setName("1120"); // NOI18N

        javax.swing.GroupLayout jPanel_114Layout = new javax.swing.GroupLayout(jPanel_114);
        jPanel_114.setLayout(jPanel_114Layout);
        jPanel_114Layout.setHorizontalGroup(
            jPanel_114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_114Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rad_1120)
                    .addComponent(rad_1119)
                    .addComponent(rad_1118)
                    .addComponent(rad_1117)
                    .addComponent(jLabel21))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel_114Layout.setVerticalGroup(
            jPanel_114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_114Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1117)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1118)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1119)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1120)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_115.setName("115"); // NOI18N

        jLabel22.setText("1.16 ¿Qué idioma habla como lengua principal tu madre?\n");
        jLabel22.setName("1"); // NOI18N

        rad_1121.setText("Español");
        rad_1121.setName("1121"); // NOI18N

        rad_1122.setText("Lengua indígena");
        rad_1122.setName("1122"); // NOI18N

        rad_1123.setText("Lengua extranjera");
        rad_1123.setName("1123"); // NOI18N

        rad_1124.setText("No habla (lenguaje de señas)");
        rad_1124.setName("1124"); // NOI18N

        javax.swing.GroupLayout jPanel_115Layout = new javax.swing.GroupLayout(jPanel_115);
        jPanel_115.setLayout(jPanel_115Layout);
        jPanel_115Layout.setHorizontalGroup(
            jPanel_115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_115Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rad_1124)
                    .addComponent(rad_1123)
                    .addComponent(rad_1122)
                    .addComponent(rad_1121)
                    .addComponent(jLabel22))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel_115Layout.setVerticalGroup(
            jPanel_115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_115Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1121)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1122)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1123)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rad_1124)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel_100.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel_100.setForeground(new java.awt.Color(255, 51, 51));
        jLabel_100.setText("* Esta pregunta es obligatoria.");
        jLabel_100.setName("lbl_100"); // NOI18N

        javax.swing.GroupLayout jPanelSec_1Layout = new javax.swing.GroupLayout(jPanelSec_1);
        jPanelSec_1.setLayout(jPanelSec_1Layout);
        jPanelSec_1Layout.setHorizontalGroup(
            jPanelSec_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSec_1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSec_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSec_1Layout.createSequentialGroup()
                        .addComponent(jPanel_100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_100))
                    .addComponent(jPanel_101, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_102, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_103, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_104, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_105, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_106, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_107, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_108, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_109, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_110, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_111, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_112, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_113, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_114, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_115, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanelSec_1Layout.setVerticalGroup(
            jPanelSec_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSec_1Layout.createSequentialGroup()
                .addGroup(jPanelSec_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSec_1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel_100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelSec_1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel_100)))
                .addGap(10, 10, 10)
                .addComponent(jPanel_101, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel_102, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel_103, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel_104, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel_105, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel_106, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel_107, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel_108, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel_109, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel_110, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel_111, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel_112, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel_113, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel_114, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel_115, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanelSec_1);

        jTabbedPane1.addTab("INFORMACIÓN FAMILIAR", jScrollPane1);

        javax.swing.GroupLayout jPanelSec_2Layout = new javax.swing.GroupLayout(jPanelSec_2);
        jPanelSec_2.setLayout(jPanelSec_2Layout);
        jPanelSec_2Layout.setHorizontalGroup(
            jPanelSec_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 637, Short.MAX_VALUE)
        );
        jPanelSec_2Layout.setVerticalGroup(
            jPanelSec_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanelSec_2);

        jTabbedPane1.addTab("TIPOLOGIA DE LA VIVIENDA", jScrollPane2);

        javax.swing.GroupLayout jPanelSec_3Layout = new javax.swing.GroupLayout(jPanelSec_3);
        jPanelSec_3.setLayout(jPanelSec_3Layout);
        jPanelSec_3Layout.setHorizontalGroup(
            jPanelSec_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 637, Short.MAX_VALUE)
        );
        jPanelSec_3Layout.setVerticalGroup(
            jPanelSec_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanelSec_3);

        jTabbedPane1.addTab("CAPITAL ECONOMICO, SOCIAL Y CULTURAL", jScrollPane3);

        javax.swing.GroupLayout jPanelSec_4Layout = new javax.swing.GroupLayout(jPanelSec_4);
        jPanelSec_4.setLayout(jPanelSec_4Layout);
        jPanelSec_4Layout.setHorizontalGroup(
            jPanelSec_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 637, Short.MAX_VALUE)
        );
        jPanelSec_4Layout.setVerticalGroup(
            jPanelSec_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(jPanelSec_4);

        jTabbedPane1.addTab("PREPARACIÓN PARA RENDIR EL ENES", jScrollPane4);

        javax.swing.GroupLayout jPanelSec_5Layout = new javax.swing.GroupLayout(jPanelSec_5);
        jPanelSec_5.setLayout(jPanelSec_5Layout);
        jPanelSec_5Layout.setHorizontalGroup(
            jPanelSec_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 637, Short.MAX_VALUE)
        );
        jPanelSec_5Layout.setVerticalGroup(
            jPanelSec_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
        );

        jScrollPane5.setViewportView(jPanelSec_5);

        jTabbedPane1.addTab("ACCESO A TECNOLOGÍA DE LA INFORMACIÓN Y COMUNICACIÓN", jScrollPane5);

        javax.swing.GroupLayout jPanelSec_6Layout = new javax.swing.GroupLayout(jPanelSec_6);
        jPanelSec_6.setLayout(jPanelSec_6Layout);
        jPanelSec_6Layout.setHorizontalGroup(
            jPanelSec_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 637, Short.MAX_VALUE)
        );
        jPanelSec_6Layout.setVerticalGroup(
            jPanelSec_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
        );

        jScrollPane6.setViewportView(jPanelSec_6);

        jTabbedPane1.addTab("PERCEPCIONES", jScrollPane6);

        jButton_Sigueinte.setText("Siguiente");
        jButton_Sigueinte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SigueinteActionPerformed(evt);
            }
        });

        jButton_Atras.setText("Atrás");
        jButton_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AtrasActionPerformed(evt);
            }
        });

        jLabel20.setText("Cédula:");

        jLabel23.setText("Nombres:");

        jLabel24.setText("Apellidos:");

        jButton_activarEncuesta.setText("Activar Encuesta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_apellidos)))
                .addGap(106, 106, 106)
                .addComponent(jButton_activarEncuesta)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txt_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_activarEncuesta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton_Atras, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_Sigueinte)
                                .addGap(58, 58, 58))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Sigueinte)
                    .addComponent(jButton_Atras))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_SigueinteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SigueinteActionPerformed
        // TODO add your handling code here:
        validaSiguiente();
    }//GEN-LAST:event_jButton_SigueinteActionPerformed

    private void jButton_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AtrasActionPerformed
        // TODO add your handling code here:
        int i = jTabbedPane1.getSelectedIndex();
        if (i > 0) {
            i--;
        }
        jTabbedPane1.setSelectedIndex(i);
        index = i;
        //OPTIMIZAR
        //obtenerRespuestasPorSeccion(jPanelSec_1);
    }//GEN-LAST:event_jButton_AtrasActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        //index = jTabbedPane1.getSelectedIndex();
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jTabbedPane1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MousePressed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(index);
    }//GEN-LAST:event_jTabbedPane1MousePressed

    private void jTabbedPane1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseEntered

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        //jTabbedPane1.setSelectedIndex(index);
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jScrollPane1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jScrollPane1FocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_jScrollPane1FocusLost

    private void rad_1102ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1102ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad_1102ActionPerformed

    private void rad_1088ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1088ActionPerformed
        if(rad_1088.isSelected()){
            muestraOcultaPanel(jPanel_113, false);
            muestraOcultaPanel(jPanel_115, false);
        }
    }//GEN-LAST:event_rad_1088ActionPerformed

    private void rad_1087ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1087ActionPerformed
        if(rad_1087.isSelected()){
            muestraOcultaPanel(jPanel_113, false);
            muestraOcultaPanel(jPanel_115, true);
        }
    }//GEN-LAST:event_rad_1087ActionPerformed

    private void rad_1086ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1086ActionPerformed
        if(rad_1086.isSelected()){
            muestraOcultaPanel(jPanel_113, false);
            muestraOcultaPanel(jPanel_115, true);
        }
    }//GEN-LAST:event_rad_1086ActionPerformed

    private void rad_1085ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1085ActionPerformed
        if(rad_1085.isSelected()){
            muestraOcultaPanel(jPanel_113, false);
            muestraOcultaPanel(jPanel_115, true);
        }
    }//GEN-LAST:event_rad_1085ActionPerformed

    private void rad_1084ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1084ActionPerformed
        if(rad_1084.isSelected()){
            muestraOcultaPanel(jPanel_113, false);
            muestraOcultaPanel(jPanel_115, true);
        }
    }//GEN-LAST:event_rad_1084ActionPerformed

    private void rad_1083ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1083ActionPerformed
        if(rad_1083.isSelected()){
            muestraOcultaPanel(jPanel_113, false);
            muestraOcultaPanel(jPanel_115, true);
        }
    }//GEN-LAST:event_rad_1083ActionPerformed

    private void rad_1082ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1082ActionPerformed
        if(rad_1082.isSelected()){
            muestraOcultaPanel(jPanel_113, false);
            muestraOcultaPanel(jPanel_115, true);
        }
    }//GEN-LAST:event_rad_1082ActionPerformed

    private void rad_1081ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1081ActionPerformed
        if(rad_1081.isSelected()){
            muestraOcultaPanel(jPanel_113, true);
            muestraOcultaPanel(jPanel_115, true);
        }
    }//GEN-LAST:event_rad_1081ActionPerformed

    private void rad_1052ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1052ActionPerformed
        if(rad_1052.isSelected()){
            muestraOcultaPanel(jPanel_111, false);
            muestraOcultaPanel(jPanel_114, false);
        }
    }//GEN-LAST:event_rad_1052ActionPerformed

    private void rad_1051ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1051ActionPerformed
        if(rad_1051.isSelected()){
            muestraOcultaPanel(jPanel_111, false);
            muestraOcultaPanel(jPanel_114, true);
        }
    }//GEN-LAST:event_rad_1051ActionPerformed

    private void rad_1050ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1050ActionPerformed
        if(rad_1050.isSelected()){
            muestraOcultaPanel(jPanel_111, false);
            muestraOcultaPanel(jPanel_114, true);
        }
    }//GEN-LAST:event_rad_1050ActionPerformed

    private void rad_1049ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1049ActionPerformed
        if(rad_1049.isSelected()){
            muestraOcultaPanel(jPanel_111, false);
            muestraOcultaPanel(jPanel_114, true);
        }
    }//GEN-LAST:event_rad_1049ActionPerformed

    private void rad_1048ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1048ActionPerformed
        if(rad_1048.isSelected()){
            muestraOcultaPanel(jPanel_111, false);
            muestraOcultaPanel(jPanel_114, true);
        }
    }//GEN-LAST:event_rad_1048ActionPerformed

    private void rad_1047ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1047ActionPerformed
        if(rad_1047.isSelected()){
            muestraOcultaPanel(jPanel_111, false);
            muestraOcultaPanel(jPanel_114, true);
        }
    }//GEN-LAST:event_rad_1047ActionPerformed

    private void rad_1046ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1046ActionPerformed
        if(rad_1046.isSelected()){
            muestraOcultaPanel(jPanel_111, false);
            muestraOcultaPanel(jPanel_114, true);
        }
    }//GEN-LAST:event_rad_1046ActionPerformed

    private void rad_1045ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1045ActionPerformed
        if(rad_1045.isSelected()){
            muestraOcultaPanel(jPanel_111, true);
            muestraOcultaPanel(jPanel_114, true);
        }
    }//GEN-LAST:event_rad_1045ActionPerformed

    private void rad_1043ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1043ActionPerformed
        if(rad_1043.isSelected()){
            muestraOcultaPanel(jPanel_109, false);
        }
    }//GEN-LAST:event_rad_1043ActionPerformed

    private void rad_1042ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1042ActionPerformed
        if(rad_1042.isSelected()){
            muestraOcultaPanel(jPanel_109, true);
        }
    }//GEN-LAST:event_rad_1042ActionPerformed

    private void rad_1033ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1033ActionPerformed
        if(rad_1033.isSelected()){
            muestraOcultaPanel(jPanel_106, true);
        }
    }//GEN-LAST:event_rad_1033ActionPerformed

    private void rad_1032ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1032ActionPerformed
        if(rad_1032.isSelected()){
            muestraOcultaPanel(jPanel_106, true);
        }
    }//GEN-LAST:event_rad_1032ActionPerformed

    private void rad_1031ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1031ActionPerformed
        if(rad_1031.isSelected()){
            muestraOcultaPanel(jPanel_106, true);
        }
    }//GEN-LAST:event_rad_1031ActionPerformed

    private void rad_1030ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1030ActionPerformed
        if(rad_1030.isSelected()){
            muestraOcultaPanel(jPanel_106, false);
            muestraOcultaPanel(jPanel_107, true);
        }
    }//GEN-LAST:event_rad_1030ActionPerformed

    private void chk_1025ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_1025ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_1025ActionPerformed

    private void rad_1021ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1021ActionPerformed
        if(rad_1021.isSelected()){
            muestraOcultaPanel(jPanel_104, false);
            muestraOcultaPanel(jPanel_105, false);
            muestraOcultaPanel(jPanel_106, false);
            muestraOcultaPanel(jPanel_107, false);
            muestraOcultaPanel(jPanel_108, false);
            muestraOcultaPanel(jPanel_109, false);
        }
    }//GEN-LAST:event_rad_1021ActionPerformed

    private void rad_1020ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1020ActionPerformed
        if(rad_1020.isSelected()){
            muestraOcultaPanel(jPanel_104, true);
            muestraOcultaPanel(jPanel_105, true);
            muestraOcultaPanel(jPanel_107, true);
            muestraOcultaPanel(jPanel_108, true);
        }
    }//GEN-LAST:event_rad_1020ActionPerformed

    private void rad_1011ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1011ActionPerformed
        if(rad_1011.isSelected()){
            muestraOcultaPanel(jPanel_102,false);
        }
    }//GEN-LAST:event_rad_1011ActionPerformed

    private void rad_1010ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad_1010ActionPerformed
        if(rad_1010.isSelected()){
            muestraOcultaPanel(jPanel_102,true);
        }
    }//GEN-LAST:event_rad_1010ActionPerformed

    private void chk_1008ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_1008ActionPerformed
        if(chk_1008.isSelected()){
            habilitaDeshabilitaComponentesRango(1029,1029,false);
        }else{
            habilitaDeshabilitaComponentesRango(1029,1029,true);
        }
    }//GEN-LAST:event_chk_1008ActionPerformed

    private void chk_1007ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_1007ActionPerformed

    }//GEN-LAST:event_chk_1007ActionPerformed

    private void chk_1006ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_1006ActionPerformed
        if(chk_1006.isSelected()){
            habilitaDeshabilitaComponentesRango(1028,1028,false);
        }else{
            habilitaDeshabilitaComponentesRango(1028,1028,true);
        }
    }//GEN-LAST:event_chk_1006ActionPerformed

    private void chk_1005ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_1005ActionPerformed
        if(chk_1005.isSelected()){
            habilitaDeshabilitaComponentesRango(1027,1027,false);
        }else{
            habilitaDeshabilitaComponentesRango(1027,1027,true);
        }
    }//GEN-LAST:event_chk_1005ActionPerformed

    private void chk_1004ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_1004ActionPerformed
        if(chk_1004.isSelected()){
            habilitaDeshabilitaComponentesRango(1026,1026,false);
        }else{
            habilitaDeshabilitaComponentesRango(1026,1026,true);
        }
    }//GEN-LAST:event_chk_1004ActionPerformed

    private void chk_1003ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_1003ActionPerformed
        if(chk_1003.isSelected()){
            habilitaDeshabilitaComponentesRango(1025,1025,false);
        }else{
            habilitaDeshabilitaComponentesRango(1025,1025,true);
        }
    }//GEN-LAST:event_chk_1003ActionPerformed

    private void chk_1002ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_1002ActionPerformed
        if(chk_1002.isSelected()){
            habilitaDeshabilitaComponentesRango(1024,1024,false);
            habilitaDeshabilitaComponentesRango(1088,1088,false);
        }else{
            habilitaDeshabilitaComponentesRango(1024,1024,true);
        }
    }//GEN-LAST:event_chk_1002ActionPerformed

    private void chk_1001ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_1001ActionPerformed
        if(chk_1001.isSelected()){
            habilitaDeshabilitaComponentesRango(1023,1023,false);
            habilitaDeshabilitaComponentesRango(1052,1052,false);
        }else{
            habilitaDeshabilitaComponentesRango(1023,1023,true);
        }
    }//GEN-LAST:event_chk_1001ActionPerformed

    private void chk_1000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_1000ActionPerformed
        if(chk_1000.isSelected()){
            habilitaDeshabilitaComponentesRango(1001,1009,false);
        }else{
            habilitaDeshabilitaComponentesRango(1001,1009,true);
        }

    }//GEN-LAST:event_chk_1000ActionPerformed

    /** 
     * @param args the command line arguments
     */
    public HashMap<String,Component> obtenerComponentesPorPanel(JPanel j) {
        try {
            Component[] componentes = j.getComponents();
            HashMap<String,Component> componentMap = new HashMap<>();
            for (int i = 0; i < componentes.length; i++) {
                if (componentes[i] instanceof JPanel) {
                    componentMap.put(componentes[i].getName(), componentes[i]);
                    Component[] auxiliar = ((JPanel)componentes[i]).getComponents();
                    for (int a = 0; a < auxiliar.length; a++) {
                        componentMap.put(auxiliar[a].getName(), auxiliar[a]);
                    }
                }
                if (componentes[i] instanceof JLabel) {
                    componentMap.put(componentes[i].getName(), componentes[i]);
                }
            }
            return componentMap;
        } catch (Exception ex) {
            Logger.getLogger(EncuestaContexto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     * 
     */
    public Component obtenerComponentePorName(String name) {
        if (allComponents.containsKey(name)) {
            return (Component) allComponents.get(name);
        }else{
             return null;
        }
    }
    
    /**
     * 
     */
    private void muestraOcultaPanel(JPanel panel,boolean opcion){
        panel.setVisible(opcion);
        Component[] componentes1 = panel.getComponents();
        for (int a = 0; a < componentes1.length; a++) {
            if(componentes1[a] instanceof JRadioButton){
//                ((JRadioButton)componentes1[a]).setEnabled(opcion);
                ((JRadioButton)componentes1[a]).setSelected(false);
            }
            if(componentes1[a] instanceof JCheckBox){
//                ((JCheckBox)componentes1[a]).setEnabled(opcion);
                ((JCheckBox)componentes1[a]).setSelected(false);
            }
            if(componentes1[a] instanceof JTextField){
//                ((JTextField)componentes1[a]).setEnabled(opcion);
                ((JTextField)componentes1[a]).setText("");
            }
        }
    }
    
    public void fileChooser(){
        javax.swing.JFileChooser jF1 = new javax.swing.JFileChooser(); 
        //Creamos el filtro
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.XML", "xml");
        //Le indicamos el filtro
        jF1.setFileFilter(filtro);
        //Nombre por defecto
        jF1.setSelectedFile(new File("respuestas.XML"));
        try{ 
            if(jF1.showSaveDialog(null)==jF1.APPROVE_OPTION){ 
                ruta = jF1.getSelectedFile().getAbsolutePath();
                System.out.println(ruta);
                //Aqui ya tiens la ruta,,,ahora puedes crear un fichero n esa ruta y escribir lo k kieras... 
            } 
        }catch (Exception ex){ 
            ex.printStackTrace(); 
        }
    }
    /**
     * 
     */
    public void habilitaDeshabilitaComponentesRango(int inicio,int fin, boolean opcion){
        Component componente;
        for(int i=inicio;i<=fin;i++){
            String nombre = ""+i;
            componente = obtenerComponentePorName(nombre);
            if(componente instanceof JRadioButton){
                ((JRadioButton)componente).setEnabled(opcion);
                ((JRadioButton)componente).setSelected(false);
            }
            if(componente instanceof JCheckBox){
                ((JCheckBox)componente).setEnabled(opcion);
                ((JCheckBox)componente).setSelected(false);
            }
            if(componente instanceof JTextField){
                ((JTextField)componente).setEnabled(opcion);
                ((JTextField)componente).setText("");
            }
        }
    
    }
    /**
     * @param args the command line arguments
     */
//    public void obtenerRespuestasPorSeccion(JPanel j) {
//        try {
//            Component[] componentes = j.getComponents();
//            HashMap<String,Component> componentMap = new HashMap<>();
//            for (int i = 0; i < componentes.length; i++) {
//                if (componentes[i] instanceof JPanel) {
//                    componentMap.put(componentes[i].getName(), componentes[i]);
//                    Component[] componentes1 = ((JPanel)componentes[i]).getComponents();
//                    for (int a = 0; a < componentes1.length; a++) {
////                        if(componentes1[a] instanceof JPanel){
////                            componentMap.put(componentes1[a].getName(), componentes1[a]);
////                        }
//                        if(componentes1[a] instanceof JRadioButton){
//                            componentMap.put(componentes1[a].getName(), componentes1[a]);
//                        }
//                        if(componentes1[a] instanceof JCheckBox){
//                            componentMap.put(componentes1[a].getName(), componentes1[a]);
//                        }
//                        if(componentes1[a] instanceof JTextField){
//                            componentMap.put(componentes1[a].getName(), componentes1[a]);
//                        }
//                    }
//                }
//            }
//            generateXML(componentMap);
//        } catch (Exception ex) {
//            Logger.getLogger(EncuestaContexto.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

     /**
     * @param args the command line arguments
     */
    public void generateXML(HashMap<String,Component> respuestas) throws Exception{
        String valor = "";
        if(respuestas.isEmpty()){
            System.out.println("ERROR empty ArrayList");
            return;
        }else{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            org.w3c.dom.Document document = implementation.createDocument(null, fileConfig, null);
            document.setXmlVersion("1.0");
            //Main Node
            org.w3c.dom.Element raiz = document.getDocumentElement();
            org.w3c.dom.Element itemNode = document.createElement("LISTA_RESPUESTAS");
            /*Para registrar la seccion actual*/
            org.w3c.dom.Element itemNode1 = document.createElement("SECCIONES");
            org.w3c.dom.Element keyNode1 = document.createElement("SECCION_ACTUAL");
            keyNode1.setAttribute("INDEX", index.toString());
            itemNode1.appendChild(keyNode1);
            raiz.appendChild(itemNode1);
            /*--------------------------------*/
            for(Map.Entry<String,Component> b: respuestas.entrySet()){
                org.w3c.dom.Element keyNode = document.createElement("COMPONENTE"); 
                keyNode.setAttribute("NAME", b.getKey());
                if(b.getValue() instanceof JPanel){
                    keyNode.setAttribute("VISIBLE", (((JPanel)b.getValue()).isVisible())?"1":"0");
                    valor = "jPanel";
                }
                if(b.getValue() instanceof JRadioButton){
                    keyNode.setAttribute("ENABLED", (((JRadioButton)b.getValue()).isEnabled())?"1":"0");
                    keyNode.setAttribute("SELECTED", (((JRadioButton)b.getValue()).isSelected())?"1":"0");
                    valor = (((JRadioButton)b.getValue()).isSelected())?"1":"0";
                }
                if(b.getValue() instanceof JCheckBox){
                    keyNode.setAttribute("ENABLED", (((JCheckBox)b.getValue()).isEnabled())?"1":"0");
                    keyNode.setAttribute("SELECTED", (((JCheckBox)b.getValue()).isSelected())?"1":"0");
                    valor = (((JCheckBox)b.getValue()).isSelected())?"1":"0";
                }
                if(b.getValue() instanceof JTextField){
                    keyNode.setAttribute("ENABLED", (((JTextField)b.getValue()).isEnabled())?"1":"0");
                    keyNode.setAttribute("VALUE", ((JTextField)b.getValue()).getText());
                    valor = ((JTextField)b.getValue()).getText();
                }
                Text nodeKeyValue = document.createTextNode(valor);
                keyNode.appendChild(nodeKeyValue);      
                itemNode.appendChild(keyNode);
                raiz.appendChild(itemNode);
            }
            //Generate XML
            Source source = new DOMSource(document);
            //Indicamos donde lo queremos almacenar
            Result result = new StreamResult(new java.io.File("./xml/"+fileConfig+".xml")); //nombre del archivo
            //Result result = new StreamResult(new java.io.File("./src/ec/gob/senescyt/snna/xml/"+fileConfig+".xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        }
    }
    
    /**
     * 
     */
    public void cargarXml(){
        //Se crea un SAXBuilder para poder parsear el archivo
        SAXBuilder builder = new SAXBuilder();
        //File xmlFile = new File( "./src/ec/gob/senescyt/snna/xml/"+fileConfig+".xml" );
        File xmlFile = new File( "./xml/"+fileConfig+".xml" );
        try
        {
            //Se crea el documento a traves del archivo
            Document document = (Document) builder.build( xmlFile );
            //Se obtiene la raiz
            Element rootNode = document.getRootElement();
            //Se obtiene la lista de hijos de la raiz 'config'
            /*------------------------------------------------*/
            List listaSecciones = rootNode.getChildren( "SECCIONES" );
            Element secciones = (Element) listaSecciones.get(0);
            List hijosSecciones = secciones.getChildren();
            Element seccionActual = (Element)hijosSecciones.get(0);
            jTabbedPane1.setSelectedIndex(Integer.parseInt(seccionActual.getAttributeValue("INDEX")));
            index = jTabbedPane1.getSelectedIndex();
            bloqueaPestanias();
            /*------------------------------------------------*/
            List list = rootNode.getChildren( "LISTA_RESPUESTAS" );
            //Se obtiene el elemento 'LISTA_RESPUESTAS'
            Element respuestas = (Element) list.get(0);
            //Se obtiene la lista de hijos del tag 'LISTA_RESPUESTAS'
            List lista_componentes = respuestas.getChildren();
            //Se recorre la lista de campos
            for ( int j = 0; j < lista_componentes.size(); j++ )
            {
                //Se obtiene el elemento 'campo'
                Element componente = (Element)lista_componentes.get(j);
//                if(componente.getAttributeValue("NAME").equalsIgnoreCase("109"))
//                {
//                System.out.println("xxxx");
//                }
                Component componenteGui = obtenerComponentePorName(componente.getAttributeValue("NAME"));
                if(componenteGui instanceof JPanel){
                    ((JPanel)componenteGui).setVisible(componente.getAttributeValue("VISIBLE").equalsIgnoreCase("1"));
                }
                if(componenteGui instanceof JRadioButton){
                    ((JRadioButton)componenteGui).setEnabled(componente.getAttributeValue("ENABLED").equalsIgnoreCase("1"));
                    ((JRadioButton)componenteGui).setSelected(componente.getAttributeValue("SELECTED").equalsIgnoreCase("1"));
                }
                if(componenteGui instanceof JCheckBox){
                    ((JCheckBox)componenteGui).setEnabled(componente.getAttributeValue("ENABLED").equalsIgnoreCase("1"));
                    ((JCheckBox)componenteGui).setSelected(componente.getAttributeValue("SELECTED").equalsIgnoreCase("1"));
                }
                if(componenteGui instanceof JTextField){
                    ((JTextField)componenteGui).setEnabled(componente.getAttributeValue("ENABLED").equalsIgnoreCase("1"));
                    if(componente.getContent().size()>0)
                        ((JTextField)componenteGui).setText(componente.getAttributeValue("VALUE").toString());
                }
            }
        }catch ( Exception e ) {
            System.out.println( e.getMessage() );
        }
    }
    
    /** 
     * @param args the command line arguments
     */
    public boolean validarPreguntasPorPanel(JPanel j) {
        try {
            int bandera=0;
            int banderaAux=0;
            Component[] componentes = j.getComponents();
            for (int i = 0; i < componentes.length; i++) {
                if (componentes[i] instanceof JPanel && ((JPanel)componentes[i]).isVisible()) {
                    Component[] auxiliar = ((JPanel)componentes[i]).getComponents();
                    bandera=0;
                    Component label = obtenerComponentePorName("lbl_"+ ((JPanel)componentes[i]).getName());
                    for (int a = 0; a < auxiliar.length; a++) {
                        if(auxiliar[a] instanceof JRadioButton && ((JRadioButton)auxiliar[a]).isSelected()){
                            bandera++;
                        }
                        if(auxiliar[a] instanceof JCheckBox && ((JCheckBox)auxiliar[a]).isSelected()){
                            bandera++;
                        }
                        if(auxiliar[a] instanceof JTextField && !((JTextField)auxiliar[a]).getText().isEmpty()){
                            bandera++;
                        }
                    }
                    if(label != null)//CAMBIAR!!!!
                        if(bandera == 0){
                            ((JLabel)label).setVisible(true);
                            banderaAux++;
                        }else{
                            ((JLabel)label).setVisible(false);
                        }
                }
            }
            if(banderaAux > 0){
                JOptionPane.showMessageDialog(this, "Revisa los campos alertados","Error",JOptionPane.ERROR_MESSAGE);
                return false;
            }else{
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(EncuestaContexto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    /**
     * 
     */
    public void validaSiguiente(){
        int i = jTabbedPane1.getSelectedIndex() + 1;
        int total = jTabbedPane1.getTabCount();
        boolean bandera;
        switch(i){
            case 1:
                bandera = validarPreguntasPorPanel(jPanelSec_1);
            break;
            default:
                bandera = false;
            break;
        }
        
        if(bandera){
            try {
                if (i < total) {
                    jTabbedPane1.setSelectedIndex(i++);
                    jTabbedPane1.setEnabledAt(i-1,true);
                    index = jTabbedPane1.getSelectedIndex();
                }
                generateXML(allComponents);
            } catch (Exception ex) {
                Logger.getLogger(EncuestaContexto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            //jTabbedPane1.setSelectedIndex(i-2);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EncuestaContexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EncuestaContexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EncuestaContexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EncuestaContexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EncuestaContexto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgSec1_101;
    private javax.swing.ButtonGroup bgSec1_103;
    private javax.swing.ButtonGroup bgSec1_105;
    private javax.swing.ButtonGroup bgSec1_107;
    private javax.swing.ButtonGroup bgSec1_108;
    private javax.swing.ButtonGroup bgSec1_110;
    private javax.swing.ButtonGroup bgSec1_111;
    private javax.swing.ButtonGroup bgSec1_112;
    private javax.swing.ButtonGroup bgSec1_113;
    private javax.swing.ButtonGroup bgSec1_114;
    private javax.swing.ButtonGroup bgSec1_115;
    private javax.swing.JCheckBox chk_1000;
    private javax.swing.JCheckBox chk_1001;
    private javax.swing.JCheckBox chk_1002;
    private javax.swing.JCheckBox chk_1003;
    private javax.swing.JCheckBox chk_1004;
    private javax.swing.JCheckBox chk_1005;
    private javax.swing.JCheckBox chk_1006;
    private javax.swing.JCheckBox chk_1007;
    private javax.swing.JCheckBox chk_1008;
    private javax.swing.JCheckBox chk_1009;
    private javax.swing.JCheckBox chk_1012;
    private javax.swing.JCheckBox chk_1013;
    private javax.swing.JCheckBox chk_1014;
    private javax.swing.JCheckBox chk_1015;
    private javax.swing.JCheckBox chk_1016;
    private javax.swing.JCheckBox chk_1017;
    private javax.swing.JCheckBox chk_1018;
    private javax.swing.JCheckBox chk_1019;
    private javax.swing.JCheckBox chk_1022;
    private javax.swing.JCheckBox chk_1023;
    private javax.swing.JCheckBox chk_1024;
    private javax.swing.JCheckBox chk_1025;
    private javax.swing.JCheckBox chk_1026;
    private javax.swing.JCheckBox chk_1027;
    private javax.swing.JCheckBox chk_1028;
    private javax.swing.JCheckBox chk_1029;
    private javax.swing.JButton jButton_Atras;
    private javax.swing.JButton jButton_Sigueinte;
    private javax.swing.JButton jButton_activarEncuesta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_100;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelSec_1;
    private javax.swing.JPanel jPanelSec_2;
    private javax.swing.JPanel jPanelSec_3;
    private javax.swing.JPanel jPanelSec_4;
    private javax.swing.JPanel jPanelSec_5;
    private javax.swing.JPanel jPanelSec_6;
    private javax.swing.JPanel jPanel_100;
    private javax.swing.JPanel jPanel_101;
    private javax.swing.JPanel jPanel_102;
    private javax.swing.JPanel jPanel_103;
    private javax.swing.JPanel jPanel_104;
    private javax.swing.JPanel jPanel_105;
    private javax.swing.JPanel jPanel_106;
    private javax.swing.JPanel jPanel_107;
    private javax.swing.JPanel jPanel_108;
    private javax.swing.JPanel jPanel_109;
    private javax.swing.JPanel jPanel_110;
    private javax.swing.JPanel jPanel_111;
    private javax.swing.JPanel jPanel_112;
    private javax.swing.JPanel jPanel_113;
    private javax.swing.JPanel jPanel_114;
    private javax.swing.JPanel jPanel_115;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rad_1010;
    private javax.swing.JRadioButton rad_1011;
    private javax.swing.JRadioButton rad_1020;
    private javax.swing.JRadioButton rad_1021;
    private javax.swing.JRadioButton rad_1030;
    private javax.swing.JRadioButton rad_1031;
    private javax.swing.JRadioButton rad_1032;
    private javax.swing.JRadioButton rad_1033;
    private javax.swing.JRadioButton rad_1035;
    private javax.swing.JRadioButton rad_1036;
    private javax.swing.JRadioButton rad_1037;
    private javax.swing.JRadioButton rad_1038;
    private javax.swing.JRadioButton rad_1039;
    private javax.swing.JRadioButton rad_1040;
    private javax.swing.JRadioButton rad_1041;
    private javax.swing.JRadioButton rad_1042;
    private javax.swing.JRadioButton rad_1043;
    private javax.swing.JRadioButton rad_1045;
    private javax.swing.JRadioButton rad_1046;
    private javax.swing.JRadioButton rad_1047;
    private javax.swing.JRadioButton rad_1048;
    private javax.swing.JRadioButton rad_1049;
    private javax.swing.JRadioButton rad_1050;
    private javax.swing.JRadioButton rad_1051;
    private javax.swing.JRadioButton rad_1052;
    private javax.swing.JRadioButton rad_1053;
    private javax.swing.JRadioButton rad_1054;
    private javax.swing.JRadioButton rad_1055;
    private javax.swing.JRadioButton rad_1056;
    private javax.swing.JRadioButton rad_1057;
    private javax.swing.JRadioButton rad_1058;
    private javax.swing.JRadioButton rad_1059;
    private javax.swing.JRadioButton rad_1060;
    private javax.swing.JRadioButton rad_1061;
    private javax.swing.JRadioButton rad_1062;
    private javax.swing.JRadioButton rad_1063;
    private javax.swing.JRadioButton rad_1064;
    private javax.swing.JRadioButton rad_1065;
    private javax.swing.JRadioButton rad_1066;
    private javax.swing.JRadioButton rad_1067;
    private javax.swing.JRadioButton rad_1068;
    private javax.swing.JRadioButton rad_1069;
    private javax.swing.JRadioButton rad_1070;
    private javax.swing.JRadioButton rad_1071;
    private javax.swing.JRadioButton rad_1072;
    private javax.swing.JRadioButton rad_1073;
    private javax.swing.JRadioButton rad_1074;
    private javax.swing.JRadioButton rad_1075;
    private javax.swing.JRadioButton rad_1076;
    private javax.swing.JRadioButton rad_1077;
    private javax.swing.JRadioButton rad_1078;
    private javax.swing.JRadioButton rad_1079;
    private javax.swing.JRadioButton rad_1080;
    private javax.swing.JRadioButton rad_1081;
    private javax.swing.JRadioButton rad_1082;
    private javax.swing.JRadioButton rad_1083;
    private javax.swing.JRadioButton rad_1084;
    private javax.swing.JRadioButton rad_1085;
    private javax.swing.JRadioButton rad_1086;
    private javax.swing.JRadioButton rad_1087;
    private javax.swing.JRadioButton rad_1088;
    private javax.swing.JRadioButton rad_1089;
    private javax.swing.JRadioButton rad_1090;
    private javax.swing.JRadioButton rad_1091;
    private javax.swing.JRadioButton rad_1092;
    private javax.swing.JRadioButton rad_1093;
    private javax.swing.JRadioButton rad_1094;
    private javax.swing.JRadioButton rad_1095;
    private javax.swing.JRadioButton rad_1096;
    private javax.swing.JRadioButton rad_1097;
    private javax.swing.JRadioButton rad_1098;
    private javax.swing.JRadioButton rad_1099;
    private javax.swing.JRadioButton rad_1100;
    private javax.swing.JRadioButton rad_1101;
    private javax.swing.JRadioButton rad_1102;
    private javax.swing.JRadioButton rad_1103;
    private javax.swing.JRadioButton rad_1104;
    private javax.swing.JRadioButton rad_1105;
    private javax.swing.JRadioButton rad_1106;
    private javax.swing.JRadioButton rad_1107;
    private javax.swing.JRadioButton rad_1108;
    private javax.swing.JRadioButton rad_1109;
    private javax.swing.JRadioButton rad_1110;
    private javax.swing.JRadioButton rad_1111;
    private javax.swing.JRadioButton rad_1112;
    private javax.swing.JRadioButton rad_1113;
    private javax.swing.JRadioButton rad_1114;
    private javax.swing.JRadioButton rad_1115;
    private javax.swing.JRadioButton rad_1116;
    private javax.swing.JRadioButton rad_1117;
    private javax.swing.JRadioButton rad_1118;
    private javax.swing.JRadioButton rad_1119;
    private javax.swing.JRadioButton rad_1120;
    private javax.swing.JRadioButton rad_1121;
    private javax.swing.JRadioButton rad_1122;
    private javax.swing.JRadioButton rad_1123;
    private javax.swing.JRadioButton rad_1124;
    private javax.swing.JTextField txt_1034;
    private javax.swing.JTextField txt_1044;
    private javax.swing.JTextField txt_apellidos;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_nombres;
    // End of variables declaration//GEN-END:variables
}
