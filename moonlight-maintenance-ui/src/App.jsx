import {BrowserRouter,Routes,Route,Link} from "react-router-dom";
import Dashboard from "./pages/Dashboard";
import MonthlyStatement from "./pages/MonthlyStatement";
import ResidentLookup from "./components/ResidentLookup";
import Login from "./pages/Login";
import ProtectedRoute from "./components/ProtectedRoute";

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