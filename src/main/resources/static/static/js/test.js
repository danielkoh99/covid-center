const userUrl = "http://localhost:5555/api/user";
const covidTestUrl = "http://localhost:5555/actionApi/test";
const covidVaccineURl = "http://localhost:5555/actionApi/vaccine";
let userTable = document.querySelector(".userInfoTable");
const searchInput = document.querySelector(".search");
const testPopup = document.querySelector(".testpop");
const vaccinePopup = document.querySelector(".vaccinepop");
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
const back = document.getElementById("backButton");

const getHref = () => {
  const userid = getCookie("userID");
  const userType = getCookie("userType");

  if (userid > 0) {
    if (userType === "administrator") {
      back.href = "/admin";
    }
    if (userType === "secretary") {
      back.href = "/secretary";
    }
  }
};

let users = [];

let tests = [];
const getUsers = async () => {
  try {
    const res = await fetch(userUrl);
    users = await res.json();
  } catch (err) {
    console.log(err);
  }
};
EditTestBtn.addEventListener("click", (e) => {
  let place = "";

  let cpr = bookingID.value;
  let result = bookingStatus.value;
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
  getTests();
});

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
  const filteredTests = tests.filter((test) => {
    return test.user_id_user.toString().toLowerCase().includes(searchTerm);
  });
  renderTests(filteredTests);
});
const findCpr = (userID) => {
  return users.find((user) => user.idUser == userID);
};
const renderTests = (tests) => {
  let HTML = "";

  tests.map((test, idx) => {
    HTML += `
      <tr>
        <th scope="row">${test.idbookings}</th>
        <td class="item">(${test.user_id_user})${
      findCpr(test.user_id_user).cprNumber
    }</td>
        <td class="item">Covid center</td>
        <td class="item">${test.bookingType_idbookingType.type}</td>
        <td class="item">${
          test.bookingStatus_idbookingStatus.bookingStatus
        }</td>
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
const getBookingPopup = (booking) => {
  console.log(JSON.parse(booking));
  let bookingInfo = JSON.parse(booking);
  bookingEdit.classList.remove("d-none");
  testTableContainer.style.pointerEvents = "none";
  testTableContainer.style.opacity = "0.3";
  bookingID.value = bookingInfo.idbookings;
  bookingStatus.value =
    bookingInfo.bookingStatus_idbookingStatus.idbookingStatus;
};

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
getUsers().then(() => {
  getTests();
});
