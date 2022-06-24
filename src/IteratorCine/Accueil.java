package IteratorCine;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import CompositeCine.Film;
import CompositeCine.PlanningCinema;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Accueil extends JFrame{

	private JFrame frmAccueil;
	private JTextField textField;
	private JTable table;
	private static String cinema;
	public static DefaultTableModel model1;

	/**
	 * Launch the application.
	 */
	public JFrame getFrame() {
		return frmAccueil;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil window = new Accueil();
					window.frmAccueil.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public void show() {
		
		this.frmAccueil.setVisible(true);
		
		if(cinema.equalsIgnoreCase("Avenida")) {
			AvenidaCinemaPlanning avenidaPlanning = new AvenidaCinemaPlanning();
			PlanningCinema avenidaCinema = new PlanningCinema();	
			OnlinePlanning Aplan = new OnlinePlanning(avenidaCinema);
			List<Film> a = Aplan.ListFilm(avenidaPlanning.createIterator());
			 for (int i = 0; i < a.size(); i++) {
				 	URL imageURL;
					try {
						imageURL = new URL(a.get(i).getPoster());
						Image img = java.awt.Toolkit.getDefaultToolkit().getDefaultToolkit().createImage(imageURL);
						Image myImg = img.getScaledInstance(100, 50,0);
						ImageIcon icon = new ImageIcon(myImg);
					    ((DefaultTableModel) table.getModel()).addRow(new Object[] {icon ,a.get(i).getTitle(),a.get(i).getDescription(),a.get(i).getType(),a.get(i).getDate(),a.get(i).getTime()});
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
			 
		}else if(cinema.equalsIgnoreCase("Espanol")) {
			EspanolCinemaPlanning espanolPlanning = new EspanolCinemaPlanning();
			PlanningCinema espanolCinema = 	new PlanningCinema();
			OnlinePlanning Eplan = new OnlinePlanning(espanolCinema);
			List<Film> a = Eplan.ListFilm(espanolPlanning.createIterator());
			 for (int i = 0; i < a.size(); i++) {
				 URL imageURL;
					try {
						imageURL = new URL(a.get(i).getPoster());
						Image img = java.awt.Toolkit.getDefaultToolkit().getDefaultToolkit().createImage(imageURL);
						Image myImg = img.getScaledInstance(100, 50,0);
						ImageIcon icon = new ImageIcon(myImg);
					    ((DefaultTableModel) table.getModel()).addRow(new Object[] {icon ,a.get(i).getTitle(),a.get(i).getDescription(),a.get(i).getType(),a.get(i).getDate(),a.get(i).getTime()});
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
		}
	
	}
	
	public Accueil() {
		initialize();
		show();	
	}
	
	public Accueil(String cinema) {
		this.cinema = cinema;
		initialize();
		System.out.println(this.cinema);
		FeedBack op = new FeedBack();
		Thread t = new Thread(op);
		t.start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAccueil = new JFrame();
		frmAccueil.setTitle("Cin\u00E9touan");
		frmAccueil.setBounds(100, 100, 698, 412);
		frmAccueil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccueil.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 102));
		panel.setBounds(0, 0, 682, 373);
		panel.setLayout(null);
		frmAccueil.getContentPane().add(panel);
		
		
		textField = new JTextField();
		textField.setBounds(165, 100, 223, 27);
		textField.setColumns(10);
		textField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				Search(textField.getText());
			}
			
		});
		panel.add(textField);
		
		
		JLabel lblNewLabel = new JLabel("Cin\u00E9touan");
		lblNewLabel.setFont(new Font("Rage Italic", Font.BOLD, 40));
		lblNewLabel.setBounds(22, 11, 170, 40);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(102, 102, 102));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search(textField.getText());
			}
		});
		btnNewButton.setBounds(411, 98, 97, 27);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 146, 546, 216);
		panel.add(scrollPane);
		
		table = new JTable() {
			
			public Class getColumnClass(int column) {
		        return (column == 0) ? Icon.class : Object.class;
		      }
		};
		table.setForeground(new Color(255, 255, 255));
		table.setBackground(new Color(0, 0, 0));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Poste", "Titre", "Description", "Type", "Date", "Time"
			}
			
		));
		table.setRowHeight(100);
		
		scrollPane.setViewportView(table);
		
		JLabel lblCinema = new JLabel(cinema);
		lblCinema.setFont(new Font("Stencil", Font.PLAIN, 20));
		lblCinema.setBounds(269, 56, 145, 33);
		panel.add(lblCinema);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(new Color(255, 153, 102));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAccueil.dispose();
				new FrameCinema().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(630, 11, 42, 27);
		ImageIcon image = new ImageIcon("C:\\Users\\ss\\eclipse-workspace\\Cinétouan\\src\\Ressources\\back2.jpg");
		Image icon = image.getImage();
		Image myImg = icon.getScaledInstance(42, 27,0);
		ImageIcon pro = new ImageIcon(myImg);
		btnNewButton_1.setIcon(pro);
		panel.add(btnNewButton_1);
	}
	
	public void Search(String str) 
	{
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter <>(model);
		table.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
}

class FeedBack implements Runnable {

	Accueil f = new Accueil();
	
	@Override
	public void run() {
		Object result;
		// TODO Auto-generated method stub
		do {
			result = JOptionPane.showInputDialog(f.getFrame(), "Veuillez donner votre avis à propos notre application :");
			System.out.println(result);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(result != null) {
				 try {
				      FileWriter myWriter = new FileWriter("C:\\Users\\ss\\eclipse-workspace\\Cinétouan\\src\\Ressources\\FeedBack.txt", true);
				      myWriter.write("\n Avis utilisateur : "+(String)result);
				      myWriter.close();
				      System.out.println("Successfully wrote to the file.");
				    } catch (IOException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				    }
			}
		}while(result == null);		
	}
	
}
