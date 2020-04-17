package lesson1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class SearchMovie extends JFrame {
	private static final long serialVersionUID = 7620657701888600721L;
	private JPanel contentPane;
	private JTextField search_field;
	private JTextField search_name_field;
	private JTextField duration_field;
	private JTextField showdate_field;
	private JTextField starttime_field;
	private JTextField endtime_field;
	private JTextField auditorium_field;
	
	public void setUp(){
		int a=10;	
	}

	/**
	 * Create the panel.
	 */
	public SearchMovie() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 150, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTypeMovieWhich = new JLabel("Type Movie Name Which You Want To Find?");
		lblTypeMovieWhich.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblTypeMovieWhich.setBounds(25, 132, 304, 42);
		getContentPane().add(lblTypeMovieWhich);
		
		search_field = new JTextField();
		search_field.setBounds(320, 145, 113, 20);
		getContentPane().add(search_field);
		search_field.setColumns(10);
		
		JButton btnSubmit = new JButton("Search");
		btnSubmit.setForeground(new Color(0, 128, 0));
		btnSubmit.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DataEntry.getConnection();
					String query="select * from moviedata where NAME = (?)";
					PreparedStatement statement = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					statement.setString(1, search_field.getText().toUpperCase());
					ResultSet data = statement.executeQuery();
					if(data.next()==false) {
						JOptionPane.showMessageDialog(null,search_field.getText() + " is not found.");
					}
					else {
						data.beforeFirst();
						while(data.next()) {
							search_name_field.setText(data.getString(1));
							duration_field.setText(String.valueOf(data.getInt(2)));
							showdate_field.setText(data.getString(3));
							starttime_field.setText(data.getString(4));
							endtime_field.setText(data.getString(5));
							auditorium_field.setText(data.getString(6));
						}
					}
					con.close();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSubmit.setBounds(159, 203, 153, 32);
		getContentPane().add(btnSubmit);
		
		JLabel lblSearchAMovie = new JLabel("Search a Movie");
		lblSearchAMovie.setForeground(new Color(30, 144, 255));
		lblSearchAMovie.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
		lblSearchAMovie.setBounds(148, 45, 193, 45);
		getContentPane().add(lblSearchAMovie);
		
		search_name_field = new JTextField();
		search_name_field.setBounds(109, 287, 101, 20);
		getContentPane().add(search_name_field);
		search_name_field.setColumns(10);
		
		duration_field = new JTextField();
		duration_field.setBounds(109, 372, 64, 20);
		getContentPane().add(duration_field);
		duration_field.setColumns(10);
		
		showdate_field = new JTextField();
		showdate_field.setBounds(338, 287, 95, 20);
		getContentPane().add(showdate_field);
		showdate_field.setColumns(10);
		
		starttime_field = new JTextField();
		starttime_field.setBounds(109, 328, 64, 20);
		getContentPane().add(starttime_field);
		starttime_field.setColumns(10);
		
		endtime_field = new JTextField();
		endtime_field.setBounds(338, 328, 64, 20);
		getContentPane().add(endtime_field);
		endtime_field.setColumns(10);
		
		auditorium_field = new JTextField();
		auditorium_field.setBounds(338, 372, 64, 20);
		getContentPane().add(auditorium_field);
		auditorium_field.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblName.setBounds(36, 288, 46, 14);
		getContentPane().add(lblName);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblDuration.setBounds(36, 373, 59, 14);
		getContentPane().add(lblDuration);
		
		JLabel lblShowDate = new JLabel("Show Date");
		lblShowDate.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblShowDate.setBounds(254, 288, 75, 14);
		getContentPane().add(lblShowDate);
		
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblStartTime.setBounds(36, 329, 64, 14);
		getContentPane().add(lblStartTime);
		
		JLabel lblEndTime = new JLabel("End Time");
		lblEndTime.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblEndTime.setBounds(254, 329, 64, 14);
		getContentPane().add(lblEndTime);
		
		JLabel lblAuditorium = new JLabel("Auditorium");
		lblAuditorium.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblAuditorium.setBounds(254, 373, 75, 14);
		getContentPane().add(lblAuditorium);
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrontPage frontPage = new FrontPage();
				frontPage.setVisible(true);
			}
		});
		btnHome.setBounds(368, 21, 89, 23);
		contentPane.add(btnHome);

	}

}
