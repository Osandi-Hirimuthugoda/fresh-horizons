/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.managment;

import java.awt.Container;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author ASUS
 */
public class ReportView extends JFrame{
    
    public ReportView(String fileName) {
        this(fileName, null);
    }
    
    public ReportView(String fileName, HashMap para) {
        super("Report View");
        Connection con = DBUtil.getConnection();
        try {
            JasperPrint jp = JasperFillManager.fillReport(fileName, para, con);
            JRViewer jv = new JRViewer(jp);
            Container c = getContentPane();
            c.add(jv);
        } catch (JRException e) {
            System.out.println("Error jasper: " + e);
        }
        setBounds(2,2,900,700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
}
