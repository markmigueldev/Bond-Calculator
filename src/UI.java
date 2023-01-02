import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField c;
	private JTextField p;
	private JTextField y;
	private JTextField r;
	private JTextField b;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		setTitle("Bond Price Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCoupon = new JLabel("Coupon Rate ($):");
		lblCoupon.setBounds(10, 11, 464, 30);
		contentPane.add(lblCoupon);
		
		c = new JTextField();
		c.setColumns(10);
		c.setBounds(10, 39, 464, 30);
		contentPane.add(c);
		
		JLabel lblParValue = new JLabel("Par Value ($):");
		lblParValue.setBounds(10, 80, 464, 30);
		contentPane.add(lblParValue);
		
		p = new JTextField();
		p.setColumns(10);
		p.setBounds(10, 108, 464, 30);
		contentPane.add(p);
		
		JLabel lblYearsToMaturity = new JLabel("Years to Maturity:");
		lblYearsToMaturity.setBounds(10, 149, 464, 30);
		contentPane.add(lblYearsToMaturity);
		
		y = new JTextField();
		y.setColumns(10);
		y.setBounds(10, 177, 464, 30);
		contentPane.add(y);
		
		JLabel lblNewInterestRate = new JLabel("New Interest Rate (%):");
		lblNewInterestRate.setBounds(10, 218, 464, 30);
		contentPane.add(lblNewInterestRate);
		
		r = new JTextField();
		r.setColumns(10);
		r.setBounds(10, 246, 464, 30);
		contentPane.add(r);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double coupon = Double.parseDouble(c.getText().trim());
					double par = Double.parseDouble(p.getText().trim());
					int years = Integer.parseInt(y.getText().trim());
					double rate = Double.parseDouble(r.getText().trim());
					
					Bonds bonds = new Bonds();
					double price = bonds.calculate(coupon, par, years, rate);
					b.setText(Double.toString(price));
					
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Input must be valid!");
				}
			}
		});
		btnNewButton.setBounds(10, 287, 130, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3_1 = new JLabel("Bond Price ($):");
		lblNewLabel_3_1.setBounds(10, 338, 464, 30);
		contentPane.add(lblNewLabel_3_1);
		
		b = new JTextField();
		b.setColumns(10);
		b.setBounds(10, 366, 464, 30);
		contentPane.add(b);
	}
}
