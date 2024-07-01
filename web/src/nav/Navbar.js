import React from 'react';
import {Link} from 'react-router-dom';
import axios from 'axios';
import AppConstants from "../util/AppConstans";

function Navbar() {
    const handleSendEmails = () => {
        axios.post(`${AppConstants.ADDRESS_SERVER_LOCAL}/api/serwisanci/wyslij-dzialania`)
            .then(() => {
                alert('Emails sent successfully!');
            })
            .catch(error => {
                console.error('Error sending emails', error);
                alert('Failed to send emails: ' + (error.response?.data?.message || error.message));
            });
    };

    return (
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
            <div className="container-fluid">
                <div className="collapse navbar-collapse" id="navbarNav">
                    <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                        <li className="nav-item">
                            <Link className="nav-link" to="/">Obszary</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="/dzialania-list">Działania</Link>
                        </li>
                        <li className="nav-item">
                            <button className="btn btn-link nav-link" onClick={handleSendEmails}>Wyślij działania do
                                serwisantów
                            </button>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    );
}

export default Navbar;

