const userUrl = "http://localhost:5555/api/user";
const covidTestUrl = "http://localhost:5555/actionApi/test";
const covidVaccineURl = "http://localhost:5555/actionApi/vaccine";
let userTable = document.querySelector(".userInfoTable");
const searchInput = document.querySelector(".search");
const testPopup = document.querySelector(".testpop");
const vaccinePopup = document.querySelector(".vaccinepop");
const tableContainer = document.querySelector(".userTable");
const testTableContainer = document.querySelector(".testTableContainer");
const closeTest = document.querySelector(".closeTest");
const personNameTest = document.getElementById("name");
const personName = document.querySelector(".name");
const personCPRTest = document.getElementById("cpr");
const personIDTest = document.getElementById("patientid");
const personIDVaccine = document.getElementById("patientIdVaccine");
const closeVaccine = document.querySelector(".closeVaccine");
const personNameVaccine = document.getElementById("person-name");
const personCPRVaccine = document.getElementById("person-cpr");
const testTable = document.querySelector(".testTable");
const testForm = document.querySelector(".testForm");
const testSaveBtn = document.querySelector(".saveTest");
const EditTestBtn = document.querySelector(".EditTest");
const vaccineSaveBtn = document.querySelector(".saveVaccine");
const testInput = document.querySelector(".test-input");
const testDateInput = document.getElementById("testDate");
const vaccineDateInput = document.getElementById("dateVaccine");
const bookingID = document.getElementById("bookingID");
const bookingStatus = document.getElementById("bookingStatus");
const bookingEdit = document.getElementById("testedit");
const positiveResultInput = document.querySelector(".positiveResultInput");
const negativeResultInput = document.querySelector(".negativeResultInput");
const modal = document.getElementById("exampleModal");
const modalClass = document.querySelector(".modal");

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

const findCpr = (userID)=>{
 return users.find(user=>user.idUser==userID);
}
const renderTests = (tests) => {
  let HTML = "";

  tests.map((test, idx) => {
    HTML += `
    <tr>
      <th scope="row">${test.idbookings}</th>
      <td class="item">(${test.user_id_user})${findCpr(test.user_id_user).cprNumber}</td>
      <td class="item">Covid center</td>
      <td class="item">${test.bookingType_idbookingType.type}</td>
      <td class="item">${test.bookingStatus_idbookingStatus.bookingStatus}</td>
      <td class="item">${test.time}</td>
      <td align="center">
    <button class="btn btn-secondary test-btn" onclick="getBookingPopup('${JSON.stringify(
        test
    )
        .split('"')
        .join("&quot;")}')">Update result</button>
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
      <th scope="row">${user.idUser}</th>
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

testSaveBtn.addEventListener("click", (e) => {
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
  let cpr = personIDTest.value;
  let data = {
    cprNumber: cpr,
    testPlace: place,
    testResult: result,
    testTime: date,
  };

  fetch(covidTestUrl, {
    method: "POST",
    body: JSON.stringify(data),
  });
  testPopup.classList.add("d-none");
  tableContainer.style.pointerEvents = "auto";
  tableContainer.style.opacity = "1";
  testTableContainer.style.pointerEvents = "auto";
  testTableContainer.style.opacity = "1";
});


EditTestBtn.addEventListener("click", (e) => {
  let place = ""

  let cpr = bookingID.value;
  let result=bookingStatus.value;
  let data = {
    cprNumber: cpr,
    testPlace: place,
    testResult: result,
    testTime: "date",
  };

  fetch(covidVaccineURl, {
    method: "PUT",
    body: JSON.stringify(data),
  });
  testPopup.classList.add("d-none");
  tableContainer.style.pointerEvents = "auto";
  tableContainer.style.opacity = "1";
  testTableContainer.style.pointerEvents = "auto";
  testTableContainer.style.opacity = "1";
});

vaccineSaveBtn.addEventListener("click", (e) => {
  let date = vaccineDateInput.value;
  let result = "";

  let cpr = personIDVaccine.value;
  let data = {
    cprNumber: cpr,
    testPlace: "asd",
    testResult: "positive",
    testTime: date,
  };

  fetch(covidVaccineURl, {
    method: "POST",
    body: JSON.stringify(data),
  });
  vaccinePopup.classList.add("d-none");
  tableContainer.style.pointerEvents = "auto";
  tableContainer.style.opacity = "1";
  testTableContainer.style.pointerEvents = "auto";
  testTableContainer.style.opacity = "1";
  location.reload();
});

const getTestPopup = (user) => {
  console.log(JSON.parse(user));
  let userInfo = JSON.parse(user);
  testPopup.classList.remove("d-none");
  tableContainer.style.pointerEvents = "none";
  tableContainer.style.opacity = "0.3";
  testTableContainer.style.pointerEvents = "none";
  testTableContainer.style.opacity = "0.3";
  personName.innerHTML = userInfo.name + "" + userInfo.surname;
  personIDTest.value = userInfo.idUser;
  personCPRTest.value = userInfo.cprNumber;
  personNameTest.value = userInfo.name + "" + userInfo.surname;
};
const getBookingPopup = (booking) => {
  console.log(JSON.parse(booking));
  let bookingInfo = JSON.parse(booking);
  bookingEdit.classList.remove("d-none");
  tableContainer.style.pointerEvents = "none";
  tableContainer.style.opacity = "0.3";
  testTableContainer.style.pointerEvents = "none";
  testTableContainer.style.opacity = "0.3";
  bookingID.value=bookingInfo.idbookings;
  bookingStatus.value=bookingInfo.bookingStatus_idbookingStatus.idbookingStatus;
};

const getVaccinePopup = (user) => {
  console.log(JSON.parse(user));
  let userInfo = JSON.parse(user);
  vaccinePopup.classList.remove("d-none");
  tableContainer.style.pointerEvents = "none";
  tableContainer.style.opacity = "0.3";
  testTableContainer.style.pointerEvents = "none";
  testTableContainer.style.opacity = "0.3";
  personNameVaccine.innerHTML = userInfo.name + "" + userInfo.surname;
  personIDVaccine.value = userInfo.idUser;
  personCPRVaccine.innerHTML ="CPR:"+ userInfo.cprNumber;
};

closeTest.addEventListener("click", () => {
  testPopup.classList.add("d-none");
  tableContainer.style.pointerEvents = "auto";
  tableContainer.style.opacity = "1";
  testTableContainer.style.pointerEvents = "auto";
  testTableContainer.style.opacity = "1";
});
closeVaccine.addEventListener("click", () => {
  vaccinePopup.classList.add("d-none");
  tableContainer.style.pointerEvents = "auto";
  tableContainer.style.opacity = "1";
  testTableContainer.style.pointerEvents = "auto";
  testTableContainer.style.opacity = "1";
});

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
getUsers().then(()=>{
  getTests();
});