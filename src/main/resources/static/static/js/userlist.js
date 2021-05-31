const userUrl = "http://localhost:5555/api/user";
const searchInput = document.querySelector(".search");
let userTable = document.querySelector(".userInfoTable");

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
const removeChild = () => {};

searchInput.addEventListener("keyup", (e) => {
  const searchTerm = e.target.value.toLowerCase();
  const filteredUsers = users.filter((user) => {
    return (
      user.name.toLowerCase().includes(searchTerm) ||
      user.email.toLowerCase().includes(searchTerm) ||
      user.cprNumber.toLowerCase().includes(searchTerm)
    );
  });
  renderUsers(filteredUsers);
});
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
      </td>
      </tr>  
  `;
  });

  userTable.innerHTML = HTML;
};

getUsers();
