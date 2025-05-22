import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;

class AuctionItem {
    private String id;
    private String name;
    private String description;
    private double currentBid;
    private String highestBidder;

    public AuctionItem(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.currentBid = 0.0;
        this.highestBidder = "No bids yet";
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getCurrentBid() { return currentBid; }
    public String getHighestBidder() { return highestBidder; }

    public boolean placeBid(double amount, String bidderName) {
        if (amount > currentBid) {
            currentBid = amount;
            highestBidder = bidderName;
            return true;
        }
        return false;
    }

    public String getItemDetails() {
        return String.format("ID: %s\nName: %s\nDescription: %s\nCurrent Bid: ₹%.2f\nHighest Bidder: %s",
                id, name, description, currentBid, highestBidder);
    }
}

class AuctionBackend {
    private List<AuctionItem> items;
    private Map<String, AuctionItem> itemMap;
    private AuctionItem currentItem;

    public AuctionBackend() {
        items = new ArrayList<>();
        itemMap = new HashMap<>();
    }

    public void addItem(AuctionItem item) {
        items.add(item);
        itemMap.put(item.getId(), item);
        if (currentItem == null) {
            currentItem = item;
        }
    }

    public List<AuctionItem> getAllItems() {
        return new ArrayList<>(items);
    }

    public AuctionItem getCurrentItem() {
        return currentItem;
    }

    public void setCurrentItem(String itemId) {
        currentItem = itemMap.get(itemId);
    }

    public boolean placeBid(String itemId, double amount, String bidderName) {
        AuctionItem item = itemMap.get(itemId);
        return item != null && item.placeBid(amount, bidderName);
    }
}

class AuctionController {
    private AuctionBackend backend;
    private AuctionGUI gui;

    public AuctionController(AuctionBackend backend, AuctionGUI gui) {
        this.backend = backend;
        this.gui = gui;
    }

    public void addItem(String id, String name, String description) {
        backend.addItem(new AuctionItem(id, name, description));
    }

    public List<AuctionItem> getAllItems() {
        return backend.getAllItems();
    }

    public void setCurrentItem(String itemId) {
        backend.setCurrentItem(itemId);
    }

    public boolean placeBid(String itemId, double amount, String bidderName) {
        return backend.placeBid(itemId, amount, bidderName);
    }

    public AuctionItem getCurrentItem() {
        return backend.getCurrentItem();
    }
}

class AuctionGUISingleton {
    private static AuctionGUISingleton instance;
    private JFrame frame;
    private AuctionController controller;
    private JTextArea adminDisplay;
    private JTextArea itemDetails;
    private JComboBox<String> itemSelector;
    private JTextField bidAmountField;
    private JTextField bidderNameField;

    private AuctionGUISingleton() {
        controller = new AuctionController(new AuctionBackend(), this);
        initialize();
    }

    public static AuctionGUISingleton getInstance() {
        if (instance == null) {
            instance = new AuctionGUISingleton();
        }
        return instance;
    }

