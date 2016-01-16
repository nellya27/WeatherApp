package com.WeatherApp.NellyAlfimov;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class ViewData extends JFrame implements Observer{
	
	private JPanel mainFrame =new JPanel();
	private JPanel firstPanel=new JPanel(new GridBagLayout());
    private JPanel secondPanel=new JPanel(new BorderLayout());
    private JPanel picPanel=new JPanel(new BorderLayout());   
    private JPanel imgweather=new JPanel(new BorderLayout());
    private JLabel cityLabel=new JLabel("Choose City:");
	private JLabel countryLabel=new JLabel("Choose Country:");
	private JLabel Img=new JLabel();
	private Border line;
	private TitledBorder title;
	private ImageIcon pic=new ImageIcon("icons/pic1.jpg");
	JTextField  cityText=new JTextField(10);
	JTextField  countryText=new JTextField(10);
	private JButton start=new JButton("show weather");
    Font fontForLabels=new Font("Gungsuh",Font.BOLD,15);
    Font fontForTextResult=new Font("BatangChe",Font.BOLD,20);
    Font fontWelcome=new Font ("Broadway",Font.BOLD,18);
    JTextArea textResult=new JTextArea(15,30);
    
    
	   public ViewData()   {
		      
		this.setSize(900,700);
		this.setTitle("Weather Application");
		this.setFont(fontForLabels);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    this.setVisible(true);
 	 
	 
	    this.add(mainFrame);            
        mainFrame.add(firstPanel,BorderLayout.CENTER);	
		firstPanel.setPreferredSize(new Dimension(800,600));
		 
	  
	    
		
		
		start.setForeground(Color.PINK);
		start.setFont(fontForLabels);
		start.setPreferredSize(new Dimension(130,55));
		cityLabel.setFont(fontForLabels);
		cityLabel.setForeground(Color.PINK);
		countryLabel.setFont(fontForLabels);
		countryLabel.setForeground(Color.PINK);
		countryText.setBorder(BorderFactory.createLineBorder(Color.PINK, 2));
		cityText.setBorder(BorderFactory.createLineBorder(Color.PINK, 2));
		GridBagConstraints  container= new GridBagConstraints();
		container.fill=GridBagConstraints.HORIZONTAL;
		container.gridx=0;
		container.gridy=0;
		firstPanel.add(cityLabel, container);
		container.fill=GridBagConstraints.HORIZONTAL;
		container.gridx=0;
		container.gridy=1;
		firstPanel.add(countryLabel, container);
		container.fill=GridBagConstraints.HORIZONTAL;
		container.gridx=1;
		container.gridy=0;
		firstPanel.add(cityText, container);
		container.fill=GridBagConstraints.HORIZONTAL;
		container.gridx=1;
		container.gridy=1;
		firstPanel.add(countryText, container);
		container.fill=GridBagConstraints.HORIZONTAL;
		container.gridheight=2;
		container.gridwidth=2;
		container.gridx=2;
		container.gridy=0;
		firstPanel.add(start,container);
		container.fill=GridBagConstraints.HORIZONTAL;
		container.gridx=0;
		container.gridy=2;
		firstPanel.add(secondPanel, container);
		Img.setIcon(new ImageIcon("icons/pic1.jpg"));
		picPanel.add(Img);
		container.fill=GridBagConstraints.HORIZONTAL;
		container.gridx=2;
		container.gridy=2;
		firstPanel.add(picPanel, container);
		validate();
		
		secondPanel.add(textResult,BorderLayout.PAGE_END);
		textResult.setEditable(false);
	    textResult.setFont(fontForTextResult);
	    textResult.setForeground(Color.PINK);
	    textResult.setBackground(Color.DARK_GRAY);
	    textResult.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
	    line=BorderFactory.createLineBorder(Color.PINK,4);
	    title=BorderFactory.createTitledBorder(line, "weather info");
	    title.setTitleJustification(TitledBorder.CENTER);
	    title.setTitleColor(Color.PINK);
	    title.setTitleFont(fontForLabels);
	    secondPanel.setBorder(title);
	  
	    

	}



	   void addListener(ActionListener buttonListener){
			start.addActionListener(buttonListener);
	   }



		@Override
		public void update(Observable arg0, Object arg) {
		 
			this.textResult.setText(arg0.toString());
			
			















	








































































	}
	
	

}
