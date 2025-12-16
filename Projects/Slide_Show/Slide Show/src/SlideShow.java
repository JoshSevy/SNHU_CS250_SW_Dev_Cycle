import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		textPane.setBackground(Color.BLUE);
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Wellness Retreat Destinations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			// Updated font color so the text was more accessible.
            // Used https://www.tutorialspoint.com/how-to-change-jlabel-background-and-foreground-color-in-java
            // as a reference to update the color.
			lblTextArea.setForeground(Color.WHITE);
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){
            /*
             * Note: Keeping existing image for demonstration but altering slide body to represent the wellness/detox requirement.
             */
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/TestImage1.jpg") + "'</body></html>";
		} else if (i==2){
            /*
             * Note: Replace TestImage2.jpg with CaliforniaFitnessCenter.jpg
             * Kotowski, H. (n.d.). Coast of California in the vicinity of Monterey [Photograph].
             * https://commons.wikimedia.org/wiki/File:California_coast.jpg
             */
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/CaliforniaFitnessCenter.jpg") + "'</body></html>";
		} else if (i==3){
            /*
             * Note: Replace TestImage3.jpg with OjoCalienteMineralSprings.jpg
             * Berlin, K (2014). Ojo Caliente mineral springs and resort [Photograph].
             * https://commons.wikimedia.org/wiki/File:Ojo_Caliente_mineral_springs_and_resort_(14500688944).jpg
             */
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/OjoCalienteMineralSprings.jpg") + "'</body></html>";
		} else if (i==4){
            /*
             * Note: Replace TestImage4.jpg with TreeHotelHarads.jpg
             * Steffen, L (2019). Tree hotel Harads, Sweden [Photograph].
             * https://commons.wikimedia.org/wiki/File:The_Mirrorcube,_Treehotel_in_Harads,_Sweden_1_-_Jan_3,_2019.jpg
             */
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/TreehotelHarads.jpg") + "'</body></html>";
		} else if (i==5){
            /*
             * Note: Replace TestImage5.jpg with AnandaInTheHimalayas.jpg
             * Millican, E (2007). Ananda in the Himalayas, India [Photograph].
             * https://commons.wikimedia.org/wiki/File:Himalayan_view_from_Ananda_spa,_Narendra_Nagar.jpg
             */
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/AnandaInTheHimalayas.jpg") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 */
	private String getTextDescription(int i) {
		String text = ""; 
		if (i==1){
            // Updated title and description to reflect wellness retreat
			text = "<html><body><font size='5'>#1 The Grand Canyon Hiking Adventure.</font> <br>Grand Canyon hiking and wellness retreat.</body></html>";
		} else if (i==2){
            // Added California Coast Fitness Camp title and description
			// Added font size to align with slide #1
			// Added short description to align with slide #1
			text = "<html><body><font size='5'>#2 California Coast Fitness Camp.</font> <br>Beautiful Southern California fitness camp and behavioral wellness center.</body></html>";
		} else if (i==3){
            // Added Ojo Caliente Mineral Springs Retreat title and description
			// Added font size to align with slide #1
			// Added short description to align with slide #1
			text = "<html><body><font size='5'>#3 Ojo Caliente Mineral Springs Retreat.</font> <br>Secluded renouned New Mexico healing mineral hotsprings and detoxification retreat.</body></html>";
		} else if (i==4){
            // Added Swedish Artic Bath Wellness Retreat title and description
			// Added font size to align with slide #1
			// Added short description to align with slide #1
			text = "<html><body><font size='5'>#4 Swedish Artic Bath Wellness Retreat and cultural immersion center.</font> <br>World renouned artic baths in the heart of this Swedish wonderland.</body></html>";
		} else if (i==5){
            // Added Ananda in the Himalayas Wellness Spa title and description
			// Added font size to align with slide #1
			// Added short description to align with slide #1
			text = "<html><body><font size = '5'>#5 Ananda in the Himalays Wellness Spa</font> <br> Scenic relaxation retreat deep in Indias side of the Himalayas.</body></html>";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}