import { useEffect, useState } from "react";
import axios from "axios";

function Collections() {

  const [collections, setCollections] = useState([]);
      const [form, setForm] = useState({
        flatNumber: "",
        month: "",
        year: new Date().getFullYear(),
        amount: "",
        paymentDate: "",
        remarks: ""
        });

  useEffect(() => {
    loadCollections();
  }, []);

  const loadCollections = async () => {
    const token = localStorage.getItem("token");

    const response = await axios.get(
      "http://localhost:8080/api/collections",
      {
        headers: {
          Authorization: `Bearer ${token}`
        }
      }
    );


    setCollections(response.data);
  };

  const saveCollection = async () => {

  const token = localStorage.getItem("token");

            await axios.post(
                "http://localhost:8080/api/collections",
                form,
                {
                headers: {
                    Authorization: `Bearer ${token}`
                }
                }
            );

            setForm({
                flatNumber: "",
                month: "",
                year: new Date().getFullYear(),
                amount: "",
                paymentDate: "",
                remarks: ""
            });

            loadCollections();
            };

  return (
    <div>
      <h2>Collections</h2>

      <h3>Add Collection</h3>

            <div>

            <input
                placeholder="Flat Number"
                value={form.flatNumber}
                onChange={(e) =>
                setForm({
                    ...form,
                    flatNumber: e.target.value
                })
                }
            />

            <input
                placeholder="Month"
                value={form.month}
                onChange={(e) =>
                setForm({
                    ...form,
                    month: e.target.value
                })
                }
            />

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

            <input
                type="date"
                value={form.paymentDate}
                onChange={(e) =>
                setForm({
                    ...form,
                    paymentDate: e.target.value
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

            <button onClick={saveCollection}>
                Save Payment
            </button>

            </div>

            <hr />

      <table border="1">
        <thead>
          <tr>
            <th>Flat</th>
            <th>Month</th>
            <th>Year</th>
            <th>Amount</th>
            <th>Payment Date</th>
          </tr>
        </thead>

        <tbody>
          {collections.map((c) => (
            <tr key={c.id}>
              <td>{c.flatNumber}</td>
              <td>{c.month}</td>
              <td>{c.year}</td>
              <td>{c.amount}</td>
              <td>{c.paymentDate}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Collections;