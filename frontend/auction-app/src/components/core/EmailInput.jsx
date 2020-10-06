import React from 'react';
import '../../styles/core/input.scss'
import { isEmail } from 'validator'
import Input from 'react-validation/build/input';

function validEmail(value) {
  if (!isEmail(value)) {
    return (
      <div className="error-msg" role="alert">
        Please enter a valid email.
      </div>
    );
  }
};

const EmailField = ({ label, ...props }) => {
  return (
    <div className="...props">
      <label>{label}</label>
      <Input {...props} validations={[validEmail]} />
    </div>
  );
}
export default EmailField;
