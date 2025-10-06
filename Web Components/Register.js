/**
 * 
 */
 document.getElementById("registrationForm").addEventListener("submit", function(event) {
  event.preventDefault();
  var username = document.getElementById("username").value;
  var email = document.getElementById("email").value;
  var password = document.getElementById("password").value;
  var message = document.getElementById("message");

  // Here you can add validation logic before submitting the form
  if (username === "" || email === "" || password === "") {
    message.innerHTML = "Please fill in all fields.";
    message.style.color = "red";
  } else {
    // In a real scenario, you would submit the form to a server
    // For demonstration purposes, just display the submitted data
    message.innerHTML = "Registration successful!";
    message.style.color = "green";
    console.log("Username:", username);
    console.log("Email:", email);
    console.log("Password:", password);
    // You can also redirect the user to another page after successful registration
  }
});