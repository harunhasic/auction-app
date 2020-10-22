import React, { Component } from 'react';
import EmailField from '../core/EmailInput'
import { withRouter } from 'react-router-dom'
import '../../styles/login/Login.scss';
import AuthService from '../../services/auth-service';
import UserService from '../../services/user-service';
import Form from 'react-validation/build/form';
import CheckButton from 'react-validation/build/button';
import PasswordField from '../core/PasswordField';
import { saveUser } from '../../utils/LocalStorageUtils';


class Login extends Component {

  constructor(props) {
    super(props);
    this.state = {
      email: '',
      password: '',
      loading: false,
      message: ''
    };

    this.authService = new AuthService();
    this.userService = new UserService();

    this.handleLogin = this.handleLogin.bind(this);
    this.onChangeEmail = this.onChangeEmail.bind(this);
    this.onChangePassword = this.onChangePassword.bind(this);
  }

  onChangeEmail(e) {
    this.setState({
      email: e.target.value
    });
  }

  toProfile() {
    this.props.history.push('/profile');
  }

  onChangePassword(e) {
    this.setState({
      password: e.target.value
    });
  }

  handleLogin(e) {
    e.preventDefault();

    this.setState({
      message: '',
      loading: true
    });
    this.form.validateAll();

    if (!this.checkBtn.context._errors.length) {
      const user = {
        email: this.state.email,
        password: this.state.password
      };
      this.authService.login(user).then(() => {
        this.toProfile();
        this.userService.getByMail(user.email).then(response => {
          saveUser(response.data);
          window.location.reload();
        });
      }).catch(error => {
        this.setState({
          loading: false,
          message: 'The email and password you entered did not match our records. Please double-check and try again'
        });
      });
    } else {
      this.setState({
        loading: false
      });
    }
  }

  render() {
    const { match, location, history } = this.props;
    return (
      <div className="login-container">
        <div className="login-title">
          LOGIN
            </div>
        <Form className="login-form"
          onSubmit={this.handleLogin}
          ref={ref => {
            this.form = ref;
          }}
        >
          <div className="form-group">
            <EmailField
              id="email"
              name="email"
              label="Enter Email"
              className="form-control"
              type="text"
              onChange={this.onChangeEmail}
            />
          </div>

          <div className="form-group">
            <PasswordField
              id="password"
              name="password"
              label="Enter password"
              className="form-control"
              type={"password"}
              onChange={this.onChangePassword}
            />
          </div>
          <small>
            <label className="error">{this.state.message}</label>
          </small>
          <div className="form-group">
            <button
              className="button"
              disabled={this.state.loading}>
              {this.state.loading && (
                <span className="spinner-border spinner-border-sm"></span>
              )}
              LOGIN
            </button>
          </div>
          <CheckButton
            className="btn-display"
            ref={ref => {
              this.checkBtn = ref;
            }}
          />
        </Form>
      </div>
    )
  }
}
export default withRouter(Login);