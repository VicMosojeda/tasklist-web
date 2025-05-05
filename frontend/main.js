const taskForm = document.getElementById("task__form");
const taskList = document.getElementById("task__list");

const API_URL = "http://localhost:8081/api/tasks";

const themeToggleBtn = document.getElementById("theme__toggle__btn");

document.addEventListener("DOMContentLoaded", () => {
  const savedTheme = localStorage.getItem("theme");
  if (savedTheme === "dark") {
    document.body.classList.add("dark__mode");
    themeToggleBtn.textContent = "☀️";
  } else {
    document.body.classList.remove("dark__mode");    
    themeToggleBtn.textContent = "🌙";
  }

  loadTasks();
});

themeToggleBtn.addEventListener("click", () => {
  document.body.classList.toggle("dark__mode");

  if (document.body.classList.contains("dark__mode")) {
    themeToggleBtn.textContent = "☀️";
    localStorage.setItem("theme", "dark");
  } else {
    themeToggleBtn.textContent = "🌙";
    localStorage.setItem("theme", "light");
  }
});

function loadTasks() {
  fetch(API_URL)
    .then(response => response.json())
    .then(tasks => {
      taskList.innerHTML = "";
      tasks.forEach(task => renderTask(task));
    })
    .catch(error => console.error("Error loading tasks:", error));
}

function renderTask(task) {
  const li = document.createElement("li");
  li.innerHTML = `
    <span>${task.title}: ${task.description}</span>
    <button class="delete" onclick="deleteTask(${task.id})">X</button>
  `;
  taskList.appendChild(li);
}

taskForm.addEventListener("submit", e => {
  e.preventDefault();

  const newTask = {
    title: document.getElementById('task__title').value,
    description: document.getElementById('task__description').value,
    completed: false
  };

  fetch(API_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(newTask)
  })
  .then(response => response.json())
  .then(task => {
    renderTask(task);
    taskForm.reset();
  })
  .catch(error => console.error("Error adding task: ", error));
});

function deleteTask(id) {
  fetch(`${API_URL}/${id}`, {
    method: "DELETE"
  })
  .then(() => {
    loadTasks();
  })
  .catch(error => console.error("Error deleting task: ", error));
}

