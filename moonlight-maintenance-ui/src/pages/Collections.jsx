import { useEffect, useState } from "react";
import axios from "axios";

function Collections() {

  const [collections, setCollections] = useState([]);
  const [flats, setFlats] = useState([]);
  const [errorMessage, setErrorMessage] = useState("");
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
      loadFlats();
    }, []);

    const loadFlats = async () => {

      try {

        const token = localStorage.getItem("token");

        console.log("TOKEN =", token);

        const response = await axios.get(
          "http://localhost:8080/flats",
          {
            headers: {
              Authorization: `Bearer ${token}`
            }
          }
        );

        console.log("FLATS RESPONSE =", response.data);

        setFlats(response.data);

      } catch (error) {

        console.log("FLATS ERROR =", error);

      }
    };

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

  const deleteCollection = async (id) => {

          const token = localStorage.getItem("token");

          await axios.delete(
            `http://localhost:8080/api/collections/${id}`,
            {
              headers: {
                Authorization: `Bearer ${token}`
              }
            }
          );

          loadCollections();
        };

  const saveCollection = async () => {

  const token = localStorage.getItem("token");

          try {

            await axios.post(
              "http://localhost:8080/api/collections",
              form,
              {
                headers: {
                  Authorization: `Bearer ${token}`
                }
              }
            );

            setErrorMessage("");

            setForm({
              flatNumber: "",
              month: "",
              year: new Date().getFullYear(),
              amount: "",
              paymentDate: "",
              remarks: ""
            });

            loadCollections();

          } catch (error) {

            setErrorMessage(
              "Payment already exists for this Flat, Month and Year"
            );

          }
          {
          errorMessage &&
          <p style={{color: "red"}}>
            {errorMessage}
          </p>
        }

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

            <select
              value={form.flatNumber}
              onChange={(e) =>
                setForm({
                  ...form,
                  flatNumber: e.target.value
                })
              }
            >

              <option value="">
                Select Flat
              </option>

              {flats.map((flat) => (
                <option
                  key={flat.id}
                  value={flat.flatNumber}
                >
                  {flat.flatNumber}
                </option>
              ))}

            </select>

            <select
              value={form.month}
              onChange={(e) =>
                setForm({
                  ...form,
                  month: e.target.value
                })
              }
            >
              <option value="">
                Select Month
              </option>

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
            <th>Action</th>
          </tr>
        </thead>

        <tbody>
          {collections.map((c) => (
            <tr key={c.id}>
              <td>{c.flatNumber}</td>
              <td>{c.month}</td>
              <td>{c.year}</td>
              <td>{c.amount}</td>
              <td>
              <button
                onClick={() =>
                  deleteCollection(c.id)
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

export default Collections;