import React, {useEffect, useState} from 'react';
import axios from 'axios';
import {useParams, useNavigate} from 'react-router-dom';
import AppConstants from "../util/AppConstans";

function AddDzialanie() {
    const {obszarId} = useParams();
    const [dzialanie, setDzialanie] = useState({opisDzialania: '', planowanyCzas: ''});
    const [serwisantId, setSerwisantId] = useState(null);
    const [serwisanci, setSerwisanci] = useState([]);
    const [obszar, setObszar] = useState(null);
    const [dzialania, setDzialania] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        axios.get(`${AppConstants.ADDRESS_SERVER_LOCAL}/api/obszary/${obszarId}`)
            .then(response => {
                setObszar(response.data);
                setDzialania(response.data.dzialania);
            })
            .catch(error => console.error('Error fetching obszar details', error));

        axios.get(`${AppConstants.ADDRESS_SERVER_LOCAL}/api/serwisanci`)
            .then(response => {
                setSerwisanci(response.data);
            })
            .catch(error => console.error('Error fetching serwisanci', error));
    }, [obszarId]);

    const handleSubmit = (event) => {
        event.preventDefault();

        const apiUrl = `${AppConstants.ADDRESS_SERVER_LOCAL}/api/dzialania/add/${obszarId}/${serwisantId}`;

        axios.post(apiUrl, dzialanie)
            .then(response => {
                setDzialania([...dzialania, response.data]);
                setDzialanie({opisDzialania: '', planowanyCzas: ''});
                setSerwisantId('');
            })
            .catch(error => {
                console.error('Error adding działanie', error);
                alert('Failed to add działanie: ' + (error.response?.data?.message || error.message));
            });
    };

    return (
        <div className="container mt-3">
            <h1>Dodaj działanie do obszaru</h1>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="opisDzialania" className="form-label">Opis</label>
                    <input
                        type="text"
                        className="form-control"
                        id="opisDzialania"
                        value={dzialanie.opisDzialania}
                        onChange={e => setDzialanie({...dzialanie, opisDzialania: e.target.value})}
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="planowanyCzas" className="form-label">Planowany czas</label>
                    <input
                        type="number"
                        className="form-control"
                        id="planowanyCzas"
                        value={dzialanie.planowanyCzas}
                        onChange={e => setDzialanie({...dzialanie, planowanyCzas: e.target.value})}
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="serwisantId" className="form-label">Serwisant</label>
                    <select
                        className="form-control"
                        id="serwisantId"
                        value={serwisantId}
                        onChange={e => setSerwisantId(e.target.selectedIndex)}
                    >
                        <option value="">Wybierz serwisanta</option>
                        {serwisanci.map(serwisant => (
                            <option key={serwisant.id} value={serwisant.id}>
                                {serwisant.nazwisko}
                            </option>
                        ))}
                    </select>
                </div>
                <button type="submit" className="btn btn-primary">Dodaj</button>
            </form>
            {obszar && (
                <div>
                    <h3>Szczegóły obszaru</h3>
                    <p>Nazwa: {obszar.nazwa}</p>
                    <p>Status: {obszar.aktywny ? 'Aktywny' : 'Nieaktywny'}</p>
                </div>
            )}
            <div>
                <h3>Lista działań</h3>
                <ul>
                    {dzialania.map(d => (
                        <li key={d.dzialanieId}>
                            {d.opisDzialania} - {d.planowanyCzas} godzin
                        </li>
                    ))}
                </ul>
            </div>
        </div>
    );
}

export default AddDzialanie;
