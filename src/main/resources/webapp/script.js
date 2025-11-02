// Registration form handler
document
  .getElementById("registrationForm")
  .addEventListener("submit", function (e) {
    e.preventDefault();
    const messageDiv = document.getElementById("message");
    const firstName = document.getElementById("firstName").value;
    const lastName = document.getElementById("lastName").value;
    const email = document.getElementById("email").value;

    messageDiv.className = "message success";
    messageDiv.textContent = `Registration successful! Welcome, ${firstName} ${lastName} (${email})`;

    // Reset form after 3 seconds
    setTimeout(() => {
      this.reset();
      messageDiv.className = "message";
      messageDiv.textContent = "";
    }, 3000);
  });

// Click counter
let clickCount = 0;
document.getElementById("clickMe").addEventListener("click", function () {
  clickCount++;
  document.getElementById(
    "clickCount"
  ).textContent = `Click count: ${clickCount}`;
  this.textContent = `Clicked ${clickCount} time(s)`;
});

// Hide/Show functionality
document.getElementById("hideShow").addEventListener("click", function () {
  const hiddenDiv = document.getElementById("hiddenDiv");
  hiddenDiv.classList.toggle("hidden");
  this.textContent = hiddenDiv.classList.contains("hidden")
    ? "Show Element"
    : "Hide Element";
});

// Dropdown selection
document
  .getElementById("countrySelect")
  .addEventListener("change", function () {
    const selectedCountry = document.getElementById("selectedCountry");
    const selectedValue = this.value;
    if (selectedValue) {
      const optionText = this.options[this.selectedIndex].text;
      selectedCountry.textContent = `Selected: ${optionText}`;
    } else {
      selectedCountry.textContent = "";
    }
  });
