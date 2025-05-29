import libmngr.*;

import java.awt.*;
import java.util.*;
import java.io.*;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

public class Program extends JFrame implements ActionListener {
	JPanel Fpanel, smallpanel, bpanel, borrowedbookpanel, adminchoicepanel, loginpanel, addbookpanel, studentpanel,
			bookpanel, collectionbookpanel;
	JButton mainadminbutton, loginbutton, logincancelbutton, collectionbookbutton, adchoicebackbutton,
			borrowedbookbbackutton;
	JButton addbooksbutton, removebooksbutton, modifybooksbutton, adchoicelogoutbutton, logoutbutton,
			borrowedbookbutton;
	JButton mainstudentbutton, searchbutton, backbutton, addbooksavebutton, addbookcancelbutton;
	JTextField user, searchbar, title, author, genre, ReleaseDate, ID;
	JPasswordField pass;
	JTable collectionbooktable, borrowedbooktable;
	CardLayout layout;

	LibraryManager manager = new LibraryManager();

	Program() {
		setForeground(new Color(128, 128, 128));
		setTitle("LIBRARY MANAGEMENT");
		setSize(1000, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		layout = new CardLayout();
		Fpanel = new JPanel(layout);

		AdminChoicePanel();
		StudentPanel();
		CollectionOfBookPanel();
		MainButtonPanel();
		LoginPanel();
		BorrowedBookPanel();
		AddBookPanel();

		Fpanel.add(bpanel, "BPANEL");
		Fpanel.add(loginpanel, "LOGINPANEL");
		Fpanel.add(adminchoicepanel, "ADMINCHOICEPANEL");
		Fpanel.add(collectionbookpanel, "COLLECTIONBOOKPANEL");
		Fpanel.add(borrowedbookpanel, "BORROWEDBOOKPANEL");
		// Fpanel.add(addbookpanel, "ADDBOOKSPANEL");

		Fpanel.add(studentpanel, "STUDENT");

		// Fpanel.add();

		getContentPane().add(Fpanel, BorderLayout.CENTER);
		setResizable(false);
		setVisible(true);

	}

	private void MainButtonPanel() {
		bpanel = new JPanel(null);

		mainadminbutton = new JButton("ADMIN");
		mainadminbutton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mainadminbutton.setBounds(370, 270, 250, 50);
		mainadminbutton.addActionListener(this);
		bpanel.add(mainadminbutton);

		mainstudentbutton = new JButton("STUDENT");
		mainstudentbutton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mainstudentbutton.setBounds(370, 350, 250, 50);
		mainstudentbutton.addActionListener(this);
		bpanel.add(mainstudentbutton);

		smallpanel = new JPanel(null);
		smallpanel.setBounds(290, 140, 400, 400);
		bpanel.add(smallpanel);

		JLabel libmngrtitle = new JLabel("LIBRARY MANAGEMENT");
		libmngrtitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		libmngrtitle.setBounds(75, 26, 250, 100);
		smallpanel.add(libmngrtitle);

		JPanel longerpanel = new JPanel(null);
		longerpanel.setBackground(Color.black);
		longerpanel.setBounds(0, 0, 1000, 1000);
		bpanel.add(longerpanel);

	}

	private void LoginPanel() {
		loginpanel = new JPanel(null);

		JPanel smallpanel1 = new JPanel(null);
		smallpanel1.setBounds(290, 140, 400, 400);
		loginpanel.add(smallpanel1);

		JLabel Admin = new JLabel("ADMIN LOGIN PANEL");
		Admin.setBounds(116, 25, 190, 84);
		smallpanel1.add(Admin);
		Admin.setFont(new Font("Tahoma", Font.ITALIC, 20));

		JLabel label1 = new JLabel("Username ");
		label1.setBounds(21, 111, 75, 50);
		smallpanel1.add(label1);
		label1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel label2 = new JLabel("Password ");
		label2.setBounds(21, 183, 72, 50);
		smallpanel1.add(label2);
		label2.setFont(new Font("Tahoma", Font.PLAIN, 15));

		loginbutton = new JButton("LOGIN");
		loginbutton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginbutton.setBounds(107, 285, 100, 40);
		smallpanel1.add(loginbutton);

		logincancelbutton = new JButton("CANCEL");
		logincancelbutton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		logincancelbutton.setBounds(232, 285, 100, 40);
		smallpanel1.add(logincancelbutton);

		pass = new JPasswordField();
		pass.setBounds(100, 191, 250, 40);
		smallpanel1.add(pass);

		user = new JTextField();
		user.setBounds(100, 119, 250, 40);
		smallpanel1.add(user);
		logincancelbutton.addActionListener(this);
		loginbutton.addActionListener(this);

		JPanel longerpanel1 = new JPanel(null);
		longerpanel1.setBackground(Color.black);
		longerpanel1.setBounds(0, 0, 1000, 1000);
		loginpanel.add(longerpanel1);
	}

	private void AdminChoicePanel() {
		adminchoicepanel = new JPanel(null);

		collectionbookbutton = new JButton("COLLECTION OF BOOKS");
		collectionbookbutton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		collectionbookbutton.setBounds(370, 270, 250, 50);
		collectionbookbutton.addActionListener(this);
		adminchoicepanel.add(collectionbookbutton);

		borrowedbookbutton = new JButton("BORROWED BOOKS");
		borrowedbookbutton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		borrowedbookbutton.setBounds(370, 350, 250, 50);
		borrowedbookbutton.addActionListener(this);
		adminchoicepanel.add(borrowedbookbutton);

		adchoicelogoutbutton = new JButton("LOGOUT");
		adchoicelogoutbutton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		adchoicelogoutbutton.setBounds(550, 190, 120, 30);
		adchoicelogoutbutton.addActionListener(this);
		adminchoicepanel.add(adchoicelogoutbutton);

		JPanel adchoicesmallpanel = new JPanel(null);
		adchoicesmallpanel.setBounds(290, 140, 400, 400);
		adminchoicepanel.add(adchoicesmallpanel);

		JPanel adchoicelongerpanel = new JPanel(null);
		adchoicelongerpanel.setBackground(Color.black);
		adchoicelongerpanel.setBounds(0, 0, 1000, 1000);
		adminchoicepanel.add(adchoicelongerpanel);

	}

	public void AddBookPanel() {
		addbookpanel = new JPanel(null);

		addbooksavebutton = new JButton("SAVE");
		addbooksavebutton.addActionListener(this);
		addbooksavebutton.setBounds(127, 266, 85, 21);
		addbookpanel.add(addbooksavebutton);

		addbookcancelbutton = new JButton("CANCEL");
		addbookcancelbutton.setBounds(222, 266, 85, 21);
		addbookcancelbutton.addActionListener(this);
		addbookpanel.add(addbookcancelbutton);

	}

	private void CollectionOfBookPanel() {
		Logger.info("asdf");
		collectionbookpanel = new JPanel(null);
		String[] Title1 = { " TITLE ", " AUTHOR ", " GENRE ", " RELEASE DATE ", " ID NUMBER ", "AVAILABILITY" };
		ArrayList<Book> books = manager.getBooks();
		String[][] bookData = new String[books.size()][Title1.length];
		for (int i = 0; i < bookData.length; i++) {
			bookData[i][0] = books.get(i).getTitle();
			bookData[i][1] = books.get(i).getAuthor().toString();
			bookData[i][2] = books.get(i).getGenres().toString();
			bookData[i][3] = new Date(2000, 11, 04).toString(); // TODO
			bookData[i][4] = Integer.toString(books.get(i).getId());
			bookData[i][5] = "AVAILABLE"; // TODO
		}

		DefaultTableModel tablemodel = new DefaultTableModel(bookData, Title1) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		collectionbooktable = new JTable(tablemodel);
		collectionbooktable.setBounds(140, 300, 700, 100);
		collectionbooktable.getTableHeader().setBounds(140, 250, 700, 50);
		collectionbooktable.getTableHeader().setReorderingAllowed(false);
		collectionbookpanel.add(collectionbooktable.getTableHeader());
		collectionbookpanel.add(collectionbooktable);

		adchoicebackbutton = new JButton("BACK");
		adchoicebackbutton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		adchoicebackbutton.setBounds(150, 170, 100, 30);
		adchoicebackbutton.addActionListener(this);
		collectionbookpanel.add(adchoicebackbutton);

		addbooksbutton = new JButton("ADD BOOKS");
		addbooksbutton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addbooksbutton.setBounds(350, 440, 130, 30);
		addbooksbutton.addActionListener(this);
		collectionbookpanel.add(addbooksbutton);

		removebooksbutton = new JButton("REMOVE BOOKS");
		removebooksbutton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		removebooksbutton.setBounds(500, 440, 150, 30);
		removebooksbutton.addActionListener(this);
		collectionbookpanel.add(removebooksbutton);

		modifybooksbutton = new JButton("MODIFY BOOKS");
		modifybooksbutton.setBounds(336, 343, 150, 30);
		modifybooksbutton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		collectionbookpanel.add(modifybooksbutton);

		logoutbutton = new JButton("LOGOUT");
		logoutbutton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		logoutbutton.setBounds(658, 32, 90, 30);
		collectionbookpanel.add(logoutbutton);

		JPanel adsmallpanel1 = new JPanel(null);
		adsmallpanel1.setBounds(90, 140, 800, 400);
		collectionbookpanel.add(adsmallpanel1);

		modifybooksbutton.addActionListener(this);
		logoutbutton.addActionListener(this);

		JPanel adlongerpanel1 = new JPanel(null);
		adlongerpanel1.setBackground(Color.black);
		adlongerpanel1.setBounds(0, 0, 1000, 1000);
		collectionbookpanel.add(adlongerpanel1);

	}

	private void BorrowedBookPanel() {
		borrowedbookpanel = new JPanel(null);
		String[] Titles = { " TITLE ", " AUTHOR ", " GENRE ", " RELEASE DATE ", " ID NUMBER ", "AVAILABILITY" };
		String[][] bookset = { { "Harry Potter", "J.K Rowling", "FICTION", "06-26-1997", " ", "Available" },
				{ "PRIDE AND PREJUDICE", "JANE AUSTEN", "ROMANCE", "01-28-1813", " ", "Not Available" } };

		DefaultTableModel tablemodel2 = new DefaultTableModel(bookset, Titles) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		borrowedbooktable = new JTable(tablemodel2);
		borrowedbooktable.setBounds(140, 300, 700, 100);
		borrowedbooktable.getTableHeader().setBounds(140, 250, 700, 50);
		borrowedbooktable.getTableHeader().setReorderingAllowed(false);
		borrowedbookpanel.add(borrowedbooktable.getTableHeader());
		borrowedbookpanel.add(borrowedbooktable);

		borrowedbookbbackutton = new JButton("BACK");
		borrowedbookbbackutton.setBounds(150, 170, 100, 30);
		borrowedbookbbackutton.addActionListener(this);
		borrowedbookpanel.add(borrowedbookbbackutton);

		/*
		 * addbooksbutton = new JButton("ADD BOOKS");
		 * addbooksbutton.setBounds(350,430,130,40);
		 * addbooksbutton.addActionListener(this);
		 * borrowedbookpanel.add(addbooksbutton);
		 * 
		 * removebooksbutton = new JButton("REMOVE BOOKS");
		 * removebooksbutton.setBounds(500,430,150,40);
		 * removebooksbutton.addActionListener(this);
		 * borrowedbookpanel.add(removebooksbutton);
		 * 
		 * modifybooks = new JButton("MODIFY BOOKS");
		 * modifybooks.setBounds(450,480,130,40); modifybooks.addActionListener(this);
		 * borrowedbookpanel.add(modifybooks);
		 * 
		 * logoutbutton = new JButton("LOGOUT"); logoutbutton.setBounds(700,170,90,30);
		 * logoutbutton.addActionListener(this); borrowedbookpanel.add(logoutbutton);
		 */

		JPanel adsmallpanel1 = new JPanel(null);
		adsmallpanel1.setBounds(90, 140, 800, 400);
		borrowedbookpanel.add(adsmallpanel1);

		JPanel adlongerpanel1 = new JPanel(null);
		adlongerpanel1.setBackground(Color.black);
		adlongerpanel1.setBounds(0, 0, 1000, 1000);
		borrowedbookpanel.add(adlongerpanel1);

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

		backbutton = new JButton("BACK");
		backbutton.setBounds(300, 170, 100, 30);
		backbutton.addActionListener(this);
		studentpanel.add(backbutton);

		JPanel studentsmallpanel = new JPanel(null);
		studentsmallpanel.setBounds(290, 140, 400, 400);
		studentpanel.add(studentsmallpanel);

		JPanel stulongerpanel = new JPanel(null);
		stulongerpanel.setBackground(Color.black);
		stulongerpanel.setBounds(0, 0, 1000, 1000);
		studentpanel.add(stulongerpanel);
	}

	public static void main(String[] args) {
		Logger.initialize(new PrintStream[] { System.out });
		new Program();
	}

	@Override
	public void actionPerformed(ActionEvent mainbuttonsevent) {
		String username = user.getText();
		String password = String.valueOf(pass.getPassword());

		if (mainbuttonsevent.getSource() == mainadminbutton) {
			layout.show(Fpanel, "LOGINPANEL");

		} else if (mainbuttonsevent.getSource() == mainstudentbutton) {
			layout.show(Fpanel, "STUDENT");

		}
		if (mainbuttonsevent.getSource() == loginbutton) {
			if (username.equals("admin") && password.equals("1234")) {
				layout.show(Fpanel, "ADMINCHOICEPANEL");
			} else if (!username.equals(username) && password.equals(password)
					|| username.equals(username) && !password.equals(password)) {
				JOptionPane.showMessageDialog(Fpanel, "Incorrect password");

			} else if (!username.equals(username) && !password.equals(password)) {
				JOptionPane.showMessageDialog(Fpanel, "Incorrect password");
			} else if (username.equals(username) || username.equals("") && password.equals("")) {
				JOptionPane.showMessageDialog(Fpanel, "Input a valid username and password");

			}
		} else if (mainbuttonsevent.getSource() == logincancelbutton) {
			layout.show(Fpanel, "BPANEL");

		}
		if (mainbuttonsevent.getSource() == searchbutton) {
			JOptionPane.showMessageDialog(Fpanel,
					"Book: \n Author: \n Genre: \n Release Date: \n ID Number: \n Status(Available/Not Available \n)");
		} else if (mainbuttonsevent.getSource() == backbutton) {
			layout.show(Fpanel, "BPANEL");
		}

		actionPerformed1(mainbuttonsevent);
	}

	public void actionPerformed1(ActionEvent adminchoicebuttonsevent) {

		if (adminchoicebuttonsevent.getSource() == collectionbookbutton) {
			layout.show(Fpanel, "COLLECTIONBOOKPANEL");
		} else if (adminchoicebuttonsevent.getSource() == borrowedbookbutton) {
			layout.show(Fpanel, "BORROWEDBOOKPANEL");

		} else if (adminchoicebuttonsevent.getSource() == adchoicebackbutton) {
			layout.show(Fpanel, "ADMINCHOICEPANEL");

		} else if (adminchoicebuttonsevent.getSource() == borrowedbookbbackutton) {
			layout.show(Fpanel, "ADMINCHOICEPANEL");

		} else if (adminchoicebuttonsevent.getSource() == adchoicelogoutbutton) {
			layout.show(Fpanel, "LOGINPANEL");
			user.setText("");
			pass.setText("");

		}
		if (adminchoicebuttonsevent.getSource() == addbooksbutton) {

			JFrame addbookframe = new JFrame("ADDING BOOKS");
			addbookframe.setSize(450, 450);
			addbookframe.setResizable(false);
			addbookframe.setVisible(true);
			addbookframe.add(addbookpanel);

			JLabel BookPanelTitle = new JLabel("ADDING BOOKS PANEL");
			BookPanelTitle.setBounds(130, 12, 250, 26);
			addbookpanel.add(BookPanelTitle);

			JLabel titlename = new JLabel("TITLE ");
			titlename.setBounds(50, 47, 41, 40);
			addbookpanel.add(titlename);

			title = new JTextField();
			title.setBounds(140, 48, 200, 40);
			addbookpanel.add(title);

			JLabel authorname = new JLabel("AUTHOR");
			authorname.setBounds(44, 97, 51, 40);
			addbookpanel.add(authorname);

			author = new JTextField();
			author.setBounds(140, 98, 200, 40);
			addbookpanel.add(author);

			JLabel genrecategory = new JLabel("GENRE ");
			genrecategory.setBounds(44, 147, 100, 46);
			addbookpanel.add(genrecategory);

			genre = new JTextField();
			genre.setBounds(140, 151, 200, 40);
			addbookpanel.add(genre);

			JLabel releasedate = new JLabel("RELEASE DATE");
			releasedate.setBounds(39, 203, 250, 40);
			addbookpanel.add(releasedate);

			ReleaseDate = new JTextField();
			ReleaseDate.setBounds(140, 201, 200, 40);
			addbookpanel.add(ReleaseDate);
		}
		if (adminchoicebuttonsevent.getSource() == addbooksavebutton) {
			JOptionPane.showMessageDialog(Fpanel, "The book has been added successfully!");
			Book book = new Book(title.getText(), new Author(author.getText()), new Date(),
					EnumSet.of(Book.Genre.FICTION));
			manager.addBook(book);

		} else if (adminchoicebuttonsevent.getSource() == addbookcancelbutton) {
			layout.show(Fpanel, "COLLECTIONBOOKPANEL");
		}

		if (adminchoicebuttonsevent.getSource() == removebooksbutton) {
			int selectedRow = collectionbooktable.getSelectedRow();
			if (selectedRow != -1) {
				DefaultTableModel tablemodel = (DefaultTableModel) collectionbooktable.getModel();
				tablemodel.removeRow(selectedRow);

			}
		}
		if (adminchoicebuttonsevent.getSource() == modifybooksbutton) {
			JFrame modifybookframe = new JFrame("ADDING BOOKS");
			modifybookframe.setSize(450, 450);
			modifybookframe.setResizable(false);
			modifybookframe.setVisible(true);
			modifybookframe.add(addbookpanel);

			JLabel BookPanelTitle = new JLabel("ADDING BOOKS PANEL");
			BookPanelTitle.setBounds(130, 12, 250, 26);
			collectionbookpanel.add(BookPanelTitle);

			JLabel titlename = new JLabel("TITLE ");
			titlename.setBounds(50, 47, 41, 40);
			collectionbookpanel.add(titlename);

			title = new JTextField();
			title.setBounds(140, 48, 200, 40);
			collectionbookpanel.add(title);

			JLabel authorname = new JLabel("AUTHOR");
			authorname.setBounds(44, 97, 51, 40);
			collectionbookpanel.add(authorname);

			author = new JTextField();
			author.setBounds(140, 98, 200, 40);
			collectionbookpanel.add(author);

			JLabel genrecategory = new JLabel("GENRE ");
			genrecategory.setBounds(44, 147, 100, 46);
			collectionbookpanel.add(genrecategory);

			genre = new JTextField();
			genre.setBounds(140, 151, 200, 40);
			collectionbookpanel.add(genre);

			JLabel releasedate = new JLabel("RELEASE DATE");
			releasedate.setBounds(39, 203, 250, 40);
			collectionbookpanel.add(releasedate);

			ReleaseDate = new JTextField();
			ReleaseDate.setBounds(140, 201, 200, 40);
			collectionbookpanel.add(ReleaseDate);

		} else if (adminchoicebuttonsevent.getSource() == logoutbutton) {
			layout.show(Fpanel, "LOGINPANEL");
			user.setText("");
			pass.setText("");

		}

	}
}
