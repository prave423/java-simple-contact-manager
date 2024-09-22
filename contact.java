import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}

class ContactManager {
    private ArrayList<Contact> contacts;

    public ContactManager() {
        contacts = new ArrayList<>();
    }

    // Method to add a new contact
    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }

    // Method to display all contacts
    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    // Method to search for a contact by name
    public void searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Contact found: " + contact);
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    // Method to delete a contact by name
    public void deleteContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contacts.remove(contact);
                System.out.println("Contact deleted successfully!");
                return;
            }
        }
        System.out.println("Contact not found.");
    }
}

public class contact {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Contact Manager ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Clear the input buffer

            switch (choice) {
                case 1:
                    // Add Contact
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    Contact newContact = new Contact(name, phone, email);
                    manager.addContact(newContact);
                    break;
                
                case 2:
                    // View Contacts
                    manager.displayContacts();
                    break;

                case 3:
                    // Search Contact
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    manager.searchContact(searchName);
                    break;

                case 4:
                    // Delete Contact
                    System.out.print("Enter name to delete: ");
                    String deleteName = scanner.nextLine();
                    manager.deleteContact(deleteName);
                    break;

                case 5:
                    System.out.println("Exiting Contact Manager...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
