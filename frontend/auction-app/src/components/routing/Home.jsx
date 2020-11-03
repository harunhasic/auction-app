import React, { Component } from 'react';
import UserService from '../../services/user-service';

export default class Home extends Component {
  constructor(props) {
    super(props);

    this.state = {
      content: []
    };

    this.userService = new UserService();
  }

  componentDidMount() {
    this.userService.getPublicContent().then(
      response => {
        console.log(response.data);
        this.setState({
          content: response.data
        });
      },
      error => {
        this.setState({
          content: error.toString()
        });
      }
    );
  }

  render() {
    return (
      <div className="container">
        <header className="jumbotron">
          <h3>{
            this.state.content.map(user => (
              <div>
                {
                  user.email
                }
              </div>
            ))
          }
          </h3>
        </header>
      </div>
    );
  }
}
