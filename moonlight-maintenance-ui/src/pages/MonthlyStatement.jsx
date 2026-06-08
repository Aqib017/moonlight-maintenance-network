import { useState } from "react";
import api from "../services/api";

function MonthlyStatement() {

    const [month, setMonth] = useState("");
    const [year, setYear] = useState("");
    const [statement, setStatement] = useState(null);

    const fetchStatement = async () => {

        try {

            const response = await api.get(
                        `/statement/${month}/${year}`
                    );

            setStatement(response.data);

        } catch (error) {

            console.error(error);
            alert("Statement not found");

        }
    };

    const downloadPdf = async () => {

    try {

        const response = await api.get(
            `/statement/pdf/${month}/${year}`,
            {
                responseType: "blob"
            }
        );

        const url =
            window.URL.createObjectURL(
                new Blob([response.data])
            );

        const link =
            document.createElement("a");

        link.href = url;

        link.setAttribute(
            "download",
            `Statement-${month}-${year}.pdf`
        );

        document.body.appendChild(link);

        link.click();

        link.remove();

    } catch (error) {

        console.error(error);

        alert(
            "PDF download failed"
        );
    }
};

    return (

        <div className="container">

            <h2 className="page-title">Monthly Statement</h2>

             <div className="card">

            <input
                type="text"
                placeholder="Month (MAY)"
                value={month}
                onChange={(e) =>
                    setMonth(
                        e.target.value.toUpperCase()
                    )
                }
            />

            <input
                type="number"
                placeholder="Year"
                value={year}
                onChange={(e) =>
                    setYear(
                        e.target.value
                    )
                }
            />

            <button
                onClick={fetchStatement}
            >
                Generate
            </button>

            <button
                onClick={downloadPdf}
            >
                Download PDF
            </button>

            {statement && (

                <div>

                    <h3>Statement Generated</h3>

                    <pre>
                        {JSON.stringify(
                            statement,
                            null,
                            2
                        )}
                    </pre>

                </div>

            )}

            </div>

        </div>

    );
}

export default MonthlyStatement;