import React, { Component } from 'react';
import AuthService from '../../services/auth-service';

export default class Profile extends Component {
  constructor(props) {
    super(props);
    this.authService = new AuthService();
    this.state = {
      currentUser: this.authService.getCurrentUser()
    };

  
  }

  render() {
    const { currentUser } = this.state;

    return (
      <div className="container">
          
      </div>
    );
  }
}