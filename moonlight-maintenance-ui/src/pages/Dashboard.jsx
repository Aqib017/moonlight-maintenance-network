import { useEffect, useState } from "react";
import api from "../services/api";
import FinanceChart from "../components/FinanceChart";

function App() {

  const [dashboard, setDashboard] =
    useState(null);

  useEffect(() => {

    api.get(
    "/dashboard/MAY/2026"
      )
      .then(response => {

        setDashboard(
          response.data
        );

      })
      .catch(error => {

        console.error(error);

      });

  }, []);

  if (!dashboard) {

    return <h2>Loading...</h2>;

  }

  return (

<div className="hero-banner">

    <h1>
        Moonlight Apartment
    </h1>

    <p>
        8, Ismail Street,
        Kolkata - 700014
    </p>

     <h3>
        Apartment Maintenance Management System
    </h3>

    

    <div className="dashboard-grid">

        <div className="dashboard-card">
            <h3>Payments Recorded</h3>
            <p>{dashboard.totalCollectionsRecorded}</p>
        </div>

        <div className="dashboard-card flats">
            <h3>Total Flats</h3>
            <p>{dashboard.totalFlats}</p>
        </div>

        <div className="dashboard-card collection">
            <h3>Collection</h3>
            <p>₹{dashboard.totalCollection}</p>
        </div>

        <div className="dashboard-card expense">
            <h3>Expense</h3>
            <p>₹{dashboard.totalExpense}</p>
        </div>

        <div className="dashboard-card balance">
            <h3>Balance</h3>
            <p>₹{dashboard.balance}</p>
        </div>

    </div>

    <div className="dashboard-card due-card">

    <h3>Due Payments</h3>

    <p>{dashboard.duePayments}</p>

</div>

<div className="card">

    <h2>
        Financial Overview
    </h2>

    <FinanceChart
        collection={dashboard.totalCollection}
        expense={dashboard.totalExpense}
    />

</div>

<div className="footer">

    © 2026 Moonlight Apartment

</div>

</div>



  );
}

export default App;