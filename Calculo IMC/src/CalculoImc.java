import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculoImc extends JFrame {

	private JPanel contentPane;
	private JTextField txtPeso;
	private JTextField txtAltura;
	private JTextField txtImc;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculoImc frame = new CalculoImc();
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
	public CalculoImc() {
		setTitle("C\u00E1lculo IMC");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CalculoImc.class.getResource("/icones/imc.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(10, 31, 48, 14);
		contentPane.add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(48, 28, 96, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 79, 48, 14);
		contentPane.add(lblAltura);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(68, 76, 96, 20);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			limpar();
			}
		});
		btnLimpar.setIcon(new ImageIcon(CalculoImc.class.getResource("/icones/limpar.png")));
		btnLimpar.setBounds(298, 30, 78, 74);
		contentPane.add(btnLimpar);
		
		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(CalculoImc.class.getResource("/icones/tabela_imc.jpg")));
		lblStatus.setBounds(10, 166, 404, 200);
		contentPane.add(lblStatus);
		
		JButton btnCalcular = new JButton("");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			calcular();
			}
		});
		btnCalcular.setIcon(new ImageIcon(CalculoImc.class.getResource("/icones/imc.png")));
		btnCalcular.setBounds(210, 31, 78, 73);
		contentPane.add(btnCalcular);
		
		JLabel lblNewLabel_1 = new JLabel("IMC");
		lblNewLabel_1.setBounds(31, 104, 53, 23);
		contentPane.add(lblNewLabel_1);
		
		txtImc = new JTextField();
		txtImc.setBounds(20, 124, 64, 20);
		contentPane.add(txtImc);
		txtImc.setColumns(10);
	}
	//método para calcular o IMC
	private void calcular() {
		DecimalFormat formatador = new DecimalFormat("0.00");
		double peso, altura, imc;
		peso = Double.parseDouble(txtPeso.getText().replace(",", "."));
		altura = Double.parseDouble(txtAltura.getText().replace(",", "."));
		
		imc = peso /(altura*altura);
		txtImc.setText(formatador.format(imc));
		if (imc < 18.5) {
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/tabela_imc_abaixo.jpg")));
		} else if (imc >= 18.5 && imc < 25) {
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/tabela_imc_normal.jpg")));
		} else if (imc >= 25 && imc <30) {
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/tabela_imc_acima.jpg")));
		} else {
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/tabela_imc_obeso.jpg")));
		}
		
	}
	//limpar campos 
	private void limpar() {
		txtPeso.setText(null);
		txtAltura.setText(null);
		txtImc.setText(null);
		lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/tabela_imc.jpg")));
		
	}
	
}
