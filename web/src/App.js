import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import ObszarList from "./obszar/ObszarList";
import EditSerwisant from "./serwisant/EditSerwisant";
import AddDzialanie from "./dzialanie/AddDzialanie";
import DzialanieList from "./dzialanie/DzialanieList";
import Navbar from "./nav/Navbar";

function App() {
    return (
        <BrowserRouter>
            <Navbar />  {}
            <div className="container mt-4">
                <Routes>
                    <Route path="/" element={<ObszarList />} />
                    <Route path="/edit-serwisant/:obszarId" element={<EditSerwisant />} />
                    <Route path="/add-dzialanie/:obszarId" element={<AddDzialanie />} />
                    <Route path="/dzialania-list" element={<DzialanieList />} /> {}
                </Routes>
            </div>
        </BrowserRouter>
    );
}

export default App;
