import React, { Component } from 'react';
import EmailField from '../core/EmailInput'
import { withRouter } from 'react-router-dom'
import '../../styles/login/Login.scss';
import AuthService from '../../Services/auth-service';
import Form from 'react-validation/build/form';
import CheckButton from 'react-validation/build/button';
import PasswordField from '../core/PasswordField';



class Login extends Component {

  constructor(props) {
    super(props);
    this.state = {
      username: '',
      password: '',
      loading: false,
      message: ''
    };

    this.authService = new AuthService();

    this.handleLogin = this.handleLogin.bind(this);
    this.onChangeUsername = this.onChangeUsername.bind(this);
    this.onChangePassword = this.onChangePassword.bind(this);
  }

  onChangeUsername(e) {
    this.setState({
      username: e.target.value
    });
  }
  toProfile() {
    this.props.history.push('/home');
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
        email: this.state.username,
        password: this.state.password
      };
      this.authService.login(user).then(() => {
        this.toProfile();
        window.location.reload();
      },
        error => {
          this.setState({
            loading: false,
            message: error.toString()
          });
        }

      );
    } else {
      this.setState({
        loading: false
      });
    }
  };
  render() {
    const { match, location, history } = this.props;
    return (

      <div className="login-container">
        <div className="login-title">
          LOGIN
            </div>
        <Form className="login-form"
          initialValues={{ email: rememberInfo.email || "", password: rememberInfo.password || "", remember: rememberInfo.email !== null }}
          onSubmit={this.handleLogin}
          ref={c => {
            this.form = c;
          }}
        >
          <div className="form-group">
            <EmailField id={"email"} name={"email"} label={"Enter Email"} className={"input-field"} type={"text"} onChange={this.onChangeUsername} />
          </div>
          <small>
            <label className={"error"}>{this.state.message}</label>
          </small>
          <div className="form-group">
            <PasswordField id={"password"} name={"password"} label={"Enter Password"} className={"input-field"} type={"password"} onChange={this.onChangePassword} />
          </div>
          <small>
            <label className={"error"}>{this.state.message}</label>
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
            style={{ display: "none" }}
            ref={c => {
              this.checkBtn = c;
            }}
          />
        </Form>
      </div>

    )

  }
}
export default withRouter(Login);