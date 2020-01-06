package lesson1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DataEntry extends JFrame {

	private static final long serialVersionUID = -7258524165172556865L;
	private JPanel contentPane;
	private JTextField name_field;
	private JTextField duration_field;
	private JTextField showdate_field;
	private JTextField starttime_field;
	private JTextField endtime_field;
	private JTextField audi_field;
	private JLabel label;
	private JLabel lblMovieName;
	private JLabel lblDuration;
	private JLabel lblShowDate;
	private JLabel lblStartTime;
	private JLabel lblEndTime;
	private JLabel auditorium_field;
	private JLabel lblDuration_1;
	private JButton btnHome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontPage frontPage = new FrontPage();
					frontPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException  {
		Class.forName("org.h2.Driver");
		Connection connection=DriverManager.getConnection("jdbc:h2:~/test","sa","sa");
		return connection;
	}

	/**
	 * Create the frame.
	 */
	public DataEntry() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 150, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		name_field = new JTextField();
		name_field.setBounds(180, 113, 193, 20);
		contentPane.add(name_field);
		name_field.setColumns(10);
		
		duration_field = new JTextField();
		duration_field.setBounds(182, 158, 137, 20);
		contentPane.add(duration_field);
		duration_field.setColumns(10);
		
		showdate_field = new JTextField();
		showdate_field.setBounds(182, 197, 137, 20);
		contentPane.add(showdate_field);
		showdate_field.setColumns(10);
		
		starttime_field = new JTextField();
		starttime_field.setBounds(184, 243, 64, 20);
		contentPane.add(starttime_field);
		starttime_field.setColumns(10);
		
		endtime_field = new JTextField();
		endtime_field.setBounds(362, 243, 64, 20);
		contentPane.add(endtime_field);
		endtime_field.setColumns(10);
		
		audi_field = new JTextField();
		audi_field.setBounds(184, 287, 135, 20);
		contentPane.add(audi_field);
		audi_field.setColumns(10);
		
		label = new JLabel("");
		label.setBounds(83, 347, 46, 14);
		contentPane.add(label);
		
		lblMovieName = new JLabel("Movie Name");
		lblMovieName.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblMovieName.setBounds(77, 111, 93, 20);
		contentPane.add(lblMovieName);
		
		lblDuration = new JLabel("Duration ");
		lblDuration.setBounds(67, 113, 46, -11);
		contentPane.add(lblDuration);
		
		lblShowDate = new JLabel("Show Date");
		lblShowDate.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblShowDate.setBounds(77, 198, 117, 14);
		contentPane.add(lblShowDate);
		
		lblStartTime = new JLabel("Start Time ");
		lblStartTime.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblStartTime.setBounds(77, 244, 106, 14);
		contentPane.add(lblStartTime);
		
		lblEndTime = new JLabel("End Time");
		lblEndTime.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblEndTime.setBounds(290, 244, 106, 14);
		contentPane.add(lblEndTime);
		
		auditorium_field = new JLabel("Auditorium");
		auditorium_field.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		auditorium_field.setBounds(77, 285, 117, 20);
		contentPane.add(auditorium_field);
		
		lblDuration_1 = new JLabel("Duration");
		lblDuration_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblDuration_1.setBounds(77, 155, 105, 23);
		contentPane.add(lblDuration_1);
		
		JButton btnSubmitDeatails = new JButton("Submit Deatails");
		btnSubmitDeatails.setForeground(new Color(0, 128, 0));
		btnSubmitDeatails.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnSubmitDeatails.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
				Connection connection = getConnection();
				String query="Insert into moviedata values(?,?,?,?,?,?)";
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setString(1,name_field.getText().toUpperCase());
				statement.setInt(2, Integer.parseInt(duration_field.getText()));
				statement.setString(3, showdate_field.getText());
				statement.setString(4, starttime_field.getText());
				statement.setString(5, endtime_field.getText());
				statement.setString(6, audi_field.getText());
				int success = statement.executeUpdate();
				if(success == 1) {
					JOptionPane.showMessageDialog(null,"Movie Added Successfully");
				}
				connection.close();
				
				
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
				
				
			}
		});
		btnSubmitDeatails.setBounds(136, 347, 206, 33);
		contentPane.add(btnSubmitDeatails);
		
		JLabel lblPleaseAddA = new JLabel("Please Add a Movie...");
		lblPleaseAddA.setForeground(new Color(30, 144, 255));
		lblPleaseAddA.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
		lblPleaseAddA.setBounds(126, 30, 234, 47);
		contentPane.add(lblPleaseAddA);
		
		btnHome = new JButton("Home");
		btnHome.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrontPage frontPage = new FrontPage();
				frontPage.setVisible(true);
			}
		});
		btnHome.setBounds(370, 11, 89, 23);
		contentPane.add(btnHome);
	}
}
