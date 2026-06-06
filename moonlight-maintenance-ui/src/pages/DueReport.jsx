import { useState } from "react";
import axios from "axios";

function DueReport() {

  const [month, setMonth] = useState("June");
  const [year, setYear] = useState(2026);
  const [report, setReport] = useState([]);

  const loadReport = async () => {

    const token = localStorage.getItem("token");

    const response = await axios.get(
      `http://localhost:8080/api/collections/due-report/month/${month}/year/${year}`,
      {
        headers: {
          Authorization: `Bearer ${token}`
        }
      }
    );

    setReport(response.data);
  };

  return (
    <div>

      <h2>Due Report</h2>

      <select
        value={month}
        onChange={(e) => setMonth(e.target.value)}
      >
        <option>January</option>
        <option>February</option>
        <option>March</option>
        <option>April</option>
        <option>May</option>
        <option>June</option>
        <option>July</option>
        <option>August</option>
        <option>September</option>
        <option>October</option>
        <option>November</option>
        <option>December</option>
      </select>

      <input
        type="number"
        value={year}
        onChange={(e) =>
          setYear(e.target.value)
        }
      />

      <button onClick={loadReport}>
        Load Report
      </button>

      <br /><br />

      <table border="1">

        <thead>
          <tr>
            <th>Flat</th>
            <th>Expected</th>
            <th>Paid</th>
            <th>Due</th>
          </tr>
        </thead>

        <tbody>

          {report.map((row) => (

            <tr key={row.flatNumber}>

              <td>{row.flatNumber}</td>

              <td>
                ₹{row.expectedAmount}
              </td>

              <td>
                ₹{row.paidAmount}
              </td>

              <td>
                ₹{row.dueAmount}
              </td>

            </tr>

          ))}

        </tbody>

      </table>

    </div>
  );
}

export default DueReport;