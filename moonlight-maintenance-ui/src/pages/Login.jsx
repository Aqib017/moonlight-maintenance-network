import { useState } from "react";
import axios from "axios";

function Login() {

    const [username, setUsername] =
        useState("");

    const [password, setPassword] =
        useState("");

    const login = async () => {

        try {

            const response =
                await axios.post(

                    "http://localhost:8080/auth/login",

                    {
                        username,
                        password
                    }
                );

            localStorage.setItem(
                "token",
                response.data.token
            );

            window.location.href = "/";

        } catch (error) {

            alert(
                "Invalid Credentials"
            );

        }
    };

    return (

        <div className="container">

           <h1>
                Moonlight Login 
            </h1>

            <input
                type="text"
                placeholder="Username"
                value={username}
                onChange={(e) =>
                    setUsername(
                        e.target.value
                    )
                }
            />

            <br />

            <input
                type="password"
                placeholder="Password"
                value={password}
                onChange={(e) =>
                    setPassword(
                        e.target.value
                    )
                }
            />

            <br />

            <button
                onClick={login}
            >
                Login
            </button>

        </div>

    );
}

export default Login;