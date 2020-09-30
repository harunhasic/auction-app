import React, { Component } from 'react';
import AuthService from '../../Services/auth-service';

export default class Profile extends Component {
  constructor(props) {
    super(props);

    this.state = {
      currentUser: this.authService.getCurrentUser()
    };

    this.authService = new AuthService();
  }

  render() {
    const { currentUser } = this.state;

    return (
      <div className="container">
          
      </div>
    );
  }
}