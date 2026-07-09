import Navbar from "../components/Navbar";
import Footer from "../components/Footer";

function Home() {
  return (
    <>
      <Navbar />

      <div className="container mt-5">

        <div className="row align-items-center">

          <div className="col-md-6">
            <h1 className="display-4 fw-bold">
              Find Your Dream Job
            </h1>

            <p className="lead mt-3">
              Placement Portal helps students connect with top companies
              and apply for jobs effortlessly.
            </p>

            <a href="/jobs" className="btn btn-primary btn-lg me-3">
              Browse Jobs
            </a>

            <a href="/register" className="btn btn-outline-primary btn-lg">
              Register
            </a>
          </div>

          <div className="col-md-6 text-center">
            <img
              src="https://images.unsplash.com/photo-1521791136064-7986c2920216?w=800"
              className="img-fluid rounded shadow"
              alt="Placement"
            />
          </div>

        </div>

      </div>

      <Footer />
    </>
  );
}

export default Home;