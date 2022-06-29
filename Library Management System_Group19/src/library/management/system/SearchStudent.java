/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class SearchStudent extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTable table;
    private JTextField t1;
    JButton b1,b2;
    

    public static void main(String[] args) {
        new SearchStudent().setVisible(true);
    }

    public void searchStudent( String student_id) {
	try {
            conn con =  new conn();
            String sql = "select * from issueBook natural join student where student_id = ?";
            PreparedStatement st = con.c.prepareStatement(sql);
            st.setString(1, student_id);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));

	} catch (Exception e) {
			// TODO: handle exception
	}
    }


    public SearchStudent() {
        setBounds(400, 200, 810, 400);
	contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(40, 51, 708, 217);
	contentPane.add(scrollPane);

        table = new JTable();
	table.setBackground(new Color(224, 255, 255));
	table.setForeground(new Color(128, 128, 0));
	table.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	scrollPane.setViewportView(table);

//	JPanel panel = new JPanel();
//	panel.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Student-Details",
//				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 128)));
//	panel.setForeground(new Color(0, 128, 128));
//	panel.setBounds(26, 36, 737, 240);
//        panel.setBackground(Color.WHITE);
//	contentPane.add(panel);

	JLabel l1 = new JLabel("Back");
	l1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
		setVisible(false);
		Home home = new Home("");
		home.setVisible(true);
            }
	});
	l1.setForeground(new Color(204, 0, 102));
	l1.setFont(new Font("Tahoma", Font.BOLD, 18));
	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/tenth.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l1.setIcon(i3);
	l1.setBounds(690, 13, 96, 27);
	contentPane.add(l1);

//	JLabel l2 = new JLabel("Username : ");
//	l2.setBounds(124, 89, 95, 24);
//	contentPane.add(l2);
        
        t1 = new JTextField();
	t1.setForeground(new Color(47, 79, 79));
	t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t1.setBounds(174, 10, 156, 20);
	contentPane.add(t1);
	t1.setColumns(10);
        
        
        b1 = new JButton("Search");
	b1.addActionListener(this);
                
	b1.setForeground(new Color(46, 139, 87));
	b1.setBackground(new Color(250, 250, 210));
	b1.setBounds(350, 2, 113, 30);
	contentPane.add(b1);
        

    }
    
        public void actionPerformed(ActionEvent ae){
        try{
            
            if(ae.getSource() == b1){
                try{
		if(t1.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Shouldn't be Empty!!");
                }else{
                    searchStudent(t1.getText());
                }
                }catch(Exception e){
                    
                }
            }
            
//            if(ae.getSource() == b2){
//                this.setVisible(false);
//		new Home("").setVisible(true);		
//            }
        }catch(Exception e){
            
        }
    }
    
    
}