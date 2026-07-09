import { useEffect, useState } from "react";
import api from "../services/api";

function MyApplications() {

    const [applications, setApplications] = useState([]);

    useEffect(() => {

        const studentId = 1;

        api.get(`/applications/student/${studentId}`)
            .then((res) => {
                setApplications(res.data);
            })
            .catch((err) => console.log(err));

    }, []);

    return (

        <div className="container mt-5">

            <h2 className="mb-4">
                My Applications
            </h2>

            <table className="table table-bordered table-striped">

                <thead className="table-dark">

                    <tr>
                        <th>Company</th>
                        <th>Job</th>
                        <th>Status</th>
                        <th>Applied Date</th>
                    </tr>

                </thead>

                <tbody>

                    {applications.map(app => (

                        <tr key={app.id}>

                            <td>{app.job.company.companyName}</td>

                            <td>{app.job.jobTitle}</td>

                            <td>

                                <span className="badge bg-success">
                                    {app.status}
                                </span>

                            </td>

                            <td>{app.appliedDate}</td>

                        </tr>

                    ))}

                </tbody>

            </table>

        </div>

    );
}

export default MyApplications;