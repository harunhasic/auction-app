import React from 'react';
import '../../styles/core/input.scss'
import { isEmail } from 'validator'
import Input from 'react-validation/build/input';

const validEmail = value => {
    if (!isEmail(value)) {
      return (
        <div className="error-msg" role="alert">
          This is not a valid email.
        </div>
      );
    }
  };

const EmailField = ({ label, ...props }) => {
    return (
        <div className={"base-field"}>
            <label>{label}</label>
            <Input {...props} validations={[validEmail]}/>
        </div>
    );
}
export default EmailField;
