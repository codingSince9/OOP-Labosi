package hr.fer.oop.taxigui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import hr.fer.oop.taxigui.WindowFilter.TaxiFilter;


/**
 * A class to demonstrate the usage of GenericTablePanel
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class GenericTableMain extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private List<Record> recordList = new ArrayList<>();
	private static int i=1;
	private String path;
	private WindowFilter wfilter =new WindowFilter();
	
	public GenericTableMain() {
		setLocation(100,100);
		setSize(1000,500);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Taxi Record Viewer");
		wfilter.pack();
		initGui();
	}
	
	private void initGui() {
		Container cp=getContentPane();
		cp.setLayout(new BorderLayout());
		
		JToolBar tb=new JToolBar();
		JButton bt1=new JButton("Exit");
		JTextField field= new JTextField();
		field.setMaximumSize(new Dimension(250, 200));
		JButton bt2=new JButton("Load File");
		JButton bt3=new JButton("Define Filter");
		JButton bt4=new JButton("Apply Filter");
		
		tb.add(bt1);
		tb.add(field);
		tb.add(bt2);
		tb.add(bt3);
		tb.add(bt4);
		cp.add(tb,BorderLayout.PAGE_START);
		
		GenericTablePanel<Record> tablePanel = new GenericTablePanel<>(Record.class);
        tablePanel.setPreferredSize(new Dimension(200, 100));
        add(tablePanel, BorderLayout.CENTER);

        ScrollPane logPane = new ScrollPane();
        JTextArea text = new JTextArea();
        text.setEditable(false);
        logPane.add(text);
        cp.add(logPane,BorderLayout.SOUTH);
        
		addWindowListener( new WindowAdapter() {	
			@Override
			public void windowClosed(WindowEvent e) {
				wfilter.dispose();
			}
		});
		
		
		bt1.addActionListener(e-> {
			wfilter.dispose();
			dispose();
		});
		
		bt2.addActionListener(e-> {
		bt2.setEnabled(false);
		new Thread(()-> {
			path=field.getText();
			i=1;
			if (!path.isEmpty())
				text.append("Loading records from \"" + path + "\"\n");
			try {
			recordList =Files.lines(Paths.get(path))
					.map(line->line.split(","))
					.distinct()
					.map(line -> new Record(i++, line[0], line[1], line[2], line[3],
							line[4], line[5], line[6], line[7], line[8], line[9], line[10], line[11], line[12],
							line[13], line[14], line[15], line[16]))
					.collect(Collectors.toList());
			}catch(IOException | NullPointerException ex) {
				System.err.println("Wrong path!");
				text.append("Wrong path!\n");
			}

			 SwingUtilities.invokeLater(()->tablePanel.update(recordList));
			 if (!path.isEmpty())
				 text.append("Loaded "+ (i-1) +"records.\n");
			 bt2.setEnabled(true);
			}).start();
		});
		bt3.addActionListener(e->{
			wfilter.setVisible(!wfilter.isVisible());
		});
		
		bt4.addActionListener(e->{
			bt3.setEnabled(false);
			bt4.setEnabled(false);
			if (!path.isEmpty())
				text.append("Applying defined filter.\n");
			new Thread(()-> {
				try {
					TaxiFilter filter = wfilter.getFilter();
					i=1;
					recordList =Files.lines(Paths.get(path))
							.map(line -> line.split(","))
							.distinct()
			
							.filter(line -> {
								boolean skip=true;
								boolean leave=true;
								boolean payment=true;
								boolean distance=true;
								if (filter.isToSkip()) {
									if (i<=filter.getNumberToSkip()) {
										skip=false;
										++i;
									}
								}
								if (filter.isToLeave()) {
									if (i>filter.getNumberToLeave()) {
										leave=false;
										++i;
									}
								}
								if (filter.isToFilterByPaymentType()) {
									if(!filter.getPaymentType().equals(line[10])) {
										payment=false;
									}
								}
								if(filter.isToLimitDistance()) {
									if ( filter.getDistanceRelation().equals(">")) {
										if (Double.parseDouble(line[5]) <= filter.getDistanceToLimit())
											distance=false;
									}
									else if ( filter.getDistanceRelation().equals("<")) {
										if (Double.parseDouble(line[5]) >= filter.getDistanceToLimit())
											distance=false;
									}
									else if ( filter.getDistanceRelation().equals("=")) {
										if (Double.parseDouble(line[5]) != filter.getDistanceToLimit())
											distance=false;
									}
								}
								return skip && leave && payment && distance;
							})
							.map(line -> new Record(i++, line[0], line[1], line[2], line[3],
									line[4], line[5], line[6], line[7], line[8], line[9], line[10], line[11], line[12],
									line[13], line[14], line[15], line[16]))
							.collect(Collectors.toList());
				}catch(IOException ex) {
					System.err.println("Wrong path!");
					text.append("Wrong path!\n");
				}
	
				SwingUtilities.invokeLater(()->tablePanel.update(recordList));
				bt3.setEnabled(true);
				bt4.setEnabled(true);
			}).start();
		});
		
	}


	public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> {
        	GenericTableMain window = new GenericTableMain();
        	window.setVisible(true);
    });
}
    public static class Record {
        private int id;
        private String medallion;
        private String hack_license;
        private Date pickup_datetime;
        private Date dropoff_datetime;
        private int duration;
        private double distance;
        private double pickup_longitude;
        private double pickup_latitude;
        private double dropoff_longitude;
        private double dropoff_latitude;
        private String payment_type;
        private double fare_amount;
        private double surcharge;
        private double mta_tax;
        private double tip_amount;
        private double tolls_amount;
        private double total_amount;
        
        private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        
        public Record(int id, String medallion,
				String hack_license, String pickup_datetime, String dropoff_datetime, String duration, String distance,
				String pickup_longitude, String pickup_latitude, String dropoff_longitude, String dropoff_latitude,
				String payment_type, String fare_amount, String surcharge, String mta_tax, String tip_amount,
				String tolls_amount, String total_amount) {
			super();
			
			this.id = id;
			this.medallion = medallion;
			this.hack_license = hack_license;
			try {
			this.pickup_datetime =DATE_FORMATTER.parse(pickup_datetime);
			this.dropoff_datetime =DATE_FORMATTER.parse(dropoff_datetime);
			}catch (ParseException ex){
			}
			this.duration =Integer.parseInt(duration);
			this.distance =Double.parseDouble(distance);
			this.pickup_longitude = Double.parseDouble(pickup_longitude);
			this.pickup_latitude = Double.parseDouble(pickup_latitude);
			this.dropoff_longitude =Double.parseDouble( dropoff_longitude);
			this.dropoff_latitude = Double.parseDouble(dropoff_latitude);
			this.payment_type = payment_type;
			this.fare_amount =Double.parseDouble(fare_amount);
			this.surcharge = Double.parseDouble(surcharge);
			this.mta_tax = Double.parseDouble(mta_tax);
			this.tip_amount = Double.parseDouble(tip_amount);
			this.tolls_amount = Double.parseDouble(tolls_amount);
			this.total_amount = Double.parseDouble(total_amount);
		}



		public int getId() {
			return id;
		}

		public String getMedallion() {
			return medallion;
		}

		public String getHack_license() {
			return hack_license;
		}

		public Date getPickup_datetime() {
			return pickup_datetime;
		}

		public Date getDropoff_datetime() {
			return dropoff_datetime;
		}

		public int getDuration() {
			return duration;
		}

		public double getDistance() {
			return distance;
		}

		public double getPickup_longitude() {
			return pickup_longitude;
		}

		public double getPickup_latitude() {
			return pickup_latitude;
		}

		public double getDropoff_longitude() {
			return dropoff_longitude;
		}

		public double getDropoff_latitude() {
			return dropoff_latitude;
		}

		public String getPayment_type() {
			return payment_type;
		}

		public double getFare_amount() {
			return fare_amount;
		}

		public double getSurcharge() {
			return surcharge;
		}

		public double getMta_tax() {
			return mta_tax;
		}

		public double getTip_amount() {
			return tip_amount;
		}

		public double getTolls_amount() {
			return tolls_amount;
		}

		public double getTotal_amount() {
			return total_amount;
		}

        @Override
		public String toString() {
			return "Record [id=" + id + ", medallion=" + medallion + ", hack_license=" + hack_license
					+ ", pickup_datetime=" + pickup_datetime + ", dropoff_datetime=" + dropoff_datetime + ", duration="
					+ duration + ", distance=" + distance + ", pickup_longitude=" + pickup_longitude
					+ ", pickup_latitude=" + pickup_latitude + ", dropoff_longitude=" + dropoff_longitude
					+ ", dropoff_latitude=" + dropoff_latitude + ", payment_type=" + payment_type + ", fare_amount="
					+ fare_amount + ", surcharge=" + surcharge + ", mta_tax=" + mta_tax + ", tip_amount=" + tip_amount
					+ ", tolls_amount=" + tolls_amount + ", total_amount=" + total_amount + "]";
		}
   }
}
