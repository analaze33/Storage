package Project;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Frame1{
	Connection con = null;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_1;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_2;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_3;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JLabel lblNewLabel_20;
	private JLabel lblNewLabel_21;
	private JLabel lblNewLabel_22;
	private JLabel lblNewLabel_23;
	private JTextField choose_quantity;
	@SuppressWarnings("rawtypes")
	private JComboBox select_item_box;
	private JTextPane textPane;
	private JTextPane textPane_2;
	private JTextPane textPane_1;
	
	
	
	// main order items variables initialisation
	
	private String food_chosen;
	private int food_qty;
	private static double soup_price = 5.00;
	private static double pizza_price = 9.99;
	private static double pasta_price = 6.34;
	private String drink_chosen;
	private int drink_qty;
	private static double cola_price = 10.99;
	private static double coffee_price = 7.99;
	private static double juice_price = 10.99;
	private String dessert_chosen;
	private int dessert_qty;
	private static double donut_price = 4.55;
	private static double muffin_price = 5.67;
	private static double cake_price = 5.99;

    // END main order items variables initialisation

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
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
	public Frame1() {
		
		initialize();
		con = DBConnection.connect();
		
		
	}
	// method that returns the id of the item selected
	public static int convertItemToId(String item) {
		int result;
		switch(item) {
		case "Soup":
			result = 1;
			break;
		case "Pizza":
			result = 2;
			break;
		case "Pasta":
			result = 3;
			break;
		case "Cola":
			result = 4;
			break;
		case "Coffee":
			result = 5;
			break;
		case "Juice":
			result = 6;
			break;
		case "Cake":
			result = 7;
			break;
		case "Muffin":
			result = 8;
			break;
		case "Donut":
			result = 9;
			break;
		default:
			result = 10;
			}
		return result;	
	
	}
	
	// END method that returns the id of the item selected
	
	// method that returns the price of the item selected
	public static double getItemPrice(String item) {
		double result = 0;
		switch(item) {
		
	    case "Soup":
	    	result = soup_price;
	    	break;
	    case "Pizza":
	    	result = pizza_price;
	    	break;
	    case "Pasta":
	    	result = pasta_price;
	    	break;
	    
	    case "Cola":
	    	result = cola_price;
	    	break;
	    case "Coffee":
	    	result = coffee_price;
	    	break;
	    case "Juice":
	    	result = juice_price;
	    	break;
	    
	    case "Donut":
	    	result = donut_price;
	    	break;
	    case "Cake":
	    	result = cake_price;
	    	break;
	    case "Muffin":
	    	result = muffin_price;
	    	break;
	    case "-":
	    	result = 0;
	    	break;
	    default:
	    	result = -1;
		}
		return result;
	}
	
	// END method that returns the price of the item selected

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1317, 766);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
//-------------------------------------PART 1-------------------------------------------------		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 46, 1235, 647);
		frame.getContentPane().add(tabbedPane);

//----------------------------------ITEM REGISTRATION PANEL-------------------------------------
		JPanel panel = new JPanel();
		tabbedPane.addTab("Item registration", null, panel, null);
		panel.setLayout(null);

//----------------------------------------------------------------------------------------------
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 255), 7));
		panel_9.setForeground(new Color(0, 0, 255));
		panel_9.setBounds(92, 37, 1014, 508);
		panel.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblItemRegistrationSystem = new JLabel("Quantity Registration System");
		lblItemRegistrationSystem.setBounds(218, 43, 576, 79);
		panel_9.add(lblItemRegistrationSystem);
		lblItemRegistrationSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemRegistrationSystem.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 40));
		
