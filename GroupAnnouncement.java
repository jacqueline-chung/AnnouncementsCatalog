/* [Announcement]
 * Name: Jacqueline Chung, Leo Chan, Emily Li
 * Teacher: Mangat Period 4
 * Date: January 6 - January 20, 2015
 */

//These imports are required to use GUI components
import javax.swing.*;
//import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*; 
import java.util.*;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JFrame;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import javax.swing.BoxLayout;

//Class variables can go here (define your buttons, etc)
public class GroupAnnouncement extends JFrame implements ActionListener { //class name now must extend Jframe, turns your program into a program thatdescribes a frame
  
//delcare variables
  /////tabpan2////
  String[ ] club2 = new String[100];
  String[ ] teacher2 = new String[100];
  String[ ] student2 = new String[100];
  String[ ] topic2 = new String[100];
  String[ ] message2 = new String[100]; 
  String[ ] dateofA2 = new String[100];
  //////tabpan3//////
  String[ ] searchclub = new String[100]; 
  String[ ] searchdateofA = new String[100];
  //////tabpan4///////
  String[] columnNames = {"Club/Organization","Topic", "Date Of Announcement", "Message", "Approval"};
  String[] rowData = new String[1000];
  JTable table = new JTable();
  
  int wordCount = 0, numofAnnouncement = 0;
  int  wrongPassword = JOptionPane.ERROR_MESSAGE, information = JOptionPane.INFORMATION_MESSAGE, warning = JOptionPane.INFORMATION_MESSAGE;
  
  //declare panels for tabpan1
  JPanel pan1 = new JPanel();
  JPanel pan2 = new JPanel();
  JPanel pan3 = new JPanel();
  JPanel pan4 = new JPanel();
  JPanel pan5 = new JPanel();
  JPanel pan6 = new JPanel();
  JPanel pan7 = new JPanel();
  JPanel pan8 = new JPanel();
  JPanel pan9 = new JPanel();
  //declare panels for tabpan2
  JPanel pan10 = new JPanel(); 
  JPanel pan11 = new JPanel();
  JPanel pan12 = new JPanel();
  JPanel pan13 = new JPanel();
  JPanel pan14 = new JPanel();  
  JPanel pan15 = new JPanel();
  JPanel pan16 = new JPanel();
  JPanel pan17 = new JPanel();
  JPanel pan18 = new JPanel();
  //declare panels for tabpan3
  JPanel pan19 = new JPanel();
  JPanel pan20 = new JPanel();
  JPanel pan21 = new JPanel();
  JPanel pan22 = new JPanel();
  //declare panels for tabpan4
  JPanel pan23 = new JPanel();
  JPanel pan24 = new JPanel();
  JPanel pan25 = new JPanel();
  //declare panels for tabpan5
  JPanel pan26 = new JPanel();
  JPanel pan27 = new JPanel();
  JPanel pan28 = new JPanel();
  JPanel pan29 = new JPanel();
  JPanel pan30 = new JPanel();
  JPanel pan31 = new JPanel();
  JPanel pan32 = new JPanel();
  JPanel pan33 = new JPanel();
  JPanel pan34 = new JPanel();
  JPanel pan35 = new JPanel();
  
  //JPanel panels
  JPanel tabpan1 = new JPanel();
  JPanel tabpan2 = new JPanel();
  JPanel tabpan3 = new JPanel();
  JPanel tabpan4 = new JPanel();
  JPanel tabpan5 = new JPanel();
  
  // Create a tabbed pane
  JTabbedPane Tabbed = new JTabbedPane(JTabbedPane.TOP); //declare tabbed pane
  
  JScrollPane scroll1 = new JScrollPane();  //declare scroll pane  
  JScrollPane scroll2 = new JScrollPane();  //declare scroll pane  
  JScrollPane scroll3 = new JScrollPane();
  
  //declare method for current date
  public static String currentDate() {
    Date date = Calendar.getInstance().getTime();
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    return sdf.format(date);
  }

    TitledBorder titled = new TitledBorder("Message:"); //declare titled border for searching the message

  //Create some GUI component
  //add text area with scroll bar
  JTextArea message1Area = new JTextArea(10, 50);  
  JTextArea message2Area = new JTextArea(10, 50);  
  
