package gui;

import java.awt.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.Window.Type;

public class TableFromDatabase extends JFrame
{

    public TableFromDatabase(String sql)
    {
    	setTitle("Demata");
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	setAlwaysOnTop(true);
    	setType(Type.POPUP);
        Vector columnNames = new Vector();
        Vector data = new Vector();

        try
        {
            //  Connect to an Access Database

Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			String url = "jdbc:mysql://83.212.112.80/foo";
			String username = "root";
			String pass = "1234";
			
			Connection connection = DriverManager.getConnection(url, username, pass);
			

            //  Read data from a table

           // String sql = "Select * from demata";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names

            for (int i = 1; i <= columns; i++)
            {
                columnNames.addElement( md.getColumnName(i) );
            }

            //  Get row data

            while (rs.next())
            {
                Vector row = new Vector(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.addElement( rs.getObject(i) );
                }

                data.addElement( row );
            }

            rs.close();
            stmt.close();
            connection.close();
        }
        catch(Exception e)
        {
            System.out.println( e );
        }

        //  Create table with database data

        JTable table = new JTable(data, columnNames)
        {
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };

        JScrollPane scrollPane = new JScrollPane( table );
        scrollPane.setSize(new Dimension(1280, 720));
        getContentPane().add( scrollPane );

        JPanel buttonPanel = new JPanel();
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
    }
/*
    
     public static void main(String[] args)
    {
        TableFromDatabase frame = new TableFromDatabase();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible(true);
    }*/
    
}
