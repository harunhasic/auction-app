import React from 'react';
import '../../styles/core/input.scss';


function required(value) {
    if (!value) {
        return (
            <div className="alert alert-danger" role="alert">
                All fields need to be filled.
            </div>
        );
    }
}

const BaseField = ({ label, ...props }) => {
    return (
        <div className="...props">
            <label>{label}</label>
            <input {...props} />
        </div>
    );

}
export default BaseField;