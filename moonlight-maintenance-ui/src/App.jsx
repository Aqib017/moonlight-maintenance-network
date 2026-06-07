import {BrowserRouter,Routes,Route,Link} from "react-router-dom";
import Dashboard from "./pages/Dashboard";
import MonthlyStatement from "./pages/MonthlyStatement";
import ResidentLookup from "./components/ResidentLookup";
import Login from "./pages/Login";
import ProtectedRoute from "./components/ProtectedRoute";
import UserManagement from "./pages/UserManagement";
import Collections from "./pages/Collections";
import DueReport from "./pages/DueReport";
import ResidentLedger from "./pages/ResidentLedger";
import Expenses from "./pages/Expenses";

function App() {

  return (

    <BrowserRouter>

    <div className="layout">

        <div className="sidebar">

            <h2>
                🌙 Moonlight
            </h2>

            <Link to="/">
                Dashboard
            </Link>

            <Link to="/resident">
                Resident Lookup
            </Link>

            <Link to="/statement">
                Monthly Statement
            </Link>

            <Link to="/users">
                User Management
            </Link>

            <Link to="/collections">
            Collections
            </Link>

            <Link to="/due-report">
            Due Report
            </Link>

            <Link to="/resident-ledger">
            Resident Ledger
            </Link>

            <Link to="/expenses">
            Expenses
            </Link>

        </div>

        <div className="content">

            <Routes>

                <Route
                    path="/"
                    element={
                        <ProtectedRoute>
                            <Dashboard />
                        </ProtectedRoute>
                    }
                />

               <Route
                      path="/resident"
                      element={
                          <ProtectedRoute>
                              <ResidentLookup />
                          </ProtectedRoute>
                      }
                  />

                <Route
                      path="/statement"
                      element={
                          <ProtectedRoute>
                              <MonthlyStatement />
                          </ProtectedRoute>
                      }
                  />

                <Route
                    path="/login"
                    element={<Login />}
                />

                <Route
                    path="/users"
                    element={
                        <ProtectedRoute>
                            <UserManagement />
                        </ProtectedRoute>
                    }
                />

                <Route
                path="/collections"
                element={<Collections />}
                />

                <Route
                path="/due-report"
                element={<DueReport />}
                />

                <Route
                path="/resident-ledger"
                element={<ResidentLedger />}
                />

                <Route
                path="/expenses"
                element={<Expenses />}
                />

            </Routes>
            <button
                onClick={() => {

                    localStorage.removeItem(
                        "token"
                    );

                    window.location.href =
                        "/login";
                }}
            >
                Logout
            </button>

        </div>

    </div>

</BrowserRouter>

  );
}

export default App;
