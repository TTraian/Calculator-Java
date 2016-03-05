import java.awt.Container;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Design extends JFrame {
	private JTextField input[];
	private JButton Suma, Produs, Exit;
	private JTextField rezultat;
	private JLabel label_input[], label_rezultat;
	private int N = 4;

	public Design() {
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Input panel
		input = new JTextField[N];
		label_input = new JLabel[N];
		JPanel jp1 = new JPanel();
		for (int i = 0; i < N; i++) {
			input[i] = new JTextField(7);
			label_input[i] = new JLabel((char) (0x0061 + i) + ""); // noteaza
																	// fiecare
																	// input cu
																	// necunoscute
																	// a,b..
			jp1.add(label_input[i]);
			jp1.add(input[i]);
		}

		// Result panel
		JPanel jp2 = new JPanel();
		label_rezultat = new JLabel("Rezultat");
		rezultat = new JTextField(7);
		rezultat.setEditable(false);
		jp2.add(label_rezultat);
		jp2.add(rezultat);

		// Button panel
		JPanel jp3 = new JPanel();
		Suma = new JButton("Sum");
		Produs = new JButton("Product");
		Exit = new JButton("Exit");
		jp3.add(Suma);
		jp3.add(Produs);
		jp3.add(Exit);

		// Final panel
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(3, 1)); // Setare Layout 3 linii o coloana
		jp.add(jp1);
		jp.add(jp2);
		jp.add(jp3);

		Container c = getContentPane();
		c.add(jp, "Center");

		sumaAction sa = new sumaAction();
		Suma.addActionListener(sa);
		productAction pa = new productAction();
		Produs.addActionListener(pa);
		exitAction ea = new exitAction();
		Exit.addActionListener(ea);

	}

	class sumaAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int s = 0;
			for (int i = 0; i < N; i++) {
				if (!input[i].getText().equals("")) {
					if (input[i].getText().matches("[0-9]+")) {
						s += Integer.parseInt(input[i].getText());
					}
				}
			}
			rezultat.setText(s + "");
		}
	}

	class productAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int p = 1;
			for (int i = 0; i < N; i++) {
				if (!input[i].getText().equals("")) {
					if (input[i].getText().matches("[0-9]+")) {
						p *= Integer.parseInt(input[i].getText());
					}
				}
			}
			rezultat.setText(p + "");
		}
	}

	class exitAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(1);
		}
	}
}
