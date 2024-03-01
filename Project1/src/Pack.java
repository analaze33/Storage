import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;

public class Pack {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pack window = new Pack();
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
	public Pack() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1281, 760);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(71, 133, 336, 301);
		panel_1.setBorder(new LineBorder(Color.BLUE, 3, true));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Food");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(28, 29, 115, 30);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Drinks");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(28, 126, 115, 30);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Dessert");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(28, 220, 127, 30);
		panel_1.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(166, 70, 141, 30);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(166, 167, 141, 30);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(166, 260, 141, 30);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select a drink", "Cola", "Coffee", "Orange Juice"}));
		comboBox.setBounds(28, 166, 115, 30);
		panel_1.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select a food", "Soup ", "Pizza", "Pasta"}));
		comboBox_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		comboBox_1.setBounds(28, 69, 115, 30);
		panel_1.add(comboBox_1);
		
		
		
		
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Select a dessert", "Cheesecake", "Chocolate Mousse", "Ice Cream"}));
		comboBox_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		comboBox_2.setBounds(28, 260, 115, 30);
		panel_1.add(comboBox_2);
		
		JLabel lblNewLabel = new JLabel("Qty");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(166, 29, 127, 26);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("Qty");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(166, 126, 127, 26);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Qty");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(165, 220, 128, 26);
		panel_1.add(lblNewLabel_6);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(28, 114, 279, 2);
		panel_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(28, 212, 279, 2);
		panel_1.add(separator_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(71, 481, 336, 140);
		panel_3.setBorder(new LineBorder(Color.BLUE, 3, true));
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Cost of food");
		lblNewLabel_7.setBounds(21, 23, 122, 24);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Cost of drinks");
		lblNewLabel_8.setBounds(21, 58, 122, 24);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Cost of dessert");
		lblNewLabel_9.setBounds(21, 92, 132, 24);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_3.add(lblNewLabel_9);
		
		textField = new JTextField();
		textField.setBounds(173, 23, 141, 24);
		panel_3.add(textField);
		textField.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(173, 58, 141, 24);
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(173, 92, 141, 24);
		panel_3.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(441, 320, 336, 301);
		panel_4.setBorder(new LineBorder(Color.BLUE, 3, true));
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_13 = new JLabel("Customer Info");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setBounds(94, 23, 148, 34);
		panel_4.add(lblNewLabel_13);
		
		JLabel lblNewLabel_11_1 = new JLabel("Customer Name");
		lblNewLabel_11_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_11_1.setBounds(20, 82, 153, 26);
		panel_4.add(lblNewLabel_11_1);
		
		JLabel lblNewLabel_11_2 = new JLabel("Phone Number");
		lblNewLabel_11_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_11_2.setBounds(20, 150, 135, 26);
		panel_4.add(lblNewLabel_11_2);
		
		JLabel lblNewLabel_11_3 = new JLabel("Email");
		lblNewLabel_11_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_11_3.setBounds(20, 216, 109, 26);
		panel_4.add(lblNewLabel_11_3);
		
		textField_9 = new JTextField();
		textField_9.setToolTipText("");
		textField_9.setForeground(new Color(0, 0, 0));
		textField_9.setBounds(20, 118, 135, 26);
		panel_4.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(173, 118, 135, 26);
		panel_4.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setToolTipText("");
		textField_11.setForeground(Color.BLACK);
		textField_11.setColumns(10);
		textField_11.setBounds(20, 186, 135, 26);
		panel_4.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setToolTipText("");
		textField_12.setForeground(Color.BLACK);
		textField_12.setColumns(10);
		textField_12.setBounds(20, 252, 135, 26);
		panel_4.add(textField_12);
		
		JLabel lblNewLabel_11_2_1 = new JLabel("Adress");
		lblNewLabel_11_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_11_2_1.setBounds(173, 150, 135, 26);
		panel_4.add(lblNewLabel_11_2_1);
		
		textField_13 = new JTextField();
		textField_13.setToolTipText("");
		textField_13.setForeground(Color.BLACK);
		textField_13.setColumns(10);
		textField_13.setBounds(173, 186, 135, 26);
		panel_4.add(textField_13);
		
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(820, 133, 356, 488);
		panel_5.setBorder(new LineBorder(Color.BLUE, 3, true));
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Food Ordering System");
		lblNewLabel_1.setBounds(330, 44, 576, 79);
		lblNewLabel_1.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 50));
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(441, 133, 336, 140);
		frame.getContentPane().add(panel_2);
		panel_2.setBorder(new LineBorder(Color.BLUE, 3, true));
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Tax");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_10.setBounds(25, 23, 109, 26);
		panel_2.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Subtotal");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_11.setBounds(25, 62, 109, 26);
		panel_2.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Total");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_12.setBounds(25, 101, 109, 26);
		panel_2.add(lblNewLabel_12);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(134, 23, 141, 26);
		panel_2.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(134, 62, 141, 26);
		panel_2.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(134, 101, 141, 26);
		panel_2.add(textField_8);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(36, 30, 1197, 683);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(37, 10, 87, 28);
		frame.getContentPane().add(panel);
		
		
	}
}
