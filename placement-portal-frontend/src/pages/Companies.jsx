import { useEffect, useState } from "react";
import api from "../services/api";

function Companies() {

    const [companies, setCompanies] = useState([]);

    useEffect(() => {
        api.get("/companies/all")
            .then((res) => {
                setCompanies(res.data);
            })
            .catch((err) => {
                console.log(err);
            });
    }, []);

    return (
        <div className="container mt-5">

            <h2 className="mb-4">Companies</h2>

            <div className="row">

                {companies.map(company => (

                    <div className="col-md-4 mb-4" key={company.id}>

                        <div className="card shadow h-100">

                            <div className="card-body">

                                <h4>{company.companyName}</h4>

                                <p>
                                    <strong>Role:</strong> {company.jobRole}
                                </p>

                                <p>
                                    <strong>Location:</strong> {company.location}
                                </p>

                                <p>
                                    <strong>Package:</strong> {company.packageOffered} LPA
                                </p>

                                <p>{company.description}</p>

                            </div>

                        </div>

                    </div>

                ))}

            </div>

        </div>
    );
}

export default Companies;