  ///////////////////TEXT FIELD///////////////////////////
//add text field for the informaton from user for tabpan1
  JTextField club1Field = new JTextField(44); 
  JTextField teacher1Field = new JTextField(43); 
  JTextField student1Field = new JTextField(44); 
  JTextField topic1Field = new JTextField(50);
  //JTextField date1Field = new JTextField(47);
  //add text field for the informaton from user for tabpan2
  JTextField club2Field = new JTextField(43); 
  JTextField teacher2Field = new JTextField(42); 
  JTextField student2Field = new JTextField(43); 
  JTextField topic2Field = new JTextField(49);
  JTextField dateofA2Field = new JTextField(40);
  //add text field for tabpan3//
  JTextField searchclubField = new JTextField(45);
  JTextField searchdateofAField = new JTextField(42);
  
  ///////////////LABELS//////////
  //add labels for the titles, club name, teacher supervisor name, student in charge name, topic, current date, and message for tabpan1
  JLabel title1Label = new JLabel("BAYVIEW ANNOUNCEMENTS    |", JLabel.CENTER);
  JLabel club1Label = new JLabel("Club/Organization:", JLabel.CENTER);
  JLabel teacher1Label = new JLabel("Teacher Supervisor:", JLabel.CENTER);
  JLabel student1Label = new JLabel("Student in Charge:", JLabel.CENTER);
  JLabel topic1Label = new JLabel("Topic:", JLabel.CENTER);  
  JLabel date1Label = new JLabel("  " + currentDate(), JLabel.CENTER); //display date
  JLabel message1Label = new JLabel("Message:", JLabel.LEFT);
//add labels for the club name, teacher supervisor name, student in charge name, topic, date of announcement, and message for tabpan2
  JLabel club2Label = new JLabel("Club/Organization:", JLabel.CENTER);
  JLabel teacher2Label = new JLabel("Teacher Supervisor:", JLabel.CENTER);
  JLabel student2Label = new JLabel("Student in Charge:", JLabel.CENTER);
  JLabel topic2Label = new JLabel("Topic:", JLabel.CENTER);  
  JLabel message2Label = new JLabel("Message:", JLabel.LEFT);
  JLabel dateofA2Label = new JLabel ("Date of Announcement: ", JLabel.LEFT);
  //labels for tabpan3
  JLabel searchclubLabel = new JLabel("Club/Organization:", JLabel.CENTER);
  JLabel searchdateofALabel = new JLabel("Date of Announcement:", JLabel.CENTER); 
  JLabel searchmessageLabel = new JLabel("<html>Hey Bayview! Eco-Team will be having their first kick off meeting in rm 108.<br/> We’ll be having ice breakers & talking about our upcoming initiatives.</html>", JLabel.CENTER); 
  
//labels for tabpan4 (table)
  JLabel adminLabel = new JLabel("Announcement Approval", JLabel.CENTER); 
  JLabel passwordLabel = new JLabel("Enter the adminstrative password:", JLabel.CENTER);
  JLabel hintLabel = new JLabel("*Hint: 'admin'", JLabel.CENTER);
  //Help/Info Labels for tabpan5
  JLabel help1Label = new JLabel("This program is used to SUBMIT and READ announcements for Bayview S.S.");
  JLabel help2Label = new JLabel("1. HOME Tab displays annoucements by date (default at current date).");
  JLabel help3Label = new JLabel("a) Students and adminstrator can edit, save, delete and look through announcements by date.", JLabel.CENTER);
  JLabel help4Label = new JLabel("2. SUBMISSION tab is to submit an announcement.", JLabel.CENTER);
  JLabel help5Label = new JLabel("a) Students and administrator can enter the information for and submit the announcements.", JLabel.CENTER);
  JLabel help6Label = new JLabel("*Note: The date format (MM/dd/yyyy) must be entered in correctly; the character limit must be followed", JLabel.CENTER);
  JLabel help7Label = new JLabel("b) Edits and deletes on approved submissions are allowed. *Note: One announcement per club per day", JLabel.CENTER);
  JLabel help8Label = new JLabel("3. SEARCH tab is to search for submitted and approved announcement(s).", JLabel.CENTER);
  JLabel help9Label = new JLabel("4. ADMINISTRATOR tab is to approve announcements. *Password is required", JLabel.CENTER);
  
/////////////BUTTONS/////////////////////
//add buttons for add, delete, edit, previous, next, and search for tabpan1
  JButton yesterdayButton = new JButton("Yesterday");  
  JButton tomorrowButton = new JButton("Tomorrow");
  JButton deleteButton = new JButton("Delete"); 
  JButton saveButton = new JButton("Save"); 
  JButton editButton = new JButton("Edit");
  JButton nextButton = new JButton("Next");
  JButton previousButton = new JButton("Previous");
  //clear and submit buttons for tabpan2
  //JButton clear2Button = new JButton("Clear");
   JButton clearButton = new JButton("Clear");
  JButton submitButton = new JButton ("Submit");
  //search and clear buttons for tabpan3
  JButton searchclearButton = new JButton("Clear Data");
  JButton searchButton = new JButton ("Search");
  //button for Save for tabpan4
 JButton helpButton = new JButton("Help");
  JButton adminsaveButton = new JButton("Save Changes"); 
  