//---------------------------------------SELECT ITEM BOX----------------------------------------------------
		
		select_item_box = new JComboBox();
	    select_item_box.addActionListener(new ActionListener() {                               
	    	public void actionPerformed(ActionEvent e) {
	    		try {
	 
	    			String selected_item = (String)select_item_box.getSelectedItem(); 
	    			
	    			//converts item we have chosen which is stored in selected_item variable into its respective id	and saves it into another variable			
	    			int id = convertItemToId(selected_item);
			        
					String q1 = "SELECT * FROM items WHERE ID = '" +id+"'";
					
					// this SQL statement is stored into this PreparedStatement object and it makes possible the statement to execute multiple times
					PreparedStatement pst1 = con.prepareStatement(q1);
					
					// through this statement that queries the database we generate the table of data representing the a database ResultSet 
					ResultSet rs = pst1.executeQuery();
					
					
					int qty = 0;
					
					while(rs.next()) {
						qty = rs.getInt("qty"); 
					}
					
					String qty1 = Integer.toString(qty);
					choose_quantity.setText(qty1);
					
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
	    	}
	    });
		select_item_box.setFont(new Font("Lucida Sans", Font.BOLD, 22));
		select_item_box.setBounds(102, 150, 240, 60);
		panel_9.add(select_item_box);
		select_item_box.setModel(new DefaultComboBoxModel(new String[] {"       Select item", "Soup", "Pizza", "Pasta", "Cola", "Coffee", "Juice", "Cake", "Muffin", "Donut"}));
		
//-------------------------------------------------------------------------------------------------------------------------------------------		
		
		JLabel qtylbl1 = new JLabel("Quantity");
		qtylbl1.setFont(new Font("Tahoma", Font.BOLD, 22));
		qtylbl1.setBounds(504, 167, 170, 27);
		panel_9.add(qtylbl1);

//-------------------------------------------------------------------------------------------------------------------------------------------
		
		choose_quantity = new JTextField();
		choose_quantity.setFont(new Font("Tahoma", Font.BOLD, 15));
		choose_quantity.setBounds(684, 163, 170, 44);
		panel_9.add(choose_quantity);
		choose_quantity.setColumns(10);
		
//---------------------------------------------UPDATES THE QUANTITY OF THE TABLE FOR THE ITEM WHICH IS SELECTED-------------------------------		
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String selected_item = (String)select_item_box.getSelectedItem();//variable which stores the value of the selected item
				
				//converts the item to its id
				int id = convertItemToId(selected_item);
				
				//query which will update the quantity of the item with the selected id
				String q1 = "UPDATE items SET qty = '"+choose_quantity.getText()+"' WHERE ID = '" +id+"'";
				
				PreparedStatement pst1 = con.prepareStatement(q1);
				pst1.execute();
				JOptionPane.showMessageDialog(null, "Quantity was updated");
				
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnUpdate.setVerticalAlignment(SwingConstants.TOP);
		btnUpdate.setFont(new Font("Sitka Small", Font.BOLD, 26));
		btnUpdate.setBounds(402, 338, 151, 32);
		panel_9.add(btnUpdate);
		
		
		//-----------------------------------------PART 2-------------------------------------------------------	
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Food ordering", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Food Ordering System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 60));
		lblNewLabel.setBounds(122, 10, 847, 97);
		panel_1.add(lblNewLabel);
        //----------------------------------------------------------------------------------------------------------		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(Color.BLUE, 3, true));
		panel_2.setBounds(36, 88, 336, 286);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Food");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(28, 10, 115, 30);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Drinks");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(28, 111, 115, 30);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Dessert");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(28, 207, 127, 30);
		panel_2.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {  //Java prog#140. How to make textfield that only accepts numbers
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		textField.setColumns(10);
		textField.setBounds(166, 50, 141, 30);
		panel_2.add(textField);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(166, 151, 141, 30);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)) {
					e.consume();
				}
				
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(166, 247, 141, 30);
		panel_2.add(textField_2);
		
	   comboBox_1 = new JComboBox();
	   comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select a food", "Soup", "Pizza", "Pasta"}));
	   comboBox_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
	   comboBox_1.setBounds(28, 50, 115, 30);
	   panel_2.add(comboBox_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Select a drink", "Cola", "Coffee", "Juice"}));
		comboBox_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		comboBox_2.setBounds(28, 151, 115, 30);
		panel_2.add(comboBox_2);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Select a dessert", "Cake", "Muffin", "Donut"}));
		comboBox_3.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		comboBox_3.setBounds(28, 247, 127, 30);
		panel_2.add(comboBox_3);
		
		JLabel lblNewLabel_2 = new JLabel("Qty");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(166, 13, 127, 26);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Qty");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(166, 114, 127, 26);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Qty");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(165, 210, 128, 26);
		panel_2.add(lblNewLabel_6);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(28, 95, 279, 2);
		panel_2.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(28, 195, 279, 2);
		panel_2.add(separator_1);
