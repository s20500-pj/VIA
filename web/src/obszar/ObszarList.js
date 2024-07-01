import React, {useEffect, useState} from 'react';
import axios from 'axios';
import {Link} from 'react-router-dom';
import AppConstants from "../util/AppConstans";

function ObszarList() {
    const [obszars, setObszars] = useState([]);

    useEffect(() => {
        axios.get(`${AppConstants.ADDRESS_SERVER_LOCAL}/api/obszary`)
            .then(response => setObszars(response.data))
            .catch(error => console.error('Error fetching obszars', error));
    }, []);

    return (
        <div className="container mt-3">
            <h1 className="mb-3">Lista obszarów z przypisanymi serwisantami</h1>
            <ul className="list-group">
                {obszars.map(obszar => (
                    <li key={obszar.obszarId} className="list-group-item">
                        <div className="d-flex justify-content-between align-items-center w-100">
                            <span className="flex-grow-1">
                                {obszar.obszarNazwa} - {obszar.serwisantNazwisko || 'Brak przypisanego serwisanta'}
                            </span>
                            <span className={`badge ${obszar.obszarAktywny ? 'bg-success' : 'bg-secondary'} ms-2`}>
                                {obszar.obszarAktywny ? 'aktywny' : 'nieaktywny'}
                            </span>
                            <div>
                                <Link to={`/edit-serwisant/${obszar.obszarId}`} className="btn btn-primary btn-sm ms-2">Edytuj
                                    Serwisanta</Link>
                                <Link to={`/add-dzialanie/${obszar.obszarId}`}
                                      className="btn btn-secondary btn-sm ms-2">Dodaj Działanie</Link>
                            </div>
                        </div>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default ObszarList;
