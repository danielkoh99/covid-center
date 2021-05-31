const userUrl = "http://localhost:5555/api/user";
const covidTestUrl = "http://localhost:5555/actionApi/test";
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
});
const renderTests = (tests) => {
  let HTML = "";

  tests.map((test, idx) => {
    HTML += `
    <tr>
      <th scope="row">${idx + 1}</th>
      <td class="item">${test.cpr_number}</td>
      <td class="item">${test.test_place}</td>
      <td class="item">${test.test_result}</td>
      <td class="item">${test.test_time}</td>
      <td align="center">
    <button class="btn btn-secondary test-btn" onclick="">Update result</button>
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
  let place = testInput.value;
  let date = testDateInput.value;
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
  console.log(data);
  if (place != "") {
    fetch(covidTestUrl, {
      method: "POST",
      body: JSON.stringify(data),
    });
  }
  if (result || place === "") {
    alert("please enter all fields");
  }
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
/*
closeTest.addEventListener("click", () => {
  testPopup.classList.add("d-none");
  tableContainer.style.pointerEvents = "auto";
  tableContainer.style.opacity = "1";
  testTableContainer.style.pointerEvents = "auto";
  testTableContainer.style.opacity = "1";
});*/
/*closeVaccine.addEventListener("click", () => {
  testPopup.classList.add("d-none");
  tableContainer.style.pointerEvents = "auto";
  tableContainer.style.opacity = "1";
  testTableContainer.style.pointerEvents = "auto";
  testTableContainer.style.opacity = "1";
});*/
function getCookie(cname) {
  var name = cname + "=";
  var decodedCookie = decodeURIComponent(document.cookie);
  var ca = decodedCookie.split(";");
  for (var i = 0; i < ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == " ") {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}
getTests();
getUsers();
