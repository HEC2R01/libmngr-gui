package Libmngr;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class LMgui extends JFrame implements ActionListener {
	JPanel Fpanel,smallpanel,bpanel,adminpanel,loginpanel, addbookpanel, studentpanel,bookpanel;
	JButton b1,b2,login, logout,addbooks,removebooks,modifybooks;
	JButton savebutton,cancelbutton,searchbutton,cancelbtn,backbtn;
	JTextField user, searchbar, title, author, genre, ReleaseDate, ID ;
	JPasswordField pass;
	JTextArea area;
	CardLayout layout;
	GridLayout LoginLayout;
	
	
	LMgui() {
		setTitle("LIBRARY MANAGEMENT");
		setSize(1000,700);
		
		layout = new CardLayout();
		Fpanel = new JPanel(layout);
		
		
		MainButtonPanel();
		AdminPanel();
		LoginPanel();
		AddBookPanel();
		StudentPanel();
		
		
		Fpanel.add(bpanel, "BACKBUTTON");
		Fpanel.add(loginpanel, "LOGINPANEL");
		Fpanel.add(adminpanel,"ADMINPANEL");
		Fpanel.add(addbookpanel, "ADDBOOKS");
		//Fpanel.add();
		Fpanel.add(studentpanel, "STUDENT");
		
	
		add(Fpanel, BorderLayout.CENTER);
		setResizable(false);
		setVisible(true);
		
	}
		
	private void MainButtonPanel() {
		bpanel = new JPanel(null);
		
		b1 = new JButton("ADMIN");
		b1.setBounds(370,270,250,50);
		b1.addActionListener(this);
		bpanel.add(b1);
		
		b2 = new JButton("STUDENT");
		b2.setBounds(370,350,250,50);
		b2.addActionListener(this);
		bpanel.add(b2);
		
		smallpanel = new JPanel(null);
		smallpanel.setBounds(290,140,400,400);
		bpanel.add(smallpanel);
		
		JPanel longerpanel = new JPanel(null);
		longerpanel.setBackground(Color.black);
		longerpanel.setBounds(0,0,1000,1000);
		bpanel.add(longerpanel);
		
			
	}
		
	private void LoginPanel() {
		loginpanel = new JPanel(null);
					
		JLabel Admin = new JLabel ("ADMIN PANEL");
		Admin.setBounds(450, 130, 100, 100);
		loginpanel.add(Admin);
			
		user = new JTextField();
		user.setBounds(390,230,250,40);
		loginpanel.add(user);
		
		pass = new JPasswordField();
		pass.setBounds(390,300,250,40);
		loginpanel.add(pass);
		
		JLabel label1 = new JLabel("Username ");
		label1.setBounds(320,230,250,50);
		loginpanel.add(label1);
		
		
		JLabel label2 = new JLabel("Password "); 
		label2.setBounds(320,300,250,50);
		loginpanel.add(label2);
		
		login = new JButton("LOGIN");
		login.setBounds(350,400,120,40);
		login.addActionListener(this);
		loginpanel.add(login);
		
		
		cancelbtn = new JButton("CANCEL");
		cancelbtn.setBounds(500,400,120,40);
		cancelbtn.addActionListener(this);
		loginpanel.add(cancelbtn);
		
		JPanel smallpanel1 = new JPanel(null);
		smallpanel1.setBounds(290,140,400,400);
		loginpanel.add(smallpanel1);
		
		JPanel longerpanel1 = new JPanel(null);
		longerpanel1.setBackground(Color.black);
		longerpanel1.setBounds(0,0,1000,1000);
		loginpanel.add(longerpanel1);
	} 
	
	private void AdminPanel () {
		
		adminpanel = new JPanel(null);
		
		JLabel BookTitle = new JLabel("TITLE");
		BookTitle.setBounds(150,130,150,100);	
		adminpanel.add(BookTitle); 
	
		
		JTextArea booklist = new JTextArea("\n       1. Harry Potter \n       2. Pride and  \n            Prejudice");		
		booklist.setBounds(90,190,130,230);
		adminpanel.add(booklist);
		booklist.setEditable(false);
		
		
		JLabel BookAuthor = new JLabel("AUTHOR");
		BookAuthor.setBounds(150,130,150,100);	;
		adminpanel.add(BookAuthor); 
	
		
		JTextArea authorlist = new JTextArea("\n            J.K Rowling \n            Jane Austen");		
		authorlist.setBackground(Color.LIGHT_GRAY);
		authorlist.setBounds(220,190,130,230);
		authorlist.setEditable(false);
		adminpanel.add(authorlist); 
		
		JLabel bookgenre = new JLabel("BOOK GENRE");
		bookgenre.setBounds(150,130,150,100);	
		adminpanel.add(bookgenre); 
		
		JTextArea genrelist = new JTextArea("\n            FICTION \n            ROMANCE");		
		genrelist.setBounds(350,190,130,230);
		genrelist.setEditable(false);
		adminpanel.add(genrelist);
		
		JLabel rdate = new JLabel("RELEASE DATE");
		rdate.setBounds(150,130,150,100);	
		adminpanel.add(rdate); 
	
		
		JTextArea datelist = new JTextArea("\n               06-26-1997 \n               01-28-1813");		
		datelist.setBackground(Color.LIGHT_GRAY);
		datelist.setBounds(480,190,130,230);
		datelist.setEditable(false);
		adminpanel.add(datelist); 
		
		JLabel idnum = new JLabel("ID NUMBER");
		idnum.setBounds(150,130,150,100);	
		adminpanel.add(idnum); 
	
		
		JTextArea idlist = new JTextArea("\n            456213 \n            331245");		
		idlist.setBounds(610,190,130,230);
		idlist.setEditable(false);
		adminpanel.add(idlist); 
		
		
		addbooks = new JButton("ADD BOOKS");
		addbooks.setBounds(350,430,130,40);
		addbooks.addActionListener(this);
		adminpanel.add(addbooks);
	
		removebooks = new JButton("REMOVE BOOKS");
		removebooks.setBounds(500,430,150,40);
		removebooks.addActionListener(this);
		adminpanel.add(removebooks);
		
		modifybooks = new JButton("MODIFY BOOKS");
		modifybooks.setBounds(450,480,130,40);
		modifybooks.addActionListener(this);
		adminpanel.add(modifybooks);
		
		logout = new JButton("LOGOUT");
		logout.setBounds(800,50,90,30);
		logout.addActionListener(this);
		adminpanel.add(logout);
		
		JPanel adsmallpanel1 = new JPanel(null);
		adsmallpanel1.setBounds(90,140,800,400);
		adminpanel.add(adsmallpanel1);
		
		JPanel adlongerpanel1 = new JPanel(null);
		adlongerpanel1.setBackground(Color.black);
		adlongerpanel1.setBounds(0,0,1000,1000);
		adminpanel.add(adlongerpanel1); 
		
	}
	
	private void AddBookPanel() {
		addbookpanel = new JPanel(null);
		
		JLabel BookPanelTitle = new JLabel("ADDING BOOKS PANEL");
		BookPanelTitle.setBounds(450, 130, 100, 100);
		addbookpanel.add(BookPanelTitle);
		
		JLabel titlename = new JLabel ("Book Title ");
		titlename.setBounds(320,200,250,40);
		addbookpanel.add(titlename);	
		title = new JTextField();
		title.setBounds(390,200,250,40);
		addbookpanel.add(title);
		
		JLabel authorname = new JLabel("Book Author");
		authorname.setBounds(320,250,250,40);
		addbookpanel.add(authorname);
	
		author = new JTextField();
		author.setBounds(390,250,250,40);
		addbookpanel.add(author);
		
		
		JLabel genrecategory = new JLabel ("Book Genre ");
		genrecategory.setBounds(320,280,100,100);
		addbookpanel.add(genrecategory);
		
		genre = new JTextField();
		genre.setBounds(390,350,250,40);
		addbookpanel.add(genre);
		
		JLabel releasedate = new JLabel ("Release Date ");
		releasedate.setBounds(320,310,100,100);
		addbookpanel.add(releasedate);
		
		ReleaseDate = new JTextField();
		ReleaseDate.setBounds(390,300,250,40);
		addbookpanel.add(ReleaseDate);
		
		
		savebutton = new JButton("SAVE");
		savebutton.setBounds(400,460,100,40);
		savebutton.addActionListener(this);
		addbookpanel.add(savebutton);
		
		cancelbutton = new JButton("CANCEL");
		cancelbutton.setBounds(500,460,100,40);
		cancelbutton.addActionListener(this);
		addbookpanel.add(cancelbutton);
		
		JPanel adbsmallpanel1 = new JPanel(null);
		adbsmallpanel1.setBounds(290,140,400,400);
		addbookpanel.add(adbsmallpanel1);
		
		JPanel adblongerpanel1 = new JPanel(null);
		adblongerpanel1.setBackground(Color.black);
		adblongerpanel1.setBounds(0,0,1000,1000);
		addbookpanel.add(adblongerpanel1); 
		
	}
	
		
   private void StudentPanel() {
		studentpanel = new JPanel(null);
		
		JLabel Studentpanel = new JLabel("STUDENT PANEL ");
		Studentpanel.setBounds(450, 170, 140, 100);
		studentpanel.add(Studentpanel);
		
		
		JLabel Search = new JLabel("CHECK THE STATUS OF THE BOOK ");
		Search.setBounds(400, 350, 250, 100);
		studentpanel.add(Search);
		
		searchbar = new JTextField();
		searchbar.setBounds(400, 270, 200, 40);
		studentpanel.add(searchbar);
		
		searchbutton = new JButton("SEARCH");
		searchbutton.setBounds(450, 330, 100, 30);
		searchbutton.addActionListener(this);
		studentpanel.add(searchbutton);
		
		backbtn = new JButton("BACK");
		backbtn.setBounds(300, 170, 100, 30);
		backbtn.addActionListener(this);
		studentpanel.add(backbtn);
		
		JPanel studentsmallpanel = new JPanel(null);
		studentsmallpanel.setBounds(290,140,400,400);
		studentpanel.add(studentsmallpanel);
		
		JPanel stulongerpanel = new JPanel(null);
		stulongerpanel.setBackground(Color.black);
		stulongerpanel.setBounds(0,0,1000,1000);
		studentpanel.add(stulongerpanel);
	}
		

	public static void main(String[] args) {
		 new LMgui();
	
	}

	@Override
	public void actionPerformed(ActionEvent buttonsevent) {
		String username = user.getText();
		String password = String.valueOf(pass.getPassword());
		
		if (buttonsevent.getSource() == b1) {
			layout.show(Fpanel, "LOGINPANEL");
		} else if (buttonsevent.getSource() == b2) {
			layout.show(Fpanel, "STUDENT");
		
		} if (buttonsevent.getSource() == login) {
			if (username.equals("admin") && password.equals("1234")) {
				layout.show(Fpanel, "ADMINPANEL");
			} else if(username.equals("admin") && !password.equals("1234")) {
				JOptionPane.showMessageDialog(Fpanel, "Incorrect password");
				} else if(username.equals("") && password.equals("")) {
					JOptionPane.showMessageDialog(Fpanel, "Incorrect password");
					}
					else {
					JOptionPane.showMessageDialog(Fpanel, "Input a valid username and password");
				}
		  } else if (buttonsevent.getSource() == cancelbtn) {
			  layout.show(Fpanel, "BACKBUTTON");
	}
	
		if (buttonsevent.getSource() == searchbutton) {
			layout.show(Fpanel, "SEARCH");
		} else if (buttonsevent.getSource() == backbtn) {
			  layout.show(Fpanel, "BACKBUTTON");
			  	 
	}
		 actionPerformed1(buttonsevent);
		
}	
		public void actionPerformed1(ActionEvent optionevent) {
			String TitleName = title.getText();
			String Authorname = author.getText();
		
			if (optionevent.getSource() == addbooks) {
				layout.show(Fpanel, "ADDBOOKS");
			} else if (optionevent.getSource() == modifybooks) {
				layout.show(Fpanel, "ADDBOOKS" );
			}
			else if (optionevent.getSource() == removebooks) {
				layout.show(Fpanel, "REMOVE BOOKS");
				
			} else if (optionevent.getSource() == logout) {
				layout.show(Fpanel, "LOGINPANEL");
				user.setText("");
				pass.setText("");
			}
				if (optionevent.getSource() == savebutton) {
				JOptionPane.showMessageDialog(Fpanel, "The book has been added successfully!");
			} else if (optionevent.getSource() == cancelbutton) {
				layout.show(Fpanel, "ADMINPANEL");
			}
	}
}
