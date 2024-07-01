import React, {useEffect, useState} from 'react';
import axios from 'axios';
import AppConstants from "../util/AppConstans";

function DzialanieList() {
    const [dzialania, setDzialania] = useState([]);

    useEffect(() => {
        axios.get(`${AppConstants.ADDRESS_SERVER_LOCAL}/api/serwisanci/dzialania`)
            .then(response => {
                setDzialania(response.data);
            })
            .catch(error => console.error('Error fetching actions for serwisant', error));
    }, []);

    return (
        <div className="container mt-3">
            <h2>Zaplanowane działania dla serwisantów</h2>
            <table className="table table-striped">
                <thead>
                <tr>
                    <th>Opis działania</th>
                    <th>Planowany czas</th>
                    <th>Serwisant</th>
                    <th>Obszar</th>
                </tr>
                </thead>
                <tbody>
                {dzialania.map(item => (
                    <tr key={item.dzialanieId}>
                        <td>{item.opisDzialania}</td>
                        <td>{item.planowanyCzas} godzin</td>
                        <td>{item.nazwisko}</td>
                        <td>{item.obszarNazwa}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}

export default DzialanieList;
