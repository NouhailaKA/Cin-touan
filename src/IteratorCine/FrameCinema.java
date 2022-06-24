package IteratorCine;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class FrameCinema extends JFrame{
	
	// S'agit de la première page ou l'utilisateur précise le nom de la cinéma

	protected static final String JOptionPanel = null;
	private JFrame frame;
	private JTextField textField;
	



	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCinema window = new FrameCinema();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameCinema() {
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 153, 102));
		frame.setBounds(100, 100, 682, 373);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cin\u00E9touan");
		lblNewLabel.setFont(new Font("Rage Italic", Font.BOLD, 45));
		lblNewLabel.setBounds(231, 92, 193, 47);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(148, 162, 303, 31);
		textField.setColumns(10);
		textField.setText(" Précisez une Cinéma ");
		textField.addFocusListener((FocusListener) new FocusListener(){
	        
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				textField.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			}
	    });
		
		frame.getContentPane().add(textField);
		
		JButton btnSearch = new JButton("");
		btnSearch.setBackground(new Color(255, 153, 102));
		btnSearch.setBounds(461, 162, 31, 31);
		ImageIcon image = new ImageIcon("C:\\Users\\ss\\eclipse-workspace\\Cinétouan\\src\\Ressources\\search2.png");
		Image icon = image.getImage();
		Image myImg = icon.getScaledInstance(25, 25,0);
		ImageIcon pro = new ImageIcon(myImg);
		btnSearch.setIcon(pro);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = textField.getText();
				if(t.equalsIgnoreCase("avenida") || t.equalsIgnoreCase("espanol")) {
					frame.dispose();
					new Accueil(t).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(frame,"Le nom de la Cinema invalid !!!"); 
				}
				
			}
		});

		frame.getContentPane().add(btnSearch);
	}
}
