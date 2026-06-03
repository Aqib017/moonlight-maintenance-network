import { useState } from "react";
import api from "../services/api";

function ResidentLookup() {

    const [flatNumber, setFlatNumber] =
        useState("");

    const [resident, setResident] =
        useState(null);

    const searchResident = () => {

        api.get(
                `/resident/${flatNumber}`
            )
            .then(response => {

                setResident(
                    response.data
                );

            })
            .catch(error => {

                console.error(error);

                alert(
                    "Resident not found"
                );

            });
    };

    return (

        <div className="container">

            <h2 className="page-title">
                Resident Lookup
            </h2>
        <div className="card">
            <input
                type="text"
                placeholder="Enter Flat Number"
                value={flatNumber}
                onChange={(e) =>
                    setFlatNumber(
                        e.target.value
                    )
                }
            />

            <button
                onClick={
                    searchResident
                }
            >
                Search
            </button>

            {resident && (

                <div>

                    <hr />

                    <h3>
                        Resident Details
                    </h3>

                    <p>
                        Flat:
                        {" "}
                        {resident.flatNumber}
                    </p>

                    <p>
                        Owner:
                        {" "}
                        {resident.ownerName}
                    </p>

                    <p>
                        Monthly Charge:
                        ₹
                        {resident.monthlyCharge}
                    </p>

                    <p>
                        Due Payments:
                        {" "}
                        {resident.duePayments}
                    </p>

                    <p>
                        Outstanding Amount:
                        ₹
                        {resident.outstandingAmount}
                    </p>

                </div>

            )}
            </div>

        </div>

    );
}

export default ResidentLookup;