// 1. VARIABLES
// Use 'const' for DOM elements because the element reference won't change
const titleElement = document.getElementById('app-title');
const statusElement = document.getElementById('app-status');
const nameInput = document.getElementById('nameInput');
const roleInput = document.getElementById('roleInput');
const addBtn = document.getElementById('addBtn');
const memberList = document.getElementById('memberList');

// Use 'let' for data that might change later
let appName = "Awesome Roster App";

// 2. OUTPUTTING DATA
// Writing directly to the HTML Document Object Model (DOM)
titleElement.innerHTML = appName;
statusElement.innerHTML = "System is ready.";

// Writing to the console for debugging
console.log("App Initialized. Variables loaded.");