import React from 'react';
import '../../styles/core/input.scss';
import Input from 'react-validation/build/input';

function NameCheck(value) {
  if (value.length < 2 || value.length > 30) {
    return (
      <div className="error-msg" role="alert">
        Please enter a valid name.
      </div>
    );
  }
};


const NameField = ({ label, validation, ...props }) => {
  return (
    <div className={"props"}>
      <label>{label}</label>
      <Input {...props} validations={[NameCheck]} />
    </div>
  );
}
export default NameField;