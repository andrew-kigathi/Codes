// 1. VARIABLES
const titleElement = document.getElementById('app-title');
const statusElement = document.getElementById('app-status');

// FIXED: Capitalized the 'N' so it matches your functions later on
const firstNameInput = document.getElementById('firstNameInput');
const lastNameInput = document.getElementById('lastNameInput');
const roleInput = document.getElementById('roleInput');
const addBtn = document.getElementById('addBtn');
const memberList = document.getElementById('memberList');

// Use 'let' for data that might change later
let appName = "Awesome Roster App";

// 2. OUTPUTTING DATA
titleElement.innerHTML = appName;
statusElement.innerHTML = "System is ready.";
console.log("App Initialized. Variables loaded.");

// 3 & 4. ARRAYS AND OBJECTS (COMBINED)
let rosterArray = [];

let savedData = localStorage.getItem("mySavedRoster");

if (savedData) {
    // If saved data exists, translate it from a string back into a real JavaScript Array
    rosterArray = JSON.parse(savedData);
    console.log("Data loaded from memory!");
} else {
    // If there is no saved data (first time visiting), create and use the default member
    //creating an object with a method inside it
    const defaultMember = {
        firstName: "Andy",
        lastName: "Blue",
        role: "CEO",
        
        // A method inside an object
        getDetails: function() {
            return this.firstName + " " + this.lastName + " (" + this.role + ")";
        }
    };
    rosterArray.push(defaultMember);
    console.log("No saved data found. Using default.");
}

// FIXED: Removed the rosterArray.length = 0 line that was deleting your loaded data!

console.log("Current Array Length:", rosterArray.length); 

// 5. FUNCTIONS 
const clearInputs = () => {
    firstNameInput.value = "";
    lastNameInput.value = "";
    roleInput.value = "";
};

function handleAddMember() {
    // Get the values from the HTML inputs
    let newFirstName = firstNameInput.value;
    let newLastName = lastNameInput.value;
    let newRole = roleInput.value;

    // Basic validation
    if (newFirstName === "" || newLastName === "" || newRole === "") {
        window.alert("Please fill out all fields!"); 
        return; 
    }

    //validating that firstName, lastName and role are not numbers
    if (!isNaN(newFirstName) || !isNaN(newLastName) || !isNaN(newRole)) {
        window.alert("First Name, Last Name, and Role cannot be numbers!"); 
        return; 
    }

    // Create a new object on the fly
    let newMemberObject = {
        firstName: newFirstName,
        lastName: newLastName,
        role: newRole
    };

    // Push the new object to our array
    rosterArray.push(newMemberObject);

    // Save to LocalStorage
    localStorage.setItem("mySavedRoster", JSON.stringify(rosterArray));
    
    console.log("Member Added!", rosterArray);

    clearInputs(); // Clear the input fields after adding a member
    renderList();  // Update the displayed list after adding a member
}

// Attach the function to the button click event
addBtn.onclick = handleAddMember;

// 6. LOOPS
function renderList() {
    // First, clear out the current HTML list so we don't get duplicates
    memberList.innerHTML = "";

    for (let i = 0; i < rosterArray.length; i++) {
        
        let currentMember = rosterArray[i];
        let displayText = "";

        // Check if the current member has a getDetails method
        if (currentMember.getDetails) {
            displayText = currentMember.getDetails();
        } else {
            displayText = currentMember.firstName + " " + currentMember.lastName + " - " + currentMember.role;
        }

        // Write the new list item into the HTML
        memberList.innerHTML += "<li>" + displayText + "</li>";
    }
}

// Call it once when the app loads to show the default member
renderList();