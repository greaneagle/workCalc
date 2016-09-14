import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame {
	private JTextField anwserfield;
	private JButton one, two, three, four, five, six, seven, eight, nine, zero, colon, withBreak, noBreak, clearBtn, endWork;
	private String stemp1;
	private Integer workTime = 480;
	private Integer breakTime = 30;
	private JPanel contentPanel;
	private boolean equalsClicked = false;
	char operation = ' ';
	private String startTime;
	private String endDate;
	private String startDate;
	private JTextField tippsField;
	private String tippsString = "Input end time or start time in format hh:mm";
	private JTextField tippsField2;
	private String tippsString2 = "Example: 16:00";
	
	
	public Gui(){
		super("Calculator");
		
		anwserfield =  new JTextField(null, 20);
		anwserfield.setEditable(true);
		tippsField =  new JTextField(null, 20);
		tippsField.setEditable(false);
		tippsField2 =  new JTextField(null, 20);
		tippsField2.setEditable(false);
		tippsField.setText(tippsString);
		tippsField2.setText(tippsString2);
		
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		zero = new JButton("0");
		colon = new JButton(":");
		clearBtn = new JButton("Clear");
		noBreak = new JButton("Without break!");
		withBreak = new JButton("With break!");
		endWork = new JButton("When to end work!");
		
		Dimension dim = new Dimension(75, 25);
		
		one.setPreferredSize(dim);
		two.setPreferredSize(dim);
		three.setPreferredSize(dim);
		four.setPreferredSize(dim);
		five.setPreferredSize(dim);
		six.setPreferredSize(dim);
		seven.setPreferredSize(dim);
		eight.setPreferredSize(dim);
		nine.setPreferredSize(dim);
		zero.setPreferredSize(new Dimension (225, 25));
		colon.setPreferredSize(new Dimension (225, 25));
		clearBtn.setPreferredSize(new Dimension (225, 25));
		noBreak.setPreferredSize(new Dimension (225, 25));
		withBreak.setPreferredSize(new Dimension (225, 25));
		endWork.setPreferredSize(new Dimension (225, 25));
		
		Numbers n = new Numbers();
		Calc c = new Calc();
		
		one.addActionListener(n);
		two.addActionListener(n);
		three.addActionListener(n);
		four.addActionListener(n);
		five.addActionListener(n);
		six.addActionListener(n);
		seven.addActionListener(n);
		eight.addActionListener(n);
		nine.addActionListener(n);
		zero.addActionListener(n);
		colon.addActionListener(n);
		clearBtn.addActionListener(n);
		
		noBreak.addActionListener(c);
		withBreak.addActionListener(c);
		endWork.addActionListener(c);
		
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.GRAY);
		contentPanel.setLayout(new FlowLayout());
		
		contentPanel.add(anwserfield, BorderLayout.NORTH);
		contentPanel.add(one); contentPanel.add(two); contentPanel.add(three); contentPanel.add(four);
		contentPanel.add(five); contentPanel.add(six); contentPanel.add(seven); contentPanel.add(eight);
		contentPanel.add(nine); contentPanel.add(zero); contentPanel.add(colon); contentPanel.add(clearBtn); contentPanel.add(noBreak); contentPanel.add(withBreak);
		contentPanel.add(endWork);
		contentPanel.add(tippsField, BorderLayout.SOUTH); contentPanel.add(tippsField2, BorderLayout.SOUTH);
		this.setContentPane(contentPanel);		
		
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		 Calendar cal = Calendar.getInstance();
		 startTime = dateFormat.format(cal.getTime()).toString();
		 endDate = startTime.substring(0, 10);
		 startDate  =  startTime.substring(0, 10);
		   
	}

	
	private class Numbers implements ActionListener{
		public void actionPerformed(ActionEvent event){
			JButton src = (JButton) event.getSource();
			
			if(src.equals(one)){
						stemp1 = anwserfield.getText() + "1";
					
				}
			
			if(src.equals(two)){
						stemp1 = anwserfield.getText() + "2";
					
				}
			if(src.equals(three)){
						stemp1 = anwserfield.getText() + "3";
					
				}
			
			if(src.equals(four)){
						stemp1 = anwserfield.getText() + "4";
					
				}
			
			if(src.equals(five)){
						stemp1 = anwserfield.getText() + "5";
					
				}
			
			if(src.equals(six)){
						stemp1 = anwserfield.getText() + "6";
					
				}
			
			if(src.equals(seven)){
						stemp1 = anwserfield.getText() + "7";
				
			}
			
			if(src.equals(eight)){
						stemp1 = anwserfield.getText() + "8";
					
				}
			
			
			if(src.equals(nine)){
						stemp1 = anwserfield.getText() + "9";
					
			}
			
			if(src.equals(zero)){
						stemp1 = anwserfield.getText() + "0";
		
				}
			
			
			if(src.equals(colon)){
						stemp1 = anwserfield.getText() + ":";
					
				}
			if(src.equals(clearBtn)){
					stemp1 = "";
					anwserfield.setText("");
				
			}
			
			
			if(equalsClicked==false){
				
					anwserfield.setText(stemp1);				
			}
		}
	}
	
	private class Calc implements ActionListener{
		public void actionPerformed(ActionEvent event){
			JButton src = (JButton) event.getSource();
	
			if(src.equals(withBreak)){
				stemp1 = anwserfield.getText();
				 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
					try{
						   Date calcFinishDate = dateFormat.parse(endDate + " " + stemp1);
						   if(Integer.parseInt(stemp1.substring(0, 2)) <= 24 && Integer.parseInt(stemp1.substring(3,5)) <=60 &&  stemp1.length() == 5){
							   Date calcStartDate = dateFormat.parse(startTime);
							   long diff = calcFinishDate.getTime() - calcStartDate.getTime();
							   long diffMinutes = diff / (60 * 1000);
								int resoult = (int) (diffMinutes - breakTime);
								if(resoult <= 0){
								  anwserfield.setText("Negative work time? Nope...");
								  
								  
								}else{
									anwserfield.setText("You will work for " + Integer.toString(resoult) + " minutes.");
								}
						   }else{
							   anwserfield.setText("That time looks wrong.");
						   }
						  }
						catch (ParseException ex){
					            System.out.println("Exception "+ex);
					            anwserfield.setText("That time looks wrong.");
					    }
				
			}
			
			if(src.equals(noBreak)){
				stemp1 = anwserfield.getText();
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
					try{
						   Date calcFinishDate = dateFormat.parse(endDate + " " + stemp1);
						   if(Integer.parseInt(stemp1.substring(0, 2)) <= 24 && Integer.parseInt(stemp1.substring(3,5)) <= 59 &&  stemp1.length() == 5){
						   
							   Date calcStartDate = dateFormat.parse(startTime);
							   System.out.println(calcStartDate.toString());
							   System.out.println(calcFinishDate.toString());
							   long diff = calcFinishDate.getTime() - calcStartDate.getTime();
							   long diffMinutes = diff / (60 * 1000);
								int resoultNoBreak = (int) (diffMinutes);
									if(resoultNoBreak <=0){
										anwserfield.setText("Negative work time? Nope...");
									}else{
										anwserfield.setText("You will work for " + Integer.toString(resoultNoBreak) + " minutes.");
									}
						   		}else{
						   			anwserfield.setText("That time looks wrong.");
						   		}
						   }
						   catch (ParseException ex){
					            System.out.println("Exception "+ex);
					            anwserfield.setText("That time looks wrong.");
					            
					        }
				}
			
			
			if(src.equals(endWork)){
				stemp1 = anwserfield.getText();
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
					try{
						   if(stemp1.length() == 5 && Integer.parseInt(stemp1.substring(0, 2)) <= 24 && Integer.parseInt(stemp1.substring(3,5)) <= 59) {
								
							    Calendar cal = Calendar.getInstance(); 
								Date startTime = dateFormat.parse(startDate + " " +stemp1);
								cal.setTime(startTime);
								cal.add(Calendar.MINUTE, workTime + breakTime);
								String endWork = dateFormat.format(cal.getTime());
								String endTime = endWork.substring(11, 16);
								anwserfield.setText("Go home at " + endTime +" " );
							   
						   	}else if (stemp1.length() == 4 && Integer.parseInt(stemp1.substring(2,4)) <= 59){
						   			
						   			stemp1 = "0" + stemp1;
						   			Calendar cal = Calendar.getInstance(); 
									Date startTime = dateFormat.parse(startDate + " " +stemp1);
									cal.setTime(startTime);
									cal.add(Calendar.MINUTE, workTime + breakTime);
									String endWork = dateFormat.format(cal.getTime());
									String endTime = endWork.substring(11, 16);
								   
								   anwserfield.setText("Go home at " + endTime +" " );
						   	}else{
						   			anwserfield.setText("That time looks wrong.");
						   		}
						   }
						   catch (ParseException ex){
					            System.out.println("Exception "+ex);
					            anwserfield.setText("That time looks wrong.");      
					        }
				}
			}
		}
	}


				
			


	