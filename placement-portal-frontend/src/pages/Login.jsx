import { useState } from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "../components/Navbar";
import Footer from "../components/Footer";
import api from "../services/api";

function Login() {

    const navigate = useNavigate();

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const login = async (e) => {

        e.preventDefault();

        try {

            const response = await api.post("/students/login", {
                email,
                password
            });

            alert("Login Successful");

            localStorage.setItem("token", response.data.token);
            localStorage.setItem("studentId", response.data.studentId);

            navigate("/dashboard");

        } catch (error) {

            alert("Invalid Email or Password");

        }

    };

    return (

        <>
            <Navbar />

            <div className="container mt-5">

                <div className="row justify-content-center">

                    <div className="col-md-5">

                        <div className="card shadow">

                            <div className="card-body">

                                <h2 className="text-center mb-4">
                                    Student Login
                                </h2>

                                <form onSubmit={login}>

                                    <div className="mb-3">

                                        <label>Email</label>

                                        <input
                                            type="email"
                                            className="form-control"
                                            value={email}
                                            onChange={(e)=>setEmail(e.target.value)}
                                        />

                                    </div>

                                    <div className="mb-3">

                                        <label>Password</label>

                                        <input
                                            type="password"
                                            className="form-control"
                                            value={password}
                                            onChange={(e)=>setPassword(e.target.value)}
                                        />

                                    </div>

                                    <button className="btn btn-primary w-100">
                                        Login
                                    </button>

                                </form>

                            </div>

                        </div>

                    </div>

                </div>

            </div>

            <Footer />

        </>

    );

}

export default Login;