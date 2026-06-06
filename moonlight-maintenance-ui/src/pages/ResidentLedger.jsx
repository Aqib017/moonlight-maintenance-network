import { useEffect, useState } from "react";
import axios from "axios";

function ResidentLedger() {

  const [flatNumber, setFlatNumber] =
    useState("");

  const [ledger, setLedger] =
    useState([]);

  const [totalPaid, setTotalPaid] =
    useState(0);

  const [flats, setFlats] =
    useState([]);

      useEffect(() => {
    loadFlats();
    }, []);

    const loadFlats = async () => {

    const token =
        localStorage.getItem("token");

    const response =
        await axios.get(
        "http://localhost:8080/flats",
        {
            headers: {
            Authorization:
                `Bearer ${token}`
            }
        }
        );

    setFlats(response.data);
    };

  const loadLedger = async () => {

    if (!flatNumber) {
      return;
    }

    const token =
      localStorage.getItem("token");

    const response = await axios.get(
      `http://localhost:8080/api/collections/flat/${flatNumber}`,
      {
        headers: {
          Authorization: `Bearer ${token}`
        }
      }
    );

    setLedger(response.data);
const total =
        response.data.reduce(
            (sum, entry) =>
            sum + entry.amount,
            0
        );

        setTotalPaid(total);

  };

  return (

    <div>

      <h2>Resident Ledger</h2>

        <select
        value={flatNumber}
        onChange={(e) =>
            setFlatNumber(
            e.target.value
            )
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

      <button onClick={loadLedger}>
        Load Ledger
      </button>

      <br /><br />

      <h3>
        Total Paid: ₹{totalPaid}
        </h3>

      <table border="1">

        <thead>

          <tr>
            <th>Month</th>
            <th>Year</th>
            <th>Amount</th>
            <th>Payment Date</th>
            <th>Remarks</th>
          </tr>

        </thead>

        <tbody>

          {ledger.map((entry) => (

            <tr key={entry.id}>

              <td>{entry.month}</td>
              <td>{entry.year}</td>
              <td>₹{entry.amount}</td>
              <td>{entry.paymentDate}</td>
              <td>{entry.remarks}</td>

            </tr>

          ))}

        </tbody>

      </table>

    </div>

  );
}

export default ResidentLedger;