   //declare paddword field
    JTextField passwordField = new JPasswordField();
    Object[] ob = {passwordLabel, passwordField, hintLabel};

  //declare fonts for the title and date
  Font font1 = new Font("Serif", Font.BOLD, 26);
  Font font2 = new Font("Serif", Font.ITALIC, 18);
  
  ////////////////////////////// CONSTRUCTOR - Setup your GUI here//////////////////////////////////
  public GroupAnnouncement() { 
    
   //password dialog box when opening program for admin (students can access w/o admin functions  
    for (int count = 0; count < 5; count++) { //loop four times, putting a limited amount of tries for the password (5)
      JOptionPane.showMessageDialog (null, ob); //dialog pops up      
      String passwordValue = passwordField.getText(); //store value
      
      //Here is some validation code
      if (!passwordValue.equals("admin") && !passwordValue.equals("")) { //if the password is incorrect              
        JOptionPane.showMessageDialog (null, "Incorrect password!", "Error", wrongPassword); //show an error dialog box to tell user their password is incorrect
        System.out.println ("Incorrect password."); //test in console
        adminsaveButton.setEnabled(false); //disable button if admin password is not entered
        
      } else if (passwordValue.equals("admin")) { //if it is correct
        System.out.println ("Correct!"); //test in console
        JOptionPane.showMessageDialog (null, "You have successfully logged in! You have enabled adminstrative functions.", "Message", information); //their password has been stores
        adminsaveButton.setEnabled(true); //enable save changes button
        
        break; //break out of loop
      } else {
        System.out.println ("Remember that if you don't login, you can't approve the announcements."); //test in console
        JOptionPane.showMessageDialog (null, "Remember that if you don't login, you can't approve the announcements.", "Message", information); //their password has been stores
        adminsaveButton.setEnabled(false); //enable save changes button
        
        break; //break out of loop
      }
    }

    setTitle("Announcement Catalog");    //Create a window with a title
    setSize(670, 560);           // set the window size    
    
    //set font for the title and date
    title1Label.setFont (font1);
    date1Label.setFont (font1);
    //set font for Help/Info heading
    help1Label.setFont (font2);
    
    //Add the tabbed pane to this panel
    Tabbed.addTab( "Home" , tabpan1);
    Tabbed.addTab( "Submission", tabpan2);
    Tabbed.addTab( "Search", tabpan3);
    Tabbed.addTab( "Adminstrator", tabpan4);
    Tabbed.addTab( "Help/Info", tabpan5);
    
    add(Tabbed);
    
    //set colour background for the tabs
    tabpan1.setBackground(Color.orange); 
    tabpan2.setBackground(Color.pink);
    tabpan3.setBackground(Color.LIGHT_GRAY);
    tabpan4.setBackground(Color.yellow);
    //set background colour for the panels within each tab
    ////set colour to orange for tabpan1
    pan1.setBackground(Color.orange);
    pan2.setBackground(Color.orange);
    pan3.setBackground(Color.orange);
    pan4.setBackground(Color.orange);
    pan5.setBackground(Color.orange);
    pan6.setBackground(Color.orange);
    pan7.setBackground(Color.orange);
    pan8.setBackground(Color.orange);
    pan9.setBackground(Color.orange);
    ///set pink background colour to tabpan2
    pan10.setBackground(Color.pink);
    pan11.setBackground(Color.pink);
    pan12.setBackground(Color.pink);
    pan13.setBackground(Color.pink);
    pan14.setBackground(Color.pink);
    pan15.setBackground(Color.pink);
    pan16.setBackground(Color.pink);
    pan17.setBackground(Color.pink);
    ///set light gray backround colour to tabpan3
    pan18.setBackground(Color.LIGHT_GRAY);
    pan19.setBackground(Color.LIGHT_GRAY);
    pan20.setBackground(Color.LIGHT_GRAY);
    pan21.setBackground(Color.LIGHT_GRAY);
    pan22.setBackground(Color.LIGHT_GRAY);
    //set yellow background colour to tabpan4
    pan23.setBackground(Color.yellow);
    pan24.setBackground(Color.yellow);
    pan25.setBackground(Color.yellow);
    
    // Create some Layouts    
    GridLayout layout1 = new GridLayout(0,2);       
    FlowLayout layout2 = new FlowLayout();
    
    /////////////////////////TABPAN1/////////////////////////////
    // Set the frame and both panel layouts
    BoxLayout layout6 = new BoxLayout(tabpan1, BoxLayout.PAGE_AXIS);
    
    pan1.setLayout (layout2);
    pan2.setLayout (layout2);
    pan3.setLayout (layout2);
    pan4.setLayout (layout2);
    pan5.setLayout (layout2);
    pan6.setLayout (layout2);
    pan7.setLayout (layout1);
    pan8.setLayout (layout2);
    
    // Add an action listener to the button, this allows the program to know if the button was pressed
    yesterdayButton.addActionListener(this); 
    tomorrowButton.addActionListener(this); 
    deleteButton.addActionListener(this); 
    saveButton.addActionListener(this); 
    saveButton.setEnabled(false); //disable save button
    editButton.addActionListener(this); 
    nextButton.addActionListener(this);
    previousButton.addActionListener(this); 
    
    // Add all the components to the first panel 
    pan1.add (title1Label);
    pan1.add (date1Label);
    //add all components to second panel
    pan2.add (yesterdayButton);
    pan2.add (tomorrowButton);
    //add all components to third panel
    pan3. add (club1Label);
    pan3.add (club1Field);
    pan4.add (teacher1Label);
    pan4.add (teacher1Field);
    pan5.add (student1Label);
    pan5.add (student1Field);
    pan6.add (topic1Label);
    pan6.add (topic1Field);

    pan7.add (message1Label);
    
    //add scroll bar to text area
    scroll1.getViewport().add(message1Area);   //add scroll pane to the text area
    pan8.add(scroll1);
    scroll1.setVerticalScrollBarPolicy (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); //display scrollbar at all times
    
//add all components to fourth panel * maybe change to pan3
    pan9.add (previousButton);
    pan9.add (editButton);
    pan9.add (saveButton);
    pan9.add (deleteButton);
    pan9.add (nextButton);
    
    //add sub panels to the tab panel
    tabpan1.add(pan1);
    tabpan1.add(pan2);
    tabpan1.add(pan3);
    tabpan1.add(pan4);
    tabpan1.add(pan5);
    tabpan1.add(pan6);
    tabpan1.add(pan7);
    tabpan1.add(pan8);
    tabpan1.add(pan9);
    
    /////////////////////////TABPAN2/////////////////////////////
    
    //BoxLayout layout7 = new BoxLayout(tabpan2, BoxLayout.PAGE_AXIS);
    tabpan2.setLayout (layout2);
    
    // Set panel layouts   
    pan10.setLayout (layout2);
    pan11.setLayout (layout2);
    pan12.setLayout (layout2);
    pan13.setLayout (layout2);
    pan14.setLayout (layout2);
    pan15.setLayout (layout2);
    pan16.setLayout (layout2);
    pan17.setLayout (layout2);
    
    //add Action Listener to buttons
    submitButton.addActionListener(this); 
    clearButton.addActionListener(this);  
    
    //add buttons to panel
    pan17.add (clearButton);
    pan17.add (submitButton);
    
    //add components to tabpan2
    pan10.add (club2Label);
    pan10.add (club2Field);
    pan11.add (teacher2Label);
    pan11.add (teacher2Field);
    pan12.add (student2Label);
    pan12.add (student2Field);
    pan13.add (topic2Label);
    pan13.add (topic2Field); 
    pan14.add (dateofA2Label);
    pan14.add (dateofA2Field); 
    pan15.add (message2Label);   
    
    //set text fields
    student2Field.setText ("First then Last (more than one student is allowed)"); //set TextField to give user an example
    dateofA2Field.setText ("dd/mm/yyyy"); //set TextField to give user an example
    
    //add scroll bar to text area
    scroll2.getViewport().add(message2Area);   //add scroll pane to the text area
    pan16.add(scroll2);
    scroll2.setVerticalScrollBarPolicy (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); //display scrollbar at all times
    
    message2Area.setText ("  Maximum 140 Characters"); //set TextArea to inform user that the maximum number of characters is 140
    
    //add panels to tabs
    tabpan2.add(pan10);
    tabpan2.add(pan11);
    tabpan2.add(pan12);
    tabpan2.add(pan13);
    tabpan2.add(pan14);
    tabpan2.add(pan15);
    tabpan2.add(pan16);
    tabpan2.add(pan17);
    
    ///////////////////TABPAN3////////////////////
    // Create some Layouts    
    BorderLayout layout3 = new BorderLayout();
    
    tabpan3.setLayout (layout2); //create layout for tabpan3
    
    // Set panel layouts   
    // BoxLayout layout7 = new BoxLayout(pan7, BoxLayout.PAGE_AXIS);
    pan18.setLayout (layout2);
    pan19.setLayout (layout2);
    pan20.setLayout (layout2);
    pan21.setLayout (layout3);
    
    // Add an action listener to the button, this allows the program to know if the button was pressed
    //disable buttons
    searchclearButton.addActionListener(this); 
    searchButton.addActionListener(this); 
    searchButton.setEnabled(false); 
    
    //add components to tabpan3
    pan18.add (searchclubLabel);
    pan18.add (searchclubField);
    pan19.add (searchdateofALabel);
    pan19.add (searchdateofAField); 
  
    //add buttons to panel
    pan20.add (searchclearButton);
    pan20.add (searchButton);
    
    //add message label with titled border    
    searchmessageLabel.setHorizontalAlignment(JLabel.LEFT);
    searchmessageLabel.setBorder (titled);    
    pan21.add (searchmessageLabel);
    
    //add panels to tabs
    tabpan3.add(pan18);
    tabpan3.add(pan19);
    tabpan3.add(pan20);
    tabpan3.add(pan21);
    //tabpan3.add(pan22);
    
    ///////////////TABPAN4////////////////
    
    // Set panel layouts   
    pan23.setLayout (layout2);
    pan24.setLayout (layout2);
    pan25.setLayout (layout2);
    
    // Add an action listener to the button, this allows the program to know if the button was pressed
    adminsaveButton.addActionListener(this); 
    
    //set Font for title
    adminLabel.setFont (font1);
    
    //add components to tabpan3
    pan23.add (adminLabel);
    
    //add table with approval checkboxes
    // pan11.add (adminsaveButton);
    table.setPreferredScrollableViewportSize(new Dimension(550, 300));
    //add scroll bar to table
    scroll3.getViewport().add(table);   //add scroll pane to the table
    scroll3.setVerticalScrollBarPolicy (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); //display scrollbar at all times
    
    //Add the scroll pane to this panel.
    pan24.add(scroll3);
    
    //add message label
    pan25.add (adminsaveButton);    
    
    //add panels to tabs
    tabpan4.add(pan23);
    tabpan4.add(pan24);
    tabpan4.add(pan25);   
    
    ///////////TABPAN5//////////////////
    tabpan5.setLayout (layout2); //create layout for tabpan5
    //************why only align centre?***********
    pan26.setLayout (layout2); //create layout
    pan27.setLayout (layout2); //create layout
    pan28.setLayout (layout2); //create layout
    pan29.setLayout (layout2); //create layout
    pan30.setLayout (layout2); //create layout
    pan31.setLayout (layout2); //create layout
    pan32.setLayout (layout2); //create layout
    
    //add Labels
    pan26.add (help1Label);
    pan27.add (help2Label);
    pan28.add (help3Label);
    pan29.add (help4Label);
    pan30.add (help5Label);
    pan31.add (help6Label);
    pan32.add (help7Label);
    pan33.add (help8Label);
    pan34.add (help9Label);
    
    //add pan
    tabpan5.add (pan26);
    tabpan5.add (pan27);
    tabpan5.add (pan28);
    tabpan5.add (pan29);
    tabpan5.add (pan30);
    tabpan5.add (pan31);
    tabpan5.add (pan32);
    tabpan5.add (pan33);
    tabpan5.add (pan34);
//    tabpan5.add (pan35);
    
    setVisible(true);     
  }
  
///////////////////////////// ACTION LISTENER - This method runs when an event occurs///////////////////////////////
  // Code in here only runs when a user interacts with a component that has an action listener attached to it
  public void actionPerformed(ActionEvent event) {    
    String command = event.getActionCommand();  //find out the name of the component that was used  
    
     ////////////YESTERDAY BUTTON///////////  
    if (command.equals ("Yesterday")) {
      System.out.println ("Yesterday Button pressed"); //test in console
      
      ////////////TOMMOROW BUTTON///////////  
    } else if (command.equals ("Tomorrow")) {
      System.out.println ("Tomorrow Button pressed"); //test in console
      
     ////////////PREVIOUS BUTTON///////////  
    } else if (command.equals ("Previous")) {
      System.out.println ("Previous Button pressed"); //test in console
      
      
     ////////////EDIT BUTTON///////////  
    } else if (command.equals ("Edit")) {
      System.out.println ("Edit Button pressed"); //test in console
      
      
     ////////////DELETE BUTTON///////////  
    } else if (command.equals ("Delete")) {
      System.out.println ("Delete Button pressed"); //test in console
      
      
     ////////////CLEAR BUTTON///////////  
    } else if (command.equals ("Clear")) {
      System.out.println ("Clear Button pressed"); //test in console
      
      club2Field.setText (" "); //set Text blank - erase data
      teacher2Field.setText (" "); //set Text blank - erase data
      student2Field.setText (" "); //set Text blank - erase data
      topic2Field.setText (" "); //set Text blank - erase data
      dateofA2Field.setText (" "); //set Text blank - erase data
      message2Area.setText (" "); //set Text blank - erase data
      
     ////////////SUBMIT BUTTON///////////  
    } else if (command.equals ("Submit")) {
      System.out.println ("Submit Button pressed"); //test in console
      
      int wordCount = message2Area.getText().length(); //declare word count
      
      club2[numofAnnouncement] = club2Field.getText(); //getText receives value from input
      teacher2[numofAnnouncement] = teacher2Field.getText(); //getText receives value from input
      student2[numofAnnouncement] = student2Field.getText(); //getText receives value from input
      topic2[numofAnnouncement] = topic2Field.getText(); //getText receives value from input
      dateofA2[numofAnnouncement] = dateofA2Field.getText(); //getText receives value from input
      message2[numofAnnouncement] = message2Area.getText(); //getText receives value from input
      
      if (club2[numofAnnouncement].equals("") || teacher2[numofAnnouncement].equals("") || student2[numofAnnouncement].equals("") || topic2[numofAnnouncement].equals("") || dateofA2[numofAnnouncement].equals("")) { //if any of fields are empty
         JOptionPane.showMessageDialog (null, "All of the fields must be entered!", "Message", warning); //user did not fill in all the fields
        System.out.println ("All of the fields must be entered!"); //test in console
      }
      
      //Validate the date of announcement(s)
      
      if (!dateofA2[numofAnnouncement].equals("") && !dateofA2[numofAnnouncement].matches("^(3[0-1]|[1][0-9]|[2][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$")) {
        JOptionPane.showMessageDialog (null, "The date must follow the format given. Please try again.", "Message", warning); //user did not fill in all the fields
        System.out.println ("The date must follow the format given. Please try again."); //test in console
        dateofA2Field.setText (" "); //set Text blank - erase data
      }
      if (wordCount > 140) { //if word count is greater than 140 characters
        JOptionPane.showMessageDialog (null, "Maximum of 140 characters. Please try again!", "Error", wrongPassword); //user did not follow rules
        System.out.println ("Maximum of 140 characters. Please try again!"); //test in console
        
        message2Area.setText (" "); //set Text blank - erase data
        
      } 
      
     ////////////CLEAR DATA BUTTON///////////  
    } else if (command.equals ("Clear Data")) {
      System.out.println ("Clear Data Button pressed"); //test in console
      
      searchclubField.setText (" "); //set Text blank - erase data
      searchdateofAField.setText (" "); //set Text blank - erase data
      
     ////////////SEARCH BUTTON///////////  
    } else if (command.equals ("Search")) {
      System.out.println ("Search Button pressed"); //test in console      
      
      if (!searchdateofA[numofAnnouncement].equals("") && !searchdateofA[numofAnnouncement].matches("^(3[0-1]|[1][0-9]|[2][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$")) {
        JOptionPane.showMessageDialog (null, "The date must follow the format given. Please try again.", "Message", warning); //user did not fill in all the fields
        System.out.println ("The date must follow the format given. Please try again."); //test in console
        searchdateofAField.setText (" "); //set Text blank - erase data
      }
      
      ///////SAVE CHANGES BUTTON/////////////
    } else if (command.equals ("Save Changes")) {      
      System.out.println ("Save Changes Button pressed"); //test in console     
    }
  }
  
  public static void main(String[] args) { //Main method
    GroupAnnouncement frame1 = new GroupAnnouncement();  //Start the GUI    
  }  
}

