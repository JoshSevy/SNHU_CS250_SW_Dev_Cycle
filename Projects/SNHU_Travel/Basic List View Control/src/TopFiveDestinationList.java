import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class TopFiveDestinationList {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	TopDestinationListFrame topDestinationListFrame = new TopDestinationListFrame();
                topDestinationListFrame.setTitle("Top 5 Destination List");
                topDestinationListFrame.setVisible(true);
            }
        });
    }
}


class TopDestinationListFrame extends JFrame {
    private DefaultListModel listModel;

    public TopDestinationListFrame() {
        super("Top Five Destination List");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 750);

        listModel = new DefaultListModel();

        // Add Top 5 destinations, descriptions, and pictures.
        // Adding citations for all images used below.
        //File:Kauai (7635267862).jpg. (2024, October 5). Wikimedia Commons.
        //Retrieved November 15, 2025, from https://commons.wikimedia.org/w/index.php?title=File:Kauai_(7635267862).jpg&oldid=933181383.
        addDestinationNameAndPicture("1. Kauai, Hawaii - 11 mile Kalalau Trail Backpacking Adventure.", new ImageIcon(getClass().getResource("/resources/KauaiHawaii.jpg")));
        //File:View of St. Johns, Saba, from Thais Hill (2024).jpg. (2024, August 4). Wikimedia Commons.
        //Retrieved November 15, 2025,
        //from https://commons.wikimedia.org/w/index.php?title=File:View_of_St._Johns,_Saba,_from_Thais_Hill_(2024).jpg&oldid=906338097.
        addDestinationNameAndPicture("2. Coral Bay, St. John's - 7 night Eco Hut Adventure.", new ImageIcon(getClass().getResource("/resources/CoralBayStJohnEco.jpg")));
        //File:The National Red Rocks 10.09.18 (30319919227).jpg. (2025, May 3). Wikimedia Commons.
        //Retrieved November 15, 2025,
        //from https://commons.wikimedia.org/w/index.php?title=File:The_National_Red_Rocks_10.09.18_(30319919227).jpg&oldid=1027400155.
        addDestinationNameAndPicture("3. Morrison, CO - Red Rock Amphitheater Concert & Denver Restaurant Adventure", new ImageIcon(getClass().getResource("/resources/RedrocksCO.jpg")));
        //File:Cour Carrée, Louvre Museum, 2 April 2009.jpg. (2024, November 20). Wikimedia Commons.
        //Retrieved November 15, 2025,
        //from https://commons.wikimedia.org/w/index.php?title=File:Cour_Carr%C3%A9e,_Louvre_Museum,_2_April_2009.jpg&oldid=959449721.
        addDestinationNameAndPicture("4. Paris, France - 4 night Downtown Hotel and Louvre Private Tour", new ImageIcon(getClass().getResource("/resources/LouvreParis.jpg")));
        //File:Central Park New York May 2017 005.jpg. (2024, February 17). Wikimedia Commons.
        //Retrieved November 15, 2025,
        //from https://commons.wikimedia.org/w/index.php?title=File:Central_Park_New_York_May_2017_005.jpg&oldid=852576782.
        addDestinationNameAndPicture("5. New York City, NY - Central Park View Hotel and Broadway ticket Package.", new ImageIcon(getClass().getResource("/resources/nyc.jpg")));
        
        JList list = new JList(listModel);
        JScrollPane scrollPane = new JScrollPane(list);

        TextAndIconListCellRenderer renderer = new TextAndIconListCellRenderer(2);

        list.setCellRenderer(renderer);

        // Customization: change list font and selection colors
        // Updating font for better readability and accessibility
        list.setFont(new Font("SansSerif", Font.BOLD, 18));
        list.setSelectionBackground(Color.DARK_GRAY);
        list.setSelectionForeground(Color.WHITE);

        // Customization: Heading label above the list
        // Similar to example in the assignment tutorial
        JLabel headingLabel = new JLabel("Joshua Sevy's Top 5 Travel Destinations");
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headingLabel.setFont(new Font("SansSerif", Font.BOLD, 24));

        // Add heading at the top of the frame
        getContentPane().add(headingLabel, BorderLayout.NORTH);

        // Keep center scroll pane with the list
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void addDestinationNameAndPicture(String text, Icon icon) {
        TextAndIcon tai = new TextAndIcon(text, icon);
        listModel.addElement(tai);
    }
}


class TextAndIcon {
    private String text;
    private Icon icon;

    public TextAndIcon(String text, Icon icon) {
        this.text = text;
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}


class TextAndIconListCellRenderer extends JLabel implements ListCellRenderer {
    private static final Border NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);

    private Border insideBorder;

    public TextAndIconListCellRenderer() {
        this(0, 0, 0, 0);
    }

    public TextAndIconListCellRenderer(int padding) {
        this(padding, padding, padding, padding);
    }

    public TextAndIconListCellRenderer(int topPadding, int rightPadding, int bottomPadding, int leftPadding) {
        insideBorder = BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding);
        setOpaque(true);

        // Customization: center text and put above destination image
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
        setHorizontalTextPosition(CENTER);
        setVerticalTextPosition(TOP);
        // Customization: space between text and image
        setIconTextGap(10);
    }

    public Component getListCellRendererComponent(JList list, Object value,
    int index, boolean isSelected, boolean hasFocus) {
        // The object from the combo box model MUST be a TextAndIcon.
        TextAndIcon tai = (TextAndIcon) value;

        // Sets text and icon on 'this' JLabel.
        setText(tai.getText());
        setIcon(tai.getIcon());

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        Border outsideBorder;

        if (hasFocus) {
            outsideBorder = UIManager.getBorder("List.focusCellHighlightBorder");
        } else {
            outsideBorder = NO_FOCUS_BORDER;
        }

        setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
        setComponentOrientation(list.getComponentOrientation());
        setEnabled(list.isEnabled());
        setFont(list.getFont());

        return this;
    }

    // The following methods are overridden to be empty for performance
    // reasons. If you want to understand better why, please read:
    //
    // http://java.sun.com/javase/6/docs/api/javax/swing/DefaultListCellRenderer.html#override

    public void validate() {}
    public void invalidate() {}
    public void repaint() {}
    public void revalidate() {}
    public void repaint(long tm, int x, int y, int width, int height) {}
    public void repaint(Rectangle r) {}
}