    private void initialize() {
        frame = new JFrame("Auction Management System");
        frame.setSize(900, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        JLabel title = new JLabel("Auction Platform", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        frame.add(title, BorderLayout.NORTH);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Arial", Font.PLAIN, 14));

        JPanel adminPanel = createAdminPanel();
        JPanel userPanel = createUserPanel();

        tabbedPane.addTab("Admin Panel", adminPanel);
        tabbedPane.addTab("User Panel", userPanel);
        
        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.add(new JLabel(" Ready", JLabel.LEFT), BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel createAdminPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel controls = new JPanel(new GridLayout(0, 1, 10, 10));
        controls.add(createButton("View All Auction Items", e -> displayAllItems()));
        controls.add(createButton("Add New Item", e -> showAddItemDialog()));
        controls.add(createButton("End Current Auction", e -> endCurrentAuction()));

        adminDisplay = new JTextArea();
        adminDisplay.setEditable(false);
        panel.add(controls, BorderLayout.WEST);
        panel.add(new JScrollPane(adminDisplay), BorderLayout.CENTER);
        return panel;
    }

    private JPanel createUserPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        itemSelector = new JComboBox<>();
        refreshItemSelector();
        itemSelector.addActionListener(e -> updateCurrentItemDisplay());

        JPanel selectionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        selectionPanel.add(new JLabel("Select Item:"));
        selectionPanel.add(itemSelector);

        itemDetails = new JTextArea();
        itemDetails.setEditable(false);
        itemDetails.setFont(new Font("Arial", Font.PLAIN, 14));

        JPanel currentItemPanel = new JPanel(new BorderLayout());
        currentItemPanel.add(selectionPanel, BorderLayout.NORTH);
        currentItemPanel.add(new JScrollPane(itemDetails), BorderLayout.CENTER);
        updateCurrentItemDisplay();

        JPanel bidForm = new JPanel(new GridLayout(4, 2, 10, 10));
        bidForm.setBorder(BorderFactory.createTitledBorder("Place Your Bid"));
        bidAmountField = new JTextField();
        bidderNameField = new JTextField();
        bidForm.add(new JLabel("Your Name:"));
        bidForm.add(bidderNameField);
        bidForm.add(new JLabel("Bid Amount (₹):"));
        bidForm.add(bidAmountField);
        bidForm.add(new JLabel());
        bidForm.add(createButton("Submit Bid", e -> placeBid()));

        panel.add(currentItemPanel, BorderLayout.CENTER);
        panel.add(bidForm, BorderLayout.SOUTH);
        return panel;
    }

    private JButton createButton(String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        return button;
    }

    private void refreshItemSelector() {
        itemSelector.removeAllItems();
        for (AuctionItem item : controller.getAllItems()) {
            itemSelector.addItem(item.getId() + " - " + item.getName());
        }
    }

    private void updateCurrentItemDisplay() {
        String selected = (String) itemSelector.getSelectedItem();
        if (selected != null) {
            String itemId = selected.split(" - ")[0];
            controller.setCurrentItem(itemId);
            itemDetails.setText(controller.getCurrentItem().getItemDetails());
        }
    }

    private void displayAllItems() {
        StringBuilder sb = new StringBuilder();
        for (AuctionItem item : controller.getAllItems()) {
            sb.append(item.getItemDetails()).append("\n\n");
        }
        adminDisplay.setText(sb.toString());
    }

    private void showAddItemDialog() {
        JDialog dialog = new JDialog(frame, "Add New Item", true);
        dialog.setLayout(new GridLayout(4, 2, 10, 10));
        
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField descField = new JTextField();
        
        dialog.add(new JLabel("Item ID:"));
        dialog.add(idField);
        dialog.add(new JLabel("Item Name:"));
        dialog.add(nameField);
        dialog.add(new JLabel("Description:"));
        dialog.add(descField);
        
        dialog.add(createButton("Add", e -> {
            controller.addItem(idField.getText(), nameField.getText(), descField.getText());
            refreshItemSelector();
            dialog.dispose();
        }));
        
        dialog.add(createButton("Cancel", e -> dialog.dispose()));
        dialog.setSize(400, 200);
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }

    private void placeBid() {
        try {
            double amount = Double.parseDouble(bidAmountField.getText());
            String bidderName = bidderNameField.getText();
            String selected = (String) itemSelector.getSelectedItem();
            
            if (selected != null && !bidderName.isEmpty()) {
                String itemId = selected.split(" - ")[0];
                if (controller.placeBid(itemId, amount, bidderName)) {
                    JOptionPane.showMessageDialog(frame, "Bid placed successfully!");
                    updateCurrentItemDisplay();
                    bidAmountField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Bid must be higher than current bid!");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid bid amount");
        }
    }

    private void endCurrentAuction() {
        AuctionItem item = controller.getCurrentItem();
        String message = String.format("Auction ended!\n\n%s\n\nWinner: %s\nWinning Bid: ₹%.2f",
                item.getName(), item.getHighestBidder(), item.getCurrentBid());
        JOptionPane.showMessageDialog(frame, message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> AuctionGUISingleton.getInstance());
    }
}