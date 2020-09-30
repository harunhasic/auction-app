import React from 'react';
import '../../styles/core/input.scss';
import Input from 'react-validation/build/input';

const vpassword = value => {
    if (value.length < 4 || value.length > 40) {
      return (
        <div className="error-msg" role="alert">
          The password must be between 4 and 40 characters.
        </div>
      );
    }
  };
  const PasswordField = ({ label, ...props }) => {
    return (
        <div className={"base-field"}>
            <label>{label}</label>
            <Input {...props} validations={[vpassword]}/>
        </div>
    );

}
export default PasswordField;