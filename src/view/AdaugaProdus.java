package view;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Magazin;
import model.Produs;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AdaugaProdus {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	
	public AdaugaProdus() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 285, 157);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDenumireProdus = new JLabel("Denumire produs:");
		lblDenumireProdus.setBounds(31, 30, 91, 14);
		frame.getContentPane().add(lblDenumireProdus);
		
		JLabel lblPret = new JLabel("Pret:");
		lblPret.setBounds(31, 55, 46, 14);
		frame.getContentPane().add(lblPret);
		
		textField = new JTextField();
		textField.setBounds(132, 27, 109, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(132, 52, 109, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String denumire = textField.getText();
				double pret=0;
				try
				{
					pret = Double.parseDouble(textField_1.getText());
				}catch(NumberFormatException exc)
				{
					System.out.println("Pretul nu este valid"+exc);
					
				}

				Produs p = new Produs(denumire,pret);
				try{
					Magazin.getInstance().adaugaProdus(p);
					System.out.println("Produsul a fost adaugat! ("+p+")");
					}catch(Exception ex){
						System.out.println("Nu s-a putut adauga produsul "+ex);
					}
				frame.dispose();
			}
		});
		btnAdd.setBounds(152, 83, 89, 23);
		frame.getContentPane().add(btnAdd);
	}
}
