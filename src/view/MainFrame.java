package view;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import controller.MainController;
import model.Magazin;
import model.Produs;
import utils.MagazinListener;


public class MainFrame {
	

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
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
	JLabel lblProduse = new JLabel("Produse: 0");
	public MainFrame() {
		initialize();
		
		try {
			MainController.incarcaProduseDinDB();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Thread t = new Thread(){
			public void run(){
				while(true){
					int nr= Magazin.getInstance().getProduse().size();
					lblProduse.setText("Produse: "+nr);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
			t.start();
	}

	private DefaultListModel<Produs> model = new DefaultListModel<Produs>();
	private void initialize() {
		frame = 	new JFrame();
		frame.setBounds(100, 100, 450, 333);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 74, 360, 165);
		frame.getContentPane().add(scrollPane);
		
		final JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2){
					String s =JOptionPane.showInputDialog(frame,"Modifica pretul","Pret",JOptionPane.INFORMATION_MESSAGE);
					Double pretNou = Double.parseDouble(s);
					model.get(list.getSelectedIndex()).setPret(pretNou);
					
					try {
						MainController.modificaUnProdus(model.get(list.getSelectedIndex()).getDenumire(),pretNou);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		scrollPane.setViewportView(list);
		
		list.setModel(model);
		lblProduse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		lblProduse.setBounds(43, 243, 98, 19);
		frame.getContentPane().add(lblProduse);
		
		JLabel lblObserverPattern = new JLabel("Observer Pattern");
		lblObserverPattern.setFont(new Font("Traditional Arabic", Font.PLAIN, 16));
		lblObserverPattern.setBounds(149, 11, 167, 24);
		frame.getContentPane().add(lblObserverPattern);
		
		JLabel lblDenumireProdus = new JLabel("Lista de produse in Magazin");
		lblDenumireProdus.setBounds(41, 57, 214, 14);
		frame.getContentPane().add(lblDenumireProdus);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmAdaugaProdus = new JMenuItem("Adauga produs");
		mntmAdaugaProdus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AdaugaProdus window = new AdaugaProdus();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnFile.add(mntmAdaugaProdus);
		
		JMenuItem mntmIncarcaProduse = new JMenuItem("Reincarcare produse din DB");
		mntmIncarcaProduse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MainController.incarcaProduseDinDB();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnFile.add(mntmIncarcaProduse);
		
		
		
		Magazin.getInstance().addMagazinListener(
					new MagazinListener(){
						public void listaProduseModificata(){
							afisareProduse();
						}
					}
				);
	}
	
	public void afisareProduse(){
		 model.clear();
		 ArrayList<Produs> produse = Magazin.getInstance().getProduse();
		 for(Produs p:produse){
			 model.addElement(p);
		 }
	}
	
	
	
	
}
