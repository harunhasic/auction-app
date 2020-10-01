import React, { Component } from 'react';
import '../../styles/register/Register.scss'
import AuthService from '../../Services/auth-service'
import Form from 'react-validation/build/form';
import CheckButton from 'react-validation/build/button';
import EmailField from '../core/EmailInput';
import { Link } from 'react-router-dom';
import PasswordField from '../core/PasswordField';
import FirstNameField from '../core/NameField';
import LastNameField from '../core/LastNameField';

export default class Register extends Component {

  constructor(props) {
    super(props);
    this.handleRegister = this.handleRegister.bind(this);
    this.onChangeFirstname = this.onChangeFirstName.bind(this);
    this.onChangeLastName = this.onChangeLastName.bind(this);
    this.onChangeEmail = this.onChangeEmail.bind(this);
    this.onChangePassword = this.onChangePassword.bind(this);
    this.isRequired = this.isRequired.bind(this);

    this.authService = new AuthService();

    this.state = {
      firstName: '',
      lastName: '',
      email: '',
      password: '',
      successful: false,
      message: ''
    };
  }

  isRequired(value) {
    if (!value) {
      return (
        <div className="alert alert-danger" role="alert">
          This field is required!
        </div>
      );
    }
  }
  setErrorMessage(errorMessage) {
    errorMessage = "Invalid information"
  }
  onChangeFirstName(e) {
    this.setState({
      firstName: e.target.value
    });
  }

  onChangeLastName(e) {
    this.setState({
      lastName: e.target.value
    });
  }

  onChangeEmail(e) {
    this.setState({
      email: e.target.value
    });
  }

  onChangePassword(e) {
    this.setState({
      password: e.target.value
    });
  }

  handleRegister(e) {
    e.preventDefault();

    this.setState({
      message: null,
      successful: false
    });
    const params = {
      firstName: this.state.firstName,
      lastName: this.state.lastName,
      email: this.state.email,
      password: this.state.password
    }
    if (!this.checkBtn.context._errors.length) {
      this.authService.register(
        params
      ).then(
        response => {
          this.setState({
            message: response.data.message,
            successful: true
          });
        },
        error => {
          this.setState({
            successful: false,
            message: error.toString()
          });
        }
      );
    };
  }

  render() {
    return (

      <div className="register-container">
        <div className="register-title">
          REGISTER
  </div>
        <Form className='register-form'
          onSubmit={this.handleRegister}
          ref={c => {
            this.form = c;
          }}
        >
          {!this.state.successful && (
            <div>
              <div className="form-group">
                <FirstNameField
                  id={"firstName"}
                  name={"firstName"}
                  type={"text"}
                  label={"First Name"}
                  className={"input-field"}
                  value={this.state.firstName}
                  onChange={(e) => this.onChangeFirstName(e)}
                />

                <div className="form-group">
                  <LastNameField
                    id={"lastName"}
                    name={"lastName"}
                    type={"text"}
                    label={"Last Name"}
                    className={"input-field"}
                    value={this.state.lastName}
                    onChange={(e) => this.onChangeLastName(e)}
                  />

                </div>
                <div className="form-group">
                  <EmailField
                    id={"email"}
                    name={"email"}
                    type={"email"}
                    label={"Email"}
                    className={"input-field"}
                    value={this.state.email}
                    onChange={(e) => this.onChangeEmail(e)}
                  />
                </div>
                <div className="form-group">
                  <PasswordField
                    id={"password"}
                    name={"password"}
                    type={"password"}
                    label={"Password"}
                    className={"input-field"}
                    value={this.state.password}
                    onChange={(e) => this.onChangePassword(e)}
                    validation={this.isRequired}
                  />
                </div>
                <div className="form-group">
                  <button className="btn-register btn">REGISTER</button>
                </div>
              </div>
            </div>
          )}
          {this.state.message && (
            <div className="form-group">
              <div
                className={
                  this.state.successful
                    ? "alert alert-success"
                    : "alert alert-danger"
                }
                role="alert"
              >
                {this.state.message}
              </div>
            </div>
          )}
          <CheckButton
            style={{ display: "none" }}
            ref={c => {
              this.checkBtn = c;
            }}
          />
          <div className="already-registered">
            Already have an account?
              <Link className="purple-nav-link nav-link" to="/login">
              Login
              </Link>
          </div>
        </Form>
      </div>

    )
  }
}
