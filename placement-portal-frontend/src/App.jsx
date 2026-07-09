import { BrowserRouter, Routes, Route } from "react-router-dom";

import Home from "./pages/Home";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Companies from "./pages/Companies";
import Jobs from "./pages/Jobs";
import Dashboard from "./pages/Dashboard";
import MyApplications from "./pages/MyApplications";


function App() {
  return (
    <BrowserRouter>
      <Routes>

        <Route path="/" element={<Home />} />

        <Route path="/login" element={<Login />} />

        <Route path="/register" element={<Register />} />

        <Route path="/companies" element={<Companies />} />

        <Route path="/jobs" element={<Jobs />} />

        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="/applied" element={<MyApplications />} />
        <Route path="/applications" element={<MyApplications />} />

      </Routes>
    </BrowserRouter>
  );
}

export default App;