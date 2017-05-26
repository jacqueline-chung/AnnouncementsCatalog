//package compstudprograms;

/*
 * Names: Emily Lin, Jacqueline Chung, Leo Chan 
 * Title: The final summative - Announcement Catalog program 
 * Description: It allows end user (Cindy Wang & Announcement Team + Teacher Supervisor) to view/read announcements more easily. 
 * ONLY admin can approve of announcements using their password 'admin'. 
 * This is meant for everyone, head/presidents of clubs/organizations, Guidance, teachers, or amdin themselves to submit announcements throughout the week.
 * All the fields must be filled in, and user must follow the correct validation (date, message). 
 * Once submitted, it is passed onto the admin tab where they will approve of announcements (only those who enter int he password).
 * Admin (secretary, teacher supervisor, etc.) will double click 'Approval' column and type in 'yes'. One announcement can be approved at a time.
 * Then, they must 'Save Changes' after every approval for it to work.
 * The approved announcements will be shown on the 'Home' Tab on their repsectful dates (current date as default).
 * This tab allows the announcement team to read through announcements more easily by just a click of a button.
 * Overall, it saves paper and people spend LESS time on writing it out. It will be easier for the Team to read (no messy handwriting).
 * The Fields are disabled until someone wants to edit (not the club name), then save them. 
 * The announcements can also be deleted. User can move back and forth through dates and announcements within each date.
 * The Search Tab is used to efficiently find the messages of desired announcements. The date and club anme msut be entered first.
 * Message will appear inside Titled Border
 * The Help/Info Tab aids the user with formal instructions and reference (acts as a guide).
 * NOT supposed to allow user to repeat announcements (make it harder for the user to repeat announcements)
 * Date: 08/01/15 - 20/01/15
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.EventObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.io.*;
import javax.swing.JTabbedPane;

public class Announcement extends JFrame implements ActionListener {

    static class SingleAnnouncement implements Serializable {

        public String club;
        public String teacher;
        public String student;
        public String topic;
        public String message;
        public Calendar date;
        public String approval;

        public SingleAnnouncement() {
        }

        public SingleAnnouncement(String clubValue, String teacherValue, String studentValue, String topicValue, String messageValue, Calendar dateValue, String approvalValue) {
            club = clubValue;
            teacher = teacherValue;
            student = studentValue;
            topic = topicValue;
            message = messageValue;
            date = dateValue;
            approval = approvalValue;
        }

        // Getter and Setter for Approval 
        public String getApproval() {
            return approval;
        }

        public void setApproval(String approved) {
            this.approval = approved;
        }

        // Getter and Setter for Club 
        public String getClub() {
            return club;
        }

        public void setClub(String club) {
            this.club = club;
        }

        // Getter and Setter for Teacher
        public String getTeacher() {
            return teacher;
        }

        public void setTeacher(String teacher) {
            this.teacher = teacher;
        }

        // Getter and Setter for Student
        public String getStudent() {
            return student;
        }

        public void setStudent(String student) {
            this.student = student;
        }

        // Getter and Setter for Topic
        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }

        // Getter and Setter for Message
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        // Getter and Setter for Date
        public Calendar getDate() {
            return date;
        }

        public void setDate(Calendar date) {
            this.date = date;
        }
    }

    // Class Variables
    // array list stores each singleAnnouncement object
    ArrayList<SingleAnnouncement> allAnnouncements;
    ArrayList<SingleAnnouncement> announcementsToBeApproved = new ArrayList<SingleAnnouncement>();
  // announcementArray.add("Placeholder","Placeholder","Placeholder","Placeholder","Placeholder",)

    // Keeps track of how many times tomorrow and yesterday have been pressed 
    int wordCount = 0, numofAnnouncement = 0;
    int wrongPassword = JOptionPane.ERROR_MESSAGE, information = JOptionPane.INFORMATION_MESSAGE, warning = JOptionPane.INFORMATION_MESSAGE;

    int numDateChanged = 0;

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

    //declare panels for tabpan4
    JPanel pan22 = new JPanel();
    JPanel pan23 = new JPanel();
    JPanel pan24 = new JPanel();

    //declare panels for tabpan5
    JPanel pan25 = new JPanel();
    JPanel pan26 = new JPanel();
    JPanel pan27 = new JPanel();
    JPanel pan28 = new JPanel();
    JPanel pan29 = new JPanel();
    JPanel pan30 = new JPanel();
    JPanel pan31 = new JPanel();
    JPanel pan32 = new JPanel();
    JPanel pan33 = new JPanel();

    //JPanel tab panels
    JPanel tabpan1 = new JPanel();
    JPanel tabpan2 = new JPanel();
    JPanel tabpan3 = new JPanel();
    JPanel tabpan4 = new JPanel();
    JPanel tabpan5 = new JPanel();

    // Create a tabbed pane with scroll panes
    JTabbedPane Tabbed = new JTabbedPane(JTabbedPane.TOP); //declare tabbed pane

    JScrollPane scroll1 = new JScrollPane();  //declare scroll pane  
    JScrollPane scroll2 = new JScrollPane();  //declare scroll pane  
    JScrollPane scroll3 = new JScrollPane();

    // Puts title on border on the Search Tab 
    TitledBorder titled = new TitledBorder("Message: ");

///////////////////TEXT FIELDS///////////////////////////
//add text field for the informaton from user for tabpan1 (Home)
    JTextField clubTextField = new JTextField(44);
    JTextField teacherTextField = new JTextField(43);
    JTextField studentTextField = new JTextField(44);
    JTextField topicTextField = new JTextField(50);
    JTextArea messageTextArea = new JTextArea(10, 50);

    //add text field for the informaton from user for tabpan2 (Submission tab)
    JTextField clubSubmit = new JTextField(43);
    JTextField teacherSubmit = new JTextField(42);
    JTextField studentSubmit = new JTextField(43);
    JTextField topicSubmit = new JTextField(49);
    JTextField dateSubmit = new JTextField(40);
    JTextArea messageSubmit = new JTextArea(10, 50); // Submit Panel  

    //add text field for tabpan3 (Search)
    JTextField clubSearch = new JTextField(45);
    JTextField dateSearch = new JTextField(42);
    JTextField messageSearchField = new JTextField();
    JTable table;
    DefaultTableModel tableModel;

    ///////////////LABELS//////////
    //add labels Home tab 
    JLabel title1Label = new JLabel("BAYVIEW ANNOUNCEMENTS     |", JLabel.CENTER);
    JLabel club1Label = new JLabel("Club/Organization:", JLabel.CENTER);
    JLabel teacher1Label = new JLabel("Teacher Supervisor:", JLabel.CENTER);
    JLabel student1Label = new JLabel("Student in Charge:", JLabel.CENTER);
    JLabel topic1Label = new JLabel("Topic:", JLabel.CENTER);
    JLabel dateLabel = new JLabel(calToString(currentDate()), JLabel.CENTER); //display date
    JLabel message1Label = new JLabel("Message:", JLabel.LEFT);

//add labels for Submission tab 
    JLabel club2Label = new JLabel("Club/Organization:", JLabel.CENTER);
    JLabel teacher2Label = new JLabel("Teacher Supervisor:", JLabel.CENTER);
    JLabel student2Label = new JLabel("Student in Charge:", JLabel.CENTER);
    JLabel topic2Label = new JLabel("Topic:", JLabel.CENTER);
    JLabel message2Label = new JLabel("Message:", JLabel.LEFT);
    JLabel dateofA2Label = new JLabel("Date of Announcement: ", JLabel.LEFT);

    // add labels for search tab 
    JLabel searchclubLabel = new JLabel("Club/Organization:", JLabel.CENTER);
    JLabel searchdateofALabel = new JLabel("Date of Announcement:", JLabel.CENTER);
    JLabel searchmessageLabel = new JLabel("                                                                     ", JLabel.CENTER);

// add labels for table in adminstrator tab 
    JLabel adminLabel = new JLabel("Announcement Approval", JLabel.CENTER);
    JLabel passwordLabel = new JLabel("Enter the password: ", JLabel.CENTER);
    JLabel hintLabel = new JLabel("*Hint: 'admin'", JLabel.CENTER);

//Help/Info Labels for Info/Help tab 
    JLabel help1Label = new JLabel("This program is used to SUBMIT and READ announcements for Bayview S.S.");
    JLabel help2Label = new JLabel("1. HOME Tab displays annoucements by date (default at current date).");
    JLabel help3Label = new JLabel("a) Students and adminstrator can edit (NOT Club Field), save, delete and look through announcements by date.", JLabel.CENTER);
    JLabel help4Label = new JLabel("2. SUBMISSION tab is to submit an announcement.", JLabel.CENTER);
    JLabel help5Label = new JLabel("a) Students and administrator can enter the information for and submit the announcements.", JLabel.CENTER);
    JLabel help6Label = new JLabel("*Note: The date format (dd/mm/yyyy) must be entered in correctly; the character limit must be followed", JLabel.CENTER);
    JLabel help7Label = new JLabel("b) Edits and deletes on approved submissions are allowed. *Note: One announcement per club per day", JLabel.CENTER);
    JLabel help8Label = new JLabel("3. SEARCH tab is to search for the message(s) of submitted and approved announcement(s).", JLabel.CENTER);
    JLabel help9Label = new JLabel("4. ADMINISTRATOR tab is to approve announcements. *Password is required", JLabel.CENTER);
    JLabel help10Label = new JLabel("a) Double click the approval column of desired announcement, then type in 'yes' to approve and press Enter.", JLabel.CENTER);
    JLabel help11Label = new JLabel("*Note: Save changes each time this is done.", JLabel.CENTER);

    /////////////BUTTONS/////////////////////
//add buttons for add, delete, edit, previous, next, and search for home tab 
    JButton yesterdayButton = new JButton("Yesterday");
    JButton tomorrowButton = new JButton("Tomorrow");
    JButton deleteButton = new JButton("Delete");
    JButton saveButton = new JButton("Save");
    JButton editButton = new JButton("Edit");
    JButton nextButton = new JButton("Next");
    JButton previousButton = new JButton("Previous");

    //clear and submit buttons for submission tab 
    JButton clearButton = new JButton("Clear");
    JButton submitButton = new JButton("Submit");

    //search and clear buttons for search tab 
    JButton searchButton = new JButton("Search");
    JButton clearDataButton = new JButton("Clear Data");

//    //buttons for administrator tab 
    JButton adminSaveButton = new JButton("Save Changes");

    //declare password field and objects
    JTextField passwordField = new JPasswordField();
    Object[] ob = {passwordLabel, passwordField, hintLabel};

    //declare fonts for the title and date
    Font font1 = new Font("Serif", Font.BOLD, 26);
    Font font2 = new Font("Serif", Font.ITALIC, 18);

    // Formats the date
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // Header
    String[] header = {"Club", "Topic", "Date", "Message", "Approval"};

    public Announcement() {

//password dialog box when opening program for admin (students can access w/o admin functions)
        for (int count = 0; count < 5; count++) { //loop four times, putting a limited amount of tries for the password (5)
            JOptionPane.showMessageDialog(null, ob); //dialog pops up      
            String passwordValue = passwordField.getText(); //store value

            //Here is some validation code
            if (!passwordValue.equals("admin") && !passwordValue.equals("")) { //if the password is incorrect              
                JOptionPane.showMessageDialog(null, "Incorrect password!", "Error", wrongPassword); //show an error dialog box to tell user their password is incorrect
                System.out.println("Incorrect password."); //test in console
                adminSaveButton.setEnabled(false); //disable button if admin password is not entered

            } else if (passwordValue.equals("admin")) { //if it is correct
                // System.out.println ("Correct!"); //test in console
                JOptionPane.showMessageDialog(null, "You have successfully logged in! You have enabled adminstrative functions.", "Message", information); //their password has been stores
                adminSaveButton.setEnabled(true); //enable save changes button

                break; //break out of loop
            } else { //else
                System.out.println("Remember that if you don't login, you can't approve the announcements."); //test in console
                JOptionPane.showMessageDialog(null, "Remember that if you don't login, you can't approve the announcements.", "Message", information); //their password has been stores
                adminSaveButton.setEnabled(false); //enable save changes button

                break; //break out of loop
            }
        }
        // Generic Frame Setup 
        setTitle("Announcement Catalog");    //Create a window with a title
        setSize(670, 560); // set the window size    

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // stops the program when user exist out of the frame 
        setResizable(false); // prevents user from changing the size 

        getContentPane().add(Tabbed);// 

        //set font for the title and date
        title1Label.setFont(font1);
        dateLabel.setFont(font1);
        //set font for Help/Info heading
        help1Label.setFont(font2);

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
        //set yellow background colour to tabpan4
        pan22.setBackground(Color.yellow);
        pan23.setBackground(Color.yellow);
        pan24.setBackground(Color.yellow);

        // Create some Layouts   
        GridLayout layout1 = new GridLayout(0, 2);
        FlowLayout layout2 = new FlowLayout();

        //The following line enables to use scrolling tabs.
        Tabbed.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        /////////////////////////HOME PANEL/////////////////////////////
        // Set the frame and both panel layouts
        BoxLayout layout6 = new BoxLayout(tabpan1, BoxLayout.PAGE_AXIS);

        // Sets all the layouts for the panels 
        pan1.setLayout(layout2);
        pan2.setLayout(layout2);
        pan3.setLayout(layout2);
        pan4.setLayout(layout2);
        pan5.setLayout(layout2);
        pan6.setLayout(layout2);
        pan7.setLayout(layout1);
        pan8.setLayout(layout2);

        // Add all the components to panels within the tab panel
        pan1.add(title1Label);
        pan1.add(dateLabel);

        pan2.add(yesterdayButton);
        pan2.add(tomorrowButton);

        pan3.add(club1Label);
        pan3.add(clubTextField);

        pan4.add(teacher1Label);
        pan4.add(teacherTextField);

        pan5.add(student1Label);
        pan5.add(studentTextField);

        pan6.add(topic1Label);
        pan6.add(topicTextField);

        pan7.add(message1Label);

        //add scroll bar to text area
        scroll1.getViewport().add(messageTextArea);   //add scroll pane to the text area
        pan8.add(scroll1);
        scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); //display scrollbar at all times

        //add all buttons * maybe change to pan3
        pan9.add(previousButton);
        pan9.add(editButton);
        pan9.add(saveButton);
        pan9.add(deleteButton);
        pan9.add(nextButton);

        //add panels within home tab panel
        tabpan1.add(pan1);
        tabpan1.add(pan2);
        tabpan1.add(pan3);
        tabpan1.add(pan4);
        tabpan1.add(pan5);
        tabpan1.add(pan6);
        tabpan1.add(pan7);
        tabpan1.add(pan8);
        tabpan1.add(pan9);

        /////////////////////////Submission Tab/////////////////////////////
        BoxLayout layout7 = new BoxLayout(tabpan2, BoxLayout.PAGE_AXIS); //set layout for the submission tab

        // Set panel layouts   
        pan10.setLayout(layout2);
        pan11.setLayout(layout2);
        pan12.setLayout(layout2);
        pan13.setLayout(layout2);
        pan14.setLayout(layout2);
        pan15.setLayout(layout2);
        pan16.setLayout(layout2);
        pan17.setLayout(layout2);

        //add components to Submit panel 
        pan10.add(club2Label);
        pan10.add(clubSubmit);
        pan11.add(teacher2Label);
        pan11.add(teacherSubmit);
        pan12.add(student2Label);
        pan12.add(studentSubmit);
        pan13.add(topic2Label);
        pan13.add(topicSubmit);
        pan14.add(dateofA2Label);
        pan14.add(dateSubmit);
        pan15.add(message2Label);

        //set text fields
        studentSubmit.setText("First then Last (more than one student is allowed)"); //set TextField to give user an example
        dateSubmit.setText("dd/mm/yyyy"); //set TextField to give user an example
        messageSubmit.setText("  Maximum 140 Characters"); //set TextArea to inform user that the maximum number of characters is 140

        //add scroll bar to text area
        scroll2.getViewport().add(messageSubmit);   //add scroll pane to the text area
        pan16.add(scroll2);
        scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); //display scrollbar at all times

        //add buttons to panel
        pan17.add(clearButton);
        pan17.add(submitButton);

        //add panels to tabs
        tabpan2.add(pan10);
        tabpan2.add(pan11);
        tabpan2.add(pan12);
        tabpan2.add(pan13);
        tabpan2.add(pan14);
        tabpan2.add(pan15);
        tabpan2.add(pan16);
        tabpan2.add(pan17);

        ///////////////////Search Tab ////////////////////
        tabpan3.setLayout(layout2); //create layout for tabpan3

        // Set panel layouts   
        pan18.setLayout(layout2);
        pan19.setLayout(layout2);
        pan20.setLayout(layout2);
        pan21.setLayout(layout1);

        searchButton.setEnabled(false); //disable search button

        //add components to tabpan3
        pan18.add(searchclubLabel);
        pan18.add(clubSearch);
        pan19.add(searchdateofALabel);
        pan19.add(dateSearch);

        //add buttons to panel
        pan20.add(clearDataButton);
        pan20.add(searchButton);

        //add message label with titled border    
        searchmessageLabel.setHorizontalAlignment(JLabel.LEFT);
        searchmessageLabel.setBorder(titled);
        pan21.add(searchmessageLabel);

        //add panels to tabs
        tabpan3.add(pan18);
        tabpan3.add(pan19);
        tabpan3.add(pan20);
        tabpan3.add(pan21);

        ///////////INFO/HELP TAB //////////////////
        tabpan5.setLayout(layout2); //create layout for tabpan5

        pan25.setLayout(layout2); //create layout
        pan26.setLayout(layout2); //create layout
        pan27.setLayout(layout2); //create layout
        pan28.setLayout(layout2); //create layout
        pan29.setLayout(layout2); //create layout
        pan30.setLayout(layout2); //create layout
        pan31.setLayout(layout2); //create layout
        pan32.setLayout(layout2); //create layout
        pan33.setLayout(layout2); //create layout

        //add Labels
        pan25.add(help1Label);
        pan26.add(help2Label);
        pan27.add(help3Label);
        pan28.add(help4Label);
        pan29.add(help5Label);
        pan30.add(help6Label);
        pan31.add(help7Label);
        pan32.add(help8Label);
        pan33.add(help9Label);

        //add pan
        tabpan5.add(pan26);
        tabpan5.add(pan27);
        tabpan5.add(pan28);
        tabpan5.add(pan29);
        tabpan5.add(pan30);
        tabpan5.add(pan31);
        tabpan5.add(pan32);
        tabpan5.add(pan33);

        /////////////// ADMINISTRATOR TAB ///////////////////
        // Set panel layouts   
        pan22.setLayout(layout2);
        pan23.setLayout(layout2);
        pan24.setLayout(layout2);

        //set Font for title
        adminLabel.setFont(font2);

        //JTable related         
        tableModel = new DefaultTableModel(header, 0);

        // makes columns 0-3 uneditable - only the approval one will be editable 
        table = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0 && column != 1 && column != 2 && column != 3;
            }
        };

        synchronized (this) {
            try {
                wait(1000);
            } catch (InterruptedException e) {
            }
        }

        //set 3 columns to the table
        TableColumn column3 = table.getColumnModel().getColumn(3);
        column3.setCellRenderer(new MessageCellRenderEditor());
        column3.setCellEditor(new MessageCellRenderEditor());
        //size columns
        //column3.setPreferredWidth(300);
        column3.setMinWidth(200);
        column3.setMaxWidth(300);
        table.setRowHeight(100);
        table.setPreferredScrollableViewportSize(new Dimension(550, 300)); //set dimensions
        table.setSelectionMode(SINGLE_SELECTION); // ensures user can only select one row at a time 
        scroll3.getViewport().add(table);   //add scroll pane to the table
        scroll3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); //display scrollbar at all times

        // Adds panels
        pan22.add(adminLabel);
        pan24.add(adminSaveButton);
        pan23.add(scroll3);
        tabpan4.add(pan22);
        tabpan4.add(pan23);
        tabpan4.add(pan24);

//        // Various button or textfield disabling  
//        // Sets buttons to disabled on home page
        saveButton.setEnabled(false);
//
        // Sets textfields to disabled on home page
        clubTextField.setEnabled(false);
        teacherTextField.setEnabled(false);
        studentTextField.setEnabled(false);
        topicTextField.setEnabled(false);
        messageTextArea.setEnabled(false);

        // Adds actionListener to the Buttons
        //add buttons for add, delete, edit, previous, next, and search for home tab 
        yesterdayButton.addActionListener(this);
        tomorrowButton.addActionListener(this);
        deleteButton.addActionListener(this);
        saveButton.addActionListener(this);
        editButton.addActionListener(this);
        nextButton.addActionListener(this);
        previousButton.addActionListener(this);

        //clear and submit buttons for submission tab 
        clearButton.addActionListener(this);
        submitButton.addActionListener(this);

        //search and clear buttons for search tab 
        searchButton.addActionListener(this);
        clearDataButton.addActionListener(this);

        //buttons for administrator tab 
        adminSaveButton.addActionListener(this);

        readData(); //Run the setData method to get information from text document

        // Puts the first announcement of the proper day (will only work if information has already been stored inside it)
        for (SingleAnnouncement ann : allAnnouncements) {
            if (calToString(ann.getDate()).equals(dateLabel.getText())) {
                //set texts
                clubSubmit.setText(ann.getClub());
                teacherSubmit.setText(ann.getTeacher());
                topicSubmit.setText(ann.getTopic());
                dateSubmit.setText(calToString(ann.getDate()));
                break; //breka out of loop
            }
        }

        // Makes the disabled text black (for whatever reason, it pops up as a grey colour without this)
        clubTextField.setDisabledTextColor(Color.BLACK);
        teacherTextField.setDisabledTextColor(Color.BLACK);
        studentTextField.setDisabledTextColor(Color.BLACK);
        topicTextField.setDisabledTextColor(Color.BLACK);
        messageTextArea.setDisabledTextColor(Color.BLACK);

        Tabbed.addTab("Home", tabpan1);
        Tabbed.addTab("Submission", tabpan2);
        Tabbed.addTab("Search", tabpan3);
        Tabbed.addTab("Adminstrator", tabpan4);
        Tabbed.addTab("Help/Info", tabpan5);

        // Sets the information on the Submit page 
        // clears all the textfields
        clubSubmit.setText("");
        teacherSubmit.setText("");
        studentSubmit.setText("First then Last (more than one student is allowed");
        topicSubmit.setText("");
        dateSubmit.setText("");
        messageSubmit.setText("Maximum 140 Characters");

        setVisible(true); // makes it visible

    }

    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        int index; // index of the announcement
        int indexAll;
        String date; // stores the date 
        boolean alreadyExists; // checks to see if the club has already submitted an announcement for that day
        boolean consecutive; // checks to see if they have over 3 consecutive announcements
        SingleAnnouncement tempAnn = null;  // acts as a temporary singleAnnouncement object 

        // Button functions for the home screen
        if (command.equals("Previous")) { // goes to previous announcement (home page)
            index = searchAnnouncement(approvedAnnouncements, clubTextField.getText(), dateLabel.getText()); // determines the index   

            if (index == 0) { // ensures that there isn't an "array out of bounds error"
                tempAnn = approvedAnnouncements.get(index);

                clubTextField.setText(tempAnn.getClub());
                teacherTextField.setText(tempAnn.getTeacher());
                studentTextField.setText(tempAnn.getStudent());
                topicTextField.setText(tempAnn.getTopic());
                messageTextArea.setText(tempAnn.getMessage());
                JOptionPane.showMessageDialog(null, "This is the first announcement of this day");

            } else if (--index >= 0 && index < approvedAnnouncements.size()) { // 
                tempAnn = approvedAnnouncements.get(index); // stores the information in the next announcementArray

                if (calToString(tempAnn.getDate()).equals(dateLabel.getText()) && tempAnn.getApproval().equals("true")) { // checks to see that it is one the same day
                    // sets all of the information 
                    clubTextField.setText(tempAnn.getClub());
                    teacherTextField.setText(tempAnn.getTeacher());
                    studentTextField.setText(tempAnn.getStudent());
                    topicTextField.setText(tempAnn.getTopic());
                    messageTextArea.setText(tempAnn.getMessage());

                } else { // if it is not on the same day 
                    JOptionPane.showMessageDialog(null, "Sorry, there are no more announcements for this day.", "Error", JOptionPane.ERROR_MESSAGE); //show error message dialog box
                }

            } else { // no announcements on this day 
                JOptionPane.showMessageDialog(null, "There are no announcements on this day.");//display message dialog box
            }

        } else if (command.equals("Edit")) { // allows for editing of information (home page)
            // Sets button to pressable mode
            yesterdayButton.setEnabled(false);
            tomorrowButton.setEnabled(false);
            previousButton.setEnabled(false);
            editButton.setEnabled(false);
            deleteButton.setEnabled(false);
            nextButton.setEnabled(false);

            // Sets the save buton to pressable mode
            saveButton.setEnabled(true);

            // Sets the textfields to editable
            clubTextField.setEnabled(false);
            teacherTextField.setEnabled(true);
            studentTextField.setEnabled(true);
            topicTextField.setEnabled(true);
            messageTextArea.setEnabled(true);

            JOptionPane.showMessageDialog(null, "You may now edit the information.");

        } else if (command.equals("Save")) { // allows for saving of updated information (home page)
            index = searchAnnouncement(approvedAnnouncements, clubTextField.getText(), dateLabel.getText());
            int wordCount = messageSubmit.getText().length(); //declare word count

            saveButton.setEnabled(false);

            if (wordCount > 140) { //if word count is greater than 140 characters         
                JOptionPane.showMessageDialog(null, "Maximum of 140 characters. Please try again!", "Error", JOptionPane.ERROR_MESSAGE); //user did not follow rules
                messageSubmit.setText(""); //set Text blank - erase data

            } else {
                // Changes all of the values to new ones
                SingleAnnouncement newAnn = approvedAnnouncements.get(index);
                newAnn.setClub(clubTextField.getText());
                newAnn.setTeacher(teacherTextField.getText());
                newAnn.setStudent(studentTextField.getText());
                newAnn.setMessage(messageTextArea.getText());
                newAnn.setTopic(topicTextField.getText());

                // Re-sorts arrayList
                sortAnnouncements(allAnnouncements);
                sortAnnouncements(approvedAnnouncements);
                JOptionPane.showMessageDialog(null, "Your changes have been saved.");
                // Sets button to pressable mode
                yesterdayButton.setEnabled(true);
                tomorrowButton.setEnabled(true);
                previousButton.setEnabled(true);
                editButton.setEnabled(true);
                deleteButton.setEnabled(true);
                nextButton.setEnabled(true);

                // disable save buton 
                saveButton.setEnabled(false);
                writeData();
            }

        } else if (command.equals("Delete")) { // allows for the deleting of messages (home page)
            index = searchAnnouncement(approvedAnnouncements, clubTextField.getText(), dateLabel.getText());
            indexAll = searchAnnouncement(allAnnouncements, clubTextField.getText(), dateLabel.getText());

            if (index >= 0) {
                // removes the announcement from approvedAnnouncements
                SingleAnnouncement deleted = approvedAnnouncements.remove(index);

                // removes the announcement from allAnnouncements
                allAnnouncements.remove(indexAll);

                SingleAnnouncement ann = null;

                if (index < approvedAnnouncements.size()) {
                    ann = approvedAnnouncements.get(index);

                } else if (approvedAnnouncements.size() > 0) {
                    if (index == approvedAnnouncements.size()) {
                        ann = approvedAnnouncements.get(index - 1);

                    } else {
                        ann = approvedAnnouncements.get(0);
                    }
                }

                // Sets all the fields to blank again
                if (ann != null) {
                    clubTextField.setText(ann.getClub());
                    teacherTextField.setText(ann.getTeacher());
                    studentTextField.setText(ann.getStudent());
                    topicTextField.setText(ann.getTopic());
                    messageTextArea.setText(ann.getMessage());
                } else {
                    clubTextField.setText("");
                    teacherTextField.setText("");
                    studentTextField.setText("");
                    topicTextField.setText("");
                    messageTextArea.setText("");
                }

                sortAnnouncements(approvedAnnouncements);
                writeData();

                // Informs user that the announcement has been deleted 
                JOptionPane.showMessageDialog(null, "This announcement has been deleted");
            }
        } else if (command.equals("Next")) { // goes to the next message of that day (home page)
            index = searchAnnouncement(approvedAnnouncements, clubTextField.getText(), dateLabel.getText());

            if (index == (approvedAnnouncements.size() - 1) && index != -1) { // avoids "array out of bounds" error 
                tempAnn = approvedAnnouncements.get(index);

                clubTextField.setText(tempAnn.getClub());
                teacherTextField.setText(tempAnn.getTeacher());
                studentTextField.setText(tempAnn.getStudent());
                topicTextField.setText(tempAnn.getTopic());
                messageTextArea.setText(tempAnn.getMessage());

                JOptionPane.showMessageDialog(null, "This is the last announcement of this day");

            } else if (++index > 0 && index < approvedAnnouncements.size()) {
                tempAnn = approvedAnnouncements.get(index); // stores the temporary announcement object in the next index 

                // if the date of announcement corresponds to that of the date on the label 
                if (calToString(tempAnn.getDate()).equals(dateLabel.getText()) && tempAnn.getApproval().equals("true")) {

                    // Sets all the information in the correct text fields of the next announcement
                    clubTextField.setText(tempAnn.getClub());
                    teacherTextField.setText(tempAnn.getTeacher());
                    studentTextField.setText(tempAnn.getStudent());
                    topicTextField.setText(tempAnn.getTopic());
                    messageTextArea.setText(tempAnn.getMessage());

                } else {
                    JOptionPane.showMessageDialog(null, "This is the last announcement of this day");
                }

            } else {
                JOptionPane.showMessageDialog(null, "There are no announcements on this day.");
            }

        } else if (command.equals("Yesterday")) { // goes to the previous day (home page)
            numDateChanged--; // keeps track of how many days the date should be pushed back

            try { // attempts to change the date 
                date = changeDate(numDateChanged);
                dateLabel.setText(date);
                showApprovedAnnouncements();
            } catch (ParseException ex) {
                Logger.getLogger(Announcement.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (command.equals("Tomorrow")) { // goes to the next day  (home page)           
            numDateChanged++; // keeps track of how many days the date should be pushed forward 

            try { // attempts to change the date 
                date = changeDate(numDateChanged);
                dateLabel.setText(date); //sets the date on the top to the apporpriate date 
                showApprovedAnnouncements();
            } catch (ParseException ex) {
                Logger.getLogger(Announcement.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (command.equals("Clear")) { // clears all the information (submit page)
            clubSubmit.setText("");
            teacherSubmit.setText("");
            studentSubmit.setText("");
            topicSubmit.setText("");
            dateSubmit.setText("");
            messageSubmit.setText("");

        } else if (command.equals("Submit")) {
            int wordCount = messageSubmit.getText().length(); //declare word count

            //validate text fields
            if (clubSubmit.getText().equals("") || teacherSubmit.getText().equals("") || studentSubmit.getText().equals("") || topicSubmit.getText().equals("") || dateSubmit.getText().equals("") || messageSubmit.getText().equals("")) { //if any of fields are empty
                JOptionPane.showMessageDialog(null, "All of the fields must be entered!", "Message", warning); //user did not fill in all the fields
                System.out.println("All of the fields must be entered!"); //test in console
            }

            //Validate the date of announcement(s)      
            if (!dateSubmit.getText().equals("") && !dateSubmit.getText().matches("^(3[0-1]|[1][0-9]|[2][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$")) {
                JOptionPane.showMessageDialog(null, "The date must follow the format given. Please try again.", "Message", warning); //user did not fill in all the fields
                System.out.println("The date must follow the format given. Please try again."); //test in console
                dateSubmit.setText(" "); //set Text blank - erase data
            }

            // ensures all the fields have been filled out
            if (clubSubmit.getText().trim().length() > 0 && teacherSubmit.getText().trim().length() > 0 && studentSubmit.getText().trim().length() > 0 && topicSubmit.getText().trim().length() > 0 && dateSubmit.getText().trim().length() > 0 && messageSubmit.getText().trim().length() > 0) {

                if (wordCount > 140) { //if word count is greater than 140 characters                   
                    JOptionPane.showMessageDialog(null, "Maximum of 140 characters. Please try again!", "Error", wrongPassword); //user did not follow rules
                    System.out.println("Maximum of 140 characters. Please try again!"); //test in console

                } else {

                    // checks to see if they've already submitted an announcement for that day 
                    alreadyExists = alreadyExists(clubSubmit.getText().trim(), dateSubmit.getText().trim());

                    if (alreadyExists == false) {

                        // creates a temporary singleAnnouncement object 
                        try {
                            tempAnn = new SingleAnnouncement(clubSubmit.getText(), teacherSubmit.getText(),
                                    studentSubmit.getText(), topicSubmit.getText(), messageSubmit.getText(), stringToCal(dateSubmit.getText()), "false");
                        } catch (ParseException ex) {
                            Logger.getLogger(Announcement.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        // adds the announcement to the array that stores all the announcements
                        allAnnouncements.add(tempAnn);

                        // sorts the array        
                        sortAnnouncements(allAnnouncements);

                        // places it on the approval table model 
                        updateApprovals(tableModel);

                        // notifies user that it has been added 
                        JOptionPane.showMessageDialog(null, "Your announcement has been successfully submitted!"); //information); //their password has been stores                

                        writeData(); //Writes all data from allAnnouncements to text document

                        // clears all the textfields
                        clubSubmit.setText("");
                        teacherSubmit.setText("");
                        studentSubmit.setText("First then Last (more than one student is allowed");
                        topicSubmit.setText("");
                        dateSubmit.setText("");
                        messageSubmit.setText("Maximum 140 Characters");

                    } else if (alreadyExists == true) { // already exists on that day 
                        JOptionPane.showMessageDialog(null, "Sorry, you have already submitted an announcement for this day", "Error", JOptionPane.ERROR_MESSAGE);

                        // clears all the textfields
                        clubSubmit.setText("");
                        teacherSubmit.setText("");
                        studentSubmit.setText("First then Last (more than one student is allowed");
                        topicSubmit.setText("");
                        dateSubmit.setText("");
                        messageSubmit.setText("Maximum 140 Characters");
                    }
                }
            }
        } else if (command.equals("Search")) { // search button on the search page 
            System.out.println("Search Button was pressed"); //test in console

            index = searchAnnouncement(allAnnouncements, clubSearch.getText().trim(), dateSearch.getText().trim());

            //validate text fields
            if (clubSearch.getText().equals("") || dateSearch.getText().equals("")) { //if any of fields are empty
                JOptionPane.showMessageDialog(null, "All of the fields must be entered!", "Message", warning); //user did not fill in all the fields
            }

            //Validate the date of announcement(s)     
            if (!dateSearch.getText().equals("") && !dateSearch.getText().matches("^(3[0-1]|[1][0-9]|[2][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$")) {
                JOptionPane.showMessageDialog(null, "The date must follow the format given. Please try again.", "Message", warning); //user did not fill in all the field
                dateSearch.setText(" "); //set Text blank - erase data
            } else if (index == -1 && !clubSearch.getText().equals("") && !dateSearch.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Sorry, this announcement does not exist", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                //declare variables
                String fullmessage = allAnnouncements.get(index).getMessage();
                final int mid = fullmessage.length() / 2;
                String[] parts = {
                    fullmessage.substring(0, mid),
                    fullmessage.substring(mid),};
                searchmessageLabel.setText("<html>" + parts[0] + "<br>" + parts[1] + "<html>");  //output two parts of message on two separate lineslines
            }

        } else if (command.equals("Clear Data")) { // clears data on search page 
            clubSearch.setText("");
            dateSearch.setText("");
            searchmessageLabel.setText("");

        } else if (command.equals("Save Changes")) { // saves changes made on administrator page 
            boolean approvesChanged = false;
            boolean approvalError = false;
            
            for (int i = 0; i < announcementsToBeApproved.size(); i++) {
                SingleAnnouncement ann = announcementsToBeApproved.get(i);
                if (ann.getClub().equals(tableModel.getValueAt(i, 0))
                        && calToString(ann.getDate()).equals(tableModel.getValueAt(i, 2))) {

                    // Updates all of the values 
                    ann.setTopic((String) tableModel.getValueAt(i, 1));
                    ann.setMessage((String) tableModel.getValueAt(i, 3));

                    // checks to see whether or not it has actually been approved 
                    if (tableModel.getValueAt(i, 4).equals("yes")) {
                        //approvesChanged = true;
                        ann.setApproval("true");
                        
                    } else if (tableModel.getValueAt(i, 4).equals("no")) {
                        //approvesChanged = true;
                        ann.setApproval("false");
                        
                    } else {
                        approvalError = true;
                        JOptionPane.showMessageDialog(null, "Approval must either be 'yes' or 'no'", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                i++;
            }

            if (approvalError == false) {
                    updateApprovals(tableModel);
                    showApprovedAnnouncements();
                    JOptionPane.showMessageDialog(null, "Your changes have been saved.");
            }
        }
        writeData();

    }
//********************INPUT********************
//Reads data from file and writes it into array

    public void readData() {
        File file = new File("Announcement.txt"); // file variable will refer to "Announcement.txt" text file 

        if (file.exists()) { // ensures that the file exists to avoid errors
            try {
                // input stream will "input" information from the file into the object
                ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));

                // the information will then be stored into the allAnnouncements array as an object 
                allAnnouncements = (ArrayList<SingleAnnouncement>) input.readObject();
                input.close();
            } catch (Exception e) {
                allAnnouncements = new ArrayList<SingleAnnouncement>();
            }
        } else {
            allAnnouncements = new ArrayList<SingleAnnouncement>();
        }

        // sorts the array        
        sortAnnouncements(allAnnouncements);

        // places it on the approval table model 
        updateApprovals(tableModel);

        showApprovedAnnouncements();
    }

    //********************OUTPUT********************
    // transfers information from the array into the text file 
    public void writeData() {
        File file = new File("Announcement.txt"); // creates a new file object 

        try {
            FileOutputStream fileOut = new FileOutputStream(file); // FileOutputStream will occur to the "Announcement.txt" file

            // Converts info from text file to an object
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            // Places the object into the announcement array
            objectOut.writeObject(allAnnouncements);

            // Ensure all the informatin goes from "memory" into the file 
            objectOut.flush();
            fileOut.flush();

            // Closes the "streams"
            objectOut.close();
            fileOut.close();

        } catch (Exception e) {
            e.printStackTrace();
            file.delete(); // deletes the file so that it won't be "contaminated" by other information
        }
    }

//********************OUTPUT********************
    ArrayList<SingleAnnouncement> approvedAnnouncements = new ArrayList<SingleAnnouncement>();

    public void showApprovedAnnouncements() {
        approvedAnnouncements.clear();
        
        for (SingleAnnouncement ann : allAnnouncements) {
            if (calToString(ann.getDate()).equals(dateLabel.getText())
                    && ann.getApproval().equals("true")) {
                approvedAnnouncements.add(ann);
            }
        }

        if (approvedAnnouncements.size() > 0) {
            SingleAnnouncement ann = approvedAnnouncements.get(0);
            clubTextField.setText(ann.getClub());
            teacherTextField.setText(ann.getTeacher());
            studentTextField.setText(ann.getStudent());
            topicTextField.setText(ann.getTopic());
            messageTextArea.setText(ann.getMessage());

        } else { // nothing to show
            clubTextField.setText("");
            teacherTextField.setText("");
            studentTextField.setText("");
            topicTextField.setText("");
            messageTextArea.setText("");
        }

        sortAnnouncements(approvedAnnouncements);
    }

    public int searchAnnouncement(List<SingleAnnouncement> announcements, String clubTextValue, String dateTextValue) {
        String clubValue; // will store the club value within singleAnnouncement object
        String dateValue; // will store the date value within singleAnnouncement object
        int indexValue = -1;

        for (SingleAnnouncement announcement : announcements) { // looks through arraylist
            clubValue = announcement.getClub().trim();
            dateValue = calToString(announcement.getDate());

            if (clubValue.equals(clubTextValue) && dateValue.equals(dateTextValue)) { // if there is a match
                indexValue = announcements.indexOf(announcement); // finds the index of the match
            }
        }
        return indexValue; // returns the index back
    }

    public Calendar currentDate() { // method to find the current date
        // find the current date
        Calendar currentDate = Calendar.getInstance();

        // return the current date in proper format 
        return currentDate;
    }

    public static String changeDate(int change) throws ParseException { // methods to find the next date 
        Calendar cal = Calendar.getInstance(); // creates a calendar object

        // moves the date back 
        cal.add(Calendar.DATE, change);

        // converts calendar object into a date object 
        Date date = cal.getTime();

        // returns the new date in proper format 
        return sdf.format(date);
    }

    public Calendar stringToCal(String date) throws ParseException { // converts from string to calendar 
        Calendar cal = Calendar.getInstance(); // initalizes the value of calendar object
        cal.setTime(sdf.parse(date)); // sets it to the date passed into the method 
        return cal; // returns the calendar object 
    }

    public String calToString(Calendar cal) { // converts from calendar to string 
        String date; // creates a variable that will store the string version of the date  
        date = sdf.format(cal.getTime());  // converts the calendar object into the date object and formats it 
        return date; // returns the string object 
    }

    // determines if the club has already created an announcement for that day 
    public boolean alreadyExists(String clubValue, String dateValue) {
        boolean alreadyExists = false;
        String tempClubVal;
        String tempDateVal;

        for (SingleAnnouncement announcement : allAnnouncements) { // looks through arraylist
            tempClubVal = announcement.getClub().trim();
            tempDateVal = calToString(announcement.getDate());

            if (clubValue.equals(tempClubVal) && dateValue.equals(tempDateVal)) { // if there is a match
                alreadyExists = true;
            }
        }
        return alreadyExists; // returns the index back      
    }

    // sorts based on whether or not it has approval, then by date and then by club name (alpha)
    public static void sortAnnouncements(List<SingleAnnouncement> list) {
        Collections.sort(list, new Comparator<SingleAnnouncement>() {
            @Override
            public int compare(SingleAnnouncement l, SingleAnnouncement r) {
                int value1 = l.getApproval().compareTo(r.getApproval()); // stores the value that represents what order they're in                                

                if (value1 == 0) { // if they are the same, sort by approval
                    int value2 = l.getDate().compareTo(r.getDate()); // stores the value that represents what order they're in                                                     

                    if (value2 == 0) { // if they are the same, sort by date
                        return l.getClub().compareTo(r.getClub()); // returns the value that represents what order they're in and switches them accordinly
                    } else {
                        return value2;
                    }

                } else { // if there is no match
                    return value1; // returns the value that represents what order they're in and switches them accordinly
                }
            }
        });
    }

    public void updateApprovals(DefaultTableModel tableModel) { // Creates an array for the announcements without approval 
        announcementsToBeApproved.clear();
        String approval;

        if (allAnnouncements != null) {
            for (SingleAnnouncement announcement : allAnnouncements) { // searches through the array 
                approval = announcement.getApproval();  // stores the approval 

                if (approval.equals("false")) { // if the announcement has not been approved
                    announcementsToBeApproved.add(announcement);  // adds it to the array 
                }
            }
        }

        // Sorts the temporary arraylist in terms of date and club name 
        Collections.sort(announcementsToBeApproved, new Comparator<SingleAnnouncement>() {
            @Override
            public int compare(SingleAnnouncement l, SingleAnnouncement r) {
                int value1 = l.getDate().compareTo(r.getDate()); // stores the value that represents what order they're in                                
                if (value1 == 0) { // if they are the same, sort by approval
                    return l.getClub().compareTo(r.getClub()); // stores the value that represents what order they're in                                                   
                } else { // if there is no match 
                    return value1; // returns the value that represents what order they're in and switches them accordinly
                }
            }
        });

        while (tableModel.getRowCount() > 0) { // clear up the model
            tableModel.removeRow(0);
        }

        Object[] row = null;
        if (announcementsToBeApproved.size() > 0) { // if we have announcements to get approval
            for (SingleAnnouncement ann : announcementsToBeApproved) { // add each announcement that needs approval to the table model
                row = new Object[5];
                row[0] = ann.getClub();
                row[1] = ann.getTopic();
                row[2] = calToString(ann.getDate());
                row[3] = ann.getMessage();
                row[4] = "no";

                tableModel.addRow(row);

            }
        }
    }

    // CITATION: 
    // All of this was gotten from this website: http://www.coderanch.com/t/340609/GUI/java/JTable-Custom-Cell-Renderer-JTextArea
    // the scrollpane however, was not actually working as they did not use the viewport method, but other than that, it was all
    // taken from there 
    protected static class MessageCellRenderEditor implements TableCellRenderer, TableCellEditor {

        JTextArea textArea;
        JScrollPane scrollPane;

        MessageCellRenderEditor() {
            textArea = new JTextArea();
            scrollPane = new JScrollPane();
            scrollPane.getViewport().add(textArea);
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable table,
                Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column) {
            textArea.setText((String) value);
            return scrollPane;
        }

        @Override
        public Component getTableCellEditorComponent(
                JTable table,
                Object value,
                boolean isSelected,
                int row,
                int column) {
            textArea.setText((String) value);
            return scrollPane;
        }

        @Override
        public void addCellEditorListener(CellEditorListener l) {
        }

        @Override
        public void cancelCellEditing() {
        }

        @Override
        public Object getCellEditorValue() {
            return textArea.getText();
        }

        @Override
        public boolean isCellEditable(EventObject anEvent) {
            return true;
        }

        @Override
        public void removeCellEditorListener(CellEditorListener l) {
        }

        @Override
        public boolean shouldSelectCell(EventObject anEvent) {
            return true;
        }

        @Override
        public boolean stopCellEditing() {
            return true;
        }
    }

    public static void main(String args[]) throws ParseException {
        Announcement frame1 = new Announcement();
    }
}
