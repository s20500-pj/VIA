import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import AppConstants from "../util/AppConstans";

function EditSerwisant() {
    const { obszarId } = useParams();
    const [obszar, setObszar] = useState({});
    const [serwisant, setSerwisant] = useState({});
    const [updateSuccess, setUpdateSuccess] = useState(false);

    useEffect(() => {
        fetchDetails();
    }, [obszarId]);

    const fetchDetails = () => {
        axios.get(`${AppConstants.ADDRESS_SERVER_LOCAL}/api/obszary/${obszarId}`)
            .then(response => {
                setObszar(response.data);
                setSerwisant(response.data.serwisant);
                setUpdateSuccess(false);
            })
            .catch(error => console.error('Error fetching details', error));
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        axios.put(`${AppConstants.ADDRESS_SERVER_LOCAL}/api/obszary/${obszarId}/update-serwisant`, serwisant)
            .then(() => {
                fetchDetails();
                setUpdateSuccess(true);
                setSerwisant({});
            })
            .catch(error => {
                console.error('Error updating serwisant', error);
                setUpdateSuccess(false);
            });
    };

    return (
        <div className="container mt-3">
            <h1>Edytuj serwisanta</h1>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="serwisantName" className="form-label">Nazwisko</label>
                    <input
                        type="text"
                        className="form-control"
                        id="serwisantName"
                        value={serwisant.nazwisko || ''}
                        onChange={e => setSerwisant({...serwisant, nazwisko: e.target.value})}
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="serwisantEmail" className="form-label">Email</label>
                    <input
                        type="email"
                        className="form-control"
                        id="serwisantEmail"
                        value={serwisant.email || ''}
                        onChange={e => setSerwisant({...serwisant, email: e.target.value})}
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="serwisantActive" className="form-label">Aktywny?</label>
                    <input
                        type="checkbox"
                        className="form-check-input ms-2"
                        id="serwisantActive"
                        checked={serwisant.aktywny || false}
                        onChange={e => setSerwisant({...serwisant, aktywny: e.target.checked})}
                    />
                </div>
                <button type="submit" className="btn btn-primary">Zaktualizuj</button>
            </form>
            {updateSuccess && <p className="text-success">Update successful!</p>}
            <div>
                {serwisant && (
                    <div>
                        <h3>Serwisant</h3>
                        <p>Nazwisko: {serwisant.nazwisko}</p>
                        <p>Email: {serwisant.email}</p>
                        <p>Status: {serwisant.aktywny ? 'Aktywny' : 'Nieaktywny'}</p>
                    </div>
                )}
            </div>
            <div>
                {obszar && (
                    <div>
                        <h3>Obszar</h3>
                        <p>Nazwa: {obszar.nazwa}</p>
                        <p>Status: {obszar.aktywny ? 'Aktywny' : 'Nieaktywny'}</p>
                    </div>
                )}
            </div>
        </div>
    );
}

export default EditSerwisant;
