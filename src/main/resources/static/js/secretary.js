const URL = "http://localhost:5555/api/secretary";
const userUrl = "http://localhost:5555/api/user";
let userTable = document.querySelector(".userInfoTable");
const searchInput = document.querySelector(".search");
// let searchTerm = "";
let users = [];
const getUsers = async () => {
  try {
    const res = await fetch(userUrl);
    users = await res.json();
    renderUsers(users);
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

const renderUsers = (data) => {
  let HTML = "";
  // users
  //   .filter((user) => user.email.includes(searchTerm.toLowerCase()))
  data.map((element, idx) => {
    HTML += `
    <tr>
      <th scope="row">${idx + 1}</th>
      <td class="item">${element.name}</td>
      <td class="item">${element.surname}</td>
      <td class="item">${element.cprNumber}</td>
      <td class="item">${element.email}</td>
      <td align="center">
      <div class="dropdown">
        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
        Edit
      </button>
      <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
        <li><a class="dropdown-item" href="#">Add test</a></li>
        <li><a class="dropdown-item" href="#">Add vaccine</a></li>
        <li><a class="dropdown-item" href="#">Book a test</a></li>
      </ul>
    </div>
    </td>
    </tr>  
`;
  });

  userTable.innerHTML = HTML;
};
getUsers();
