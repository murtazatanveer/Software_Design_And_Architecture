import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class AccountManagementSystem extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel registerPanel, updatePanel, deletePanel, rolePanel;
    private JTextField regNameField, regEmailField, updateIdField, updateNameField, updateEmailField, deleteIdField, roleIdField;
    private JPasswordField regPasswordField;
    private JComboBox<String> regRoleCombo, roleCombo;
    private JButton regSubmitBtn, updateSubmitBtn, deleteSubmitBtn, roleSubmitBtn;
    private Map<String, User> users = new HashMap<>();

    public AccountManagementSystem() {
        setTitle("Admin Account Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tabbedPane = new JTabbedPane();
        createRegisterPanel();
        createUpdatePanel();
        createDeletePanel();
        createRolePanel();

        tabbedPane.addTab("Register", registerPanel);
        tabbedPane.addTab("Update", updatePanel);
        tabbedPane.addTab("Delete", deletePanel);
        tabbedPane.addTab("Assign Role", rolePanel);

        add(tabbedPane, BorderLayout.CENTER);
    }

    private void createRegisterPanel() {
        registerPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        regNameField = new JTextField();
        regEmailField = new JTextField();
        regPasswordField = new JPasswordField();
        String[] roles = {"Admin", "Manager", "Staff"};
        regRoleCombo = new JComboBox<>(roles);
        regSubmitBtn = new JButton("Register");

        registerPanel.add(new JLabel("Name:"));
        registerPanel.add(regNameField);
        registerPanel.add(new JLabel("Email:"));
        registerPanel.add(regEmailField);
        registerPanel.add(new JLabel("Password:"));
        registerPanel.add(regPasswordField);
        registerPanel.add(new JLabel("Role:"));
        registerPanel.add(regRoleCombo);
        registerPanel.add(new JLabel());
        registerPanel.add(regSubmitBtn);

        regSubmitBtn.addActionListener(e -> {
            String name = regNameField.getText();
            String email = regEmailField.getText();
            String password = new String(regPasswordField.getPassword());
            String role = (String) regRoleCombo.getSelectedItem();
            
            if (!users.containsKey(email)) {
                users.put(email, new User(name, email, password, role));
                JOptionPane.showMessageDialog(this, "User registered successfully");
                clearRegisterFields();
            } else {
                JOptionPane.showMessageDialog(this, "Email already exists");
            }
        });
    }

    private void createUpdatePanel() {
        updatePanel = new JPanel(new GridLayout(5, 2, 10, 10));
        updateIdField = new JTextField();
        updateNameField = new JTextField();
        updateEmailField = new JTextField();
        updateSubmitBtn = new JButton("Update");

        updatePanel.add(new JLabel("User Email:"));
        updatePanel.add(updateIdField);
        updatePanel.add(new JLabel("New Name:"));
        updatePanel.add(updateNameField);
        updatePanel.add(new JLabel("New Email:"));
        updatePanel.add(updateEmailField);
        updatePanel.add(new JLabel());
        updatePanel.add(updateSubmitBtn);

        updateSubmitBtn.addActionListener(e -> {
            String oldEmail = updateIdField.getText();
            String newName = updateNameField.getText();
            String newEmail = updateEmailField.getText();
            
            if (users.containsKey(oldEmail)) {
                User user = users.get(oldEmail);
                user.setName(newName);
                if (!oldEmail.equals(newEmail)) {
                    users.remove(oldEmail);
                    user.setEmail(newEmail);
                    users.put(newEmail, user);
                }
                JOptionPane.showMessageDialog(this, "User updated successfully");
                clearUpdateFields();
            } else {
                JOptionPane.showMessageDialog(this, "User not found");
            }
        });
    }

    private void createDeletePanel() {
        deletePanel = new JPanel(new GridLayout(2, 2, 10, 10));
        deleteIdField = new JTextField();
        deleteSubmitBtn = new JButton("Delete");

        deletePanel.add(new JLabel("User Email:"));
        deletePanel.add(deleteIdField);
        deletePanel.add(new JLabel());
        deletePanel.add(deleteSubmitBtn);

        deleteSubmitBtn.addActionListener(e -> {
            String email = deleteIdField.getText();
            if (users.containsKey(email)) {
                users.remove(email);
                JOptionPane.showMessageDialog(this, "User deleted successfully");
                deleteIdField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "User not found");
            }
        });
    }

    private void createRolePanel() {
        rolePanel = new JPanel(new GridLayout(3, 2, 10, 10));
        roleIdField = new JTextField();
        String[] roles = {"Admin", "Manager", "Staff"};
        roleCombo = new JComboBox<>(roles);
        roleSubmitBtn = new JButton("Assign Role");

        rolePanel.add(new JLabel("User Email:"));
        rolePanel.add(roleIdField);
        rolePanel.add(new JLabel("New Role:"));
        rolePanel.add(roleCombo);
        rolePanel.add(new JLabel());
        rolePanel.add(roleSubmitBtn);

        roleSubmitBtn.addActionListener(e -> {
            String email = roleIdField.getText();
            String newRole = (String) roleCombo.getSelectedItem();
            
            if (users.containsKey(email)) {
                users.get(email).setRole(newRole);
                JOptionPane.showMessageDialog(this, "Role assigned successfully");
                roleIdField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "User not found");
            }
        });
    }

    private void clearRegisterFields() {
        regNameField.setText("");
        regEmailField.setText("");
        regPasswordField.setText("");
    }

    private void clearUpdateFields() {
        updateIdField.setText("");
        updateNameField.setText("");
        updateEmailField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AccountManagementSystem system = new AccountManagementSystem();
            system.setVisible(true);
        });
    }
}

class User {
    private String name;
    private String email;
    private String password;
    private String role;

    public User(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getRole() { return role; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setRole(String role) { this.role = role; }
}