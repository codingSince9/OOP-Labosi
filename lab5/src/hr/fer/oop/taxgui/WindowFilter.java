package hr.fer.oop.taxigui;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

public class WindowFilter extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JCheckBox skipR,leaveR,payment,distance;
	private JTextField fieldSkipR,fieldLeaveR,fieldDistance;
	private JRadioButton cash,card,unknown;
	private JComboBox<String> relation;

	

	public WindowFilter() {
		setLocation(200,100);
		setSize(300,500);
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setTitle("Filters");
		setVisible(false);
		initGui();
		
	}

	private void initGui() {
		Container cp=getContentPane();
		cp.setLayout(new SpringLayout());
		
		skipR =new JCheckBox("Skip records?", false);
		leaveR= new JCheckBox("Leave records?", false);
		payment =new JCheckBox("Filter by payment type?", false);
		distance =new JCheckBox("Limit Distane?", false);
		
		JLabel txtSkipR =new JLabel("Number of records to skip: ");
		JLabel txtLeaveR =new JLabel("Number of records to leave: ");
		
		fieldSkipR=new JTextField();
		fieldLeaveR=new JTextField();
		
		JPanel paymentTypePanel = new JPanel();
		paymentTypePanel.setBorder(BorderFactory.createTitledBorder(null,
			"Payment type?",TitledBorder.LEADING , TitledBorder.TOP));
		paymentTypePanel.setLayout(new GridLayout(0, 1, 0, 0));
		ButtonGroup paymentType = new ButtonGroup();
		
		cash=new JRadioButton("Cash (CSH)");
		card=new JRadioButton("Card (CRD)");
		unknown=new JRadioButton("Unknown (UNK)");
		
	
		
		paymentType.add(cash);
		paymentType.add(card);
		paymentType.add(unknown);
		
		paymentTypePanel.add(cash);
		paymentTypePanel.add(card);
		paymentTypePanel.add(unknown);
		

		
		relation = new JComboBox<>();
		relation.addItem("=");
		relation.addItem(">");
		relation.addItem("<");
		
		fieldDistance = new JTextField();
		
		cp.add(skipR);
		cp.add(txtSkipR);
		cp.add(fieldSkipR);
		cp.add(leaveR);
		cp.add(txtLeaveR);
		cp.add(fieldLeaveR);
		cp.add(payment);
		cp.add(new JLabel(""));
		cp.add(paymentTypePanel);
		cp.add(distance);
		cp.add(relation);
		cp.add(fieldDistance);
		SpringUtilities.makeCompactGrid(cp, 4, 3, 0, 0, 5, 5);
	}
	
	public TaxiFilter getFilter() {
		TaxiFilter filter =new TaxiFilter();
		
		if(skipR.isSelected()) {
			filter.setNumberToSkip(Integer.parseInt(fieldSkipR.getText()));
		}
		filter.setToSkip(skipR.isSelected());
		
		if(leaveR.isSelected()) {
			filter.setNumberToLeave(Integer.parseInt(fieldLeaveR.getText()));
		}
		filter.setToLeave(leaveR.isSelected());
		
		if(payment.isSelected()) {
			if(cash.isSelected()) {
				filter.setPaymentType("CSH");
			}else if (card.isSelected()) {
				filter.setPaymentType("CRD");
			}else filter.setPaymentType("UNK");
		}
		filter.setToFilterByPaymentType(payment.isSelected());
		
		if(distance.isSelected()) {
			filter.setDistanceRelation((String)relation.getSelectedItem());
			filter.setDistanceToLimit(Double.parseDouble(fieldDistance.getText()));
		}
		filter.setToLimitDistance(distance.isSelected());
		
		return filter;
		
	}
	
	public class TaxiFilter{
		private boolean toSkip,toLeave,toFilterByPaymentType,toLimitDistance;
		private int numberToSkip, numberToLeave;
        private double distanceToLimit;
        private String paymentType, distanceRelation;
        
        
		public boolean isToSkip() {
			return toSkip;
		}
		public void setToSkip(boolean toSkip) {
			this.toSkip = toSkip;
		}
		public boolean isToLeave() {
			return toLeave;
		}
		public void setToLeave(boolean toLeave) {
			this.toLeave = toLeave;
		}
		public boolean isToFilterByPaymentType() {
			return toFilterByPaymentType;
		}
		public void setToFilterByPaymentType(boolean toFilterByPaymentType) {
			this.toFilterByPaymentType = toFilterByPaymentType;
		}
		public boolean isToLimitDistance() {
			return toLimitDistance;
		}
		public void setToLimitDistance(boolean toLimitDistance) {
			this.toLimitDistance = toLimitDistance;
		}
		public int getNumberToSkip() {
			return numberToSkip;
		}
		public void setNumberToSkip(int numberToSkip) {
			this.numberToSkip = numberToSkip;
		}
		public int getNumberToLeave() {
			return numberToLeave;
		}
		public void setNumberToLeave(int numberToLeave) {
			this.numberToLeave = numberToLeave;
		}
		public double getDistanceToLimit() {
			return distanceToLimit;
		}
		public void setDistanceToLimit(double distanceToLimit) {
			this.distanceToLimit = distanceToLimit;
		}
		public String getPaymentType() {
			return paymentType;
		}
		public void setPaymentType(String paymentType) {
			this.paymentType = paymentType;
		}
		public String getDistanceRelation() {
			return distanceRelation;
		}
		public void setDistanceRelation(String distanceRelation) {
			this.distanceRelation = distanceRelation;
		}
        
        
	}

}