//------------------------------------------------------------------------------------------------		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(Color.BLUE, 3, true));
		panel_3.setBounds(36, 384, 336, 140);
		panel_1.add(panel_3);
		
		JLabel lblNewLabel_7 = new JLabel("Cost of food");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_7.setBounds(21, 23, 122, 24);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Cost of drink");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_8.setBounds(21, 58, 122, 24);
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Cost of dessert");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_9.setBounds(21, 92, 132, 24);
		panel_3.add(lblNewLabel_9);
		
	    lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setBounds(184, 23, 122, 22);
		lblNewLabel_18.setBorder(new LineBorder(Color.BLUE, 1, true));
		panel_3.add(lblNewLabel_18);
		
		lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setBounds(184, 58, 122, 22);
		lblNewLabel_19.setBorder(new LineBorder(Color.BLUE, 1, true));
		panel_3.add(lblNewLabel_19);
		
		lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.setBounds(184, 92, 122, 24);
		lblNewLabel_20.setBorder(new LineBorder(Color.BLUE, 1, true));
		panel_3.add(lblNewLabel_20);
		
		
	//-----------------------------------------------------------------------------------------------	
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(Color.BLUE, 3, true));
		panel_4.setBounds(434, 88, 336, 125);
		panel_1.add(panel_4);
		
		JLabel lblNewLabel_10 = new JLabel("Tax");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_10.setBounds(25, 10, 109, 26);
		panel_4.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Subtotal");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_11.setBounds(25, 46, 109, 26);
		panel_4.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Total");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_12.setBounds(25, 82, 109, 26);
		panel_4.add(lblNewLabel_12);
		
		lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setBounds(144, 14, 122, 22);
		lblNewLabel_21.setBorder(new LineBorder(Color.BLUE, 1, true));
		panel_4.add(lblNewLabel_21);
		
		lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setBounds(144, 46, 122, 22);
		lblNewLabel_22.setBorder(new LineBorder(Color.BLUE, 1, true));
		panel_4.add(lblNewLabel_22);
		
		lblNewLabel_23 = new JLabel("");
		lblNewLabel_23.setBounds(144, 82, 122, 22);
		lblNewLabel_23.setBorder(new LineBorder(Color.BLUE, 1, true));
		panel_4.add(lblNewLabel_23);
		
		
	//-----------------------------------------------------------------------------------------	
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new LineBorder(Color.BLUE, 3, true));
		panel_5.setBounds(434, 223, 336, 301);
		panel_1.add(panel_5);
		
		JLabel lblNewLabel_13 = new JLabel("Customer Info");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_13.setBounds(94, 23, 148, 34);
		panel_5.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Customer Name");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_14.setBounds(20, 82, 153, 26);
		panel_5.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Phone Number");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_15.setBounds(20, 150, 135, 26);
		panel_5.add(lblNewLabel_15);
		
		JLabel lblNewLabel_17 = new JLabel("Email");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_17.setBounds(20, 216, 109, 26);
		panel_5.add(lblNewLabel_17);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("");
		textField_3.setForeground(Color.BLACK);
		textField_3.setColumns(10);
		textField_3.setBounds(20, 118, 135, 26);
		panel_5.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(173, 118, 135, 26);
		panel_5.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setToolTipText("");
		textField_5.setForeground(Color.BLACK);
		textField_5.setColumns(10);
		textField_5.setBounds(20, 186, 135, 26);
		panel_5.add(textField_5);
		
		textField_7 = new JTextField();
		textField_7.setToolTipText("");
		textField_7.setForeground(Color.BLACK);
		textField_7.setColumns(10);
		textField_7.setBounds(20, 252, 135, 26);
		panel_5.add(textField_7);
		
		JLabel lblNewLabel_16 = new JLabel("Address");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_16.setBounds(173, 150, 135, 26);
		panel_5.add(lblNewLabel_16);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("");
		textField_6.setForeground(Color.BLACK);
		textField_6.setColumns(10);
		textField_6.setBounds(173, 186, 135, 26);
		panel_5.add(textField_6);
	//-------------------------------------------------------------------------------------------	
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(Color.WHITE, 3, true));
		panel_6.setBounds(830, 88, 268, 436);
		panel_1.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(0, 0, 268, 436);
		panel_6.add(panel_7);
		panel_7.setLayout(null);
		
	    textPane_1 = new JTextPane();
		textPane_1.setBounds(0, 0, 268, 277);
		panel_7.add(textPane_1);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Lucida Handwriting", Font.BOLD, 15));
		textPane.setBounds(0, 270, 268, 51);
		panel_7.add(textPane);
		
		textPane_2 = new JTextPane();
		textPane_2.setBounds(0, 321, 268, 115);
		panel_7.add(textPane_2);
		

	//----------------------------------------TOTAL BUTTON CLICK------------------------------------------------------------------	
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(Color.BLUE, 3));
		panel_8.setBounds(36, 544, 1062, 50);
		panel_1.add(panel_8);
		panel_8.setLayout(null);
		
		JButton Button = new JButton("Total");
		Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				if(!textField.getText().equals("")||!textField_1.getText().equals("")||!textField_2.getText().equals("")) {
					if(!textField.getText().equals("")) {
						food_qty = Integer.parseInt(textField.getText());//get food quantity
						food_chosen = (String) comboBox_1.getSelectedItem();//get selected food
						if(food_chosen.equals("Soup")) {
							double soup_cost = soup_price * food_qty; 
							String cost_soup = String.format("%.2f", soup_cost);
							lblNewLabel_18.setText(cost_soup);
						}
					    if(food_chosen.equals("Pizza")) {
					    	double pizza_cost = pizza_price * food_qty;
					    	String cost_pizza = String.format("%.2f", pizza_cost);
							lblNewLabel_18.setText(cost_pizza);
						}
						if(food_chosen.equals("Pasta")) {
							double pasta_cost = pasta_price * food_qty;
							String cost_pasta = String.format("%.2f", pasta_cost);
							lblNewLabel_18.setText(cost_pasta);
						}
						
						} else {
							food_qty = 0;
							food_chosen = "-";
							double food_cost_1 = 0;
							lblNewLabel_18.setText(Double.toString(food_cost_1));
						}
						
					if(!textField_1.getText().equals("")) {
					    drink_qty = Integer.parseInt(textField_1.getText());//get drink quantity
						drink_chosen = (String) comboBox_2.getSelectedItem();//get selected food
						if(drink_chosen.equals("Cola")) {
							double cola_cost = cola_price * drink_qty; 
							String cost_cola = String.format("%.2f", cola_cost);
							lblNewLabel_19.setText(cost_cola);
						}
					    if(drink_chosen.equals("Coffee")) {
					    	double coffee_cost = coffee_price * drink_qty;
					    	String cost_coffee = String.format("%.2f", coffee_cost);
							lblNewLabel_19.setText(cost_coffee);
						}
						if(drink_chosen.equals("Juice")) {
							double juice_cost = juice_price * drink_qty;
							String cost_juice = String.format("%.2f", juice_cost);
							lblNewLabel_19.setText(cost_juice);
						}
						
						}else {
							drink_qty = 0;
							drink_chosen = "-";
							double drink_cost_1 = 0;
							lblNewLabel_19.setText(Double.toString(drink_cost_1));
							
						}
					
						
					if(!textField_2.getText().equals("")) {
					    dessert_qty = Integer.parseInt(textField_2.getText());//get dessert quantity
					    dessert_chosen = (String) comboBox_3.getSelectedItem();//get selected dessert
					    if(dessert_chosen.equals("Cake")) {
							double cake_cost = cake_price * dessert_qty; 
							String cost_cake = String.format("%.2f", cake_cost);
							lblNewLabel_20.setText(cost_cake);
						}
					    if(dessert_chosen.equals("Muffin")) {
					    	double muffin_cost = muffin_price * dessert_qty;
					    	String cost_muffin = String.format("%.2f", muffin_cost);
							lblNewLabel_20.setText(cost_muffin);
						}
						if(dessert_chosen.equals("Donut")) {
							double donut_cost = donut_price * dessert_qty;
							String cost_donut = String.format("%.2f", donut_cost);
							lblNewLabel_20.setText(cost_donut);
						}
					    
					} else {
					    dessert_qty = 0;
					    dessert_chosen = "-";
						double dessert_cost_1 = 0;
						lblNewLabel_20.setText(Double.toString(dessert_cost_1));
						
						}
  //------------------------------------TAX   SUBTOTAL  TOTAL-----------------------------------------------------------------------------------------
					
					double cFood = Double.parseDouble(lblNewLabel_18.getText());//get cost of food
					
					double cDrinks = Double.parseDouble(lblNewLabel_19.getText());//get cost of drink
					
					double cDessert = Double.parseDouble(lblNewLabel_20.getText());//get cost of dessert
					
					double sub_total = cFood+cDrinks+cDessert;//sum of the costs which equals subTotal
					
					double tax = (sub_total)*8.45/100;//multiplied by the fixed tax rate
					
					String Tax = String.format("%.2f", tax);
					
					lblNewLabel_21.setText(Tax);
					
					String Sub_total = String.format("%.2f", sub_total);
					
					lblNewLabel_22.setText(Sub_total);
					
					double total = tax +sub_total;//finds the total
					
					String Total = String.format("%.2f", total);
					
					lblNewLabel_23.setText(Total);
					
					
					
					LocalDateTime orderDateObj = LocalDateTime.now();
					DateTimeFormatter orderDateFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					DateTimeFormatter orderTimeFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");

					String orderDate = orderDateObj.format(orderDateFormatObj);
					String orderTime = orderDateObj.format(orderTimeFormatObj);
					
					//https://howtodoinjava.com/java/date-time/java8-datetimeformatter-example/
					
					textPane_1.setText("\n\tRESTAURANT AND BAR"
							+ "\n\t           Albania,AL"
							+ "\n\t      1234 Main Street"
							+ "\n\t     Tel: 650-309-1992"
							+ "\n\t      Date: " + orderDate
							+ "\n\t       Time: " + orderTime
							+ "\n\n *************************************************** \n\n   ");
						
						if(!textField.getText().equals("")) {
							
						    textPane_1.setText(textPane_1.getText()+food_qty+"     "+ food_chosen + "\t\t                  $"+cFood+ "\n   ");
								
					    }else {
					    	textPane_1.setText(textPane_1.getText());
					    }
						if(!textField_1.getText().equals("")) {
							
							
							textPane_1.setText(textPane_1.getText()+drink_qty+"     "+ drink_chosen + "\t\t                  $"+cDrinks+ "\n   ");
						   
					    }else {
					    	textPane_1.setText(textPane_1.getText());
					    	
					    }
						if(!textField_2.getText().equals("")) {
							
							
							textPane_1.setText(textPane_1.getText()+dessert_qty+"     "+ dessert_chosen + "\t\t                  $"+cDessert+ "\n   ");
						   
					    }else {
					    	textPane_1.setText(textPane_1.getText());
						}
						
						textPane_1.setText(textPane_1.getText()+"\n   TAX"+"\t\t                  $"+Tax 
								+"\n   SUB-TOTAL"+"\t                  $"+Sub_total
								+" ***************************************************    ");
						textPane.setText("\n   TOTAL"+"\t\t      $"+Total);
						textPane_2.setText(" ***************************************************    "
								+ "\n\n           A 20% service charge has been \n\tapplied to the bill. "
								+ "\n    Thank you for supporting online businesses!");
					
					
				}else {
					JOptionPane.showMessageDialog(null, "At least one item should be chosen!");
				}
			    
			}
			
		});
		Button.setFont(new Font("Tahoma", Font.BOLD, 17));
		Button.setBounds(198, 10, 110, 30);
		panel_8.add(Button);
		
		JButton btnSubmitOrder = new JButton("Submit Order!");
		btnSubmitOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String total = lblNewLabel_23.getText();
				
				if (total.equals("")) {
				JOptionPane.showMessageDialog(null, "Press total button then receipt");
					
				}
				else {
					try {	
						if(textField_3.getText().equals("") || textField_4.getText().equals("") || textField_5.getText().equals("")
						  || textField_6.getText().equals("") || textField_7.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Please ensure to fill out all necessary informations!");
						}
						
						else {	
						String new_order_query = "INSERT INTO orders ("
								+ " `customer_name`, `customer_surname`, `customer_phone`, `customer_address`, `customer_email`,"
								+ " `food_name`, `food_price`, `food_qty`, "
								+ "`drink_name`, `drink_price`, `drink_qty`, "
								+ "`dessert_name`, `dessert_price`, `dessert_qty`) "
								+ "VALUES ( '"+textField_3.getText()+"', '"+textField_4.getText()+ "', '"+textField_5.getText()+"',"
										+ "'"+textField_6.getText()+"', '"+textField_7.getText()+"'"
								+ ", '"+food_chosen+"', '"+getItemPrice(food_chosen)+"', '"+food_qty+"', "
								+ "'"+drink_chosen+"', '"+getItemPrice(drink_chosen)+"', '"+drink_qty+"', '"+dessert_chosen+"'"
								+ ", '"+getItemPrice(dessert_chosen)+"', '"+dessert_qty+"')";
					    PreparedStatement pst3 = con.prepareStatement(new_order_query);                        
					    pst3.execute();
					    
					    String get_items_query = "SELECT * FROM items";
					    PreparedStatement pst4 = con.prepareStatement(get_items_query);
					    ResultSet rs = pst4.executeQuery();
					    
					    int db_food_qty = 0;
					    int db_drink_qty = 0;
					    int db_dessert_qty = 0;
					    
					    while(rs.next()) {
					    	
					    	if(rs.getString("name").equals(food_chosen)) {
					    		db_food_qty = rs.getInt("qty");
					    	} else if (rs.getString("name").equals(drink_chosen)) {
					    		db_drink_qty = rs.getInt("qty");
					    	} else if (rs.getString("name").equals(dessert_chosen)) {
					    		db_dessert_qty = rs.getInt("qty");
					    	}
					    	
					    }
					    
					    int updated_food_qty = db_food_qty - food_qty;
					    int updated_drink_qty = db_drink_qty - drink_qty;
					    int updated_dessert_qty = db_dessert_qty - dessert_qty;
					   
					    
					    if(updated_food_qty <= 10 && updated_food_qty != 0) {
					    	JOptionPane.showMessageDialog(null, "Warning " + food_chosen + " quantity is at limit!");
					    }
					    if(updated_drink_qty <= 10 && updated_drink_qty != 0) {
					    	JOptionPane.showMessageDialog(null, "Warning " + drink_chosen + " quantity is at limit!");
					    }
					    if(updated_dessert_qty <= 10 && updated_dessert_qty != 0) {
					    	JOptionPane.showMessageDialog(null, "Warning " + dessert_chosen + " quantity is at limit!");
					    }
					    
					    String update_food_qty = "UPDATE items SET qty = '"+updated_food_qty+"' WHERE name = '" +food_chosen+"'";
						
						PreparedStatement food = con.prepareStatement(update_food_qty);
						food.execute();
						
						String update_drink_qty = "UPDATE items SET qty = '"+updated_drink_qty+"' WHERE name = '" + drink_chosen+"'";
							
					    PreparedStatement drink = con.prepareStatement(update_drink_qty);
					    drink.execute();
					    
					    
                        String update_dessert_qty = "UPDATE items SET qty = '"+updated_dessert_qty+"' WHERE name = '" +dessert_chosen+"'";
						
						PreparedStatement dessert = con.prepareStatement(update_dessert_qty);
						dessert.execute();
					    
					    JOptionPane.showMessageDialog(null,"Order is done!");
					    
					    
					    
						}    
					    
					}
					catch(Exception e3){
						JOptionPane.showMessageDialog(null,"Order is not done!");	
						System.out.println("The error was"+ e3);
					}
				}
				
		
		
			
			}
		});
		btnSubmitOrder.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSubmitOrder.setBounds(479, 10, 159, 30);
		panel_8.add(btnSubmitOrder);
		
		JButton Button_2 = new JButton("Reset");
		Button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				textField_7.setText(null);
				lblNewLabel_18.setText(null);
				lblNewLabel_19.setText(null);
				lblNewLabel_20 .setText(null);
				lblNewLabel_21 .setText(null);
				lblNewLabel_22 .setText(null);
				lblNewLabel_23 .setText(null);
				comboBox_1.setSelectedItem("Select a food");
				comboBox_2.setSelectedItem("Select a drink");
				comboBox_3.setSelectedItem("Select a dessert");
				textPane.setText("");
				textPane_1.setText("");
				textPane_2.setText("");
				
				
			}
		});
		Button_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		Button_2.setBounds(788, 10, 110, 30);
		panel_8.add(Button_2);
		
		
	}
}
























