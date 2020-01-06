package lesson1;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FrontPage extends JFrame {
	private static final long serialVersionUID = 6360512911863289692L;
	private JPanel contentPane;

	/**
	 * Create the panel.
	 */
	public FrontPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 150, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddAMovie = new JButton("Add a Movie");
		btnAddAMovie.setForeground(new Color(0, 128, 0));
		btnAddAMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DataEntry frame = new DataEntry();
				frame.setVisible(true);
			}
		});
		btnAddAMovie.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		btnAddAMovie.setBounds(133, 184, 180, 44);
		getContentPane().add(btnAddAMovie);
		
		JButton btnViewAMovie = new JButton("View a Movie");
		btnViewAMovie.setForeground(new Color(0, 128, 0));
		btnViewAMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchMovie searchMovie = new SearchMovie();
				searchMovie.setVisible(true);
			}
		});
		btnViewAMovie.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		btnViewAMovie.setBounds(133, 273, 180, 44);
		getContentPane().add(btnViewAMovie);
		
		JLabel lblMovieTicketReservation = new JLabel("Movie Ticket Reservation System");
		lblMovieTicketReservation.setForeground(new Color(30, 144, 255));
		lblMovieTicketReservation.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
		lblMovieTicketReservation.setBounds(72, 55, 345, 62);
		getContentPane().add(lblMovieTicketReservation);

	}

}
