import { useEffect, useState } from "react";
import axios from "axios";

function Expenses() {

  const [expenses, setExpenses] = useState([]);
  const [editingId, setEditingId] = useState(null);

  const [form, setForm] = useState({
    expenseName: "",
    amount: "",
    month: "",
    year: new Date().getFullYear(),
    expenseDate: "",
    remarks: ""
  });

  useEffect(() => {
    loadExpenses();
  }, []);

  const loadExpenses = async () => {

    const token = localStorage.getItem("token");

    const response = await axios.get(
      "http://localhost:8080/api/expenses",
      {
        headers: {
          Authorization: `Bearer ${token}`
        }
      }
    );
    console.log("EXPENSES =", response.data);
    setExpenses(response.data);
  };

  const editExpense = (expense) => {

  setEditingId(expense.id);

  setForm({
    expenseName: expense.expenseName,
    amount: expense.amount,
    month: expense.month,
    year: expense.year,
    expenseDate: expense.expenseDate,
    remarks: expense.remarks
  });
};

 const saveExpense = async () => {

  const token =
    localStorage.getItem("token");

  if (editingId) {

    await axios.put(
      `http://localhost:8080/api/expenses/${editingId}`,
      form,
      {
        headers: {
          Authorization:
            `Bearer ${token}`
        }
      }
    );

  } else {

    await axios.post(
      "http://localhost:8080/api/expenses",
      form,
      {
        headers: {
          Authorization:
            `Bearer ${token}`
        }
      }
    );
  }

  setEditingId(null);

  setForm({
    expenseName: "",
    amount: "",
    month: "",
    year: new Date().getFullYear(),
    expenseDate: "",
    remarks: ""
  });

  loadExpenses();
};

  const deleteExpense = async (id) => {

    const token = localStorage.getItem("token");

    await axios.delete(
      `http://localhost:8080/api/expenses/${id}`,
      {
        headers: {
          Authorization: `Bearer ${token}`
        }
      }
    );

    loadExpenses();
  };

  return (
    <div>

      <h2>Expense Management</h2>

      <input
        placeholder="Expense Name"
        value={form.expenseName}
        onChange={(e) =>
          setForm({
            ...form,
            expenseName: e.target.value
          })
        }
      />

      <input
        type="number"
        placeholder="Amount"
        value={form.amount}
        onChange={(e) =>
          setForm({
            ...form,
            amount: e.target.value
          })
        }
      />

      <select
        value={form.month}
        onChange={(e) =>
          setForm({
            ...form,
            month: e.target.value
          })
        }
      >
        <option value="">Select Month</option>
        <option value="January">January</option>
        <option value="February">February</option>
        <option value="March">March</option>
        <option value="April">April</option>
        <option value="May">May</option>
        <option value="June">June</option>
        <option value="July">July</option>
        <option value="August">August</option>
        <option value="September">September</option>
        <option value="October">October</option>
        <option value="November">November</option>
        <option value="December">December</option>
      </select>

      <input
        type="number"
        placeholder="Year"
        value={form.year}
        onChange={(e) =>
          setForm({
            ...form,
            year: e.target.value
          })
        }
      />

      <input
        type="date"
        value={form.expenseDate}
        onChange={(e) =>
          setForm({
            ...form,
            expenseDate: e.target.value
          })
        }
      />

      <input
        placeholder="Remarks"
        value={form.remarks}
        onChange={(e) =>
          setForm({
            ...form,
            remarks: e.target.value
          })
        }
      />

      <button onClick={saveExpense}>
        {editingId
          ? "Update Expense"
          : "Save Expense"}
      </button>

      <hr />

      <table border="1">

        <thead>

          <tr>
            <th>Name</th>
            <th>Amount</th>
            <th>Month</th>
            <th>Year</th>
            <th>Date</th>
            <th>Actions</th>
          </tr>

        </thead>

        <tbody>

          {expenses.map((e) => (

            <tr key={e.id}>

              <td>{e.expenseName}</td>
              <td>₹{e.amount}</td>
              <td>{e.month}</td>
              <td>{e.year}</td>
              <td>{e.expenseDate}</td>

              <td>

            <button
              onClick={() =>
                editExpense(e)
              }
            >
              Edit
            </button>

            <button
              onClick={() =>
                deleteExpense(e.id)
              }
            >
              Delete
            </button>

              </td>

            </tr>

          ))}

        </tbody>

      </table>

    </div>
  );
}

export default Expenses;