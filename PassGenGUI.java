// This class will be used to design all the frontend elements of this password generator. 


// Importing all the packages necessary for the creation of the GUI elements. 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// This class will extend the JFrame class so that we can create the elements for the GUI.
public class PassGenGUI extends JFrame {
    

	private PassGen passwordGenerator;

	// Constructor
    public PassGenGUI(){
    	

        // Calls super to create the frame with a title.
        super("Password Generator");

        // set the size of the GUI and we will prevent it from further being resized.
        setSize(600, 600);
        setResizable(false);

        // we will set the layout to be null to have control over the position and size of our components in this generator.
        setLayout(null);

        // This will terminate the program when the GUI is closed. 
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Centers the GUI.
        setLocationRelativeTo(null);

        // init password generator
        passwordGenerator = new PassGen();

        // This method will allow us to add the GUI components to the frame. 
        addGuiComponents();
    }

    

    // This is the method, which adds all the GUI components to the frame.
    private void addGuiComponents(){
    	

    	

        // Creates the title
        JLabel title = new JLabel("Password Generator");

        // Making the font bold and a set size, I also centered it.
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        

        // set x,y coordinates and width/height values, then I add the title to it.
        title.setBounds(0, 10, 540, 39);
        add(title);

        

        

        // Create a box where the output (once the password has been generated) can be displayed.
        JTextArea passOutput = new JTextArea();

        // Making it immutable so that the text cannot be edited.
        passOutput.setEditable(false);
        passOutput.setFont(new Font("Arial", Font.BOLD, 32));

        // Adding scrollability in case the text becomes too big, I have also set bounds for it.
        JScrollPane passwordOutputPane = new JScrollPane(passOutput);
        passwordOutputPane.setBounds(25, 97, 479, 70);

        // Create a black border around the text area, and then add it. 
        passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passwordOutputPane);

        // create password length label, set it's font and bounds, then add it to the frame.
        JLabel passlength = new JLabel("Password Length (Must be >=4): ");
        passlength.setFont(new Font("Arial", Font.PLAIN, 32));
        passlength.setBounds(25, 215, 272, 39);
        add(passlength);

        // Create a password length input, which takes in how long the passcode should be, then set it's font, border and bounds, finally adding it to the frame.
        JTextArea passlengthinput = new JTextArea();
        passlengthinput.setFont(new Font("Arial", Font.PLAIN, 32));
        passlengthinput.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passlengthinput.setBounds(310, 215, 192, 39);
        add(passlengthinput);

        

        

       // Next, we will create the password toggle buttons, whereby each component of the Passcode can be toggled (i.e switched on/off depending on whether the user wants those components or not). 
        

        // Uppercase letter toggle
        JToggleButton upToggle = new JToggleButton("Uppercase");
        upToggle.setFont(new Font("Arial", Font.PLAIN, 26));
        upToggle.setBounds(25, 302, 225, 56);
        add(upToggle);

        // Lowercase letter toggle
        JToggleButton lowToggle = new JToggleButton("Lowercase");
        lowToggle.setFont(new Font("Arial", Font.PLAIN, 26));
        lowToggle.setBounds(282, 302, 225, 56);
        add(lowToggle);

        // Numbers toggle
        JToggleButton numToggle = new JToggleButton("Numbers");
        numToggle.setFont(new Font("Arial", Font.PLAIN, 26));
        numToggle.setBounds(25, 373, 225, 56);
        add(numToggle);

        // symbols toggle
        JToggleButton symToggle = new JToggleButton("Symbols");
        symToggle.setFont(new Font("Arial", Font.PLAIN, 26));
        symToggle.setBounds(282, 373, 225, 56);
        add(symToggle);

        // Create the button required to generate the password, users will click on this when they want to generate the password. 
        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Arial", Font.PLAIN, 32));
        generateButton.setBounds(155, 477, 222, 41);
        

        // Creates the actionListener component to identify events. 
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	

                // We can only create the password if the length of the text is at least 4 letters long. So, we will return if the length is smaller than 4.
                if(passlengthinput.getText().length() < 7) 
                	return;
                

                

                // Here, we also ensure that the password contains at least two of the toggle buttons so: 
                

                boolean anyToggleSelected = (lowToggle.isSelected() && upToggle.isSelected())
                		|| (lowToggle.isSelected() && numToggle.isSelected())
                		|| (lowToggle.isSelected() && symToggle.isSelected())
                		|| (upToggle.isSelected() && numToggle.isSelected())
                		|| (upToggle.isSelected() && symToggle.isSelected())
                		|| (numToggle.isSelected() &&  symToggle.isSelected());
                		

                	

                // Generate the password. 
                // Converts the text to an integer value. 
                int passwordLength = Integer.parseInt(passlengthinput.getText());
                

                

                if(anyToggleSelected){
                    String generatedPassword = passwordGenerator.generatePassword(passwordLength,
                            upToggle.isSelected(),
                            lowToggle.isSelected(),
                            numToggle.isSelected(),
                            symToggle.isSelected());

                    // display password back to the user
                    passOutput.setText(generatedPassword);
                }
            }
        });
        add(generateButton);
    }
}

