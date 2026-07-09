import { useState } from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "../components/Navbar";
import Footer from "../components/Footer";
import api from "../services/api";

function Register() {

    const navigate = useNavigate();

    const [student, setStudent] = useState({
        name: "",
        email: "",
        password: "",
        phone: "",
        cgpa: ""
    });

    const handleChange = (e) => {
        setStudent({
            ...student,
            [e.target.name]: e.target.value
        });
    };

    const register = async (e) => {

        e.preventDefault();

        try {

            await api.post("/students/register", student);

            alert("Registration Successful");

            navigate("/login");

        } catch (error) {

            alert("Registration Failed");

        }

    };

    return (
        <>
            <Navbar />

            <div className="container mt-5">

                <div className="row justify-content-center">

                    <div className="col-md-6">

                        <div className="card shadow">

                            <div className="card-body">

                                <h2 className="text-center mb-4">
                                    Student Registration
                                </h2>

                                <form onSubmit={register}>

                                    <input
                                        className="form-control mb-3"
                                        placeholder="Name"
                                        name="name"
                                        onChange={handleChange}
                                    />

                                    <input
                                        className="form-control mb-3"
                                        placeholder="Email"
                                        name="email"
                                        onChange={handleChange}
                                    />

                                    <input
                                        type="password"
                                        className="form-control mb-3"
                                        placeholder="Password"
                                        name="password"
                                        onChange={handleChange}
                                    />

                                    <input
                                        className="form-control mb-3"
                                        placeholder="Phone"
                                        name="phone"
                                        onChange={handleChange}
                                    />

                                    <input
                                        className="form-control mb-3"
                                        placeholder="CGPA"
                                        name="cgpa"
                                        onChange={handleChange}
                                    />

                                    <button className="btn btn-success w-100">
                                        Register
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

export default Register;