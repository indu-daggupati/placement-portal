import { useEffect, useState } from "react";
import Navbar from "../components/Navbar";
import Footer from "../components/Footer";
import api from "../services/api";
import { Link } from "react-router-dom";

function Dashboard() {

    const [jobs, setJobs] = useState([]);
    const [companies, setCompanies] = useState([]);

    useEffect(() => {
        loadData();
    }, []);

    const loadData = async () => {

        try {

            const jobsRes = await api.get("/jobs/all");
            const companiesRes = await api.get("/companies/all");

            setJobs(jobsRes.data);
            setCompanies(companiesRes.data);

        } catch (error) {

            console.log(error);

        }

    };

    return (

        <>
            <Navbar />

            <div className="container mt-5">

                <h2 className="mb-4">
                    Welcome 👋
                </h2>

                <div className="row">

                    <div className="col-md-4">

                        <div className="card shadow bg-primary text-white">

                            <div className="card-body">

                                <h5>Total Jobs</h5>

                                <h1>{jobs.length}</h1>

                            </div>

                        </div>

                    </div>

                    <div className="col-md-4">

                        <div className="card shadow bg-success text-white">

                            <div className="card-body">

                                <h5>Total Companies</h5>

                                <h1>{companies.length}</h1>

                            </div>

                        </div>

                    </div>

                    <div className="col-md-4">

                        <div className="card shadow bg-warning">

                            <div className="card-body">

                                <h5>Applications</h5>

                                <h1>1</h1>

                            </div>

                        </div>

                    </div>

                </div>

                <div className="mt-5">

                    <h3>Quick Actions</h3>

                    <Link to="/jobs" className="btn btn-primary me-3">
                        Browse Jobs
                    </Link>

                    <Link to="/companies" className="btn btn-success">
                        Companies
                    </Link>

                </div>

            </div>

            <Footer />

        </>

    );

}

export default Dashboard;