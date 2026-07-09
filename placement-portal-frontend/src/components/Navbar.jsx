import { Link } from "react-router-dom";

function Navbar() {

  return (

    <nav className="navbar navbar-expand-lg navbar-dark bg-primary">

      <div className="container">

        <Link className="navbar-brand fw-bold" to="/">
          Placement Portal
        </Link>

        <button
          className="navbar-toggler"
          data-bs-toggle="collapse"
          data-bs-target="#nav"
        >
          <span className="navbar-toggler-icon"></span>
        </button>

        <div className="collapse navbar-collapse" id="nav">

          <ul className="navbar-nav ms-auto">

            <li className="nav-item">
              <Link className="nav-link" to="/">Home</Link>
            </li>

            <li className="nav-item">
              <Link className="nav-link" to="/companies">Companies</Link>
            </li>

            <li className="nav-item">
              <Link className="nav-link" to="/jobs">Jobs</Link>
            </li>

            <li className="nav-item">
              <Link className="nav-link" to="/login">Login</Link>
            </li>

            <li className="nav-item">
              <Link
                className="btn btn-light ms-3"
                to="/register"
              >
                Register
              </Link>
            </li>
            <li className="nav-item">
                <Link className="nav-link" to="/applications">
                    My Applications
                </Link>
            </li>

          </ul>

        </div>

      </div>

    </nav>

  );
}

export default Navbar;