import React from 'react';
import '../../styles/core/input.scss';
import Input from 'react-validation/build/input';

const lastNameCheck = value => {
    if (value.length < 2 || value.length > 30) {
      return (
        <div className="error-msg" role="alert">
          Please enter a valid Last Name.
        </div>
      );
    }
  };

const LastNameField = ({ label, ...props }) => {
    return (
        <div className={"first-field"}>
            <label>{label}</label>
            <Input {...props} validations={[lastNameCheck]}/>
        </div>
    );
}
export default LastNameField;