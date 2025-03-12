// Prisijungimo funkcija
function login() {
    let username = document.getElementById('username').value.trim();
    let password = document.getElementById('password').value.trim();

    if (!username || !password) {
        alert("Įveskite duomenis!");
        return;
    }

    fetch('http://localhost:8080/auth/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, password })
    })
    .then(response => response.json())
    .then(data => {
        if (data.token) {
            localStorage.setItem('jwt', data.token);
            alert("Sėkmingai prisijungta!");
            window.location.href = 'index.html';
        } else {
            alert("Neteisingi prisijungimo duomenys!");
        }
    })
    .catch(error => console.error('Klaida:', error));
}

// Restoranų sąrašo gavimas
function loadRestaurants() {
    let token = localStorage.getItem('jwt');
    if (!token) {
        alert("Prisijunkite, kad matytumėte restoranus.");
        return;
    }

    fetch('http://localhost:8080/api/restaurants', {
        headers: { 'Authorization': 'Bearer ' + token }
    })
    .then(response => response.json())
    .then(restaurants => {
        let restaurantList = document.getElementById('restaurant-list');
        restaurantList.innerHTML = '';
        restaurants.forEach(restaurant => {
            let restaurantItem = document.createElement('li');
            restaurantItem.innerHTML = `
                <strong>${restaurant.name}</strong> (${restaurant.category})
                ${restaurant.open ? '<span style="color:green;">[Atidaryta]</span>' : '<span style="color:red;">[Uždaryta]</span>'}
            `;
            restaurantList.appendChild(restaurantItem);
        });
    })
    .catch(error => console.error('Klaida:', error));
}

// Maitinimo įstaigų valdymas administratoriui
function addRestaurant() {
    let token = localStorage.getItem('jwt');
    if (!token) {
        alert("Prisijunkite kaip administratorius.");
        return;
    }

    let name = document.getElementById('restaurant-name').value.trim();
    let category = document.getElementById('restaurant-category').value.trim();

    fetch('http://localhost:8080/api/admin/restaurants', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + token
        },
        body: JSON.stringify({ name, category })
    })
    .then(response => {
        if (response.ok) {
            alert("Restoranas pridėtas!");
            loadRestaurants();
        } else {
            alert("Nepavyko pridėti restorano.");
        }
    })
    .catch(error => console.error('Klaida:', error));
}

// Atsijungimo funkcija
function logout() {
    localStorage.removeItem('jwt');
    alert("Sėkmingai atsijungta!");
    window.location.href = 'login.html';
}

// Automatiškai užkrauti restoranus puslapiui įsikėlus
document.addEventListener('DOMContentLoaded', function() {
    if (document.getElementById('restaurant-list')) {
        loadRestaurants();
    }
});
