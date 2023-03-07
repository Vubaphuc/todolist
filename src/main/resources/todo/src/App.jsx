import { useEffect } from 'react';
import { useState } from 'react'
import axios from 'axios';



function App() {
  const [todos, setTodos] = useState([]);

  

  useEffect(() => {
    getTodos();
  }, []);

  const getTodos = async () => {
    const response = await axios.get('http://localhost:8080/api/todos');
    console.log(response);
    setTodos(response.data);
  };

  const addTodo = async () => {
    const title = window.prompt('Enter the title');
    if (title) {
      const response = await axios.post('http://localhost:8080/api/todos', {title, status: false});
      setTodos([...todos,response.data]);
    }
  };
  // xóa todo
  // const deleteTodo = async (id) => {
    // await axios.delete(`http://localhost:8080/api/todos/${id}`);
    // setTodos(todos.filter((todo) => todo.id !== id));
  // }

  const deleteTodo = (id) => {
    fetch(`/api/todos/${id}`, { method: 'DELETE' })
      .then(() => setTodos(todos.filter((todo) => todo.id !== id)))
      .catch((error) => console.error('Error deleting todo:', error));
  };



  const updateTodoTitle = async (id,title) => {
    await axios.put(`http://localhost:8080/api/todos/${id}`, {title});
    setTodos (
      todos.map((todo) => {
        if (todo.id === id) {
          return {...todo, title};
        }
        return todo;
      })
    );
  };


  const updateTodoStatus = async (id,status) => {
    await axios.put(`http://localhost:8080/api/todos/${id}`, {status});
    setTodos(
      todos.map((todo) => {
        if (todo.id === id) {
          return {...todo,status};
        }
        return todo;
      })
    );
  };

  return (
    <>
      <h1>To-Do List</h1>
      {todos.length === 0 && <p>Danh sách công việc trống</p>}
      <ul>
        {todos.map((todo) => (
          <li key={todo.id}>
            <input type="checkbox" checked={todo.status} onChange={() => updateTodoStatus(todo.id,!todo.status)}/>
            <span>{todo.title}</span>
            <button onClick={() => updateTodoTitle(todo.id,window.prompt('Enter the title',todo.title))}>Edit</button>
            <button onClick={() => deleteTodo(todo.id)}>Delete</button>
          </li>
        ))}
      </ul>
      <button onClick={addTodo}>Thêm công việc mới</button>
    </>
  )
}

export default App
