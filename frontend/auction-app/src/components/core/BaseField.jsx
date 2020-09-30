import React from 'react';
import '../../styles/core/input.scss';


const required = value => {
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
        <div className={"base-field"}>
            <label>{label}</label>
            <input {...props} />
            <small>
                <label className={"error"}>{required}</label>
            </small>

        </div>
    );

}
export default BaseField;