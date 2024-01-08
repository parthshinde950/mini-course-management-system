import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.sql.*;

public class Data extends JFrame implements ActionListener {
    JButton BRefresh;
    JButton BBackPage;
    JTable table;
    String[] col = { "First Name", "Middle Name", "Last Name", "Birth Date", "Gender", "Mobile Number", "Address",
            "E-Mail", "Course" };
    String[][] data = new String[10][10];

    public static void main(String[] args) {
        Data d = new Data();
    }

    Data() {
        setLayout(null);

        BRefresh = new JButton("Read Data");
        BRefresh.setBounds(340, 50, 100, 20);
        BRefresh.addActionListener(this);
        add(BRefresh);

        BBackPage = new JButton("Back");
        BBackPage.setBounds(470, 50, 100, 20);
        BBackPage.addActionListener(this);
        add(BBackPage);

        setSize(1000, 700);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BRefresh) {
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection con = DriverManager.getConnection("jdbc:odbc:Student_Data");
                Statement st = con.createStatement();
                String sql = "select * from Detail";
                ResultSet rs = st.executeQuery(sql);
                
                int row = 0;
                while (rs.next()) {
                    int col = 0;
                    for (int i = 1; i <= 9; i++) {

                        data[row][col] = rs.getString(i) + "";
                        col++;
                    }
                    row++;
                }
                table = new JTable(data, col);
                JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                sp.setBounds(10, 100, 950, 500);
                add(sp);
            } catch (Exception ee) {
                System.out.println(ee);
            }
        } else if (e.getSource() == BBackPage) {
            dispose();
            Login l = new Login();

        }
    }
}
