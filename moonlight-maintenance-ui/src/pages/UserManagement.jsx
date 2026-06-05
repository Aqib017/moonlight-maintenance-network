import { useEffect, useState } from "react";
import axios from "axios";

function UserManagement() {

    const [users, setUsers] =
        useState([]);

    const [username, setUsername] =
        useState("");

    const [password, setPassword] =
        useState("");

    const fetchUsers = async () => {

        try {

            const response =
                await axios.get(
                    "http://localhost:8080/users",
                    {
                        headers: {
                            Authorization:
                                `Bearer ${localStorage.getItem("token")}`
                        }
                    }
                );

            setUsers(
                response.data
            );

        } catch (error) {

            console.error(error);

        }
    };

    useEffect(() => {

        fetchUsers();

    }, []);

    return (

    <div>

        <h2>
            User Management
        </h2>

        <hr />

        <h3>
            Add User
        </h3>

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

        <button
            onClick={async () => {

                try {

                    await axios.post(

                        "http://localhost:8080/users",

                        {
                            username,
                            password
                        },

                        {
                            headers: {
                                Authorization:
                                    `Bearer ${localStorage.getItem("token")}`
                            }
                        }
                    );

                    setUsername("");
                    setPassword("");

                    fetchUsers();

                } catch (error) {

                    console.error(error);

                    alert(
                        "Failed to create user"
                    );
                }
            }}
        >
            Add User
        </button>

        <hr />

        <h3>
            Existing Users
        </h3>

        <table border="1">

            <thead>

                <tr>

                    <th>ID</th>

                    <th>Username</th>

                    <th>Action</th>

                </tr>

            </thead>

            <tbody>

                {
                    users.map(user => (

                        <tr key={user.id}>

                            <td>
                                {user.id}
                            </td>

                            <td>
                                {user.username}
                            </td>

                            <td>

                                {
                                    user.username === "admin"

                                        ? "Protected"

                                        : (

                                            <button

                                                onClick={async () => {

                                                    try {

                                                        await axios.delete(

                                                            `http://localhost:8080/users/${user.id}`,

                                                            {
                                                                headers: {
                                                                    Authorization:
                                                                        `Bearer ${localStorage.getItem("token")}`
                                                                }
                                                            }
                                                        );

                                                        fetchUsers();

                                                    } catch (error) {

                                                        console.error(error);

                                                        alert(
                                                            "Delete failed"
                                                        );
                                                    }
                                                }}
                                            >
                                                Delete
                                            </button>
                                        )
                                }

                            </td>

                        </tr>

                    ))
                }

            </tbody>

        </table>

    </div>

);
}

export default UserManagement;