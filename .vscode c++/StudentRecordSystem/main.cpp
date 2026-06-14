/*
    Group Members:
        1. Ian Njau - 194681
        2. Andrew Kigathi - 220277
        3. Remmy Otieno - 221021
        4. James Kingola - 221747
*/


#include <iostream>
#include <string>

using namespace std;

struct Student {
    int id;
    string name;
    int age;
};

struct Node {
    int id;
    string name;
    int age;
    Node* next;
};

Student students[100];
int count = 0;

Node* head = NULL; 

void addStudent() {
    cout << "Enter ID: ";
    cin >> students[count].id;
    cout << "Enter Name: ";
    cin >> students[count].name;
    cout << "Enter Age: ";
    cin >> students[count].age;
    count++;
}

void displayStudents() {
    for(int i = 0; i < count; i++) {
        cout << students[i].id << " "
            << students[i].name << " "
            << students[i].age << endl;
    }
}

void linearSearch() {
    int id;
    cout << "Enter Student ID: ";
    cin >> id;
    for(int i = 0; i < count; i++) {
        if(students[i].id == id) {
            cout << "Student Found" << endl;
            return;
        }
    }
    cout << "Student Not Found" << endl;
}

void binarySearch() {
    int id;
    cout << "Enter Student ID: ";
    cin >> id;
    int left = 0;
    int right = count - 1;

    while(left <= right) {
        int mid = (left + right) / 2;
        if(students[mid].id == id) {
            cout << "Student Found" << endl;
            return;
        }
        if(id < students[mid].id)
            right = mid - 1;
        else
            left = mid + 1;
    }
    cout << "Student Not Found" << endl;
}

void deleteStudent() {
    int id;
    int position = -1;
    cout << "Enter Student ID: ";
    cin >> id;
    for(int i = 0; i < count; i++) {
        if(students[i].id == id) {
            position = i;
            break;
        }
    }
    if(position == -1) {
        cout << "Student Not Found";
        return;
    }
    for(int i = position; i < count - 1; i++) {
        students[i] = students[i + 1];
    }
    count--;
}

void insertStudent(int id, string name, int age) {
    Node* newNode = new Node();
    newNode->id = id;
    newNode->name = name;
    newNode->age = age;
    newNode->next = NULL;

    if (head == NULL) {
        head = newNode;
    } else {
        Node* temp = head;
        while (temp->next != NULL) {
            temp = temp->next;
        }
        temp->next = newNode;
    }
    cout << "Student added to Linked List.\n";
}

void displayList() {
    if (head == NULL) {
        cout << "Linked List is empty.\n";
        return;
    }
    Node* temp = head;
    while (temp != NULL) {
        cout << temp->id << " " << temp->name << " " << temp->age << endl;
        temp = temp->next;
    }
}

void deleteNode(int id) {
    if (head == NULL) {
        cout << "List is empty.\n";
        return;
    }

    if (head->id == id) {
        Node* temp = head;
        head = head->next;
        delete temp;
        cout << "Student deleted from Linked List.\n";
        return;
    }

    Node* temp = head;
    while (temp->next != NULL && temp->next->id != id) {
        temp = temp->next;
    }

    if (temp->next == NULL) {
        cout << "Student Not Found\n";
        return;
    }

    Node* nodeToDelete = temp->next;
    temp->next = temp->next->next;
    delete nodeToDelete;
    cout << "Student deleted from Linked List.\n";
}

// Main function

int main() {
    //Student s1;
    //Student s2;
    //Student s3;

    /*
    s1.id = 101;
    s1.name = "John";
    s1.age = 20;

    s2.id = 102;
    s2.name = "Alice";
    s2.age = 21;

    s3.id = 103;
    s3.name = "Bob";
    s3.age = 22;

    cout << "--- Sample Students ---\n";
    cout << s1.id << " " << s1.name << " " << s1.age << endl;
    cout << s2.id << " " << s2.name << " " << s2.age << endl;
    cout << s3.id << " " << s3.name << " " << s3.age << endl;
    */

    int choice;
    do {
        cout << "\n--- Student Record Management System ---\n";
        cout << "1. Add Student (Array)\n";
        cout << "2. Display Students (Array)\n";
        cout << "3. Linear Search (Array)\n";
        cout << "4. Binary Search (Array)\n";
        cout << "5. Delete Student (Array)\n";
        cout << "6. Insert Student (Linked List)\n";
        cout << "7. Display Students (Linked List)\n";
        cout << "8. Delete Node (Linked List)\n";
        cout << "9. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch(choice) {
            case 1:
                addStudent();
                break;
            case 2:
                displayStudents();
                break;
            case 3:
                linearSearch();
                break;
            case 4:
                binarySearch();
                break;
            case 5:
                deleteStudent();
                break;
            case 6: {
                int id, age;
                string name;
                cout << "Enter ID: "; cin >> id;
                cout << "Enter Name: "; cin >> name;
                cout << "Enter Age: "; cin >> age;
                insertStudent(id, name, age);
                break;
            }
            case 7:
                displayList();
                break;
            case 8: {
                int id;
                cout << "Enter ID to delete: "; cin >> id;
                deleteNode(id);
                break;
            }
            case 9:
                cout << "Exiting program...\n";
                break;
            default:
                cout << "Invalid choice. Please try again.\n";
        }
    } while(choice != 9);

    return 0;
}