/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.senescyt.snna;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author jchalan
 */
public class EncuestaContexto extends javax.swing.JFrame {
  
    /**
     * Creates new form Encuesta
     */
    public EncuestaContexto() {
        initComponents();

        this.setLocationRelativeTo(null);

        buttonGroup_1.add(resp_100);
        buttonGroup_1.add(resp_101);
        buttonGroup_1.add(resp_102);

        jLayeredPane_2.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_1 = new javax.swing.ButtonGroup();
        buttonGroup_2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLayeredPane_1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        resp_100 = new javax.swing.JRadioButton();
        resp_101 = new javax.swing.JRadioButton();
        resp_102 = new javax.swing.JRadioButton();
        jLayeredPane_2 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox_104 = new javax.swing.JCheckBox();
        jCheckBox_105 = new javax.swing.JCheckBox();
        jCheckBox_106 = new javax.swing.JCheckBox();
        jLayeredPane_3 = new javax.swing.JLayeredPane();
        jLabel3 = new javax.swing.JLabel();
        jTextField_107 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton_Sigueinte = new javax.swing.JButton();
        jButton_Atras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        jLayeredPane_1.setBackground(new java.awt.Color(0, 204, 255));
        jLayeredPane_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLayeredPane_1MouseClicked(evt);
            }
        });
        jLayeredPane_1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLayeredPane_1MouseMoved(evt);
            }
        });

        jLabel1.setText("1.- ¿ Pregunta Uno ?");
        jLabel1.setName("1"); // NOI18N

        resp_100.setText("Respuesta Uno");
        resp_100.setName("100"); // NOI18N
        resp_100.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resp_100MouseClicked(evt);
            }
        });
        resp_100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resp_100ActionPerformed(evt);
            }
        });

        resp_101.setText("Respuesta Dos");
        resp_101.setName("101"); // NOI18N

        resp_102.setText("Respuesta Tres");
        resp_102.setName("102"); // NOI18N

        jLayeredPane_1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane_1.setLayer(resp_100, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane_1.setLayer(resp_101, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane_1.setLayer(resp_102, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane_1Layout = new javax.swing.GroupLayout(jLayeredPane_1);
        jLayeredPane_1.setLayout(jLayeredPane_1Layout);
        jLayeredPane_1Layout.setHorizontalGroup(
            jLayeredPane_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane_1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jLayeredPane_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resp_100)
                    .addGroup(jLayeredPane_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(resp_102)
                        .addComponent(jLabel1)
                        .addComponent(resp_101, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(420, Short.MAX_VALUE))
        );
        jLayeredPane_1Layout.setVerticalGroup(
            jLayeredPane_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane_1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resp_100)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resp_101)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resp_102)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane_2.setBackground(new java.awt.Color(0, 204, 255));

        jLabel2.setText("2.- ¿ Pregunta Dos ?");
        jLabel2.setName("2"); // NOI18N

        jCheckBox_104.setText("Respuesta Cuatro");
        jCheckBox_104.setName("104"); // NOI18N

        jCheckBox_105.setText("Respuesta Cinco");
        jCheckBox_105.setName("105"); // NOI18N

        jCheckBox_106.setText("Respuesta Seis");
        jCheckBox_106.setName("106"); // NOI18N

        jLayeredPane_2.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane_2.setLayer(jCheckBox_104, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane_2.setLayer(jCheckBox_105, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane_2.setLayer(jCheckBox_106, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane_2Layout = new javax.swing.GroupLayout(jLayeredPane_2);
        jLayeredPane_2.setLayout(jLayeredPane_2Layout);
        jLayeredPane_2Layout.setHorizontalGroup(
            jLayeredPane_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane_2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox_106)
                    .addComponent(jCheckBox_105)
                    .addComponent(jCheckBox_104)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane_2Layout.setVerticalGroup(
            jLayeredPane_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane_2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox_104)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox_105)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox_106)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLayeredPane_3.setBackground(new java.awt.Color(0, 204, 255));

        jLabel3.setText("3.- ¿ Pregunta Tres ?");
        jLabel3.setName("2"); // NOI18N

        jTextField_107.setName("107"); // NOI18N

        jLayeredPane_3.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane_3.setLayer(jTextField_107, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane_3Layout = new javax.swing.GroupLayout(jLayeredPane_3);
        jLayeredPane_3.setLayout(jLayeredPane_3Layout);
        jLayeredPane_3Layout.setHorizontalGroup(
            jLayeredPane_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane_3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane_3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTextField_107))
                    .addGroup(jLayeredPane_3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 84, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jLayeredPane_3Layout.setVerticalGroup(
            jLayeredPane_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane_3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_107, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLayeredPane_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLayeredPane_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLayeredPane_2)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLayeredPane_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLayeredPane_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        jTabbedPane1.addTab("Sección Uno", jScrollPane1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 639, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 357, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Sección Dos", jPanel2);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_Atras, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_Sigueinte)
                .addGap(58, 58, 58))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Sigueinte)
                    .addComponent(jButton_Atras))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resp_100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resp_100ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resp_100ActionPerformed

    private void resp_100MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resp_100MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_resp_100MouseClicked

    private void jLayeredPane_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLayeredPane_1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLayeredPane_1MouseClicked

    private void jLayeredPane_1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLayeredPane_1MouseMoved
        // TODO add your handling code here:
        if (resp_100.isSelected()) {
            jLayeredPane_2.setVisible(true);
        } else {
            jLayeredPane_2.setVisible(false);
        }
    }//GEN-LAST:event_jLayeredPane_1MouseMoved

    private void jButton_SigueinteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SigueinteActionPerformed
        // TODO add your handling code here:
        int i = jTabbedPane1.getSelectedIndex() + 1;
        int total = jTabbedPane1.getTabCount();
        if (i < total) {
            jTabbedPane1.setSelectedIndex(i++);
        }
        recorrerJPanel(jPanel1);
    }//GEN-LAST:event_jButton_SigueinteActionPerformed

    private void jButton_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AtrasActionPerformed
        // TODO add your handling code here:
        int i = jTabbedPane1.getSelectedIndex();
        if (i > 0) {
            i--;
        }
        jTabbedPane1.setSelectedIndex(i);
    }//GEN-LAST:event_jButton_AtrasActionPerformed

    /**
     * @param args the command line arguments
     */
    public void recorrerJPanel(JPanel j) {
        try {
            Component[] componentes = j.getComponents();
            HashMap<String,Component> componentMap = new HashMap<>();
            for (int i = 0; i < componentes.length; i++) {
                if (componentes[i] instanceof JLayeredPane) {
                    Component[] componentes1 = ((JLayeredPane)componentes[i]).getComponents();
                    for (int a = 0; a < componentes1.length; a++) {
                        if(componentes1[a] instanceof JRadioButton && ((JRadioButton)componentes1[a]).isSelected()){
                            componentMap.put(componentes1[a].getName(), componentes1[a]);
                        }
                        if(componentes1[a] instanceof JCheckBox && ((JCheckBox)componentes1[a]).isSelected()){
                            componentMap.put(componentes1[a].getName(), componentes1[a]);
                        }
                        if(componentes1[a] instanceof JTextField && !((JTextField)componentes1[a]).getText().isEmpty()){
                            componentMap.put(componentes1[a].getName(), componentes1[a]);
                        }
                    }
                }
            }
            generateXML(componentMap);
        } catch (Exception ex) {
            Logger.getLogger(EncuestaContexto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     /**
     * @param args the command line arguments
     */
    public static void generateXML(HashMap<String,Component> respuestas) throws Exception{
        String name = "RespuestasEncuestaContexto";
        String valor;
        if(respuestas.isEmpty()){
            System.out.println("ERROR empty ArrayList");
            return;
        }else{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, name, null);
            document.setXmlVersion("1.0");
 
            //Main Node
            Element raiz = document.getDocumentElement();
            Element itemNode = document.createElement("LISTA_RESPUESTAS"); 
            for(Map.Entry<String,Component> b: respuestas.entrySet()){
                Element keyNode = document.createElement("RESPUESTA"); 
                keyNode.setAttribute("name", b.getKey());
                if(b.getValue() instanceof JTextField){
                    valor = ((JTextField)b.getValue()).getText();
                }else{
                    valor = "1";
                }
                Text nodeKeyValue = document.createTextNode(valor);
                keyNode.appendChild(nodeKeyValue);      
                itemNode.appendChild(keyNode);
                raiz.appendChild(itemNode);
            }
            //Generate XML
            Source source = new DOMSource(document);
            //Indicamos donde lo queremos almacenar
            Result result = new StreamResult(new java.io.File("./xml/"+name+".xml")); //nombre del archivo
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
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
    private javax.swing.ButtonGroup buttonGroup_1;
    private javax.swing.ButtonGroup buttonGroup_2;
    private javax.swing.JButton jButton_Atras;
    private javax.swing.JButton jButton_Sigueinte;
    private javax.swing.JCheckBox jCheckBox_104;
    private javax.swing.JCheckBox jCheckBox_105;
    private javax.swing.JCheckBox jCheckBox_106;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane_1;
    private javax.swing.JLayeredPane jLayeredPane_2;
    private javax.swing.JLayeredPane jLayeredPane_3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField_107;
    private javax.swing.JRadioButton resp_100;
    private javax.swing.JRadioButton resp_101;
    private javax.swing.JRadioButton resp_102;
    // End of variables declaration//GEN-END:variables
}
