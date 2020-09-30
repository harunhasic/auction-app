import React from 'react';
import '../../styles/core/input.scss';
import Input from 'react-validation/build/input';

const firstNameCheck = value => {
    if (value.length < 2 || value.length > 30) {
      return (
        <div className="error-msg" role="alert">
          Please enter a valid First Name.
        </div>
      );
    }
  };


const FirstNameField = ({ label, validation, ...props }) => {
    return (
        <div className={"first-field"}>
            <label>{label}</label>
            <Input {...props} validations={[firstNameCheck]}/>
        </div>
    );
}
export default FirstNameField;