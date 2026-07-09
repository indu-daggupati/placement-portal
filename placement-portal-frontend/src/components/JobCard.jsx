function JobCard({ job, onApply }) {

    return (

        <div className="card shadow-lg h-100">

            <div className="card-body">

                <h4>{job.jobTitle}</h4>

                <h6 className="text-primary">
                    {job.company.companyName}
                </h6>

                <p>📍 {job.location}</p>

                <p>💰 {job.salary} LPA</p>

                <p>📅 {job.lastDate}</p>

                <button
                    className="btn btn-success w-100"
                    onClick={() => onApply(job.id)}
                >
                    Apply Now
                </button>

            </div>

        </div>

    );

}

export default JobCard;