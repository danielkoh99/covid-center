const userUrl = "http://localhost:5555/api/user";
const covidTestUrl = "http://localhost:5555/api/useraction/test";
let userTable = document.querySelector(".userInfoTable");
const searchInput = document.querySelector(".search");
const testPopup = document.querySelector(".testpop");
const vaccinePopup = document.querySelector(".vaccinepop");
const tableContainer = document.querySelector(".userTable");
const testTableContainer = document.querySelector(".testTableContainer");
const closeTest = document.querySelector(".closeTest");
const personNameTest = document.querySelector(".name");
const personCPRTest = document.querySelector(".cpr");
const closeVaccine = document.querySelector(".closeVaccine");
const personNameVaccine = document.querySelector(".person-name");
const personCPRVaccine = document.querySelector(".person-cpr");
const testTable = document.querySelector(".testTable");
const testForm = document.querySelector(".testForm");
const testSaveBtn = document.querySelector(".saveTest");
const testInput = document.querySelector(".test-input");
const testDateInput = document.querySelector(".date-input");
const positiveResultInput = document.querySelector(".positiveResultInput");
const negativeResultInput = document.querySelector(".negativeResultInput");

let users = [];
let tests = [];
const getUsers = async () => {
  try {
    const res = await fetch(userUrl);
    users = await res.json();

    renderUsers(users);
  } catch (err) {
    console.log(err);
  }
};
const getTests = async () => {
  try {
    const res = await fetch(covidTestUrl);
    tests = await res.json();
    renderTests(tests);
  } catch (err) {
    console.log(err);
  }
};

searchInput.addEventListener("keyup", (e) => {
  const searchTerm = e.target.value.toLowerCase();
  const filteredUsers = users.filter((user) => {
    return (
      user.name.toLowerCase().includes(searchTerm) ||
      user.email.toLowerCase().includes(searchTerm)
    );
  });
  renderUsers(filteredUsers);
  // renderUsers();
});
const renderTests = (tests) => {
  let HTML = "";

  tests.map((test, idx) => {
    HTML += `
    <tr>
      <th scope="row">${idx + 1}</th>
      <td class="item">${test.cprNumber}</td>
      <td class="item">${test.testPlace}</td>
      <td class="item">${test.testResult}</td>
      <td class="item"></td>
      <td align="center">
      <div class="dropdown">
        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
        Edit
      </button>
      <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
        <li><button class="btn btn-secondary dropdown-item test-btn" onclick="getTestPopup()">Add test</button></li>
        <li><button class="btn btn-secondary dropdown-item vaccine" onclick="getVaccinePopup()">Add vaccine</button></li>
      </ul>
    </div>
    </td>
    </tr>  
`;
  });

  testTable.innerHTML = HTML;
};
const renderUsers = (data) => {
  let HTML = "";

  data.map((user, idx) => {
    HTML += `
    <tr>
      <th scope="row">${idx + 1}</th>
      <td class="item">${user.name}</td>
      <td class="item">${user.surname}</td>
      <td class="item">${user.cprNumber}</td>
      <td class="item">${user.email}</td>
      <td align="center">
      <div class="dropdown">
        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
        Edit
      </button>
      <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
        <li><button class="btn btn-secondary dropdown-item test-btn" onclick="getTestPopup('${JSON.stringify(
          user
        )
          .split('"')
          .join("&quot;")}')">Add test</button></li>
        <li><button class="btn btn-secondary dropdown-item vaccine" onclick="getVaccinePopup('${JSON.stringify(
          user
        )
          .split('"')
          .join("&quot;")}')">Add vaccine</button></li>
        <li><button class="btn btn-secondary dropdown-item book onclick="getBookingPopup()">Book a test</button></li>
      </ul>
    </div>
    </td>
    </tr>  
`;
  });

  userTable.innerHTML = HTML;
};

testSaveBtn.addEventListener("click", () => {
  let date = testInput.value;
  let place = testDateInput.value;
  let result = "";
  if (negativeResultInput.checked) {
    positiveResultInput.checked = false;
    result = negativeResultInput.value;
  }
  if (positiveResultInput.checked) {
    negativeResultInput.checked = false;
    result = positiveResultInput.value;
  }
  console.log(result);
  let cpr = personCPRTest.innerHTML;
  let data = {
    cprNumber: cpr,
    testPlace: place,
    testResult: result,
    testTime: date,
  };
  if (cpr || result || place != "") {
    fetch(covidTestUrl, {
      method: "POST",
      body: JSON.stringify(data),
    });
  } else alert("please enter all fields");

  testPopup.classList.add("d-none");
  tableContainer.style.pointerEvents = "auto";
  tableContainer.style.opacity = "1";
  testTableContainer.style.pointerEvents = "auto";
  testTableContainer.style.opacity = "1";
});

const getTestPopup = (user) => {
  console.log(JSON.parse(user));
  let userInfo = JSON.parse(user);
  testPopup.classList.remove("d-none");
  tableContainer.style.pointerEvents = "none";
  tableContainer.style.opacity = "0.3";
  testTableContainer.style.pointerEvents = "none";
  testTableContainer.style.opacity = "0.3";
  personCPRTest.innerHTML = userInfo.cprNumber;
  personNameTest.innerHTML = userInfo.name + "" + userInfo.surname;
};
const getVaccinePopup = (user) => {
  console.log(JSON.parse(user));
  let userInfo = JSON.parse(user);
  vaccinePopup.classList.remove("d-none");
  tableContainer.style.pointerEvents = "none";
  tableContainer.style.opacity = "0.3";
  testTableContainer.style.pointerEvents = "none";
  testTableContainer.style.opacity = "0.3";
  personNameVaccine.innerHTML = userInfo.cprNumber;
  personCPRVaccine.innerHTML = userInfo.name + userInfo.surname;
};
closeTest.addEventListener("click", () => {
  testPopup.classList.add("d-none");
  tableContainer.style.pointerEvents = "auto";
  tableContainer.style.opacity = "1";
  testTableContainer.style.pointerEvents = "auto";
  testTableContainer.style.opacity = "1";
});
closeVaccine.addEventListener("click", () => {
  testPopup.classList.add("d-none");
  tableContainer.style.pointerEvents = "auto";
  tableContainer.style.opacity = "1";
  testTableContainer.style.pointerEvents = "auto";
  testTableContainer.style.opacity = "1";
});
getTests();
getUsers();
