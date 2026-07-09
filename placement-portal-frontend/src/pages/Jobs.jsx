import { useEffect, useState } from "react";
import Navbar from "../components/Navbar";
import Footer from "../components/Footer";
import JobCard from "../components/JobCard";
import api from "../services/api";

function Jobs() {
  const [jobs, setJobs] = useState([]);
  const [search, setSearch] = useState("");

  useEffect(() => {
    loadJobs();
  }, []);

  const loadJobs = async () => {
    try {
      const response = await api.get("/jobs/all");
      setJobs(response.data);
    } catch (error) {
      console.error("Error fetching jobs:", error);
      alert("Unable to load jobs.");
    }
  };

  const applyJob = async (jobId) => {
    // For now, using a fixed student ID.
    // Later, replace this with:
    // const studentId = localStorage.getItem("studentId");
    const studentId = 1;

    try {
      await api.post(`/applications/apply/${studentId}/${jobId}`);
      alert("Application Submitted Successfully!");
    } catch (error) {
      console.error(error);
      alert("Failed to apply for the job.");
    }
  };

  const filteredJobs = jobs.filter((job) =>
    job.jobTitle.toLowerCase().includes(search.toLowerCase())
  );

  return (
    <>
      <Navbar />

      <div className="container mt-5">

        <h2 className="text-center mb-4">Available Jobs</h2>

        <div className="row justify-content-center mb-4">
          <div className="col-md-6">
            <input
              type="text"
              className="form-control"
              placeholder="Search by Job Title..."
              value={search}
              onChange={(e) => setSearch(e.target.value)}
            />
          </div>
        </div>

        <div className="row">
          {filteredJobs.length > 0 ? (
            filteredJobs.map((job) => (
              <div className="col-md-4 mb-4" key={job.id}>
                <JobCard
                  job={job}
                  onApply={applyJob}
                />
              </div>
            ))
          ) : (
            <div className="text-center">
              <h5>No Jobs Found</h5>
            </div>
          )}
        </div>

      </div>

      <Footer />
    </>
  );
}

export default Jobs;